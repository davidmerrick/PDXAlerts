/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.merricklabs.pdxalerts.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.requestType
import com.merricklabs.pdxalerts.PdxAlertsConfig
import com.merricklabs.pdxalerts.external.twitter.TwitterClient
import mu.KotlinLogging
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.Optional

private val log = KotlinLogging.logger {}

class LaunchRequestHandler : RequestHandler, KoinComponent {

    private val config by inject<PdxAlertsConfig>()
    private val twitterClient by inject<TwitterClient>()

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(requestType(LaunchRequest::class.java))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val invocationName = config.alexa.invocationName

        log.info { "Fetching latest Tweet from ${config.twitter.twitterHandle}" }
        val latest = twitterClient.getLatestTweets()
        if (latest.isEmpty()) {
            return noTweetsResponse(input)
        }

        val speechText = """
                Latest alert:
                ${latest[0].text}
        """
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard(invocationName, speechText)
                .build()
    }

    fun noTweetsResponse(input: HandlerInput): Optional<Response> {
        val invocationName = config.alexa.invocationName
        val speechText = """
                Sorry, no recent alerts were found.
        """
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard(invocationName, speechText)
                .build()
    }
}

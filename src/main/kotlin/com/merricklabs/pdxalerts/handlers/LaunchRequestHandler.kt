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
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.Optional

class LaunchRequestHandler : RequestHandler, KoinComponent {

    private val config by inject<PdxAlertsConfig>()

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(requestType(LaunchRequest::class.java))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val repromptText = "Which stop would you like information about?"
        val INVOCATION_NAME = config.alexa.invocationName
        val speechText = StringBuilder()
                .append("Welcome to $INVOCATION_NAME. ")
                .append("I can retrieve arrival times for bus stops in Portland, Oregon. ")
                .append(repromptText)
                .toString()
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard(INVOCATION_NAME, speechText)
                .withReprompt(repromptText)
                .build()
    }

}

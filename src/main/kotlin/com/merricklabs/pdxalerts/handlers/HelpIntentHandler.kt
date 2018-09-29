package com.merricklabs.pdxalerts.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import com.merricklabs.pdxalerts.PdxAlertsConfig
import com.merricklabs.pdxalerts.constants.Intents.HELP_INTENT
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.Optional

class HelpIntentHandler : RequestHandler, KoinComponent {

    private val config by inject<PdxAlertsConfig>()

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(intentName(HELP_INTENT))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val invocationName = config.alexa.invocationName
        val speechText = """
            Welcome to $invocationName.
            For the latest Portland alerts, simply open this skill.
            """
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard(invocationName, speechText)
                .build()
    }
}

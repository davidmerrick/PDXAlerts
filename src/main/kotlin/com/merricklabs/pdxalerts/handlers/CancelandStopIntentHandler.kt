package com.merricklabs.pdxalerts.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import com.merricklabs.pdxalerts.PdxAlertsConfig
import com.merricklabs.pdxalerts.constants.Intents.CANCEL_INTENT
import com.merricklabs.pdxalerts.constants.Intents.STOP_INTENT
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.Optional

class CancelandStopIntentHandler : RequestHandler, KoinComponent {

    private val config by inject<PdxAlertsConfig>()

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(intentName(CANCEL_INTENT).or(intentName(STOP_INTENT)))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val speechText = "Goodbye"
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard(config.alexa.invocationName, speechText)
                .build()
    }
}

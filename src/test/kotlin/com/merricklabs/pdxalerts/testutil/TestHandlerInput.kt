package com.merricklabs.pdxalerts.testutil

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Intent
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.RequestEnvelope
import com.amazon.ask.model.Session
import com.amazon.ask.model.Slot
import com.amazon.ask.model.User

/**
 * Helper class for building intent inputs
 */
data class TestHandlerInput(val slots: Map<String, Slot>?, val userId: String, val intentName: String) {

    val handlerInput: HandlerInput
        get() {
            val intent = Intent.builder()
                    .withName(intentName)
                    .withSlots(slots)
                    .build()

            val intentRequest = IntentRequest.builder()
                    .withIntent(intent)
                    .build()

            val user = User.builder()
                    .withUserId(userId)
                    .build()

            val session = Session.builder()
                    .withUser(user)
                    .build()

            val requestEnvelope = RequestEnvelope.builder()
                    .withVersion("1.0")
                    .withRequest(intentRequest)
                    .withSession(session)
                    .build()

            return HandlerInput.builder()
                    .withRequestEnvelope(requestEnvelope)
                    .build()
        }

    class Builder {
        private var slots: Map<String, Slot>? = null
        private var userId: String = ""
        private var intentName: String = ""

        fun slots(slots: Map<String, Slot>) = apply { this.slots = slots }
        fun userId(userId: String) = apply { this.userId = userId }
        fun intentName(intentName: String) = apply { this.intentName = intentName }

        fun build() = TestHandlerInput(slots, userId, intentName)
    }
}
package com.merricklabs.pdxalerts.testutil

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.RequestEnvelope
import com.amazon.ask.model.Session
import com.amazon.ask.model.User

/**
 * Helper class for building intent inputs
 */
data class LaunchHandlerInput(val userId: String) {

    val handlerInput: HandlerInput
        get() {
            val request = LaunchRequest.builder()
                    .build()

            val user = User.builder()
                    .withUserId(userId)
                    .build()

            val session = Session.builder()
                    .withUser(user)
                    .build()

            val requestEnvelope = RequestEnvelope.builder()
                    .withVersion("1.0")
                    .withRequest(request)
                    .withSession(session)
                    .build()

            return HandlerInput.builder()
                    .withRequestEnvelope(requestEnvelope)
                    .build()
        }

    class Builder {
        private var userId: String = ""

        fun userId(userId: String) = apply { this.userId = userId }

        fun build() = LaunchHandlerInput(userId)
    }
}
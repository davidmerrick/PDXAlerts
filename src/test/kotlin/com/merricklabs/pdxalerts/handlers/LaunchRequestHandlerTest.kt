package com.merricklabs.pdxalerts.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.merricklabs.pdxalerts.PdxAlertsIntegrationTestBase
import com.merricklabs.pdxalerts.mocks.MockStatus
import com.merricklabs.pdxalerts.testutil.LaunchHandlerInput
import com.merricklabs.pdxalerts.testutil.TestConstants.INTEGRATION_GROUP
import org.koin.standalone.inject
import org.mockito.Mockito
import org.testng.Assert
import org.testng.annotations.Test

class LaunchRequestHandlerTest : PdxAlertsIntegrationTestBase() {

    private val launchRequestHandler: LaunchRequestHandler by inject()

    @Test(groups = [INTEGRATION_GROUP])
    fun `launch skill`() {
        // Init mocks
        val statusText = "hello world"
        var status = MockStatus()
        status.text = statusText
        Mockito.`when`(twitterClient.getLatestTweet()).thenReturn(status)

        val input = getValidInput()
        val responseOptional = launchRequestHandler.handle(input)
        Assert.assertTrue(responseOptional.isPresent)

        val speechText = responseOptional.get().getOutputSpeech().toString()
        Assert.assertTrue(speechText.contains(statusText))
    }

    private fun getValidInput(): HandlerInput {
        return LaunchHandlerInput.Builder()
                .build()
                .handlerInput
    }
}
package com.merricklabs.pdxalerts

import com.merricklabs.pdxalerts.external.twitter.TwitterClient
import com.merricklabs.pdxalerts.external.twitter.TwitterClientImpl
import com.merricklabs.pdxalerts.handlers.CancelandStopIntentHandler
import com.merricklabs.pdxalerts.handlers.FallbackIntentHandler
import com.merricklabs.pdxalerts.handlers.HelpIntentHandler
import com.merricklabs.pdxalerts.handlers.LaunchRequestHandler
import com.merricklabs.pdxalerts.handlers.SessionEndedRequestHandler
import org.koin.dsl.module.module

val PdxAlertsModule = module {
    single { PdxAlertsConfig() }
    single { TwitterClientImpl() as TwitterClient }

    single { LaunchRequestHandler() }
    single { CancelandStopIntentHandler() }
    single { FallbackIntentHandler() }
    single { HelpIntentHandler() }
    single { SessionEndedRequestHandler() }
}
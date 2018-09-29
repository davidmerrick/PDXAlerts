package com.merricklabs.pdxalerts

import com.merricklabs.pdxalerts.handlers.CancelandStopIntentHandler
import com.merricklabs.pdxalerts.handlers.FallbackIntentHandler
import com.merricklabs.pdxalerts.handlers.HelpIntentHandler
import com.merricklabs.pdxalerts.handlers.LaunchRequestHandler
import org.koin.dsl.module.module

val PdxAlertsModule = module {
    single { PdxAlertsConfig() }

    single { CancelandStopIntentHandler() }
    single { FallbackIntentHandler() }
    single { HelpIntentHandler() }
    single { LaunchRequestHandler() }
}
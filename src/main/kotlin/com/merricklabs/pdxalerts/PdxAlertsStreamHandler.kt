package com.merricklabs.pdxalerts

import com.amazon.ask.Skill
import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.merricklabs.pdxalerts.handlers.CancelandStopIntentHandler
import com.merricklabs.pdxalerts.handlers.FallbackIntentHandler
import com.merricklabs.pdxalerts.handlers.HelpIntentHandler
import com.merricklabs.pdxalerts.handlers.LaunchRequestHandler
import com.merricklabs.pdxalerts.handlers.SessionEndedRequestHandler
import mu.KotlinLogging
import org.koin.standalone.StandAloneContext.startKoin

private val log = KotlinLogging.logger {}

class PdxAlertsStreamHandler : SkillStreamHandler(skill) {

    companion object {
        val skill: Skill
            get() {
                log.info { "Starting skill" }

                startKoin(listOf(PdxAlertsModule))

                return Skills.standard()
                        .addRequestHandlers(
                                LaunchRequestHandler(),
                                CancelandStopIntentHandler(),
                                FallbackIntentHandler(),
                                HelpIntentHandler(),
                                SessionEndedRequestHandler()
                        )
                        .withSkillId(PdxAlertsConfig().alexa.skillId)
                        .build()
            }
    }
}
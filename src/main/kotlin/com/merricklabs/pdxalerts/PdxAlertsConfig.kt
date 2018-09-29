package com.merricklabs.pdxalerts

import org.koin.standalone.KoinComponent

class PdxAlertsConfig : KoinComponent {

    val alexa = Alexa()

    inner class Alexa {
        val skillId: String = System.getenv("SKILL_ID")
        val invocationName: String = if (System.getenv("INVOCATION_NAME") != null)
            System.getenv("INVOCATION_NAME")
        else
            "PDX Alerts"
    }
}

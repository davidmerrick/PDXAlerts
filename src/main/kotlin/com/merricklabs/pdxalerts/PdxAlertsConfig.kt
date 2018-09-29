package com.merricklabs.pdxalerts

import org.koin.standalone.KoinComponent

class PdxAlertsConfig : KoinComponent {

    val alexa = Alexa()
    val twitter = Twitter()

    inner class Alexa {
        val skillId: String = System.getenv("SKILL_ID")
        val invocationName: String = if (System.getenv("INVOCATION_NAME") != null)
            System.getenv("INVOCATION_NAME")
        else
            "Portland Alerts"
    }

    inner class Twitter {
        val twitterHandle: String = if (System.getenv("TWITTER_HANDLE") != null)
            System.getenv("TWITTER_HANDLE")
        else
            "pdxalerts"
        val consumerKey: String = System.getenv("TWITTER_CONSUMER_KEY")
        val consumerSecret: String = System.getenv("TWITTER_CONSUMER_SECRET")
        val accessToken: String = System.getenv("TWITTER_ACCESS_TOKEN")
        val accessTokenSecret: String = System.getenv("TWITTER_ACCESS_TOKEN_SECRET")
    }
}

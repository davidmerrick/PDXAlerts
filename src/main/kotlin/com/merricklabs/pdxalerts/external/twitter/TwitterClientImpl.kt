package com.merricklabs.pdxalerts.external.twitter

import com.merricklabs.pdxalerts.PdxAlertsConfig
import mu.KotlinLogging
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import twitter4j.Paging
import twitter4j.Status
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

private val log = KotlinLogging.logger {}

class TwitterClientImpl : KoinComponent, TwitterClient {

    private val config: PdxAlertsConfig by inject()
    private val twitter: Twitter

    init {
        log.info { "Initializing Twitter client" }
        val cb = ConfigurationBuilder()
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(config.twitter.consumerKey)
                .setOAuthConsumerSecret(config.twitter.consumerSecret)
                .setOAuthAccessToken(config.twitter.accessToken)
                .setOAuthAccessTokenSecret(config.twitter.accessTokenSecret)

        val tf = TwitterFactory(cb.build())
        twitter = tf.instance
    }

    override fun getLatestTweet(): Status {
        return twitter.getUserTimeline(config.twitter.twitterHandle, Paging(1, 1))[0]
    }
}

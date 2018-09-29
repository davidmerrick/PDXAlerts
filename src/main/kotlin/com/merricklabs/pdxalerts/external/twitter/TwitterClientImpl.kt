package com.merricklabs.pdxalerts.external.twitter

import com.merricklabs.pdxalerts.PdxAlertsConfig
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import twitter4j.Query
import twitter4j.Status
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

class TwitterClientImpl : KoinComponent, TwitterClient {

    private val config: PdxAlertsConfig by inject()
    private val twitter: Twitter

    init {
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
        val query = Query("source:${config.twitter.twitterHandle}")
        return twitter.search(query).tweets[0]
    }
}

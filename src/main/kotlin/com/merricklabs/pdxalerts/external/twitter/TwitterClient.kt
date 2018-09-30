package com.merricklabs.pdxalerts.external.twitter

import twitter4j.Status

interface TwitterClient {
    fun getLatestTweets(count: Int = 1): List<Status>
}
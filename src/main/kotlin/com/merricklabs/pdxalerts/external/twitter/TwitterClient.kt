package com.merricklabs.pdxalerts.external.twitter

import twitter4j.Status

interface TwitterClient {
    fun getLatestTweet(): Status
}
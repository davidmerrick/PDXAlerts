package com.merricklabs.pdxalerts.mocks

import twitter4j.GeoLocation
import twitter4j.HashtagEntity
import twitter4j.MediaEntity
import twitter4j.Place
import twitter4j.RateLimitStatus
import twitter4j.Scopes
import twitter4j.Status
import twitter4j.SymbolEntity
import twitter4j.URLEntity
import twitter4j.User
import twitter4j.UserMentionEntity
import java.util.Date

class MockStatus : Status {
    private var text = ""

    fun setText(value: String) {
        text = value
    }

    override fun getText(): String {
        return text
    }

    override fun getUserMentionEntities(): Array<UserMentionEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContributors(): LongArray {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isFavorited(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInReplyToScreenName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDisplayTextRangeStart(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGeoLocation(): GeoLocation {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSource(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInReplyToStatusId(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getId(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWithheldInCountries(): Array<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserRetweetId(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSymbolEntities(): Array<SymbolEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAccessLevel(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInReplyToUserId(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMediaEntities(): Array<MediaEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlace(): Place {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isRetweetedByMe(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getURLEntities(): Array<URLEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isRetweeted(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLang(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getQuotedStatus(): Status {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRateLimitStatus(): RateLimitStatus {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDisplayTextRangeEnd(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun compareTo(other: Status?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getQuotedStatusId(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isRetweet(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRetweetedStatus(): Status {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFavoriteCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPossiblySensitive(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getScopes(): Scopes {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isTruncated(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCreatedAt(): Date {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getQuotedStatusPermalink(): URLEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHashtagEntities(): Array<HashtagEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRetweetCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
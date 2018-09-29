package com.merricklabs.pdxalerts

import com.merricklabs.pdxalerts.external.twitter.TwitterClient
import com.merricklabs.pdxalerts.testutil.TestConstants.INTEGRATION_GROUP
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.koin.test.declareMock
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

open class PdxAlertsIntegrationTestBase : KoinTest {

    protected val twitterClient: TwitterClient by inject()

    @BeforeMethod(groups = [INTEGRATION_GROUP])
    fun beforeClass() {
        StandAloneContext.loadKoinModules(PdxAlertsModule)
        declareMock<TwitterClient>()
    }

    @AfterMethod(groups = [INTEGRATION_GROUP])
    fun afterMethod() {
        StandAloneContext.stopKoin()
    }
}
package org.wikipedia.homeworks.homework12

import androidx.test.espresso.AmbiguousViewMatcherException
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.params.FlakySafetyParams.Companion.defaultAllowedExceptions
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class ForTests: TestCase(
    kaspressoBuilder = Kaspresso.Builder.advanced{
        flakySafetyParams = FlakySafetyParams.custom(
            timeoutMs = 30000,
            allowedExceptions = FlakySafetyParams.defaultAllowedExceptions.plus(
                AmbiguousViewMatcherException::class.java)

        )
    })
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

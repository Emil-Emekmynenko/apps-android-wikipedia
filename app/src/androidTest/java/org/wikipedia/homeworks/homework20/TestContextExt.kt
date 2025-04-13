package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.homeworks.homework19.Steps

private val stepContextCache = mutableMapOf<TestContext<*>, NamedSteps>()
val TestContext<*>.steps: NamedSteps
    get() = stepContextCache.getOrPut(this) { NamedSteps(this) }
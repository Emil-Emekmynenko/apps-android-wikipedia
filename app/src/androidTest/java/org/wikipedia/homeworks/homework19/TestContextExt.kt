package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.homeworks.homework19.Steps
import org.wikipedia.homeworks.homework20.NamedSteps

val TestContext<*>.steps : Steps
    get()= Steps(this)

val TestContext<*>.namedSteps  : NamedSteps
    get()= NamedSteps(this)
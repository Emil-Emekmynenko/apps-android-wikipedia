package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.actions.BaseActions

val names = mutableMapOf<BaseActions, String>()

fun <T : BaseActions> T.setName(name: String): T {
    names[this] = name
    return this
}
fun BaseActions.getName() : String? {
    return names[this] ?: throw RuntimeException ("set name")
}

fun BaseActions.withParent(elementName: String) = getName().withParent(elementName)
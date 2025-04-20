package org.wikipedia.homeworks.homework21

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert

class CustomImageAssertion : ViewAssertion {
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (view is ImageView) {
            Assert.assertNotNull(view.drawable)
        } else {
            throw (noViewFoundException ?: AssertionError("Это не картинка"))
        }
    }
}
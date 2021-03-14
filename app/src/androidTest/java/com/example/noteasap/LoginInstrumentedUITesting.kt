package com.example.noteasap

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.noteasap.ui.login.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class LoginInstrumentedUITesting {
    @get:Rule
    val testRule=ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginUI(){
        onView(withId(R.id.log_email))
            .perform(typeText("gopal@gmail.com"))
        closeSoftKeyboard()

        Thread.sleep(100)
        onView(withId(R.id.password))
            .perform(typeText("gopal123"))

        closeSoftKeyboard()
        onView(withId(R.id.login))
            .perform(click())

        Thread.sleep(2500)
        onView(withId(R.id.bottom_navigation))
            .check(matches(isDisplayed()))
    }

}
package com.example.noteasap

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.noteasap.ui.login.LoginActivity
import com.example.noteasap.ui.signUpViewModel.SignUpActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class SignupInstrumentedUITesting {
    @get:Rule
    val testRule= ActivityScenarioRule(SignUpActivity::class.java)
    @Test
    fun checkSignupUI(){
        Espresso.onView(ViewMatchers.withId(R.id.fullName))
            .perform(ViewActions.typeText("UI testing"))
        Espresso.closeSoftKeyboard()
        Thread.sleep(100)

        Espresso.onView(ViewMatchers.withId(R.id.log_email))
            .perform(ViewActions.typeText("UITestning@gmail.com"))
        Thread.sleep(100)

        Espresso.onView(ViewMatchers.withId(R.id.pass))
            .perform(ViewActions.typeText("UITestning"))
        Thread.sleep(100)

        Espresso.onView(ViewMatchers.withId(R.id.con_pss))
            .perform(ViewActions.typeText("UITestning"))
        Thread.sleep(100)

        Espresso.onView(ViewMatchers.withId(R.id.termsnCon))
            .perform(ViewActions.click())
        Thread.sleep(100)

        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.reister))
            .perform(ViewActions.click())

        Thread.sleep(2500)
        Espresso.onView(ViewMatchers.withId(R.id.fullName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
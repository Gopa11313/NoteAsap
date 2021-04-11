package com.example.noteasap

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.noteasap.ui.login.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class AccountUploadnotesUITesting {
    @get:Rule
    val testRule = ActivityScenarioRule(LoginActivity::class.java)
    @Test
    fun checkUploadNoteActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.log_email))
            .perform(ViewActions.typeText("gopal@gmail.com"))
        Espresso.closeSoftKeyboard()

        Thread.sleep(100)
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(ViewActions.typeText("gopal123"))

        Thread.sleep(100)
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.login))
            .perform(ViewActions.click())

        Thread.sleep(1500)
        Espresso.onView(ViewMatchers.withId(R.id.notif_Button))
            .perform(ViewActions.click())


        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.ic_account))
            .perform(ViewActions.click())

        Thread.sleep(1500)
        Espresso.onView((ViewMatchers.withId(R.id.uploadnotesframe)))
            .perform(ViewActions.click())


        Thread.sleep(2500)
        Espresso.onView(ViewMatchers.withId(R.id.chooseFile))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Thread.sleep(5000)



//        Espresso.onView((withId(R.id.recyclerViewLatestReleased)))
//            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(1,click()))
//
//        Thread.sleep(2000)
//
//        Espresso.onView(withId(R.id.btnAddToWatchlist)).perform(scrollTo(), click());
//
//        Thread.sleep(2000)
//
//        Espresso.onView(withId(R.id.btnRemoveFromWatchlist))
//            .check(ViewAssertions.matches(isDisplayed()))


//        Espresso.onView(withId(R.id.recyclerViewLatestReleased)).perform(
//                actionOnItemAtPosition<MovieAdapter.MovieViewHolder>(
//                        1, R.id.moviesLinearLayout, click()));


//        Thread.sleep(1000)
//
//        Espresso.onView(ViewMatchers.withId(R.id.moviesLinearLayout))
//            .perform(ViewActions.click())


//        Espresso.onView(ViewMatchers.withId(R.id.tvLatestReleased))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

}

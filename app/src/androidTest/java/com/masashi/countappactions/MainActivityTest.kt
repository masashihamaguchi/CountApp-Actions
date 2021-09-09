package com.masashi.countappactions

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule


/**
 * Created by Masashi Hamaguchi on 2021/09/06.
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun init() {
        onView(withId(R.id.textView)).check(matches(withText("0")))
        onView(withId(R.id.textView)).check(matches(hasTextColor(R.color.BLACK)))
    }

    @Test
    fun plus() {
        onView(withId(R.id.plusBtn)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("1")))
        onView(withId(R.id.textView)).check(matches(hasTextColor(R.color.BLUE)))
    }

    @Test
    fun minus() {
        for (i in 0..4) onView(withId(R.id.minusBtn)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("-5")))
        onView(withId(R.id.textView)).check(matches(hasTextColor(R.color.RED)))
    }
}
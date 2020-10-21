package com.natlus.skor

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SkorTest {
    @Rule
    @JvmField
    var activityScenarioRule =
        ActivityScenarioRule(
            MainActivity::class.java
        )

    @Before
    fun before() {
        activityScenarioRule.scenario
            .onActivity { activity ->
                activity.supportFragmentManager
                    .beginTransaction()
            }
    }

    @Test
    fun addScoreHomeTest() {
        Espresso.onView(ViewMatchers.withId(R.id.button_add_home))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.input_name))
            .perform(ViewActions.typeText("Andi"))
        Espresso.onView(ViewMatchers.withId(R.id.input_minute))
            .perform(ViewActions.typeText("40"))
            .perform(ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.button_save))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.text_home_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }

    @Test
    fun addScoreAwayTest() {
        Espresso.onView(ViewMatchers.withId(R.id.button_add_away))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.input_name))
            .perform(ViewActions.typeText("Budi"))
        Espresso.onView(ViewMatchers.withId(R.id.input_minute))
            .perform(ViewActions.typeText("45"))
            .perform(ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.button_save))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.text_away_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }

    @Test
    fun addScoreHomeScorerTest() {
        Espresso.onView(ViewMatchers.withId(R.id.button_add_home))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.input_name))
            .perform(ViewActions.typeText("Candra"))
        Espresso.onView(ViewMatchers.withId(R.id.input_minute))
            .perform(ViewActions.typeText("50"))
            .perform(ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.button_save))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button_add_home))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.input_name))
            .perform(ViewActions.typeText("Beni"))
        Espresso.onView(ViewMatchers.withId(R.id.input_minute))
            .perform(ViewActions.typeText("60"))
            .perform(ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.button_save))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.text_home_scorer))
            .check(ViewAssertions.matches(ViewMatchers.withText("Candra 50\" Beni 60\" ")))
    }

    @Test
    fun addScoreAwayScorerTest() {
        Espresso.onView(ViewMatchers.withId(R.id.button_add_away))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.input_name))
            .perform(ViewActions.typeText("Deni"))
        Espresso.onView(ViewMatchers.withId(R.id.input_minute))
            .perform(ViewActions.typeText("60"))
            .perform(ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.button_save))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button_add_away))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.input_name))
            .perform(ViewActions.typeText("Joni"))
        Espresso.onView(ViewMatchers.withId(R.id.input_minute))
            .perform(ViewActions.typeText("70"))
            .perform(ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.button_save))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.text_away_scorer))
            .check(ViewAssertions.matches(ViewMatchers.withText("Deni 60\" Joni 70\" ")))
    }
}
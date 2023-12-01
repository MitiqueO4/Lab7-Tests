package com.example.lab_7;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkFirstName() throws Exception {
        try (ActivityScenario<MainActivity> scenario = activityScenarioRule.getScenario()) {

            Espresso.onView(withId(R.id.textView1)).check(matches(isDisplayed()));
            Espresso.onView(withId(R.id.username)).perform(ViewActions.replaceText("user1"));
            Espresso.onView(withId(R.id.username))
                    .check(matches(withText(Matchers.not(Matchers.equalTo("user")))));
        }
    }
}
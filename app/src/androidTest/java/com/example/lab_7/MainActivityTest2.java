package com.example.lab_7;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest2 {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void emailIsInvalid() {
        try (ActivityScenario<MainActivity> scenario = activityScenarioRule.getScenario()) {
            Espresso.onView(withId(R.id.username)).perform(typeText("user"), closeSoftKeyboard());
            Espresso.onView(withId(R.id.Lastname)).perform(typeText("test"), closeSoftKeyboard());
            Espresso.onView(withId(R.id.email)).perform(typeText("email@"), closeSoftKeyboard());
            Espresso.onView(withId(R.id.loginBtn)).perform(click());
            Espresso.onView(withText("Invalid Email")).check(matches(isDisplayed()));
        }
    }
}
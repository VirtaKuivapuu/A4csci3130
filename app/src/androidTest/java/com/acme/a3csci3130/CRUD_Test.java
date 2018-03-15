/**
 * Created by YZ on 2018-03-14.
 */



package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class CRUD_Test {

    String business_number = "123456789";
    String name = "abc";
    String primary_business = "Fisher";
    String address = "123 bubu St";
    String province = "NS";

    String updated_business_number = "666666666";
    String updated_name = "fff";
    String updated_primary_business = "Distributor";
    String updated_address = "777 sdf ave";
    String updated_province = "NB";


    @Rule
    public ActivityTestRule<MainActivity> myActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }

    @Test
    public void createTest1(){
        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.business_number)).perform(typeText(business_number));
        closeSoftKeyboard();
        onView(withId(R.id.name)).perform(typeText(name));
        closeSoftKeyboard();
        onView(withId(R.id.primary_business)).perform(typeText(primary_business));
        closeSoftKeyboard();
        onView(withId(R.id.address)).perform(typeText(address));
        closeSoftKeyboard();
        onView(withId(R.id.province)).perform(typeText(province));
        closeSoftKeyboard();

        onView(withId(R.id.submitButton)).perform(click());
    }

    @Test
    public  void readTest1() throws InterruptedException{
        Thread.sleep(1500);

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        onView(withId(R.id.business_number)).check(matches(withText(business_number)));
        onView(withId(R.id.name)).check(matches(withText(name)));
        onView(withId(R.id.primary_business)).check(matches(withText(primary_business)));
        onView(withId(R.id.address)).check(matches(withText(address)));
        onView(withId(R.id.province)).check(matches(withText(province)));
    }

    @Test
    public  void  updateTest1() throws InterruptedException{
        Thread.sleep(1500);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.business_number)).perform(replaceText(updated_business_number));
        closeSoftKeyboard();
        onView(withId(R.id.name)).perform(replaceText(updated_name));
        closeSoftKeyboard();
        onView(withId(R.id.primary_business)).perform(replaceText(updated_primary_business));
        closeSoftKeyboard();
        onView(withId(R.id.address)).perform(replaceText(updated_address));
        closeSoftKeyboard();
        onView(withId(R.id.province)).perform(replaceText(updated_province));
        closeSoftKeyboard();
        onView(withId(R.id.updateButton)).perform(click());
        Thread.sleep(1500);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.business_number)).check(matches(withText(updated_business_number)));
        onView(withId(R.id.name)).check(matches(withText(updated_name)));
        onView(withId(R.id.primary_business)).check(matches(withText(updated_primary_business)));
        onView(withId(R.id.address)).check(matches(withText(updated_address)));
        onView(withId(R.id.province)).check(matches(withText(updated_province)));
    }

    @Test
    public void deleteTest1() throws InterruptedException{
        Thread.sleep(1500);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}




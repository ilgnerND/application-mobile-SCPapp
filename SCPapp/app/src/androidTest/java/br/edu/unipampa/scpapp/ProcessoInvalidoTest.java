package br.edu.unipampa.scpapp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ProcessoInvalidoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void processoInvalidoTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.campo_cont_processo),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText.perform(scrollTo(), replaceText("22222"), closeSoftKeyboard());



        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.campo_cpf),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText2.perform(scrollTo(), replaceText("333.333.333-33"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton.perform(scrollTo(), click());

    }

}

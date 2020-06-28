package br.edu.unipampa.scpapp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestedeacessoNegativoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testedeacessoNegativoTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.campo_cont_processo),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText.perform(scrollTo(), replaceText("000000000000000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.campo_cont_processo), withText("00000000000000"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText2.perform(scrollTo(), replaceText("000000000000000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.campo_cont_processo), withText("00000000000000"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText3.perform(scrollTo(), replaceText("000000000000000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.campo_cont_processo), withText("00000000000000"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText4.perform(scrollTo(), replaceText("000000000000000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.campo_cont_processo), withText("00000000000000"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText5.perform(pressImeActionButton());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.campo_cpf),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText6.perform(scrollTo(), replaceText("333"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.campo_cpf), withText("333."),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText7.perform(scrollTo(), replaceText("333.333"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.campo_cpf), withText("333.333."),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText8.perform(scrollTo(), replaceText("333.333.333"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.campo_cpf), withText("333.333.333-"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText9.perform(scrollTo(), replaceText("333.333.333-33"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.campo_cpf), withText("333.333.333-33"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText10.perform(scrollTo(), replaceText("333.333.333-3"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.campo_cpf), withText("3333333333"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText11.perform(scrollTo(), replaceText("000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.campo_cpf), withText("000."),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText12.perform(scrollTo(), replaceText("000.000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.campo_cpf), withText("000.000."),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText13.perform(scrollTo(), replaceText("000.000.000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.campo_cpf), withText("000.000.000-"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText14.perform(scrollTo(), replaceText("000.000.000-00"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.rdCNPJ), withText("CNPJ"),
                        withParent(withId(R.id.radioGroup))));
        appCompatRadioButton.perform(scrollTo(), click());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.campo_cpf), withText("000.000.000-00"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText15.perform(scrollTo(), replaceText("000.000.000-000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.campo_cpf), withText("00.000.000/0000-"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText16.perform(scrollTo(), replaceText("00.000.000/0000-00"), closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.campo_cont_processo), withText("00000000000000"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText17.perform(scrollTo(), replaceText(""), closeSoftKeyboard());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.campo_cont_processo),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText18.perform(pressImeActionButton());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.campo_cpf), withText("00.000.000/0000-00"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText19.perform(scrollTo(), replaceText("00.000.000/0000-0"), closeSoftKeyboard());

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.campo_cpf), withText("0000000000000"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText20.perform(scrollTo(), replaceText("000000000000"), closeSoftKeyboard());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.campo_cpf), withText("000000000000"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText21.perform(scrollTo(), replaceText(""), closeSoftKeyboard());

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.campo_cont_processo),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText22.perform(scrollTo(), replaceText("1234567"), closeSoftKeyboard());

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.campo_cpf),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText23.perform(scrollTo(), replaceText("11"), closeSoftKeyboard());

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.campo_cpf), withText("11."),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText24.perform(scrollTo(), replaceText("11.111"), closeSoftKeyboard());

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.campo_cpf), withText("11.111."),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText25.perform(scrollTo(), replaceText("11.111.111"), closeSoftKeyboard());

        ViewInteraction appCompatEditText26 = onView(
                allOf(withId(R.id.campo_cpf), withText("11.111.111/"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText26.perform(scrollTo(), replaceText("11.111.111/1111"), closeSoftKeyboard());

        ViewInteraction appCompatEditText27 = onView(
                allOf(withId(R.id.campo_cpf), withText("11.111.111/1111-"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText27.perform(scrollTo(), replaceText("11.111.111/1111-11"), closeSoftKeyboard());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton5.perform(scrollTo(), click());

        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.activity_main),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

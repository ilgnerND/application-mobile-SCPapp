package br.edu.unipampa.scpapp;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by Ilgner on 05/05/2017.
 */

public class CompartilhamentoNegativoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buscasTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.campo_cont_processo),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText.perform(scrollTo(), replaceText("TesteCampoTexto"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.campo_cont_processo), withText("TexteCompoNumerico"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText2.perform(scrollTo(), replaceText("TesteCampoNumerico"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.campo_cont_processo), withText("12345678999999"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.campo_cpf),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText4.perform(scrollTo(), replaceText("888.888.888-88"), closeSoftKeyboard());


        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.campo_cpf), withText(""),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText10.perform(scrollTo(), click());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.campo_cpf),/*withText("888.888.888-88")*/
                        withParent(withId(R.id.activity_main))));
        appCompatEditText11.perform(scrollTo(), replaceText("222.222.222-22"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.campo_cpf), withText("8888888888"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText12.perform(scrollTo(),replaceText("222.222.222-22"), closeSoftKeyboard());
        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.campo_cont_processo), /*withText("12345678999999"),*/
                        withParent(withId(R.id.activity_main))));
        appCompatEditText16.perform(scrollTo(), replaceText("12345678"), closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.campo_cont_processo), withText("12345678"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText17.perform(pressImeActionButton());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction button = onView(
                allOf(withId(R.id.btAndamento), withText("Andamento")));
        button.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.campo_cont_processo), /*withText("12345678"),*/
                        withParent(withId(R.id.activity_main))));
        appCompatEditText19.perform(scrollTo(), replaceText("123456789"), closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.btAndamento), withText("Andamento")));
        button2.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.campo_cont_processo), /*withText("123456789"),*/
                        withParent(withId(R.id.activity_main))));
        appCompatEditText20.perform(scrollTo(), replaceText("1234567"), closeSoftKeyboard());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.campo_cpf), /*withText("222.222.222-22"),*/
                        withParent(withId(R.id.activity_main))));
        appCompatEditText21.perform(scrollTo(), replaceText("333.333.333-333"), closeSoftKeyboard());

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.campo_cpf), withText("2222222222"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText22.perform(scrollTo(), replaceText("333"), closeSoftKeyboard());

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.campo_cpf), withText("333."),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText23.perform(scrollTo(), replaceText("333.333"), closeSoftKeyboard());

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.campo_cpf), withText("333.333."),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText24.perform(scrollTo(), replaceText("333.333.333"), closeSoftKeyboard());

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.campo_cpf), withText("333.333.333-"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText25.perform(scrollTo(), replaceText("333.333.333-333"), closeSoftKeyboard());

        ViewInteraction appCompatEditText26 = onView(
                allOf(withId(R.id.campo_cpf), withText("333.333.333-33"),
                        withParent(withId(R.id.activity_main))));
        appCompatEditText26.perform(pressImeActionButton());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.btAndamento), withText("Andamento")));
        button3.perform(scrollTo(), click());

        ViewInteraction imageView = onView(
                allOf(withClassName(is("android.widget.ImageView")),
                        withParent(childAtPosition(
                                withId(android.R.id.list),
                                0)),
                        isDisplayed()));
        /*imageView.perform(click());*/


        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btpesquisar), withText("Compartilhar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction button4 = onView(
                allOf(withId(R.id.btAndamento), withText("Aplicação")));
        button3.perform(scrollTo(), click());

        ViewInteraction imageView2 = onView(
                allOf(withClassName(is("android.widget.ImageView")),
                        withParent(childAtPosition(
                                withId(android.R.id.list),
                                0)),
                        isDisplayed()));

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction button7 = onView(
                allOf(withId(R.id.btAndamento), withText("Andamento")));
        button3.perform(scrollTo(), click());

        ViewInteraction imageView3 = onView(
                allOf(withClassName(is("android.widget.ImageView")),
                        withParent(childAtPosition(
                                withId(android.R.id.list),
                                0)),
                        isDisplayed()));

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btpesquisar), withText("Pesquisar"),
                        withParent(withId(R.id.activity_main))));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction button5 = onView(
                allOf(withId(R.id.btAndamento), withText("Andamento")));
        button3.perform(scrollTo(), click());

        ViewInteraction imageView4 = onView(
                allOf(withClassName(is("android.widget.ImageView")),
                        withParent(childAtPosition(
                                withId(android.R.id.list),
                                0)),
                        isDisplayed()));


        pressBack();



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

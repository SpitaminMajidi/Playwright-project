package com.pw.m5;

import com.google.errorprone.annotations.Var;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class NavigationOptions {

    @Test
    void navigationTest(Page page) {
        page.navigate(HOME_WEB, new Page.NavigateOptions().setTimeout(1));

        assertThat(page).hasTitle("Credit Association");

        page.reload();
        page.goBack();
        page.goForward();
    }

    @Test
    void challengeTest(Page page) {
        page.navigate(HOME_WEB);

        // click register
        page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Register")).click();

        // check "invalid feedback is visible"
        var feedback = page.locator(".invalid feedback").all();
        for (var message : feedback) {
            assertThat(message).isVisible();
        }

        // reload
        page.reload();

        // checks "invalid feedback is not visible"
        for (var message : feedback) {
            assertThat(message).not().isVisible();
        }
    }
}

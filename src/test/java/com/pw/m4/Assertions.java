package com.pw.m4;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.pw.TestScriptBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.pw.Constants.HOME_WEB;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Assertions extends TestScriptBase {

    @Test
    void testWithPlaywrightAssertions() {
        page.navigate(HOME_WEB);

        // click register

        var feedback = page.locator(".invalid-feedback");

        // JUnit assertions
        assertEquals("Credit Association", page.title());
        assertTrue(feedback.isVisible());

        // Playwright assertions
        assertThat(page).hasTitle("Credit Association");
        assertThat(feedback).isVisible();
    }

}

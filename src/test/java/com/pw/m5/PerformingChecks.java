package com.pw.m5;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class PerformingChecks {

    @Test
    void performChecks(Page page) {

        page.navigate(HOME_WEB);

        var textarea = page.locator("#textarea");

        assertThat(textarea).isVisible();
        assertThat(textarea).isEditable();
        assertThat(textarea).isInViewport();

        assertThat(textarea).hasText("", new LocatorAssertions.HasTextOptions().setIgnoreCase(true));

        // has value
        assertThat(textarea).hasValue("");    // for what you typed in

        assertThat(textarea).hasText("");   // for what is between tags, e.g. <textarea> some text </textarea>

        var msg = "msg";

        page.getByRole(AriaRole.CHECKBOX).check();
        textarea.fill(msg);

        assertThat(textarea).hasValue(msg); // it should pass
        assertThat(textarea).hasText(msg); // it should fail

    }
}

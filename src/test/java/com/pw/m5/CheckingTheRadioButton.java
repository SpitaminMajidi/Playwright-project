package com.pw.m5;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class CheckingTheRadioButton {

    @Test
    void checkingTheRadioButton(Page page) {
        page.navigate(HOME_WEB);

        String message = "msg";

        var checkbox = page.getByRole(AriaRole.CHECKBOX);
        var textarea = page.locator("#textarea");

        checkbox.check();
        textarea.fill(message);

        assertThat(textarea).hasValue(message);


    }

}

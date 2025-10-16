package com.pw.m5;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class FillingOptions {

    @Test
    void fillingOptionsTest(Page page) {
        page.navigate(HOME_WEB);
        page.getByLabel("First name").fill("John");
        page.getByLabel("Date of birth").fill("2024-10-10");

    }

    @Test
    void forcingTest(Playwright pw) {
        var page = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000)).newPage();
        page.navigate(HOME_WEB);

        var button = page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Register"));
        var textarea = page.locator("#textarea");

        button.click(new Locator.ClickOptions());

        textarea.fill("text", new Locator.FillOptions().setForce(true));

    }
}

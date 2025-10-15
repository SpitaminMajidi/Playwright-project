package com.pw.m3;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;

public class SlowingThingsDown {

    @Test
    void firstPlayWrightScriptRefactoredNew() {
        try (var pw = Playwright.create();
             var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))) {
            Page page = browser.newPage();
            page.navigate(HOME_WEB);
            System.out.println(page.title());

            Locator name = page.getByLabel("First name");
            name.fill("John");
            name.clear();

            page.getByLabel("First name").fill("Doe");

            page.getByRole(BUTTON, name("Register")).click();

            var warning = page.getByText("Valid last name is required"); //possible but not recommended
            Assertions.assertTrue(warning.isVisible());


        }
    }

    private static Page.GetByRoleOptions name(String name) {
        return new Page.GetByRoleOptions().setName(name);
    }
}

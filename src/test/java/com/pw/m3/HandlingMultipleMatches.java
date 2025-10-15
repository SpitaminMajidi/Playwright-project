package com.pw.m3;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.pw.Constants.HOME_WEB;

import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.microsoft.playwright.options.AriaRole.LINK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HandlingMultipleMatches {

    @Test
    void handlingMultipleMatches() {
       try (var pw = Playwright.create();
       var browser = pw.chromium().launch(new
       BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))) {
           Page page = browser.newPage();
          page.navigate(HOME_WEB);
          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Savings")).click();

       }
    }





    @Test
    void multipleMatchesFirstLastNth() {
        try (var pw = Playwright.create();
             var browser = pw.chromium().launch()) {
            Page page = browser.newPage();
            page.navigate(HOME_WEB);

            Locator buttons = page.getByRole(BUTTON); // single obj that may contain multiple elements

            System.out.println(buttons.first().textContent());
            System.out.println(buttons.last().textContent());
            System.out.println(buttons.nth(1).textContent());


        }
    }



    @Test
    void multipleMatchesCountOrIterate() {

        try (var pw = Playwright.create();
             var browser = pw.chromium().launch()) {
            Page page = browser.newPage();
            page.navigate(HOME_WEB);

            page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Register")).click();

            var warnings = page.locator(".invalid-feedback");
          //  assertEquals(3, warnings.count());

            for(var message : warnings.all()){
              //  assertTrue(message.isVisible()); // possible but not recommended
                assertThat(message).isVisible();
            }
        }
    }

}

package com.pw.m3;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static com.pw.Constants.HOME_WEB;

public class OtherLocators {

    @Test
    void outdatedLocators() {
     try(var pw = Playwright.create();
     var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))) {
         Page page = browser.newPage();
         page.navigate(HOME_WEB);

         page.check("#hear-about");
         page.fill("textarea","Message");

         // 2+ matches? -> default to 1st
         // Poor locator reusability


     }
    }
}

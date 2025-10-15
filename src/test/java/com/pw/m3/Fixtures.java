package com.pw.m3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.pw.Constants.HOME;
import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class Fixtures {

    @Test
    void testWithPageFixtures(Page page){

        page.navigate(HOME_WEB);
        Assertions.assertEquals("Credit Association", page.title());
    }

    @Test
    void testWithBrowserFixture(Browser browser){

   var context = browser.browserType().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
   Page page = context.newPage();
   page.navigate(HOME_WEB);



    }
}

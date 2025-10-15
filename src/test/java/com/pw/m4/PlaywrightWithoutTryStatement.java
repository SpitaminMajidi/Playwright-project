package com.pw.m4;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pw.TestScriptBase;
import org.junit.jupiter.api.*;

import static com.pw.Constants.HOME_WEB;

public class PlaywrightWithoutTryStatement extends TestScriptBase {


    @Test
    void playwrightWithoutTry() {
        page.navigate(HOME_WEB);
         System.out.println(page.title());
    }

}

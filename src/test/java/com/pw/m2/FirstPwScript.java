package com.pw.m2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class FirstPwScript {

    @Test
    void firstScript() {
        try(Playwright playwright = Playwright.create()){
          BrowserType type = playwright.chromium();

          try(Browser browser = type.launch()){
              Page page = browser.newPage();
              page.navigate("https://globalsolutions-reference.gpi-test.globepayroll.net/");
              System.out.println(page.title());
          }
        }

    }

    @Test
    void firstScriptRefactored() {
        try(var pw = Playwright.create();
            var browser = pw.chromium().launch()) {

                Page page = browser.newPage();
                page.navigate("https://globalsolutions-reference.gpi-test.globepayroll.net/");
                System.out.println(page.title());

        }

    }
}

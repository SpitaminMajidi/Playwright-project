package com.pw.m3;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.options.AriaRole.ROW;
import static com.pw.Constants.SAVINGS_WEB;
import static java.awt.SystemColor.text;

public class FilteringDemo {

    @Test
    void filters() {
        try (var pw = Playwright.create();
        var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))) {
         Page page = browser.newPage();
         page.navigate(SAVINGS_WEB);

         var rows = page.getByRole(ROW);
            System.out.println(rows);

         var row = rows.filter(text("Competition"));
            System.out.println(row.textContent());

        }
    }
    public static Locator.FilterOptions text(String text){
        return  new Locator.FilterOptions().setHasText(text);
    }
}

package com.pw.m6;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;
import static com.pw.Constants.NEW_URL;

@UsePlaywright
public class ConsoleEvents {

    @Test
    void handleConsoleEvents(Page page) {
        page.onConsoleMessage(msg -> {
            System.out.printf("Console message:", msg.type(), msg.text());
        });

        page.navigate(NEW_URL);
        page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Register")).click();
    }

    @Test
    void consoleErrors(Page page){

        page.onPageError(e -> {
            System.out.printf("Page error: %s%n" + e);

            page.navigate(NEW_URL);
            page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Register")).click();
        });
    }
}

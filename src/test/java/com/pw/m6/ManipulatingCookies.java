package com.pw.m6;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.Cookie;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;
import static com.pw.Constants.NEW_URL;

@UsePlaywright
public class ManipulatingCookies {

    @Test
    void manipulatingCookiesTest(Page page) {
        page.navigate(NEW_URL);
        BrowserContext ctx = page.context();
        System.out.println(ctx.cookies());

        Cookie cookie = new Cookie("cookie1", "abc").setUrl("https://playwright.dev");
        ctx.addCookies(List.of(cookie));

        System.out.println(ctx.cookies().getFirst());
        System.out.println(ctx.cookies().getFirst().name);

        ctx.clearCookies();

        System.out.println(ctx.cookies());
    }
}

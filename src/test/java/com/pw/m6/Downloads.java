package com.pw.m6;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;
import static com.pw.Constants.NEW_URL;


@UsePlaywright
public class Downloads {

    @Test
    void downloadFileTest(Playwright pw, Page page) {
      //  var page = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();

        page.navigate(NEW_URL);

        Download download = page.waitForDownload(() -> {
            page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Download Our Offer")).click();
        });

        System.out.println(download.path());
        System.out.println(download.suggestedFilename());
    }
}

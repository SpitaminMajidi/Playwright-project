package com.pw.m6;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;
import static com.pw.Constants.NEW_URL;

@UsePlaywright
public class Screenshots {

    @Test
    void takeScreenshot(Page page) {
        page.navigate(NEW_URL);

        var nameInput = page.getByLabel("First name");
        nameInput.fill("John");
        page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Register").setExact(true)).click();

        //basic
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/screenshot.png")));

        //advanced
        var elementsToMask = page.locator(".form-control").all();
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshot/screenshot-advanced.png"))
                .setFullPage(true)
                .setMask(elementsToMask)
                .setMaskColor("blue"));

        var feedbackInput = page.locator(".invalid-feedback").all();
        for (var msg: feedbackInput){
            assertThat(msg).not().isVisible();

        }
    }
}

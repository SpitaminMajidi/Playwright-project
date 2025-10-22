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
public class Dialogs {

    String name = "Sofia";

    @Test
    void dialogDefaultHandling(Page page) {
       page.navigate(NEW_URL);

       var nameInput = page.getByLabel("First name");
       nameInput.fill(name);

       assertThat(nameInput).hasValue(name);

       page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Clear")).click();
       assertThat(nameInput).hasValue(name);
    }

    @Test
    void dialogAccept(Page page) {

        page.onceDialog(Dialog::accept);
        page.navigate(NEW_URL);
        var nameInput = page.getByLabel("First name");
        nameInput.fill(name);
        page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Clear")).click();
        assertThat(nameInput).hasValue("");

    }
}

package com.pw.m5;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class ClickingOptions {

    @Test
    void clickingTest(Page page) {
       page.navigate(HOME_WEB);

       var button = page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Register"));

       button.click();
       button.click();
       button.click();

       for(int i=0; i<3; i++) {
           button.click();
       }

       button.click(new Locator.ClickOptions().setClickCount(2)); // clicks twice
       button.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT)); // right click
       button.dblclick(); // double click
    }
}

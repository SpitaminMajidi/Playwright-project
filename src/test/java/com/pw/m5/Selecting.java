package com.pw.m5;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class Selecting {

    @Test
    void selectingTest(Page page) {
        page.navigate(HOME_WEB);

        var deposit = page.getByTestId("deposit");
        var period = page.getByTestId("period");
        var result = page.getByTestId("result");

        deposit.fill("100");

        period.selectOption("6 months");
        assertThat(result).hasText("After 6 Months you will earn $2.00 on your deposit");

        period.selectOption(new SelectOption().setLabel("1 year"));
        assertThat(result).hasText("After 1 Year you will earn $5.00 on your deposit");
    }
}

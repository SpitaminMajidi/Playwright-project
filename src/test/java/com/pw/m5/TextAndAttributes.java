package com.pw.m5;


import com.microsoft.playwright.junit.UsePlaywright;

import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Page;

import static com.pw.Constants.SAVINGS_WEB;

@UsePlaywright
public class TextAndAttributes {

    @Test
    void textAndAttributes(Page page) {
        page.navigate(SAVINGS_WEB);
        var form = page.locator(".needs-validation");

        System.out.println("===== Inner HTML =====");
        System.out.println(form.innerHTML()); // includes HTML tags

        System.out.println("===== Text content =====");
        System.out.println(form.textContent()); // includes white spaces

        System.out.println("===== Inner text =====");
        System.out.println(form.innerText()); // includes white spaces trimmed

    }


}

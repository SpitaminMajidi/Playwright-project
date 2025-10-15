package com.pw.m2;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

public class BrowserSupport {

    @Test
    void browserSupport() {
        try(var pw = Playwright.create()){
            List<BrowserType> browserTypes = List.of(pw.chromium(), pw.firefox(), pw.webkit());

            for(var type: browserTypes){
                Page page = type.launch().newPage();
                page.navigate("https://globalsolutions-reference.gpi-test.globepayroll.net/");
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(type.name() + ".png")));
                
            }
        }
    }

}

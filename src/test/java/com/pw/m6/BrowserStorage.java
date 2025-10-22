package com.pw.m6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.pw.StorageState;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;
import static com.pw.Constants.NEW_URL;


@UsePlaywright
public class BrowserStorage {

    String name = "Andrejs";

    @Test
    void storageUiPerspective(Page page) {

        page.navigate(NEW_URL);

        var nameInput = page.getByLabel("First name");
        nameInput.fill(name);
        page.reload();
        assertThat(nameInput).hasValue("");

        nameInput.fill(name);
        page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Save Input")).click();
        page.reload();
        assertThat(nameInput).hasValue(name);
    }

    @Test
    void localStorage(Page page) throws JsonProcessingException {
        page.navigate(NEW_URL);
        page.getByLabel("First name").fill(name);
        page.getByLabel("Last name").fill("Berzins");
        page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Save Input")).click();

        String storageJson = page.context().storageState();
        System.out.println(storageJson);

        // JSON to POJO
        StorageState storageState = new ObjectMapper().readValue(storageJson, StorageState.class);

        for(var origin : storageState.origins()){
            System.out.printf("Origin: %s%n", origin.origin());

            for(StorageState.LocalStorageEntry entry : origin.localStorage()){
                System.out.printf("Key: %s, Value: %s%n", entry.name(), entry.value());
            }

        }
    }

    @Test
    void usingJavaScript(Page page){
        page.navigate(NEW_URL);

        var nameInput = page.getByLabel("First name");
        nameInput.fill(name);
        page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Save Input")).click();

        var href = (String) page.evaluate("location.href");
        System.out.println("href is:" + href);

        var storage = (Map<String, String>) page.evaluate("localStorage");
        System.out.println("local storage is:" + storage);

        page.evaluate("localStorage.clear()");
        page.reload();
        assertThat(nameInput).hasValue("");

        page.evaluate("localStorage.setItem('firstName', '" + name + "')");
        page.reload();
        assertThat(nameInput).hasValue(name);

        //if you want you can change the localStorage to the sessionStorage but keep in mind to change from js folder also
    }
}

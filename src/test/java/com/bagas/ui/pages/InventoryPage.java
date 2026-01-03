package com.bagas.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private final WebDriver driver;

    private final By inventoryTitle = By.cssSelector("[data-test='title']");
    private final By inventoryItem = By.cssSelector(".inventory_item");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpened() {
        String url = driver.getCurrentUrl();
        return url != null && url.contains("inventory.html")
                && !driver.findElements(inventoryTitle).isEmpty();
    }

    public int getInventoryItemsCount() {
        return driver.findElements(inventoryItem).size();
    }
}




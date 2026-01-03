package com.bagas.ui.steps;

import com.bagas.ui.pages.InventoryPage;
import com.bagas.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(Hooks.driver);
    private final InventoryPage inventoryPage = new InventoryPage(Hooks.driver);

    private static final String BASE_URL = "https://www.saucedemo.com/";

    @Given("saya membuka halaman login")
    public void sayaMembukaHalamanLogin() {
        loginPage.open(BASE_URL);
    }

    @When("saya login dengan username {string} dan password {string}")
    public void sayaLoginDenganUsernameDanPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("saya berhasil masuk ke halaman inventory")
    public void sayaBerhasilMasukKeHalamanInventory() {
        assertThat(inventoryPage.isOpened()).isTrue();
        assertThat(inventoryPage.getInventoryItemsCount()).isGreaterThan(0);
    }

    @Then("muncul error message yang mengandung {string}")
    public void munculErrorMessageYangMengandung(String expected) {
        String actual = loginPage.getErrorMessage();
        assertThat(actual).containsIgnoringCase(expected);
    }
}




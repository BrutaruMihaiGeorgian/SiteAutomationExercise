package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    WebDriver driver;

    // Elemente pentru Signup/Login
    By signupLoginLink = By.linkText("Signup / Login");
    By newUserSignupTitle = By.xpath("//h2[text()='New User Signup!']");
    By nameInput = By.name("name");
    By emailInput = By.cssSelector("input[data-qa='signup-email']");
    By signupButton = By.cssSelector("button[data-qa='signup-button']");

    // Elemente pentru creare cont
    By titleMrRadio = By.id("id_gender1");
    By passwordInput = By.id("password");
    By daysDropdown = By.id("days");
    By monthsDropdown = By.id("months");
    By yearsDropdown = By.id("years");
    By newsletterCheckbox = By.id("newsletter");
    By optinCheckbox = By.id("optin");
    By firstNameInput = By.id("first_name");
    By lastNameInput = By.id("last_name");
    By addressInput = By.id("address1");
    By countryDropdown = By.id("country");
    By stateInput = By.id("state");
    By cityInput = By.id("city");
    By zipcodeInput = By.id("zipcode");
    By mobileNumberInput = By.id("mobile_number");
    By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    // Elemente pentru pagina Account Created
    By accountCreatedText = By.tagName("b");
    By continueButton = By.cssSelector("a[data-qa='continue-button']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metode pentru Signup/Login
    public void clickSignupLogin() {
        driver.findElement(signupLoginLink).click();
    }

    public boolean isSignupTitleVisible() {
        return driver.findElement(newUserSignupTitle).isDisplayed();
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    // Metode pentru completare formular creare cont
    public void selectTitleMr() {
        driver.findElement(titleMrRadio).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(driver.findElement(daysDropdown)).selectByValue(day);
        new Select(driver.findElement(monthsDropdown)).selectByValue(month);
        new Select(driver.findElement(yearsDropdown)).selectByValue(year);
    }

    public void checkNewsletter() {
        driver.findElement(newsletterCheckbox).click();
    }

    public void checkOptin() {
        driver.findElement(optinCheckbox).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectCountry(String country) {
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
    }

    public void enterState(String state) {
        driver.findElement(stateInput).sendKeys(state);
    }

    public void enterCity(String city) {
        driver.findElement(cityInput).sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        driver.findElement(zipcodeInput).sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobile) {
        driver.findElement(mobileNumberInput).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    // Metode pentru pagina Account Created
    public String getAccountCreatedMessage() {
        return driver.findElement(accountCreatedText).getText();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}

package com.automationexercise.tests;

import com.automationexercise.pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class RegisterTest {

    static WebDriver driver;
    static RegistrationPage registrationPage;

    @BeforeAll
    public static void setup() {
        // Creează obiect ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // Adaugă opțiunea incognito
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        registrationPage = new RegistrationPage(driver);
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testUserRegistration() {
        driver.get("https://automationexercise.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]/p")).click();


        registrationPage.clickSignupLogin();

        Assertions.assertTrue(registrationPage.isSignupTitleVisible());

        String name = "Ion Test";
        String email = "ion" + System.currentTimeMillis() + "@test.com";

        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
        registrationPage.clickSignupButton();
        registrationPage.selectTitleMr();
        registrationPage.enterPassword("Parola123!");
        registrationPage.selectDateOfBirth("31", "5", "2000");
        registrationPage.checkNewsletter();
        registrationPage.checkOptin();
        registrationPage.enterFirstName("Brutaru");
        registrationPage.enterLastName("Mihai Georgian");
        registrationPage.enterAddress("Strada  123");
        registrationPage.selectCountry("Canada");
        registrationPage.enterState("Bucuresti");
        registrationPage.enterCity("Oltenita");
        registrationPage.enterZipcode("917025");
        registrationPage.enterMobileNumber("0700000000");
        registrationPage.clickCreateAccount();

        Assertions.assertEquals("ACCOUNT CREATED!", registrationPage.getAccountCreatedMessage());


        registrationPage.clickContinue();

    }
}

package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

// created not to repeate the Before and After Methods
public abstract class BaseTest {
    protected WebDriver webDriver;

    // Локаторы
    private final By TRAINING_SIMULATOR_TEXT = By.xpath(".//*[text()='Учебный тренажер']");

    @Before
    public void setup() {
        switch (String.valueOf(System.getProperty("browser"))) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                this.webDriver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                this.webDriver = new ChromeDriver();
        }
        openWebPage();
    }

    @After
    public void tearDown() {
        // закрытие браузера
        webDriver.quit();
    }

    // Методы
    public void openWebPage() {
        // переход на страницу тестового приложения
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        // ожидаение загрузки контента на стартовую страницу
        waitForHeaderDisclamer();
    }

    public void waitForHeaderDisclamer() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(TRAINING_SIMULATOR_TEXT));
    }
}

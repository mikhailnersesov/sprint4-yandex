package ru.praktikum.services.qa.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageSamokat extends BasePage {

    // Локаторы
    private final By orderTopButtonLocator = By.xpath("(.//*[text()='Заказать'])[1]");
    private final By orderBottomButtonLocator = By.xpath("(.//*[text()='Заказать'])[2]");
    private final By orderConfirmationTitleLocator = By.xpath(".//*[text()='Заказ оформлен']");

    // Конструктор
    public HomePageSamokat(WebDriver webDriver) {
        super(webDriver);
    }

    // Методы
    public void clickImportantQuestionButton(String question) {
        By importantQuestionItemLocator = By.xpath(".//*[text()='" + question + "']");
        WebElement importantQuestionButton = webDriver.findElement(importantQuestionItemLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", importantQuestionButton);
        importantQuestionButton.click();
    }

    public boolean checkImportantAnswerText(String answer) {
        By importantAnswerItemLocator = By.xpath(".//*[text()='" + answer + "']");
        WebElement importantAnswerItem = webDriver.findElement(importantAnswerItemLocator);
        importantAnswerItem.isDisplayed();
        return true;
    }

    public void clickOrderTopButton() {
        WebElement orderTopButton = webDriver.findElement(orderTopButtonLocator);
        orderTopButton.click();
    }

    public void clickBottomOrderButton() {
        WebElement bottomOrderButton = webDriver.findElement(orderBottomButtonLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", bottomOrderButton);
        bottomOrderButton.click();
    }

    public boolean isOrderConfirmationTitleDisplayed() {
        WebElement orderConfirmationTitle = webDriver.findElement(orderConfirmationTitleLocator);
        return orderConfirmationTitle.isDisplayed();

    }
}

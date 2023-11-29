package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentInformationPageSamokat extends BasePage {

    // Локаторы
    private final By orderFormRentInfoHeaderLocator = By.xpath(".//*[text()='Про аренду']");
    private final By orderDateFieldLocator = By.xpath(".//input[contains(@placeholder,'Когда привезти')]");
    private final By orderRentalPeriodFieldLocator = By.xpath(".//*[contains(text(),'Срок аренды')]");
    private final By orderButtonLocator = By.xpath("(.//button[text()='Заказать'])[2]");
    private final By confirmationOrderTitleLocator = By.xpath(".//*[text()='Хотите оформить заказ?']");
    private final By yesButtonLocator = By.xpath(".//button[text()='Да']");

    // Конструктор
    public RentInformationPageSamokat(WebDriver webDriver) {
        super(webDriver);
    }

    // Методы
    public void waitForRentInfoOrderFormHeader() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(orderFormRentInfoHeaderLocator));
    }

    public void setOrderDate(String date) {
        WebElement orderDateField = webDriver.findElement(orderDateFieldLocator);
        orderDateField.sendKeys(date);
        orderDateField.sendKeys(Keys.RETURN);
    }

    public void selectRentalPeriodOption(String rentalPeriod) {
        WebElement orderRentalPeriodField = webDriver.findElement(orderRentalPeriodFieldLocator);
        orderRentalPeriodField.click();
        WebElement orderRentalPeriodOption = webDriver.findElement(By.xpath(".//*[@role='option'][contains(text(),'" + rentalPeriod + "')]"));
        orderRentalPeriodOption.click();
    }

    public void clickScooterColorCheckbox(String scooterColor) {
        WebElement scooterColorCheckbox = webDriver.findElement(By.xpath(".//label[contains(text(),'" + scooterColor + "')]"));
        scooterColorCheckbox.click();
    }

    public void clickOrderButton() {
        WebElement orderButton = webDriver.findElement(orderButtonLocator);
        orderButton.click();
    }

    public void waitForConfirmationPopup() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(confirmationOrderTitleLocator));
    }

    public void clickYesButton() {
        WebElement yesButton = webDriver.findElement(yesButtonLocator);
        yesButton.click();
    }

    // Шаги
    public void fillInAndSubmitInfoAboutRent(String date, String rentalPeriod, String scooterColor) {
        // дождаться пока загрузятся данные на странице
        waitForRentInfoOrderFormHeader();
        // Заполнить поле "Когда привезти самокат"
        setOrderDate(date);
        // Выбрать опцию в поле "Срок аренды"
        selectRentalPeriodOption(rentalPeriod);
        // Выбрать цвет самоката
        clickScooterColorCheckbox(scooterColor);
        // Нажать кнопку "Заказать"
        clickOrderButton();
    }

    public void confirmOrder() {
        // Дождаться появления всплывающего диалога о подтверждении заказа
        waitForConfirmationPopup();
        // Наждать кнопку "Да"
        clickYesButton();
    }
}

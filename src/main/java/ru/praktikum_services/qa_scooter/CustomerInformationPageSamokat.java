package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerInformationPageSamokat extends BasePage {
    // Локаторы
    private final By orderFormCustomerInfoHeaderLocator = By.xpath(".//*[text()='Для кого самокат']");
    private final By orderNameFieldLocator = By.xpath(".//input[contains(@placeholder,'Имя')]");
    private final By orderSurnameFieldLocator = By.xpath(".//input[contains(@placeholder,'Фамилия')]");
    private final By orderAddressFieldLocator = By.xpath(".//input[contains(@placeholder,'Адрес')]");
    private final By orderMetroStationFieldLocator = By.xpath(".//input[contains(@placeholder,'Станция метро')]");
    private final By orderContactNumberFieldLocator = By.xpath(".//input[contains(@placeholder,'Телефон')]");
    private final By continueButtonLocator = By.xpath(".//button[text()='Далее']");

    // Конструктор
    public CustomerInformationPageSamokat(WebDriver webDriver) {
        super(webDriver);
    }

    // Методы
    public void waitForCustomerInfoOrderFormHeader() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(orderFormCustomerInfoHeaderLocator));
    }

    public void setOrderName(String name) {
        WebElement orderNameField = webDriver.findElement(orderNameFieldLocator);
        orderNameField.sendKeys(name);
    }

    public void setOrderSurname(String surname) {
        WebElement orderSurnameField = webDriver.findElement(orderSurnameFieldLocator);
        orderSurnameField.sendKeys(surname);
    }

    public void setOrderAddress(String address) {
        WebElement orderAddressField = webDriver.findElement(orderAddressFieldLocator);
        orderAddressField.sendKeys(address);
    }

    public void setOrderMetroStation(String metroStation) {
        WebElement orderMetroStationField = webDriver.findElement(orderMetroStationFieldLocator);
        orderMetroStationField.click();
        WebElement orderMetroStationName = webDriver.findElement(By.xpath(".//*[text()='" + metroStation + "']"));
        orderMetroStationName.click();
    }

    public void setOrderContactNumber(String contactNumber) {
        WebElement orderContactNumberField = webDriver.findElement(orderContactNumberFieldLocator);
        orderContactNumberField.sendKeys(contactNumber);
    }

    public void clickContinueButton() {
        WebElement continueButton = webDriver.findElement(continueButtonLocator);
        continueButton.click();
    }

    // Шаги
    public void fillInAndSubmitInfoAboutCustomer(String name, String surname, String address, String metroStation, String contactNumber) {
        // дождаться пока загрузятся данные на странице
        waitForCustomerInfoOrderFormHeader();
        // Заполнить поле "Имя"
        setOrderName(name);
        // Заполнить поле "Фамилия"
        setOrderSurname(surname);
        // Заполнить поле "Адрес: куда привезти заказ"
        setOrderAddress(address);
        // Выбрать станцию метро в поле "Станция метро"
        setOrderMetroStation(metroStation);
        // Заполнить поле "Телефон: на него позвонит курьер"
        setOrderContactNumber(contactNumber);
        // Нажать кнопку "Далее"
        clickContinueButton();
    }
}

package ru.praktikum.services.qa.scooter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderScooterTests extends BaseTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String contactNumber;
    private final String date;
    private final String rentalPeriod;
    private final String scooterColor;

    public OrderScooterTests(String name, String surname, String address, String metroStation, String contactNumber, String date, String rentalPeriod, String scooterColor) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.contactNumber = contactNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.scooterColor = scooterColor;
    }

    @Parameterized.Parameters(name = "{index} - name {0}, surname {1}, address {2}, metroStation {3}, contactNumber {4}, date {5}, rentalPeriod {6}, scooterColor {7}")
    public static Object[][] data() {
        return new Object[][]{
                {"Максим", "Калиниченко", "Улица Лужники, 24", "Спортивная", "+79261234567", "18.04.2024", "сутки", "чёрный жемчуг"}
        };
    }

    @Test
    public void orderScooterViaTopOption() {
        HomePageSamokat objHomePage = new HomePageSamokat(webDriver);
        // нажать верхнюю кнопку "Заказать"
        objHomePage.clickOrderTopButton();
        // Заполнить форму заказа, часть "Для кого самокат"
        CustomerInformationPageSamokat objOrderPage = new CustomerInformationPageSamokat(webDriver);
        objOrderPage.fillInAndSubmitInfoAboutCustomer(name, surname, address, metroStation, contactNumber);
        // Заполнить форму заказа, часть "Про аренду"
        RentInformationPageSamokat objRentInformationPage = new RentInformationPageSamokat(webDriver);
        objRentInformationPage.fillInAndSubmitInfoAboutRent(date, rentalPeriod, scooterColor);
        // Подтвердить заказ
        objRentInformationPage.confirmOrder();
        // Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа

        objHomePage.isOrderConfirmationTitleDisplayed();

    }

    @Test
    public void orderScooterViaBottomOption() {
        HomePageSamokat objHomePage = new HomePageSamokat(webDriver);
        // нажать нижнюю кнопку "Заказать"
        objHomePage.clickBottomOrderButton();
        // Заполнить форму заказа, часть "Для кого самокат"
        CustomerInformationPageSamokat objOrderPage = new CustomerInformationPageSamokat(webDriver);
        objOrderPage.fillInAndSubmitInfoAboutCustomer(name, surname, address, metroStation, contactNumber);
        // Заполнить форму заказа, часть "Про аренду"
        RentInformationPageSamokat objRentInformationPage = new RentInformationPageSamokat(webDriver);
        objRentInformationPage.fillInAndSubmitInfoAboutRent(date, rentalPeriod, scooterColor);
        // Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа
        boolean orderConfirmationTitleDisplayed = objHomePage.isOrderConfirmationTitleDisplayed();
        Assert.assertTrue("Всплывающее окно с сообщением об успешном создании заказа НЕ появилось", orderConfirmationTitleDisplayed);
    }
}

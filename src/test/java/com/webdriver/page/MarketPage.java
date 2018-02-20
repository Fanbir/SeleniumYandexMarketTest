package com.webdriver.page;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.webdriver.utils.SeleniumWebDrivers.driver;

public class MarketPage extends HomePage {
    private static final Logger logger = LoggerFactory.getLogger(MarketPage.class);

    private static final By electronicsItem = By.xpath(".//*[text()='Электроника']");

    private static final By cityMoscow = By.xpath("//*[@class='header2-menu__text' and text()='Москва']");
    private static final By city = By.xpath("//*[contains(@class,'header2-menu__icon_type_region')]");
    private static final By cityInputField = By.xpath("//input[@placeholder='Укажите другой регион']");
    private static final By cityСhoiceList = By.xpath("//div[@class='region-suggest__list suggest2__content suggest2__content_theme_normal']//strong");
    private static final By cityСonfirmationButton = By.xpath("//*[contains(@class,'region-select-form__continue-with-new')]");

    private static final By searchInMarketFieldElement = By.xpath(".//*[@id='header-search']");
    private static final By searchInMarketButtonElement = By.xpath("//*[contains(text(),'Найти')]/parent::button");
    private static final By finalSearchElement = By.xpath("//div[@class='n-title__text']/h1");

    private static final String cityMOSCOW = "Москва";

    public void selectCityLocalization() {
        logger.info("Выполняется проверка локализации");
        if (driver.findElements(cityMoscow).size() == 0) {
            driver.findElement(city).click();
            driver.findElement(cityInputField).sendKeys(cityMOSCOW);
            driver.findElement(cityСhoiceList).click();
            driver.findElement(cityСonfirmationButton).click();
            logger.info("Местоположение изменено");
        } else {
            logger.info("Местоположение Москва");
        }
    }

    public ElectronicsCatalogPage selectElectronicsCatalog() {
        logger.info("Открытие вкладки 'Электроника' ");
        driver.findElement(electronicsItem).click();
        return new ElectronicsCatalogPage();
    }

    public void insertStringForSearch(String name){
        driver.findElement(searchInMarketFieldElement).sendKeys(name);
    }

    public void clickButtonForSearch() {
        driver.findElement(searchInMarketButtonElement).click();
    }

    public String resultSearch(){
        String name = driver.findElement(finalSearchElement).getText();
        logger.info("Наименование НАЙДЕННОГО элемента " + name + "\n");
        return name;
    }
}

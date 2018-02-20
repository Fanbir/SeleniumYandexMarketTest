package com.webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import static com.webdriver.utils.SeleniumWebDrivers.driver;

public class ElectronicsCatalogPage extends HomePage {
    private static final Logger logger = LoggerFactory.getLogger(ElectronicsCatalogPage.class);

    private static final By priceFromField = By.id("glf-pricefrom-var");
    private static final By tvItem = By.xpath("//a[contains(@class,'catalog-menu__list-item metrika') and text()='Телевизоры']");
    private static final By headphonesItem = By.xpath("//a[contains(@class,'catalog-menu__list-item metrika') and text()='Наушники и Bluetooth-гарнитуры']");
    private static final By filterButtonElement = By.xpath("//a[contains(text(),'Перейти ко всем фильтрам')]");
    private static final By searchButton = By.xpath("//span[@class='button__text'][contains(text(),'Показать подходящие')]/parent::a");
    private static final String element_LIST_XPATH = "//*[contains(@class,'n-snippet-card2__title')]";
    private static final By firstResultElement = By.xpath("//div[contains(@class,'n-snippet-card2__title')]//a");


    public CatalogTvPage clickToTvItem() {
        logger.info("Переход в 'Телевизоры' ");
        driver.findElement(tvItem).click();
        return new CatalogTvPage();
    }

    public  CatalogHeadPhonesPage clickHeadphonesItem() {
        logger.info("Переход в 'Наушники' ");
        driver.findElement(headphonesItem).click();
        return new  CatalogHeadPhonesPage();
    }

    public void goToFullSearch() {
        logger.info("Переход в расширенный поиск");
        driver.findElement(filterButtonElement).click();
    }

    public ElectronicsCatalogPage setPriceFrom(int price) {
        logger.info("Ввод значения 'Цена' - параметр поиска от "+ price + "рублей");
        String value = Integer.toString(price);
        driver.findElement(priceFromField).sendKeys(value);
        return this;
    }

    public void goToSearch() {
        logger.info("Выполнение поиска с применением фильтров");
        driver.findElement(searchButton).click();
    }

    public int getNumOfResults() {
        List<WebElement> TelevisionModelList = driver.findElements(By.xpath(element_LIST_XPATH));
        logger.info("Всего устройств отображено на странице: " + TelevisionModelList.size() + "\n");
        return TelevisionModelList.size();
    }

    public String nameOfFirstResult() {
        String name = driver.findElement(firstResultElement).getText();
        logger.info("Наименование первого элемента списка " + name + "\n");
        return name;
    }

}

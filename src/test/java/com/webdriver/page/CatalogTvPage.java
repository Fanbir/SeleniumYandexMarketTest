package com.webdriver.page;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.webdriver.element.CheckBoxElement.selectCheckBox;
import static com.webdriver.utils.SeleniumWebDrivers.driver;

public class CatalogTvPage extends HomePage {
    private static final Logger logger = LoggerFactory.getLogger(CatalogTvPage.class);

    private static final By lgCheckbox = By.xpath("//label[@class='checkbox__label' and contains(text(), 'LG')]");
    private static final By samsungCheckbox = By.xpath("//label[@class='checkbox__label' and contains(text(), 'Samsung')]");
    private static final By firstResultTvElement = By.xpath("//div[@class='n-snippet-card2__title']//a");
    private static final By searchInMarketTvFieldElement = By.xpath(".//*[@id='header-search']");
    private static final By finalSearchTvElement = By.xpath("//div[@class='n-title__text']/h1");



    public void selectTvLG() {
        logger.info("Выделение чекбокса 'LG' ");
        selectCheckBox(lgCheckbox);
    }

    public void selectTvSamsung() {
        logger.info("Выделение чекбокса 'Samsung' ");
        selectCheckBox(samsungCheckbox);
    }
    public String nameOfFirstTvResult() {
        String name = driver.findElement(firstResultTvElement).getText();
        logger.info("Наименование первого элемента списка " + name + "\n");
        return name;
    }

    public void insertStringForSearch(String name){
        driver.findElement(searchInMarketTvFieldElement).sendKeys(name);
    }

    public String resultSearchTvElement(){
        String name = driver.findElement(finalSearchTvElement).getText();
        logger.info("Наименование НАЙДЕННОГО элемента " + name + "\n");
        return name;
    }
}

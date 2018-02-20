package com.webdriver.page;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.webdriver.element.CheckBoxElement.selectCheckBox;
import static com.webdriver.utils.SeleniumWebDrivers.driver;


public class CatalogHeadPhonesPage extends HomePage{
  private static final Logger logger = LoggerFactory.getLogger(CatalogHeadPhonesPage.class);

  private static final By beatsCheckbox = By.xpath("//label[@class='checkbox__label' and contains(text(), 'Beats')]");
  private static final By firstResultHeadphonesElement = By.xpath("//div[@class='n-snippet-cell2__title']//a");
  private static final By searchInMarketHeadPhonesFieldElement = By.xpath(".//*[@id='header-search']");
  private static final By finalSearchHeadElement = By.xpath("//div[@class='n-title__text']/h1");
  private static final By searchInMarketHeadPhonesdElement = By.xpath("//div[@class='suggest2-group-title__content' and contains(text(),'товар')]//ancestor::div[@class='suggest2__group']//ul//a");

  public void selectHeadPhonesBeats() {
    logger.info("Выделение чекбокса 'Beats' ");
    selectCheckBox(beatsCheckbox);
  }

  public String nameOfFirstHeadResult() {
    String name = driver.findElement(firstResultHeadphonesElement).getText();
    logger.info("Наименование первого элемента списка " + name + "\n");
    return name;
  }

  public String editHeadPhonesTitle() {
    logger.info("Редактирование тайтла перед поиском");
    String refactorName = nameOfFirstHeadResult();
    String newName = refactorName.replaceFirst("Наушники ", "");
    return newName;
  }

  public void insertStringForSearch(String name) {
    driver.findElement(searchInMarketHeadPhonesFieldElement).sendKeys(name);
    driver.findElement(searchInMarketHeadPhonesdElement).isDisplayed();

  }

  public String resultSearchHeadPhones(){
    String name = driver.findElement(finalSearchHeadElement).getText();
    logger.info("Наименование НАЙДЕННОГО элемента " + name + "\n");
    return name;
  }
}

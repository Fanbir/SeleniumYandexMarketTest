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
  private static final By headphonesItem = By.xpath("//div[@class='catalog-menu__list']/a[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited'][contains(text(),'Наушники')]");
  private static final By filterButtonElement = By.xpath("//a[contains(text(),'Перейти ко всем фильтрам')]");
  private static final By searchButton = By.xpath("//span[@class='button__text'][contains(text(),'Показать подходящие')]/parent::a");
  private static final String element_LIST_XPATH = "//div[@class='price']";
  private static final By sortedElementCostButton = By.xpath("//*[contains(@class,'n-filter-sorter__link') and text()='по цене']");
  private static final By setElementVeiwButton = By.xpath("//*[contains(@class,'radio-button__radio_side_right')]");

  public CatalogTvPage clickToTvItem() {
    logger.info("Переход в 'Телевизоры' ");
    driver.findElement(tvItem).click();
    return new CatalogTvPage();
  }

  public CatalogHeadPhonesPage clickHeadphonesItem() {
    logger.info("Переход в 'Наушники' ");
    driver.findElement(headphonesItem).click();
    return new CatalogHeadPhonesPage();
  }

  public void goToFullSearch() {
    logger.info("Переход в расширенный поиск");
    driver.findElement(filterButtonElement).click();
  }

  public ElectronicsCatalogPage setPriceFrom(int price) {
    logger.info("Ввод значения 'Цена' - параметр поиска от " + price + "рублей");
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

  public void sortedElementCost() {
    logger.info("Клик на фильтр сортировки");
    driver.findElement(sortedElementCostButton).click();
  }

  public void setElementVeiw() {
    logger.info("Отображение элеменентов списком");
    driver.findElement(setElementVeiwButton).click();
  }
}

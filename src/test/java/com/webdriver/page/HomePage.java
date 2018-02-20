package com.webdriver.page;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.webdriver.utils.SeleniumWebDrivers.driver;

public class HomePage {
  private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

  private static final By market = By.xpath("//*[@data-id='market']");

  public void openPage(String pageUrl) {
    logger.info("Выполняется переход по адресу " + pageUrl);
    driver.get(pageUrl);
  }

  public MarketPage navigateToMarket() {
    logger.info("Выполняется переход в раздел Маркет");
    driver.findElement(market).click();
    return new MarketPage();
  }
}

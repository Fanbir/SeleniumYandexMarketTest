package com.webdriver.page;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.webdriver.element.CheckBoxElement.selectCheckBox;

public class CatalogTvPage extends HomePage {
  private static final Logger logger = LoggerFactory.getLogger(CatalogTvPage.class);

  private static final By lgCheckbox = By.xpath("//label[@class='checkbox__label' and contains(text(), 'LG')]");
  private static final By samsungCheckbox = By.xpath("//label[@class='checkbox__label' and contains(text(), 'Samsung')]");

  public void selectTvLG() {
    logger.info("Выделение чекбокса 'LG' ");
    selectCheckBox(lgCheckbox);
  }

  public void selectTvSamsung() {
    logger.info("Выделение чекбокса 'Samsung' ");
    selectCheckBox(samsungCheckbox);
  }
}

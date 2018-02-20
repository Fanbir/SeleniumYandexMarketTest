package com.webdriver.page;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.webdriver.element.CheckBoxElement.selectCheckBox;


public class CatalogHeadPhonesPage extends HomePage{
  private static final Logger logger = LoggerFactory.getLogger(CatalogHeadPhonesPage.class);

  private static final By beatsCheckbox = By.xpath("//label[@class='checkbox__label' and contains(text(), 'Beats')]");

  public void selectHeadPhonesBeats() {
    logger.info("Выделение чекбокса 'Beats' ");
    selectCheckBox(beatsCheckbox);
  }

}

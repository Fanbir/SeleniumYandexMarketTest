package com.webdriver.test;

import com.webdriver.page.*;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MarketTest extends BaseTest {

    private HomePage homePage;
    private MarketPage marketPage;
    private CatalogTvPage catalogTvPage;
    private CatalogHeadPhonesPage catalogHeadPhonesPage;
    private ElectronicsCatalogPage electronicsPage;

    private static final int RESULT_COUNT_LIST = 12;
    private static final int PRICE_TV_FROM = 20000;
    private static final int PRICE_HEADPHONES_FROM = 5000;
    private static final String YANDEX_PAGE_URL = "https://yandex.ru/";

    @BeforeTest
    public void SetUp() {
        super.SetUp();
        homePage = new HomePage();
        marketPage = new MarketPage();
        electronicsPage = new ElectronicsCatalogPage();
        catalogTvPage = new CatalogTvPage();
        catalogHeadPhonesPage = new CatalogHeadPhonesPage();
    }

    @Test
    public void yandexMarketTvTest() {
        homePage.openPage(YANDEX_PAGE_URL);
        homePage.navigateToMarket();

        marketPage.selectCityLocalization();
        marketPage.selectElectronicsCatalog();

        electronicsPage.clickToTvItem();
        electronicsPage.goToFullSearch();
        electronicsPage.setPriceFrom(PRICE_TV_FROM);

        catalogTvPage.selectTvLG();
        catalogTvPage.selectTvSamsung();

        electronicsPage.goToSearch();

        Assert.assertTrue("Найдено 12 результатов", electronicsPage.getNumOfResults()==RESULT_COUNT_LIST);

        String nameFirstElement = electronicsPage.nameOfFirstResult();
        marketPage.insertStringForSearch(nameFirstElement);
        marketPage.clickButtonForSearch();

        Assert.assertEquals(marketPage.resultSearch(),nameFirstElement);
    }


    @Test
    public void yandexMarketHeadPhonesTest() {
        homePage.openPage(YANDEX_PAGE_URL);
        homePage.navigateToMarket();
        marketPage.selectCityLocalization();
        marketPage.selectElectronicsCatalog();

        electronicsPage.clickHeadphonesItem();
        electronicsPage.goToFullSearch();
        electronicsPage.setPriceFrom(PRICE_HEADPHONES_FROM);

        catalogHeadPhonesPage.selectHeadPhonesBeats();

        electronicsPage.goToSearch();
        Assert.assertTrue("Найдено 12 результатов", electronicsPage.getNumOfResults()==RESULT_COUNT_LIST);

        String nameFirstElement = electronicsPage.nameOfFirstResult();
        marketPage.insertStringForSearch(nameFirstElement);
        marketPage.clickButtonForSearch();

        Assert.assertEquals(marketPage.resultSearch(),nameFirstElement);
    }

}

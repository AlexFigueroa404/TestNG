package com.claro.test;

import com.claro.pages.MenuBarPage;
import com.claro.testcomponents.BaseTest;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MenuBarPageTest extends BaseTest {

 MenuBarPage menuBarPage;
  WebDriver driver;

  String postpaidUrl = "https://www.claro.com.sv/personas/servicios/servicios-moviles/pospago/";
  String fullClaroUrl = "https://www.claro.com.sv/personas/servicios/full-claro/";

  String helpUrl = "https://asistencia.claro.com.sv/soporte/Soporte/";
  String  cellPhonesUrl = "https://tiendaenlinea.claro.com.sv/categories/prepago/celulares?utm_source=menuheader&utm_medium=celulares&utm_campaign=portal/";
  String storeUrl = "https://tiendaenlinea.claro.com.sv/categories/prepago/celulares";



  @BeforeClass
  public void setup() throws IOException {
    driver = initializeDriver();
    menuBarPage = new MenuBarPage(driver);
    driver.get("https://www.claro.com.sv/personas/");
    menuBarPage.closeCookieModal();
  }


  @Test(priority = 0)
  void validateMenuBar(){
   boolean isMainMenuVisible = menuBarPage.isMainMenuVisible();
    Assert.assertTrue(isMainMenuVisible);

  }

//  @Test
//  void validateSubMenu(){
//    boolean isSubMenuVisible = menuBarPage.hoverAndWaitForSubMenu(driver);
//    Assert.assertTrue(isSubMenuVisible);
//  }

  @Test(priority = 1)
  void validatePostpaidLink(){
    menuBarPage.closeCookieModal();
    menuBarPage.hoverAndClickServices();
    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals(currentUrl, postpaidUrl);
    menuBarPage.clickOnHomeLink();
  }

  @Test(priority = 2)
  void validateBenefitsLink(){
    menuBarPage.closeCookieModal();
    menuBarPage.hoverAndClickBenefits();
    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals(currentUrl, fullClaroUrl);
    menuBarPage.clickOnHomeLink();
  }

  @Test(priority = 4)
  void validateHelpLink(){
    menuBarPage.closeCookieModal();
    menuBarPage.hoverAndClickHelp();

    menuBarPage.switchToTab(1, driver);
    Assert.assertEquals(driver.getCurrentUrl(), helpUrl);
    menuBarPage.clickOnHomeLinkHelp();
    menuBarPage.switchToTab(0, driver);

  }


  @Test(priority = 3)
  void validateCellPhonesLink(){
    menuBarPage.closeCookieModal();
    menuBarPage.hoverAndClickStore();
    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals(currentUrl, cellPhonesUrl);
    menuBarPage.clickOnHomeLinkStore();
  }




}

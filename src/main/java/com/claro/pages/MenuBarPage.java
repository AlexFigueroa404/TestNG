package com.claro.pages;

import com.claro.abstractcomponent.AbstractComponent;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuBarPage extends AbstractComponent {

  WebDriver driver;

  @FindBy(how = How.XPATH, using = "//ul[@class='mainMenu noSearchBar']")
  private WebElement menuBar;

  @FindBy(how = How.XPATH, using = "(//ul[@class='subMenu'])[1]")
  private WebElement subMenu;

  @FindBy(how = How.XPATH, using = "//a[normalize-space()='Servicios']")
  private WebElement servicesLink;

  @FindBy(how = How.XPATH, using = "//span[normalize-space()=\"Full Claro\"]")
  private WebElement fullClaroLink;

  @FindBy(how = How.XPATH, using = "//a[normalize-space()=\"Tienda\"]")
  private WebElement storeLink;

  @FindBy(how = How.XPATH, using = "//span[normalize-space()=\"Celulares\"]")
  private WebElement cellPhonesLink;

  @FindBy(how = How.XPATH, using = "//a[@url=\"http://asistencia.claro.com.sv/\"]")
  private WebElement helpLink;

  @FindBy(how = How.XPATH, using = "//a[@class=\"linkCat\"][normalize-space()=\"Soporte\"]")
  private WebElement helpSubMenuLink;

  @FindBy(how = How.XPATH, using = "//a[@url='/personas/servicios/servicios-moviles/pospago/']//span[contains(text(),'Pospago')]")
  private WebElement postpaidLink;


  @FindBy(how = How.XPATH, using = "(//img[@title='Logo Claro'])[1]")
  private WebElement HomeLink;


  @FindBy(how = How.XPATH, using = "//a[@href='https://www.claro.com.sv/personas/' and @class='nav--logo']")
  private WebElement HomeLinkStore;


  @FindBy(how = How.XPATH, using = "//a[@class='header__logo']")
  private WebElement HomeLinkHelp;

  @FindBy(how = How.XPATH, using = "//a[@url=\"/personas/beneficios/\"]")
  private WebElement BenefitsLink;


  public MenuBarPage(WebDriver driver) {
    super(driver);
  }


  public boolean isMainMenuVisible() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000)); // Wait for 2 seconds
    try {
      WebElement menu = wait.until(ExpectedConditions.visibilityOf(menuBar));
      return menu.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  public boolean hoverAndWaitForSubMenu(WebDriver driver) {
    Actions actions = new Actions(driver);
    actions.moveToElement(servicesLink).perform();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000)); // Wait for 2 seconds
    try {
      WebElement subMenuElement = wait.until(ExpectedConditions.visibilityOf(subMenu));
      return subMenuElement.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  public void clickOnPostpaidLink() {
    postpaidLink.click();
  }


  public void clickOnStoreLink() {
    storeLink.click();
  }

  public void hoverAndClickServices() {
    navbarHover(servicesLink, postpaidLink);
  }

  public void hoverAndClickBenefits() {
    navbarHover(BenefitsLink, fullClaroLink);
  }

  public void hoverAndClickHelp() {
    navbarHover(helpLink, helpSubMenuLink);
  }

  public void hoverAndClickStore() {
    navbarHover(storeLink, cellPhonesLink);
  }

  public void clickOnHomeLink() {
    HomeLink.click();
  }

  public void clickOnHomeLinkStore() {
    HomeLinkStore.click();
  }

  public void clickOnHomeLinkHelp() {
    HomeLinkHelp.click();
  }


  public void switchToTab(int tabIndex, WebDriver driver) {
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    if (tabIndex < tabs.size()) {
      driver.switchTo().window(tabs.get(tabIndex));
    } else {
      throw new IllegalArgumentException("Índice de pestaña inválido: " + tabIndex);
    }
  }


}

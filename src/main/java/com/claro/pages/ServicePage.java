package com.claro.pages;

import com.claro.abstractcomponent.AbstractComponent;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServicePage extends AbstractComponent {

  WebDriver driver;
  Actions actions;


  @FindBy(id = "themaCookieModal")
  WebElement cookieModal;

  @FindBy(xpath = "//button[@class='fancybox-button fancybox-close-small']")
  private WebElement closeCookieModalButton;
  @FindBy(how = How.XPATH, using = "//a[normalize-space()='Tienda']")
  private WebElement servicesLink;

  @FindBy(how = How.XPATH, using = "(//ul[@class='mainMenu noSearchBar'])[1]")
  private WebElement mainMenu;


  @FindBy(how = How.XPATH, using = "(//span[contains(text(),'Pospago')])[1]")
  private WebElement postpaidSpan;

  @FindAll(@FindBy(how = How.XPATH, using = "(//a[normalize-space()='Servicios'])[1]//following-sibling::ul//a"))
  private List<WebElement> allServiceLinks;

  public ServicePage(WebDriver driver) {

    super(driver);
  }

  public void clickOnPostpaid() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
    wait.until(ExpectedConditions.visibilityOf(postpaidSpan));
    wait.until(ExpectedConditions.elementToBeClickable(postpaidSpan));

    postpaidSpan.click();
  }

  public void hoverOverServicesLink() {

    actions = new Actions(driver);
    actions.moveToElement(mainMenu).build().perform();
    actions.moveToElement(postpaidSpan).build().perform();


  }


  public void closeCookieModal(){
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
      wait.until(ExpectedConditions.or(
          ExpectedConditions.visibilityOf(cookieModal),
          ExpectedConditions.invisibilityOf(cookieModal)
      ));
      if (cookieModal.isDisplayed()) {
        closeCookieModalButton.click();
        wait.until(ExpectedConditions.invisibilityOf(cookieModal));
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }


}

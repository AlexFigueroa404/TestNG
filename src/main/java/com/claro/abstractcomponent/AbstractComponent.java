package com.claro.abstractcomponent;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

  WebDriver driver;

  @FindBy(id = "themaCookieModal")
  WebElement cookieModal;

  @FindBy(xpath = "//button[@class='fancybox-button fancybox-close-small']")
  private WebElement closeCookieModalButton;

  public AbstractComponent(WebDriver driver){

    this.driver = driver;
    PageFactory.initElements(driver, this);
  }


  public void waitForVisual(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      System.out.println("Error: " + e.getMessage());
    }
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


  public boolean navbarHover(WebElement element, WebElement submenu) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement navbarElement = wait.until(ExpectedConditions.visibilityOf(element));
      Actions actions = new Actions(driver);
      actions.moveToElement(navbarElement).perform();
      WebElement submenuElement = wait.until(ExpectedConditions.elementToBeClickable(submenu));
      submenuElement.click();
      waitForVisual(2000);
      return true;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return false;
    }
  }


}

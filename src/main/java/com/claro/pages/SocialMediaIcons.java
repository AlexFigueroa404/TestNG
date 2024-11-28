package com.claro.pages;

import com.claro.abstractcomponent.AbstractComponent;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SocialMediaIcons extends AbstractComponent {

  WebDriver driver;

  // no se ha actualizado la url
  @FindBy(how = How.XPATH, using = "//a[@href='https://twitter.com/claroelsalvador']")
  private WebElement XIcon;





  @FindBy(how = How.XPATH, using = "//a[@href='https://www.facebook.com/claroelsalvador']']")
  private WebElement facebookIcon;

  // no tiene el certificado de seguridad

  @FindBy(how = How.XPATH, using = "//a[@href='http://instagram.com/claroelsalvador']")
  private WebElement instagramIcon;

  // Path diferente a los anteriores

  @FindBy(how = How.XPATH, using = "//(//a[@class='icoRs'])[4]")
  private WebElement whatsAppIcon;

  @FindBy(how = How.XPATH, using = "//div[@class='footerRS fRSBtns fRSBtnsLibRec']//dl")
  private WebElement footer;








  public SocialMediaIcons(WebDriver driver) {

    super(driver);
  }

  public void clickOnFacebookIcon() {
    // Click on Facebook icon
  }

  public void clickOnXIcon() {
    XIcon.click();

  }

  public void cickOnInstagramIcon() {
    // Click on Instagram icon
  }

  public void clickOnWhatsAppIcon() {
    // Click on WhatsApp icon
  }



  public void scrollToFooter() {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
      wait.until(ExpectedConditions.visibilityOf(footer));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
    } catch (Exception e) {

    }
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

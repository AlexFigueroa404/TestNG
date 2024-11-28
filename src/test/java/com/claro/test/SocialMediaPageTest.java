package com.claro.test;

import com.claro.pages.SocialMediaIcons;
import com.claro.testcomponents.BaseTest;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialMediaPageTest extends BaseTest {

  SocialMediaIcons socialMediaIcons;

  WebDriver driver;

  @BeforeClass
  public void setup() throws IOException {

    driver = initializeDriver();
    driver.get("https://www.claro.com.sv/personas/");
    socialMediaIcons = new SocialMediaIcons(driver);

    socialMediaIcons.closeCookieModal();

  }


  @Test
  void clickOnXIcon() {

    String expectedUrl = "https://x.com/claroelsalvador";
    socialMediaIcons.clickOnXIcon();

    socialMediaIcons.switchToTab(1, driver);
    socialMediaIcons.waitForVisual(2000);
    driver.close();
    socialMediaIcons.switchToTab(0, driver);

    Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

  }


}

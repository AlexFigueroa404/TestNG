package com.claro.pages;

import com.claro.abstractcomponent.AbstractComponent;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractComponent {

  String homePageUrl = "https://www.claro.com.co/personas/";

  WebDriver driver;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void goToHomePage() {
    System.out.println("Navigating to Home Page");

    driver.get(homePageUrl);

  }

}

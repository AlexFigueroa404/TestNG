package com.claro.pages;

import com.claro.abstractcomponent.AbstractComponent;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultPage extends AbstractComponent {
  WebDriver driver;

  // without how

  @FindBy(how = How.XPATH, using = "//i[@aria-label='Buscador']")
  private WebElement SearchIcon;

  @FindBy(how = How.XPATH, using = "//input[@id='searchInput']")
  private WebElement SearchInput;

  @FindBy(how = How.XPATH, using = "//input[@value='Buscar']")
  private WebElement SearchButton;


  public SearchResultPage(WebDriver driver) {
    super(driver);
  }

  public void clickOnSearchIcon() {
    SearchIcon.click();
  }

  public void clickOnSearchButton() {
    SearchButton.click();
  }


  public void enterSearchText(String text){

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      String s = String.valueOf(c);
      SearchInput.sendKeys(s);
//      Thread.sleep(100); // muy peligroso
    // puntos de estilo x]D
    }

  }


  public void PressEnterKey(){
    SearchInput.sendKeys(Keys.ENTER);
  }



  public void perform (boolean useEnterKey) {
    if (useEnterKey) {
      PressEnterKey();
    } else {
      clickOnSearchButton();
    }
  }





}

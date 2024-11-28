package com.claro.test;

import com.claro.testcomponents.BaseTest;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.claro.pages.SearchResultPage;


public class SearchResultPageTest extends BaseTest {

  private static final String SEARCH_TERM = "Internet";

  SearchResultPage searchResultPage;
  WebDriver driver;


  @BeforeClass
  public void setup() throws IOException {
    driver = initializeDriver();
    searchResultPage = new SearchResultPage(driver);

    driver.get("https://www.claro.com.sv/personas/");
    searchResultPage.closeCookieModal();


  }

  @Test
  void validateSearchFunctionalityWithEnterKey() {

    searchResultPage.clickOnSearchIcon();
    searchResultPage.enterSearchText(SEARCH_TERM);
    searchResultPage.perform(true); // true para usar la tecla enter

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlContains(SEARCH_TERM));

    Assert.assertTrue(driver.getCurrentUrl().matches(".*q=" + SEARCH_TERM + ".*"),
        "La URL no contiene el término de búsqueda esperado.");

    System.out.println("URL: " + driver.getCurrentUrl());

    searchResultPage.waitForVisual(2000);
  }


  @Test
  void validateSearchFunctionalityWithSearchButton() {
    searchResultPage.clickOnSearchIcon();
    searchResultPage.enterSearchText(SEARCH_TERM);
    searchResultPage.perform(
        false); // false para usar el boton de busqueda en lugar de la key enter

    Assert.assertTrue(driver.getCurrentUrl().matches(".*q=" + SEARCH_TERM + ".*"),
        "La URL no contiene el término de búsqueda esperado.");

  }


//  @Test
//  void validateSearchResultSize() {
//
//    List<WebElement> allSearchResults = new ArrayList<>();
//    int allResultCount = 0;
//    int currentResultCount;
//
//// Selector del botón "Siguiente"
//    By nextButton = By.xpath("//i[@class='ico-chevron-right']");
//
//    do {
//      // Obtener resultados de la página actual
//      List<WebElement> currentPageResults = driver.findElements(
//          By.xpath("//div[@class='cSearchAdvResultBox']"));
//      allSearchResults.addAll(
//          currentPageResults); // Agregar los resultados de la página actual a la lista acumulativa
//
//      currentResultCount = currentPageResults.size();
//      allResultCount += currentResultCount;
//
//      // Imprimir resultados encontrados en la página actual
//      System.out.println("Resultados en esta página: " + currentPageResults.size());
//
//      // Intentar hacer clic en el botón "Siguiente"
//      try {
//        List<WebElement> nextBtnList = driver.findElements(nextButton);
//        if (!nextBtnList.isEmpty()) {
//          WebElement nextBtn = nextBtnList.getFirst();
//          if (nextBtn.isDisplayed() && nextBtn.isEnabled()) {
//            nextBtn.click();
//
//            // Esperar a que se cargue la nueva página
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//            wait.until(ExpectedConditions.stalenessOf(currentPageResults.get(0)));
//          } else {
//            break; // Salir del bucle si el botón "Siguiente" no está habilitado
//          }
//        } else {
//          System.out.println("No hay más páginas, se encontraron todos los resultados.");
//          break;
//        }
//      } catch (NoSuchElementException e) {
//        System.out.println(
//            "No se encontró el botón 'Siguiente', posiblemente sea la última página.");
//        break;
//      }
//    } while (true);
//
//    WebElement element = driver.findElement(By.xpath("//p[@id='textoBusqueda']"));
//    String searchResultText = element.getText();
//
//    Pattern pattern = Pattern.compile("de\\s+(\\d+)");
//    Matcher matcher = pattern.matcher(searchResultText);
//
//    if (matcher.find()) {
//      int totalResults = Integer.parseInt(matcher.group(1));
//      Assert.assertEquals(allResultCount, totalResults,
//          "La cantidad de resultados no coincide con la cantidad total de resultados.");
//    } else {
//      Assert.fail("No se encontró la cantidad total de resultados.");
//
//
//    }
//
//  }

  @Test
  void validateSearchResultAreRelevant() {
    List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='cSearchAdvResultBox']"));
    System.out.println("Cantidad de resultados: " + searchResults.size());

    for (WebElement searchResult : searchResults) {
      String searchResultText = searchResult.getText();

      // Validamos que el texto del resultado contiene la palabra buscada
      Assert.assertTrue(
          searchResultText.toLowerCase().contains(SEARCH_TERM.toLowerCase()),
          "El resultado no contiene la palabra buscada: " + searchResult + ". Resultado: " + searchResultText
      );
  }
}}


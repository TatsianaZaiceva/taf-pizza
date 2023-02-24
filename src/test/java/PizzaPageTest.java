
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PizzaPageTest {

    WebDriver driver;

    @BeforeEach
    public void into() {
        driver = new ChromeDriver();
        driver.get(PizzaPage.URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void testTerraPizzaAddPizzaMargaritaToCart() {
        driver.findElement(By.xpath(PizzaPage.BTN_CLOSE_COOKIE)).click();
        driver.findElement(By.xpath(PizzaPage.BTN_MENU)).click();
        driver.findElement(By.xpath(PizzaPage.BTN_MENU_PIZZA)).click();
        String PizzaMargarita = driver.findElement(By.xpath(PizzaPage.PIZZA_MARGARITA)).getText();
        String PizzaMargaritaType = driver.findElement(By.xpath(PizzaPage.PIZZA_MARGARITA_TYPE)).getText();
        String PizzaMargaritaSize = driver.findElement(By.xpath(PizzaPage.PIZZA_MARGARITA_SIZE)).getText();
        String Expected = PizzaMargarita + " " + PizzaMargaritaType + " " + PizzaMargaritaSize;
        System.out.println(Expected);

        driver.findElement(By.xpath(PizzaPage.PIZZA_MARGARITA_BTN_CART)).click();
        driver.findElement(By.xpath(PizzaPage.BTN_CART)).click();

        List<WebElement> Cart = driver.findElements(By.xpath(PizzaPage.PRODUCTS_IN_CART));
        String PizzaMargaritaInCart = Cart.get(0).getText();
        String PizzaMargaritaSizeInCart = driver.findElements(By.xpath(PizzaPage.PIZZA_MARGARITA_SIZE_IN_CART)).get(0).getText();
        /*System.out.println(PizzaMargaritaInCart);
        System.out.println(PizzaMargaritaSizeInCart);*/
        String Actual = PizzaMargaritaInCart + " (" + PizzaMargaritaSizeInCart + ")";
        System.out.println(Actual);
        Assertions.assertEquals(Expected, Actual);
    }
    @Test
    public void testTerrapizzaAddMargaritaAndDrink(){
        driver.findElement(By.xpath(PizzaPage.BTN_CLOSE_COOKIE)).click();
        driver.findElement(By.xpath(PizzaPage.BTN_MENU)).click();
        driver.findElement(By.xpath(PizzaPage.BTN_MENU_PIZZA)).click();
        String PizzaMargarita = driver.findElement(By.xpath(PizzaPage.PIZZA_MARGARITA)).getText();
        //driver.findElement(By.xpath(PizzaPage.PIZZA_MARGARITA_SIZE)).click();
        driver.findElement(By.xpath(PizzaPage.PIZZA_MARGARITA_BTN_CART)).click();
        driver.findElement(By.xpath(PizzaPage.BTN_MENU_BAR)).click();
        driver.findElement(By.xpath(PizzaPage.BAR_LATTE_BTN_CART)).click();
        driver.findElement(By.xpath(PizzaPage.BTN_CART)).click();
        List<WebElement> Cart = driver.findElements(By.xpath(PizzaPage.PRODUCTS_IN_CART));
        Assertions.assertEquals(PizzaMargarita, Cart.get(0).getText());
        Assertions.assertEquals("Латте", Cart.get(1).getText());
    }
   @AfterEach
   public void out() {
        driver.quit();
   }
}


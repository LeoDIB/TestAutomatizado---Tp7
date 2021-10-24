package testautomatico;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class VerificarMensajeUsuarioInexistenteTest {

	private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
	
}
    @Test
    public void verificarMensajeUsuarioInexistente() throws InterruptedException {
  

      driver.findElement(By.id("login2")).click();
      
      driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
      
      {
        WebElement element = driver.findElement(By.id("login2"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
      }
      
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
      {
        WebElement element = driver.findElement(By.tagName("body"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element, 0, 0).perform();
      }
      
     
      
      driver.findElement(By.id("loginusername")).click();
      driver.findElement(By.id("loginusername")).sendKeys("mariagomez@gmail.com");
      driver.findElement(By.id("loginpassword")).click();
      driver.findElement(By.id("loginpassword")).sendKeys("gom2913");
      driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
      Thread.sleep(5000);
      Alert alert = driver.switchTo().alert();
      assertThat(alert.getText(), is("User does not exist."));
      Thread.sleep(5000);
      alert.accept();
     
    }
    
    @AfterEach
    public void tearDown() {
          driver.quit();
      
}
}
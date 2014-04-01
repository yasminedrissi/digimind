
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestD {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://195.154.170.223/d/beta/connect.do";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testD() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("mrahmoun@digimind.com");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Pass2014");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.findElement(By.cssSelector("span.tab-name")).click();
    driver.findElement(By.linkText("What")).click();
    driver.findElement(By.cssSelector("div.big")).click();
    driver.findElement(By.cssSelector("button.close")).click();
    driver.findElement(By.xpath("(//input[@name=''])[3]")).click();
    driver.findElement(By.xpath("//div[@id='analytics-container']/div/div/div/form/ul/li[3]/div/ul/li[2]/label")).click();
    driver.findElement(By.xpath("//div[@id='__sizzle__']/div[3]/ul/li[2]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

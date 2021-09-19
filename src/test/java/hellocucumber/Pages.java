package hellocucumber;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pages {

  private WebDriver driver;

  public String mainWindow;

  public static By EMAIL = By.id("email_create");
  public static By SIGNIN = By.cssSelector(".login");
  public static By CREATE_ACCOUNt = By.id("SubmitCreate");

  public static By FIRST_NAME = By.id("customer_firstname");
  public static By LAST_NAME = By.id("customer_lastname");
  public static By PASSWORD = By.id("passwd");
  public static By DAYS = By.id("days");
  public static By MONTHS = By.id("months");
  public static By YEARS = By.id("years");
  public static By NEWSLETTER = By.id("newsletter");
  public static By OFFERS = By.id("optin");

  public static By ADDRESS_FIRST_NAME = By.id("firstname");
  public static By ADDRESS_LAST_NAME = By.id("lastname");
  public static By ADDRESS_COMPANY = By.id("company");
  public static By ADDRESS_ADDRESS = By.id("address1");
  public static By ADDRESS_ADDRESS2 = By.id("address2");
  public static By ADDRESS_CITY = By.id("city");
  public static By ADDRESS_STATE = By.id("id_state");
  public static By ADDRESS_POST = By.id("postcode");
  public static By ADDRESS_COUNTRY = By.id("id_country");
  public static By ADDRESS_OTHER = By.id("other");
  public static By ADDRESS_HOME_PHONE = By.id("phone");
  public static By ADDRESS_MOBILE_PHONE = By.id("phone_mobile");
  public static By ADDRESS_ALIAS = By.id("alias");

  public static By REGISTER = By.id("submitAccount");
  public static By ACCOUNT = By.cssSelector(".account");

  public static By ERROR = By.xpath(
    "//p[contains(text(), 'There are 8 errors')]"
  );

  public static By JMETER = By.cssSelector("img[src='Jmeter720.png']");

  public Pages() {
    System.out.println(System.getenv("CHROMEDRIVER"));
    String chromedriver = System.getenv("CHROMEDRIVER") + "\\chromedriver.exe";
    System.setProperty(
      "webdriver.chrome.driver",
      chromedriver
    );
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.addArguments("incognito");
    this.driver = new ChromeDriver(options);
  }

  public void iOpenPage(String page) {
    driver.get(page);
  }

  public void iWaitNSecond(int second) {
    second = second * 1000;
    // convert
    long longSecond = Long.valueOf(String.valueOf(second));
    try {
      Thread.sleep(longSecond);
    } catch (InterruptedException e) {
      throw new RuntimeException("iWaitNSecond failed", e);
    }
  }

  public void theUrlIsLoaded(String url) {
    WebDriverWait wait = new WebDriverWait(
      driver,
      Duration.ofSeconds(10).getSeconds()
    );
    wait.until(
      driver ->
        ((JavascriptExecutor) driver).executeScript(
            "return document.readyState"
          )
          .equals("complete")
    );
  }

  public void quitBrowser() {
    driver.quit();
  }

  public void iClickOnSignIn() {
    driver.findElement(SIGNIN).click();
  }

  public void iSelectGender(String gender) {
    if (gender.equals("Mr")) {
      driver.findElement(By.cssSelector("label[for='id_gender1']")).click();
    }
    if (gender.equals("Mrs")) {
      driver.findElement(By.cssSelector("label[for='id_gender2']")).click();
    }
  }

  public void iPasteMyEmail(String email) {
    Random rand = new Random(System.currentTimeMillis());
    driver.findElement(EMAIL).sendKeys(rand.nextInt() + email);
  }

  public void iCreateAccount() {
    driver.findElement(CREATE_ACCOUNt).click();
  }

  public void iFillTheData() {
    new WebDriverWait(driver, 10)
      .until(
        ExpectedConditions.elementToBeClickable(
          By.cssSelector("label[for='id_gender1']")
        )
      )
      .click();
    driver.findElement(FIRST_NAME).sendKeys("Sam");
    driver.findElement(LAST_NAME).sendKeys("Fisher");
    driver.findElement(PASSWORD).sendKeys("admin12345");

    Select select = new Select(driver.findElement(DAYS));
    select.selectByIndex(1);
    select = new Select(driver.findElement(MONTHS));
    select.selectByIndex(1);
    select = new Select(driver.findElement(YEARS));
    select.selectByIndex(1);

    driver.findElement(NEWSLETTER).click();
    driver.findElement(OFFERS).click();

    driver.findElement(ADDRESS_FIRST_NAME).clear();
    driver.findElement(ADDRESS_FIRST_NAME).sendKeys("Sam");
    driver.findElement(ADDRESS_LAST_NAME).clear();
    driver.findElement(ADDRESS_LAST_NAME).sendKeys("Fisher");
    driver.findElement(ADDRESS_COMPANY).sendKeys("Ubisoft");
    driver.findElement(ADDRESS_ADDRESS).sendKeys("Maple street");
    driver.findElement(ADDRESS_ADDRESS2).sendKeys("Mean Street");
    driver.findElement(ADDRESS_CITY).sendKeys("California");

    select = new Select(driver.findElement(ADDRESS_STATE));
    select.selectByIndex(5);

    driver.findElement(ADDRESS_POST).sendKeys("12345");

    select = new Select(driver.findElement(ADDRESS_COUNTRY));
    select.selectByIndex(1);

    driver.findElement(ADDRESS_OTHER).sendKeys("My other thing");
    driver.findElement(ADDRESS_HOME_PHONE).sendKeys("+36783777");
    driver.findElement(ADDRESS_MOBILE_PHONE).sendKeys("+369876799");

    driver.findElement(ADDRESS_ALIAS).clear();
    driver.findElement(ADDRESS_ALIAS).sendKeys("alias@alias.com");
  }

  public void iClickRegisterButoon() {
    driver.findElement(REGISTER).click();
  }

  public void iCheckAccount() {
    new WebDriverWait(driver, 10)
    .until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT));
    assertTrue(driver.findElement(ACCOUNT).getText().equals("Sam Fisher"));
  }

  public void iFillTheMissingData() {
    new WebDriverWait(driver, 10)
    .until(
        ExpectedConditions.elementToBeClickable(
          By.cssSelector("label[for='id_gender1']")
        )
      );

    Select select = new Select(driver.findElement(DAYS));
    select.selectByIndex(1);
    select = new Select(driver.findElement(MONTHS));
    select.selectByIndex(1);
    select = new Select(driver.findElement(YEARS));
    select.selectByIndex(1);

    driver.findElement(NEWSLETTER).click();
    driver.findElement(OFFERS).click();

    driver.findElement(ADDRESS_COMPANY).sendKeys("Ubisoft");

    driver.findElement(ADDRESS_ADDRESS2).sendKeys("Mean Street");

    driver.findElement(ADDRESS_OTHER).sendKeys("My other thing");
    driver.findElement(ADDRESS_HOME_PHONE).sendKeys("+36783777");

    driver.findElement(ADDRESS_ALIAS).clear();
  }

  public void errorDisplayed() {
    driver.findElement(ERROR);
  }

  public void scrollDownTillIFrame() {
    final WebElement element = driver.findElement(
      By.xpath(
        "//*[contains(text(), 'iFrame will not show if you have adBlock extension enabled')]"
      )
    );
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView(true);",
        element
      );
  }

  public void scrollUpTillHeader() {
    final WebElement element = driver.findElement(
      By.cssSelector(".menu-block")
    );
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView(true);",
        element
      );
  }

  public void iScrollDownToTheBottom() {
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }

  public void iSwtichToIFrame() {
    mainWindow = driver.getWindowHandle();
    driver.switchTo().frame("a077aa5e");
  }

  public void iSwitchBackToMainFrame() {
    driver.switchTo().defaultContent();
  }

  public void iClickToTheImage() {
    driver.findElement(JMETER).click();
  }

  public void iCheckTheTabs() {
    ArrayList<String> tabHandles = new ArrayList<String>(
      driver.getWindowHandles()
    );
    for (String eachHandle : tabHandles) {
      driver.switchTo().window(eachHandle);
      if (
        driver
          .getTitle()
          .equals("Selenium Live Project: FREE Real Time Project for Practice")
      ) {
        driver.close();
        driver.switchTo().window(mainWindow);
        return;
      }
    }
    assertTrue(false);
  }

  public void iHoover() {
    final Actions action = new Actions(driver);
    action
      .moveToElement(driver.findElement(By.cssSelector(".gf-menu .item118")))
      .moveToElement((driver.findElement(By.cssSelector(".gf-menu .item121"))))
      .click()
      .build()
      .perform();
  }

  public void iWaitUntilButtonIsDisplayed() {
    new WebDriverWait(driver, 60)
    .until(
        ExpectedConditions.visibilityOf(
          driver.findElement(
            By.xpath("//button[contains (@style, 'color: rgb(255, 255, 255)')]")
          )
        )
      );
  }

  public void moveMose() {
    int width = driver.manage().window().getSize().getWidth();
    int height = driver.manage().window().getSize().getHeight();
    Robot robot;
    try {
      try {
        robot = new Robot();
        Thread.sleep(1000);
        for (int i = (height / 2); i > 110; i -= 50) {
          robot.mouseMove(width / 2, i);
          Thread.sleep(50);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } catch (AWTException e) {
      e.printStackTrace();
    }
  }

  public void iScrollDownByPixel() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement myElement = new WebDriverWait(driver, 2)
    .until(
        ExpectedConditions.visibilityOfElementLocated(
          By.cssSelector(".bottom-footer")
        )
      );

    boolean isDisplayed = false;

    int contentHeight =
      (
        (Number) js.executeScript("return document.body.scrollHeight")
      ).intValue();

    contentHeight = contentHeight / 100;

    while ((contentHeight > 0) && isDisplayed == false) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      isDisplayed =
        (Boolean) ((JavascriptExecutor) driver).executeScript(
            "var elem = arguments[0],                 " +
            "  box = elem.getBoundingClientRect(),    " +
            "  cx = box.left + box.width / 2,         " +
            "  cy = box.top + box.height / 2,         " +
            "  e = document.elementFromPoint(cx, cy); " +
            "for (; e; e = e.parentElement) {         " +
            "  if (e === elem)                        " +
            "    return true;                         " +
            "}                                        " +
            "return false;                            ",
            myElement
          );
      js.executeScript("javascript:window.scrollBy(0,100);");
      contentHeight--;
    }
  }
}

package steps;
import java.net.URL;
import java.time.Duration;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyProductStepDefinitions {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @Given("User is on the home screen")
    public void user_is_on_the_home_screen() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5556")
                .setPlatformName("Android")
                .setPlatformVersion("12.0")
                .setDeviceName("Android Emulator")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.saucelabs.mydemoapp.android")
                .setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity")
                .setNoReset(true)
                .setAppWaitForLaunch(false);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @When("User selects Sauce Lab Back Packs product")
    public void user_selects_product() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement backPack = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Sauce Lab Back Packs']"));
        backPack.click();
    }

    @And("User selects Blue color")
    public void user_selects_color() {
        WebElement colour = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Blue color']"));
        colour.click();
    }

    @And("User increases the item quantity")
    public void user_increases_item_quantity() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Add to cart\"))")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement quantity = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Increase item quantity']"));
        quantity.click();
    }

    @And("User adds the product to the cart")
    public void user_adds_product_to_cart() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Add to cart\"))")).click();
        WebElement cart = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Displays number of items in your cart']"));
        cart.click();
    }

    @And("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt")));
        checkout.click();
    }

    @Then("User should be redirected to the login page")
    public void user_should_be_redirected_to_login_page() {
        driver.quit();
    }
}
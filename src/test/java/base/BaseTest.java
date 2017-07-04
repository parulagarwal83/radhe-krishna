package base;

import models.ui.Config;
import models.ui.TestData;
import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import util.MyTailerListener;
import util.YamlReader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chandanjavaregowda on 03/04/17.
 */
public class BaseTest {
    protected TestData data;
    protected Config config;
    private static DesiredCapabilities capabilities;
    public static WebDriver driver;

    public BaseTest() {
        config = new YamlReader("config.yml").readConfig();
        data = new YamlReader("data.yml").readTestData();
    }

    @BeforeSuite
    public void setUp() {
        try {
            TailerListener listener = new MyTailerListener();
            Tailer tailer = Tailer.create(new File("/var/lib/logs/server-log.out"), listener, 1);

            Thread thread = new Thread(tailer);
            thread.setDaemon(true);
            thread.start();

            setBrowser();
            setCaps();
            driver = new RemoteWebDriver(new URL(config.getNode_url()), capabilities);
            if (config.isBring_to_front()) {
                bringToForeground();
            }
            if (config.isMaximize()) {
                maximize();
            }
            driver.get(data.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private BaseTest bringToForeground() {
        String currentWindowHandle = driver.getWindowHandle();
        ((JavascriptExecutor) driver).executeScript("alert('Test')");
        driver.switchTo().alert().accept();
        driver.switchTo().window(currentWindowHandle);
        return this;
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

    private BaseTest setCaps() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--kiosk");     //      maximizes screen
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return this;
    }

    private BaseTest setBrowser() {
        if (config.getBrowser().equals("chrome")) {
            capabilities = DesiredCapabilities.chrome();
        }
        return this;
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

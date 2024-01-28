package base.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil extends DataProviders {
   public WebDriver driver;
   private String browser , testURL;
   private int implicitWait;

    @BeforeMethod
    public void setupDriverAndOpenUrl(){
        readConfigFile("src/test/resources/config.properties");
        setupDriver();
//       driver.manage().timeouts().implicitlyWait(Duration.from(Duration.ofSeconds(implicitWait)));
        driver.get(testURL);
    }

    private void readConfigFile(String fullPathToFile){
        try{
            FileInputStream fileInputStream = new FileInputStream(fullPathToFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            testURL = properties.getProperty("url");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("wait"));
        }catch (IOException e){
            System.out.println(e);
        }
    }
    private void setupDriver(){
        switch(browser){
            case "firefox":
                driver = setupFireFoxDriver();
                break;
            case "edge":
                driver = setupEdgeDriver();
                break;
            default:
                driver = setupChromeDriver();
                break;
        }
    }
    private WebDriver setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return driver = new ChromeDriver();
    }
    private WebDriver setupFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return driver = new FirefoxDriver();
    }
    private WebDriver setupEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        return driver = new EdgeDriver();
    }

    @AfterMethod

    public void tearDown(){
        driver.quit();
    }
}

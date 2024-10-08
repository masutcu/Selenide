package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    public static WebDriver driver;


    public static WebDriver getDriver(){

        if(driver==null) {

            switch (ConfigReader.getProperty("browser")){

                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "safari":
                    driver = new SafariDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                default:
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }




    public static void closeDriver(){

        if(driver!=null) {
            driver.close();
            driver=null;
        }
    }
}

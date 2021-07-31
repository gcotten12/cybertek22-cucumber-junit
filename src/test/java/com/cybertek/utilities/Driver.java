package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {}
    /*
    Making oue driver instance private so this is not reachable outside of the class
    Also we make it static because we are going to be using it in a static method, and
    we want it run before everything else
     */
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if(driverPool.get() == null) {

            synchronized (Driver.class){
            String browserType = ConfigurationReader.getProperty("browser");

            switch(browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    // driver.manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup(); // internet explorer
                    driverPool.set(new InternetExplorerDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
            }

        }

        return driverPool.get();

    }

    public static void closeDriver() {
        if(driverPool.get()!=null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}

package lesson2.lesson3base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import lesson2.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.IOUtils.close;


public class BaseTest {
    // метод, который будет открывать наше приложение на телефоне
    public MainPage openApp(String device) {
        WebDriver driver = null;
        try {
            driver = getAndroidDriver(device);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Opps, we have problems with URL for driver!");
        }
        // устанавливаем драйвер для selenide
        WebDriverRunner.setWebDriver(driver);
        // возвращаем главную страницу для будущей работы с ней в тесте
        return new MainPage();
    }

//    public static WebDriver getAndroidDriver() throws MalformedURLException {
//        // устанавливаем capabilities
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Pixel");
//        capabilities.setCapability("platformVersion", "11");
//        capabilities.setCapability("udid", "emulator-5554");
//        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("app", "/Users/arish/Downloads/Android-NativeDemoApp-0.2.1.apk");
//        // папка для сохранения скриншотов selenide
//        Configuration.reportsFolder = "screenshots/actual";
//        // устанавливаем и открываем приложение
//        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }

    @AfterClass
    public void setDown(){
        try {
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // добавили значение String device
    public  AndroidDriver getAndroidDriver(String device) throws MalformedURLException {
        // устанавливаем capabilities.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        // указываем для appium на каком девайсе хотим запускать тест.
        switch (device){
            case "pixel 10":
                capabilities.setCapability("udid", "emulator-5554");
                break;
            case "pixel 11":
                capabilities.setCapability("udid", "emulator-5556");
                break;
        }
        capabilities.setCapability("app", "/Users/arish/Downloads/Android-NativeDemoApp-0.2.1.apk");

        // папка для сохранения скриншотов selenide.
        Configuration.reportsFolder = "screenshots/actual";

        // устанавливаем и открываем приложение. !!! Указываем URL Grid !!!
        return new AndroidDriver(new URL("http://0.0.0.0:4444/wd/hub"), capabilities);
    }
}




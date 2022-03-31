package lesson2;

import com.github.romankh3.image.comparison.ImageComparisonUtil;
import io.appium.java_client.MobileBy;
import lesson2.lesson3base.BaseTest;
import org.testng.annotations.Test;

import java.awt.image.BufferedImage;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;


public class ScreenShootHelper extends BaseTest {
    @Test
    public void createScreen(){
        openApp("pixel 10");
        File actualScreenshot = $(MobileBy.AccessibilityId("Home-screen")).screenshot();
    }
}

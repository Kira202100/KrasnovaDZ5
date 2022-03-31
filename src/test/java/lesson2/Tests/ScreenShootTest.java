package lesson2.Tests;

import lesson2.lesson3base.BaseTest;
import org.testng.annotations.Test;

public class ScreenShootTest extends BaseTest {
    @Test
    public void checkMainPageScreen(){
        openApp("pixel 10")
                .checkScreenshot();

    }
}

package lesson2.Tests;

import lesson2.lesson3base.BaseTest;
import lesson2.listeners.AllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class ScreenShootTestFail extends BaseTest {
    @Test
    public void checkMainPageScreenShot (){
        openApp("pixel 11")
                .checkFailScreenshot();
    }
}

package lesson2.Tests;

import lesson2.lesson3base.BaseTest;
import org.testng.annotations.Test;

public class MySecondTest extends BaseTest {
    @Test
    public void checkEmptyEmail() {
        openApp("pixel 10")
                .clickLoginMenuButton()
                .clickLoginButton()
                .checkLoginErrorText("Please enter a valid email address");


    }
}

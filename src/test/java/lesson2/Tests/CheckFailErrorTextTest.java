package lesson2.Tests;

import io.qameta.allure.Description;
import lesson2.lesson3base.BaseTest;
import lesson2.listeners.AllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(AllureListener.class)
public class CheckFailErrorTextTest extends BaseTest {
    public static final String VALID_EMAIL_ADDRESS = "Please enter a valid email address";

    @Test
    @Description("Проверяем поведения теста при падении проверки сообщения об ошибке валидного email")
    public void CheckFailEmptyEmail() {
        openApp("pixel 10")
                .clickLoginMenuButton()
                .checkLoginErrorText(VALID_EMAIL_ADDRESS);
    }

}

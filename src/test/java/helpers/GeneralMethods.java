package helpers;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class GeneralMethods {

    public static void removeBanner() {
        executeJavaScript("$('#start-popup').remove()");
        executeJavaScript("$('.modal-backdrop').remove()");
    }

    public static void closeBanner() {
        executeJavaScript("$('#careers_friend div a img').click()");
    }


    public static void setBannerCookie() {
        open("/image/catalog/favicon.png");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("start-modal-shown", "1"));
    }
}
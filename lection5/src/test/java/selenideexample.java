import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class selenideexample {

    @BeforeClass
    void init(){
        Configuration.baseUrl = "https://www.simbirsoft.com/";
        Configuration.browserSize = "1920x2100";
        Configuration.pageLoadTimeout = 60000; // 60 секунд
        Configuration.timeout = 40000; // 40 секунд
        Configuration.headless = false; // Если нужно headless-режим, установи true
    }

    @Test
    public void test1() {
        open("https://www.simbirsoft.com/");
        $(By.cssSelector("[data-gclick='showModalFeedback']"))
                .shouldBe(visible)
                .shouldHave(text("Написать нам"))
                .click();
        $x("//*[@class='fmo-parent']//*[@class='fb-modal-default']").shouldBe(visible);
        sleep(5000);
    }

    @Test
    public void test2() {
        open("https://www.simbirsoft.com/");
        $(By.xpath("//*[contains(@class,'gh-nav-item--about')]"))
                .shouldHave(text("О нас"))
                .hover();
        $(By.linkText("Контакты"))
                .click();
        $(By.xpath("//h1"))
                .shouldHave(text("Контакты"))
                .shouldBe(visible);
        webdriver().shouldHave(url("https://www.simbirsoft.com/contacts/"));
        sleep(5000);
    }

    @Test
    public void testBlogButtonNavigation() {
        // Открыть главную страницу
        open("https://www.simbirsoft.com/");

        // Найти кнопку "Блог" по XPath
        $x("/html/body/div[1]/div/div[2]/div[5]/a")
                .shouldBe(visible) // Проверить, что кнопка видима
                .click();          // Кликнуть по кнопке

        // Проверить, что произошёл переход на страницу блога
        String expectedUrl = "https://www.simbirsoft.com/blog/";
        webdriver().shouldHave(url(expectedUrl)); // Проверить URL
    }
}


package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {

    @BeforeAll
    static void beforeAll() {
        System.setProperty("env", System.getProperty("env", "local"));

        WebConfig webConfig = ConfigFactory.create(WebConfig.class);

        Configuration.browser = webConfig.getBrowser();
        Configuration.browserVersion = webConfig.version();
        Configuration.remote = webConfig.remoteUrl();
    }

    @Test
    @Tag("example")
    void simpleTest() {
        SelenideElement banner = $(".fc-consent-root");

        open("https://demoqa.com/text-box");

        if (banner.isDisplayed()) {
            banner.$(byText("Consent")).click();
        }

        $(".text-center").shouldHave(Condition.text("Text Box"));
    }
}

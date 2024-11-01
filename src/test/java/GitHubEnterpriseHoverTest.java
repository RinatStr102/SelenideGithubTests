import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GitHubEnterpriseHoverTest {

    @BeforeAll
    public static void setUp () {
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    public void hoverOverSolutionsAndVerifyEnterprisePage () {
        open ("/");

        $$(".HeaderMenu-item").findBy(text("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"), text("developer platform"));
    }
}

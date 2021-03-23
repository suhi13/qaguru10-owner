package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

    public class BaseSteps extends BaseTest {

        @Step("Open Base URL")
        public void openBaseUrl() {
            open("https://github.com");
        }

        @Step("Search repository {repositoryName}")
        public void searchRepository(String repositoryName) {
            $(".header-search-input").as("Search field").setValue(repositoryName).submit();
        }

        @Step("Open {repositoryName} repository in search results")
        public void openRepository(String repositoryName) {
            $(By.linkText(repositoryName)).click();
        }

        @Step("Make sure '{elementName}' element is displayed in left-side menu")
        public void checkElementDisplay(String elementName) {
            $(withText(elementName)).shouldBe(Condition.visible);
        }
}
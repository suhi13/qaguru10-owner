package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest extends BaseTest {

    private final static String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "suhi13/y_qaguru";

    @Test
    @Owner("Yuliia Sukhova")
    @Tags({@Tag("web"), @Tag("Critical")})
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Base URL", value = BASE_URL)
    @Story("User can see menu elements")
    @Feature("Navigation")
    @DisplayName("Check 'Issue' element display")
    public void checkIssueDisplayTest() {
        BaseSteps steps = new BaseSteps();

        steps.openBaseUrl();
        steps.searchRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.checkElementDisplay("Issues");
    }
}
package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class LabelsTest {

    @Test
    @Feature("Pull-request в репозитории")
    @Story("Проверка pull-requests")
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Проверка наличия pull-request в репозитории")
    public void testStaticLabels () {

    }

    @Test
    public void testDynamicLabels () {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Проверка наличия pull-request в репозитории")
        );

        Allure.feature("Pull-request в репозитории (2)");
        Allure.story("Проверка pull-requests (2)");
        Allure.label("Owner", "eroshenkoam");
        Allure.label("Severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}

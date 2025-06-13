package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static tests.TestForAllure.*;

public class AttachmentStepsTests {
    @Test
    void lambdaAttachmentsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываю страницу github в интернете", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });
        step("Ищу окно для ввода текста и кликаю по нему", () -> {
            searchInputText.shouldBe(visible, interactable).click();
        });
        step("В строке запроса ввожу имя репозитория: " + REPOSITORY + " и отправляю запрос", () -> {
            queryString.shouldBe(visible, interactable).setValue(REPOSITORY);
            queryString.submit();
        });
        step("В найденных результатах нахожу нужный репозиторий: " + REPOSITORY + " и кликаю по нему", () -> {
            linkText.shouldBe(visible, interactable).click();
        });
        step("На открывшейся странице с репозиторием ищу tab pullRequests и кликаю по нему", () -> {
            pullRequestTab.shouldBe(visible, interactable).click();
        });
        step("Проверяю, что на странице с pullRequests есть пулл-реквест с номером: #" + PULL_REQUEST_NUMBER, () -> {
            resultText.should(exist);
        });
    }

    @Test
    void annotatedAttachmentsTest () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();
        webSteps.openMainPage();
        webSteps.searchForRepository();
        webSteps.clickOnRepositoryLink(REPOSITORY);
        webSteps.openPullRequestsTab();
        webSteps.shouldSeePullRequestWithNumber();
        webSteps.takeScreenshot();
    }
}

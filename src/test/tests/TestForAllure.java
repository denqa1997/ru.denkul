package tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;

import static io.qameta.allure.Allure.step;

import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForAllure {
    public static final SelenideElement searchInputText = $(".header-search-button");
    public static final SelenideElement queryString = $("#query-builder-test");
    public static final SelenideElement linkText = $(By.linkText("eroshenkoam/allure-example"));
    public static final SelenideElement pullRequestTab = $("#pull-requests-tab");
    public static final SelenideElement resultText = $(withText("#91"));
    static final String REPOSITORY = "eroshenkoam/allure-example";
    static final int PULL_REQUEST_NUMBER = 91;


    @Test
    void easyTestSelenideSeacrhOnGitHub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        openSite();
        searchText();
        queryString.shouldBe(visible, interactable).setValue(REPOSITORY);
        queryString.submit();
        linkText.shouldBe(visible, interactable).click();
        pullRequestTab.shouldBe(visible, interactable).click();
        resultText.should(exist);
    }

    @Test
    void selenideSearchTestOnGitHubWithLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываю страницу github в интернете", () -> {
            open("https://github.com");
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
    void testAnnotatedStep () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();

        webSteps.openMainPage();
        webSteps.searchForRepository();
        webSteps.clickOnRepositoryLink(REPOSITORY);
        webSteps.openPullRequestsTab();
        webSteps.shouldSeePullRequestWithNumber();
    }

    @Step("Ищу окно для ввода текста")
    public void searchText() {
        searchInputText.shouldBe(visible, interactable).click();
    }

    @Step("Открываю страницу github  в интернет")
    public void openSite() {
        open("https://github.com");
    }


}


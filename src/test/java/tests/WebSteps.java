package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static tests.TestForAllure.*;

public class WebSteps {
    @Step ("Открываю страницу github в интернете")
    public void openMainPage () {
        open("https://github.com");
    }
    @Step ("Ищу окно для ввода текста и кликаю по нему, " +
            "в строке запроса ввожу имя репозитория: " + REPOSITORY + " и отправляю запрос")
    public void searchForRepository () {
        searchInputText.shouldBe(visible, interactable).click();
        queryString.shouldBe(visible, interactable).setValue(REPOSITORY);
        queryString.submit();
    }

    @Step ("В найденных результатах нахожу нужный репозиторий: " + REPOSITORY + " и кликаю по нему")
    public void clickOnRepositoryLink (String repo) {
        linkText.shouldBe(visible, interactable).click();
    }

    @Step ("На открывшейся странице с репозиторием ищу tab pullRequests и кликаю по нему")
    public void openPullRequestsTab () {
        pullRequestTab.shouldBe(visible, interactable).click();
    }

    @Step ("Проверяю, что на странице с pullRequests есть пулл-реквест с номером: #" + PULL_REQUEST_NUMBER)
    public void shouldSeePullRequestWithNumber () {
        resultText.should(exist);
    }

    @Attachment (value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot () {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

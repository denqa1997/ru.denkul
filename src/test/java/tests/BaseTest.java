package tests;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
@Test
void openSite() throws InterruptedException {

    SelenideElement takeATable = $x("//span[@class='label' and contains(text(), 'Заказать столик')]");
    SelenideElement selectCountOfGuests = $x("//select[@name='reservation[guests_count]']");
    SelenideElement selectDateOfVisit = $x("//select[@name='visit_date_select']");
    SelenideElement visitTime = $x("//select[@name = 'reservation[visit_date]']");
    SelenideElement nameOfGuest = $x("//input[@name = 'reservation[name]']");
    SelenideElement telephone = $x("//input[@name='reservation[phone]']");
    SelenideElement comment = $x("//textarea[@name='reservation[comment]']");
    SelenideElement acceptForPersonalData = $x("//input[@name='pd_consent']");
    SelenideElement confirm = $x("//input[@type= 'submit']");

//    Set<SelenideElement> selectors = new HashSet<>();
//    selectors.add(takeATable);
//    final SelenideElement advertisment = $x("//div[ contains(text(), 'Планируете к нам пойти?')]/following-sibling::div[@class='btn red solid big upcase close no']");
//    final SelenideElement but = $x("//div[@class = 'icon-menu size-6 bg-white']");
//    open("https://cafekamenka.ru/tihaya");
//    advertisment.shouldBe(interactable).click();
//    but.shouldBe(interactable).click();
//    ElementsCollection menusItem = $$x("//li//a");
//    for (SelenideElement element: menusItem) {
//        element.shouldBe(interactable).click();
//    }
//    advertisment.shouldBe(appear);
//    File pdf = advertisment.download();

    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String address = faker.address().streetAddress();
    System.out.println(firstName);


//    open("https://cafekamenka.ru/tihaya");
//    takeATable.click();
//    selectCountOfGuests.selectOption(3);
//    selectDateOfVisit.selectOption(2);
//    visitTime.selectOption(2);
//    nameOfGuest.setValue("Test Test");
//    telephone.setValue("9000000000");
//    comment.setValue("Отдельный столик");
//    acceptForPersonalData.setSelected(false);
//    confirm.click();
      }
}
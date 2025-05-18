import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class baseTest {
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


    open("https://cafekamenka.ru/tihaya");
    takeATable.click();
    selectCountOfGuests.selectOption(3);
    selectDateOfVisit.selectOption(2);
    visitTime.selectOption(2);
    nameOfGuest.setValue("Test Test");
    telephone.setValue("9000000000");
    comment.setValue("Отдельный столик");
    acceptForPersonalData.setSelected(false);
    confirm.click();
      }
}
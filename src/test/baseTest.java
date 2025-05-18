import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class baseTest {
@Test
void openSite() {
    open("https://cafekamenka.ru/tihaya");
    SelenideElement takeATable = $x("//span[@class='label' and contains(text(), 'Заказать столик')]");
    takeATable.click();
    }
}
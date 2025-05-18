import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class baseTest {
@Test
void openSite() {
    open("https://cafekamenka.ru/");
    }
}
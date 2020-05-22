package integrationtests.cucumbers.googleSearch;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasicPage;

import java.util.Set;

import static com.codeborne.selenide.Selenide.*;

public class GoogleSearch {
    public ChromeDriver driver;
    BasicPage basicPage = new BasicPage();

    @When("^Открываем браузер Google Chrome$")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/diana.sadikova/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("^Закрываем браузер$")
    public void close() {
        driver.quit();
    }

    @When("^Вводим адрес поисковой страницы \"(.*)\"$")
    public void url(String url) {
        driver.get(url);
    }

    @Then("^Отображается название вкладки \"(.*)\"$")
    public void title(String nameTitle) {
        Assert.assertEquals(driver.getTitle(), nameTitle);
    }

    @When("Выполняем запрос \"(.*)\" в поисковой строке браузера$")
    public void searchInquiry(String inquiry) {
//        $(By.name("q")).val(inquiry).pressEnter();
        driver.findElement(By.name("q")).sendKeys(inquiry);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @When("Изменяем запроса на \"(.*)\" и нажимаем кнопку поиска")
    public void editInquiry(String inquiry) {
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys(inquiry);
        driver.findElement(By.cssSelector(".Tg7LZd")).click();
    }

    @When("Очищаем поле запроса$")
    public void closeInquiry() {
        driver.findElement(By.cssSelector(".rzyADb")).click();
    }

//    @Then("^Проверяем отображение заголовка первого найденного результата \"(.*)\"$")
//    public void searchResult(String nameResult) {
//        Assert.assertEquals(driver.findElements(By.cssSelector(".LC20lb")), nameResult);
////        ElementsCollection visible = $$(".DKV0Md").filter(Condition.visible);
////        SelenideElement result = visible.get(0);
////        result.shouldHave(Condition.exactText(nameResult));
//    }

    @When("^Выбираем первый найденый результат поиска$")
    public void clickInquiry() {
        driver.findElement(By.cssSelector(".LC20lb")).click();
    }

    @When("^Закрываем всплывающее окно с текстом \"(.*)\"$")
    public void closeCookiesPopup(String textPopup) {
        if (basicPage.checkTextExist(textPopup)) {
            basicPage.clickButtonSpan("Хочу!");
        }
    }

//    @When("^Закрываем всплывающее окно$")
//    public void closePopup() {
////        driver.findElement(By.cssSelector(".bubble__close")).click();
//        String originalWindow = driver.getWindowHandle();
//        // получаем набор дескрипторов текущих открытых окон
//        final Set<String> oldWindowsSet = driver.getWindowHandles();
//
//        // ожидаем открытия и получаем дескриптор нового окна
//        String newWindow = (new WebDriverWait(driver, 10))
//                .until(new ExpectedCondition<String>() {
//                           public String apply(WebDriver driver) {
//                               // получаем новый набор дескрипторов, включающий уже и новое окно
//                               Set<String> newWindowsSet = driver.getWindowHandles();
//                               // получаем дескриптор нового окна
//                               newWindowsSet.removeAll(oldWindowsSet);
//                               return newWindowsSet.size() > 0 ?
//                                       newWindowsSet.iterator().next() : null;
//                           }
//                       }
//                );
//
//        // переключает фокус для будущих команд драйвера в окно с заданным дескриптором
//        driver.switchTo().window(newWindow);
//
//        System.out.println("New window title: " + driver.getTitle());
//        driver.close();
//
//        driver.switchTo().window(originalWindow);
//        System.out.println("Old window title: " + driver.getTitle());
//    }
}

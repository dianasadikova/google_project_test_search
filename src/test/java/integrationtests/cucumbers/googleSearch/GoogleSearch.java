package integrationtests.cucumbers.googleSearch;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public ChromeDriver driver;

    @When("^Открываем браузер Google Chrome$")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/diana.sadikova/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("^Закрываем браузер$")
    public void close() {
        driver.quit();
    }

    @When("^Вводим адрес поисковой страницы Google$")
    public void url() {
        driver.get("https://www.google.com/");
    }

    @Then("^Отображается название вкладки \"(.*)\"$")
    public void title(String nameTitle) {
        Assert.assertEquals(driver.getTitle(), nameTitle);
    }

    @When("Выполняем запрос \"(.*)\" в поисковой строке браузера$")
    public void searchInquiry(String inquiry) {
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
}

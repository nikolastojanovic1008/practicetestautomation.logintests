package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage extends BaseTest {

    WebDriver driver;
    WebElement testLoginTestButton;


    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTestLoginTestButton() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    public void clickOnTestLoginPageButton() {
        getTestLoginTestButton().click();
    }
}

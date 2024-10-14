package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://practicetestautomation.com/");
    }


    @Test
    public void userCanLogIn(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());

    }
    @Test
    public void userCanNotLogInWithInvalidUsername(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("non student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(), "Your username is invalid!");


    }
    @Test
    public void userCanNotLogInWithInvalidPassword(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("admin");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(), "Your password is invalid!");


    }
    @Test
    public void userCanNotLogInWithBlankUsernameField(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(), "Your username is invalid!");


    }
    @Test
    public void userCanNotLogInWithBlankPasswordField(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(), "Your password is invalid!");


    }
    @Test
    public void userCanNotLogInWithBlankUsernameAndPasswordField(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(), "Your username is invalid!");

    }
    @Test
    public void userCanLogOutAfterSuccesfullLogIn(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        profilePage.clickOnLogOutButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertFalse(loginPage.getError().isDisplayed());
    }
    @Test
    public void userCanLogInAgainAfterLogOut(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        profilePage.clickOnLogOutButton();
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());

    }
}

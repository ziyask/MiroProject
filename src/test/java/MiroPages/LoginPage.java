package MiroPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver = null;

    @FindBy(how = How.NAME, using = "email")
    private WebElement username;

    @FindBy(how = How.NAME, using = "password")
    private WebElement password;

    @FindBy(how = How.CLASS_NAME, using = "signup__submit")
    private WebElement signInButton;

    //This initElements method will create all WebElements
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Set username in textbox
    public void setUserName(String strUserName){
        username.clear();
        username.sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
        password.clear();
        password.sendKeys(strPassword);
    }

    //Click on SignIn button
    public void clickSignInButton(){
        signInButton.click();
    }

}

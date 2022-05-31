package MiroPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    private WebDriver driver = null;

    @FindBy(how = How.XPATH, using = "//div[text()='New board']")
    private WebElement newboard;

    @FindBy(how = How.XPATH, using = "//span[@tooltip='Board']//parent::div")
    private WebElement openboard;

    //This initElements method will create all WebElements
    public DashBoardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Create new board
    public void createNewBoard(){
        newboard.click();
    }

    //Open new board
    public void openNewBoard(){
        openboard.click();
    }
}

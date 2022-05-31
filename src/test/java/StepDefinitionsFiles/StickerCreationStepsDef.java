package StepDefinitionsFiles;

import MiroPages.CanvasBoardPage;
import MiroPages.DashBoardPage;
import MiroPages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.AShotAPIUtils;
import utilities.ConfigFileReader;

import java.io.IOException;
import java.time.Duration;

public class StickerCreationStepsDef {

    public WebDriver webDriver = null;
    public LoginPage miroLoginPage = null;
    public DashBoardPage dashBoardPage = null;
    public CanvasBoardPage canvasBoardPage = null;
    public AShotAPIUtils aShotAPIUtils = null;
    public ConfigFileReader configFileReader = null;

    @Before
    public void beforeScenario() {
        configFileReader = new ConfigFileReader();
        webDriver = WebDriverManager.chromedriver().create();
        webDriver.get(configFileReader.getApplicationUrl());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicitlyWait()));
    }

    @After
    public void afterScenario() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Given("^As a User1 I login into service$")
    public void as_a_user1_i_login_into_service() {
        try {
            miroLoginPage = new LoginPage(webDriver);
            miroLoginPage.setUserName(configFileReader.getUserNameFor("user1_id"));
            miroLoginPage.setPassword(configFileReader.getPasswordFor("user1_password"));
            miroLoginPage.clickSignInButton();
        } catch (Exception ex) {

        }
    }

    @And("^I create a board with the name Board$")
    public void i_create_a_board_with_the_name() throws InterruptedException {
        dashBoardPage = new DashBoardPage(webDriver);
        dashBoardPage.createNewBoard();
        canvasBoardPage = new CanvasBoardPage(webDriver);
        canvasBoardPage.editBoardHeaderTitle();
        canvasBoardPage.enterTitleNameas(configFileReader.getBoardName());
    }

    @Then("^As a User1 I open Board and create there sticker, by using left toolbar$")
    public void asAUserIOpenBoardAndCreateThereStickerStickerWidgetByUsingLeftToolbar() throws InterruptedException, IOException {
        canvasBoardPage.moreToolsLink();
        canvasBoardPage.clickStickerAndEmojiLink();
        canvasBoardPage.selectSticker();
    }

    @And("^As a User1 I invite User2 to Board by using Share button on the top right corner$")
    public void asAUserIInviteUserToBoardByUsingShareButtonOnTheTopRightCorner() throws IOException {
        canvasBoardPage.clickOnShareButton();
        canvasBoardPage.enterInviteEmailID(configFileReader.getUserNameFor("user2_id"));
        canvasBoardPage.clickOnSendInvitationButton();
        canvasBoardPage.clickOnPresentationModeButton();
    }

    @Then("^As a User2 I login into service and open Board$")
    public void asAUserILoginIntoServiceAndOpenBoard() throws InterruptedException {
        webDriver.navigate().to(configFileReader.getApplicationUrl());
        miroLoginPage.setUserName(configFileReader.getUserNameFor("user2_id"));
        miroLoginPage.setPassword(configFileReader.getPasswordFor("user2_password"));
        miroLoginPage.clickSignInButton();
        dashBoardPage.openNewBoard();
    }

    @And("^As a User2 I should see created sticker on Board$")
    public void asAUserIShouldSeeCreatedStickerOnBoard() throws IOException {
        canvasBoardPage.clickOnPresentationModeButton();
        aShotAPIUtils = new AShotAPIUtils();
        aShotAPIUtils.captureImage(webDriver, configFileReader.getActualImageFilePath());
        Assert.assertTrue(aShotAPIUtils.compareImage(configFileReader.getExpectedImageFilePath(), configFileReader.getActualImageFilePath()));
    }
}

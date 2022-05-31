package MiroPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CanvasBoardPage {

    private WebDriver driver = null;
    private WebDriverWait webDriverWait = null;
    private Actions actions = null;

    @FindBy(how = How.XPATH, using = "//div[@data-testid='board-header__title']")
    private WebElement editBoardHeaderTitle;

    @FindBy(how = How.XPATH, using = "//input[@ng-model='modal.board.title']")
    private WebElement inputBoardHeaderTitle;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='template-picker__close-button']")
    private WebElement closeTemplate;

    @FindBy(how = How.XPATH, using = "//div[@tooltip='more tools']")
    private WebElement moreToolsLink;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'EMOJI_ICONS')]")
    private WebElement stickerandEmojiLink;

    @FindBy(how = How.XPATH, using = "//div[contains(@data-testid,'breadcrumbs__stickers')]")
    private WebElement StickerBreadCrumb;

    @FindBy(how = How.XPATH, using = "//img[@src='https://mirostatic.com/app/static/09f9a8f09cc6787c.svg']//parent::div")
    private WebElement heartSticker;

    @FindBy(how = How.XPATH, using = "//button[contains(@data-testid,'share-board-button')]")
    private WebElement shareButton;

    @FindBy(how = How.XPATH, using = "//span[contains(@class,'share-content__emails-editor-interactive-placeholder')]")
    private WebElement getEmailTextBox;

    @FindBy(how = How.XPATH, using = "//input[contains(@data-testid,'emails-editor-input')]")
    private WebElement emailTextBox;

    @FindBy(how = How.XPATH, using = "//button[contains(@data-testid,'shareMdButtonSend')]")
    private WebElement sendInvitationButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@aria-label,'Presentation mode')]")
    private WebElement presentationModeButton;


    //This initElements method will create all WebElements
    public CanvasBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        actions = new Actions(this.driver);
    }

    //To Click on Edit board settings
    public void editBoardHeaderTitle() {
        closeTemplate.click();
        editBoardHeaderTitle.click();
    }

    //Enter Title name as Board
    public void enterTitleNameas(String boardName) {
        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
        keydown.perform();
        inputBoardHeaderTitle.sendKeys(Keys.BACK_SPACE);
        inputBoardHeaderTitle.sendKeys(boardName + Keys.ENTER);
    }

    //To CLick MoreTools link
    public void moreToolsLink() {
        moreToolsLink.click();
    }

    //To Click on Sticker and Emoji link
    public void clickStickerAndEmojiLink() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(stickerandEmojiLink));
        driver.switchTo().activeElement().sendKeys("Sticker");
        //actions.sendKeys(Keys.chord(""));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(stickerandEmojiLink));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", stickerandEmojiLink);
        stickerandEmojiLink.click();
    }

    //Select Sticker
    public void selectSticker() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(StickerBreadCrumb));
        StickerBreadCrumb.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(heartSticker));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", heartSticker);
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(heartSticker).click().build().perform();
        driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        moreToolsLink.click();
    }

    //Click on Share button
    public void clickOnShareButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(shareButton));
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(shareButton).click().build().perform();
        //shareButton.click();
    }

    //Enter invite email id
    public void enterInviteEmailID(String emaiID) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getEmailTextBox));
        getEmailTextBox.click();
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(emailTextBox).click().build().perform();
        emailTextBox.sendKeys(emaiID + Keys.ENTER);
    }

    //Click on Send Invitation button
    public void clickOnSendInvitationButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendInvitationButton));
        sendInvitationButton.click();
    }

    //Click on Presentation Mode to capture the screenshot
    public void clickOnPresentationModeButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(presentationModeButton));
        try {
            presentationModeButton.click();
        } catch (WebDriverException webDriverException) {
            webDriverException.printStackTrace();
        }

    }
}

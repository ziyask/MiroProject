package utilities;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.comparison.PointsMarkupPolicy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AShotAPIUtils {

    Screenshot screenshot = null;
    String imagePath = System.getProperty("user.dir");

    public void captureImage(WebDriver driver, String filPath) throws IOException {
        String imageFilePath = imagePath + filPath;
        screenshot = new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "png", new File(imageFilePath));
    }

    public boolean compareImage(String expectedImagePath, String actualImagePath) throws IOException {
        File expectedImageFilePath = new File(imagePath + expectedImagePath);
        File actualImageFilePath = new File(imagePath + actualImagePath);
        BufferedImage expectedImage = ImageIO.read(expectedImageFilePath);
        BufferedImage actualImage = ImageIO.read(actualImageFilePath);
        PointsMarkupPolicy diffMarkupPolicy = new PointsMarkupPolicy();
        diffMarkupPolicy.setDiffSizeTrigger(diffMarkupPolicy.getDiffSize());
        ImageDiffer imgDiff = new ImageDiffer().withDiffMarkupPolicy(diffMarkupPolicy);
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        if (diff.hasDiff() == true) {
            System.out.println("Images are Not Same");
            return false;
        } else {
            System.out.println("Images are Same");
            return true;
        }
    }
}

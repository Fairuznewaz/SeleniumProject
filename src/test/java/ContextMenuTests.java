import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTests {


    /*
     * Open the browser and apply browser options
     *  write the url
     * Look for the Context Menu element in the home page
     * Click on that Context element
     * Verify that we are in Context Menu element page
     * Get the Context Menu element on the same page
     * Check for the Context Menu paragraphs
     * Verify if the Context Menu element is working
     * If yes,then a JavaScript will appear
     * If not, then Context Menu element will not change
     * Repeat to verify all the elements are working
     * close the browser
     * */

    @Test
    public void verifyIfContextMenu(){


        WebDriver driver;

        String url = "https://the-internet.herokuapp.com/";

        String driverPath = System.getProperty("user.dir")+"/drivers/chromedriver/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        options.addArguments("--start-maximized");



        driver.get(url);

        /* Checking for the Context Menu Element on the actual Page*/
        driver.findElement(By.linkText("Context Menu")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Context Menu");

        /*Checking for the paragraphs*/
        boolean actualStatus = driver.findElement(By.cssSelector("#content > div > p:nth-child(2)")).isSelected();

        if (actualStatus==false){driver.findElement(By.cssSelector("#content > div > p:nth-child(2)"));
            System.out.println("Paragraph available");
        }
        else {
            System.out.println("Paragraph not available");
        }

        /*Checking the context menu element*/
        boolean actualStatusForSecondBox = driver.findElement(By.cssSelector("#hot-spot")).isSelected();

        if (actualStatusForSecondBox==false){
            driver.findElement(By.cssSelector("#hot-spot")).click();
            System.out.println("JavaScript pops up");
        }
        else {
            System.out.println("JavaScript is not working");
        }

        driver.close();

    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABTesting {

    /*
     * Open the browser and apply browser options
     *  write the url
     * Look for the A/B Test element in the home page
     * Click on A/B Test element to redirect to the page
     * Verify that we are in A/B Test element page
     * Get the A/B Test element on the same page
     * Look for the paragraph about the testing variation
     * Verify all the elements are working
     * close the browser
     * */

    @Test
    public void verifyABTesting(){


        WebDriver driver;

        String url = "https://the-internet.herokuapp.com/";

        String driverPath = System.getProperty("user.dir")+"/drivers/chromedriver/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        options.addArguments("--start-maximized");



        driver.get(url);


        /* Checking for the Add Element on the actual Page*/
        driver.findElement(By.linkText("A/B Testing")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "A/B Test Variation 1");

        /*Checking for the presence of the paragraph*/
        boolean actualStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/p")).isSelected();

        if (actualStatus==false){
            driver.findElement(By.xpath("/html/body/div[2]/div/div/p")).click();
            System.out.println("A/B Testing Variation 1 is available");
        }
        else {
            System.out.println("A/B Testing Variation 1 is unavailable");
        }


        driver.close();

    }
}

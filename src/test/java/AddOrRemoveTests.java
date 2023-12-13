import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddOrRemoveTests {


    /*
     * Open the browser and apply browser options
     *  write the url
     * Look for the Add or Remove element in the home page
     * Click on that Add or Remove element
     * Verify that we are in Add or Remove element page
     * Get the Add/Remove element on the same page
     * Verify if the Add element is working
     * If yes,then a delete button will appear
     * If not, then Add element will not change
     * Click on the Delete button to check if it disappears or not
     * Verify all the elements are working
     * close the browser
     * */

    @Test
    public void verifyIfAddOrRemove() {


        WebDriver driver;

        String url = "https://the-internet.herokuapp.com/";

        String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        options.addArguments("--start-maximized");

        driver.get(url);

        /* Checking for the Add Element on the actual Page*/

        driver.findElement(By.linkText("Add/Remove Elements")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Add/Remove Elements");

        /*Checking whether the Add or Delete are clickable and working*/

        boolean actualStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).isSelected();

        if (actualStatus==false){
            driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
            System.out.println("Add Element is showing Delete button");
        }
        else {
            System.out.println("Add Element is not working");
        }

        /*Checking the status of the Delete Element*/

        boolean actualStatusForSecondBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).isSelected();

        if (actualStatusForSecondBox==false){
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button")).click();
            System.out.println("Delete Element is clickable");
        }
        else {
            System.out.println("Delete element is not clickable and not disappearing");
        }

        driver.close();
    }

    }

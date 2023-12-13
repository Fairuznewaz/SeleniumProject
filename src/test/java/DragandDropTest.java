import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragandDropTest {

    /*
     * Open the browser and apply browser options
     *  write the url
     * Look for the Drag and Drop element in the home page
     * Click on that Drag and Drop element
     * Verify that we are in Drag and Drop element page
     * Get the Drag and Drop element on the same page
     * Verify if the drag and drop elements are working
     * If yes,then a dragging and dropping will affect the boxes
     * If not, then the boxes will have no effect
     * Repeat to verify all the elements are working
     * close the browser
     * */

    @Test
    public void verifyIfDragandDropisWorking(){


        WebDriver driver;

        String url = "https://the-internet.herokuapp.com/";

        String driverPath = System.getProperty("user.dir")+"/drivers/chromedriver/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        options.addArguments("--start-maximized");



        driver.get(url);


        /* Checking for the Drag and Drop Element on the actual Page*/
        driver.findElement(By.linkText("Drag and Drop")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Drag and Drop");


        /*Checking the status of first Drag and Drop box*/
        boolean actualStatus = driver.findElement(By.cssSelector("/#column-a")).isDisplayed();

        if (actualStatus==true){
            driver.findElement(By.cssSelector("#column-a")).click();
            System.out.println("First box is draggable");
        }
        else {
            System.out.println("First box is not draggable");
        }

        /*Checking the status of second Drag and Drop box*/
        boolean actualStatusForSecondBox = driver.findElement(By.cssSelector("#column-b")).isDisplayed();

        if (actualStatusForSecondBox==true){
            driver.findElement(By.cssSelector("#column-b")).click();
            System.out.println("Second box is draggable");
        }
        else {
            System.out.println("Second box is not draggable");
        }

        driver.close();

    }
}

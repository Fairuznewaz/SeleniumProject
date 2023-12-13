import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTests {


    /*
     * Open the browser and apply browser options
     *  write the url
     * Look for the checkbox element in the home page
     * Click on that checkbox element
     * Verify that we are in Checkbox page
     * Get the checkbox element in Checkbox page
     * Verify if the checkbox is selected
     * If not, then click on that unchecked element
     * Click on the checkbox button
     * Repeat this until all the checkboxes are checked
     * Verify all the boxes are checked
     * close the browser
     * */






    @Test
    public void verifyIfCheckBoxesAreChecked(){


        WebDriver driver;

        String url = "https://the-internet.herokuapp.com/";

        String driverPath = System.getProperty("user.dir")+"/drivers/chromedriver/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        options.addArguments("--start-maximized");

        driver.get(url);


        driver.findElement(By.linkText("Checkboxes")).click();

/*        String actualHeader = driver.findElement(By.tagName("h3")).getText();

        String expectedHeader = "Checkboxes";

        Assert.assertEquals(actualHeader, expectedHeader);*/

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Checkboxes");

        /*We will check the status of the checkbox first
         * If the checkbox is selected (status true), we will proceed to next checkbox
         * If the checkbox is not selected (status false), we will select it and verify again before proceeding to next checkbox
         * */

        /*Checking the status of first checkbox*/
        boolean actualStatus = driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[1]")).isSelected();

        if (actualStatus==false){
            driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[1]")).click();
            System.out.println("First checkbox is selected");
        }
        else {
            System.out.println("First checkbox has been selected already");
        }

        /*Checking the status of second checkbox*/
        boolean actualStatusForSecondBox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected();

        if (actualStatusForSecondBox==false){
            driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
            System.out.println("Second checkbox is selected");
        }
        else {
            System.out.println("Second checkbox has been selected already");
        }

        driver.close();

    }
}

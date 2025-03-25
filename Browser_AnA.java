import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Browser_AnA {
    public String baseUrl = "https://www.fgcu.edu/";
    String driverPath = "C:\\Users\\rjacq\\OneDrive - Florida Gulf Coast University\\2024_Spring\\CEN 4072 Software Testing\\ChromeDriver\\chromedriver.exe";
    WebDriver driver;
    

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        // before each method in this class run chromeDriver
        System.out.println("launching Chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(10000);
    }


    // Test Case 4
    @Test
    public void test4() throws InterruptedException {


        /* Test if the actual title of a web page is NOT EQUAL to the expected title page of a web page of your choice
        using assert statements.
        */

        String chosen_Title = "Florida Gulf Coast University | Turning Ideas Into Not Matching";

        //get the title
        String title_page = driver.getTitle();
        System.out.println(title_page);
        Thread.sleep(5000);

        //If the titles are NOT equal the program does not stop. The next line is run.
        Assert.assertNotEquals(chosen_Title,title_page, "The website title matches the assumed title.");

        System.out.println("The website title does not match the assumed title");

    }

    // Test Case 5
    @Test
    public void test5() throws InterruptedException {

        /*
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rjacq\\OneDrive - Florida Gulf Coast University\\2024_Spring\\CEN 4072 Software Testing\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.fgcu.edu/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        */

        //Go to new page
        driver.findElement(By.xpath("/html/body/fgcuheader/div[1]/div[1]/div/div/div/div/ul/li[1]/a")).click();
        Thread.sleep(5000);

        //Test if the actual URL matched with the expected URL of a web page of your choice using assert statements.
        //Get the URL of the page
        String current_url = driver.getCurrentUrl();
        System.out.println(current_url);
        Thread.sleep(3000);

        String expected_URL = "https://www.fgcu.edu/admissionsandaid/";

        Assert.assertEquals(current_url,expected_URL,"The actual URL DOES NOT match the expected URL of the webpage");
        System.out.println("The acutal URL DOES match the expected URL of the webpage.");

    }

    // Test Case 6
    @Test
    public void test6() throws InterruptedException {

        //Test if the size of the elements in the web page is equal to the size you expected using assert statements.

        int expectedElNum = 463;

        //Get number of elements in page
        List<WebElement> link = driver.findElements(By.tagName("a"));
        int elementNum = link.size();
        System.out.println(link.size());
        Thread.sleep(5000);


        //Compare the two numbers with an assert statement
        Assert.assertEquals(elementNum,expectedElNum,"The element numbers DO NOT match the expected element number");
        System.out.println("The element numbers DO match the expected element number");

    }


    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Running Browser Annotations and Assertions Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Finished Browser_AnA Class.");
    }

    // Setup the webdriver
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Running Method");
    }

    // Declare the test has finished running and increment the test number
    @AfterMethod
    public void afterMethod(){
        System.out.println("Finished Method");
    }


}



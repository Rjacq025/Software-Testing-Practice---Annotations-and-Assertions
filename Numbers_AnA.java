import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Scanner;


public class Numbers_AnA {

    //Scanner Class for user input
    Scanner sc = new Scanner(System.in);

    // Test Case 1
    @Test
    public void test1() {

        /*
        Check if the given number and reversed number (Java code) is equal using assert statements. Comment on the
        logic of the code.
        Had some help from https://www.programiz.com/java-programming/examples/reverse-number to figure out how to
        reverse a number in Java. I edited it to fit this task.
        */

        System.out.println("Please type in number:");
        //int userNumber = sc.nextInt();
        int userNumber = 25052;

        System.out.println("\nOriginal Number: " + userNumber);


         /*
         Number reversal works by dividing the userNumber by 10, the remainder (previously the last number) is then
         taken from this and is inputted as the first number in the reversed variable. This loops until the original
         number becomes 0
        */

        int usedNum = userNumber;
        int reversed = 0;

        while(usedNum != 0) {

            // get last digit from num
            int digit = usedNum % 10;
            reversed = reversed * 10 + digit;

            // remove the last digit from num
            usedNum /= 10;
        }

        System.out.println("Reversed Number: " + reversed);

        Assert.assertEquals(userNumber,reversed,"Given number and reversed number do NOT match.");
    }

    // Test Case 2
    @Test
    public void test2() {
        //Check if the factorial of a given number is correct or not using assert statements.

        System.out.println("\nPlease type in number:");
        //int questionNum = sc.nextInt();
        int questionNum = 5;

        System.out.println("\nInsert what you think is the factorial of your number:");
        //int userFactorial = sc.nextInt();
        int userFactorial = 121;

        //Calculate the Factorial of the number
        int realFactorial = 1;

        for(int i = questionNum; i != 0; i--){
            realFactorial *= i;
        }

        System.out.println("User Factorial:" + userFactorial + "\nReal Factorial: " + realFactorial);

        Assert.assertNotEquals(realFactorial,userFactorial,"The Factorials Match");
        System.out.println("The factorials do not match");
    }

    // Test Case 3
    @Test
    public void test3() {
        //Check if the given number is a prime number or not using assert statements.

        System.out.println("\nPlease type in what you think is a prime number:");
        //int userPrime = sc.nextInt();
        int userPrime = 29;
        boolean primeTest = true;


        //Test the userPrime to see if it qualifies as a prime number
        for (int i = 2; i <= userPrime / 2; ++i) {
            // condition for nonprime number
            if (userPrime % i == 0) {
                primeTest = false;
                break;
            }
        }

        //Assert statement
        Assert.assertTrue(primeTest,"This value is not a prime number");
        System.out.println(primeTest);

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

    @BeforeClass
    public void beforeClass() {
        System.out.println("Running Numbers Annotations and Assertions Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Finished Numbers_AnA class\n");
    }


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Running Annotations and Assertions Tests 1-6");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Finished running Annotations and Assertions Tests 1-6");
    }

}

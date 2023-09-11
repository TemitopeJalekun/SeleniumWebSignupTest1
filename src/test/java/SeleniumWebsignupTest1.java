import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebsignupTest1 {
    //import the selenium WebDriver

    private WebDriver driver;
    @BeforeTest
    public void setup() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // 1. Open your chrome driver
        driver = new ChromeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        //Test1. Verify the user input correct url and is on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong Webpage");

        Thread.sleep(5000);
        //3. Maximize the page
        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }


    @Test (priority = 0)
    //Test7: verify user is successfully Signed up when valid details are inputted
    public void PositiveSignup() throws InterruptedException {
        /* 5. Input your username on the username field */
        driver.findElement(By.id("user_username")).sendKeys("Temidayo");
        //6. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("TEMIDAY142@yopmail.com");
        //7.  Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("77889944");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }


    @Test (priority = 1)
    public void clickMeaghanitems() throws InterruptedException {
        //9.click on Meaghan item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test2 Verify that when user clicks on the Signup button, the user is directed to the signup webpage
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("correct Webpage");
        else
            //fail
            System.out.println("wrong Webpage");
        Thread.sleep(5000);
    }
    @Test (priority = 2)
   public void verifyItem()throws InterruptedException {
        //10. search for an item (Using python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test 9: Verify that item searched for on User1 page is present
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if(actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("correct User1Page");
        else
            //fail
            System.out.println("wrong User1Page");
        Thread.sleep(5000);
    }
   @Test (priority = 3)
   public void logoutsuccesfully(){
    //11. Click to logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 10: Verify that when user logs out, he/she is redirected to the homepage
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if(expectedTitle.contains(actualTitle))
            //pass
            System.out.println("correct Webpage");
        else
            //fail
            System.out.println("wrong Webpage");

   }

    @Test (priority = 4)
    //Test3 verify user cannot Signup with username less than three Characters
    public void negativeSignup() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(3000);
        /* 5. Input your username on the username field */
        driver.findElement(By.id("user_username")).sendKeys("T");
        //6. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("emilas254@yopmail.com");
        //7.  Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("kasolayo");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    //Test4 verify user can not Signup with invalid email address
    public void invalidEmail() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        /* 5. Input your username on the username field */
        driver.findElement(By.id("user_username")).sendKeys("Adeneyin");
        //6. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("@yopmail.com");
        //7.  Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("1253445");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
        //Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
    }

    @Test (priority = 6)
    //Test5 verify user cannot Signup with password less than or equal to one character
    public void invalidPassword() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        /* 5. Input your username on the username field */
        driver.findElement(By.id("user_username")).sendKeys("Askyin");
        //6. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("adedoyin246@yopmail.com");
        //7.  Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("5");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
    }

    @Test (priority = 7)
    //Test6: verify user cannot Signup with either or all the fields blank
    public void blankField() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        /* Input your username on the username field */
        driver.findElement(By.id("user_username")).sendKeys("-");
        // Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("-");
        // Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("-");
        //Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
    }

    @AfterTest
    public void closeBrowser(){
        //Quit the browser
        driver.quit();
    }
}

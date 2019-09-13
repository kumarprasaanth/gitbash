package demo2.demo;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cucumberdemo {
   
WebDriver driver;

@Given("User in Homepage")
public void user_in_Homepage() throws InterruptedException
{
System.setProperty("webdriver.chrome.driver","C:\\kprasaanth\\Drivers\\chromedriver_win32 (3)\\chromedriver.exe");
driver =new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("http://10.232.237.143:443/TestMeApp/");
Assert.assertEquals(driver.getTitle(),"Home");
System.out.println("User in Homepage");
/* driver.findElement(By.partialLinkText("SignUp")).click();
driver.findElement(By.id("userName")).sendKeys("lindandanlin");
driver.findElement(By.id("firstName")).sendKeys("Lindan");
driver.findElement(By.id("lastName")).sendKeys("L");
driver.findElement(By.id("password")).sendKeys("Lindan123");
driver.findElement(By.name("confirmPassword")).sendKeys("Lindan123");
//driver.findElement(By.xpath("//input[@value='Female')]")).click();
//driver.findElement(By.xpath("//input[@value='Male')]")).click();
driver.findElement(By.id("gender")).click();
driver.findElement(By.id("emailAddress")).sendKeys("abcc@gmail.com");
driver.findElement(By.id("dob")).sendKeys("01/01/2001");
driver.findElement(By.id("mobileNumber")).sendKeys("98765436210");
driver.findElement(By.id("address")).sendKeys("asd asd sd asdds asdsd");
Select s=new Select(driver.findElement(By.id("securityQuestion")));
s.selectByVisibleText("What is your Birth Place?");
driver.findElement(By.id("answer")).sendKeys("Chennai");
driver.findElement(By.name("Submit")).click();
Assert.assertEquals(driver.getTitle(), "Login");
System.out.println("User Login Successfully");
driver.get("http://10.232.237.143:443/TestMeApp/");
//driver.findElement(By.id("userName")).sendKeys("lindanfine");
/////driver.findElement(By.id("password")).sendKeys("Lindan123");
//driver.findElement(By.xpath("html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();

*/
}
@When("User enters Username and Password and click on Login Button")
public void user_enters_Username_and_Password_and_click_on_Login_Button()
{
 driver.findElement(By.partialLinkText("SignIn")).click();
 driver.findElement(By.id("userName")).sendKeys("lindandanlin");
 driver.findElement(By.id("password")).sendKeys("Lindan123");
 driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
 
}
@Then("User Logged verified")
public void user_Logged_verified()
{

Assert.assertEquals(driver.getTitle(),"Home");
System.out.println("User Login verified");
System.out.println("User Now Goes for Shopping");
}
@Given("User Searches for Electronics,Headphone")
public void user_searches_for_Electronics_Headphone()
{
Actions act=new Actions(driver);
act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'All')]"))).click().build().perform();;
act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"))).click().build().perform();;
act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Travel')]"))).click().build().perform();
Assert.assertEquals(driver.getTitle(),"Search");
System.out.println("User Selected the product");
}
@Given("User add the product to the Shopping cart")
public void user_add_the_product_to_the_Shopping_cart()
{
driver.get("http://10.232.237.143:443/TestMeApp/fetchSubCat.htm?val=search");
driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
System.out.println("User Proceeds for checkout");
}
@And("User proceeds for checkout")
public void user_proceeds_for_checkout()
{
Assert.assertEquals(driver.getTitle(),"View Cart");
System.out.println("USer ready to proceed");
driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div[2]/div[3]/div/form[2]/input")).click();
Assert.assertEquals(driver.getTitle(),"Payment Gateway");
System.out.println("User now proceeds for payment");

}
@And("Select bank and Add Credentials")
public void select_bank_and_Add_Credentials() throws InterruptedException
{
driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
driver.findElement(By.xpath("//*[id=\"btn\")")).click();
driver.findElement(By.id("userName")).sendKeys("lindandanlin");
driver.findElement(By.id("password")).sendKeys("Lindan123");
Thread.sleep(2000);


}
@Then("User directed to Thankyou Page")
public void user_directed_to_Thankyou_page()
{
System.out.println("Error In Applicatio");
driver.get("http://10.232.237.143:443/TestMeApp/");
Assert.assertEquals(driver.getTitle(),"Home");
System.out.println("ThankYou For Purchase");
driver.close();

}

}


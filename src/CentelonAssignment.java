import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CentelonAssignment {
	
	WebDriver driver;

	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		  CentelonAssignment centelon1 = new CentelonAssignment();
		centelon1.invokeBrowser();
		centelon1.userRegistration();
		centelon1.addItemToCart(); 
	
	}
	
	public void userRegistration(){
	
		//Open required URL
        driver.get("http://automationpractice.com/index.php");
        //now click on SignIn button
        driver.findElement(By.className("login")).click();
        //enter email id
        driver.findElement(By.id("email_create")).sendKeys("poojapawar10@gmail.com");
        //click on create an account
        driver.findElement(By.name("SubmitCreate")).click();
        
    	try {
			Thread.sleep(7000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        //select title in create an account details
        driver.findElement(By.id("id_gender2")).click();
        //name and pwd
        driver.findElement(By.id("customer_firstname")).sendKeys("Pooja");
        driver.findElement(By.id("customer_lastname")).sendKeys("Pawar");
        driver.findElement(By.id("passwd")).sendKeys("Test@2022");
        //dropdown
        driver.findElement(By.id("days")).sendKeys("7");
        driver.findElement(By.id("months")).sendKeys("June");
        driver.findElement(By.id("years")).sendKeys("1992");
        //checkbox
        driver.findElement(By.id("newsletter")).isSelected();
        //Your Address
        driver.findElement(By.id("company")).sendKeys("centelon");
        driver.findElement(By.id("address1")).sendKeys("address1");
        driver.findElement(By.id("address2")).sendKeys("address2");
        driver.findElement(By.name("city")).sendKeys("Dehli");
        driver.findElement(By.id("id_state")).sendKeys("Indiana");
        driver.findElement(By.cssSelector("input#postcode")).sendKeys("41004");
        driver.findElement(By.id("other")).sendKeys("Not Required.");
        driver.findElement(By.id("phone")).sendKeys("0217234567");
        driver.findElement(By.id("phone_mobile")).sendKeys("9196959798");
        driver.findElement(By.id("alias")).sendKeys("Same as above adddress");
        driver.findElement(By.id("submitAccount")).click();
        
        try {
			Thread.sleep(7000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //logout from current session
        driver.findElement(By.xpath("//a[@class='logout']")).click();
	}
	
	public void invokeBrowser() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    //implicit wait-30 seconds time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
	}
	
	public void addItemToCart(){
		
		//Open required URL
        driver.get("http://automationpractice.com/index.php");
        //now click on SignIn button
        driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("poojapawar10@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Test@2022");
		driver.findElement(By.cssSelector("button#SubmitLogin")).click();
		try {
			Thread.sleep(9000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Adding product to card
        driver.findElement(By.cssSelector("a.sf-with-ul")).click();
        driver.findElement(By.linkText("DRESSES")).click();
        driver.findElement(By.xpath("//a[@class='product-name'][1]")).click();
        driver.findElement(By.xpath("//p[@id='add_to_cart']")).click();
        driver.findElement(By.linkText("Proceed to checkout")).click();
        driver.findElement(By.xpath("//p/a/span[text()='Proceed to checkout']")).click();
        driver.findElement(By.xpath("//button[@name='processAddress']")).click();
        driver.findElement(By.cssSelector("input#cgv" )).click();
		System.out.println("after::"+driver.findElement(By.cssSelector("input#cgv" )).isSelected());
        //selecting printed dress
        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
        driver.findElement(By.xpath("//div/p/a[@class='bankwire']")).click();
        driver.findElement(By.xpath("//button/span[text()='I confirm my order']")).click();
        driver.close();
		
	}
	

}

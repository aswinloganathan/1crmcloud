package project.crmcloud;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Crmcloud {
	
	public static WebDriver driver;
	public static  WebDriverWait wait;
	
    public static void main( String[] args ) throws InterruptedException {
        
    	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
    	System.setProperty("webdriver.chrome.silentOutput", "true");
    	
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-notifications"); //To disable Notifications
    	
    	driver = new ChromeDriver(options);
    	
    	
    	//1) Go to https://demo.1crmcloud.com/
    	
    	driver.manage().window().maximize();
    	driver.get("https://demo.1crmcloud.com");
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	
    	
    	//2) Give username as admin and password as admin
    	
    	driver.findElement(By.id("login_user")).sendKeys("admin");
    	driver.findElement(By.id("login_pass")).sendKeys("admin");
    	
    	
    	//3) Choose theme as Claro Theme
    	
    	WebElement theme = driver.findElement(By.id("login_theme"));
    	Select select = new Select(theme);
    	select.selectByValue("Claro");
    	
    	driver.findElement(By.xpath("//span[contains(@class,'uii uii-arrow-right')]")).click();
    	
    	
    	//4) Click on Sales and Marketting 
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//div[text()='Sales & Marketing']")).click();    	
    	
    	//5) Click Create contact
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//div[text()='Create Contact']")).click();    	
    	
    	
    	//6) Select Title and type First name, Last Name, Email and Phone Numbers
    	Thread.sleep(5000);
    	driver.findElement(By.id("DetailFormsalutation-input-label")).click();
    	
    	Thread.sleep(3000);
    	WebElement title = driver.findElement(By.xpath("//div[@id='DetailFormsalutation-input-popup']//div[text()='Mr.']"));
    	Actions action = new Actions(driver);
    	action.moveToElement(title).click().build().perform();
    	
    	Thread.sleep(3000);
    	driver.findElement(By.name("first_name")).sendKeys("Nanthan");
    	driver.findElement(By.name("last_name")).sendKeys("Nanthan");
    	driver.findElement(By.id("DetailFormemail1-input")).sendKeys("email@email.com");
    	driver.findElement(By.name("phone_work")).sendKeys("9874563210");
    	
    	//7) Select Lead Source as "Public Relations"
    	Thread.sleep(5000);
    	driver.findElement(By.id("DetailFormlead_source-input")).click();
    	Thread.sleep(3000);
    	WebElement leadSource = driver.findElement(By.xpath("//div[@id='DetailFormlead_source-input-popup']//div[text()='Public Relations']"));
    	action.moveToElement(leadSource).click().build().perform();
 
    	
    	//8) Select Business Roles as "Sales"
    	Thread.sleep(5000);
    	driver.findElement(By.id("DetailFormbusiness_role-input")).click();
    	
    	Thread.sleep(3000);
    	WebElement role = driver.findElement(By.xpath("//div[@id='DetailFormbusiness_role-input-popup']//div[text()='Sales']"));
    	action.moveToElement(role).click().build().perform();
    	
    	
    	//9) Fill the Primary Address, City, State, Country and Postal Code and click Save
    	driver.findElement(By.id("DetailFormprimary_address_street-input")).sendKeys("No x, 7 Street Name, Street Number");
    	driver.findElement(By.id("DetailFormprimary_address_city-input")).sendKeys("City");
    	
    	WebElement state = driver.findElement(By.id("DetailFormprimary_address_state-input"));
    	state.click();
    	Thread.sleep(3000);
    	state.sendKeys("Tamil Nadu");
    	
    	WebElement country = driver.findElement(By.id("DetailFormprimary_address_country-input"));
    	country.click();
    	Thread.sleep(3000);
    	country.sendKeys("India");    	    	
    	
    	WebElement zipcode = driver.findElement(By.id("DetailFormprimary_address_postalcode-input"));
    	zipcode.click();
    	zipcode.sendKeys("600108");
   
    	driver.findElement(By.id("DetailForm_save2")).click(); 
    	Thread.sleep(3000);
    	
    	//10) Mouse over on Today's Activities and click Meetings
    	action.moveToElement(driver.findElement(By.xpath("(//div[@class='menu-label'])[1]"))).perform();
    	action.moveToElement(driver.findElement(By.xpath("//div[text()='Meetings']"))).click().perform();
    	Thread.sleep(3000);
    	
    	//11) Click Create
    	driver.findElement(By.xpath("//button[@name='SubPanel_create']")).click();
    	Thread.sleep(3000);
    	
    	//12) Type Subject as "Project Status" , Status as "Planned" 
    	driver.findElement(By.id("DetailFormname-input")).sendKeys("Project Status");
    	driver.findElement(By.id("DetailFormstatus-input")).click();
    	Thread.sleep(3000);
    	action.moveToElement(driver.findElement(By.xpath("//div[text()='Planned']"))).click().perform();
    	Thread.sleep(3000);
    	
    	
    	//13) Start Date & Time as tomorrow 3 pm and Duration as 1hr
    	driver.findElement(By.xpath("//div[@id='DetailFormdate_start-input']/div[2]")).click();
    	Thread.sleep(3000);
    	
    	//To get date and manipulate date form tomorrow
    	LocalDate date = LocalDate.now(); 
		LocalDate tomorrow = date.plusDays(1);
		String tomorrowDate = tomorrow.toString();	
		
		WebElement dateBox = driver.findElement(By.xpath("//div[@id='DetailFormdate_start-calendar-text']/input"));
		dateBox.click();
		dateBox.clear();
		dateBox.sendKeys(tomorrowDate,Keys.ENTER);
		
		Thread.sleep(3000);
		dateBox.click();
		dateBox.clear();
		dateBox.sendKeys("15:00",Keys.ENTER);
    	
    		
		WebElement durations = driver.findElement(By.id("DetailFormduration-time"));
    	durations.click();
    	durations.clear();
    	Thread.sleep(3000);
    	durations.sendKeys("1h 00m");
    	
    	
    	//14) Click Add paricipants, add your created Contact name and click Save
    	
    	driver.findElement(By.name("addInvitee")).click();
    	WebElement addParticipant = driver.findElement(By.xpath("//div[contains(@class,'popup-search tools-row')]//input"));
    	addParticipant.click();
    	Thread.sleep(3000);
    	addParticipant.sendKeys("Nanthan Nanthan");
    	wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='app-search-list']"))).click();
    	
    	wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DetailForm_save2-label"))).click();
    	
    	//15) Go to Sales and Marketting-->Contacts
    	action.moveToElement(driver.findElement(By.xpath("//div[text()='Sales & Marketing']"))).perform();
    	wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Contacts']"))).click();
    	Thread.sleep(3000);
    	
    	//16) search the lead Name and click the name from the result
    	
    	driver.findElement(By.id("filter_text")).sendKeys("Nanthan Nanthan",Keys.ENTER);
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("(//table[@class='listView']//tr)[2]/td[3]/span/a")).click();
    	//wait = new WebDriverWait(driver, 30);
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'card-body menu-outer input-scroll')])[3]"))).click();
    	
    	//17) Check weather the Meeting is assigned to the contact under Activities Section.
    	Thread.sleep(6000);
    	String meeting = driver.findElement(By.xpath("(//table[@class='listView']//tr)[2]/td[5]")).getText();
    	if (meeting.equalsIgnoreCase("Planned")) {
			System.out.println("Meeting is Planned");
		} else {
			System.out.println("Need to schedule meeting for Nanthan Nanthan");
		}
    	
    	
    	driver.close();
    }
}

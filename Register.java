package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class Register {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
	
	
	}

	public WebDriver driver;	//private WebDriver driver;      
	public Register(WebDriver driver) {    //constuctor
		driver = this.driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id = "FirstName")
	WebElement FirstnameField;
		
	@FindBy(id = "LastName")
	WebElement LastnameField;
	
	@FindBy(id = "Email")
	WebElement EmailField;
	
	@FindBy(id = "Password")
	WebElement PasswordField;
	
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmpasswordField;
	
	@FindBy(id = "register-button")
	WebElement RegisterBtn;
	
	@FindBy(css = ".ico-logout")
	static
	WebElement LogoutBtn;
	
	//driver.findelement().sendKeys("FirstName")
	public void setFirstName(Object firstname) {	
		WebElement FirstnameFeild = null;
		FirstnameFeild.sendKeys("Tanzeela");
	}	
	
     public void setLastName(String LastName) {	
			WebElement LastnameFeild = null;
			LastnameFeild.sendKeys("Shaik");
     }
			
	public static void setemail(String email) {	
	 WebElement emailFeild = null;
	emailFeild.sendKeys("shaiktanzeelas@gmail.com");	
	}
		
	public void setpass(String pass) {	
		WebElement passFeild = null;
	    passFeild.sendKeys("123456789")	;
	}
			
	    public void setConfirm(String confirm) {	
			WebElement confirmpassFeild = null;
			confirmpassFeild.sendKeys("123456789"); 
	    }
	    
			public void clickRegister() {	
				RegisterBtn.click();
			}
			public static void clickLogout() {	
				LogoutBtn.click();
	}

			
				
			}

			
			
	
	

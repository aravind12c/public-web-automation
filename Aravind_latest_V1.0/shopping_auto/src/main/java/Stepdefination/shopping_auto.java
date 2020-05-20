package Stepdefination;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dynamic_objects.xpath_locators;


public class shopping_auto {
	public WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,20);
	Actions actions = new Actions(driver);
	
	public excelData excel_info = new excelData();
	public xpath_locators xlocators = new xpath_locators();
	SoftAssert Assertion = new SoftAssert();
	ITestResult testResult;
	//public static propertiesData properties_info;
	
	
	public void getscreenshot(String a) throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
            FileUtils.copyFile(scrFile, new File("Screenshots/screenshot_"+a+".png"));
    }
	
	
	
	
	@Given("^Launch the shopping url$")
	public void launch_the_shopping_url() throws Exception {
		
		driver.get("http://automationpractice.com/index.php");
	    driver.manage().window().maximize();
	}

	@And("^I check whether website is opened$")
	   public void check_the_shopping_url() throws Exception { 
		
	   try {
		   Assert.assertNotNull(driver.findElement(By.xpath(xlocators.woman_element())));
			   
	   System.out.println("Page Reached Successfully");
	   }
	   
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   String screen = "Page not yet reached";
			getscreenshot(screen);
			Assert.fail("Page not yet reached");
	   }
	   
	   	}
	
	
	@When("^I click on the Women column to select Summer Dresses$")
	public void select_summer_dresses() throws Exception {
		
		try {
		WebElement women = driver.findElement(By.xpath(xlocators.women_hover()));
		actions = new Actions(driver);
		actions.moveToElement(women).perform();
		Thread.sleep(2000);
		}
		catch(Exception e)
		   {
			   e.printStackTrace();
			   String screen = "Unable to find Women column";
				getscreenshot(screen);
			   Assert.fail("Unable to find Women column");
				
		   }
		try {
			WebElement summer_dresses = driver.findElement(By.xpath(xlocators.summerdresses_hover()));
			actions.moveToElement(summer_dresses).perform();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(xlocators.summerdress_element())).click();
			}
			catch(Exception e)
			   {
				   e.printStackTrace();
				   String screen = "Unable to find Summer dresses Option";
					getscreenshot(screen);
				   Assert.fail("Unable to find Summer dresses Option");
					
			   }
		
	}
	
	@Then("^I am navigated to Summer Dresses section$")
	public void verify_summerdressessection() throws Exception {
		try {
			String act_section = driver.findElement(By.className("cat-name")).getText();
			String ex_section = "SUMMER DRESSES ";
			 Assert.assertEquals(ex_section,act_section);
			   System.out.println("Page Reached Summer Dress Section");
			}
			catch(Exception e)
			   {
				   e.printStackTrace();
				   String screen = "Unable to navigate to Summer Dresses Section";
					getscreenshot(screen);
				   Assert.fail("Unable to navigate to Summer Dresses Section");
					
			   }
	}
	
	@And("^I Add a dress to the cart$")
	public void add_dress() throws Exception {
		
					
		actions.moveToElement(driver.findElement(By.xpath(xlocators.pic_hover()))).perform();	
		Thread.sleep(2000);
		 driver.findElement(By.xpath("((//*[text() = 'Add to cart'])[1])")).click();
		
		 try {
		driver.switchTo().window(driver.getWindowHandle());
		Thread.sleep(2000);
		String act_success = driver.findElement(By.xpath(xlocators.success_test())).getText();
		String ex_success = "Product successfully added to your shopping cart";
		
		Assert.assertEquals(ex_success,act_success);
		System.out.println("Product Added to Cart Successfully");
		 }
						
		 catch(Exception e){
			 e.printStackTrace();
			 String screen = "Unable to add the product to the cart";
				getscreenshot(screen);
			 Assert.fail("Unable to add the product to the cart");
			 
		 }
		driver.findElement(By.xpath(xlocators.continue_button())).click();
		driver.switchTo().window(driver.getWindowHandle());
		
		
	}
	
	@And("^I click on cart to Check out$")
	public void check_out() throws Exception {
		try {
		actions.moveToElement(driver.findElement(By.xpath(xlocators.view_cart()))).perform();
		Thread.sleep(2000);
		String ex_cart =  "0";
		String act_cart =driver.findElement(By.xpath(xlocators.cart_test())).getText();
		
//		Assert.assertNotEquals(ex_cart,act_cart);
			driver.findElement(By.xpath(xlocators.cart_order())).click(); 	
		}
		 catch(Exception e){
			e.printStackTrace();
			String screen = "Unable to order the product";
			getscreenshot(screen);
			Assert.fail("Unable to order the product");
			
			 }
	}
	
	@Then("^I am navigated to Shipping Cart Summary Page to checkout$")
	public void shipping_checkout() throws Exception {
		try {
			String act_summary = driver.findElement(By.xpath(xlocators.summary_test())).getText();
			String ex_summary = "Shopping-cart summary			";
			
//			Assert.assertNotEquals(ex_summary,act_summary);
			try {
				
				Assert.assertNotNull(driver.findElement(By.xpath(xlocators.product_test())));
				driver.findElement(By.xpath(xlocators.proceed_checkout())).click();
				}
			catch (Exception e){
				e.printStackTrace();
				String screen = "Unable to Find any products in cart";
				getscreenshot(screen);
				Assert.fail("Unable to Find any products in cart");
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to reach Summary page");
		}
	}
	
	@And("^I login as existing customer with \"(.*)\" and \"(.*)\"$")
	public void login_customer(String username, String password) throws Exception {
		try {
			excel_info.excelsData();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.login_email())));
			driver.findElement(By.xpath(xlocators.login_email())).sendKeys(username);
			driver.findElement(By.xpath(xlocators.login_pwd())).sendKeys(password);
			driver.findElement(By.xpath(xlocators.login_submit())).click();
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.name_user())));
		String act_nameof_user = driver.findElement(By.xpath(xlocators.name_user())).getText();
		
		String ex_nameof_user = "Aravind C";
		
		Assert.assertEquals(ex_nameof_user,act_nameof_user);
		System.out.println("Login Successfull");
	}
		catch(Exception e){
			e.printStackTrace();
			String screen = "Unable to reach Summary page";
			getscreenshot(screen);
			Assert.fail("Unable to reach Summary page");
		}
	}
	
	@And("^I choose address as home adress$")
	public void customer_address() throws Exception {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.address())));
			Select address_home = new Select(driver.findElement(By.xpath(xlocators.address()))); 
			address_home.selectByVisibleText("Home Address"); 
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.verify_address())));
				String act_address = driver.findElement(By.xpath(xlocators.verify_address())).getText();
				String ex_address = "Paradise World Apartments";
				Assert.assertEquals(ex_address,act_address);
				driver.findElement(By.xpath(xlocators.check_out())).submit();
			}
			catch (Exception e){
				e.printStackTrace();
				String screen = "Incorrect Home Address";
				getscreenshot(screen);
				Assert.fail("Incorrect Home Address");
			}
							
			}
		
		catch (Exception e){
			e.printStackTrace();
			String screen = "Unable to select home address";
			getscreenshot(screen);
			Assert.fail("Unable to select home address");
		}
}
	
	@And("^I proceed to checkout by agreeing terms and conditions$")
	public void shipping_details() throws Exception {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.checker_box())));
			driver.findElement(By.xpath(xlocators.checker_box())).click();
			driver.findElement(By.xpath(xlocators.shipping_checkout())).click();
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Shipping Failed";
			getscreenshot(screen);
			Assert.fail("Shipping Failed");
		}
	}
	
	@And("^I pay by Bank Wire$")
	public void payment_gateway() throws Exception {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.payment_gate())));
			driver.findElement(By.xpath(xlocators.payment_gate())).click();
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Payment Failed";
			getscreenshot(screen);
			Assert.fail("Payment Failed");
		}
	}
		 
	@And("^I confirm Order$")
	public void confirm_order() throws Exception {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath(xlocators.confirm_button())).submit();
			WebElement confirm_orders = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.order_text())));
			String act_ordertxt = confirm_orders.getText();
			String ex_ordertxt = "Your order on My Store is complete.";
			Assert.assertEquals(ex_ordertxt,act_ordertxt);
			System.out.println("Oredr Success");
			Thread.sleep(2000);
			driver.close();
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Order failed";
			getscreenshot(screen);
			Assert.fail("Order failed");
		}
	}
	
	
		
	
	@When("^I click on Sign in to register$")
	public void sign_in() throws Exception {
		try {
			driver.findElement(By.xpath(xlocators.signin_link())).click();
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Unable to click on Sign In";
			getscreenshot(screen);
			Assert.fail("Unable to click on Sign In");
		} 
	}
	
	@And("^I click on Create Account by verifying whether Email is already registered$")
	public void verify_user() throws Exception {
		try {
			excel_info.excelsData();
			int no_of_rows = excel_info.last_row_count();
			for (int i=1;i<=no_of_rows;i++) { 
						
				String rows = excel_info.mail(i);
				driver.findElement(By.xpath(xlocators.mail_entry())).sendKeys(rows);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.create_button())));
				driver.findElement(By.xpath(xlocators.create_button())).click();
				Thread.sleep(3000);
				if(driver.findElement(By.xpath(xlocators.verify_mail())).isDisplayed()) {
						System.out.println("Email already taken");
						driver.findElement(By.xpath(xlocators.mail_entry())).clear();
				}
				else {
					break;
				}
				}
			}
			catch (Exception e){
				e.printStackTrace();
				String screen = "Unable to get into Registration page";
				getscreenshot(screen);
				System.out.println("Unable to get into Registration page");
				
			}
	}
	
	
	@Then("^I am navigated to Registeration page$")
	public void registration_page() throws Exception {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.radio_button())));
			Assert.assertFalse(driver.findElement(By.xpath(xlocators.radio_button())).isDisplayed());
			System.out.println("Page reached successfully");
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Invalid Page after Registration";
			getscreenshot(screen);
			Assert.fail("Invalid Page after Registration");
		}
	}
	
	@And("^I enter all the info related to Personal Information$")
	public void registration_personal() throws Exception {
		try {
			driver.findElement(By.xpath(xlocators.radio_button())).click();
			driver.findElement(By.xpath(xlocators.p_fname())).sendKeys(excel_info.data_fName());
			driver.findElement(By.xpath(xlocators.p_lname())).sendKeys(excel_info.data_lName());
			driver.findElement(By.xpath(xlocators.reg_pwd())).sendKeys(excel_info.data_password());
			//driver.findElement(By.xpath(xlocators.reg_pwd())).sendKeys(excel_info.data_password());
			driver.findElement(By.id("days")).click();
			Select day = new Select(driver.findElement(By.id("days"))); 
			day.selectByValue("7"); 
			driver.findElement(By.id("months")).click();
			Select month = new Select(driver.findElement(By.id("months"))); 
			month.selectByValue("3");
			driver.findElement(By.id("years")).click();
			Select year = new Select(driver.findElement(By.id("years"))); 
			year.selectByValue("1995");
			
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Unable to Input Personal Information";
			getscreenshot(screen);
			Assert.fail("Unable to Input Personal Information");
		}
}
	
	@And("^I verify personal Information with the Address column$")
	public void registration_address() throws Exception  {
		try {
		String act_fname=	driver.findElement(By.xpath(xlocators.a_fname())).getAttribute("value");
		CharSequence ex_fname=	excel_info.data_fName();
		System.out.println(ex_fname);
			Assertion.assertEquals(act_fname, ex_fname);
			
		String act_lname=	driver.findElement(By.xpath(xlocators.a_lname())).getAttribute("value");
		CharSequence ex_lname=	excel_info.data_fName();		
			Assertion.assertEquals(act_lname, ex_lname);
	
				
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Validation Failure in Registration";
			getscreenshot(screen);
			Assert.fail("Validation Failure in Registration");
		}
}
	@And("^I enter all the required information in Address$")
	public void registration_input_address() throws Exception  {
		try {
			driver.findElement(By.xpath(xlocators.a_company())).sendKeys(excel_info.data_company());
			driver.findElement(By.xpath(xlocators.a_address1())).sendKeys(excel_info.data_address1());
			driver.findElement(By.xpath(xlocators.a_address2())).sendKeys(excel_info.data_address2());
			driver.findElement(By.xpath(xlocators.a_city())).sendKeys(excel_info.data_city());
			
			driver.findElement(By.id("id_state")).click();
			Select day = new Select(driver.findElement(By.id("id_state"))); 
			day.selectByValue("32"); 
			
			driver.findElement(By.xpath(xlocators.a_post())).sendKeys(String.valueOf(excel_info.data_post()));
			driver.findElement(By.xpath(xlocators.a_otherinfo())).sendKeys(excel_info.data_otherinfo());
			driver.findElement(By.xpath(xlocators.a_mobile())).sendKeys(String.valueOf(excel_info.data_mobile()));
			driver.findElement(By.xpath(xlocators.address_name())).clear();
			driver.findElement(By.xpath(xlocators.address_name())).sendKeys(excel_info.data_adressnme());
			
			
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Unable to Input Address Information";
			getscreenshot(screen);
			Assert.fail("Unable to Input Address Information");
		}
	}
	
	@And("^I complete the registeration process$")
	public void registration_proceed() throws Exception  {
		try {
			driver.findElement(By.xpath(xlocators.reg_submit())).click();
			
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Unable to Input Personal Information";
			getscreenshot(screen);
			Assert.fail("Unable to Input Personal Information");
		}
	}
	
	@And("^I verify whther I am logged In$")
	public void registration_verify() throws Exception {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.name_user())));
			Thread.sleep(1000);
			String act_verify = driver.findElement(By.xpath(xlocators.name_user())).getText();
			
			CharSequence ex_verify = excel_info.data_verification();
			
			Assertion.assertEquals(act_verify, ex_verify);
			
			driver.close();
			
			
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Unable to Input Personal Information";
			getscreenshot(screen);
			Assert.fail("Unable to Input Personal Information");
		}
	}
	
	
	
	
	
	@When("^I click on Sign in$")
	public void test_login() throws Exception {
		try {
			driver.findElement(By.xpath(xlocators.signin_link())).click();
		}
		catch (Exception e){
			e.printStackTrace();
			String screen = "Unable to click on Sign In";
			getscreenshot(screen);
			Assert.fail("Unable to click on Sign In");
		} 
	}
	

	@And("^I enter my credentials \"(.*)\" and \"(.*)\"$")
	public void test_enter_credentials(String username, String password) throws Exception {
		
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.login_email())));
			driver.findElement(By.xpath(xlocators.login_email())).sendKeys(username);
			driver.findElement(By.xpath(xlocators.login_pwd())).sendKeys(password);
			driver.findElement(By.xpath(xlocators.login_submit())).click();
			
			
			try {

				String act_nameof_user = driver.findElement(By.xpath(xlocators.name_user())).getText();
				
				String ex_nameof_user = "Aravind C";
			Assert.assertEquals(act_nameof_user,ex_nameof_user);

			
			
	}
		catch(Throwable t){
			t.printStackTrace();
			String screen = "Unable to reach Account page";
			
				getscreenshot(screen);
				MediaEntityBuilder.createScreenCaptureFromPath("Screenshots/screenshot_Unable to reach Account page.png").build();
			Assert.fail("Unable to reach Account page");
		}
	}
	

	@Then("I logged out$")
	public void test_logout()  {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.logout())));
		driver.findElement(By.xpath(xlocators.logout())).click();
		driver.close();
		Assertion.assertAll();
}

	
	@When("I search T-shirt in search box$")
	public void search_tshirt() throws Exception {
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.search_textbox())));
		driver.findElement(By.xpath(xlocators.search_textbox())).click();
		driver.findElement(By.xpath(xlocators.search_textbox())).sendKeys("T-shirt");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.search_result())));
		driver.findElement(By.xpath(xlocators.search_result())).click();
		}
		
		catch(Exception e){
			e.printStackTrace();
			String screen = "Unable to reach T-shirt Summary page";
			getscreenshot(screen);
			Assert.fail("Unable to reach T-shirt Summary page");
		}
		
}
	
	@And("I add a dress of two different colours to the cart$")
	public void tshirt_page() throws Exception {
		try {
		Thread.sleep(2000);
		driver.findElement(By.xpath(xlocators.add_to_cart())).click();
		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle());
		driver.findElement(By.xpath(xlocators.continue_button())).click();
		Thread.sleep(1000);
		driver.switchTo().window(driver.getWindowHandle());
		driver.findElement(By.xpath(xlocators.blue_color())).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(xlocators.added_to_cart())).click();
		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle());
		driver.findElement(By.xpath(xlocators.continue_button())).click();
		Thread.sleep(1000);
		driver.switchTo().window(driver.getWindowHandle());
		}
		
		catch(Exception e){
			e.printStackTrace();
			String screen = "unable to add two different color of dress";
			getscreenshot(screen);
			Assert.fail("unable to add two different color of dress");
		}
		
}
	@And("I enter my credentials that is specified in properties file$")
	public void addressUpdate_login() throws Exception{
		propertiesData.propertyData();
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.login_email())));
			driver.findElement(By.xpath(xlocators.login_email())).sendKeys(propertiesData.username());
			driver.findElement(By.xpath(xlocators.login_pwd())).sendKeys(propertiesData.password());
			driver.findElement(By.xpath(xlocators.login_submit())).click();
		}
		catch(Exception e){
			e.printStackTrace();
			String screen = "Unable to reach Account page";
			getscreenshot(screen);
			Assert.fail("Unable to reach Account page");
		}
		
	}
	
	@And("I click on My Addresses to update my address with New Address$")
	public void address_upadateaddress() throws Exception{
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.address_button())));
			driver.findElement(By.xpath(xlocators.address_button())).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.addressUpdate_button())));
			driver.findElement(By.xpath(xlocators.addressUpdate_button())).click();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.a_company())));
			driver.findElement(By.xpath(xlocators.a_company())).clear();
			driver.findElement(By.xpath(xlocators.a_company())).sendKeys(propertiesData.company());
			driver.findElement(By.xpath(xlocators.a_address1())).clear();
			driver.findElement(By.xpath(xlocators.a_address1())).sendKeys(propertiesData.address1());
			driver.findElement(By.xpath(xlocators.a_address2())).clear();
			driver.findElement(By.xpath(xlocators.a_address2())).sendKeys(propertiesData.address2());
			driver.findElement(By.xpath(xlocators.a_city())).clear();
			driver.findElement(By.xpath(xlocators.a_city())).sendKeys(propertiesData.city());
			
			driver.findElement(By.xpath(xlocators.address_savebutton())).click();
				
		}
		catch(Exception e){
			e.printStackTrace();
			String screen = "Unable to reach Account page";
			getscreenshot(screen);
			Assert.fail("Unable to reach Account page");
		}
		
	}
	
	@Then("I verify whether Address is updated$")
	public void address_verifyaddress() throws Exception{
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xlocators.addressUpdate_button())));
			String ac_company = driver.findElement(By.xpath(xlocators.verify_updatedcompany())).getText();
			String ex_company = propertiesData.company();
			Assert.assertEquals(ac_company, ex_company);
			
			String ac_address1 = driver.findElement(By.xpath(xlocators.verify_updatedaddress1())).getText();
			String ex_address1 = propertiesData.address1();
			Assert.assertEquals(ac_address1, ex_address1);
			
			String ac_address2 = driver.findElement(By.xpath(xlocators.verify_updatedaddress2())).getText();
			String ex_address2 = propertiesData.address2();
			Assert.assertEquals(ac_address2, ex_address2);
			
			String ac_city = driver.findElement(By.xpath(xlocators.verify_updatedcity())).getText();
			String ex_city = propertiesData.city();
			ac_city = ac_city.replace(ac_city.substring(ac_city.length()-1), "");
			Assert.assertEquals(ac_city, ex_city);
			
			driver.close();
				
		}
		catch(Exception e){
			e.printStackTrace();
			String screen = "Unable to reach Account page";
			getscreenshot(screen);
			Assert.fail("Unable to reach Account page");
		}
		
	}
	

		
	
	
	
	
}


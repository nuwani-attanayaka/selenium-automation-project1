package project1_openfoodfacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C1 {

			static WebDriver driver;

			public static void main(String[] args) throws InterruptedException {
				setup();
				login();
				productSearch();
				productView();
				addProduct();
				Thread.sleep(2000);
				editProduct();
				closeBrowser();
				Thread.sleep(8000);
			}

			public static String baseUrl = "https://world.openfoodfacts.org/";

			@BeforeTest
			public static void setup() {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\HP\\Downloads\\SELENIUM Files\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();

				// setting delay

				//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				//		wait.until(ExpectedConditions.urlToBe(""));

				// launch browser and redirect it to the Base URL
				driver.get(baseUrl);

				// maximizing window size
				driver.manage().window().maximize();

				// Hide banner
				driver.findElement(By.xpath("//*[@id=\"hide_image_banner\"]")).click();
			}

			@Test
			// TEST CASE 1
			public static void login() {
				String userName = "test-user12";
				String password = "Test123456";

				// Login
				driver.findElement(By.xpath("/html/body/div/div[1]/nav/section/ul[2]/li/a")).click();
				driver.findElement(By.xpath("//*[@id=\"login_user_id\"]")).sendKeys(userName);
				driver.findElement(By.xpath("//*[@id=\"login_user_password\"]")).sendKeys(password);
				driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
			}

			// TEST CASE 2
			public static void productSearch() {
				String keyword = "chips";

				// Product Search****
				driver.findElement(By.xpath("//*[@id=\"offNav\"]/nav/section/ul[1]/li/form/div/div/div/div[1]/input[1]"))
				.sendKeys(keyword);
				driver.findElement(By.xpath("//*[@id=\"offNav\"]/nav/section/ul[1]/li/form/div/div/div/div[2]/button")).click();
			}

			// TEST CASE 3
			public static void productView() {

				// Product View
				driver.findElement(By.xpath("//*[@id=\"products_match_all\"]/li[1]/a/div")).click();
			}

			// TEST CASE 4
			public static void addProduct() {
				String testImageUrl = "C:\\Users\\HP\\Pictures\\image1.jpg";

				// Add a Product
				driver.findElement(By.xpath("//*[@id=\"upNav\"]/nav/section/ul[1]/li[1]/a")).click();
				driver.findElement(By.xpath("//*[@id=\"upNav\"]/nav/section/ul[1]/li[1]/ul/li[6]/a")).click();

				// adding the image
				WebElement chooseFile = driver.findElement(By.id("imgupload_search_block_side"));
				chooseFile.sendKeys(testImageUrl);
			}

			// TEST CASE 5
			public static void editProduct() {

				/*****/
				driver.findElement(By.xpath("//*[@id=\"prodHead\"]/div/div/div/div[1]/a")).click();
				String productName = "Fresh Milk";
				// updating product name
				driver.findElement(By.xpath("//*[@id=\"product_name_en\"]")).sendKeys(productName);
				driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"main_column\"]/div/div/p[3]/a")).click();
			}

			@AfterTest
			public static void closeBrowser() {
				driver.close();
				System.out.println("The driver has been closed.");
			}

	}



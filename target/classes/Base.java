package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
public WebDriver driver=null;
	public Properties prop;
	public WebDriver initialDriver() throws IOException  {
		 prop=new Properties();
		 String dir=System.getProperty("user.dir");
		 FileInputStream path=new FileInputStream(dir+"\\src\\main\\java\\resources\\data.properties");
		 prop.load(path);
		String browsername= prop.getProperty("browser");
			System.out.println(prop.getProperty("browser"));
			if(browsername.equalsIgnoreCase("chrome"))
				WebDriverManager.chromedriver().setup();		
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		return driver;	
		
	}
	public void takescreenshot(String testname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(".\\screenshot\\"+testname+"test.png");
		FileUtils.copyFile(src,target);
	}
}

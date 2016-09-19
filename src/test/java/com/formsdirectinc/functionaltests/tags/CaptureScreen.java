package com.formsdirectinc.functionaltests.tags;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import com.formsdirectinc.functionaltests.enums.Sites;


/**
 * Captures screen where-ever required
 * 
 * @author Orina
 */
public class CaptureScreen extends BaseTag{

	public CaptureScreen(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static final String DOWNLOADED_IMAGE_PATH = "src\\test\\resources\\images\\%s\\pages\\%s-%s.png";
	
	public CaptureScreen takeScreenShot(String appName,String page) {

		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File(String.format(DOWNLOADED_IMAGE_PATH,appName,page,site)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this;
	}
	
	public CaptureScreen takeScreenShotOfElement(String appName){

		Sites site = Sites.valueOf(System.getProperty("site.name"));

		String timeStamp = new SimpleDateFormat("dd.MM.HH.mm").format(Calendar
				.getInstance().getTimeInMillis());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement pdfImage = driver.findElement(By.cssSelector("form[id='mainForm']"));
		
		WebElement panelDiv=pdfImage.findElement(By.cssSelector("div[class='panel-content panel-content-2']"));
		
		List<WebElement> imagesSRC=panelDiv.findElements(By.tagName("img"));
		
		System.out.println("Total images of the product ------->>>>>"+appName+"--->"+imagesSRC.size());
		
		for(int i=0;i<imagesSRC.size();i++)
		{
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		System.out.println("Capturing image of------->>>>>"+appName+"--Page--->"+i);
		
		final Screenshot screenshot = new AShot().takeScreenshot(driver,imagesSRC.get(i));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
        
		final BufferedImage image = screenshot.getImage();
       
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	        try {
				ImageIO.write(image, "PNG", new File("src\\test\\resources\\images\\" + appName + "\\" 
														+ i+"-"+timeStamp+"-"+site+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		return this;
	}
	
	
	
}

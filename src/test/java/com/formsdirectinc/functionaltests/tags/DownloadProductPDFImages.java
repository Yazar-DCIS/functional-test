package com.formsdirectinc.functionaltests.tags;

import java.io.File;

import org.openqa.selenium.WebDriver;



/**
 * Download the pdf-image using HTTP-Get and Setting Cookies
 * Find the differences between the images
 * 
 * @author Orina
 */
public class DownloadProductPDFImages extends BaseTag{

	public DownloadProductPDFImages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public static final String DOWNLOADED_IMAGE_PATH = "src\\test\\resources\\images\\%s\\Page %d out of %d.png";
	private static final String DEFAULT_DOWNLOAD_PATH = "src/test/resources/pdf/%s/";
	
	/* Get the latest file name from a specific directory*/
	public String getLatestFileName(String productname){
	    File dir = new File(String.format(DEFAULT_DOWNLOAD_PATH,productname));
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile.getName().replace(".pdf", "");
	}
	
	
}

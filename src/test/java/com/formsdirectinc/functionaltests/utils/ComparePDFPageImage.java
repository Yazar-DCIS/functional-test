package com.formsdirectinc.functionaltests.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
/**
 * @author Orina<br>
 * Converts the PDF Pages to Image Files , Compares the images and Highlights the Difference
 */
public class ComparePDFPageImage {
	 
	
		
	private static final String ACTUAL_IMAGE_PATH = "src/test/resources/imagediff/%s/actual/%s-Page %d out of %d.png";
	private static final String EXPECTED_IMAGE_PATH = "src/test/resources/imagediff/%s/expected/%s-Page %d out of %d.png";
	private static final String DIFF_IMAGE_PATH = "src/test/resources/imagediff/%s/diff/%s-Page %d out of %d.png";
    
	
	public void comparePDFPageImages(String product,String flowname,int page,int totalPages) throws IOException {
    	    	
    	
		InputStream actualImagePath = new FileInputStream(String.format(ACTUAL_IMAGE_PATH, product,flowname,page,totalPages));
    	BufferedImage actualImage = ImageIO.read(actualImagePath);
    	
    	InputStream expectedImagePath = new FileInputStream(String.format(EXPECTED_IMAGE_PATH, product,flowname,page,totalPages));
    	BufferedImage expectedImage = ImageIO.read(expectedImagePath);
    	
    	
    	ImageDiff diffResult = new ImageDiffer().makeDiff(actualImage, expectedImage);
    	
    	if(diffResult.hasDiff())
    	{
    		BufferedImage diffImageResult = diffResult.getMarkedImage();
    		ImageIO.write(diffImageResult, "png", new File(String.format(DIFF_IMAGE_PATH, product,flowname,page,totalPages)));
    	}
    	
       	
       	
    }
    
   
}

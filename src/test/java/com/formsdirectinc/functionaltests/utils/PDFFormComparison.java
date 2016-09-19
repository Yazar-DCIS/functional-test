package com.formsdirectinc.functionaltests.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/**
 * @author Orina<BR>
 *         Takes the PDF Forms as input(actual, expected) and compares and lists
 *         their differences in image
 */
public class PDFFormComparison {

	public static final String DOWNLOADED_PDF_PATH = "src\\test\\resources\\pdf\\%s\\%s\\%s.pdf";
	private static final String PDFIMAGE_PATH = "src/test/resources/imagediff/%s/%s/%s-Page %d out of %d.png";
	private static final String CONSOLE_MESSAGE = "The total pages for %s file of product %s in Flow %s are %d";
	
	@Test
	@Parameters({ "product", "flowname","pdfFileName","fileType","pageNumber","formStartPageNumber","formEndPageNumber"})
	
	public void pdfImageAndContentCompare(String product, String flowname,String pdfFileName,String fileType,int pageNumber,int formStartPageNumber, int formEndPageNumber) throws IOException, NotFoundException,
			ChecksumException, FormatException {

		pdfFileName = String.format(DOWNLOADED_PDF_PATH, product, fileType,pdfFileName);

		File pdfFile = new File(pdfFileName);
		
		PDDocument pdfDoc = PDDocument.load(pdfFile);
		PDFRenderer pdfRenderer = new PDFRenderer(pdfDoc);

		System.out.println(String.format(CONSOLE_MESSAGE, fileType,product,flowname,pdfDoc.getPages().getCount()));
		
		for (PDPage page : pdfDoc.getPages()) {
	
			//System.out.println(pdfDoc.getPages().getCount());
			
			BufferedImage pdfPageImage = pdfRenderer.renderImageWithDPI((pageNumber-1), 300,ImageType.RGB);
			
			if(fileType.equals("expected"))
			{
				ImageIOUtil.writeImage(pdfPageImage, String.format(PDFIMAGE_PATH, product,fileType,flowname, (pageNumber++)+formStartPageNumber, pdfDoc.getPages().getCount()+formEndPageNumber), 300);

			}
			
			if(fileType.equals("actual"))
			{
				ImageIOUtil.writeImage(pdfPageImage, String.format(PDFIMAGE_PATH, product,fileType,flowname, (pageNumber++), pdfDoc.getPages().getCount()), 300);
				ComparePDFPageImage imageDifference=new ComparePDFPageImage();
				imageDifference.comparePDFPageImages(product, flowname,(pageNumber-1), pdfDoc.getPages().getCount());
			}
			
		}

		
	}

}

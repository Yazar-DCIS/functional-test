package com.formsdirectinc.qa.utils;

import java.io.File;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CleanFolderContents {

	private static final String PDF_DIRECTORY = "build" + File.separator
			+ "test-output" + File.separator + "pdf" + File.separator + "%s"
			+ File.separator + "actual" + File.separator;
	private static final String IMAGE_DIRECTORY = "build" + File.separator
			+ "test-output" + File.separator + File.separator + "images"
			+ File.separator + "%s" + File.separator + "pages" + File.separator;
	private static final String CONTENT_DIFF_DIRECTORY = "build"
			+ File.separator + "test-output" + File.separator + File.separator
			+ "contentdiff" + File.separator + "%s" + File.separator;
	private static final String IMAGE_DIFF_DIRECTORY = "build" + File.separator
			+ "test-output" + File.separator + File.separator + "imagediff"
			+ File.separator + "%s" + File.separator;

	@Test
	@Parameters({ "product", "directory" })
	public void cleanFolders(String product, String directory) {

		if (directory.equalsIgnoreCase("pdf")) {
			directory = String.format(PDF_DIRECTORY, product, product);
		} else if (directory.equalsIgnoreCase("images")) {
			directory = String.format(IMAGE_DIRECTORY, product, product);
		} else if (directory.equalsIgnoreCase("imagediff")) {
			directory = String.format(CONTENT_DIFF_DIRECTORY, product, product);
		} else if (directory.equalsIgnoreCase("contentdiff")) {
			directory = String.format(IMAGE_DIFF_DIRECTORY, product, product);
		}

		File file = new File(directory);
		String[] myFiles;
		if (file.isDirectory()) {
			myFiles = file.list();
			for (int i = 0; i < myFiles.length; i++) {
				File myFile = new File(file, myFiles[i]);
				myFile.delete();
			}
		}
	}

}
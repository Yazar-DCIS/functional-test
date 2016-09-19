package com.formsdirectinc.functionaltests.tags;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class for Generating EMail
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */

public class GenerateMail {

	public String generateEmail(String product) {

		String siteName = System.getProperty("site.name");
		String timeStamp = new SimpleDateFormat("dd.MM.HH.mm.ss")
				.format(Calendar.getInstance().getTimeInMillis());
		String email = product + "." + siteName + "." + timeStamp + "@dcis.net";
		return email;
	}

	public void writeMail_ID(String email) throws IOException {
		File fileData = new File("src/test/resources/properties/userData");
		String absolutePathName = fileData.getAbsolutePath();
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
				absolutePathName), true));
		try {
			writer.newLine();
			writer.write("User Data---->" + email);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
	}

}

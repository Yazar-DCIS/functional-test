package com.formsdirectinc.qa.driverprofile;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Class for FirefoxDriverProfile
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */

public class FirefoxDriverProfile {

	private static final String DEFAULT_DOWNLOAD_PATH = "build"
			+ File.separator + "test-output" + File.separator + "pdf"
			+ File.separator + "%s" + File.separator + "actual"
			+ File.separator;

	public FirefoxProfile firefoxProfile(String productName) throws Exception {

		FirefoxProfile firefoxProfile = new FirefoxProfile();

		File file = new File(String.format(DEFAULT_DOWNLOAD_PATH, productName));

		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.dir",
				file.getAbsolutePath());
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/pdf,application/octet-stream");
		firefoxProfile.setPreference("pdfjs.disabled", true);
		firefoxProfile.setPreference("plugin.scan.plid.all", false);
		firefoxProfile.setPreference("plugin.scan.Acrobat", "99.0");
		return firefoxProfile;

	}

}

package helper;

import static driver.DriverFactory.GetDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class FileHelper {

	public static void TakeScreenShot() {
		try {
			File scrFile = ((TakesScreenshot)GetDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./src/test/resources/prints/" + GetTimeToNameScreenShot() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private static String GetTimeToNameScreenShot() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		return new SimpleDateFormat("hhmmss").format(ts);
	}
}

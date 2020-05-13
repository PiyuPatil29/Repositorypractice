package crossbrowser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase1 {
	@Parameters("Browsername")
	@Test
 public void openBrowsers(String browsername) {
	Config.openBrowser(browsername);
	System.out.println("All browser opened ");
	}

}



package common;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/*
 * To generate customized html report
*/

public class ReportHelper {

    static String testname;
	public static ExtentReports reporter;
	public static Map<String, ExtentTest> nameToTestMap = new HashMap<String, ExtentTest>();

	private synchronized static ExtentReports getExtentReport() {
		if (reporter == null) {
			reporter = new ExtentReports("test-output/ExtentReport.html", true, DisplayOrder.NEWEST_FIRST);
		}
		return reporter;
	}

	public synchronized static ExtentTest getTest(String testName, String testDescription) {
		if (!nameToTestMap.containsKey(testName)) {
			testname= testName;
			
			ExtentTest test = getExtentReport().startTest(testName, testDescription);
			nameToTestMap.put(testName, test);
		}
		return nameToTestMap.get(testName);
	}

	public synchronized static ExtentTest getTest(String testName) {
		return getTest(testName, "");
	}


	public synchronized static void closeTest(String testName) {

		if (!testName.isEmpty()) {
			ExtentTest test = getTest(testName);
			getExtentReport().endTest(test);
		}
	}

	public synchronized static void closeTest(ExtentTest test) {
		if (test != null) {
			getExtentReport().endTest(test);
		}
	}

	public synchronized static void closeTest()  {
		ExtentTest test = getTest(testname);
		closeTest(test);
	}

	public synchronized static void closeReport() {
		if (reporter != null) {
			reporter.flush();
			reporter.close();
		}
	}
}

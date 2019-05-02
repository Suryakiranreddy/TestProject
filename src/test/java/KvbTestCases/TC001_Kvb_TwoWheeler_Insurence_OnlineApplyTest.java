package KvbTestCases;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.Screenshot;
import Common.TestDataProvider;
import KvbPages.Kvb_TwoWheeler_Insurence_OnlineApply;
import TestBase.TestBase;

public class TC001_Kvb_TwoWheeler_Insurence_OnlineApplyTest extends TestBase {
	
	Kvb_TwoWheeler_Insurence_OnlineApply OnlineApply;
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("KvbTestDataFilePath"),Repository.getProperty("TwoWheelerInsurenceTestData"));
		return data;
	}
	
	@BeforeClass
	public void TestEngine() {
		try {
			OnlineApply=new Kvb_TwoWheeler_Insurence_OnlineApply(driver);
			init();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider="testData")
	public void TwoWheeler_Insurence_OnlineApplyTest(String stateCode,String stateCodedigit,String areaCode,String number,String firstName,
			String lastName,String mobileNumber,String emailAddress,String vehicleMakevisibleText,String vehicleModelvisibleText ,String vehicleSubTypevisibleText
			,String engineNumber,String chasisNumber,String cc,String RegistrationDate,String RegistrationMonth,
			String RegistrationYear,String VehicleRegistrationcity,String Pincode,String existingInsurer, String ExistingPolicyNumber, String Existingpolicyexpirydate,
			String ExistingpolicyexpiryMonth,String ExistingpolicyexpiryYear, String Tenureofyourcurrent,
			String NCBonyourcurrent,String runmode) {
		
		try {
			test.assignCategory("RegressionTest");
			if (runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			Screenshot.infoScreenshot(driver, "AndhraBankL_OnlineApply_CarLoanProcess");
			OnlineApply.twoWheeler_Insurence_OnlineApply(stateCode, stateCodedigit, areaCode, number, firstName, lastName, mobileNumber, emailAddress, vehicleMakevisibleText, vehicleModelvisibleText, vehicleSubTypevisibleText, engineNumber, chasisNumber, cc, RegistrationDate, RegistrationMonth, RegistrationYear, VehicleRegistrationcity, Pincode);
			OnlineApply.existingPolicy(existingInsurer, ExistingPolicyNumber, Existingpolicyexpirydate, ExistingpolicyexpiryMonth, ExistingpolicyexpiryYear, Tenureofyourcurrent,NCBonyourcurrent);
			Screenshot.infoScreenshot(driver, "AndhraBankL_OnlineApply_CarLoanProcess");
	
		} catch (Exception e) {
			e.getMessage();
		}
	}
	/*@AfterClass(alwaysRun = true)
	public void endreport() {
		closeBrowser();
	}*/

}

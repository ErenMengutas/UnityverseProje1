package tests.Us_001;

import com.aventstack.extentreports.ExtentTest;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Us01_tekrarlananAdimlar {
    public static void tekarlananAdimlar(ExtentTest extentTest, SoftAssert softAssert)
    {

        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        extentTest.info("Kullanici url'e gider");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        extentTest.pass("Sayfaya gittiğini dogrular");
        String expectedTitle="Test Otomasyonu";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Title bilgileri gecerli değil.");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        extentTest.info("Account linkine tıklar");
        testOtomasyonuFormPage.toAnaSayfaAccLinki.click();

        extentTest.info("Sign up linkine tıklar");
        testOtomasyonuFormPage.toLoginSayfasiSignUpButonu.click();

        extentTest.info("Register now sayfasinda olduğunu doğrular");
        softAssert.assertTrue(testOtomasyonuFormPage.registerNowYaziElementi.isDisplayed(),"Register now sayfasında olduğu doğrulanamadı");

        softAssert.assertAll();


    }
}

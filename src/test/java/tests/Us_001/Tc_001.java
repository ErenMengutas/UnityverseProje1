package tests.Us_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class Tc_001 extends ExtentReport {

    @Test
    public void registerSayfasıGoruntulemeTesti()
    {
        SoftAssert softAssert=new SoftAssert();
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();

        extentTest=extentReports.createTest("Form kontrol testi",
                "Kullanıcı kayıt formunun görünür olduğunu test eder");

        //Kullanıcı url'e gider-Sayfaya gittigini dogrular-Account linkine tıklar-Register now sayfasında olduğunu doğrular
        Us01_tekrarlananAdimlar.tekarlananAdimlar(extentTest,softAssert);

        extentTest.pass("Kullanıcı register sayfasında firstname, lastname, email, " +
                "password, confirm password, sign up butonlarının görünür olduğunu doğrular");



        softAssert.assertTrue(testOtomasyonuFormPage.firtNameButonu.isDisplayed(),"first name butonu gözükmüyor");
        softAssert.assertTrue(testOtomasyonuFormPage.lastNameButonu.isDisplayed(),"last name butonu gözükmüyor");
        softAssert.assertTrue(testOtomasyonuFormPage.emailAddressButonu.isDisplayed(),"email butonu gözükmüyor");
        softAssert.assertTrue(testOtomasyonuFormPage.passwordButonu.isDisplayed(),"password butonu gözükmüyor");
        softAssert.assertTrue(testOtomasyonuFormPage.confirmPasswordButonu.isDisplayed(),"confirmPassword butonu gözükmüyor");
        softAssert.assertTrue(testOtomasyonuFormPage.registerSayfasiSignUpButonu.isDisplayed(),"sign up butonu gözükmüyor");


        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.info("Sayfayı kapatır");

        softAssert.assertAll();

    }
}

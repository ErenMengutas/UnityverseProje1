package tests.Us_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class Tc_003 extends ExtentReport {


    @Test
    public void negatifLoginTesti()
{
    SoftAssert softAssert=new SoftAssert();
    TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();

    extentTest=extentReports.createTest("Negatif login testi",
            "Kullanıcı kayıt formunu doldurmadan kayıt oluşturamamalı");

    //Kullanıcı url'e gider-Sayfaya gittigini dogrular-Account linkine tıklar-Register now sayfasında olduğunu doğrular
    Us01_tekrarlananAdimlar.tekarlananAdimlar(extentTest,softAssert);

    extentTest.info("Form bilgilerini eksik bırakir");

    extentTest.info("Sign in butonuna tiklar");

    testOtomasyonuFormPage.registerSayfasiSignUpButonu.click();

    extentTest.pass("Tum bilgiler icin required uyarisi verildigini dogrular");
    softAssert.assertTrue(testOtomasyonuFormPage.firstNameRequiredYaziElementi.isDisplayed(),"First name is required yazısı gözükmemekte");
    softAssert.assertTrue(testOtomasyonuFormPage.lastNameRequiredYaziElementi.isDisplayed(),"Last name is required yazısı gözükmemekte");
    softAssert.assertTrue(testOtomasyonuFormPage.emailAdressRequiredYaziElementi.isDisplayed(),"Email Adress is required yazısı gözükmemekte");
    softAssert.assertTrue(testOtomasyonuFormPage.passwordRequiredYaziElementi.isDisplayed(),"Password required yazısı gözükmemekte");
    softAssert.assertTrue(testOtomasyonuFormPage.confirmPasswordRequiredYaziElementi.isDisplayed(),"Confirm password required yazısı gözükmemekte");

    extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

    extentTest.pass("Register Now yazı elementinin gözültüğünü doğrular");
    softAssert.assertTrue(testOtomasyonuFormPage.registerNowYaziElementi.isDisplayed());

    extentTest.info("Sayfayı kapatır");


    softAssert.assertAll();


  }
}

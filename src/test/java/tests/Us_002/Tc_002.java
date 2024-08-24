package tests.Us_002;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

import java.time.Duration;

public class Tc_002 extends ExtentReport {
    @Test (groups = "E2E")
    public void profilEkranıElmentleri()
    {
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait=new  WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        extentTest=extentReports.createTest("Kullanıcı Profil ekrani elementleri",
                "Kullanici profile girer ve MyProfile, My Orders, Wishlist, Manage Adress,change password ve Logout elementlerinin görünür olduğunu doğrular");

        extentTest.info("Kullanıcı url'e gider");
        Driver.getDriver().get(ConfigReader.getProperty("url"));


        extentTest.pass("Sayfaya gittigini dogrular");
        String expectedTitle="Test Otomasyonu";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Title bilgileri gecerli değil.");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        extentTest.info("Account linkine tiklar");
        testOtomasyonuFormPage.toAnaSayfaAccLinki.click();


        extentTest.pass("Login sayfasında olduğunu doğrular");
        String expectedLoginYazisi="Login Now";
        String actualLoginYazisi=testOtomasyonuFormPage.loginSayfasıLoginNowYaziElementi.getText();
        softAssert.assertEquals(actualLoginYazisi,expectedLoginYazisi,"Login sayfası doğrulaması yapılamadı");


        extentTest.info("Email ve password alanlarinin gorunur oldugunu dogrula");
        softAssert.assertTrue(testOtomasyonuFormPage.loginSayfasıEmailButonu.isDisplayed(),"email butonu gözükmüyor");
        softAssert.assertTrue(testOtomasyonuFormPage.loginSayfasıPassButonu.isDisplayed(),"password butonu gözükmüyor");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        extentTest.info("Gecerli email ve password ile giriş yapar");
        testOtomasyonuFormPage.loginSayfasıEmailButonu.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        testOtomasyonuFormPage.loginSayfasıPassButonu.sendKeys(ConfigReader.getProperty("gecerliPass"));

        extentTest.info("Sign in butonuna tıklar");
        testOtomasyonuFormPage.loginSayfasıSigninButonu.click();

        extentTest.pass("Login Success yazisinin görüntülendiğini dogrular");
        wait.until(ExpectedConditions.visibilityOf(testOtomasyonuFormPage.loginSuccessElementi));
        softAssert.assertTrue(testOtomasyonuFormPage.loginSuccessElementi.isDisplayed(),"Login success yazisi gözükmüyor.");

        extentTest.pass("Kullanici profilinde olduğunu dogrular");
        softAssert.assertTrue(testOtomasyonuFormPage.profilYazıElementi.isDisplayed(),"kullanici profilinde olduğu doğrulanamadı.");

        extentTest.pass("Kullanici profilinde My Profile butonunun gorunurlugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.myProfileElementi.isDisplayed());

        extentTest.pass("Kullanici profilinde My Wishlist butonunun gorunurlugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.wishListElementi.isDisplayed());

        extentTest.pass("Kullanici profilinde Manage Adress butonunun gorunurlugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.manageAdressElementi.isDisplayed());

        extentTest.pass("Kullanici profilinde  change password butonunun gorunurlugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.changePasswordElementi.isDisplayed());

        extentTest.pass("Kullanici profilinde Logout butonunun gorunurlugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.logoutElementi.isDisplayed());

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        softAssert.assertAll();

    }
}

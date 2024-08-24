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

public class Tc_001 extends ExtentReport {
    @Test
    public void accountProfilGoruntulemeTesti()
    {
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        extentTest=extentReports.createTest("Kullanıcı gecerli email ve sifre ile giriş yapar",
                        "email ve sifre girilmeli ve sistemde Account bolumunde bilgiler gorunmeli");

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


        extentTest.info("Email ve password alanlarinin gorunur oldugunu dogrular");
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

        extentTest.pass("Kullanici profilindeki first name,last name ve email yazılarının görüntülendğini test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.profilFirstNameYaziElementi.isDisplayed(),"First name yazisi gözükmüyor");
        softAssert.assertTrue(testOtomasyonuFormPage.profilLastNameYaziElementi.isDisplayed(),"Last name yazisi gözükmüyor");
        softAssert.assertTrue(testOtomasyonuFormPage.profilEmailYaziElementi.isDisplayed(),"Email yazisi gözükmüyor");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        softAssert.assertAll();
    }
}

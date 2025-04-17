package tests.Us_001;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class Tc_004 extends ExtentReport {
    @Test
    public void gecersizEmailIleKayıt()
    {

        SoftAssert softAssert=new SoftAssert();
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        Faker faker=new Faker();

        extentTest=extentReports.createTest("Gecersiz kayıt testi",
                                            "Kullanıcı gecersiz email ile sisteme kayıt olamamalı");

        //Kullanıcı url'e gider-Sayfaya gittigini dogrular-Account linkine tıklar-Register now sayfasında olduğunu doğrular
        Us01_tekrarlananAdimlar.tekarlananAdimlar(extentTest,softAssert);

        extentTest.info("Register sayfasındaki formu gecersiz email girerek kayıt olur.");
        String fakeName=faker.name().firstName();
        String fakaLastName=faker.name().lastName();
        String fakePass=faker.internet().password();
        String fakeEmail=faker.internet().emailAddress();

        fakeEmail=fakeEmail.replace("@","");

        testOtomasyonuFormPage.firtNameButonu.sendKeys(fakeName);
        testOtomasyonuFormPage.lastNameButonu.sendKeys(fakaLastName);
        testOtomasyonuFormPage.emailAddressButonu.sendKeys(fakeEmail);
        testOtomasyonuFormPage.passwordButonu.sendKeys(fakePass);
        testOtomasyonuFormPage.confirmPasswordButonu.sendKeys(fakePass);
        testOtomasyonuFormPage.registerSayfasiSignUpButonu.click();
        ReusableMethods.bekle(2);
        testOtomasyonuFormPage.loginSayfasıEmailButonu.sendKeys(fakeEmail);
        testOtomasyonuFormPage.loginSayfasıPassButonu.sendKeys(fakePass);
        testOtomasyonuFormPage.loginSayfasıSigninButonu.click();

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));



        extentTest.info("Giriş yapılamadiğini test eder.");
        softAssert.assertTrue(testOtomasyonuFormPage.loginSayfasıEmailButonu.isDisplayed(),"Sisteme giriş yapildi");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        softAssert.assertAll();




    }
}

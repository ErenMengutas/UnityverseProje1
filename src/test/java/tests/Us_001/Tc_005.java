package tests.Us_001;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class Tc_005 extends ExtentReport {

    @Test
    public void gecersizPassword()
    {
        SoftAssert softAssert=new SoftAssert();
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        Faker faker=new Faker();

        extentTest=extentReports.createTest("Gecersiz Password testi",
                                            "Kullanıcı password ve confirm password alanlarına farklı şifreler girememeli");

        //Kullanıcı url'e gider-Sayfaya gittigini dogrular-Account linkine tıklar-Register now sayfasında olduğunu doğrular
        Us01_tekrarlananAdimlar.tekarlananAdimlar(extentTest,softAssert);

        extentTest.info("Register sayfasındaki formu farklı şifreler girerek kayıt olur.");
        String fakeName=faker.name().firstName();
        String fakaLastName=faker.name().lastName();
        String fakePass=faker.internet().password();
        String fakeEmail=faker.internet().emailAddress();

        testOtomasyonuFormPage.firtNameButonu.sendKeys(fakeName);
        testOtomasyonuFormPage.lastNameButonu.sendKeys(fakaLastName);
        testOtomasyonuFormPage.emailAddressButonu.sendKeys(fakeEmail);
        testOtomasyonuFormPage.passwordButonu.sendKeys(fakePass);
        testOtomasyonuFormPage.confirmPasswordButonu.sendKeys(faker.internet().password());
        testOtomasyonuFormPage.registerSayfasiSignUpButonu.click();


        extentTest.pass("Confirm password uyarı yazısının çıktığını doğrular");
        softAssert.assertTrue(testOtomasyonuFormPage.confirmPasswordUyariYazisi.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.info("Sayfayı kapatır");


        softAssert.assertAll();


    }



}

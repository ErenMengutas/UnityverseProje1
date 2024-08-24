package tests.Us_001;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class Tc_002 extends ExtentReport{


    @Test(groups = "E2E")
    public void accountOlusturmaTesti()
    {
        SoftAssert softAssert=new SoftAssert();
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();

        Faker faker=new Faker();

        extentTest=extentReports.createTest("Account olusturma testi",
                "Kullanıcı girmiş olduğu geçerli bilgilerle kayıt oluşturabilmeli");

        //Kullanıcı url'e gider-Sayfaya gittigini dogrular-Account linkine tıklar-Register now sayfasında olduğunu doğrular
        Us01_tekrarlananAdimlar.tekarlananAdimlar(extentTest,softAssert);

        extentTest.info("Register sayfasındaki formu doldurarak kayıt olur.");
        String fakeName=faker.name().firstName();
        String fakaLastName=faker.name().lastName();
        String fakePass=faker.internet().password();
        String fakeEmail=faker.internet().emailAddress();

        testOtomasyonuFormPage.firtNameButonu.sendKeys(fakeName);
        testOtomasyonuFormPage.lastNameButonu.sendKeys(fakaLastName);
        testOtomasyonuFormPage.emailAddressButonu.sendKeys(fakeEmail);
        testOtomasyonuFormPage.passwordButonu.sendKeys(fakePass);
        testOtomasyonuFormPage.confirmPasswordButonu.sendKeys(fakePass);
        testOtomasyonuFormPage.registerSayfasiSignUpButonu.click();


        extentTest.info("Oluşturulmuş olan kullanici email ve şifre ile sisteme giriş yapar");
        testOtomasyonuFormPage.loginSayfasıEmailButonu.sendKeys(fakeEmail);
        testOtomasyonuFormPage.loginSayfasıPassButonu.sendKeys(fakePass);
        testOtomasyonuFormPage.loginSayfasıSigninButonu.click();



        extentTest.pass("Kullanici oluşturulmuş email ve şifre ile giriş yapılabildiğini test eder.");
        softAssert.assertTrue(testOtomasyonuFormPage.profilYazıElementi.isDisplayed());

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));
        softAssert.assertAll();



    }
}

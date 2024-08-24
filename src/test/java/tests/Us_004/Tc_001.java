package tests.Us_004;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class Tc_001 extends ExtentReport {
    @Test
    public void sepeteUrunEkleme()
    {
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        SoftAssert softAssert=new SoftAssert();
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();


        extentTest=extentReports.createTest("Kullanici sepete ürün ekler",
                                        "Kullanici her kategoride rastgele sectigi 3 ürünü sepete ekleyebilmelidir");

        extentTest.info("Kullanıcı url'e gider");
        Driver.getDriver().get(ConfigReader.getProperty("url"));


        extentTest.pass("Sayfaya gittigini dogrular");
        String expectedTitle="Test Otomasyonu";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Title bilgileri gecerli değil.");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Top selling product bölümünün görünüz oldğunu test eder");
        actions.moveToElement(testOtomasyonuFormPage.topSellingProducts).perform();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertTrue(testOtomasyonuFormPage.topSellingProducts.isDisplayed());

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.info("View all product linkine tıklar");
        testOtomasyonuFormPage.topSellingProductsViewAll.click();

        extentTest.info("Rastgele 3 ürünü sepete ekler");

        List<WebElement> topSellingList=new ArrayList<>();

        for (WebElement each:testOtomasyonuFormPage.topSellinUrunElementleriList)
        {
                topSellingList.add(each);

        }

        for (int i = 0; i <3 ; i++)
        {
            int randomNum=faker.number().numberBetween(0,16);

            actions.moveToElement(topSellingList.get(randomNum)).perform();

            topSellingList.get(randomNum).click();
            testOtomasyonuFormPage.addToCart.click();
            Driver.getDriver().navigate().back();

        }

        extentTest.info("Sepete gider");
        ReusableMethods.click(testOtomasyonuFormPage.yourCartButonu);


        extentTest.info("Sepete ürün eklendiğini test eder.");
        softAssert.assertTrue(testOtomasyonuFormPage.continueButonu.isDisplayed());

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.info("Sayfayı kapatır");

        softAssert.assertAll();
    }



}

package tests.Us_003;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class Tc_001 extends ExtentReport {
    @Test
    public void kategoriLinkleriTesti()
    {
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        SoftAssert softAssert=new SoftAssert();


        extentTest=extentReports.createTest("Kategori linkleri testi",
                "Kullanıcı kategori linklerinin kullanilabilir olduğunu doğrular");

        extentTest.info("Kullanıcı url'e gider");
        Driver.getDriver().get(ConfigReader.getProperty("url"));


        extentTest.pass("Sayfaya gittigini dogrular");
        String expectedTitle="Test Otomasyonu";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Title bilgileri gecerli değil.");
        ReusableMethods.bekle(1);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("'Electronics' kategorisinin kullanılabilir olduğunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.electronicLinki.isEnabled());

        extentTest.info("'Electronics' linkine tıklar");
        testOtomasyonuFormPage.electronicLinki.click();

        extentTest.pass("Sayfa urlsinin https://testotomasyonu.com/category/7/products olduğunu test eder.");
        String expectedElectronicUrl="https://testotomasyonu.com/category/7/products";
        String actualElectronicUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualElectronicUrl,expectedElectronicUrl);

        extentTest.pass("Acilan sayfanin 'Electronics' bolumu oldugunu test eder");
        String expectedElectronicTitle="Test Otomasyonu - Electronics";
        String actualElectronicTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualElectronicTitle,expectedElectronicTitle);

        ReusableMethods.bekle(1);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("'Men Fashion' kategorisinin kullanılabilir olduğunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.menFashionLinki.isEnabled());

        extentTest.info("'Men Fashion' linkine tıklar");
        testOtomasyonuFormPage.menFashionLinki.click();

        extentTest.pass("Sayfa urlsinin https://testotomasyonu.com/category/1/products olduğunu test eder.");
        String expectedMenFashionUrl="https://testotomasyonu.com/category/1/products";
        String actualManFashionUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualManFashionUrl,expectedMenFashionUrl);

        extentTest.pass("Acilan sayfanin 'Men Fashion' bolumu oldugunu test eder");
        String expectedMenFashionTitle="Test Otomasyonu - Men Fashion";
        String actualMenFashionTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualMenFashionTitle,expectedMenFashionTitle);

        ReusableMethods.bekle(1);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        extentTest.pass("'Women Fashion' kategorisinin kullanılabilir olduğunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.womenFashionLinki.isEnabled());

        extentTest.info("'Women Fashion' linkine tıklar");
        testOtomasyonuFormPage.womenFashionLinki.click();

        extentTest.pass("Sayfa urlsinin https://testotomasyonu.com/category/2/products olduğunu test eder.");
        String expectedWomenFashionUrl="https://testotomasyonu.com/category/2/products";
        String actualWomenFashionUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualWomenFashionUrl,expectedWomenFashionUrl);

        extentTest.pass("Acilan sayfanin 'Women Fashion' bolumu oldugunu test eder");
        String expectedWomenFashionTitle="Test Otomasyonu - Women Fashion";
        String actualWomenFashionTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualWomenFashionTitle,expectedWomenFashionTitle);

        ReusableMethods.bekle(1);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("'Shoes' kategorisinin kullanılabilir olduğunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.shoesLinki.isEnabled());

        extentTest.info("'Shoes' linkine tıklar");
        testOtomasyonuFormPage.shoesLinki.click();

        extentTest.pass("Sayfa urlsinin https://testotomasyonu.com/category/3/products olduğunu test eder.");
        String expectedShoesnUrl="https://testotomasyonu.com/category/3/products";
        String actualShoesUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualShoesUrl,expectedShoesnUrl);


        extentTest.pass("Acilan sayfanin 'Shoes' bolumu oldugunu test eder");
        String expectedShoesTitle="Test Otomasyonu - Shoes";
        String actualShoesTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(expectedShoesTitle,actualShoesTitle);

        ReusableMethods.bekle(1);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("'Furniture' kategorisinin kullanılabilir olduğunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.furnitureLinki.isEnabled());

        extentTest.info("'Furniture' linkine tıklar");
        testOtomasyonuFormPage.furnitureLinki.click();

        extentTest.pass("Sayfa urlsinin https://testotomasyonu.com/category/8/products olduğunu test eder.");
        String expectedFurniturenUrl="https://testotomasyonu.com/category/8/products";
        String actualFurnitureUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualFurnitureUrl,expectedFurniturenUrl);


        extentTest.pass("Acilan sayfanin 'Furniture' bolumu oldugunu test eder");
        String expectedFurnitureTitle="Test Otomasyonu - Furniture";
        String actualFurnitureTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(expectedFurnitureTitle,actualFurnitureTitle);

        ReusableMethods.bekle(1);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        extentTest.pass("'Travel' kategorisinin kullanılabilir olduğunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.travelLinki.isEnabled());

        extentTest.info("'Travel' linkine tıklar");
        testOtomasyonuFormPage.travelLinki.click();

        extentTest.pass("Sayfa urlsinin https://testotomasyonu.com/category/5/products olduğunu test eder.");
        String expectedTravelUrl="https://testotomasyonu.com/category/5/products";
        String actualTravelUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualTravelUrl,expectedTravelUrl);


        extentTest.pass("Acilan sayfanin 'Travel' bolumu oldugunu test eder");
        String expectedTravelTitle="Test Otomasyonu - Travel";
        String actualTravelTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(expectedTravelTitle,actualTravelTitle);

        ReusableMethods.bekle(1);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("'Kids Wear' kategorisinin kullanılabilir olduğunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.kidsWearLinki.isEnabled());

        extentTest.info("'Kids Wear' linkine tıklar");
        testOtomasyonuFormPage.kidsWearLinki.click();

        extentTest.pass("Sayfa urlsinin https://testotomasyonu.com/category/6/products olduğunu test eder.");
        String expectedKidsWearlUrl="https://testotomasyonu.com/category/6/products";
        String actualKidsWearUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualKidsWearUrl,expectedKidsWearlUrl);


        extentTest.pass("Acilan sayfanin 'Kids Wear' bolumu oldugunu test eder");
        String expectedKidsWearTitle="Test Otomasyonu - Kids Wear";
        String actualKidsWearTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualKidsWearTitle,expectedKidsWearTitle);

        ReusableMethods.bekle(1);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("'Grocery' kategorisinin kullanılabilir olduğunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.groceryLinki.isEnabled());

        extentTest.info("'Grocery' linkine tıklar");
        testOtomasyonuFormPage.groceryLinki.click();

        extentTest.pass("Sayfa urlsinin https://testotomasyonu.com/category/4/products olduğunu test eder.");
        String expectedGrocerylUrl="https://testotomasyonu.com/category/4/products";
        String actualGroceryUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualGroceryUrl,expectedGrocerylUrl);


        extentTest.pass("Acilan sayfanin 'Grocery' bolumu oldugunu test eder");
        String expectedGroceryTitle="Test Otomasyonu - Grocery";
        String actualGroceryTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualGroceryTitle,expectedGroceryTitle);

        ReusableMethods.bekle(1);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        softAssert.assertAll();
    }
}

package tests.Us_004;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import java.util.ArrayList;
import java.util.List;

public class Tc_002 extends ExtentReport {
    @Test
    public void test01()
    {
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        SoftAssert softAssert=new SoftAssert();
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));

        extentTest=extentReports.createTest("Sepete ürün ekleme",
                                    "Sepete eklenen ürünler ile sayfadaki ürünlerin ayni oldugu test edilmeli");


        extentTest.info("Kullanıcı url'e gider");
        Driver.getDriver().get(ConfigReader.getProperty("url"));


        extentTest.pass("Sayfaya gittigini dogrular");
        String expectedTitle="Test Otomasyonu";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Title bilgileri gecerli değil.");


        extentTest.pass("Top selling product bölümünün görünüz oldğunu test eder");
        actions.moveToElement(testOtomasyonuFormPage.topSellingProducts).perform();
        softAssert.assertTrue(testOtomasyonuFormPage.topSellingProducts.isDisplayed(),"Top selling bölümü gözükmüyor");


        extentTest.info("View all product linkine tıklar");
        testOtomasyonuFormPage.topSellingProductsViewAll.click();

        extentTest.pass("Sayfa url'sinin https://testotomasyonu.com/trending/all-products oldugunu test eder");
        String expectedUrl="https://testotomasyonu.com/trending/all-products";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Trending url eşleşmiyor");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));



        extentTest.pass("ürün listesinde 0 dan fazla ürün olduğunu test eder.");

        List<WebElement> ürünListesi=new ArrayList<>();

        for (WebElement each:testOtomasyonuFormPage.topSellinUrunElementleriList)
        {
            ürünListesi.add(each);

        }

        softAssert.assertTrue(ürünListesi.size()>0,"Listede ki ürün miktarı sıfır");

        extentTest.info("Listedeki ilk ürünün üzerine gider");
        actions.moveToElement(testOtomasyonuFormPage.topSellingIlkUrun).perform();
        WebElement ilkUrun= testOtomasyonuFormPage.topSellingIlkUrun;


        extentTest.pass("Urun kutusunun uzerinde dururken gorunur olan Add to Cart butonunun tiklanabilirligini test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.urunUzerindekiSepeteEklemeButonu.isEnabled(),"Urun üzerinde add cart buyonu gözükmüyor");


        extentTest.pass("Urun kutusunun uzerinde dururken gorunur olan Add to Cart butonuna tıklar");
        testOtomasyonuFormPage.urunUzerindekiSepeteEklemeButonu.click();

        extentTest.pass("Product Added To Cart! Yazisinin ciktigini dogrular");
        wait.until(ExpectedConditions.visibilityOf(testOtomasyonuFormPage.productAddedToCartYazıElementi));
        softAssert.assertTrue(testOtomasyonuFormPage.productAddedToCartYazıElementi.isDisplayed(),"Product Added To Cart yazısı gözükmüyor");


        extentTest.pass("Your Cart butonunun gorunurlugunu test eder");
        ReusableMethods.bekle(1);
        softAssert.assertTrue(testOtomasyonuFormPage.yourCartButonu.isDisplayed(),"Your Cart butonunu gözükmüyor");

        extentTest.pass("Your Cart butonunun sayisininin 1 oldugunu dogrular");
        softAssert.assertEquals(testOtomasyonuFormPage.addCartüzerindekiSayiElementi.getText(),("1"),"Your Cart butonunun sayisininin 1 den farklı");

        extentTest.info("Your cart butonuna tiklar");
        ReusableMethods.click(testOtomasyonuFormPage.yourCartButonu);
        testOtomasyonuFormPage.yourCartButonu.click();

        extentTest.pass("Sayfa url'sinin https://testotomasyonu.com/shoppingCart oldugunu test eder");
        String expectedShoppingUrl="https://testotomasyonu.com/shoppingCart";
        String actualShoopingUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualShoopingUrl,expectedShoppingUrl,"Shopping url uyuşmuyor");

        extentTest.info("Sepete ürün eklendiğini test eder.");
        softAssert.assertTrue(testOtomasyonuFormPage.continueButonu.isDisplayed(),"Sepete ürün eklenemedi");

        extentTest.pass("Sepetteki urunun isminin listede eklenen urunun ismi ile ayni oldugunu test eder");
        softAssert.assertEquals(testOtomasyonuFormPage.trendingIlkUrunYaziElementi, testOtomasyonuFormPage.sepettekiIlkurunYaziElementi,"Listedeki ürün ve sepete eklenen ürün isimleri uyuşmuyor");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        softAssert.assertAll();
    }
}

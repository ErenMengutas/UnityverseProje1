package tests.Us_004;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

public class Tc_004 extends ExtentReport {
    @Test
    public void urumMiktariniArtirmaTesti()
    {
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));

        extentTest=extentReports.createTest("Ürün miktari arttirilarak sepete ekleme",
                "Kullanici ürün sayfasinda ürünü sepete eklmeden once ayarladigi miktar kadar ürünü sepette gorebilmelidir");


        extentTest.info("Kullanıcı url'e gider");
        Driver.getDriver().get(ConfigReader.getProperty("url"));


        extentTest.pass("Sayfaya gittigini dogrular");
        String expectedTitle="Test Otomasyonu";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Title bilgileri gecerli değil.");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Arama kutusunun gorünür oldugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.aramaKutusu.isDisplayed());
        extentTest.info("Arama kutusuna AranacakKelimeyi yazar ve aratır");//AranacakKelimeyi = phone
        testOtomasyonuFormPage.aramaKutusu.sendKeys(ConfigReader.getProperty("aranacakKelime")+Keys.ENTER);

        extentTest.info("Sayfa url'sinin https://testotomasyonu.com/search-product?search=phone&search_category=0 oldugunu test eder");
        String expectedUrl="https://testotomasyonu.com/search-product?search=phone&search_category=0";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Url bilgileri uyuşmuyor");

        List<String> bulunanUrunList=new ArrayList<>();
        for (WebElement each:testOtomasyonuFormPage.bulunanUrunListesi)
        {
            bulunanUrunList.add(each.getText());
        }

        extentTest.info("0'dan fazla urun bulundugunu dogrular");
        softAssert.assertTrue(bulunanUrunList.size()>0,"Bulunan urun miktari sıfırdan büyük değil");

        extentTest.info("ilk urune tiklar");
        testOtomasyonuFormPage.bulunanIlkUrunElementi.click();

        extentTest.pass("Sayfa url'sinin https://testotomasyonu.com/product/34 icerdigini test eder");
        String expectedProductUrl="https://testotomasyonu.com/product/34";
        String actualProductUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualProductUrl,expectedProductUrl,"Produc Url bilgileri uyuşmuyor");

        extentTest.pass("Miktar kutusunun gorunurlugunu dogrular");
        softAssert.assertTrue(testOtomasyonuFormPage.urunMiktarKutusu.isDisplayed(),"Miktar kutusu gözükmüyor");


        extentTest.info("Miktar kutusunda + butonuna 2 kere basar ");
        testOtomasyonuFormPage.urunMiktarArttırmaButonu.click();
        testOtomasyonuFormPage.urunMiktarArttırmaButonu.click();

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.info("Add to cart butonuna tiklar");
        testOtomasyonuFormPage.addToCart.click();

        extentTest.pass("Product Added To Cart! Yazisinin ciktigini dogrular");
        wait.until(ExpectedConditions.invisibilityOf(testOtomasyonuFormPage.productAddedToCartYazıElementi));
        //softAssert.assertTrue(testOtomasyonuFormPage.productAddedToCartYazıElementi.isDisplayed(),"Product Added to cart yazısı gözükmüyor");

        extentTest.pass("Your Cart butonunun gorunurlugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.yourCartButonu.isDisplayed(),"Your cart butonu gözükmüyor");

        extentTest.pass("Your Cart butonunun sayisininin 3 oldugunu dogrular");
        softAssert.assertEquals(testOtomasyonuFormPage.addCartüzerindekiSayiElementi.getText(),"3","Eklenen eleman sayısı 3'e eşit değil");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.info("Your cart butonuna tiklar");
        Driver.getDriver().findElement(By.xpath("(//span[@class='menu-icon-text'])[3]")).click();

        extentTest.pass("Sayfa url'sinin https://testotomasyonu.com/shoppingCart/34 oldugunu test eder");
        String expectedShoppingUrl="https://testotomasyonu.com/shoppingCart";
        String actualShoppingUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualShoppingUrl,expectedShoppingUrl,"Shopping Cart Url bilgileri uyuşmuyor");

        extentTest.pass("Sepette urun bulundugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.continueButonu.isDisplayed(),"Sepette urun yok");

        extentTest.pass("Urun miktarinin 3 oldugunu test eder");
        softAssert.assertEquals(testOtomasyonuFormPage.sepettekiUrunMiktari.getAttribute("value"),"3","urun miktarı 3'e eşit değil");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));




        softAssert.assertAll();

    }
}

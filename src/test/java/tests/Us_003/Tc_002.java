package tests.Us_003;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuFormPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tc_002 extends ExtentReport {
    @Test
    public void kategoriLinkleriKarsilastirmaTesi()
    {

        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        SoftAssert softAssert=new SoftAssert();


        extentTest=extentReports.createTest("Kategori linklerini karşılaştırma testi",
                "Kullanıcı kategori linkleri ve arama çubuğunda ki kategori linklerinin aynı olduğunu test eder ");

        extentTest.info("Kullanıcı url'e gider");
        Driver.getDriver().get(ConfigReader.getProperty("url"));


        extentTest.pass("Sayfaya gittigini dogrular");
        String expectedTitle="Test Otomasyonu";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Title bilgileri gecerli değil.");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        boolean anaSayfaKategorilinkleri=false;

        List<String> anaSayfaKategoriLinkleriList=new ArrayList<>();

        extentTest.pass("Anasayfada kategorilerin gorunurlugunu test eder");
        extentTest.info("Anasayfa kategori isimlerini liste olarak kaydeder");

        for (WebElement each: testOtomasyonuFormPage.anasayfaKategoriList)
        {
            if (each.isDisplayed())
            {
                anaSayfaKategoriLinkleriList.add(each.getText());
                anaSayfaKategorilinkleri=true;
            }

        }

        softAssert.assertTrue(anaSayfaKategorilinkleri,"Anasayfa kategori linkleri gözükmüyor");

        extentTest.info("Arama kutusundaki Select Category butonunun gorunurlugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.aramaKutusuKategoriButonu.isDisplayed());

        extentTest.info("Select Category butonuna tiklar");
        testOtomasyonuFormPage.aramaKutusuKategoriButonu.click();

        extentTest.pass("Kategori listesinin gorunur oldugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.aramaKutusuDropDownMenu.isDisplayed(),"Kategori listesi gözükmüyor");

        extentTest.info("Kategori listesindeki isimleri liste olarak kaydeder");

        List<String> aramaKutusuKategoriElemanlarıList=new ArrayList<>();

        aramaKutusuKategoriElemanlarıList.add(testOtomasyonuFormPage.aramaKutusuElectronicsElementi.getText());
        aramaKutusuKategoriElemanlarıList.add(testOtomasyonuFormPage.aramaKutusuMenFashionElementi.getText());
        aramaKutusuKategoriElemanlarıList.add(testOtomasyonuFormPage.aramaKutusuWomenFashionElementi.getText());
        aramaKutusuKategoriElemanlarıList.add(testOtomasyonuFormPage.aramaKutusuShoesElementi.getText());
        aramaKutusuKategoriElemanlarıList.add(testOtomasyonuFormPage.aramaKutusuFurnitureElementi.getText());
        aramaKutusuKategoriElemanlarıList.add(testOtomasyonuFormPage.aramaKutusuTravelElementi.getText());
        aramaKutusuKategoriElemanlarıList.add(testOtomasyonuFormPage.aramaKutusuKidsWearElementi.getText());
        aramaKutusuKategoriElemanlarıList.add(testOtomasyonuFormPage.aramaKutusuGroceryElementi.getText());


        Collections.sort(aramaKutusuKategoriElemanlarıList);
        Collections.sort(anaSayfaKategoriLinkleriList);


        extentTest.pass("Anasayfa kategori listesi ile Arama kutusu kategori listesi uzunluklarinin ayni oldugunu dogrular");

        softAssert.assertEquals(anaSayfaKategoriLinkleriList.size(),aramaKutusuKategoriElemanlarıList.size(),
                "Ana sayfa ve Arama kutusu kategori listesi uzunlukları farklı");


        extentTest.pass("Anasayfa kategori listesindeki 'Electronics','Men Fashion','Women Fashion','Shoes','Furniture','Travel','Kids Wear','Grocery' " +
                " elemanlarinin arama kutusu kategori listesinde oldugunu dogrular");

        softAssert.assertTrue(anaSayfaKategoriLinkleriList.containsAll(aramaKutusuKategoriElemanlarıList),"aynı elemanları içermiyor");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));




        softAssert.assertAll();




    }
}

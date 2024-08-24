package tests.Us_003;

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
import java.util.Collections;
import java.util.List;

public class Tc_003 extends ExtentReport {
    @Test
    public void mostPopulerKategoriTesti()
    {

        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        SoftAssert softAssert=new SoftAssert();
        Actions actions=new Actions(Driver.getDriver());


        extentTest=extentReports.createTest("Most populer kategori linklerini testi",
                "Kullanıcı kategori linklerinin most populer kategorisinde olduğunu doğrular ");

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
        softAssert.assertTrue(anaSayfaKategorilinkleri);

        extentTest.info("Anasayfada Most Popular Products bolumune gider");
        actions.moveToElement(testOtomasyonuFormPage.mostPopulerLinki).perform();

        extentTest.info("Most Populer kategorisindeki isimlerinin gözüktüğünü test eder");


        boolean mostPopulerKategori=false;

        List<String> mostPopulerKategorilist=new ArrayList<>();

        extentTest.pass("Most populer kategorilerinin gorunurlugunu test eder");
        extentTest.info("Most populer kategorinin isimlerini liste olarak kaydeder");
        for (WebElement each: testOtomasyonuFormPage.mostPopulerKategorliList)
        {
            if (each.isDisplayed())
            {
                mostPopulerKategorilist.add(each.getText());
                mostPopulerKategori=true;
            }

        }
        softAssert.assertTrue(mostPopulerKategori);
        Collections.sort(mostPopulerKategorilist);
        Collections.sort(anaSayfaKategoriLinkleriList);


        extentTest.pass("Anasayfa kategori listesi ile Most Popular Products kategori listesi uzunluklarinin ayni oldugunu dogrular");
        softAssert.assertEquals(anaSayfaKategoriLinkleriList.size(),mostPopulerKategorilist.size());


        extentTest.pass("Anasayfa kategori listesindeki 'Electronics','Men Fashion','Women Fashion','Shoes','Furniture','Travel','Kids Wear','Grocery' " +
                " elemanlarinin Most populer listesinde oldugunu dogrular");
        softAssert.assertTrue(anaSayfaKategoriLinkleriList.containsAll(mostPopulerKategorilist));

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        softAssert.assertAll();

    }


}

package tests.Us_004;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

public class Tc_005 extends ExtentReport {
    @Test(groups = "E2E")
    public void siparisVermeTesti()
    {
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        SoftAssert softAssert=new SoftAssert();
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        extentTest=extentReports.createTest("Sipariş verilme testi",
            "Sepete eklenen ürün siparis verilmeli ve siparis verildigi dogrulanmali");


        extentTest.info("Kullanıcı url'e gider");
        Driver.getDriver().get(ConfigReader.getProperty("url"));


        extentTest.pass("Sayfaya gittigini dogrular");
        String expectedTitle="Test Otomasyonu";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Title bilgileri gecerli değil.");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Top selling product bölümünün görünüz oldğunu test eder");
        actions.moveToElement(testOtomasyonuFormPage.topSellingProducts).perform();
        softAssert.assertTrue(testOtomasyonuFormPage.topSellingProducts.isDisplayed(),"Top selling bölümü gözükmüyor");

        extentTest.info("View all product linkinin tıklanabilirliğini test eder ve tıklar");
        softAssert.assertTrue(testOtomasyonuFormPage.topSellingProductsViewAll.isEnabled(),"View all product linki kullanılamıyor.");
        testOtomasyonuFormPage.topSellingProductsViewAll.click();


        extentTest.pass("Sayfa url'sinin https://testotomasyonu.com/trending/all-products oldugunu test eder");
        String expectedUrl="https://testotomasyonu.com/trending/all-products";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Trending url eşleşmiyor");


        extentTest.pass("ürün listesinde 0 dan fazla ürün olduğunu test eder.");

        List<WebElement> ürünListesi=new ArrayList<>();

        for (WebElement each:testOtomasyonuFormPage.topSellinUrunElementleriList)
        {
            ürünListesi.add(each);

        }


        softAssert.assertTrue(ürünListesi.size()>0,"Listede ki ürün miktarı sıfır");

        extentTest.info("Listedeki ik ürünün üzerine gider");
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
        softAssert.assertTrue(testOtomasyonuFormPage.yourCartButonu.isDisplayed(),"Your Cart butonunu gözükmüyor");

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Your Cart butonunun sayisininin 1 oldugunu dogrular");
        softAssert.assertEquals(testOtomasyonuFormPage.addCartüzerindekiSayiElementi.getText(),("1"),"Your Cart butonunun sayisininin 1 den farklı");

        extentTest.info("Your cart butonuna tiklar");
        ReusableMethods.click(testOtomasyonuFormPage.yourCartButonu);
        testOtomasyonuFormPage.yourCartButonu.click();

        extentTest.pass("Sayfa url'sinin https://testotomasyonu.com/shoppingCart oldugunu test eder");
        String expectedShoppingUrl="https://testotomasyonu.com/shoppingCart";
        String actualShoopingUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualShoopingUrl,expectedShoppingUrl,"Shopping url bilgileri yanlış");

        extentTest.info("Sepete ürün eklendiğini test eder.");
        softAssert.assertTrue(testOtomasyonuFormPage.continueButonu.isDisplayed(),"Sepete ürün eklenemedi");

        extentTest.info("Checkout butonuna tiklar");
        testOtomasyonuFormPage.checkoutButonu.click();

        extentTest.info("Billing Address gorunurlugunu test eder");
        testOtomasyonuFormPage.billingAddressButonu.isDisplayed();

        extentTest.info("Add Address butonuna tiklar");
        testOtomasyonuFormPage.bilAddAddressButonu.click();

        extentTest.info("Name, address, address 2, city, postcode, ülke ve sehir bilgilerini doldurur");
        testOtomasyonuFormPage.addAddressName.sendKeys(ConfigReader.getProperty("addAddresName"));
        testOtomasyonuFormPage.addAddressEmail.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        testOtomasyonuFormPage.addAddressPhone.sendKeys(ConfigReader.getProperty("addAddressPhone"));
        testOtomasyonuFormPage.addAddres.sendKeys(ConfigReader.getProperty("addAddressAddress"));
        Select selectCountry=new Select(testOtomasyonuFormPage.addAddresSelectCountry);
        selectCountry.selectByIndex(faker.number().numberBetween(1,9));
        Select selecetState=new Select(testOtomasyonuFormPage.addAddresSelectCountry);
        selecetState.selectByIndex(faker.number().numberBetween(1,9));
        testOtomasyonuFormPage.addAddresCity.sendKeys(ConfigReader.getProperty("addAddressCity"));
        testOtomasyonuFormPage.addAddresPostCode.sendKeys(ConfigReader.getProperty("addAddressZipCode"));
        ReusableMethods.bekle(1);

        extentTest.info("Add Address butonuna tiklar");
        testOtomasyonuFormPage.addAddressConfirmButonu.click();

        extentTest.info("Billing Address listesinde adres bulundugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.addressBox.isDisplayed());

        extentTest.info("Billing Address listesinde adres secer");
        testOtomasyonuFormPage.addresSecmeButonu.click();

        extentTest.info("Delivery address same as billing address kutucuguna tiklar");
        testOtomasyonuFormPage.deliveryaddressButonu.click();

        extentTest.info("Delivery Address bolumunun gorunur olmadigini test eder");
        softAssert.assertFalse(testOtomasyonuFormPage.deliveryAddressYazisi.isDisplayed());

        extentTest.info("Delivery address same as billing address kutucugunu unchecked yapar");
        testOtomasyonuFormPage.deliveryaddressButonu.click();

        extentTest.info("Delivery Address bolumunun gorunur oldugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.deliveryAddressYazisi.isDisplayed());

        extentTest.info("Delivery Address linkine tıklar");
        testOtomasyonuFormPage.deliveriAddAdress.click();

        extentTest.info("Name, address, address 2, city, postcode, ülke ve sehir bilgilerini doldurur");
        testOtomasyonuFormPage.addAddressName.sendKeys(ConfigReader.getProperty("addAddresName"));
        testOtomasyonuFormPage.addAddressEmail.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        testOtomasyonuFormPage.addAddressPhone.sendKeys(ConfigReader.getProperty("addAddressPhone"));
        testOtomasyonuFormPage.addAddres.sendKeys(ConfigReader.getProperty("addAddressAddress"));
        selectCountry.selectByIndex(faker.number().numberBetween(1,9));
        selecetState.selectByIndex(faker.number().numberBetween(1,9));
        testOtomasyonuFormPage.addAddresCity.sendKeys(ConfigReader.getProperty("addAddressCity"));
        testOtomasyonuFormPage.addAddresPostCode.sendKeys(ConfigReader.getProperty("addAddressZipCode"));
        ReusableMethods.bekle(1);


        extentTest.info("Add Address butonuna tiklar");
        testOtomasyonuFormPage.addAddressConfirmButonu.click();

        extentTest.info("Delivery Address listesinde adres bulundugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.deliveryAddressBox.isDisplayed());

        extentTest.info("Delivery Address listesinde adres secer");
        testOtomasyonuFormPage.deliveryAddresCheckbox.click();

        extentTest.info("Billing Address listesinde ki adresi tekar secer");
        testOtomasyonuFormPage.addresSecmeButonu.click();

        extentTest.info("Shipping Methods listesinden kargo secer");
        actions.moveToElement(testOtomasyonuFormPage.shippingMethodsFree).perform();
        testOtomasyonuFormPage.shippingMethodsFree.click();

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.info("Terms and Conditions boxini checkler");
        testOtomasyonuFormPage.termAndCondition.click();

        extentTest.info("Place Order Now butonuna tiklar");
        testOtomasyonuFormPage.placeOrderNow.click();

        extentTest.pass("Your order is successfully done! Yazisinin gorunur oldugunu test eder");
        softAssert.assertTrue(testOtomasyonuFormPage.youOrderYaziElementi.isDisplayed());

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));





        softAssert.assertAll();
    }


}

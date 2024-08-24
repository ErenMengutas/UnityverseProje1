package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.security.cert.X509Certificate;
import java.util.List;

public class TestOtomasyonuFormPage {


    public TestOtomasyonuFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@class='cart-bar'])[1]")
    public WebElement toAnaSayfaAccLinki;

    @FindBy(xpath = "//*[@class='sign-up ']")
    public  WebElement toLoginSayfasiSignUpButonu;


    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firtNameButonu;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameButonu;

    @FindBy(xpath = "//input[@id='signupemail']")
    public WebElement emailAddressButonu;

    @FindBy(xpath = "//input[@id='signuppassword']")
    public WebElement passwordButonu;

    @FindBy(xpath = "//input[@id='comfirmPassword']")
    public WebElement confirmPasswordButonu ;

    @FindBy(xpath = "//button[@id='btn-submit-form']")
    public WebElement registerSayfasiSignUpButonu;

    @FindBy(xpath = "(//input[@type='email'])[1]")
    public WebElement loginSayfasıEmailButonu;


    @FindBy(xpath = "//input[@type='password']")
    public WebElement loginSayfasıPassButonu;

    @FindBy(xpath = "//button[@id='submitlogin']")
    public WebElement loginSayfasıSigninButonu;

    @FindBy(xpath = "(//div[p])[1]")
    public WebElement profilYazıElementi;

    @FindBy(xpath = "(//input[@type='email'])[1]")
    public WebElement kullanıcıProfilEmailYazisi;

    @FindBy(xpath = "//*[@class='heading-xs my-2 text-center']")
    public WebElement registerNowYaziElementi;

    @FindBy(xpath = "//*[text()='First name is required']")
    public WebElement firstNameRequiredYaziElementi;

    @FindBy(xpath = "//*[text()='Last name is required']")
    public WebElement lastNameRequiredYaziElementi;

    @FindBy(xpath = "//*[text()='Email address is required']")
    public WebElement emailAdressRequiredYaziElementi;

    @FindBy(xpath = "//*[text()='Password is required']")
    public WebElement passwordRequiredYaziElementi;

    @FindBy(xpath = "//*[text()='Confirm password does not match']")
    public WebElement confirmPasswordRequiredYaziElementi;


    @FindBy(xpath = "//*[@class='heading-xs my-2 text-center']")
    public WebElement loginSayfasıLoginNowYaziElementi;


    @FindBy(xpath = "//*[text()='Confirm password does not match']")
    public WebElement confirmPasswordUyariYazisi;

    @FindBy(xpath = "//div[@class='retro-notify-content']")
    public WebElement loginSuccessElementi;

    @FindBy(xpath = "//h3[text()='Update Profile']")
    public WebElement updateProfileYaziElementi;

    @FindBy(xpath = "//label[@for='firstName']")
    public WebElement profilFirstNameYaziElementi;

    @FindBy(xpath = "//label[@for='lastName']")
    public WebElement profilLastNameYaziElementi;

    @FindBy(xpath = "//label[@for='email']")
    public WebElement profilEmailYaziElementi;

    @FindBy(xpath = "(//*[@class='item'])[1]")
    public WebElement myProfileElementi;

    @FindBy(xpath = "(//*[@class='item'])[2]")
    public WebElement myOrderElementi;

    @FindBy(xpath = "(//*[@class='item'])[3]")
    public WebElement wishListElementi;

    @FindBy(xpath = "(//*[@class='item'])[4]")
    public WebElement manageAdressElementi;

    @FindBy(xpath = "(//*[@class='item'])[5]")
    public WebElement changePasswordElementi;

    @FindBy(xpath = "(//*[@class='item'])[6]")
    public WebElement logoutElementi;

    @FindBy(xpath = "(//*[@class='has-sub'])[1]")
    public WebElement electronicLinki;

    @FindBy(xpath = "(//*[@class='has-sub'])[2]")
    public WebElement menFashionLinki;

    @FindBy(xpath = "(//*[@class='has-sub'])[3]")
    public WebElement womenFashionLinki;

    @FindBy(xpath = "(//*[@class='has-sub'])[4]")
    public WebElement shoesLinki;

    @FindBy(xpath = "(//*[@class='has-sub'])[5]")
    public WebElement furnitureLinki;

    @FindBy(xpath = "(//*[@class='has-sub'])[6]")
    public WebElement travelLinki;

    @FindBy(xpath = "(//*[@class='has-sub'])[7]")
    public WebElement kidsWearLinki;

    @FindBy(xpath = "(//*[@class='has-sub'])[8]")
    public WebElement groceryLinki;

    @FindBy(xpath = "//*[@class='has-sub']")
    public List<WebElement> anasayfaKategoriList;

    @FindBy(xpath = "(//*[@class='toggle-active'])[1]")
    public WebElement aramaKutusuKategoriButonu;

    @FindBy(xpath = "//*[@class='dropdown-menu ']")
    public WebElement aramaKutusuDropDownMenu;

    @FindBy(xpath = "//li[@onclick]")
    public List<WebElement> aramaKutusuDropdownlist;


    @FindBy(xpath = "//div[text()='Most Popular Products']")
    public WebElement mostPopulerLinki;

    @FindBy(xpath = "//label[@class='category-name']")
    public List<WebElement> mostPopulerKategorliList;

    @FindBy(xpath = "//div[text()=' Top Selling Products  ']")
    public WebElement topSellingProducts;

    @FindBy(xpath = "(//a[@class='view_all'])[1]")
    public WebElement topSellingProductsViewAll;

    @FindBy(xpath = "//div[@class='product-box mb-2 pb-1']")
    public List<WebElement> topSellinUrunElementleriList;

    @FindBy(xpath = "//button[@class='add-to-cart']")
    public  WebElement addToCart;

    @FindBy(xpath = "//div[@class='text-left']")
    public WebElement continueButonu;

    @FindBy(xpath = "(//*[@class='cart-bar'])[2]")
    public WebElement yourCartButonu;

    @FindBy(xpath = "//div[@class='product-box mb-2 pb-1']")
    public WebElement topSellingIlkUrun;

    @FindBy(xpath = "(//div[@class='floating-add-to-cart  d-flex justify-content-center'])[1]")
    public WebElement urunUzerindekiSepeteEklemeButonu;

    @FindBy(xpath = "(//span[@class='cart-count basket-count'])[1]")
    public WebElement addCartüzerindekiSayiElementi;

    @FindBy(xpath = "//div[@class='retro-notify-container retro-slideTopRight-ready retro-slideTopRight-open']")
    public WebElement productAddedToCartYazıElementi;

    @FindBy(xpath = "//*[text()='Product Tax']")
    public WebElement trendingIlkUrunYaziElementi;

    @FindBy(xpath = "//*[text()='Product Tax']")
    public WebElement sepettekiIlkurunYaziElementi;

    @FindBy(xpath = "(//a[text()='Men Fashion'])[1]")
    public WebElement aramaKutusuMenFashionElementi;


    @FindBy(xpath = "(//a[text()='Electronics'])[1]")
    public WebElement aramaKutusuElectronicsElementi;

    @FindBy(xpath = "(//a[text()='Women Fashion'])[1]")
    public WebElement aramaKutusuWomenFashionElementi;

    @FindBy(xpath = "(//a[text()='Shoes'])[1]")
    public WebElement aramaKutusuShoesElementi;

    @FindBy(xpath = "(//a[text()='Furniture'])[1]")
    public WebElement aramaKutusuFurnitureElementi;

    @FindBy(xpath = "(//a[text()='Kids Wear'])[1]")
    public WebElement aramaKutusuKidsWearElementi;

    @FindBy(xpath = "(//a[text()='Grocery'])[1]")
    public WebElement aramaKutusuGroceryElementi;

    @FindBy(xpath = "(//a[text()='Travel'])[1]")
    public WebElement aramaKutusuTravelElementi;
        //=====
    @FindBy(xpath = "(//a[text()='Electronics'])[1]")
    public WebElement aramakutusuElektronik;

    @FindBy(xpath ="(//a[text()='Men Fashion'])[1]")
    public WebElement aramakutusumenfasion;

    @FindBy(xpath ="(//a[text()='Women Fashion'])[1]")
    public WebElement aramakutusuWomenfashion;

    @FindBy(xpath ="(//a[text()='Shoes'])[1]")
    public WebElement aramakutusuShoes;

    @FindBy(xpath ="(//a[text()='Furniture'])[1]")
    public WebElement aramakutusufurniture;

    @FindBy(xpath ="(//a[text()='Travel'])[1]")
    public WebElement aramakutusutravel;

    @FindBy(xpath ="(//a[text()='Kids Wear'])[1]")
    public WebElement aramakutusukidswear;

    @FindBy(xpath ="(//a[text()='Grocery'])[1]")
    public WebElement aramakutusugrocery;

    @FindBy(xpath = "//button[@class='remove']")
    public WebElement sepettekiUrunIptalButonu;

    @FindBy(xpath = "//h2[text()='Are you sure?']")
    public WebElement areYouSureYaziElementi;

    @FindBy(xpath = "//button[text()='Yes, remove it!']")
    public WebElement yesRemoveButonu;

    @FindBy(xpath = "//*[text()='Wait for it... ']")
    public WebElement waitForItYaziElementi;

    @FindBy(xpath = "//h3[text()='Shopping cart is empty']")
    public WebElement shoppingCartIsEmpty;

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='product-box my-2  py-1']")
    public List<WebElement> bulunanUrunListesi;

    @FindBy(xpath = "(//div[@class='product-box my-2  py-1'])[1]")
    public WebElement bulunanIlkUrunElementi;

    @FindBy(xpath = "//div[@class='quantitybox d-flex justify-content-center align-items-center']")
    public WebElement urunMiktarKutusu;

    @FindBy(xpath = "//div[@class='value-button increase']")
    public WebElement urunMiktarArttırmaButonu;

    @FindBy(xpath = "//div[@class='value-button decrease']")
    public WebElement urunMiktarAzaltmaButonu;

    @FindBy(xpath = "//input[@class='input-text qty text']")
    public WebElement sepettekiUrunMiktari;

    @FindBy(xpath = "//*[@class='button-block button-place']")
    public WebElement checkoutButonu;

    @FindBy(xpath = "(//div[@class='heading-xs my-1'])[1]")
    public WebElement billingAddressButonu;

    @FindBy(xpath = "(//button[@class='btn-add-address'])[1]")
    public WebElement bilAddAddressButonu;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement addAddressName;

    @FindBy(xpath = "//input[@id='useremail']")
    public WebElement addAddressEmail;

    @FindBy(xpath = "//input[@id='usermobile']")
    public WebElement addAddressPhone;

    @FindBy(xpath = "//textarea[@id='address_1']")
    public WebElement addAddres;


    @FindBy(xpath = "//textarea[@id='address_2']")
    public WebElement addAddres2;


    @FindBy(xpath = "//select[@id='country_id']")
    public WebElement addAddresSelectCountry;

    @FindBy(xpath = "//select[@id='add_address_state']")
    public WebElement addAddresSelectState;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement addAddresCity;

    @FindBy(xpath = "//input[@id='postcode']")
    public WebElement addAddresPostCode;

    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    public WebElement addAddressConfirmButonu;

    @FindBy(xpath = "//div[@class='address-box']")
    public WebElement addressBox;

    @FindBy(xpath = "(//span[@class='checkmark'])[1]")
    public WebElement addresSecmeButonu;

    @FindBy(xpath = "(//span[@class='checkmark'])[2]")
    public WebElement deliveryaddressButonu;

    @FindBy(xpath = "(//div[@class='heading-xs my-1'])[2]")
    public WebElement deliveryAddressYazisi;

    @FindBy(xpath = "(//button[@class='btn-add-address'])[2]")
    public WebElement deliveriAddAdress;

    @FindBy(xpath = "(//div[@class='address-box'])[2]")
    public WebElement deliveryAddressBox;

    @FindBy(xpath = "(//span[@class='checkmark'])[3]")
    public WebElement deliveryAddresCheckbox;

    @FindBy(xpath = "(//*[@class='checkmark'])[4]")
    public WebElement shippingMethodsFree;

    @FindBy(xpath = "//input[@name='accept_terms']")
    public WebElement termAndCondition;

    @FindBy(xpath = "//button[@class='button-block button-place mt-3']")
    public WebElement placeOrderNow;

    @FindBy(xpath = "//h2[text()='Your order is successfully done!']")
    public WebElement youOrderYaziElementi;



}




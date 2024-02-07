package team02.tests.US_18;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team02.pages.HomePage;
import team02.pages.VendorMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class Test_Cases_US_18 {
    VendorMyAccountPage vendorPage = new VendorMyAccountPage();
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void ilkDokuzStep() {
        //1	Allover Commerce websayfasina git	"https://allovercommerce.com"
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //2	Sign in butonuna tikla
        HomePage homePage = new HomePage();
        homePage.signInYH.click();

        //3	usarneme or email address kutusuna veri gir	{email veya usarname}
        homePage.userNameOrEmailYH.sendKeys(ConfigReader.getProperty("vendorEmailYH"));

        //4	password gir	{password}
        homePage.passwordYH.sendKeys(ConfigReader.getProperty("vendorPasswordYH"));

        //5	Sign in butonuna tikla
        homePage.loginButonuYH.click();

        //6	Footer bölümünde "MyAccount" a tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        homePage.myAccountYH.click();

        //7	Store Manager'e tikla

        vendorPage.storeManager_YH.click();

        //8	Soldaki menüden Coupons secenegine tikla
        vendorPage.coupons_YH.click();

        //9	Add New secenegine tikla
        vendorPage.addNewCoupons_YH.click();

    }

    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase01() {
        //Code kutusuna veri gir	{code}
        String code = couponCodeCreate();
        vendorPage.codeOfCoupons_YH.sendKeys(code);
        //Description kutusuna veri gir	{description}

        vendorPage.descriptonOfCoupons_YH.sendKeys(ConfigReader.getProperty("couponDescription"));
        ReusableMethods.bekle(2);
        //submit butonuna tikla
        vendorPage.submitAddCoupon_YH.click();
        ReusableMethods.bekle(3);
        //Code ve Description kutularina veri girildigini dogrula
        softAssert.assertEquals(vendorPage.codeOfCoupons_YH.getAttribute("value"),code);
        softAssert.assertEquals(vendorPage.descriptonOfCoupons_YH.getAttribute("value"),ConfigReader.getProperty("couponDescription"));
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase02() {
        //Discount Type olarak drop down menu den Percentage discount sec
        String percentageDiscountValue = "percent";
        ReusableMethods.ddmValue(vendorPage.discountTypeDDM_YH,percentageDiscountValue);
        //Percentage discount secildigini gör
        Select select= new Select(vendorPage.discountTypeDDM_YH);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Percentage discount");
        Driver.closeDriver();
    }
    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase03() {
        //Discount Type olarak drop down menu den Fixed Product Discount sec
        String percentageDiscountValue = "fixed_product";
        ReusableMethods.ddmValue(vendorPage.discountTypeDDM_YH,percentageDiscountValue);
        //Fixed Product Discount secildigini gör
        Select select= new Select(vendorPage.discountTypeDDM_YH);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Fixed Product Discount");
        Driver.closeDriver();
    }

    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase04_05() {
        //Code kutusuna veri gir	{code}
        String code = couponCodeCreate();
        vendorPage.codeOfCoupons_YH.sendKeys(code);
        ReusableMethods.bekle(2);
        //Coupon Amount kutusuntemizle
        vendorPage.couponAmountKutusu_YH.clear();
        ReusableMethods.bekle(2);
        //Coupon Amount kutusuna veri gir
        vendorPage.couponAmountKutusu_YH.sendKeys(ConfigReader.getProperty("couponAmount"));
        //Coupon expiry date kutusuna deger gir
        vendorPage.couponExpiryDate_YH.sendKeys(ConfigReader.getProperty("couponExpiryDate"));
        //submit butonuna tikla
        vendorPage.submitAddCoupon_YH.click();
        //Coupon Amount kutusunda ve coupon expiry date kutusuna girilen degerlerin göründügünü dogrula
        softAssert.assertEquals(vendorPage.couponAmountKutusu_YH.getAttribute("value"),ConfigReader.getProperty("couponAmount"));
        softAssert.assertEquals(vendorPage.couponExpiryDate_YH.getAttribute("value"),ConfigReader.getProperty("couponExpiryDate"));
        softAssert.assertAll();
        Driver.closeDriver();

    }
    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase06() {
        //Allow free shipping sec
        vendorPage.allowFreeshippnigButton_YH.click();
        //Show on store seç
        vendorPage.showOnStoreButton_YH.click();
        //Allow free shipping  ve Show on store seceneklerinin secili oldugunu dogrula
        softAssert.assertTrue(vendorPage.allowFreeshippnigButton_YH.isSelected());
        softAssert.assertTrue(vendorPage.showOnStoreButton_YH.isSelected());
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase07() {
        //Code kutusuna veri gir	{code}
        String couponCode = couponCodeCreate();
        vendorPage.codeOfCoupons_YH.sendKeys(couponCode);

        //Discount Type menuden bir secim yap
        String percentageDiscountValue = "percent";
        ReusableMethods.ddmValue(vendorPage.discountTypeDDM_YH,percentageDiscountValue);

        //Description kutusuna veri gir
        vendorPage.descriptonOfCoupons_YH.sendKeys(ConfigReader.getProperty("couponDescription"));
        ReusableMethods.bekle(3);
        //Coupon Amount kutusun temizle
        vendorPage.couponAmountKutusu_YH.clear();
        //Coupon Amount kutusuna veri gir	{kupon tutari}

        ReusableMethods.bekle(3);
        vendorPage.couponAmountKutusu_YH.sendKeys(ConfigReader.getProperty("couponAmount"));
        ReusableMethods.bekle(3);

        //Cupon expiry date kutusuna kuponun son kullanma tarihini gir	{tarih}
        vendorPage.couponExpiryDate_YH.sendKeys(ConfigReader.getProperty("couponExpiryDate"));
        ReusableMethods.bekle(3);

        //Submit butonuna tikla
        vendorPage.submitAddCoupon_YH.click();
        //Soldaki menüden Coupons secenegine tikla
        ReusableMethods.bekle(2);
        vendorPage.coupons_YH.click();
        ReusableMethods.bekle(3);

        //olusturulan Couponun Code'unun Coupon listing sayfasinda görüntülendigini dogrula
        ReusableMethods.scroll(vendorPage.coupons_YH);
        Assert.assertEquals(vendorPage.couponListFirstElementCouponCode_YH.getText(),couponCode);
        Driver.closeDriver();

    }

    private String couponCodeCreate(){
       int couponNumber=(int)(Math.random()*100000+1);
        return  "CODE"+couponNumber;
    }



}

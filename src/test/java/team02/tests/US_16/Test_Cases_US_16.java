package team02.tests.US_16;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team02.pages.HomePage;
import team02.pages.VendorMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class Test_Cases_US_16 {

    VendorMyAccountPage vendorPage = new VendorMyAccountPage();
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

        //8	Soldaki menüden Products'a tikla
        vendorPage.products_YH.click();

        //9	Add New secenegine tikla
        vendorPage.addNewProducts_YH.click();
    }

    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase01() {
      //  Add Product sayfasinda en ustteki dropdown menüde "Simple Product" secili oldugunu dogrula

        Select select = new Select(vendorPage.productTypeDDM_YH);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),vendorPage.simpleProduct_YH.getText());
        Driver.closeDriver();

    }

    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase02() {
        //Add Product sayfasinda Virtual ve Downloadable radio butonlarina tikla
        vendorPage.virtual_YH.click();
        vendorPage.downloadable_YH.click();

        //Virtual ve Downloadable butonlarinin secili oldugunu dogrula
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(vendorPage.virtual_YH.isSelected());
        softAssert.assertTrue(vendorPage.downloadable_YH.isSelected());
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase03() {
        //Price kutusuna bir deger gir
        vendorPage.price_YH.sendKeys("25");

        //Sale Price kutusuna deger gir
        vendorPage.salePrice_YH.sendKeys("22");

        //Price ve Sale Price kutularina deger girilebildigini dogrula
        // eger webelementin type attribute'ü text veya number ise veri girilebilir anlamina gelir
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(vendorPage.price_YH.getAttribute("type"),"number");
        softAssert.assertEquals(vendorPage.salePrice_YH.getAttribute("type"),"number");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase04() {
        //Product Title kutusuna veri girilir	{title}
        String productTitleExample = "example";
        vendorPage.productTitle_YH.clear();
        vendorPage.productTitle_YH.sendKeys(productTitleExample);

        //Product title kutusuna veri girilebildigini dogrula
        Assert.assertEquals(vendorPage.productTitle_YH.getAttribute("type"),"text");
        Driver.closeDriver();
    }


    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase05() {
        //Categories* altindan bir kategori sec
        vendorPage.selectCategory_YH.click();
        //Istenen kategorinin secili oldugunu dogrula
        Assert.assertTrue(vendorPage.selectCategory_YH.isSelected());
        Driver.closeDriver();
    }

    @Test(dependsOnMethods = "ilkDokuzStep")
    public void testCase06() {
       //Product Title kutusuna veri gir	{title}
        vendorPage.productTitle_YH.sendKeys("example");
        //Featured image	{ürün media}
        vendorPage.addFeaturedImage_YH.click();
        ReusableMethods.bekle(2);
        vendorPage.addProductImageMediaLibrary_YH.click();
        ReusableMethods.bekle(2);
        vendorPage.addProductImageMediaLibraryImage1_YH.click();
        ReusableMethods.bekle(2);
        vendorPage.addProductImageMediaLibrarySelectButton_YH.click();
        ReusableMethods.bekle(2);

        //Galeri image yukle	{ürün ismi}
        vendorPage.addProductImageGalery_YH.click();
        ReusableMethods.bekle(2);
        vendorPage.addProductImageMediaLibraryImage2_YH.click();
        ReusableMethods.bekle(2);
        vendorPage.addProductImageMediaLibraryAddToGallery_YH.click();
        ReusableMethods.bekle(2);


        //Categories* altindan bir kategori sec
        ReusableMethods.scroll(vendorPage.selectCategory_YH);
        vendorPage.selectCategory_YH.click();
        ReusableMethods.bekle(2);

        //Submit butonuna tikla
        vendorPage.submitAddProduct_YH.click();

        //Ürünun eklendigini dogrula
        Assert.assertTrue(vendorPage.productSuccesflyPublished_YH.isDisplayed());
        Driver.closeDriver();

    }




}

package team02.tests.US_15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team02.pages.RegisterPage;
import team02.pages.VendorMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.Extent_Reports;
import team02.utilities.ReusableMethods;

public class TestCase01 {
    VendorMyAccountPage vendorMyAccountPage=new VendorMyAccountPage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert=new SoftAssert();

    Faker faker=new Faker();
    @Test
    public void ilkOnAdim_15() {
        Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
        Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

        //   Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        Extent_Reports.extentTest.info("Kullanici Allover Commerce sayfasina gider");

        //Sign in butonuna tıkla
        RegisterPage registerPage =new RegisterPage();
        ReusableMethods.click(registerPage.signInKutusu);
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici sign in butonuna tiklar");

        //Username veya email adress kutusuna kayitli bir email gir
        //Password gir
        //Sign in butonuna tıkla
        registerPage.userName.sendKeys(ConfigReader.getProperty("email_SK"),
                Keys.TAB, ConfigReader.getProperty("password_SK"),
                Keys.ENTER);
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici kayitli bir email ve password girer ve sign in butonuna tiklar");

        //Başarılı giriş yapıldığını doğrula.
        Assert.assertTrue(vendorMyAccountPage.signOutYazisi_SK.isDisplayed());
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Basarili bir giris yapildigini dogrular");

        //Sayfa sonundaki My Account butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        vendorMyAccountPage.myAccountButonu_SK.click();
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici My Account butonuna tiklar");

        //Store Manager butonuna tıkla.
        vendorMyAccountPage.storeManagerButonu_SK.click();
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici Store Manager butonuna tiklar");

        //My Store webelementi altindaki Products butonuna tıkla.
       ReusableMethods.click(vendorMyAccountPage.productsButonu_SK);
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici My Store webelementi altindaki Products butonuna tiklar");

        //Add new butonuna tıkla.
        ReusableMethods.click(vendorMyAccountPage.addNewButonu_SK);
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici Add new butonuna tiklar");
        Extent_Reports.extentReport.flush();
    }
    @Test(dependsOnMethods = "ilkOnAdim_15")
    public void test01() {
        /*Vendor olarak giris yapan kisi Inventory,
        Shipping,
        Attributes,
        Linked,
        Seo,
        Advanced menüleri görülebilmeli
         */
        Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
        Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

        ReusableMethods.scroll(vendorMyAccountPage.inventoryMenu_SK  );
        SoftAssert softAssert=new SoftAssert();
        ReusableMethods.bekle(3);
        //Inventary menusunun gorundugunu dogrula
        softAssert.assertTrue(vendorMyAccountPage.inventoryMenu_SK.isDisplayed(),"Inventary menusunu gorulmez");
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Inventary menusunun gorundugunu dogrular");

        //Shipping  menüsunun görüldüğünü doğrula.
        softAssert.assertTrue(vendorMyAccountPage.shippingMenu_SK.isDisplayed(),"Shipping menusu gorulmez");
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Add new butonuna tiklar");

        // Attributes  menüsunun görüldüğünü doğrula.
        softAssert.assertTrue(vendorMyAccountPage.attributesMenu_SK.isDisplayed(),"Attributes menusu gorunmez");
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Shipping  menüsunun görüldüğünü doğrular");

        //Linked  menüsunun görüldüğünü doğrula.
        softAssert.assertTrue(vendorMyAccountPage.linkedMenu_SK.isDisplayed(),"Linked menusu gorunmez");
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Linked  menüsunun görüldüğünü doğrular");

        //Seo  menüsunun görüldüğünü doğrula.
        softAssert.assertTrue(vendorMyAccountPage.seoMenu_SK.isDisplayed(),"Seo menusu gorulmez");
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("KullaniciSeo  menüsunun görüldüğünü doğrular");

        //Advenced  menüsunun görüldüğünü doğrula.
        softAssert.assertTrue(vendorMyAccountPage.advencedMenu_SK.isDisplayed(),"Advenced menusu gorulmez");
        ReusableMethods.bekle(2);
        softAssert.assertAll();
        Extent_Reports.extentTest.info("Kullanici Advenced  menüsunun görüldüğünü doğrular");
        Extent_Reports.extentReport.flush();


    }
    @Test(dependsOnMethods = "ilkOnAdim_15"  )
    public void test02() {
        /*Vendor olarak giris yapan kisi Inventory, Shipping, Attributes, Linked, Seo, Advanced menüleri görülebilmeli*/
        Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
        Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);
        //Product title gir
        US_15_methods.productTitleEkle();
        Extent_Reports.extentTest.info("Kullanici Product title girer");

        //img alnina bir resim ekle
        US_15_methods.resimEkle();
        Extent_Reports.extentTest.info("Kullanici Advenced  menüsunun görüldüğünü doğrular");

        //Galery den resim ekle
        US_15_methods.galerydenResimEkle();
        Extent_Reports.extentTest.info("Kullanici img alnina bir resim ekler");

        //Product categori sec
        vendorMyAccountPage.catagoriesClikButonu_SK.click();
        ReusableMethods.bekle(4);
        Extent_Reports.extentTest.info("Kullanici Product categori secer");

        // SKU  text alanına veri gonder ve dogrula
        ReusableMethods.scroll(vendorMyAccountPage.inventoryMenu_SK  );
        vendorMyAccountPage.SKUKutusu_SK.sendKeys(faker.number().digits(5));
        ReusableMethods.bekle(2);
        softAssert.assertTrue(vendorMyAccountPage.SKUKutusu_SK.isEnabled(),"SKU kutusuna erisilmedi");
        Extent_Reports.extentTest.info("Kullanici SKU  text alanına veri gonder ve dogrular");

        //Manage Stock butonuna tıkla ve dogrula
        ReusableMethods.click(vendorMyAccountPage.manageStokClikButonu_SK);
        softAssert.assertTrue(vendorMyAccountPage.manageStokClikButonu_SK.isSelected(),"Manage Stock butonu click yapilmadi");
        ReusableMethods.scroll(vendorMyAccountPage.stokQtyKutusu_SK);
        Extent_Reports.extentTest.info("Kullanici Manage Stock butonuna tıkla ve dogrular");

        //  Manage Stok kutusu click yapinca Stok Qty kutusuna ve Allow BackordersDDM'a erisilebildigini dogrular
        ReusableMethods.scroll(vendorMyAccountPage.stokQtyKutusu_SK);
        vendorMyAccountPage.stokQtyKutusu_SK.sendKeys(faker.number().digits(1));
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Manage Stok kutusu click yapinca Stok Qty kutusuna ve Allow BackordersDDM'a erisilebildigini dogrular");

           //Stok Qty kutusu
        softAssert.assertTrue(vendorMyAccountPage.stokQtyKutusu_SK.isEnabled(),"Stok Qty erisilmedi");
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Stok Qty kutusuna erisildigini doğrular");

          //Allow BackordersDDM
        ReusableMethods.scroll(vendorMyAccountPage.allowBackordersDDM_SK);
        ReusableMethods.ddmIndex(vendorMyAccountPage.allowBackordersDDM_SK,1);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(vendorMyAccountPage.allowBackordersDDM_SK.isEnabled(),"Allow Backorder erisilmedi");
        ReusableMethods.bekle(3);
        ReusableMethods.click(vendorMyAccountPage.manageStokClikButonu_SK);
        Extent_Reports.extentTest.info("Kullanici Allow BackordersDDM'e erisildigini doğrular");

        //Stock status ddm' i sec ve dogrula
        ReusableMethods.ddmIndex(vendorMyAccountPage.stokStatussDDM_SK,1);
        softAssert.assertTrue(vendorMyAccountPage.stokStatussDDM_SK.isEnabled(),"Stok Status DDM erisilmedi");
        Extent_Reports.extentTest.info("Kullanici Stock status ddm' i secer ve secilebildigini doğrular");

        //Sold Individually butonuna tıkla ve dogrula
        ReusableMethods.click(vendorMyAccountPage.soldIndividuallyClikButonu_SK);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(vendorMyAccountPage.soldIndividuallyClikButonu_SK.isSelected(),"Sold individual Secilmedi");
        Extent_Reports.extentTest.info("Kullanici Sold Individually butonuna tıklar ve secilebildigini doğrular");

        //Submit butonuna tikla
        ReusableMethods.click(vendorMyAccountPage.submitButonu_SK);
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Submit butonuna tiklar");

        //Inventory islemlerinin yapildigini dogrula(Edit product yazisi gorunur)
        ReusableMethods.scroll(vendorMyAccountPage.editProductYazisi);
        softAssert.assertTrue(vendorMyAccountPage.editProductYazisi.isDisplayed(),"Edit product yazisi gozukmez");
        softAssert.assertAll();
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Inventory islemlerinin yapildigini dogrular");
        Extent_Reports.extentReport.flush();

       // vendorMyAccountPage.productTitleMetinAlani_SK.clear();
        ReusableMethods.bekle(2);
    }

    @Test(dependsOnMethods = "ilkOnAdim_15")
    public void test03() {
       /*Shipping işlemleri yapılabilmeli
       (Weight, Dimensions, Shipping class, Processing Time)*/
        Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
        Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);
        //Product title gir
        US_15_methods.productTitleEkle();
        Extent_Reports.extentTest.info("Kullanici Product title girer");

        //img alnina bir resim ekle
       US_15_methods.resimEkle();
        Extent_Reports.extentTest.info("Kullanici img alnina bir resim ekler");

        //Galery den resim ekle
       US_15_methods.galerydenResimEkle();
        Extent_Reports.extentTest.info("Kullanici Galery den resim ekler");

        //Product categori sec
        ReusableMethods.click(vendorMyAccountPage.catagoriesClikButonu_SK);
        ReusableMethods.bekle(4);
        Extent_Reports.extentTest.info("Kullanici Product categori secer");

        //Shipping butonuna tikla
        ReusableMethods.scroll(vendorMyAccountPage.shippingMenu_SK);
        ReusableMethods.click(vendorMyAccountPage.shippingMenu_SK);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(vendorMyAccountPage.shippingMenu_SK.isDisplayed(),"Shipping menu gorulmez");
        Extent_Reports.extentTest.info("Kullanici Shipping butonuna tiklar");

        //Weight alanina veri gonder
        //Diemnsions alanininda lengt e  veri gir
        //Widht alanına veri gir
        //Height alanına veri gir
        vendorMyAccountPage.weightKutusu_SK.sendKeys(faker.number().digits(3),
                Keys.TAB,faker.number().digits(2),
                Keys.TAB,faker.number().digits(2),
                Keys.TAB,faker.number().digits(3));

        Extent_Reports.extentTest.info("Kullanici Weight alanina veri gonderir");
        Extent_Reports.extentTest.info("Kullanici Diemnsions alanininda lengt e  veri girer");
        Extent_Reports.extentTest.info("Kullanici Widht alanına veri girer");
        Extent_Reports.extentTest.info("KullaniciHeight alanına veri girer");

        //Shipping class ddm butonuna tıkla
        ReusableMethods.ddmVisibleText(vendorMyAccountPage.shippingClassKutusuDDM_SK,"No shipping class");
        Extent_Reports.extentTest.info("Kullanici Shipping class ddm butonuna tıklar");

        //Processing Time butonuna tıkla ve ddm e erisilebildigini dogrula
        ReusableMethods.ddmIndex(vendorMyAccountPage.processing_timeDDM_SK,5);
        softAssert.assertTrue(vendorMyAccountPage.processing_timeDDM_SK.isEnabled(),"Processing Time DDM erisilmez");
        Extent_Reports.extentTest.info("Kullanici Processing Time butonuna tıkla ve ddm e erisilebildigini dogrular");

        //submit butonuna bas
        ReusableMethods.click(vendorMyAccountPage.submitButonu_SK);
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici submit butonuna basar");

        //Shipping işlemleri yapılabildigini dogrula
        ReusableMethods.scroll(vendorMyAccountPage.editProductYazisi);
        softAssert.assertTrue(vendorMyAccountPage.editProductYazisi.isDisplayed(),"Edit product yazisi gozukmez");

        softAssert.assertAll();
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Shipping işlemleri yapılabildigini dogrular");
        Extent_Reports.extentReport.flush();

    }
    @Test(dependsOnMethods = "ilkOnAdim_15")
    public void test04() {
        /*Attributes işlemleri yapılabilmeli (Color, Size)*/
        Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
        Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);
        //Product title gir
        US_15_methods.productTitleEkle();
        Extent_Reports.extentTest.info("Kullanici Product title girer");

        //img alnina bir resim ekle
        US_15_methods.resimEkle();
        Extent_Reports.extentTest.info("Kullanici Product title girer");

        //Galery den resim ekle
        US_15_methods.galerydenResimEkle();
        Extent_Reports.extentTest.info("Kullaniciimg alnina bir resim ekler");

        //Product categori sec
        ReusableMethods.click(vendorMyAccountPage.catagoriesClikButonu_SK);
        ReusableMethods.bekle(4);
        Extent_Reports.extentTest.info("Kullanici Product categori secer");

        //Attributes menuye verify yap ve tikla
        softAssert.assertTrue(vendorMyAccountPage.attributes_SK.isDisplayed(),"Attributes menu gorulmedi");
        ReusableMethods.bekle(3);
        ReusableMethods.click(vendorMyAccountPage.attributes_SK);
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici Attributes menuye verify yap ve tiklar");

        //Color secenegini verify yap ve tikla
        softAssert.assertTrue(vendorMyAccountPage.colorKutusunaClikButonu_SK.isDisplayed(),"Color button gorulmedi");
        ReusableMethods.bekle(3);
        ReusableMethods.click(vendorMyAccountPage.colorKutusunaClikButonu_SK);
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici Color secenegini verify yap ve tiklar");

        //Color DDM''  dan bir deger sec ve verify yap
        ReusableMethods.click(vendorMyAccountPage.color_DDM_SK);
        ReusableMethods.ddmIndex(vendorMyAccountPage.color_DDM_SK,16);
        softAssert.assertTrue(vendorMyAccountPage.color_DDM_SK.isEnabled(),"Color DDm'e ulasilamadi");
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici Color DDM''  dan bir deger sec ve verify yapar");

        // "Visible on the product page" kutunu secilebildigini dogrula
       softAssert.assertTrue(vendorMyAccountPage.visibleOnProductPageCheckbox_SK.isSelected()," color visible on the product page secili degil");
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici Visible on the product page kutunu secilebildigini dogrular");

        //Select all, select none ve add new butonlarının görünür olduğunu doğrula
        softAssert.assertTrue(vendorMyAccountPage.colorSelectAllButton_SK.isDisplayed()," (Color) SelectAll butonu gorulmedi");
        softAssert.assertTrue(vendorMyAccountPage.colorAddNewButton_SK.isDisplayed(),"(Color) Select AddNew butonu gorulmedi");
        softAssert.assertTrue(vendorMyAccountPage.colorSelectNoneButton_SK.isDisplayed()," Color SelectNone gorulmedi");
        Extent_Reports.extentTest.info("Kullanici Select all, select none ve add new butonlarının görünür olduğunu doğrular");

        // Active kutucuğunun secili oldugunu dogrula
        softAssert.assertTrue(vendorMyAccountPage.activeBox_SK.isSelected(),"Active kutusu secilemedi");
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici Active kutucuğunun secili oldugunu dogrular");

        //Size seçeneğinin görünür olduğunu doğrula ve clik yap
        softAssert.assertTrue(vendorMyAccountPage.sizeButton_SK.isDisplayed(),"Size butonu gorulmedi");
        ReusableMethods.bekle(3);
        ReusableMethods.click(vendorMyAccountPage.sizeButton_SK);
        ReusableMethods.bekle(3);
        Extent_Reports.extentTest.info("Kullanici Size seçeneğinin görünür olduğunu doğrular ve clik yapar");

        //Size DDM'e bir deger gir ve verify yap
        ReusableMethods.click(vendorMyAccountPage.sizeButtonDDM_SK);
        ReusableMethods.bekle(3);
        ReusableMethods.ddmIndex(vendorMyAccountPage.sizeButtonDDM_SK,2);
        ReusableMethods.bekle(3);
        softAssert.assertTrue(vendorMyAccountPage.sizeButtonDDM_SK.isDisplayed());
        Extent_Reports.extentTest.info("Kullanici Size DDM'e bir deger gir ve verify yapar");

        //Select all, select none ve add new butonlarının görünür olduğunu doğrula
        softAssert.assertTrue(vendorMyAccountPage.sizeSelectAllButton.isDisplayed(),"(Size) SelectAll butonu gorulmedi");
        softAssert.assertTrue(vendorMyAccountPage.sizeAddNewButton.isDisplayed(),"(Size) Select AddNew butonu gorulmedi");
        softAssert.assertTrue(vendorMyAccountPage.sizeSelectNoneButton.isDisplayed()," (Size) SelectNone gorulmedi");
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Select all, select none ve add new butonlarının görünür olduğunu doğrular");

       // 'Visible on the product page' kutusunu dogrula
        softAssert.assertTrue(vendorMyAccountPage.sizeVisibleOnProductPageCheckbox.isSelected()," select visible on the product page secili degil");
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici 'Visible on the product page' kutusunu dogrular");

        //Submit butonuna bas
        ReusableMethods.click(vendorMyAccountPage.submitButonu_SK);
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Submit butonuna basar");

       // Attributes islemlerinin yapildigini dogrula
        ReusableMethods.scroll(vendorMyAccountPage.editProductYazisi);
        ReusableMethods.bekle(3);
        softAssert.assertTrue(vendorMyAccountPage.editProductYazisi.isDisplayed(),"Edit product yazisi gorulmedi");
        ReusableMethods.bekle(3);
        softAssert.assertAll();
        ReusableMethods.bekle(2);
        Extent_Reports.extentTest.info("Kullanici Attributes islemlerinin yapildigini dogrular");
        Extent_Reports.extentReport.flush();
    }
    @AfterClass
    public void afterClass() {
        Driver.closeDriver();

    }




}

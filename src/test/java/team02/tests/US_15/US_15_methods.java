package team02.tests.US_15;

import team02.pages.VendorMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.ReusableMethods;

public class US_15_methods {
    public static void productTitleEkle(){
        VendorMyAccountPage vendorMyAccountPage=new VendorMyAccountPage();
        vendorMyAccountPage.productTitleMetinAlani_SK.clear();
        ReusableMethods.bekle(3);
        ReusableMethods.scroll(vendorMyAccountPage.productTitleMetinAlani_SK);
        vendorMyAccountPage.productTitleMetinAlani_SK.sendKeys(ConfigReader.getProperty("productTitle"));
    }
    public static void resimEkle(){
        VendorMyAccountPage vendorMyAccountPage=new VendorMyAccountPage();
        ReusableMethods.click(vendorMyAccountPage.fotografEkleWE_SK);
        ReusableMethods.bekle(4);
        ReusableMethods.click(vendorMyAccountPage.selectFilesButonu_SK);
        String dosyaYolu= "C:\\Users\\Eigenaar\\Pictures\\Ekran görüntüsü 2023-07-27 164828.png"; //kendi pc yolum
        ReusableMethods.uploadFile(dosyaYolu);
        ReusableMethods.bekle(4);
        ReusableMethods.click(vendorMyAccountPage.selectButonu_SK);
        ReusableMethods.bekle(4);
    }
    public static void galerydenResimEkle(){
        VendorMyAccountPage vendorMyAccountPage=new VendorMyAccountPage();
        ReusableMethods.click(vendorMyAccountPage.galleryImg_SK);
        ReusableMethods.bekle(4);
        ReusableMethods.click(vendorMyAccountPage.mediaLibrary_SK);
        ReusableMethods.bekle(4);
        ReusableMethods.click(vendorMyAccountPage.galerydenSecilenResim_SK);
        ReusableMethods.bekle(5);
        ReusableMethods.click(vendorMyAccountPage.addToGallery_SK);
        ReusableMethods.bekle(4);
    }
}

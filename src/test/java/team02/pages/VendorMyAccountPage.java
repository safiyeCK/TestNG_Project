package team02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team02.utilities.Driver;

import java.util.List;

public class VendorMyAccountPage {

    public VendorMyAccountPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }






    //yusuf(21-70)
@FindBy (xpath = "//*[.='Store Manager']")
public WebElement storeManager_YH;
@FindBy (xpath = "(//span[@class='text'])[4]")
public WebElement products_YH;
@FindBy (css = "#add_new_product_dashboard")
public WebElement addNewProducts_YH;
@FindBy (css = "#product_type")
public WebElement productTypeDDM_YH;
@FindBy (xpath = "//*[.='Simple Product']")
public WebElement simpleProduct_YH;
@FindBy (css = "#is_virtual")
public WebElement virtual_YH;
@FindBy (css = "#is_downloadable")
public WebElement downloadable_YH;
@FindBy (css = "#regular_price")
public WebElement price_YH;
@FindBy (css = "#sale_price")
public WebElement salePrice_YH;
@FindBy (css = "#wcfm_products_manage_form_general_expander")
public WebElement priceSalePriceProductTitleScreen_YH;
@FindBy (css = "#pro_title")
public WebElement productTitle_YH;
@FindBy (xpath = "(//input[@type='checkbox'])[4]")
public WebElement selectCategory_YH;
@FindBy (css = "#wcfm_products_simple_submit_button")
public WebElement submitAddProduct_YH;
@FindBy (css = "#wcfm_products_listing")
public WebElement productListSecreen_YH;
@FindBy (xpath = "//*[contains(text(),'Coupons')]")
public WebElement coupons_YH;
@FindBy (css = "#add_new_coupon_dashboard")
public WebElement addNewCoupons_YH;
@FindBy (css = "#coupons_manage_general_expander")
public WebElement couponOlusturmaScreen_YH;
@FindBy (css = "#title")
public WebElement codeOfCoupons_YH;
@FindBy (css = "#description")
public WebElement descriptonOfCoupons_YH;
@FindBy (css = "#discount_type")
public WebElement discountTypeDDM_YH;
@FindBy (css = "option[value='percent']")
public WebElement percentageOfDiscount_YH;
@FindBy (css = "#featured_img_display")
public WebElement addFeaturedImage_YH;





//emre(71-120)
    @FindBy(id = "menu-item-1079")
    public WebElement myAccountButonuEp;
    @FindBy(xpath = "(//li//a)[7]")
    public WebElement adressesButonuEp;
    @FindBy(xpath = "//*[@href='https://allovercommerce.com/my-account-2/edit-address/billing/']")
    public WebElement billingAddressAddButonuEp;
    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement billingAddressFirstNameEp;
    @FindBy(xpath = "//*[@id='billing_last_name']")
    public WebElement billingAddressLastNameEp;
    @FindBy(xpath = "//*[@id='billing_company']")
    public WebElement billingAddressCompanyNameEp;
    @FindBy(xpath = "//*[@id='billing_country']")
    public WebElement billingAddressCountryRegionDdmEp;
    @FindBy(xpath = "//*[@value='damarien.homero@feerock.com']")
    public WebElement billingAddressEmailEp;
    @FindBy(xpath = "//*[@value='davontay.zacheriah@free2ducks.com']")
    public WebElement billingAddressEmail1Ep;
    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement billingAddressStreetAddressKutusuEp;
    @FindBy(xpath = "//*[@id='billing_city']")
    public WebElement billingAddressTownCityEp;
    @FindBy(xpath = "//*[@id='billing_state']")
    public WebElement billingAddressStateDdmEp;
    @FindBy(xpath = "//*[@id='billing_postcode']")
    public WebElement billingAddressZipCodeEp;
    @FindBy(xpath = "//*[@id='billing_phone']")
    public WebElement billingAddressPhoneEp;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement billingSaveAddressEp;
    @FindBy(xpath = "//*[text()='Address changed successfully.']")
    public WebElement billingAddressChangedSuccessfullyMesajiEp;
    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public WebElement billingEditYourBillingAddressButonuEp;
    @FindBy(xpath = "//*[@data-id='billing_first_name']")
    public WebElement billingFirstNameNegatifMesajiEp;
    @FindBy(xpath = "//*[@data-id='billing_last_name']")
    public WebElement billingLastnameNegatifMesajiEp;
    @FindBy(xpath = "//*[@data-id='billing_country']")
    public WebElement billingCountryDdmNegatifMesaji;
    @FindBy(xpath = "//*[@data-id='billing_address_1']")
    public WebElement billingStreetAddressNegatifMesajiEp;
    @FindBy(xpath = "//*[@data-id='billing_city']")
    public WebElement billingAddressTownCityRequiredFieldEp;
    @FindBy(xpath = "//*[@data-id='billing_postcode']")
    public WebElement billingAddressZipCodeRequiredFieldEp;
    @FindBy(xpath = "//*[@data-id='billing_phone']")
    public WebElement billingAddressPhoneRequiredFieldEp;

    //ramazan(121-170)

















































    // safiye(171-350)
    @FindBy(xpath = "//li[@id='menu-item-1079']") //Tum TC'lerde ilk ortak methodlar
    public WebElement myAccountButonu_SK;
    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement signOutYazisi_SK;
    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement storeManagerButonu_SK;
    @FindBy (xpath = "(//span[@class='text'])[4]")
    public WebElement productsButonu_SK;
    @FindBy(css = "#add_new_product_dashboard")
    public WebElement addNewButonu_SK;
    @FindBy(xpath = "//select[@id='product_type']")  //TC01 locate
    public WebElement productTypeDDM_SK;
    @FindBy(xpath = "//img[@id='featured_img_display']")  //TC02 locateleri
    public WebElement fotografEkleWE_SK;
    @FindBy(xpath = "//button[@id='__wp-uploader-id-1']")
    public WebElement selectFilesButonu_SK;
    @FindBy(xpath = "(//div[@class='media-toolbar-primary search-form'])[2]")
    public WebElement selectButonu_SK;
    @FindBy(xpath = "//input[@id='featured_img_remove_button']")
    public WebElement xButtonu_SK;
    @FindBy(xpath = "//input[@id='pro_title']") //TC03 locate'leri
    public WebElement productTitleMetinAlani_SK;
    @FindBy(xpath = "//body[@data-id='excerpt']/p")
    public WebElement shortDescriptionMetinAlani_SK;
    @FindBy(xpath = "//body[.='Turkse snoepje met pistachenoten']/p")
    public WebElement shortDescriptionMetinAlaninaGirilenVeri_SK;
    @FindBy(xpath = "//body[@data-id='description']/p")
    public WebElement descriptionMetinAlani_SK;
    @FindBy(xpath = "//body[.='Nl-Ingredienten:Tarwebloem,Suiker,Palmolie,Pistachnoten,Zuurteregelar']/p")
    public WebElement descriptionMetinAlaninaGirilenVeri_SK;
    @FindBy(xpath = "(//p[@class='wcfm_title wcfm_full_ele'])[1]")  //TC04 locate leri
    public WebElement catagoriesYazisi_SK;
    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement catagoriesClikButonu_SK;
    @FindBy(xpath = "//input[@name='product_cats[]']")
    public List<WebElement> catagoriesToplamClikButonlari_SK;
    @FindBy(xpath = "//p[.='+Add new category']")  //TC05 Locate leri
    public WebElement addNewCategoryYazisi_SK;
    @FindBy(id = "wcfm_new_cat")
    public WebElement categoryNameKutusu_SK;
    @FindBy(id = "wcfm_new_parent_cat")
    public WebElement parentCategoryDDM_SK;
    @FindBy(xpath = "//button[@data-taxonomy='product_cat']")
    public WebElement addButonu_SK;
    @FindBy(xpath = "//input[@name='product_cats[]']")
    public WebElement categoryYeniEklenenUrun_SK;
    @FindBy(xpath = "//input[@class='wcfm-checkbox checklist_type_product_brand ']")  //TC06 locateleri
    public WebElement productBrandsClikButonu_SK;
    @FindBy(xpath = "//input[@name='product_custom_taxonomies[product_brand][]']")
    public List<WebElement> productBrandsListesi_SK;
    @FindBy(xpath = "//p[text()='+Add new Product brands']") //TC07 locateleri
    public WebElement addNewproductBrandsYazisi_SK;
    @FindBy(xpath = "//input[@id='wcfm_new_product_brand']")
    public WebElement productBrandsNameKutusu_SK;
    @FindBy(xpath = "(//input[@name='product_custom_taxonomies[product_brand][]'])[1]")
    public WebElement productBrandsEklenenUrun_SK;
    @FindBy(xpath = "//select[@id='wcfm_new_parent_product_brand']")
    public WebElement parentTaxonomyDDM_SK;
    @FindBy(xpath = "//button[@data-taxonomy='product_brand']")
    public WebElement productBrandAddButonu_SK;
    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[1]")//US_15,TC01 locates
    public WebElement inventoryMenu_SK;
    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[4]")
    public WebElement shippingMenu_SK;
    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributesMenu_SK;
    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[7]")
    public WebElement linkedMenu_SK;
    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[8]")
    public WebElement seoMenu_SK;
    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[10]")
    public WebElement advencedMenu_SK;
    @FindBy(css ="#sku")   //test02 locates
    public WebElement SKUKutusu_SK;
    @FindBy(css = "#manage_stock")
    public WebElement manageStokClikButonu_SK;
    @FindBy(css = "#stock_qty")
    public WebElement stokQtyKutusu_SK;
    @FindBy(css = "#backorders")
    public WebElement allowBackordersDDM_SK;
    @FindBy(css = "#stock_status")
    public WebElement stokStatussDDM_SK;
    @FindBy(css = "#sold_individually")
    public WebElement soldIndividuallyClikButonu_SK;
    @FindBy(css = "#wcfm_products_simple_submit_button")
    public WebElement submitButonu_SK;
    @FindBy(xpath = "(//h2)[2]")
    public WebElement editProductYazisi;
    @FindBy(css = "#gallery_img_gimage_0_display")
    public WebElement galleryImg_SK;
    @FindBy(css = "#menu-item-browse")
    public WebElement mediaLibrary_SK;
    @FindBy(xpath = "(//li[@role='checkbox'])[7]")
    public WebElement galerydenSecilenResim_SK;
    @FindBy(xpath = "(//div[@class='media-toolbar-primary search-form'])[4]")
    public WebElement addToGallery_SK;
    @FindBy(css = "#weight") //TC03 locates
    public WebElement weightKutusu_SK;
    @FindBy(css ="#shipping_class")
    public WebElement shippingClassKutusuDDM_SK;
    @FindBy(css ="#_wcfmmp_processing_time")
    public WebElement processing_timeDDM_SK;
    @FindBy(css =" #wcfm_products_manage_form_attribute_head")   //TC04 locates
    public WebElement attributes_SK;
    @FindBy(css ="#attributes_is_active_1")
    public WebElement colorKutusunaClikButonu_SK;
    @FindBy(css ="#attributes_value_1")
    public WebElement color_DDM_SK;
    @FindBy(css ="#attributes_is_active_1")
    public WebElement activeBox_SK;
    @FindBy(css = "#attributes_is_visible_1")
    public WebElement visibleOnProductPageCheckbox_SK;
    @FindBy(xpath = "(//*[text()='Select all'])[1]")
    public WebElement colorSelectAllButton_SK;
    @FindBy(xpath = "(//*[text()='Select none'])[1]")
    public WebElement colorSelectNoneButton_SK;
    @FindBy(xpath = "(//*[text()='Add New'])[2]")
    public WebElement colorAddNewButton_SK;
    @FindBy(css ="#attributes_is_active_2")
    public WebElement sizeButton_SK;
    @FindBy(css ="#attributes_value_2")
    public WebElement sizeButtonDDM_SK;
    @FindBy(xpath = "(//*[text()='Select all'])[2]")
    public WebElement sizeSelectAllButton;
    @FindBy(xpath = "(//*[text()='Select none'])[2]")
    public WebElement sizeSelectNoneButton;
    @FindBy(xpath = "(//*[text()='Add New'])[3]")
    public WebElement sizeAddNewButton;
    @FindBy(css = "#attributes_is_visible_2")
    public WebElement sizeVisibleOnProductPageCheckbox;
    @FindBy(css = "#__wp-uploader-id-1")
    public WebElement selectFilesButonu_YH;















































    //yusuf (351/400)

    @FindBy (css = "#coupon_amount")
    public WebElement couponAmountKutusu_YH;
    @FindBy (css = "#expiry_date")
    public WebElement couponExpiryDate_YH;
    @FindBy (css = "#free_shipping")
    public WebElement allowFreeshippnigButton_YH;
    @FindBy (css = "#show_on_store")
    public WebElement showOnStoreButton_YH;
    @FindBy (css = "#wcfm_coupon_manager_submit_button")
    public WebElement submitAddCoupon_YH;
    @FindBy (xpath = "//tbody/tr/td[1]")
    public WebElement couponListFirstElementCouponCode_YH;
    @FindBy (xpath = "//*[.='Media Library']")
    public WebElement addProductImageMediaLibrary_YH;
    @FindBy (xpath = "(//div[@class='thumbnail'])[1]")
    public WebElement addProductImageMediaLibraryImage1_YH;
    @FindBy (xpath = "(//div[@class='media-toolbar-primary search-form']/button)[1]")
    public WebElement addProductImageMediaLibrarySelectButton_YH;
    @FindBy (css = "#gallery_img_gimage_0_display")
    public WebElement addProductImageGalery_YH;
    @FindBy (xpath = "(//div[@class='thumbnail'])[7]")
    public WebElement addProductImageMediaLibraryImage2_YH;
    @FindBy (xpath = "(//div[@class='media-toolbar-primary search-form']/*[.='Add to Gallery'])[1]")
    public WebElement addProductImageMediaLibraryAddToGallery_YH;
    @FindBy (css = "div[class='wcfm-message wcfm-success']")
    public WebElement productSuccesflyPublished_YH;






















//emre (401/500)
    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement shippingAddressAddButonuEp;
    @FindBy(xpath = "//*[@id='shipping_first_name']")
    public WebElement shippingAddressFirstNameKutusuEp;
    @FindBy(xpath = "//*[@id='shipping_last_name']")
    public WebElement shippingAddressLastNameKutusuEp;
    @FindBy(xpath = "//*[@id='shipping_company']")
    public WebElement shippingAdressCompanyNameKutusuEp;
    @FindBy(xpath = "//*[@id='select2-shipping_country-container']")
    public WebElement shippingAddressCountryRegionDdmEp;
    @FindBy(xpath = "//span[@class='select2-selection__placeholder']")
    public WebElement shippingAddressCountryRegionDdm1Ep;
    @FindBy(xpath = "//*[@id='shipping_address_1']")
    public WebElement shippingAddressStreetAddressKutusu1Ep;
    @FindBy(xpath = "//*[@id='shipping_address_2']")
    public WebElement shippingAddressStreetAddressKutusu2Ep;
    @FindBy(xpath = "//*[@id='shipping_city']")
    public WebElement shippingAddressTownCityKutusuEp;
    @FindBy(xpath = "//*[@id='select2-shipping_state-container']")
    public WebElement shippingAddressStateDdmEp;
    @FindBy(xpath = "//*[@id='shipping_postcode']")
    public WebElement shippingAddressZipCodeKutusuEp;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement shippingAddressSaveAddressButonuEp;
    @FindBy(xpath = "//*[text()='Address changed successfully.']")
    public WebElement shippingAddressChangedSuccessfullyMesajiEp;
    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement register;
    @FindBy(xpath = "(//*[text()='Become a Vendor'])[1]")
    public WebElement becomeVendor;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement vendorRegistrationYazisi;
    @FindBy(xpath = "//*[@id='email']")
    public WebElement fakeMail;
    @FindBy(xpath = "//*[@name='user_email']")
    public WebElement vendorRegisterEmail;
    @FindBy(xpath = "(//table)[1]//tbody//tr[1]//td[1]")
    public WebElement fakeMailDogrulamaMaili;
    @FindBy(xpath = "//*[@id='iframeMail']")
    public WebElement iframe;
    @FindBy(xpath = "(//*[@style='margin: 0 0 16px;'])[2]")
    public WebElement fakeMailVerification;
    @FindBy(xpath = "//*[@name='wcfm_email_verified_input']")
    public WebElement verificationCode;
    @FindBy(xpath = "//*[@id='passoword']")
    public WebElement password;
    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']")
    public WebElement vendorRegisterButonu;
    @FindBy(xpath = "//*[text()='Not right now']")
    public WebElement notRightNow;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement storeManagerYazisi;
    @FindBy(xpath = "(//*[.='Sign Out'])[1]")
    public WebElement signOutButonu;
    @FindBy(xpath = "//*[text()='First name is a required field.']")
    public WebElement shippingAddressFirstNameWarningEp;
    @FindBy(xpath = "//*[text()='Last name is a required field.']")
    public WebElement shippingAddressLastNameWarningEp;
    @FindBy(xpath = "//*[text()='Country / Region is a required field.']")
    public WebElement shippingAddressCountryRegionWarningMessageEp;
    @FindBy(xpath = "//*[text()='Street address is a required field.']")
    public WebElement shippingAddressStreetAddressWarningMessageEp;
    @FindBy(xpath = "//*[text()='Town / City is a required field.']")
    public WebElement shippingAddressTownCityWarningMessageEp;
    @FindBy(xpath = "//*[text()='ZIP Code is a required field.']")
    public WebElement shippingAddressZipCodeWarningMessageEp;

































    //ibrahim  (501/750)

    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signInLinki_IO;

    @FindBy(css = "#username")
    public WebElement emailVeyaUserNameKutusu_IO;

    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement signInButonu_IO;

    @FindBy(xpath = "(//*[.='My Account'])[3]")
    public WebElement myAccountLinki_IO;

    @FindBy(xpath = "//h2[.='My Account']")
    public WebElement myAccountYazisi_IO;

    @FindBy(xpath = "//*[contains(text(),'Please, complete this field')]")
    public WebElement lutfenBuAlaniDoldurunYazisi_IO;

    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManagerLinki_IO;

    @FindBy(xpath = "//a[.='Orders']")
    public WebElement ordersLinki_IO;

    @FindBy(xpath = "//a[.='Downloads']")
    public WebElement downloadsLinki_IO;

    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement addressesLinki_IO;

    @FindBy(xpath = "//a[.='Account details']")
    public WebElement accountDetailsLinki_IO;

    @FindBy(xpath = "//a[.='Wishlist']")
    public WebElement wishListLinki_IO;

    @FindBy(xpath = "//a[.='Support Tickets']")
    public WebElement supportTicketsLinki_IO;

    @FindBy(xpath = "//a[.='Followings']")
    public WebElement followingsLinki_IO;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutLinki_IO;

    @FindBy(xpath = "//h2[.='Store Manager']")
    public WebElement storeManagerYazisi_IO;

    @FindBy(xpath = "//h4[.='Orders']")
    public WebElement ordersYazisi_IO;

    @FindBy(xpath = "//h4[.='Downloads']")
    public WebElement downLoadsYazisi_IO;

    @FindBy(xpath = "//h4[.='Account Details']")
    public WebElement accountDetailsYazisi_IO;

    @FindBy(xpath = "//h2[.='Wishlist']")
    public WebElement wishListYazisi_IO;

    @FindBy(xpath = "//span[.='Ticket(s)']")
    public WebElement ticketsYazisi_IO;

    @FindBy(xpath = "//span[.='Store']")
    public WebElement storeYazisi_IO;

    @FindBy(xpath = "//h4[.='Addresses']")
    public WebElement addressesYazisi_IO;

    @FindBy(xpath = "//*[.='WELCOME TO ALLOVER COMMERCE...']")
    public WebElement welcomeToAlloverCommerceYazisi_IO;

    @FindBy(xpath = "//*[@class='login logout inline-type']/span")
    public WebElement signOutLinki_IO;
















































































































































































































































    
}//finish 751


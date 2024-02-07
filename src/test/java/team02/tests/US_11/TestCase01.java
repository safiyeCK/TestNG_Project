package team02.tests.US_11;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import team02.pages.VendorMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase01 {

	VendorMyAccountPage page = new VendorMyAccountPage();
	@Test
	public void test01() {

		ilkYediAdim();

		// Site ana sayfasina cikarak Logout ol
		page.logoutLinki_IO.click();
	}

	@Test
	public void test02() {

		ilkYediAdim();
		signOutLinkineTikla();

		//	My Account sayfasinda Dashboard menusundeki
		//  'Store Manager' linkinin goruldugunu dogrula
		Assert.assertTrue(page.storeManagerLinki_IO.isDisplayed());

		//  'Orders' linkinin goruldugunu dogrula
		Assert.assertTrue(page.ordersLinki_IO.isDisplayed());

		//  'Downloads' linkinin goruldugunu dogrula
		Assert.assertTrue(page.downloadsLinki_IO.isDisplayed());

		//  'Addresses' linkinin goruldugunu dogrula
		Assert.assertTrue(page.addressesLinki_IO.isDisplayed());

		//  'Account Details' linkinin goruldugunu dogrula
		Assert.assertTrue(page.accountDetailsLinki_IO.isDisplayed());

		//  'Wishlist' linkinin goruldugunu dogrula
		Assert.assertTrue(page.wishListLinki_IO.isDisplayed());

		//   'Support Tickets' linkinin goruldugunu dogrula
		Assert.assertTrue(page.supportTicketsLinki_IO.isDisplayed());

		//  'Followings' linkinin goruldugunu dogrula
		Assert.assertTrue(page.followingsLinki_IO.isDisplayed());

		//  'Logout' linkinin goruldugunu dogrula
		Assert.assertTrue(page.logoutLinki_IO.isDisplayed());

		// Site ana sayfasina cikarak Logout ol
		page.logoutLinki_IO.click();
	}

	@Test
	public void test03() {

		ilkYediAdim();
		signOutLinkineTikla();

		//  'Store Manager' linkini tikla
		page.storeManagerLinki_IO.click();
		ReusableMethods.bekle(1);

		//  Acilan sayfada; 'Store Manager' yazisinin goruldugunu dogrula
		Assert.assertTrue(page.storeManagerYazisi_IO.isDisplayed());
		signOutLinkineTikla();

		// 'Orders' linkini tikla
		page.ordersLinki_IO.click();
		ReusableMethods.bekle(1);

		// Acilan sayfada; 'Orders' yazisinin goruldugunu dogrula
		Assert.assertTrue(page.ordersYazisi_IO.isDisplayed());
		signOutLinkineTikla();

		// 'Downloads' linkini tikla
		page.downloadsLinki_IO.click();
		ReusableMethods.bekle(1);

		// Acilan sayfada; 'Downloads' yazisinin goruldugunu dogrula
		Assert.assertTrue(page.downLoadsYazisi_IO.isDisplayed());
		signOutLinkineTikla();

		// 'Addresses' linkini tikla
		page.addressesLinki_IO.click();

		// Acilan sayfada; 'Addresses' yazisinin goruldugunu dogrula
		Assert.assertTrue(page.addressesYazisi_IO.isDisplayed());
		signOutLinkineTikla();

		// 'Account Details' linkini tikla
		page.accountDetailsLinki_IO.click();

		// Acilan sayfada; 'Account Details' yazisinin goruldugunu dogrula
		Assert.assertTrue(page.accountDetailsYazisi_IO.isDisplayed());
		signOutLinkineTikla();

		// Wishlist linkini tikla
		page.wishListLinki_IO.click();

		// Acilan sayfada; 'Wishlist' yazisinin goruldugunu dogrula
		Assert.assertTrue(page.wishListYazisi_IO.isDisplayed());
		signOutLinkineTikla();

		// 'Support Tickets' linkini tikla
		page.supportTicketsLinki_IO.click();

		// Acilan sayfada; 'Ticket(s)' yazisinin goruldugunu dogrula
		Assert.assertTrue(page.ticketsYazisi_IO.isDisplayed());
		signOutLinkineTikla();

		// 'Followings' linkini tikla
		page.followingsLinki_IO.click();

		// Acilan sayfada; 'Store' yazisinin goruldugunu dogrula
		Assert.assertTrue(page.storeYazisi_IO.isDisplayed());
		signOutLinkineTikla();

		// 'Logout' linkini tikla
		page.logoutLinki_IO.click();

		// Site ana sayfasina cikilarak WELCOME TO ALLOVER COMMERCE... yazisinin goruldugunu
		// ve Logout olundugunu dogrula
		Assert.assertTrue(page.welcomeToAlloverCommerceYazisi_IO.isDisplayed());
	}

	@Test
	public void test04() {

		ilkIkiAdim();

		// Email adres alanini bos birak
		// Password kutusuna kayıtlı şifreyi gir
		page.emailVeyaUserNameKutusu_IO.sendKeys(Keys.TAB,ConfigReader.getProperty("password_IO"));

		// Sign In butonuna tıkla
		page.signInButonu_IO.click();
		ReusableMethods.bekle(2);

		// Ekranda "! Lütfen bu alanı doldurun"("Please insert username before submit.") yazisini goruldugunu dogrula
		// Sayfanin tüm html kodlarini string olarak alip contains() methodu ile "Please insert username before submit."
		// icerdigini dogruluyoruz.
		Assert.assertTrue(Driver.getDriver().getPageSource().contains("Please insert username before submit."));

	}

	@Test
	public void test05() {

		ilkIkiAdim();

		// Email kutusuna kayitli email adresini gir
		// Password alanini bos birak
		page.emailVeyaUserNameKutusu_IO.sendKeys(ConfigReader.getProperty("email_IO"),
				Keys.TAB);

		// Sign In butonuna tıkla
		page.signInButonu_IO.click();
		ReusableMethods.bekle(2);

		// Ekranda "! Lütfen bu alanı doldurun"("Please insert password before submit.") yazisini goruldugunu dogrula
		// Sayfanin tüm html kodlarini string olarak alip contains() methodu ile "Please insert password before submit."
		// icerdigini dogruluyoruz.
		Assert.assertTrue(Driver.getDriver().getPageSource().contains("Please insert password before submit."));
	}

	public void signOutLinkineTikla() {

		ReusableMethods.bekle(1);
		page.signOutLinki_IO.click();
	}

	public void ilkIkiAdim(){

		// Allower Commerce ana sayfasina git	https://allovercommerce.com/
		Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

		// Sign in linkine tıkla
		page.signInLinki_IO.click();
	}
	public void ilkYediAdim(){

		//  Allower Commerce ana sayfasina git
		Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

		//  Sign in linkine tıkla
		page.signInLinki_IO.click();

		//  Email kutusuna kayitli email adresini gir
		//  Password kutusuna kayıtlı şifreyi gir

		page.emailVeyaUserNameKutusu_IO.sendKeys(ConfigReader.getProperty("email_IO"),
				Keys.TAB,ConfigReader.getProperty("password_IO"),
				Keys.ENTER);

		//  Sign In butonuna tıkla
		page.signInButonu_IO.click();

		//  Acilan sayfanin altinda Footer bolumunde 'My Account' linkini  tikla
		ReusableMethods.scrollEnd();
		ReusableMethods.bekle(2);
		page.myAccountLinki_IO.click();

		//  Acilan sayfada; 'My Account' yazisinin goruldugunu dogrula
		Assert.assertTrue(page.myAccountYazisi_IO.isDisplayed());
		ReusableMethods.bekle(1);
	}
	@AfterClass
	public void afterClass() {
		Driver.getDriver().close();
	}
}

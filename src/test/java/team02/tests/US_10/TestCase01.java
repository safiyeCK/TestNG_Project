package team02.tests.US_10;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team02.pages.RegisterPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;

import java.io.ObjectInputFilter;

public class TestCase01 {

	RegisterPage vendorRegPage = new RegisterPage();

	@BeforeMethod

	public void setUp() {

		// Allower Commerce ana sayfasina git
		Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

		// Register Butonuna tikla
		vendorRegPage.registerLinki_IO.click();

		// Acilan pencerede Become  a Vendor linkine tikla
		vendorRegPage.becomeAVendorLinki_IO.click();
	}

	@Test
	public void testCase01() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass01_IO"));

		//	Password kutusu altinda 'Too short' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.tooShortYazisi_IO.isDisplayed());
	}

	@Test
	public void testCase02() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass02_IO"));

		//	Password kutusu altinda 'Too short' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.tooShortYazisi_IO.isDisplayed());
	}

	@Test
	public void testCase03() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass03_IO"));

		//	Password kutusu altinda 'Too short' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.tooShortYazisi_IO.isDisplayed());
	}

	@Test
	public void testCase04() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass04_IO"));

		//	Password kutusu altinda 'Too short' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.tooShortYazisi_IO.isDisplayed());
	}

	@Test
	public void testCase05() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass05_IO"));

		//	Password kutusu altinda 'Weak' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.weakYazisi_IO.isDisplayed());
	}

	@Test
	public void testCase06() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass06_IO"));

		//	Password kutusu altinda 'Weak' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.weakYazisi_IO.isDisplayed());
	}

	@Test
	public void testCase07() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass07_IO"));

		//	Password kutusu altinda 'Good' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.goodYazisi_IO.isDisplayed());
	}

	@Test
	public void testCase08() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass08_IO"));

		//	Password kutusu altinda 'Strong' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.strongYazisi_IO.isDisplayed());
	}

	@Test
	public void testCase09() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass09_IO"));

		//	Password kutusu altinda 'Weak' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.weakYazisi_IO.isDisplayed());
	}

	@Test
	public void testCase10() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass10_IO"));

		//	Password kutusu altinda 'Good' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.goodYazisi_IO.isDisplayed());
	}

	@Test
	public void testCase11() {

		//	Password kutusuna deger gir
		vendorRegPage.passwordKutusu_IO.sendKeys(ConfigReader.getProperty("pass11_IO"));

		//	Password kutusu altinda 'Strong' uyarisinin goruldugunu dogrula
		Assert.assertTrue(vendorRegPage.strongYazisi_IO.isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		Driver.getDriver().close();
	}
}

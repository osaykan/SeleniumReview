package com.techproed.tests;
import com.techproed.pages.AmazonRegisterPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonRegisterTest extends TestBase {
    /*
    User Story
	- Amazon Register (kayıt)
	Ben bir kullanıcı olarak, doğru bilgileri girdikten sonra kayıt olabilmeliyim, böylece satın alma işlemi gerçekleştirebilirim.
*	AC 01 : Name box görünür olmalı.
*	AC 02 : Name box boş bırakılamamalı.
*	AC 03 : Email box görünür olmalı.
*	AC 04 : Email box boş bırakılamamalı.
	AC 05 : Emailin içerisinde 1 tane @ karakteri, 1 tane . olmalı.
			(hamzayilmaz@gmail.com)
	AC 06 : Emailin içerisinde @ karekterinden önce en az 1 tane, sonrada 			en az 3 tane karakter olmalı.
			(@gmail.com - hamza@ - hamza@a.a)
*	AC 07 : Şifre kutusu görünür olmalı.
	AC 08 : Şifre kutusu boş bırakılamamalı.
*	AC 09 : 2. Şifre kutusu görünür olmalı.
	AC 10 : 2. Şifre kutusu boş bırakılamamalı.
	AC 11 : Şifre en az 6 karakterden oluşmalı.
	AC 12 : Şifreler birbiriyle aynı olmalı.
*	AC 13 : Create you amazon account butonu görünür olmalı.
1. Adım
	pages paketinin altında test edeceğimiz sayfanın webelement'lerini içeren bir tane class oluşturmalıyız.
2. Adım
	test edeceğimiz sayfa için, test methodlarını yazacağımız test class'ı oluşturmak (tests paketinin altında)
3. Adım
	properties file'ın içerisine kullanacağımız verileri eklemek.
	(örnek : kullanici_adi = hamzayilmaz   kullanici_sifresi = Ankara06.)
     */
    private AmazonRegisterPage amazonRegisterPage = new AmazonRegisterPage();
    @AfterMethod
    public void setUp(){
        amazonRegisterPage.nameBox.clear();
        amazonRegisterPage.emailBox.clear();
        amazonRegisterPage.passwordBox.clear();
        amazonRegisterPage.rePasswordBox.clear();
    }
    @Test(priority = 0)
    public void ilkTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_register_url"));
        Assert.assertEquals(Driver.getDriver().getTitle(),"Amazon Registration");
    }
    // AC 01 : Name box görünür olmalı.
    @Test(priority = 1)
    public void nameBoxGorunurTesti(){
        boolean nameBoxGorunurMu = amazonRegisterPage.nameBox.isDisplayed();
        Assert.assertTrue(nameBoxGorunurMu);
    }
    //AC 03 : Email box görünür olmalı.
    @Test(priority = 2)
    public void emailBoxGorunurTesti(){
        boolean emailBoxGorunurMu = amazonRegisterPage.emailBox.isDisplayed();
        Assert.assertTrue(emailBoxGorunurMu);
    }
    //AC 07 : Şifre kutusu görünür olmalı.
    @Test (priority = 3)
    public void sifreKutusuGorunurTesti(){
        boolean passBoxGorunurMu = amazonRegisterPage.passwordBox.isDisplayed();
        Assert.assertTrue(passBoxGorunurMu);
    }
    //AC 09 : 2. Şifre kutusu görünür olmalı.
    @Test(priority = 4)
    public void reSifreKutusuGorunurTesti(){
        boolean rePassBoxGorunuyorMu = amazonRegisterPage.rePasswordBox.isDisplayed();
        Assert.assertTrue(rePassBoxGorunuyorMu);
    }
    //AC 13 : Create you amazon account butonu görünür olmalı.
    @Test(priority = 5)
    public void buttonGorunurMu(){
        boolean buttonGorunuyorMu = amazonRegisterPage.continueButton.isDisplayed();
        Assert.assertTrue(buttonGorunuyorMu);
    }
    //AC 02 : Name box boş bırakılamamalı.
    @Test(priority = 6)
    public void kayitTestiNameboxBos(){
        amazonRegisterPage.passwordBox.sendKeys(ConfigurationReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.emailBox.sendKeys(ConfigurationReader.getProperty("amazon_register_email"));
        // amazonRegisterPage.nameBox.sendKeys(ConfigReader.getProperty("amazon_register_name"));
        amazonRegisterPage.rePasswordBox.sendKeys(ConfigurationReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.continueButton.click();
        Assert.assertFalse( Driver.getDriver().getTitle().equals("Authentication required") );
    }
    //AC 04 : Email box boş bırakılamamalı.
    @Test(priority = 7)
    public void kayitTestiEmailboxBos(){
        amazonRegisterPage.passwordBox.sendKeys(ConfigurationReader.getProperty("amazon_register_pass"));
        //amazonRegisterPage.emailBox.sendKeys(ConfigReader.getProperty("amazon_register_email"));
        amazonRegisterPage.nameBox.sendKeys(ConfigurationReader.getProperty("amazon_register_name"));
        amazonRegisterPage.rePasswordBox.sendKeys(ConfigurationReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.continueButton.click();
        Assert.assertFalse( Driver.getDriver().getTitle().equals("Authentication required") );
    }
    //	AC 08 : Şifre kutusu boş bırakılamamalı.
    @Test(priority = 8)
    public void sifreKutusuBosOlmali(){
        amazonRegisterPage.nameBox.sendKeys(ConfigurationReader.getProperty("amazon_register_name"));
        amazonRegisterPage.emailBox.sendKeys(ConfigurationReader.getProperty("amazon_register_email"));
        //   amazonRegisterPage.passwordBox.sendKeys(ConfigReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.rePasswordBox.sendKeys(ConfigurationReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.continueButton.click();
        Assert.assertFalse( Driver.getDriver().getTitle().equals("Authentication required") );
    }
    //AC 10 : 2. Şifre kutusu boş bırakılamamalı.
    @Test(priority = 9)
    public void ikinciSifreKutusuBosOlmali(){
        amazonRegisterPage.nameBox.sendKeys(ConfigurationReader.getProperty("amazon_register_name"));
        amazonRegisterPage.emailBox.sendKeys(ConfigurationReader.getProperty("amazon_register_email"));
        amazonRegisterPage.passwordBox.sendKeys(ConfigurationReader.getProperty("amazon_register_pass"));
        //  amazonRegisterPage.rePasswordBox.sendKeys(ConfigReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.continueButton.click();
        Assert.assertFalse( Driver.getDriver().getTitle().equals("Authentication required") );
    }
    //AC 05 : Emailin içerisinde 1 tane @ karakteri, 1 tane . olmalı.
    //			(hamzayilmaz@gmail.com)
    //AC 06 : Emailin içerisinde @ karekterinden önce en az 1 tane, sonrada
    //          en az 3 tane karakter olmalı.
    //   		(@gmail.com - hamza@ - hamza@a.a)
    @Test(priority = 10)
    public void emailDogrulamaTesti() throws InterruptedException {
        String[] emailler = {ConfigurationReader.getProperty("amazon_wrong_email01"),
                ConfigurationReader.getProperty("amazon_wrong_email02"),
                ConfigurationReader.getProperty("amazon_wrong_email03"),
                ConfigurationReader.getProperty("amazon_wrong_email04"),
                ConfigurationReader.getProperty("amazon_wrong_email05"),
                ConfigurationReader.getProperty("amazon_wrong_email06")};
        SoftAssert softAssert = new SoftAssert();
        for(int i = 0 ; i < emailler.length ; i++){
            Thread.sleep(1000);
            amazonRegisterPage.nameBox.clear();
            amazonRegisterPage.emailBox.clear();
            amazonRegisterPage.passwordBox.clear();
            amazonRegisterPage.rePasswordBox.clear();
            amazonRegisterPage.nameBox.sendKeys(ConfigurationReader.getProperty("amazon_register_name"));
            amazonRegisterPage.emailBox.sendKeys(emailler[i]);
            amazonRegisterPage.passwordBox.sendKeys(ConfigurationReader.getProperty("amazon_register_pass"));
            amazonRegisterPage.rePasswordBox.sendKeys(ConfigurationReader.getProperty("amazon_register_pass"));
            Thread.sleep(1000);
            amazonRegisterPage.continueButton.click();
            softAssert.assertFalse(Driver.getDriver().getTitle().equals("Authentication required"));
        }
        softAssert.assertAll();
    }
    //AC 11 : Şifre en az 6 karakterden oluşmalı.
    @Test(priority = 11)
    public void sifreUzunluguTesti(){
        amazonRegisterPage.nameBox.sendKeys(ConfigurationReader.getProperty("amazon_register_name"));
        amazonRegisterPage.emailBox.sendKeys(ConfigurationReader.getProperty("amazon_register_email"));
        amazonRegisterPage.passwordBox.sendKeys(ConfigurationReader.getProperty("amazon_wrong_pass"));
        amazonRegisterPage.rePasswordBox.sendKeys(ConfigurationReader.getProperty("amazon_wrong_pass"));
        amazonRegisterPage.continueButton.click();
        Assert.assertFalse( Driver.getDriver().getTitle().equals("Authentication required") );
    }
    //AC 12 : Şifreler birbiriyle aynı olmalı.
    @Test(priority = 12)
    public void sifrelerAynimiTest(){
        amazonRegisterPage.nameBox.sendKeys(ConfigurationReader.getProperty("amazon_register_name"));
        amazonRegisterPage.emailBox.sendKeys(ConfigurationReader.getProperty("amazon_register_email"));
        amazonRegisterPage.passwordBox.sendKeys(ConfigurationReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.rePasswordBox.sendKeys(ConfigurationReader.getProperty("amazon_register_pass1"));
        amazonRegisterPage.continueButton.click();
        Assert.assertFalse( Driver.getDriver().getTitle().equals("Authentication required") );
    }
    private static boolean getEmailDogruMu(String email) {
        if(!email.contains("@"))
            return false;
        if(!email.contains("."))
            return false;
        if(email.length()<=5)
            return false;
        String[] array = email.split("@");  //a@a.b
        if(array[0].length()<1)
            return false;
        if(array[1].length()<3)
            return false;
        if(array.length > 2)
            return false;
        return true;
    }
}
package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadUploadTest extends TestBase {
    @Test
    public void dosyaVarMi(){
        // Suanda bulundugumuz klasörün dosya yolunu veriyor.(String olarak)
        System.out.println(   System.getProperty("user.dir")   );//C:\Users\Mz\IdeaProjects\NewTestNG

// Kullanicin ana klasörünün dosya yolunu veriyor. (String olarak)
        System.out.println(   System.getProperty("user.home")   );//C:\Users\Mz

        // Java ile belirtilen adreste, aradığımız dosyanın var olup olmadığını
        // asagidaki kod ile yapabiliyoruz.
        // Eger dosya varsa, TRUE  - Eger dosya yoksa, FALSE


        boolean varMi = Files.exists(Paths.get("C:\\Users\\Mz\\IdeaProjects\\NewTestNG\\pom.xml"));
        Assert.assertTrue(varMi);

    }
    @Test
    public void dosyaUpload(){
        driver.get("http://the-internet.herokuapp.com/upload");
        // "dosya seç (choose file)" webelementini locate ettik.
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
// sendKeys ile upload etmek istediğimiz dosyanın adresini göndermemiz gerekiyor.
        chooseFile.sendKeys("C:\\Users\\Mz\\Downloads\\image1.jpg");
        driver.findElement(By.id("file-submit")).click();

    }
    @Test
    public void dosyaIndirme(){
        // websitesinden, indirmek istediğimiz dosyayı indirdikten sonra,
// bilgisayarımızda indirme klasöründe, o dosyanın var olup olmadığını kontrol
// ediyoruz. Eğer dosya varsa, indirme işleminde bir problem yok diyebiliriz.
// Dikkat edilmesi gereken bir husus : Bazen indirme işlemi uzun sürebilir. Bu yüzden
// indirme işleminden sonra, bir müddet beklemek gerekir. Thread.sleep ile yapabiliriz.
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement penguenLink=driver.findElement(By.partialLinkText("Penguins.jpg"));
        penguenLink.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean varMi = Files.exists(Paths.get("C:\\Users\\Mz\\Downloads\\Penguins.jpg"));
        Assert.assertTrue(varMi);

    }
}

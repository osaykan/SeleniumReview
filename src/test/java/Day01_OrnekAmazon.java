import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day01_OrnekAmazon {
    // 1. Amazon.com'a gidecegiz.
// 2. Arama kutusuna "baby stroller"
// 3. 2. Siradaki ürüne tiklayacagiz.
// 4. Ürün sayfasina gittikten sonra, ürünün toplam fiyatini alacagiz.
// 5. Ürünün ortalama puanini (5 üzerinden) alacagiz.

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com/");
        driver.manage().window().maximize();
        // 2. Arama kutusuna "baby stroller"
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby stroller" + Keys.ENTER);


        // 3. 2. Sıradaki ürüne tıklayacağız.
        WebElement ikinciUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        ikinciUrun.click();
// 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
        WebElement urunFiyati = driver.findElement(By.id("priceblock_ourprice"));
        System.out.println(urunFiyati.getText());

        WebElement ortalamaPuan = driver.findElement(By.id("a-popover-content-4"));
        System.out.println("Ortalama: "+ortalamaPuan.getText());
        Actions actions =new Actions(driver);
        actions.moveToElement(ortalamaPuan).perform();
        System.out.println(driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']")).getText());




    }

}

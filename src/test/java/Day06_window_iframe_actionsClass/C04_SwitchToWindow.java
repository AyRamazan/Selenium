package Day06_window_iframe_actionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.util.Set;

public class C04_SwitchToWindow extends TestBase {

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.get("https://the-internet.herokuapp.com/windows");

        //driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement ilkSayfaYaziElementi = driver.findElement(By.tagName("h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi = ilkSayfaYaziElementi.getText();
        Assert.assertEquals(expectedYazi, actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        bekle(2);

        String ilkSayfaWHD = driver.getWindowHandle();

        // Click Here butonuna basin
        driver.findElement(By.linkText("Click Here")).click();

        // Acilan yeni pencerenin sayfa baslıgının (title) "New Window " oldugunu dogrulayin

          /*
            Eger switchToNewWindow() method'u kullanilirsa driver yeni acilan sayfaya gecis yapar

            Ancak bu method kullanilmadan bir link tiklandiginda, yeni bir sayfa aciliyorsa
            driver yeni sayfaya gecis yapmaz

            bizim yeni acilan sayfanin windowHandle degerini bulup driver'i o sayfaya gecirmemiz GEREKLIDIR

            link'e click yaptigimizda acik 2 sayfamiz oluyor bunlardan bir tanesi windowHandle degerini
            kaydettigimiz ILK SAYFA digeri ise windowHandle degerini bilmedigimiz IKINCI SAYFA

            biz getWindowHandles() method'u ile bir SET olarak iki sayfanin windowHandle degerlerini alabiliyoruz

            O SET icerisinde ilkSayfaWHD'ine esit olmayan String'i ikinciSayfaWHD olarak atayabiliriz
         */

        Set<String> tumSayfalarWHD = driver.getWindowHandles();

        String ikinciSayfaWHD = "";

        for (String each : tumSayfalarWHD
        ) {
            if (!each.equals(ilkSayfaWHD)) {
                ikinciSayfaWHD = each;

            }
        }

        driver.switchTo().window(ikinciSayfaWHD);
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();
        bekle(2);
        Assert.assertEquals(expectedTitle, actualTitle);


        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String ikinciSayfaYazi = driver.findElement(By.tagName("h3")).getText();
        expectedYazi = "New Window";
        Assert.assertEquals(expectedYazi, ikinciSayfaYazi);

        //Bir önceki pencereye geri döndükten sonra
        driver.switchTo().window(ilkSayfaWHD);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        bekle(3);

    }
}


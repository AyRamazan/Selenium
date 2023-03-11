package Day06_window_iframe_actionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

public class C03_SwitchWindows extends TestBase {

    @Test
    public void test01(){
        //amazon anasayfaya gidip arama kutusunun erişilebilir olduğunu test edin
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.get("https://www.amazon.com");


        //driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        String amazonWindowHandleDegeri= driver.getWindowHandle();
        bekle(2);

        //yeni bir tab olarak wisequarter.com'a gidin

        /*
        once yeni bir tab olusturup driver'i driveri o sayfaya geçirmeliyiz (switch)
         */

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        //url'in wisequarter icerdiğini test edin

        String expectedIcerik= "wisequarter";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        String wiseWindowHandleDegeri= driver.getWindowHandle();

        //amazon'un acik olduğu tab'a geri dönün.


        /*
        Daha önce acilmis olan bir window'a gecis yapmak icin
        O sayfanin windowHandle degerine ihtiyacimiz vardır

        Testimiz böyle bir gorevi iceriyorsa
        o sayfada iken windowHandle degerini alip kayit yapmaliyiz

         */

        driver.switchTo().window(amazonWindowHandleDegeri);

        //Nutella icin arama yapin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //Sonuclarin Nutella icerdiğini test edin
        String actualsonucYazisi= driver
                .findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText();
        expectedIcerik="Nutella";
        Assert.assertTrue(actualsonucYazisi.contains(expectedIcerik));


        // yeni bir window olarak YouTube.com'a gidin
        driver.switchTo().newWindow(WindowType.TAB.WINDOW);
        driver.get("https://www.youtube.com");

        //Url'in youtube icerdiğini test edin
        expectedIcerik= "Youtube";
        actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        //wisequarter'in acik olduğu sayfaya dönün
        driver.switchTo().window(wiseWindowHandleDegeri);

        //Title'in WiseQuarter icerdiğini test edin
        expectedIcerik="WiseQuarter";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        bekle(3);

    }
}

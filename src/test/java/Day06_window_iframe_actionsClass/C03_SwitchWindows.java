package Day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_SwitchWindows extends TestBase {

    @Test
    public void test01(){
        //amazon anasayfaya gidip arama kutusunun erişilebilir olduğunu test edin
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());


        //yeni bir tab olarak wisequarter.com'a gidin
        //url'in wisequarter icerdiğini test edin
        /*
        once yeni bir tab olusturup driver'i o sayfaya gecirmeliyiz.(switch)
         */

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");
        //Assert.assertTrue();

        driver.get("https://wisequarter.com");

        //amazon'un acik olduğu tab'a geri dönün.
        //Nutella icin arama yapin
        //Sonuclarin Nutella icerdiğini test edin

        //yeni bir window olarak youtube.com'a gidin
        //Url'in youtube icerdiğini test edin

        //wisequarter'in acik olduğu sayfaya dönün
        //Title'in WiseQuarter icerdiğini test edin





    }
}

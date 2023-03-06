package Day01_SeleniumGiriş;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {

    public static void main(String[] args) {


        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle());
        //CDwindow-DEEE8055939071472F672F4FCC09780D
        //CDwindow-AC9CBD91340076CE90B4161759179547
        //getWindoqHandle selenium tarafindan her dirver sayfasi icin uretilen
        //unigue handle degerini döndürür.
        //getWindowHandels() ise test sirasinde birden fazla sayfa acilmissa
        //bir set olarak, tum sayfalarin window handle degerlerini döndürür.

        System.out.println(driver.getPageSource());

        //sayfa kodlari "2 hours weekly meeting with the team" iceriyor mu test edin
        String expectedIcerik= "2 hours weekly meeting with the team";
        String actualSayfaKodlari= driver.getPageSource();

        if (actualSayfaKodlari.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        driver.quit();
        // close() ve quit() ikisi de sayfa kapatmak icin kullanilir
        // close() sadece bir sayfa kapatirken
        // quit() test sirasinda acilan tum sayfalari kapatir


    }
}
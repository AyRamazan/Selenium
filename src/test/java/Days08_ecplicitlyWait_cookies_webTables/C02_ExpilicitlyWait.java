package Days08_ecplicitlyWait_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExpilicitlyWait {

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");


        //arama kutusu clicable oluncaya kadar bekleyin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));


        //Expilicitly wait icin
        // A -wait objesi olustur

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));

        // B- mümkünse webelementi locate et
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));


        //Nutella icin arama yapin



    }

}
    /*

    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // arama kutusu clickable oluncaya kadar bekleyin
        // explicitly wait icin
        //  A- wait objesi olustur
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));
        // B - mumkunse webelementi locate et
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        // C- wait objesini kullanarak istenen gorev icin bekle
        wait.until(ExpectedConditions.elementToBeClickable(aramaKutusu));
        // Nutella icin arama yapin
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        Thread.sleep(5000);
        driver.close();
    }
}

     */


package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06 {


    @BeforeClass
    public static void setUP(){
        System.out.println("Before Class");

    }

    @AfterClass
    public static void tearDown(){
        System.out.println("After Class");

    }




    @Test
    public void ahmet(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Ahmet");

    }

    @Test
    public void bekir(){
        System.out.println("Bekir");
    }
    @Test
    public void cengiz(){
        System.out.println("Cengiz");



    }
}

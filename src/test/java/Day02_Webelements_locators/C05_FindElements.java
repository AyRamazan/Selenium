package Day02_Webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver" , "drivers/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sayfasına gidin
        driver.get("https:/www.amazon.com");

        //arama kutusuna java yazip aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java");
        aramaKutusu.submit();

        //arama sonuçlarında çikan resimlerdeki yaziları yazdirin.

        List <WebElement> aramaSonuclariElementList= driver.findElements(By.className("sg-col-inner"));

        System.out.println(aramaSonuclariElementList.size());//70

        //Bu 70 elementi yazdiralim
        int elementNo=1;
        for (WebElement eachElement: aramaSonuclariElementList
             ) {
            System.out.println(elementNo + "---------" + eachElement.getText());
            elementNo++;

        }

        driver.close();

    }
}

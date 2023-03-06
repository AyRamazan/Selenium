package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01 {

    /*...Exercise1...
    Create a new class under Q1 create main method
    Set Path
    Create chrome driver
    Maximize the window
    Open google home page https://www.google.com/.
    On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
    Navigate forward to amazon
    Refresh the page
    Close/Quit the browser
    And last step : print "All Ok" on console
     */

    public static void main(String[] args) {

        //Set Path

        System.setProperty("Webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Selenium\\seleniumTeam108\\drivers\\chromedriver_win32.zip");
        //Yukarıdaki satırda sisteme driver'imizi tanıtıyoruz.
        //Driver'imizin yolunu da gösteriyoruz.

        //Create chrome driver

        WebDriver driver= new ChromeDriver(); //Bu adımda hangi tarayici da çalistiracagimizi belirliyoruz. Cross testingde ihtiyacimiz olacak

        //Maximize the window

        driver.manage().window().maximize();


        //  Open google home page https://www.google.com/.

        driver.get("https://www.google.com"); //Ilk etapta navigate mi yoksa yet mi nasıl karar veriyoruz.
               //Get methodu daha hızlı çalisir. Navigate ise daha çok bagımlı senaryolarda tercih edilir.

        //On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google

        driver.navigate().to("https://www.amazon.com"); //Navigate ise daha cok bagimli senaryolarda tercih edilir.

        //Navigate back to google

        driver.navigate().back();

        //Navigate forword to amazon

        driver.navigate().forward();

        //Refresh the page

        driver.navigate().refresh();

        //Close/Quit the browser

        driver.quit(); //Close bulunan son sayfayı kapatırken quit tüm sayfaları/tüm sekmeleri kapatır.

        // And last step : print "All Ok" on console

        System.out.println("All OK");

    }
}

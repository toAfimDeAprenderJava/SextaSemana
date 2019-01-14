import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {


    protected WebDriver driver;
    protected WebDriverWait wait;

    public void getChrome(String url) {

        //Abrindo navegador
        //System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get(url);
    }

    public void login() {
        //insira abaixo seu "username" (funcional) e logo abaixo em "PasswordInternal" sua senha
        driver.findElement(By.id("username")).sendKeys("701033");
        driver.findElement(By.id("PasswordInternal")).sendKeys("T@cito170667xP");

        driver.findElement(By.id("Log_On1")).click();
    }
}
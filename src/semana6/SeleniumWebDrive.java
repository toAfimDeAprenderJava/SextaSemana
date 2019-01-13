package semana6;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
*   Escreva 10 metodos do Selenium que façam ações na pagina web da Cognizant
 *  Entre esses métodos tenha pelo menos um método para
 *  -Procurar um elemento por id
 *  -Clicar em um elemento da pagina html
 *  -Usar um elemento WebDriver
 *  -Escrever em um campo de texto
 *
 *  Com esses metodos que você criou, tente abrir a sua timesheet
 */
 public class SeleniumWebDrive{

	 //Declaracao do driver e do tempo de espera para algumas paginas.
	 public WebDriver driver;
	 public WebDriverWait wait;    
	 
	 //Metodo para abrir o Chrome no site da Cognizant
     public void setUpDriver () {
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	
    	driver = new ChromeDriver();
    	
    	wait = new WebDriverWait(driver, 25);
    	
    	String url = "https://be.cognizant.com/";
    	
    	driver.get(url);
    	
    	Evidencia.ScreenShot(driver);
    }
    
     //Metodo para inserir o login nas paginas necessarias (Microsoft, site da Cog e timesheet)
    public void Login (String user , String pass, String associate) {
    	
    	WebElement loginWE = driver.findElement(By.id("i0116"));
    	
    	//insere os dados no campo
    	loginWE.sendKeys(user);
    	
    	WebElement nextButtonWE = driver.findElement(By.id("idSIButton9"));
    	
    	//clica no botao
    	nextButtonWE.click();
    	
    	LoginCog(associate, pass, "userNameInput", "passwordInput");
    	
    	WebElement signInWE = driver.findElement(By.id("idBtn_Back"));
    	
    	Evidencia.ScreenShot(driver);
    	
    	//clica no botao
    	signInWE.click();
    }
    
    //Metodo para abrir o timesheet
    public void TimeSheet (String associate, String pass) {
    	
    	try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	Evidencia.ScreenShot(driver);
    	
    	WebElement timeSheetWE = driver.findElement(By.xpath("//a[@class='apps-and-tools-slider__item ng-scope'][1]"));
    	
    	timeSheetWE.click();
    	
    	SwitchTab();
    	
    	Evidencia.ScreenShot(driver);
    	
    	LoginCog(associate, pass, "username", "PasswordInternal");
    }
    
    //Metodo para login nos sites da Cog
    public void LoginCog (String associate, String pass, String idUser, String idPass) {
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUser)));
   	 
    	WebElement associateWE = driver.findElement(By.id(idUser));
    	
    	//Envia dados para o campo
    	associateWE.sendKeys(associate);
    	
    	WebElement passWE = driver.findElement(By.id(idPass));
    	
    	passWE.sendKeys(pass);
    	
    	WebElement logOnWE = driver.findElement(By.id("Log_On1"));
    	
    	Evidencia.ScreenShot(driver);
    	
    	//clilca no botao
    	logOnWE.click();
    	
    }
    
    //Metodo para trocar de aba, quando existe mais de uma no mesmo navegador
    public void SwitchTab () {
    	
    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    	
    	for (String s: tabs2) {
    		
    		if (!driver.getWindowHandle().equals(s)) {
    			driver.switchTo().window(s);
			}
    	}
    	
    }
}
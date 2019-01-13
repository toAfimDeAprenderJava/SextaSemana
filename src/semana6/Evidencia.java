package semana6;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
*	Navegue pelo site da Cognizant(ou por algum da sua escolhe ) e a cada troca de pagina ou preenchimento de dados
 * tire uma foto e grave ela com o nome "Nome da pagina + Hora da foto"
 * dicas:  
 *	- Para pegar o horario tente usar a biblioteca da classe Calendar
 *	- Para fazer os prints tente usar a biblioteca da classe Robot
 *	- Para facilitar a navegação, use um site que seja simples e sem muitas coisas para carregar.
 *
 * Sites:
 *	https://docs.oracle.com/javase/7/docs/api/java/awt/Robot.html
 *	https://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401
 *
 * Se você quiser colocar esse arquivos em um documento procure o framework do apache poi
 */

public class Evidencia {
	public static void ScreenShot (WebDriver driver) {
		   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		   String path = GetDesktopPath() + "\\" + GetDateString() + ".jpg";
		   
		   System.out.println(path);
		   
		   try {
		       FileUtils.copyFile(scrFile, new File(path));
		   } catch (IOException e) {
		       e.printStackTrace();
		   }
		}
	
	public static String GetDesktopPath () {
		
		
		File home = FileSystemView.getFileSystemView().getHomeDirectory();
		
		return home.getAbsolutePath();
		
	}
	
	public static String GetDateString () {
		
		 Calendar c = Calendar.getInstance();
		 return c.getTime().toString().replace(":", ";");
		
	}
		
		
}

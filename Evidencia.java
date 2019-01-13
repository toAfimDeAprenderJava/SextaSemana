package semana6;

import java.util.Calendar;

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
	public static void ScreenShot () {
		   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   
		   try {
		       FileUtils.copyFile(scrFile, new File(GetDesktopPath() + GetDateString()));
		   } catch (IOException e) {
		       e.printStackTrace();
		   }
		}
	
	public static String GetDesktopPath () {
		
		FileSystemView.getFileSystemView().getHomeDirectory();
		
		return home.getAbsolutePath();
		
	}
	
	public static String GetDateString () {
		
		 Calendar c = Calendar.getInstance();
		 return c.getTime().toString();
		
	}
		
		
}

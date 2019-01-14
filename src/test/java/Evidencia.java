import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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

		/*Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image,"png", file);*/
		public static String dataHoraArquivo(){
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
		}

		public static void printScreen(WebDriver driver, String arquivo) {


			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try{
				FileUtils.copyFile(screenshot, new File(arquivo));

			}catch (Exception e){
				System.out.println("Houve um problema ao copiar o arquivo para a pasta " + e.getMessage());
			}
		}
}

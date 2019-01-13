package semana6;

import semana6.SeleniumWebDrive;
import semana6.Evidencia;

public class Main {

	public static void main( String args[]) {
		
		//Instanciando classe 
		SeleniumWebDrive selenium = new SeleniumWebDrive();
		
		//Executando metodos da classe instanciada
		selenium.setUpDriver();
		
		selenium.Login("bianca.lopes@cognizant.com", "Bia@2018", "718000"); // colocar email cog, senha e ID
		
		Evidencia.ScreenShot(selenium.driver);
		
		selenium.TimeSheet("718000", "Bia@2018"); // colocar id e senha
		
		selenium.driver.close();
		
	}
	
}

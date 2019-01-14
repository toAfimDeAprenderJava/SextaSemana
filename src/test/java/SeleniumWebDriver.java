import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.time.LocalDate;

public class SeleniumWebDriver extends TimeSheet {

    LocalDate actualDate = LocalDate.now();

    @Rule
    public TestName test = new TestName();

    String screenShotArquivo = "C:\\Users\\tacit\\Documents\\"+Evidencia.dataHoraArquivo() + test.getMethodName() +
            ".png";
    @Before
    public void tearUp() {
        getChrome("https://compass.esa.cognizant.com/psc/ESA89PRD/EMPLOYEE/ERP/c/ADMINISTER_EXPENSE_FUNCTIONS.CTS_TS_LAND_COMP.GBL?Action=A&local_date="+actualDate);
        Evidencia.printScreen(driver, screenShotArquivo);
    }
    @Test
    public void submitTimesheet() {
        String screenShotArquivo = "C:\\Users\\tacit\\Documents\\"+Evidencia.dataHoraArquivo() + test.getMethodName() +
                ".png";
        login();
        Evidencia.printScreen(driver, screenShotArquivo);
        apontarHoras();
        Evidencia.printScreen(driver, screenShotArquivo);
        //assertTrue("erro ao verificar timesheet", returnBoolean("Timesheet Summary"));
    }
}

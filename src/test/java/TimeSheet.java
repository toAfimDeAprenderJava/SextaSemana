import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class TimeSheet extends Browser {

    public void apontarHoras() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("CTS_TS_LAND_PER_DESCR30$1")).click();

        driver.switchTo().frame("ptifrmtgtframe");

        //Insira aqui o PID, caso esteja como default, comente a linha abaixo
        //driver.findElement(By.id("PROJECT_CODE$0")).sendKeys("");
        // Campo Activity
        //driver.findElement(By.id("CTS_EX_ACT_VW_DESCR$prompt$img$0")).click();

        //driver.findElement(By.id("CTS_EX_ACT_VW_DESCR$0")).sendKeys("Integration & System Test");
        driver.findElement(By.id("CTS_EX_ACT_VW_DESCR$0")).sendKeys("Training");


        // Insira as horas dos dias aqui
        // \/
        // Domingo
        driver.findElement(By.id("TIME1$0")).sendKeys("");
        // Sábado
        driver.findElement(By.id("TIME2$0")).sendKeys("");
        // Segunda-feira
        driver.findElement(By.id("TIME3$0")).sendKeys("8");
        // Terça-feira
        driver.findElement(By.id("TIME4$0")).sendKeys("8");
        // Quarta-feira
        driver.findElement(By.id("TIME5$0")).sendKeys("8");
        // Quinta-feira
        driver.findElement(By.id("TIME6$0")).sendKeys("8");
        // Sexta-feira
        driver.findElement(By.id("TIME7$0")).sendKeys("8");

        // Submit Timesheet
        driver.findElement(By.id("EX_TIME_HDR_WRK_PB_SUBMIT")).click();
        // Confirm Submit Timesheet
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().frame("ptModFrame_0");
        driver.findElement(By.id("#ICSave")).click();


    }

}
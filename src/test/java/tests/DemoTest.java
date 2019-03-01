package tests;

import Environment.EnvironmentManager;
import Environment.RunEnvironment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DemoTest {


    @BeforeEach
    public void startBrowser() {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void demo() {



        int TIMEOUT_IN_SECONDS = 2;

        WebDriver browser = RunEnvironment.getWebDriver();


        //String fieldQuery = "Baranauskas";
        // int num;
        //String laikinas;
        //WebElement searchField = browser.findElement(By.id("sb_form_q"));
        //searchField.sendKeys(fieldQuery);
        //searchField.sendKeys(Keys.ENTER);





        browser.get("https://www.bing.com/");

        String fieldQuery = "Baranauskas";
        int num;
        String laikinas;
        WebElement searchField = browser.findElement(By.id("sb_form_q"));
        searchField.sendKeys(fieldQuery);
        searchField.sendKeys(Keys.ENTER);





        waitForElementByClassName(browser,"sb_count" ,TIMEOUT_IN_SECONDS);


        WebElement searchCount = browser.findElement(By.className("sb_count"));
        laikinas = searchCount.getText();


        String laikinas2=laikinas.replaceAll("[^0-9]", "");
        num=Integer.parseInt(laikinas2);

        if(num >50000)
        {
            System.out.println("Labai populiarus");
        }
        else {
            System.out.println("Nepopuliarus");
        }
    }
    private static void waitForElementById(WebDriver browser , String id , int TIMEOUT_IN_SECONDS)
    {
        WebDriverWait wait = new WebDriverWait(browser, TIMEOUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

    }
    private static void waitForElementByClassName(WebDriver browser , String className, int TIMEOUT_IN_SECONDS ){

        WebDriverWait wait = new WebDriverWait(browser, TIMEOUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));

    }


    @AfterEach
    public void tearDown() {
        try {
                Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        EnvironmentManager.shutDownDriver();
    }
}

















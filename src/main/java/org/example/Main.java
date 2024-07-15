package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    WebDriver driver;

    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/siddu/IdeaProjects/Bankingproject/src/main/resources/chromedriver");
        driver= new ChromeDriver();
        driver.get("https://demo.guru99.com/v3/index.php");
    }

    public static void main(String[] args) {
        Main obj=new Main();
        obj.launchBrowser();
    }
}


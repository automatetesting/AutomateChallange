package se.ff.cc.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValtechPage {
    WebDriver driver;

    String filepath = "testdata\\userlogindata.txt";

    private By recentBlogs = By.xpath(".//*[@id='container']/div[2]/div[3]/section/div/div[1]/header/h2");
    private By about = By.className("navigation__menu__item");
    private By service = By.className("navigation__menu__item");
    private By work = By.className("navigation__menu__item");


    public ValtechPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://www.valtech.co.uk/");
    }

    public void AssertBlog() {
        Assert.assertTrue(driver.findElement(recentBlogs).getText().matches("recent blogs"));
    }

    public void ClickAbout() {


        WebElement navigation = driver.findElement((about));
        navigation.findElements(By.tagName("li"));
        /// code to iterate through the elements and select the relevant element

    }

    public void ClickServices() {
        WebElement navigation = driver.findElement((service));
        navigation.findElements(By.tagName("li"));
        /// code to iterate through the elements and select the relevant element

    }

    public void ClickWork() {
        WebElement navigation = driver.findElement((work));
        navigation.findElements(By.tagName("li"));
        /// code to iterate through the elements and select the relevant element

    }
}


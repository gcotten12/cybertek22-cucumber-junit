package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {

    public WikiSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "searchInput")
    public WebElement searchBox;

    @FindBy(id = "searchButton")
    public WebElement searchButton;

    @FindBy(xpath = "//h1")
    public WebElement pageHeader;

    @FindBy(xpath = "//div[@class='fn']")
    public WebElement steveJobsImageHeader;

}

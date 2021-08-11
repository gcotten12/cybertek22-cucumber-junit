package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3SchoolsPage {

    public W3SchoolsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void switch_to_iframe(String id) {
        Driver.getDriver().switchTo().frame(id);
    }

    @FindBy(xpath = "//p[.='Double-click me to change my text color.']")
    public WebElement doubleCLickText;

    public boolean verifyTextStyle(WebElement element, String style) {

        if(element.getAttribute("style").contains(style)) {
            return true;
        }

        return false;
    }

}

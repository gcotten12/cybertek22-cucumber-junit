package com.cybertek.step_definitions;

import com.cybertek.pages.W3SchoolsPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class W3Schools_StepDefinitions {

    W3SchoolsPage w3SchoolsPage = new W3SchoolsPage();

    @Given("user is on tryit editor page")
    public void user_is_on_tryit_editor_page(){
    String url = ConfigurationReader.getProperty("w3schoolsUrl");
    Driver.getDriver().get(url);
    }

    @And("user switches to {string}")
    public void user_switches_to(String string) {
        BrowserUtils.sleep(3);
        w3SchoolsPage.switch_to_iframe(string);
    }

    @When("user double clicks on double click text")
    public void user_double_clicks_on_double_click_text() {

        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(w3SchoolsPage.doubleCLickText).perform();
        BrowserUtils.sleep(3);

    }

    @Then("text's style attribute value should contain {string}")
    public void text_s_style_attribute_value_should_contain(String string) {

        Assert.assertTrue(w3SchoolsPage.verifyTextStyle(w3SchoolsPage.doubleCLickText, string));

    }

}

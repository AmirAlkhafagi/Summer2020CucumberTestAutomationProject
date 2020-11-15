package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCalendarEventPage extends BasePage {

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    private WebElement createCalendarEventBtn;

    @FindBy(name = "oro_calendar_event_form[title]")
    private WebElement titleInputBox;

    @FindBy(id = "tinymce")
    private WebElement descriptionInputBox;

    public void enterTitle(String title){
        BrowserUtils.enterText(titleInputBox, title);
    }

    public void enterDescription(String description){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        //exit from all frames
        Driver.getDriver().switchTo().defaultContent();

        //switch to frame
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        descriptionInputBox.sendKeys(description);

        //exit the frame
        Driver.getDriver().switchTo().defaultContent();

    }

    public void clickOnCreateCalendarEventBtn(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEventBtn)).click();

        System.out.println("Clicking createCalendarEventBtn");
    }

    public String getDataFromGeneralInfo(String parameterName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        String xpath = "//label[text()='" + parameterName + "']/../div/div";
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getText().trim();
    }



}

package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;


public class EventHandler implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {

    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Open url: " + s);
    }


    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Search for element: " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Element found successfully");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        if(webElement.getText().equals("")) {
            System.out.println("Click on element: " + "<" + webElement.getTagName() + " class=" + webElement.getAttribute("class") + ">");
        }
        else {
            System.out.println("Click on element: " + webElement.getText());
        }
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Element successfully clicked");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
       System.out.println("Fill input " + webElement.getAttribute("id") + " with value " + Arrays.toString(charSequences));
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Value successfully filled");
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        throwable.getMessage();
    }
}

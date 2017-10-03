package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By loginButton = By.name("submitLogin");
    private By catalogTab = By.id("subtab-AdminCatalog");
    private By categoryTab = By.id("subtab-AdminCategories");
    private By addCategoryLabel = By.className("process-icon-new");
    private By categoryNameField = By.id("name_1");
    private By succesfulCreationMessage = By.cssSelector(".alert.alert-success");
    private By saveCategoryButton = By.id("category_form_submit_btn");
    private By ascendingorderNameFilter = By.xpath("//span[contains(text(), 'Имя')]//i[@class='icon-caret-up']");
    private By recordCreatedCategory = By.xpath("//td[contains(text(), 'Man')]");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void open(){
        driver.navigate().to(Properties.getBaseAdminUrl());
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */


    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        try {
            driver.findElement(emailField).sendKeys(login);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(loginButton).click();
        }
        catch (UnsupportedOperationException exc) {
            throw new UnsupportedOperationException("Authentication failed");
        }

    }

    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) throws InterruptedException {
        // TODO implement logic for new category creation

        try {
            // finding and clicking catalogTab
            WebElement catalogElement = driver.findElement(catalogTab);
            Actions actions = new Actions(driver);
            actions.moveToElement(catalogElement).build().perform();
            waitForContentLoad(categoryTab);
            catalogElement.findElement(categoryTab).click();
            waitForContentLoad(addCategoryLabel);

            // adding and saving new category
            driver.findElement(addCategoryLabel).click();
            waitForContentLoad(categoryNameField);
            driver.findElement(categoryNameField).sendKeys(categoryName);
            driver.findElement(saveCategoryButton).click();
            checkAddingCategory(); //checking correctly displayed message after adding category

            ascendingOrderFilter(); //filter categories in ascending order
        }
        catch (UnsupportedOperationException exc) {
            throw new UnsupportedOperationException("Fail during creation category");
            //   throw new UnsupportedOperationException();
        }
    }
    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad(By element) {
        // TODO implement generic method to wait until page content is loaded
        // wait.until(...);
        // ...
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean checkAddingCategory(){
        String message = driver.findElement(succesfulCreationMessage).getText();
        if(!message.contains("Создано")) {
            System.out.println("Fail during adding category");
        }
        return true;
    }

    public void ascendingOrderFilter() {
        driver.findElement(ascendingorderNameFilter).click();
    }

    public boolean checkRecordNewlyCreatedCategory(String categoryName) {

        String record = driver.findElement(recordCreatedCategory).getText();
        if (!record.contains(categoryName)) {
            System.out.println("Fail during finding category in the table");
        }
        return true;
    }
}

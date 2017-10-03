package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import myprojects.automation.assignment3.GeneralActions;

public class CreateCategoryTest extends BaseScript {

    private static String emailText = "webinar.test@gmail.com";
    private static String passwordText = "Xcg7299bnSmMuRLp9ITw";
    private static String categoryName = "Man";

    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        EventFiringWebDriver driver = getConfiguredDriver();
        GeneralActions generalAction = new GeneralActions(driver);
        // ...
        // login
        generalAction.open();
        generalAction.login(emailText, passwordText );

        // create category
        generalAction.createCategory(categoryName);

        // check that new category appears in Categories table
        generalAction.checkRecordNewlyCreatedCategory(categoryName);

        // finish script
        quitDriver(driver);
    }
}

package androidAutomation.steps;

import androidAutomation.steps.serenity.EndUserSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DefinitionSteps {

    @Steps
    EndUserSteps steps;

    @Given("^wait while app would be loaded$")
    public void waitWhileAppWouldBeLoaded() throws Throwable {
        steps.getDimensions();
//        steps.getAppTopYCoordinates();
//        steps.waitWhileAppWouldBeLoaded();
    }

    @When("^click on the Login button$")
    public void clickOnTheLoginButton() throws Throwable {
        steps.clickOnTheLoginButton();
    }

    @And("^wait for loading main page$")
    public void waitForLoadingMainPage() throws Throwable {
        steps.waitForLoadingMainPage();
    }

    @And("^wait for loading adv$")
    public void waitForLoadingAdv() throws Throwable {
        steps.refreshTheMainPage();
        steps.waitForLoadingAdv();
        steps.getAdvTopYCoordinate();
    }

    @When("^set screen orientation as \"([^\"]*)\"$")
    public void setScreenOrientationAsValue(String arg0) throws Throwable {
        steps.setScreenOrientationAsValue(arg0);
        steps.getDimensions();
    }

    @When("^click on the title of the \"([^\"]*)\" product$")
    public void clickOnTheTitleOfTheProduct(String arg0) throws Throwable {
        steps.rememberTitleOfTheSomeProduct(arg0);
        steps.clickOnTheTitleOfTheSomeProduct(arg0);
        steps.waitABit(500);
    }

    @Then("^make sure that you are on the page with correct dish$")
    public void makeSureThatYouAreOnThePageWithCorrectDish() throws Throwable {
        steps.makeSureThatYouAreOnThePageWithCorrectDish();
    }

    @When("^click on the Search button in the header$")
    public void clickOnTheSearchButtonInTheHeader() throws Throwable {
        steps.clickOnTheSearchButtonInTheHeader();
    }

    @When("^type \"([^\"]*)\" to the Search field$")
    public void typeWordToTheSearchField(String arg0) throws Throwable {
        steps.clearSearchField();
        steps.typeWordToTheSearchField(arg0);
    }

    @When("^click on the Filters button$")
    public void clickOnTheFiltersButton() throws Throwable {
        steps.clickOnTheFiltersButton();
    }

    @When("^add \"([^\"]*)\" to the Ingredients$")
    public void addItemToTheIngredients(String arg0) throws Throwable {
        steps.clearIngredientsField();
        steps.typeWordToTheIngredientsField(arg0);
        steps.clickOnAddIngredientButton();
    }

    @When("^remove \"([^\"]*)\" from the Ingredients$")
    public void removeItemFromTheIngredients(String arg0) throws Throwable {
        steps.clearIngredientsField();
        steps.typeWordToTheIngredientsField(arg0);
        steps.clickOnRemoveIngredientButton();
    }

    @When("^choose \"([^\"]*)\" in the By Dietary Needs menu$")
    public void chooseOptionInTheByDietaryNeedsMenu(String arg0) throws Throwable {
        steps.chooseOptionInTheByDietaryNeedsMenu(arg0);
    }

    @When("^refuse \"([^\"]*)\" in the By Dietary Needs menu$")
    public void refuseOptionInTheByDietaryNeedsMenu(String arg0) throws Throwable {
        steps.refuseOptionInTheByDietaryNeedsMenu(arg0);
    }

    @When("^set Ready In option as \"([^\"]*)\"$")
    public void setReadyInOptionAsValue(String arg0) throws Throwable {
        steps.setReadyInOptionAsValue(arg0);
    }

    @When("^click on the Search button on the Search page$")
    public void clickOnTheSearchButtonOnTheSearchPage() throws Throwable {
        steps.clickOnTheSearchButtonOnTheSearchPage();
    }

    @Then("^check that in search result page filters label contains all necessary options$")
    public void checkThatInSearchResultPageFiltersLabelContainsAllNecessaryOptions() throws Throwable {
        steps.waitForLoadingMainPage();
        steps.checkThatInSearchResultPageFiltersLabelContainsAllNecessaryOptions();
    }

    @Then("^check that the \"([^\"]*)\" recipe exists on the result page$")
    public void checkThatTheTitleRecipeExistsOnTheResultPage(String arg0) throws Throwable {
        steps.checkThatTheTitleRecipeExistsOnTheResultPage(arg0);
    }

    @When("^open menu by swiping$")
    public void openMenuBySwiping() throws Throwable {
        steps.openMenuBySwiping();
    }

    @When("^click on the Sign in button in the menu$")
    public void clickOnTheSignInButtonInTheMenu() throws Throwable {
        steps.clickOnTheSignInButtonInTheMenu();
    }

    @When("^type \"([^\"]*)\" to the email field$")
    public void typeEmailToTheEmailField(String arg0) throws Throwable {
        steps.clearEmailField();
        steps.typeEmailToTheEmailField(arg0);
    }

    @When("^type \"([^\"]*)\" to the password field$")
    public void typeToThePasswordField(String arg0) throws Throwable {
        steps.clearPasswordField();
        steps.typePasswordToThePasswordField(arg0);
    }

    @When("^click on the Sign in button in the Sign in menu$")
    public void clickOnTheSignInButtonInTheSignInMenu() throws Throwable {
        steps.clickOnTheSignInButtonInTheSignInMenu();
    }

    @Then("^check that you are logged in as \"([^\"]*)\"$")
    public void checkThatYouAreLoggedInAsUser(String arg0) throws Throwable {
        steps.waitForLoadingMainPage();
        steps.openMenuBySwiping();
        steps.checkThatYouAreLoggedInAsUser(arg0);
    }

    @When("^click on the Device \"([^\"]*)\" button$")
    public void clickOnTheDeviceNameButton(String arg0) throws Throwable {
        steps.clickOnTheDeviceNameButton(arg0);
    }

    @Then("^check that the user is on the Main page$")
    public void checkThatTheUserIsOnTheMainPage() throws Throwable {
        steps.checkThatThatToolbarIsEnabled();
        steps.checkThatOpenNavigationDrawerIsEnabled();
    }

    @Then("^check that the user is on the Home screen$")
    public void checkThatTheUserIsOnTheHomeScreen() throws Throwable {
        steps.checkThatTheUserIsOnTheHomeScreen();
    }

    @When("^open notifications$")
    public void openNotifications() throws Throwable {
        steps.openNotifications();
    }

    @When("^click on the header$")
    public void clickOnTheHeader() throws Throwable {
        steps.clickOnTheHeader();
    }

    @When("^turn on Don't disturb option \"([^\"]*)\" for \"([^\"]*)\"$")
    public void turnOnDonTDisturbOptionFor(String arg0, String arg1) throws Throwable {
        steps.clickOnTheOptionInTheNotifications("Do not disturb");
        steps.setDontDisturbValueAs(arg1);
        steps.setDontDisturbValueForTime(arg0);
    }

    @Then("^check that necessary option in Notifications is turned on$")
    public void checkThatNecessaryOptionInNotificationsIsTurnedOn() throws Throwable {
        steps.checkThatNecessaryOptionInNotificationsIsTurnedOn();
    }

    @Then("^check that recent apps are opened")
    public void checkThatRecentAppsAreOpened() throws Throwable {
        steps.checkThatRecentAppsAreOpened();
    }

    @When("^drop last application from recent apps$")
    public void dropLastApplicationFromRecentApps() throws Throwable {
        steps.dropLastApplicationFromRecentApps();
    }

    @Then("^check that that dropped app is no longer exists in recent apps$")
    public void checkThatThatDroppedAppIsNoLongerExistsInRecentApps() throws Throwable {
        steps.checkThatThatDroppedAppIsNoLongerExistsInRecentApps();
    }

    @When("^remember titles of products on the Main page$")
    public void rememberTitlesOfProductsOnTheMainPage() throws Throwable {
        steps.rememberTitlesOfProductsOnTheMainPage();
    }

    @When("^open last recent app$")
    public void openLastRecentApp() throws Throwable {
        steps.openLastRecentApp();
    }

    @Then("^check that list of products on the Main page is the same as you remembered$")
    public void checkThatListOfProductsOnTheMainPageIsTheSameAsYouRemembered() throws Throwable {
        steps.checkThatListOfProductsOnTheMainPageIsTheSameAsYouRemembered();
    }

    @When("^turn \"([^\"]*)\" wi-fi$")
    public void turnWiFi(String arg0) throws Throwable {
        steps.turnWiFi(arg0);
    }

    @Then("^check that warning message about your internet connection is appeared$")
    public void checkThatWarningMessageAboutYourInternetConnectionIsAppeared() throws Throwable {
        steps.checkThatWarningMessageAboutYourInternetConnectionIsAppeared();
    }

    @When("^print Device settings$")
    public void printDeviceSettings() throws Throwable {
        steps.printDeviceSettings();
    }

    @When("^open notifications on Samsung S5$")
    public void openNotificationsOnSamsungS5() throws Throwable {
        steps.openNotificationsOnSamsungS5();
    }

    @When("^open all settings in notifications on Samsung S5$")
    public void openAllSettingsInNotificationsOnSamsungS5() throws Throwable {
        steps.openAllSettingsInNotificationsOnSamsungS5();
    }

    @When("^turn \"([^\"]*)\" Don't disturb option on Samsung S5$")
    public void turnDonTDisturbOptionOnSamsungS5(String arg0) throws Throwable {
        steps.turnDonTDisturbOptionOnSamsungS5(arg0);
    }

    @Then("^check that necessary option in Notifications is turned on on Samsung S5$")
    public void checkThatNecessaryOptionInNotificationsIsTurnedOnOnSamsungS5() throws Throwable {
        steps.checkThatNecessaryOptionInNotificationsIsTurnedOnOnSamsungS5();
    }

    @Then("^check that that dropped app is no longer exists in recent apps on Samsung S5$")
    public void checkThatThatDroppedAppIsNoLongerExistsInRecentAppsOnSamsungS5() throws Throwable {
        steps.checkThatThatDroppedAppIsNoLongerExistsInRecentAppsOnSamsungS5();
    }

    @When("^turn \"([^\"]*)\" wi-fi on Samsung S5$")
    public void turnWiFiOnSamsungS5(String arg0) throws Throwable {
        steps.turnWiFiOnSamsungS5(arg0);
    }

    @When("^wait while product details page would be loaded$")
    public void waitWhileProductDetailsPageWouldBeLoaded() throws Throwable {
        steps.waitWhileProductDetailsPageWouldBeLoaded();
    }

    @And("^click on Close button on the warning message$")
    public void clickOnCloseButtonOnTheWarningMessage() throws Throwable {
        steps.clickOnCloseButtonOnTheWarningMessage();
    }

    @When("^turn off Don't disturb option$")
    public void turnOffDonTDisturbOption() throws Throwable {
        steps.turnOffDonTDisturbOption();
    }

    @When("^click on the Phone button$")
    public void clickOnThePhoneButton() throws Throwable {
        steps.clickOnThePhoneButton();
    }
}

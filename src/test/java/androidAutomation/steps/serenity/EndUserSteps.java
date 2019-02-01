package androidAutomation.steps.serenity;

import androidAutomation.MyAndroidDriver;
import androidAutomation.pages.AllRecipesPage;
import androidAutomation.pages.AndroidPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import static androidAutomation.MyAndroidDriver.*;


public class EndUserSteps extends ScenarioSteps {

    AllRecipesPage allRecipesPage;
    AndroidPage androidPage;

    @Step
    public void waitWhileAppWouldBeLoaded() throws Exception {
        allRecipesPage.waitWhileAppWouldBeLoaded();
    }

    @Step
    public void getDimensions() throws Exception {
        MyAndroidDriver.getDimensions();
        System.out.println("Screen dimensions are: " + screenDimensions);
    }

    @Step
    public void getAppTopYCoordinates() throws Exception {
        MyAndroidDriver.getAppTopYCoordinate();
        System.out.println("App Top Y coordinate: " + appTopYCoordinate);
    }

    @Step
    public void clickOnTheGotItButton() throws Exception {
        allRecipesPage.clickOnTheGotItButton();
    }

    @Step
    public void waitForLoadingMainPage() throws Exception {
        allRecipesPage.waitForLoadingMainPage();
    }

    @Step
    public void refreshTheMainPage() throws Exception {
        allRecipesPage.refreshTheMainPage();
    }

    @Step
    public void waitForLoadingAdv() throws Exception {
        allRecipesPage.waitForLoadingAdv();
    }

    @Step
    public void getAdvTopYCoordinate() throws Exception {
        waitABit(500);
        MyAndroidDriver.getAdvTopYCoordinate();
        System.out.println("Adv Top Y coordinate is: " + advTopYCoordinate);
    }

    @Step
    public void setScreenOrientationAsValue(String arg0) {
        androidPage.setScreenOrientationAsValue(arg0);
    }

    @Step
    public void rememberTitleOfTheSomeProduct(String arg0) {
        Serenity.getCurrentSession().put("TitleOfTheCurrentProduct", arg0);
        System.out.println("Putted: " + Serenity.getCurrentSession().get("TitleOfTheCurrentProduct"));
    }

    @Step
    public void clickOnTheTitleOfTheSomeProduct(String arg0) throws Exception {
        allRecipesPage.clickOnTheTitleOfTheSomeProduct(arg0);
    }

    @Step
    public void makeSureThatYouAreOnThePageWithCorrectDish() throws Exception {
        Assert.assertTrue("Not corresponding page was opened.", ((String) Serenity.getCurrentSession().get("TitleOfTheCurrentProduct")).
                equalsIgnoreCase(allRecipesPage.getTextOfTheTitleOfProductOnProductDetailsPage()));
    }

    @Step
    public void clickOnTheSearchButtonInTheHeader() throws Exception {
        allRecipesPage.clickOnTheSearchButtonInTheHeader();
    }

    @Step
    public void clearSearchField() throws Exception {
        allRecipesPage.clearSearchField();
    }

    @Step
    public void typeWordToTheSearchField(String arg0) throws Exception {
        allRecipesPage.typeWordToTheSearchField(arg0);
    }

    @Step
    public void clickOnTheFiltersButton() throws Exception {
        allRecipesPage.clickOnTheFiltersButton();
    }

    @Step
    public void clearIngredientsField() throws Exception {
        allRecipesPage.clearIngredientsField();
    }

    @Step
    public void typeWordToTheIngredientsField(String arg0) throws Exception {
        allRecipesPage.typeWordToTheIngredientsField(arg0);
    }

    @Step
    public void clickOnAddIngredientButton() throws Exception {
        allRecipesPage.clickOnAddIngredientButton();
    }

    @Step
    public void clickOnRemoveIngredientButton() throws Exception {
        allRecipesPage.clickOnRemoveIngredientButton();
    }

    @Step
    public void chooseOptionInTheByDietaryNeedsMenu(String arg0) throws Exception {
        allRecipesPage.chooseOptionInTheByDietaryNeedsMenu(arg0);
    }

    @Step
    public void refuseOptionInTheByDietaryNeedsMenu(String arg0) throws Exception {
        allRecipesPage.refuseOptionInTheByDietaryNeedsMenu(arg0);
    }

    @Step
    public void setReadyInOptionAsValue(String arg0) throws Exception {
        allRecipesPage.setReadyInOptionAsValue(arg0);
    }

    @Step
    public void clickOnTheSearchButtonOnTheSearchPage() throws Exception {
        allRecipesPage.clickOnTheSearchButtonOnTheSearchPage();
    }

    @Step
    public void checkThatInSearchResultPageFiltersLabelContainsAllNecessaryOptions() throws Exception {
        Assert.assertTrue("Incorrect filters are selected on the results page.",
                allRecipesPage.checkThatInSearchResultPageFiltersLabelContainsAllNecessaryOptions());
    }

    @Step
    public void checkThatTheTitleRecipeExistsOnTheResultPage(String arg0) throws Exception {
        Assert.assertTrue("The recipe " + arg0 + " doesn't exists on the result page.",
                allRecipesPage.isTitleOfRecipeEnabled(arg0));
    }

    @Step
    public void openMenuBySwiping() throws Exception {
        allRecipesPage.openMenuBySwiping();
    }

    @Step
    public void clickOnTheSignInButtonInTheMenu() throws Exception {
        allRecipesPage.clickOnTheSignInButtonInTheMenu();
    }

    @Step
    public void clearEmailField() throws Exception {
        allRecipesPage.clearEmailField();
    }

    @Step
    public void typeEmailToTheEmailField(String arg0) throws Exception {
        allRecipesPage.typeEmailToTheEmailField(arg0);
    }

    @Step
    public void clearPasswordField() throws Exception {
        allRecipesPage.clearPasswordField();
    }

    @Step
    public void typePasswordToThePasswordField(String arg0) throws Exception {
        allRecipesPage.typePasswordToThePasswordField(arg0);
    }

    @Step
    public void clickOnTheSignInButtonInTheSignInMenu() throws Exception {
        allRecipesPage.clickOnTheSignInButtonInTheSignInMenu();
    }

    @Step
    public void checkThatYouAreLoggedInAsUser(String arg0) throws Exception {
        Assert.assertTrue("You are not logged in as " + arg0,
                allRecipesPage.getUserNameInMenu().equalsIgnoreCase(arg0));
    }

    @Step
    public void clickOnTheDeviceNameButton(String arg0) {
        androidPage.clickOnTheDeviceNameButton(arg0);
    }

    @Step
    public void checkThatThatToolbarIsEnabled() throws Exception {
        Assert.assertTrue("The toolbar isn't enabled.", allRecipesPage.checkThatToolbarIsEnabled());
    }

    @Step
    public void checkThatOpenNavigationDrawerIsEnabled() throws Exception {
        Assert.assertTrue("The open navigation drawer isn't enabled.", allRecipesPage.checkThatOpenNavigationDrawerIsEnabled());
    }

    @Step
    public void checkThatTheUserIsOnTheHomeScreen() throws Exception {
        Assert.assertTrue("The Apps button isn't enabled.", androidPage.checkThatAppsButtonIsEnabled());
    }

    @Step
    public void openNotifications() throws Exception {
        androidPage.openNotifications();
    }

    @Step
    public void clickOnTheHeader() throws Exception {
        androidPage.clickOnTheHeader();
    }

    @Step
    public void clickOnTheOptionInTheNotifications(String arg0) throws Exception {
        androidPage.clickOnTheOptionInTheNotifications(arg0);
    }

    @Step
    public void setDontDisturbValueAs(String arg0) throws Exception {
        androidPage.setDontDisturbValueAs(arg0);
    }

    @Step
    public void setDontDisturbValueForTime(String arg0) throws Exception {
        androidPage.setDontDisturbValueForTime(arg0);
    }

    @Step
    public void checkThatNecessaryOptionInNotificationsIsTurnedOn() throws Exception {
        Assert.assertTrue("Necessary option isn't turned on.", androidPage.checkThatNecessaryOptionInNotificationsIsTurnedOn());
    }

    @Step
    public void checkThatRecentAppsAreOpened() throws Exception {
        Assert.assertTrue("Recent Apps aren't loaded.", androidPage.checkThatRecentAppsAreEnabled());
    }

    @Step
    public void dropLastApplicationFromRecentApps() throws Exception {
        androidPage.dropLastApplicationFromRecentApps();
    }

    @Step
    public void checkThatThatDroppedAppIsNoLongerExistsInRecentApps() throws Exception {
        Assert.assertTrue("App " + Serenity.getCurrentSession().get("DroppedApp") + " isn't dropped from recent apps.",
                androidPage.isAppDroppedFromRecentApps());
    }

    @Step
    public void rememberTitlesOfProductsOnTheMainPage() throws Exception {
        allRecipesPage.rememberTitlesOfProductsOnTheMainPage();
    }

    @Step
    public void openLastRecentApp() throws Exception {
        androidPage.openLastRecentApp();
    }

    @Step
    public void checkThatListOfProductsOnTheMainPageIsTheSameAsYouRemembered() throws Exception {
        Assert.assertTrue("List of products isn't the same with previous.", allRecipesPage.checkThatListOfProductsOnThePageIsTheSameAsYouRemembered());
    }

    @Step
    public void turnWiFi(String arg0) throws Exception {
        androidPage.turnWiFi(arg0);
    }

    @Step
    public void checkThatWarningMessageAboutYourInternetConnectionIsAppeared() throws Exception {
        Assert.assertTrue("Not corresponding warning message is appeared.", allRecipesPage.checkThatWarningMessageAboutYourInternetConnectionIsAppeared());
    }

    @Step
    public void printDeviceSettings() throws Exception {
        androidPage.printDeviceSettings();
    }

    @Step
    public void openNotificationsOnSamsungS5() throws Exception {
        androidPage.openNotificationsOnSamsungS5();
    }

    @Step
    public void openAllSettingsInNotificationsOnSamsungS5() throws Exception {
        androidPage.openAllSettingsInNotificationsOnSamsungS5();
    }

    @Step
    public void turnDonTDisturbOptionOnSamsungS5(String arg0) throws Exception {
        androidPage.turnDonTDisturbOptionOnSamsungS5(arg0);
    }

    @Step
    public void checkThatNecessaryOptionInNotificationsIsTurnedOnOnSamsungS5() throws Exception {
        Assert.assertTrue("Necessary option isn't turned on.", androidPage.checkThatNecessaryOptionInNotificationsIsTurnedOnOnSamsungS5());
    }

    @Step
    public void checkThatThatDroppedAppIsNoLongerExistsInRecentAppsOnSamsungS5() throws Exception {
        Assert.assertTrue("App " + Serenity.getCurrentSession().get("DroppedApp") + " isn't dropped from recent apps.",
                androidPage.isAppDroppedFromRecentAppsOnSamsungS5());
    }

    @Step
    public void turnWiFiOnSamsungS5(String arg0) throws Exception {
        androidPage.turnWiFiOnSamsungS5(arg0);
    }

    @Step
    public void waitWhileProductDetailsPageWouldBeLoaded() throws Exception {
        allRecipesPage.waitWhileProductDetailsPageWouldBeLoaded();
    }

    @Step
    public void clickOnCloseButtonOnTheWarningMessage() throws Exception {
        allRecipesPage.clickOnCloseButtonOnTheWarningMessage();
    }

    @Step
    public void turnOffDonTDisturbOption() throws Exception {
        androidPage.turnOffDonTDisturbOption();
    }

    @Step
    public void clickOnThePhoneButton() throws Exception {
        androidPage.clickOnThePhoneButton();
    }
}
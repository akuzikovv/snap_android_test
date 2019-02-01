package androidAutomation.pages;

import androidAutomation.ILocators;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static androidAutomation.MyAndroidDriver.*;

public class AllRecipesPage extends PageObject {

    public List<String> filtersString = new ArrayList<>();
    public List<String> listOfTitles = new ArrayList<>();

    public void waitWhileAppWouldBeLoaded() throws Exception {
        waitFor(ExpectedConditions.visibilityOf(getElementById(ILocators.APP_WELCOME_LABEL)));
    }

    public void clickOnTheGotItButton() throws Exception {
        getElementById(ILocators.APP_DONE_BUTTON).tap(1, 1);
    }

    public void waitForLoadingMainPage() throws Exception {
        waitFor(ExpectedConditions.elementToBeClickable(getElementById(ILocators.APP_MP_FIRST_ITEM_PHOTO)));
    }

    public void refreshTheMainPage() throws Exception {
        swipeDown();
    }

    public void waitForLoadingAdv() throws Exception {
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.id(ILocators.APP_ADV)));
    }

    public void clickOnTheTitleOfTheSomeProduct(String arg0) throws Exception {
        getElementByMatchingVisibleText(arg0).tap(1, 1);
    }

    public String getTextOfTheTitleOfProductOnProductDetailsPage() throws Exception {
        return getElementByMatchingVisibleText((String) Serenity.getCurrentSession().get("TitleOfTheCurrentProduct")).getText();
    }

    public void clickOnTheSearchButtonInTheHeader() throws Exception {
        getElementById(ILocators.APP_MP_SEARCH_BUTTON).tap(1, 1);
    }

    public void clearSearchField() throws Exception {
        getElementById(ILocators.APP_SEARCH_FIELD).clear();
    }

    public void typeWordToTheSearchField(String arg0) throws Exception {
        getElementById(ILocators.APP_SEARCH_FIELD).sendKeys(arg0);
    }

    public void clickOnTheFiltersButton() throws Exception {
        getElementById(ILocators.APP_FILTERS_BUTTON).tap(1, 1);
    }

    public void clearIngredientsField() throws Exception {
        getElementById(ILocators.APP_SP_INGREDIENT_FIELD).clear();
    }

    public void typeWordToTheIngredientsField(String arg0) throws Exception {
        getElementById(ILocators.APP_SP_INGREDIENT_FIELD).sendKeys(arg0);
        filtersString.add(arg0);
    }

    public void clickOnAddIngredientButton() throws Exception {
        getElementById(ILocators.APP_SP_ADD_INGREDIENT_BUTTON).tap(1, 1);
    }

    public void clickOnRemoveIngredientButton() throws Exception {
        getElementById(ILocators.APP_SP_REMOVE_INGREDIENT_BUTTON).tap(1, 1);
    }

    public void chooseOptionInTheByDietaryNeedsMenu(String arg0) throws Exception {
        if (!getElementByMatchingVisibleText(arg0).getAttribute("checked").equalsIgnoreCase("true")) {
            getElementByMatchingVisibleText(arg0).tap(1, 1);
            filtersString.add(arg0);
        }
    }

    public void refuseOptionInTheByDietaryNeedsMenu(String arg0) throws Exception {
        if (getElementByMatchingVisibleText(arg0).getAttribute("checked").equalsIgnoreCase("true")) {
            getElementByMatchingVisibleText(arg0).tap(1, 1);
            filtersString.remove(arg0);
        }
    }

    public void setReadyInOptionAsValue(String arg0) throws Exception {
        AndroidElement androidElement = getElementById(ILocators.APP_SP_READY_IN_SPINNER);
        int spinnerRadius = 61;
        int step = 0;
        while (!getElementById(ILocators.APP_SP_READY_IN_LABEL).getText().equalsIgnoreCase(arg0)) {
            getElementById(ILocators.APP_SP_SEARCH_BUTTON);
            TouchAction touchAction = new TouchAction(driver).
                    longPress(androidElement.getLocation().getX() + spinnerRadius + step, androidElement.getLocation().getY() + spinnerRadius).
                    moveTo(androidElement.getLocation().getX() + step + androidElement.getSize().getWidth() / 7, androidElement.getLocation().getY() + spinnerRadius).
                    release();
            touchAction.perform();
            step += androidElement.getSize().getWidth() / 7;
        }
        filtersString.add(arg0);
    }

    public void clickOnTheSearchButtonOnTheSearchPage() throws Exception {
        getElementById(ILocators.APP_SP_SEARCH_BUTTON).tap(1, 1);
    }

    public boolean checkThatInSearchResultPageFiltersLabelContainsAllNecessaryOptions() throws Exception {
        for (String st : filtersString) {
            if (!getElementById(ILocators.APP_SRP_FILTERS_LABEL).getText().contains(st)) {
                return false;
            }
        }
        return true;
    }

    public boolean isTitleOfRecipeEnabled(String arg0) throws Exception {
        return getElementByMatchingVisibleText(arg0).isEnabled();
    }

    public void openMenuBySwiping() {
        swipeRightToOpenMenu();
    }

    public void clickOnTheSignInButtonInTheMenu() throws Exception {
        getElementById(ILocators.APP_MENU_SIGN_IN_BUTTON).tap(1, 1);
    }

    public void clearEmailField() throws Exception {
        getElementById(ILocators.APP_SIP_EMAIL_FIELD).clear();
    }

    public void typeEmailToTheEmailField(String arg0) throws Exception {
        getElementById(ILocators.APP_SIP_EMAIL_FIELD).sendKeys(arg0);
    }

    public void clearPasswordField() throws Exception {
        getElementById(ILocators.APP_SIP_PASSWORD_FIELD).clear();
    }

    public void typePasswordToThePasswordField(String arg0) throws Exception {
        getElementById(ILocators.APP_SIP_PASSWORD_FIELD).sendKeys(arg0);
    }

    public void clickOnTheSignInButtonInTheSignInMenu() throws Exception {
        getElementById(ILocators.APP_SIP_SIGN_IN_BUTTON).tap(1, 1);
    }

    public String getUserNameInMenu() throws Exception {
        return getElementById(ILocators.APP_MENU_SIGN_IN_LABEL).getText();
    }

    public boolean checkThatToolbarIsEnabled() throws Exception {
        return getElementById(ILocators.APP_MP_TOOLBAR).isEnabled();
    }

    public boolean checkThatOpenNavigationDrawerIsEnabled() throws Exception {
        return getElementByMatchingVisibleText("Open navigation drawer").isEnabled();
    }

    public void rememberTitlesOfProductsOnTheMainPage() throws Exception {
        List<AndroidElement> list = driver.findElements(By.xpath(ILocators.APP_MP_TITLES_OF_ITEMS));
        for (AndroidElement androidElement : list) {
            if (androidElement.getLocation().getY() < advTopYCoordinate) {
                listOfTitles.add(androidElement.getText());
            }
        }
    }

    public boolean checkThatListOfProductsOnThePageIsTheSameAsYouRemembered() throws Exception {
        List<AndroidElement> list = driver.findElements(By.xpath(ILocators.APP_MP_TITLES_OF_ITEMS));
        for (int i = 0; i < list.size(); i++) {
            if (!listOfTitles.get(i).equalsIgnoreCase(list.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkThatWarningMessageAboutYourInternetConnectionIsAppeared() throws Exception {
        return getElementById(ILocators.EMULATOR_WARNING_MESSAGE).isEnabled();
    }

    public void waitWhileProductDetailsPageWouldBeLoaded() throws Exception {
        waitFor(ExpectedConditions.visibilityOf(getElementById(ILocators.APP_PDP_TITLE_OF_ITEM)));
        waitABit(200);
    }

    public void clickOnCloseButtonOnTheWarningMessage() throws Exception {
        getElementByMatchingVisibleText("Close").tap(1, 1);
    }
}
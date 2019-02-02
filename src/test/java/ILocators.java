package androidAutomation;

public interface ILocators {




    //-------------------------------------------    EMULATOR    -------------------------------------------//

    String EMULATOR_CLOCK = "com.android.systemui:id/clock";
    String EMULATOR_HEADER = "com.android.systemui:id/header";
    String EMULATOR_RECENT_VIEW = "com.android.systemui:id/recents_view";
    String EMULATOR_TITLES_OF_RECENT_APPS = "//android.widget.TextView[@resource-id='com.android.systemui:id/activity_description']";
    String EMULATOR_NOTIFICATIONS_WIFI_LABEL = "//android.view.ViewGroup[@resource-id='com.android.systemui:id/quick_settings_panel']/android.view.ViewGroup[2]/android.widget.LinearLayout//android.widget.TextView";
    String EMULATOR_NOTIFICATIONS_WIFI_ICO = "//android.view.ViewGroup[@resource-id='com.android.systemui:id/quick_settings_panel']/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.ImageView";
    String EMULATOR_WARNING_MESSAGE = "android:id/message";




    //-------------------------------------------    SAMSUNG S5    -------------------------------------------//

    String SANSUNGS5_CLOCK = "com.android.systemui:id/time_view";
    String SAMSUNGS5_SETTINGS_ICO = "com.android.systemui:id/settings_button";

    
    
    
    //-------------------------------------------    APPLICATION    -------------------------------------------//

    String APP_WELCOME_LABEL = "com.allrecipes.spinner.free:id/welcome_text";
    String APP_DONE_BUTTON = "com.allrecipes.spinner.free:id/done_button";
    String APP_SEARCH_FIELD = "com.allrecipes.spinner.free:id/search_src_text";
    String APP_FILTERS_BUTTON = "com.allrecipes.spinner.free:id/main_menu_item_filter";

    String APP_MENU_SIGN_IN_BUTTON = "com.allrecipes.spinner.free:id/navigation_signInOut_buttonRelativeLayout";
    String APP_MENU_SIGN_IN_LABEL = "com.allrecipes.spinner.free:id/navigation_user_tile_textView";

    String APP_SIP_EMAIL_FIELD = "com.allrecipes.spinner.free:id/signin_edittext_email";
    String APP_SIP_PASSWORD_FIELD = "com.allrecipes.spinner.free:id/signin_edittext_password";
    String APP_SIP_SIGN_IN_BUTTON = "com.allrecipes.spinner.free:id/signin_btnsignin";

    String APP_MP_FIRST_ITEM_PHOTO = "com.allrecipes.spinner.free:id/grid_item_photo_imageView";
    String APP_MP_SEARCH_BUTTON = "com.allrecipes.spinner.free:id/main_menu_item_search";
    String APP_MP_TOOLBAR = "com.allrecipes.spinner.free:id/toolbar";
    String APP_MP_TITLES_OF_ITEMS = "//android.widget.TextView[@resource-id='com.allrecipes.spinner.free:id/grid_item_title_textView']";

    String APP_SP_INGREDIENT_FIELD = "com.allrecipes.spinner.free:id/search_ingredients_edittext";
    String APP_SP_ADD_INGREDIENT_BUTTON = "com.allrecipes.spinner.free:id/search_ingredients_add";
    String APP_SP_REMOVE_INGREDIENT_BUTTON = "com.allrecipes.spinner.free:id/search_ingredients_remove";
    String APP_SP_READY_IN_SPINNER = "com.allrecipes.spinner.free:id/search_comboseekbar";
    String APP_SP_READY_IN_LABEL = "com.allrecipes.spinner.free:id/search_ready_in_time";
    String APP_SP_SEARCH_BUTTON = "com.allrecipes.spinner.free:id/search_search_button";

    String APP_SRP_FILTERS_LABEL = "com.allrecipes.spinner.free:id/search_results_text";

    String APP_PDP_TITLE_OF_ITEM = "com.allrecipes.spinner.free:id/recipe_title_textView";

    String APP_ADV = "com.allrecipes.spinner.free:id/adView";
}

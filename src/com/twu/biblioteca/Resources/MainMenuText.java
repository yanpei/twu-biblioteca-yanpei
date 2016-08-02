package com.twu.biblioteca.Resources;

public class MainMenuText {
    private static String mainMenuText = "*************************************\n"
                                        +"Main Menu\n"
                                        +"************************************\n"
                                        +"      1. List books\n"
                                        +"      2. Checkout books\n"
                                        +"      3. Return books\n"
                                        +"      4. List Movies\n"
                                        +"      5. Checkout Movies\n"
                                        +"      6. Longin\n"
                                        +"\n"
                                        +"      q. Quit\n"
                                        +"-------------------------------------";

    private static String mainMenuTextAfterLogin = "*************************************\n"
                                                  +"Main Menu\n"
                                                  +"************************************\n"
                                                  +"      1. List books\n"
                                                  +"      2. Checkout books\n"
                                                  +"      3. Return books\n"
                                                  +"      4. List Movies\n"
                                                  +"      5. Checkout Movies\n"
                                                  +"      6. Longin\n"
                                                  +"      7. My Information\n"
                                                  +"\n"
                                                  +"      q. Quit\n"
                                                  +"-------------------------------------";

    public static String getMainMenuText() {

        return mainMenuText;
    }

    public static String getMainMenuTextAfterLogin() {
        return mainMenuTextAfterLogin;
    }

}

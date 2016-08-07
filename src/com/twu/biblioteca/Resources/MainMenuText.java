package com.twu.biblioteca.Resources;

public class MainMenuText {
    private static String mainMenuHeader =
            "*************************************\n"
            +"Main Menu\n"
            +"************************************\n";

    private static String basicMenu = "\t\t1. List books\n"
            +"\t\t2. Checkout books\n"
            +"\t\t3. Return books\n"
            +"\t\t4. List Movies\n"
            +"\t\t5. Checkout Movies\n"
            +"\t\t6. Longin\n";

    private static String endMenu = "\n"
                                   +"\t\tq. Quit\n"
                                   +"-------------------------------------";

    private static String infomotionMenu = "\t\t7. My Information\n";

    private static String mainMenuText = mainMenuHeader + basicMenu + endMenu;

    private static String mainMenuTextAfterLogin = mainMenuHeader + basicMenu + infomotionMenu + endMenu;

    public static String getMainMenuText() {

        return mainMenuText;
    }

    public static String getMainMenuTextAfterLogin() {

        return mainMenuTextAfterLogin;
    }

}

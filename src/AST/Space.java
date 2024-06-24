package AST;

public class Space {
    public static int currentValue = 0;
    public static boolean isInsideReturn = false;
    public static boolean isJsxAttr = false;

    public static boolean isNotComponentParametersCall = true;
    public static boolean isInsideUseEffect = false;
    public static boolean isSearchFound = false;
    public static boolean isAppComponent = false;

    public static String valueUseState = "";
    public static String functionUseState = "";
    public static String initialUseState = "";

    public static boolean isUseState = false;

}

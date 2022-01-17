public class CurrentUser {
    private static String name;
    private static String userName;
    private static String password;
    private static String ID;
    private static boolean isAdmin = false;

    public static void setName(String name) {
        CurrentUser.name = name;
    }

    public static void setUserName(String userName) {
        CurrentUser.userName = userName;
    }

    public static void setPassword(String password) {
        CurrentUser.password = password;
    }

    public static void setID(String ID) {
        CurrentUser.ID = ID;
    }

    public static void setIsAdmin(boolean isAdmin) {
        CurrentUser.isAdmin = isAdmin;
    }

    public static String getName() {
        return name;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getID() {
        return ID;
    }

    public static boolean getIsAdmin() {
        return isAdmin;
    }

}

package org.example;

public class BceUtils {
    private BceUtils() {
        failUtilityClassInstantiation(this.getClass());
    }
    public static boolean classExist(String className) {

        boolean ret;
        try {
            Class.forName(className);
            ret = true;
        } catch (ClassNotFoundException e) {
            ret = false;
        }
        return ret;
    }
    private static void failUtilityClassInstantiation(Class<?> aClass) {
        throw new UnsupportedOperationException(aClass + " is utility class and should never be instantiated");
    }
}

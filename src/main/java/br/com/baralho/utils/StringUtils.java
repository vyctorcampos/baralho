package br.com.baralho.utils;

public class StringUtils {

    public static boolean containsIgnoreCase(String[] array, String value) {
        for (String str : array) {
            if (value == null && str == null)
                return true;
            if (value != null && value.equalsIgnoreCase(str))
                return true;
        }
        return false;
    }


    public static String join(String[] array, String separator) {
        int len = array.length;
        if (len == 0)
            return "";

        StringBuilder out = new StringBuilder();
        out.append(array[0]);
        for (int i = 1; i < len; i++) {
            out.append(separator).append(array[i]);
        }
        return out.toString();
    }

    public static boolean isNotNullAndNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean valida(String string) {
        return string != null && !string.trim().isEmpty() && !"null".equals(string.replace("\n", ""));
    }

}

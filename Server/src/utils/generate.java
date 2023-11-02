package utils;

import java.text.Normalizer;

public class generate {

    public static String code(int id, String name) {
        String dest = Normalizer.normalize(name.trim(), Normalizer.Form.NFD);
        return id + "" + dest.replaceAll("[^\\p{ASCII}]", "").toLowerCase().replaceAll(" ", "");
    }
}

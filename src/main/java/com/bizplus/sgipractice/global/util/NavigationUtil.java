package com.bizplus.sgipractice.global.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class NavigationUtil {

    public static List<String> setNavigation(String... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
}

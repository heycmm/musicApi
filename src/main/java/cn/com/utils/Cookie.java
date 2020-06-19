package cn.com.utils;

import java.util.*;

/**
 * @author：czx.me 2020/6/19
 */
public class Cookie {
    public static Map<String, String> parseStrCookie(String strCookie) {
        try {
            String[] split = strCookie.split("; ");
            Map<String, String> map = new HashMap<String, String>();
            Arrays.stream(split).forEach(s -> {
                String[] m = s.split("=");
                if (m.length==2){
                    map.put(m[0], m[1]);
                }
            });
            return map;
        } catch (Exception e) {
            return null;
        }
    }

    public static String parseMapStr(Map<String, String> map) {
        List<String> list = new ArrayList<>();
        if (map != null) {
            map.forEach((k, v) -> list.add(k + "=" + v));
        }
        return String.join("; ", list);
    }
}

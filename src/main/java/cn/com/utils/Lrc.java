package cn.com.utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author：czx.me 2020/6/19
 */
public class Lrc {

    public static String lrcSorted(String lyric, String lyr) {
        StringBuilder sb = new StringBuilder();
        List<String> lista = new ArrayList<>(Arrays.asList(lyr.split("\n"))).stream().distinct().sorted().collect(Collectors.toList());
        List<String> listb = new ArrayList<>(Arrays.asList(lyric.split("\n"))).stream().distinct().sorted().collect(Collectors.toList());
        String substring = "";
        String substring1 = "";
        List<String> list3 = new ArrayList<String>();
        for (String s : lista) {
            try {
                substring = s.substring(s.indexOf("["), s.lastIndexOf("]") + 1);
            } catch (Exception e) {
                list3.add(s + "\n");
                continue;
            }
            for (String ss : listb) {
                try {
                    substring1 = ss.substring(ss.indexOf("["), ss.lastIndexOf("]") + 1);
                    if (substring.equals(substring1)) {
                        String sss = ss.substring(ss.indexOf("]") + 1);
                        if (!"".equals(sss)) {
                            list3.add(s + "（" + sss + "）\n");
                        } else {
                            list3.add(s + "\n");
                        }
                    } else {
                        try {
                            String sbss = substring1.substring(substring1.indexOf("["), substring1.lastIndexOf("]") - 2);
                            String sbdd = substring.substring(substring.indexOf("["), substring.lastIndexOf("]") - 2);
                            if (sbss.equals(sbdd)) {
                                int one, onte;
                                one = Integer.parseInt(substring1.substring(substring1.indexOf(".") + 1, substring1.lastIndexOf("]")));
                                onte = Integer.parseInt(substring.substring(substring.indexOf(".") + 1, substring.lastIndexOf("]")));
                                int ccc = one - onte;
                                if (ccc >= 0 && ccc < 10 || ccc <= 0 && ccc > -10) {
                                    String sss = ss.substring(ss.indexOf("]") + 1);
                                    if (!"".equals(sss)) {
                                        list3.add(s + "（" + sss + "）\n");
                                    } else {
                                        list3.add(s + "\n");
                                    }
                                }
                            }
                        } catch (Exception ignored) {
                        }
                    }
                } catch (Exception e) {
                    list3.add(ss + "\n");
                }
            }
        }
        list3.stream().distinct().sorted().forEach(sb::append);
        return sb.toString();
    }
}

package ua.nure.lytovchenko.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    static String convert(String input) {
        Pattern pattern = Pattern.compile("([a-zA-ZА-Яа-яіїєёЁІЇ]+)");
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            Pattern pattern2 = Pattern.compile("\\s" + matcher.group(1) + "\\s");
            int start = matcher.start();
            int end = matcher.end();
            Matcher matcher2 = pattern2.matcher(" " + input.substring(0, start) + input.substring(end));
            if (matcher2.find()) {
                matcher.appendReplacement(sb, "_" + matcher.group(1));
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert(Util.readFile("part6.txt")));
    }
}

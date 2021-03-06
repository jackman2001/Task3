package ua.nure.lytovchenko.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {


    public static String convert(String input) {

        int minSize = Integer.MAX_VALUE;
        int maxSize = Integer.MIN_VALUE;
        StringBuilder min = new StringBuilder("");
        StringBuilder max = new StringBuilder("");
        Pattern pattern = Pattern.compile("([a-zA-ZА-Яа-яєЄёЁїЇіІ]+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String word = matcher.group(1);
            if (!Part1.contains(" "+word+",", max.toString() + min.toString())) {
                if (maxSize < word.length()) {
                    maxSize = word.length();
                    max.setLength(0);
                    max.append(" ").append(word).append(", ");
                } else if (minSize > word.length()) {
                    minSize = word.length();
                    min.setLength(0);
                    min.append(" ").append(word).append(", ");
                } else if (word.length() == maxSize) {
                    max.append(word).append(", ");
                } else if (word.length() == minSize) {
                    min.append(word).append(", ");
                }
            }
        }
        return "Min:" + min.substring(0, min.length() - 2) + "\nMax:" + max.substring(0, max.length() - 2);
    }

    public static void main(String[] args) {
        System.out.println(convert(Util.readFile("part2.txt")));
    }
}

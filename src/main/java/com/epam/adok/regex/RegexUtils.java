package com.epam.adok.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    private static final String WORD_PATTERN = "((?U)(\\w)*(\\p{Punct})?(\\w)+)";
    private static final String  HTML_TAG_PATTERN_HEAVY = "([\\w\\s\\p{Punct}\\p{L}]*?)((<)([\\w\\p{Punct}\\s&&[^<>]]*(>)))";
    private static final String HTML_TAG_PATTERN_LIGHTWEIGHT = "([\\w]+=)'(.+?)'";

    public static List<String> findAllWords(String input) {
        List<String> words = new ArrayList<String>();

        Pattern p = Pattern.compile(WORD_PATTERN);
        Matcher matcher = p.matcher(input);

        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static boolean isValid(String pattern, String input) {
        return input.matches(pattern);
    }

    public static String replaceWithLightAllInHTMLTagElementTo(String replacement, String pattern, String input) {
        return Pattern.compile(HTML_TAG_PATTERN_LIGHTWEIGHT)
                .matcher(input)
                .replaceAll("$1\"$2\"");
    }

    public static String replaceWithHeavyAllInHTMLTagElementTo(String replacement, String pattern, String input) {
                Pattern p = Pattern.compile(HTML_TAG_PATTERN_HEAVY);
        Matcher matcher = p.matcher(input);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group(1));
            String group2 = matcher.group(2);
            String replaced = group2.replaceAll(pattern, replacement);
            sb.append(replaced);
        }
        return sb.toString();
    }

    public static List<String> findTags(String pattern, String input) {
        List<String> tags = new ArrayList<>();

        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(input);

        while (matcher.find()) {
            String tag = matcher.group();
            tags.add(tag);
            System.out.println(tag);
        }
        return tags;
    }
}

package com.epam.adok.regex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class RegexTaskTest_01 {

    @Parameter
    public String text;

    @Parameter(1)
    public int expected;

    @Parameters(name = "{index}: RegexTaskTest_01({0})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Going, through the forest is my favourite part of the walk. ", 11},
                {"Die Verkäuferin hilft mir. Sie zeigt uns noch einen Pulli in Weiß. Er ist wunderbar und ganz meine Größe.", 19},
                {"Привет, как дела?", 3},
                {"123 123 456", 3},
                {"Hello, Mr Smith-Walley", 3}
        });
    }

    @Test
    public void testRegex() {
        List<String> words = RegexUtils.findAllWords(text);
        assertThat(words.size(), is(expected));
    }
}

package com.epam.adok.regex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class RegexTaskTest_02 {

    private String pattern = "(?U)[-\\w&&[^0-9]]*";

    @Parameter
    public String input;

    @Parameter(1)
    public boolean expected;

    @Parameters(name = "{index}: RegexTaskTest_02({0})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"table_-", true},
                {"table123", false},
                {"русский", true},
                {"Verkäuferin-Größe", true}
        });
    }

    @Test
    public void testRegex() {
        assertThat(RegexUtils.isValid(pattern, input), is(expected));
    }
}

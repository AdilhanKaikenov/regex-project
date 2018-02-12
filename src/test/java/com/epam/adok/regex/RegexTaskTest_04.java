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
public class RegexTaskTest_04 {

    private String pattern = "(<[\\w\\s='\"]+)(class=(\"|')example(\"|'))([\\w\\s='\"]+)?>(.*?)(</.+?>)";

    @Parameter
    public String input;

    @Parameter(1)
    public int expected;

    @Parameters(name = "{index}: RegexTaskTest_04({0})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {       "<note class='1'>" +
                        "   <to id='1'>Tove</to>" +
                        "   <from id='1' class='example' class='example' id='1' class='w'>Jani</from>" +
                        "   <heading>Reminder</heading>" +
                        "   <body class=\"example\">Don't forget me this weekend!</body>" +
                        "</note>", 2}, // expected
        });
    }

    @Test
    public void testRegex() {
        assertThat(RegexUtils.findTags(pattern, input).size(), is(expected));
    }
}

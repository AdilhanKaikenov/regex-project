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
public class RegexTaskTest_03 {

    private String pattern = "\'";

    @Parameter
    public String input;

    @Parameter(1)
    public String expected;

    @Parameters(name = "{index}: RegexTaskTest_03({0})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"<startElement attribute_01='attribute1'/>", "<startElement attribute_01=\"attribute1\"/>"},

                {"<startElement attribute_01='attribute1'>Some text with quotes : 'Hello Adilhan'</endElement>",
                        "<startElement attribute_01=\"attribute1\">Some text with quotes : 'Hello Adilhan'</endElement>"},

                {"<startElement attribute_01='attribute1' attribute_02='attribute2'/>",
                        "<startElement attribute_01=\"attribute1\" attribute_02=\"attribute2\"/>"},

                {"<html:submit styleClass='general-button' onclick='return delete()'><bean:message key='delete.label.button.submit'/>Hello 'Adilkhan'</html:submit>",
                        "<html:submit styleClass=\"general-button\" onclick=\"return delete()\"><bean:message key=\"delete.label.button.submit\"/>Hello 'Adilkhan'</html:submit>"},

                {"<a attribute_01='attribute1' attribute_02='attribute2'>Русский</a>",
                        "<a attribute_01=\"attribute1\" attribute_02=\"attribute2\">Русский</a>"}

        });
    }

    @Test
    public void testRegex() {
        assertThat(RegexUtils.replaceWithLightAllInHTMLTagElementTo("\"", pattern, input), is(expected));
    }

}

package com.epam.adok.regex;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class RegexPerformanceTest {

    private static final String REPLACEMENT = "\"";

    private String pattern = "\'";
    private String input = "<html:submit styleClass='general-button' onclick='return delete()'><bean:message key='delete.label.button.submit'/>Hello 'Adilkhan'</html:submit>\",\n" +
            "                        \"<html:submit styleClass=\\\"general-button\\\" onclick=\\\"return delete()\\\"><bean:message key=\\\"delete.label.button.submit\\\"/>Hello 'Adilkhan'</html:submit>";

    @Benchmark
    public void testLightRegex() {
        RegexUtils.replaceWithLightAllInHTMLTagElementTo(REPLACEMENT, pattern, input);
    }

    @Benchmark
    public void testHeavyRegex() {
        RegexUtils.replaceWithHeavyAllInHTMLTagElementTo(REPLACEMENT, pattern, input);
    }
}

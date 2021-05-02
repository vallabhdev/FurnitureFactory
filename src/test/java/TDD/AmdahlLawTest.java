package TDD;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

public class AmdahlLawTest {
    private AmdalhLaw law;
    private DecimalFormat formatter;

    @Before
    public void setUp() {
        law = new AmdalhLaw();
        formatter = new DecimalFormat("#.#");
    }

    @Test
    public void when_serially_executed() {
        Assert.assertThat(String.format("%.1f", law.calculateExecutionTime(0.4f, 1)), Is.is("1.0"));
    }

    @Test
    public void when_parallelly_executed() {
        Assert.assertThat(formatter.format(law.calculateExecutionTime(0.4f, 2)), Is.is("0.7"));
        Assert.assertThat(formatter.format(law.calculateExecutionTime(0.2f, 4)), Is.is("0.4"));
    }
}

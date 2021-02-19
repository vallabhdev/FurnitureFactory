package TDD;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {
    @Test
    public void positiveNumberMustReturnValidInteger() throws Exception {
        Assert.assertThat(new Factorial().factorialOf(3), Is.is(6));
        Assert.assertThat(new Factorial().factorialOf(1), Is.is(1));
        Assert.assertThat(new Factorial().factorialOf(5), Is.is(120));
    }

    @Test(expected = Exception.class)
    public void negativeNumber_throwsException() throws Exception {
        new Factorial().factorialOf(-1);
    }
}

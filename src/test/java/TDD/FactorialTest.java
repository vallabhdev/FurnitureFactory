package TDD;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FactorialTest {
    @Test
    public void positiveNumberMustReturnValidInteger() throws Exception {
        Assert.assertThat(new Factorial().factorialOf(3), Is.is(6));
        Assert.assertThat(new Factorial().factorialOf(1), Is.is(1));
        Assert.assertThat(new Factorial().factorialOf(5), Is.is(120));
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> teamSize = new HashMap<>();
        map.values().stream().distinct().forEach(dv -> {
            if (teamSize.containsKey(dv)) {
                teamSize.put(dv, teamSize.get(dv) + 1);
            } else {
                teamSize.put(dv, 1);
            }
        });
    }

    @Test(expected = Exception.class)
    public void negativeNumber_throwsException() throws Exception {
        new Factorial().factorialOf(-1);
    }
}

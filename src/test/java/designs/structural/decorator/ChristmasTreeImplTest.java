package designs.structural.decorator;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class ChristmasTreeImplTest {
    @Test
    public void testDecor() {
        ChristmasTreeImpl christmasTree = new ChristmasTreeImpl();
        christmasTree.setName("GreenTree");
        BubbleLights bubbleLights = new BubbleLights(christmasTree);
        Assert.assertThat(bubbleLights.decorate(), Is.is("GreenTree Tree having Basic decor with BubbleLights"));
        Garland garland = new Garland(christmasTree);
        Assert.assertThat(garland.decorate(), Is.is("GreenTree Tree having Basic decor with Garland"));
        StringLights stringLights = new StringLights(new Garland(christmasTree));
        Assert.assertThat(stringLights.decorate(), Is.is("GreenTree Tree having Basic decor with Garland with String Lights"));
    }
}
package designs.structural.decorator;

public class StringLights extends TreeDecorator {
    public StringLights(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String decorate() {
        return super.decorate() + " with String Lights";
    }
}

package designs.structural.decorator;

public class BubbleLights extends TreeDecorator {
    public BubbleLights(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String decorate() {
        return super.decorate() + bubbleDecor();
    }

    private String bubbleDecor() {
        return " with BubbleLights";
    }
}

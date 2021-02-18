package designs.structural.decorator;

public class ChristmasTreeImpl implements ChristmasTree {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String decorate() {
        return name + " Tree having Basic decor";
    }
}

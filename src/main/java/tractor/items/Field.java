package tractor.items;

public class Field implements IField {
    private final Point field;

    public Field(Point field) {
        this.field = field;
    }

    @Override
    public boolean checkContains(Point currentPosition) {
        return currentPosition.getX() <= field.getX() && currentPosition.getY() <= field.getY();
    }
}

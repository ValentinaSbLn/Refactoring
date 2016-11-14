package tractor;

import tractor.items.Field;
import tractor.items.IField;
import tractor.items.Orientation;
import tractor.items.Point;

import static tractor.items.Orientation.*;

public class Tractor {

    private Point position;
    private final IField field;
    Orientation orientation;

    public Tractor(Point point, Field field, Orientation orientation) {
        this.position = point;
        this.field = field;
        this.orientation = orientation;
    }

    public Tractor() {
        position = new Point(0, 0);
        field = new Field(new Point(5, 5));
        orientation = NORTH;
    }

    public void move(String command) {
        if (command.equals("F"))
            moveForwards();
        if (command.equals("T"))
            turnClockwise();
    }

    public void moveForwards() {
        position = orientation.changePosition(position);
        OutOfBounds();
    }

    private void OutOfBounds() {
        if (!field.checkContains(position)) {
            throw new TractorInDitchException();
        }
    }


    public void turnClockwise() {
        orientation = orientation.turnClockwise();
    }

    public int getPositionX() {
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }

    public Orientation getOrientation() {
        return orientation;
    }

}

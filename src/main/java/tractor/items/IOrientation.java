package tractor.items;

public interface IOrientation {
    /**
     * @param currentPoint
     * @return new Point where moved the tractor
     */
    Point changePosition(Point currentPoint);

    /**
     * Turns clockwise
     *
     * @return new Orientation type.
     */
    Orientation turnClockwise();
}

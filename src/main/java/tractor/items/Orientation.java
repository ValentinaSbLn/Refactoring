package tractor.items;

public enum Orientation implements IOrientation {

    NORTH {
        @Override
        public Point changePosition(Point currentPoint) {
            return new Point(currentPoint.getX(), currentPoint.getY() + 1);
        }

        @Override
        public Orientation turnClockwise() {
            return EAST;
        }
    }, WEST {
        @Override
        public Point changePosition(Point currentPoint) {
            return new Point(currentPoint.getX() - 1, currentPoint.getY());
        }

        @Override
        public Orientation turnClockwise() {
            return NORTH;
        }
    }, SOUTH {
        @Override
        public Point changePosition(Point currentPoint) {
            return new Point(currentPoint.getX(), currentPoint.getY() - 1);
        }

        @Override
        public Orientation turnClockwise() {
            return WEST;
        }
    }, EAST {
        @Override
        public Point changePosition(Point currentPoint) {
            return new Point(currentPoint.getX() + 1, currentPoint.getY());
        }

        @Override
        public Orientation turnClockwise() {
            return SOUTH;
        }
    }

}
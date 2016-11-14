package tractor.items;

public interface IField {
    /**
     * @param currentPosition
     * @return true, if the point is contained in the field, else return false
     */
    boolean checkContains(Point currentPosition);
}

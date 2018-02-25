package week3.points_segments;

public class Segment {

    private int leftPoint;
    private int rightPoint;

    public Segment() {}

    public Segment(final int leftPoint, final int rightPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public int getLeftPoint() {
        return leftPoint;
    }

    public void setLeftPoint(final int leftPoint) {
        this.leftPoint = leftPoint;
    }

    public int getRightPoint() {
        return rightPoint;
    }

    public void setRightPoint(final int rightPoint) {
        this.rightPoint = rightPoint;
    }

    public boolean containsPoint(final int point) {
        return leftPoint <= point && rightPoint >= point;
    }
}

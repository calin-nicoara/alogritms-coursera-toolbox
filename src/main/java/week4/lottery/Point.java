package week4.lottery;

public class Point implements Comparable{

    public Point(final int value, final Type type) {
        this.value = value;
        this.type = type;
    }

    public int value;
    public Type type;

    @Override
    public int compareTo(final Object o) {
        Point otherPoint = (Point) o;

        if(this.value > otherPoint.value) {
            return 1;
        } else if(this.value < otherPoint.value) {
            return -1;
        } else {
            return Integer.compare(this.type.priority, otherPoint.type.priority);
        }
    }

    public enum Type {
        INITIAL(0), LEFT(-1), RIGHT(1);

        Type(final int priority) {
            this.priority = priority;
        }

        public int priority;
    }
}

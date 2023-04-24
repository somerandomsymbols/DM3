package algorithm;

public class InputObject
{
    private final double x;
    private final double y;
    private final String name;

    public InputObject(double cx, double cy, String n)
    {
        this.x = cx;
        this.y = cy;
        this.name = n;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public static double getEuclideanDistance(InputObject a, InputObject b)
    {
        return Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
    }

    public static double getManhattanDistance(InputObject a, InputObject b)
    {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    @Override
    public String toString()
    {
        if (this.name == null)
            return String.format("(%s;%s)", this.x, this.y);
        else
            return this.name;
    }
}

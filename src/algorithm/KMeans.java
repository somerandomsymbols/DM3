package algorithm;

import java.util.List;

public class KMeans extends NonHierarchicalClusteringAlgorithm
{
    public KMeans(int x)
    {
        super(x);
    }

    @Override
    protected InputObject getCentroid(List<InputObject> objects)
    {
        double x = 0, y = 0;

        for (InputObject object : objects)
        {
            x += object.getX();
            y += object.getY();
        }

        x /= objects.size();
        y /= objects.size();

        return new InputObject(x, y, null);
    }

    @Override
    protected double getDistance(InputObject x, InputObject y)
    {
        return InputObject.getEuclideanDistance(x, y);
    }

    @Override
    public String toString()
    {
        return String.format("k-Means: k = %d", this.k);
    }
}

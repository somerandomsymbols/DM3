package algorithm;

import java.util.List;
import java.util.stream.Collectors;

public class KMedians extends NonHierarchicalClusteringAlgorithm
{
    public KMedians(int x)
    {
        super(x);
    }

    @Override
    protected InputObject getCentroid(List<InputObject> objects)
    {
        List<Double> xList = objects.stream().map(object -> object.getX()).sorted().collect(Collectors.toList());
        List<Double> yList = objects.stream().map(object -> object.getY()).sorted().collect(Collectors.toList());

        double x = xList.get(xList.size() / 2), y = yList.get(yList.size() / 2);

        if (xList.size() % 2 == 0)
        {
            x += xList.get(xList.size() / 2 - 1);
            x /= 2;
        }

        if (yList.size() % 2 == 0)
        {
            y += yList.get(yList.size() / 2 - 1);
            y /= 2;
        }

        return new InputObject(x, y, null);
    }

    @Override
    protected double getDistance(InputObject x, InputObject y)
    {
        return InputObject.getManhattanDistance(x, y);
    }

    @Override
    public String toString()
    {
        return String.format("k-Medians: k = %d", this.k);
    }
}

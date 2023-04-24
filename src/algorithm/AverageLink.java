package algorithm;

import java.util.List;

public class AverageLink extends HierarchicalClusteringAlgorithm
{
    @Override
    protected double getDistance(List<InputObject> clusterX, List<InputObject> clusterY)
    {
        double res = 0;

        for (InputObject x : clusterX)
            for (InputObject y : clusterY)
                res += this.getDistance(x, y);

        return res / clusterX.size() / clusterY.size();
    }

    @Override
    public String toString()
    {
        return "Average-link";
    }
}

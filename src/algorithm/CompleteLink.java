package algorithm;

import java.util.List;

public class CompleteLink extends HierarchicalClusteringAlgorithm
{
    @Override
    protected double getDistance(List<InputObject> clusterX, List<InputObject> clusterY)
    {
        double res = 0;

        for (InputObject x : clusterX)
            for (InputObject y : clusterY)
            {
                double d = this.getDistance(x, y);

                if (d > res)
                    res = d;
            }

        return res;
    }

    @Override
    public String toString()
    {
        return "Complete-link";
    }
}

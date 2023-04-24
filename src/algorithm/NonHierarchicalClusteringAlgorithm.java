package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class NonHierarchicalClusteringAlgorithm
{
    protected final int k;

    public NonHierarchicalClusteringAlgorithm(int x)
    {
        this.k = x;
    }

    public List<List<InputObject>> getClusters(List<InputObject> input)
    {
        List<InputObject>[] clusters = new List[this.k];
        InputObject[] centroids = new InputObject[this.k];

        for (int i = 0; i < this.k; ++i)
        {
            clusters[i] = new ArrayList<>();
            clusters[i].add(input.get(i));
            centroids[i] = input.get(i);
        }

        for (int i = k; i < input.size(); ++i)
        {
            InputObject object = input.get(i);
            List<InputObject> cluster = Arrays.stream(clusters).min(Comparator.comparingDouble(list -> this.getDistance(list.get(0), object))).get();

            cluster.add(object);
        }

        boolean f = true;
        System.out.println(Arrays.asList(clusters));

        while (f)
        {
            System.out.println(Arrays.asList(centroids));

            f = false;

            for (int i = 0; i < this.k; ++i)
                centroids[i] = this.getCentroid(clusters[i]);

            for (int i = 0; i < this.k; ++i)
            {
                for (InputObject object : List.copyOf(clusters[i]))
                {
                    int closest = 0;
                    double distance = Double.MAX_VALUE;

                    for (int j = 0; j < this.k; ++j)
                    {
                        double d = this.getDistance(centroids[j], object);

                        if (d < distance)
                        {
                            distance = d;
                            closest = j;
                        }
                    }

                    if (closest != i)
                    {
                        f = true;
                        clusters[i].remove(object);
                        clusters[closest].add(object);
                    }
                }
            }

            System.out.println(Arrays.asList(clusters));
        }

        return Arrays.asList(clusters);
    }

    protected abstract InputObject getCentroid(List<InputObject> objects);

    protected abstract double getDistance(InputObject x, InputObject y);

    @Override
    public abstract String toString();
}

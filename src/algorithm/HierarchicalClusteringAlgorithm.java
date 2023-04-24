package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class HierarchicalClusteringAlgorithm
{
    public HierarchicalClusteringAlgorithm()
    {

    }

    /*public Dendrogram getTree(List<InputObject> points)
    {
        List<Dendrogram.DendrogramNode> clusters = points.stream().map(o -> new Dendrogram.DendrogramLeaf(o)).collect(Collectors.toList());

        while (clusters.size() > 1)
        {
            System.out.println(clusters);
            Dendrogram.DendrogramNode left = null;
            Dendrogram.DendrogramNode right = null;
            double distance = Double.MAX_VALUE;

            for (Dendrogram.DendrogramNode clusterX : clusters)
                for (Dendrogram.DendrogramNode clusterY : clusters)
                    if (clusterX != clusterY)
                    {
                        double d = this.getDistance(clusterX.getObjects(), clusterY.getObjects());

                        //System.out.println(clusterX + " " + clusterY + " " + d + " " + distance);

                        if (d < distance)
                        {
                            //System.out.println(true);
                            left = clusterX;
                            right = clusterY;
                            distance = d;
                        }
                    }

            clusters.remove(left);
            clusters.remove(right);
            clusters.add(0, new Dendrogram.DendrogramBranch(left, right));
        }

        return new Dendrogram(clusters.stream().findAny().get());
    }*/

    public List<List<List<InputObject>>> getMergingList(List<InputObject> input)
    {
        List<List<List<InputObject>>> res = new ArrayList<>();

        List<List<InputObject>> clusters = input.stream().map(o -> List.of(o)).collect(Collectors.toList());

        while (clusters.size() > 1)
        {
            List<InputObject> left = null;
            List<InputObject> right = null;
            double distance = Double.MAX_VALUE;

            for (List<InputObject> clusterX : clusters)
                for (List<InputObject> clusterY : clusters)
                    if (clusterX != clusterY)
                    {
                        double d = this.getDistance(clusterX, clusterY);

                        if (d < distance)
                        {
                            left = clusterX;
                            right = clusterY;
                            distance = d;
                        }
                    }

            List<InputObject> newCluster = new ArrayList<>(left);

            newCluster.addAll(right);
            clusters.remove(left);
            clusters.remove(right);
            clusters.add(newCluster);

            res.add(List.copyOf(clusters));
        }

        return res;
    }

    protected abstract double getDistance(List<InputObject> x, List<InputObject> y);

    protected final double getDistance(InputObject a, InputObject b)
    {
        return InputObject.getEuclideanDistance(a, b);
    }

    @Override
    public abstract String toString();
}

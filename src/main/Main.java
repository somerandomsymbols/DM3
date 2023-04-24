package main;

import algorithm.*;

import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<List<String>> inputs = List.of(
                List.of(
                        "A 3 3",
                        "B 2 3",
                        "C 2 4",
                        "D 5 1",
                        "E 3 1",
                        "F 1 5",
                        "G 6 5",
                        "H 6 4",
                        "I 2 5",
                        "J 1 2"
                ),
                List.of(
                        "A 3 4",
                        "B 1 6",
                        "C 5 4",
                        "D 5 5",
                        "E 3 2",
                        "F 1 1",
                        "G 2 2",
                        "H 6 3",
                        "I 4 2",
                        "J 1 2"
                ),
                List.of(
                        "A 1 5",
                        "B 1 1",
                        "C 2 1",
                        "D 2 6",
                        "E 3 4",
                        "F 3 3",
                        "G 4 6",
                        "H 5 3",
                        "I 6 5",
                        "J 6 1"
                ),
                List.of(
                        "A 4 3",
                        "B 5 3",
                        "C 5 4",
                        "D 2 1",
                        "E 4 1",
                        "F 6 5",
                        "G 1 5",
                        "H 1 4",
                        "I 5 5",
                        "J 6 2"
                ),
                List.of(
                        "A 3 6",
                        "B 2 3",
                        "C 2 2",
                        "D 5 5",
                        "E 3 5",
                        "F 1 1",
                        "G 6 1",
                        "H 6 2",
                        "I 2 1",
                        "J 1 4"
                ),
                List.of(
                        "A 3 3",
                        "B 3 2",
                        "C 4 2",
                        "D 1 5",
                        "E 1 3",
                        "F 5 1",
                        "G 5 6",
                        "H 4 6",
                        "I 5 2",
                        "J 2 1"
                )
        );

        for (List<String> inputStrings : inputs)
        {
            for (String inputString : inputStrings)
                System.out.println(inputString);

            System.out.println();

            List<InputObject> input = inputStrings.stream().map(s -> {
                String[] ss = s.split(" ");

                return new InputObject(Integer.valueOf(ss[1]), Integer.valueOf(ss[2]), ss[0]);
            }).collect(Collectors.toList());

            HierarchicalClusteringAlgorithm singleLink = new SingleLink();
            HierarchicalClusteringAlgorithm completeLink = new CompleteLink();
            HierarchicalClusteringAlgorithm averageLink = new AverageLink();

            NonHierarchicalClusteringAlgorithm kMeans = new KMeans(3);
            NonHierarchicalClusteringAlgorithm kMedians = new KMedians(3);

            System.out.println(singleLink);
            System.out.println(singleLink.getMergingList(input));
            System.out.println();

            System.out.println(completeLink);
            System.out.println(completeLink.getMergingList(input));
            System.out.println();

            System.out.println(averageLink);
            System.out.println(averageLink.getMergingList(input));
            System.out.println();

            System.out.println(kMeans);
            System.out.println(kMeans.getClusters(input));
            System.out.println();

            System.out.println(kMedians);
            System.out.println(kMedians.getClusters(input));
            System.out.println();
        }
    }
}

package sets;

import java.io.*;
import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.print("Enter number of elements for the Set : ");
        int n = Integer.parseInt(br.readLine());

        Set<Integer> hashSet = new HashSet<>();
        System.out.println("\nEnter " + n + " integer values :");
        for (int i = 0; i < n; i++) {
            hashSet.add(Integer.parseInt(br.readLine()));
        }

        List<Integer> sortedList = new ArrayList<>(hashSet);
        Collections.sort(sortedList);
        System.out.println("\nSorted List : " + sortedList);


        Set<Integer> treeSet = new TreeSet<>(hashSet);
        System.out.println("\nSorted Set : " + treeSet);

        List<Integer> sortedStreamList = hashSet.stream()
                .sorted()
                .toList();
        System.out.println("\nSorted List : " + sortedStreamList);

        System.out.println("\nUsing Priority Queue : ");
        PriorityQueue<Integer> pq = new PriorityQueue<>(hashSet);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */
import java.util.*;
import java.io.*;
import java.lang.*;

public class CompetitionDijkstra {
  int sA, sB, sC, N, S;
  HashMap<Integer, HashMap<Integer, Double>> graph;

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
    */
    CompetitionDijkstra (String filename, int sA, int sB, int sC){
      this.sA = sA;
      this.sB = sB;
      this.sC = sC;
      
      File file = new File(filename);
      try{
        Scanner scanner = new Scanner(file);
        N = scanner.nextInt();
        S = scanner.nextInt();
        graph = new HashMap<Integer, HashMap<Integer, Double>>();
        
        int v;
        int w;
        double weight;
        
        for(int i = 0; i < S; i++) {
          v = scanner.nextInt();
          w = scanner.nextInt();
          weight = scanner.nextDouble();
          if(graph.get(v) == null)
            graph.put(v, new HashMap<Integer, Double>());
          graph.get(v).put(w, weight);
        }

        scanner.close();
      } catch (FileNotFoundException e) {
        System.err.println("FileNotFoundException caught!");
        e.printStackTrace();
      }
    }

    /**
    * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){
      // The contestants can start at any intersection and choose to meet at any intersection.
      // Therefore, the worst case scenario is one that requires the slowest contestant to travel the longest path
      // I need to perform Dijkstra's Shortest Path algorithm for every intersection in the city.
      // I then need to search through all of the shortest paths and find the longest one
      // I will then divide the length of the longest shortest path by the slowest walking speed

      if(sA < 50 || sB < 50 || sC < 50 || sA > 100 || sB > 100 || sC > 100)
        return -1;

      double[] distTo = new double[N];
      int[] edgeTo = new int[N];
      double longestShortestPath = 0;

      for(Integer source : graph.keySet()) {
        dijkstra(source, distTo, edgeTo);
        for(int i = 0; i < N; i++) {
          if(edgeTo[i] == -1)
            return -1;
          if(longestShortestPath < distTo[i])
            longestShortestPath = distTo[i];
        }
      }
      
      int slowestSpeed = sA;
      if(slowestSpeed > sB) slowestSpeed = sB;
      if(slowestSpeed > sC) slowestSpeed = sC;

      double duration = longestShortestPath * 1000 / slowestSpeed;
      int roundedDuration = (int)Math.ceil(duration);

      return roundedDuration;
    }

    public void dijkstra(int source, double[] distTo, int[] edgeTo) {
      ArrayList<Integer> unvisitedNodes = new ArrayList<Integer>();
      distTo = new double[N];
      edgeTo = new int[N];
      
      for(int i = 0; i < N; i++) {
        distTo[i] = Integer.MAX_VALUE;
        edgeTo[i] = -1;
        unvisitedNodes.add(i);
      }
      distTo[source] = 0;

      int min = source;
      double minDist;
      int v;
      while(min != -1) {
        v = min;
        for(Integer w : graph.get(v).keySet()) {
          if(unvisitedNodes.contains(w) && distTo[v] != Integer.MAX_VALUE && distTo[w] > distTo[v] + graph.get(v).get(w)) {
            distTo[w] = distTo[v] + graph.get(v).get(w);
            edgeTo[w] = v;
          }
        }
        unvisitedNodes.remove(unvisitedNodes.indexOf(v));

        min = -1;
        minDist = Integer.MAX_VALUE;
        for(Integer w : unvisitedNodes) {
          if(minDist >= distTo[w]) {
            minDist = distTo[w];
            min = w;
          }
        }
      }
      
    }

    

}

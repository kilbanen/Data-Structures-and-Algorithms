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
 * This class implements the competition using Floyd-Warshall algorithm
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class CompetitionFloydWarshall {
  public static final int INFINITY = 9999999;
  int sA, sB, sC, N, S;
  double[][] graph;

  /**
   * @param filename: A filename containing the details of the city road network
   * @param sA, sB, sC: speeds for 3 contestants
   */
  CompetitionFloydWarshall (String filename, int sA, int sB, int sC){
    this.sA = sA;
    this.sB = sB;
    this.sC = sC;

    File file = new File(filename);
    try{
      Scanner scanner = new Scanner(file);
      N = scanner.nextInt();
      S = scanner.nextInt();
      graph = new double[N][N];
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          if(i == j) graph[i][j] = 0;
          graph[i][j] = INFINITY;
        }
      }
      int v;
      int w;
      double weight;
      for(int i = 0; i < S; i++) {
        v = scanner.nextInt();
        w = scanner.nextInt();
        weight = scanner.nextDouble();
        graph[v][w] = weight;
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
    if(sA < 50 || sB < 50 || sC < 50 || sA > 100 || sB > 100 || sC > 100)
      return -1;

    int slowestSpeed = sA;
    if(slowestSpeed > sB) slowestSpeed = sB;
    if(slowestSpeed > sC) slowestSpeed = sC;

    double[][] d = new double[N][N];
    double longestShortestPath = 0;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        d[i][j] = graph[i][j];
      }
    }
    
    for(int k = 0; k < N; k++) {
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          if(d[i][k] + d[k][j] < d[i][j])
            d[i][j] = d[i][k] + d[k][j];
        }
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(d[i][j] > longestShortestPath)
          longestShortestPath = d[i][j];
      }
    }

    if(longestShortestPath > INFINITY)
      return -1;

    double duration = longestShortestPath * 1000 / slowestSpeed;
    int roundedDuration = (int)Math.ceil(duration);

    return roundedDuration;
  }

}

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
  int sA, sB, sC, numberOfIntersections, numberOfStreets;
  Intersection[] city;

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
        this.numberOfIntersections = scanner.nextInt();
        this.numberOfStreets = scanner.nextInt();
        this.city = new Intersection[numberOfIntersections];
        
        for(int i = 0; i < numberOfIntersections; i++) {
          this.city[i] = new Intersection();
        }
        
        Street street;
        int from;
        int to;
        double length;
        
        for(int i = 0; i < numberOfStreets; i++) {
          from = scanner.nextInt();
          to = scanner.nextInt();
          length = scanner.nextDouble();
          street = new Street(from, to, length);
          this.city[from].addStreet(street);
        }

        scanner.close();
      } catch (FileNotFoundException e) {
        System.err.println("FileNotFoundException caught!");
        e.printStackTrace();
      }
    }

    class Street {
      int from, to;
      double length;

      Street(int from, int to, double length) {
        this.from = from;
        this.to = to;
        this.length = length;
      }
    }

    class Intersection {
      ArrayList<Street> streets;
      int numberOfStreets;

      Intersection() {
        this.streets = new ArrayList<Street>();
        numberOfStreets = 0;
      }

      void addStreet(Street street) {
        this.streets.add(street);
        numberOfStreets++;
      }
      
      Street getStreet(int index) {
        return streets.get(index);
      }
    }

    class SPT {
      int source;
      double[] distTo;
      Street[] streetTo;
      boolean[] intersectionsVisited;

      SPT(int source, Intersection[] city) {
        this.source = source;
        int size = city.length;
        distTo = new double[size];
        streetTo = new Street[size];
        intersectionsVisited = new boolean[size];

        for(int i = 0; i < size; i++) {
          if(i == source)
            distTo[i] = 0;
          else
            distTo[i] = Integer.MAX_VALUE; 
          intersectionsVisited[i] = false;
        }

        int closestIntersectionIndex;
        Intersection closestIntersection;
        for(int i = 0; i < size; i++) {
          closestIntersectionIndex = closestIntersectionFromSource();
          closestIntersection = city[closestIntersectionIndex];
          for(Street street : closestIntersection.streets) {
            relaxStreet(street);
          }
          intersectionsVisited[closestIntersectionIndex] = true;
        }
      }

      void relaxStreet(Street street) {
        int from = street.from;
        int to = street.to;
        if(distTo[to] > distTo[from] + street.length) {
          distTo[to] = distTo[from] + street.length;
          streetTo[to] = street;
        }
        
      }

      int closestIntersectionFromSource() {
        double distance = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < distTo.length; i++) {
          if(distTo[i] < distance && intersectionsVisited[i] == false) {
            distance = distTo[i];
            index = i;
          }
        }
        return index;
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

      SPT[] shortestPathTrees = new SPT[numberOfIntersections];
      double longestShortestPath = 0;
      for(int i = 0; i < numberOfIntersections; i++) {
        shortestPathTrees[i] = new SPT(i, city);
        for(int j = 0; j < numberOfIntersections; j++) {
          if(shortestPathTrees[i].distTo[j] > longestShortestPath)
            longestShortestPath = shortestPathTrees[i].distTo[j];
        }
      }
      int slowestSpeed = sA;
      if (sB < slowestSpeed) slowestSpeed = sB;
      if (sC < slowestSpeed) slowestSpeed = sC;
      double timeRequiredDouble = longestShortestPath * 1000 / slowestSpeed;
      int timeRequiredInt = (int)Math.ceil(timeRequiredDouble);
      return timeRequiredInt;
    }

    

}

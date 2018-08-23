package com.josh.graphs.astar;

import com.josh.graphs.shared.Edge;
import com.josh.graphs.shared.Graph;

import java.util.*;

public class AStarGraph extends Graph {
    private List<StarVertex> vertices;
    private StarVertex start;

    public AStarGraph() {
        init();
    }

    private void init() {
        StarVertex a = new StarVertex("A", 10);
        StarVertex b = new StarVertex("B", 8);
        StarVertex c = new StarVertex("C", 5);
        StarVertex d = new StarVertex("D", 7);
        StarVertex e = new StarVertex("E", 9);
        StarVertex f = new StarVertex("F", 6);
        StarVertex g = new StarVertex("G", 4);
        StarVertex h = new StarVertex("H", 3);
        StarVertex i = new StarVertex("I", 2);
        StarVertex j = new StarVertex("J", 0);
        
        Edge.generateEdge(5, a, b);
        Edge.generateEdge(4, a, e);
        Edge.generateEdge(2, a, d);
        Edge.generateEdge(3, b, c);
        Edge.generateEdge(4, d, c);
        Edge.generateEdge(1, d, e);
        Edge.generateEdge(11, d, f);
        Edge.generateEdge(2, c, f);
        Edge.generateEdge(9, c, g);
        Edge.generateEdge(2, e, f);
        Edge.generateEdge(3, f, g);
        Edge.generateEdge(4, c, h);
        Edge.generateEdge(3, h, g);
        Edge.generateEdge(2, h, i);
        Edge.generateEdge(1, i, j);
        Edge.generateEdge(14, g, j);

        this.vertices = new ArrayList<>();
        this.vertices.add(a);
        this.vertices.add(b);
        this.vertices.add(c);
        this.vertices.add(d);
        this.vertices.add(e);
        this.vertices.add(f);
        this.vertices.add(g);
        this.vertices.add(h);
        this.vertices.add(i);
        this.vertices.add(j);

        this.start = a;
    }

    void findRouteTo(String dest) {
        init();

        Queue<StarVertex> verticesToEvaluate = new PriorityQueue<>(Comparator.comparingInt(StarVertex::getDistanceHeuristic));
        verticesToEvaluate.add(this.start);

        while (!verticesToEvaluate.isEmpty()) {
            StarVertex current = verticesToEvaluate.poll();
            if (current == null) {
                continue;
            }

            if (current.getData().equals(dest)) {
                printRoute(current);
                System.out.println("Distance: " + current.getDistance());
                break;
            }

            for (StarVertex neighbor : current.getStarNeighbors()) {
                if (neighbor.isVisited()) {
                    continue;
                }

                Edge currentEdge = neighbor.getEdge(current);

                int neighborDistanceFromCurrent = current.getDistanceWithoutEuclideanHeuristic() + currentEdge.getWeight() + neighbor.getEuclideanDistance();
                if (neighbor.distanceNotCalculatedYet() || neighborDistanceFromCurrent < neighbor.getDistance()) {
                    neighbor.setDistance(neighborDistanceFromCurrent);
                    neighbor.setOrigin(current);
                }

                if (!verticesToEvaluate.contains(neighbor)) {
                    verticesToEvaluate.add(neighbor);
                }
            }

            current.setVisited(true);
        }
    }
}

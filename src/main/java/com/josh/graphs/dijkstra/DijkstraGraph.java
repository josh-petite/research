package com.josh.graphs.dijkstra;

import com.josh.graphs.shared.Edge;
import com.josh.graphs.shared.Graph;
import com.josh.graphs.shared.Vertex;

import java.util.*;

public class DijkstraGraph extends Graph {
    private List<Vertex> vertices;
    private Vertex start;

    public DijkstraGraph() {
        init();
    }

    private void init() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");
        Vertex i = new Vertex("I");
        Vertex j = new Vertex("J");

        Edge.generateEdge(5, a, b);
        Edge.generateEdge(4, a, e);
        Edge.generateEdge(2, a, d);
        Edge.generateEdge(3, b, c);
        Edge.generateEdge(7, d, c);
        Edge.generateEdge(1, d, e);
        Edge.generateEdge(11, d, f);
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

        Queue<Vertex> verticesToEvaluate = new PriorityQueue<>(Comparator.comparingInt(Vertex::getDistance));
        verticesToEvaluate.add(this.start);

        while (!verticesToEvaluate.isEmpty()) {
            Vertex current = verticesToEvaluate.poll();
            if (current == null) {
                continue;
            }

            if (current.getData().equals(dest)) {
                printRoute(current);
                System.out.println("Distance: " + current.getDistance());
                break;
            }

            for (Vertex neighbor : current.getNeighbors()) {
                if (neighbor.isVisited()) {
                    continue;
                }

                Edge currentEdge = neighbor.getEdge(current);

                int newDistance = current.getDistance() + currentEdge.getWeight();
                if (neighbor.getDistance() == 0 || newDistance < neighbor.getDistance()) {
                    neighbor.setDistance(newDistance);
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
package com.josh.graphs.dijkstra;

public class Dijkstra {
    public static void main(String[] args) {
        DijkstraGraph g = new DijkstraGraph();

        g.findRouteTo("G");

        System.out.println();

        g.findRouteTo("J");
    }
}

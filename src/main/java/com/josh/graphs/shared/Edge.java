package com.josh.graphs.shared;

public class Edge {
    private Integer weight;
    private Vertex one;
    private Vertex two;

    public Edge(Integer weight, Vertex one, Vertex two) {
        this.weight = weight;
        this.one = one;
        this.two = two;

        this.one.addEdge(this);
        this.two.addEdge(this);
    }

    public Vertex getOther(Vertex vertex) {
        return this.one == vertex ? this.two : this.one;
    }

    @Override
    public String toString() {
        return String.format("%s --- %s (%s)", this.one.getData(), this.two.getData(), this.weight);
    }

    public int getWeight() {
        return this.weight;
    }

    public static void generateEdge(Integer weight, Vertex one, Vertex two) {
        new Edge(weight, one, two);
    }
}

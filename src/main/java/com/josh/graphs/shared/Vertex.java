package com.josh.graphs.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vertex {

    private List<Edge> edges = new ArrayList<>();

    private boolean visited;
    private int distance;

    private String data;
    private Vertex origin;

    public Vertex(String data) {
        this.data = data;
    }

    public List<Vertex> getNeighbors() {
        List<Vertex> neighbors = new ArrayList<>();

        for (Edge e : this.edges) {
            neighbors.add(e.getOther(this));
        }

        return neighbors;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", this.data,
                getNeighbors().stream().map(v -> v.data).collect(Collectors.joining()),
                this.distance);
    }

    public Edge getEdge(Vertex current) {
        for (Edge e : this.edges) {
            if (current.getEdges().contains(e)) {
                return e;
            }
        }

        return null;
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getOrigin() {
        return this.origin;
    }

    public void setOrigin(Vertex origin) {
        this.origin = origin;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public String getData() {
        return this.data;
    }

    public boolean distanceNotCalculatedYet() {
        return this.distance == 0;
    }

    public int getDistanceForReport() {
        return this.distance;
    }
}

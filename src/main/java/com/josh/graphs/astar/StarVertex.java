package com.josh.graphs.astar;

import com.josh.graphs.shared.Edge;
import com.josh.graphs.shared.Vertex;

import java.util.ArrayList;
import java.util.List;

public class StarVertex extends Vertex {

    private final int euclideanDistance;

    public StarVertex(String data, int euclideanDistance) {
        super(data);
        this.euclideanDistance = euclideanDistance;
    }

    public int getDistanceHeuristic() {
        return getDistance() + this.euclideanDistance;
    }

    public List<StarVertex> getStarNeighbors() {
        List<StarVertex> neighbors = new ArrayList<>();

        for (Edge e : super.getEdges()) {
            neighbors.add((StarVertex) e.getOther(this));
        }

        return neighbors;
    }

    public int getDistanceWithoutEuclideanHeuristic() {
        return super.getDistance();
    }

    @Override
    public int getDistance() {
        return super.getDistance() + euclideanDistance;
    }

    public int getEuclideanDistance() {
        return this.euclideanDistance;
    }

    @Override
    public boolean distanceNotCalculatedYet() {
        return this.getDistance() == this.getEuclideanDistance();
    }
}

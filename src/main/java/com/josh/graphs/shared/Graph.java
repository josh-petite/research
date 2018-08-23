package com.josh.graphs.shared;

import java.util.Stack;

public abstract class Graph {

    protected void printRoute(Vertex current) {
        Stack<Vertex> route = new Stack<>();

        while(current != null) {
            route.push(current);
            current = current.getOrigin();
        }

        System.out.print("Route: ");

        while (!route.empty()) {
            Vertex v = route.pop();

            System.out.print(String.format("%s(%s)%s", v.getData(), v.getDistanceForReport(), route.empty() ? "" : " -> "));
        }

        System.out.println();
    }
}

package org.example.classes;

public class Aresta {
    private Double value;
    private Vertice exitVertex;
    private Vertice arrivalVertex;

    public Double getValue() {
        return value;
    }
    public Vertice getExitVertex() {
        return exitVertex;
    }
    public Vertice getArrivalVertex() {
        return arrivalVertex;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public void setExitVertex(Vertice exitVertex) {
        this.exitVertex = exitVertex;
    }
    public void setArrivalVertex(Vertice arrivalVertex) {
        this.arrivalVertex = arrivalVertex;
    }
    
}

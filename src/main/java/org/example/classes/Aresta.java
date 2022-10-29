package org.example.classes;

public class Aresta {
    private String value;
    private Vertice exitVertex;
    private Vertice entryVertex;

    public String getValue() {
        return value;
    }
    public Vertice getExitVertex() {
        return exitVertex;
    }
    public Vertice getEntryVertex() {
        return entryVertex;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public void setExitVertex(Vertice exitVertex) {
        this.exitVertex = exitVertex;
    }
    public void setEntryVertex(Vertice entryVertex) {
        this.entryVertex = entryVertex;
    }
    
}

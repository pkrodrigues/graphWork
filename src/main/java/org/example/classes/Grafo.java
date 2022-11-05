package org.example.classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Grafo {
    private Integer graphType; 
    private Boolean isWeighted; 
    private ArrayList<Aresta> edgesList = new ArrayList<Aresta>();
    private ArrayList<Vertice> vertexList = new ArrayList<Vertice>();
    
    public Boolean graphWeighted(String value)
    {
        if(value.equals("S") || value.equals("s"))
        {
            this.isWeighted = true;
        } 
        else if(value.equals("N") || value.equals("n")){
            this.isWeighted = false;
        }

        return isWeighted;
    }

    public String listVertex(){
        String print = "";
        for (Vertice vertice : vertexList) {
            print += " \n " + vertice.getNameVertex();
        }
        return print;
    }

    public String listEdges() {
        String print = "";
        for(Aresta aresta : edgesList){
            if(getIsWeighted()){
                print += "("+aresta.getExitVertex().getNameVertex()+"-"+aresta.getArrivalVertex().getNameVertex()+")"+ "- Valor: "+aresta.getValue()+"\n";
            } else {
                print += "("+aresta.getExitVertex().getNameVertex()+"-"+aresta.getArrivalVertex().getNameVertex()+")";
            }		
        }
        return print;
    }

    public void addVertex(){
        String exit = "S";   
        do{
            
            //Vertice cadastrados 
            String see = JOptionPane.showInputDialog("Lista de Vertices:" + listVertex()   + "\n Digite o vertice:");
            
            //Cadastrar novo vértice
            Vertice v = new Vertice();
            v.setNameVertex(see);

            // Adcionar o novo vertice no Arraz
            vertexList.add(v);

            //Deseja cadastrar mais vértices
            exit = JOptionPane.showInputDialog("Deseja cadastrar mais ?\n"+ "Digite N para sair\n"+"Digite S para continuar");
        }while(exit.equals("S") || exit.equals("s"));
    }

    //Aresta(Edges)
    public void addEdges(Boolean isValued){
        String exit = "S";

        // String edgesNames = "";

        do {
            //Aresta informada ou digitada
            String typedEdge = JOptionPane.showInputDialog("Lista de vertices:" + listVertex() + "\nLista de arestas:"+ listEdges() + "\n Informe as arestas separadas por '-' informando primeiro o ponto de saída e depois o ponto de chegada.\n Ex.: v1-v2");

            // Separando em valores individuais
            String[] parDeVertice = typedEdge.split("-|-\\s");

            Aresta aresta = new Aresta();

            for (Vertice vertice : vertexList) {
                if(vertice.getNameVertex().equalsIgnoreCase(parDeVertice[0])){
                    aresta.setExitVertex(vertice);
                }
                if(vertice.getNameVertex().equalsIgnoreCase(parDeVertice[1])){
                    aresta.setArrivalVertex(vertice);
                }
            }

			// se o grafo for valorado pede o valor da aresta
            if(getIsWeighted()){
                String edgeValue = JOptionPane.showInputDialog("Qual o valor da aresta " + typedEdge + "?");
                if(edgeValue.equals("")){
                    edgeValue = "0";
                }
                aresta.setValue(Double.parseDouble(edgeValue));
            }
            //Adicionar no Arralist
            edgesList.add(aresta);

            exit = JOptionPane.showInputDialog("Deseja cadastrar mais ?\n"+ "Digite N para sair\n"+"Digite S para continuar");
        } while (exit.equals("S") || exit.equals("s"));

    }
    public void printListEdegs(){
        System.out.println("");
        System.out.println("-------------Lista de Arestas-------------");
        for (Aresta aresta : edgesList) {
            System.out.println("Saída: "+aresta.getExitVertex().getNameVertex()+" | ");
            System.out.println("Chegada:"+aresta.getArrivalVertex().getNameVertex()+" | ");
            if(getIsWeighted()){
                System.out.println("    "+aresta.getValue()+"    "+"\n");
            }else{
                System.out.println("---- Grafo não valorado ----\n");
            }
        }
    }
    public void printListAdjacencia() {
        System.out.println("\n-------------Lista de Adjacência-------------");
        for(Vertice vertice : vertexList){
            System.out.println(vertice.getNameVertex());
            for(Aresta aresta : edgesList){
                // se vertice de saida for igual ao vertice atual da lista mostra o de chegada
                if(aresta.getExitVertex().getNameVertex().equals(vertice.getNameVertex()){
                    System.out.println("->"+aresta.getArrivalVertex().getNameVertex());
                    // se não mostra o vertice de saída apenas - tipo de grafo deve ser (1) = não orientado
                }else if(this.getGraphType() == 1 && aresta.getArrivalVertex().getNameVertex().equals(vertice.getNameVertex())){
                    System.out.println("->"+aresta.getArrivalVertex().getNameVertex());
                }
            }
            System.out.println("---------------------------------");
        }
          
    }

    public Integer getGraphType() {
        return graphType;
    }

    public void setGraphType(Integer graphType) {
        this.graphType = graphType;
    }

    public Boolean getIsWeighted() {
        return isWeighted;
    }

    public void setIsWeighted(Boolean isWeighted) {
        this.isWeighted = isWeighted;
    }

    public ArrayList<Aresta> getEdgesList() {
        return edgesList;
    }

    public void setEdgesList(ArrayList<Aresta> edgesList) {
        this.edgesList = edgesList;
    }

    public ArrayList<Vertice> getVertexList() {
        return vertexList;
    }

    public void setVertexList(ArrayList<Vertice> vertexList) {
        this.vertexList = vertexList;
    }

    
}

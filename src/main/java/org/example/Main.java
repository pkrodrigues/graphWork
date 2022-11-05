package org.example;



import javax.swing.JOptionPane;

import org.example.classes.*;

public class Main {
    public static void main(String[] args) {
        
        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo de Grafo\n 1 - Não orientado | 2 - Orientado"));

        Grafo g = new Grafo();

        g.setGraphType(tipo);

        g.addVertex();

        String valorado = JOptionPane.showInputDialog("Grafo valorado? Digite S (Para sim) ou N (Para não)");
		Boolean isValor = g.graphWeighted(valorado.toUpperCase());
        g.setIsWeighted(isValor);

        g.addEdges(isValor);

        g.printListEdegs();



    }
}
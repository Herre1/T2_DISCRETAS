package camino.corto;

import java.util.Scanner;
import javax.swing.*;
//QUEDO MUY CORTO XD NO SE QUE LE QUIERAN AÑADIR 
//AGREGENLE UNA EXCEPTION POR SI EL DESTINO NO EXISTE

public class CaminoCorto {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        Scanner lector = new Scanner(System.in);
        String[] n = new String[20];

        n[0] = "Cafeteria Central";
        n[1] = "Cafeteria Snack";
        n[2] = "Cafeteria Tostao";
        n[3] = "Cafeteria del L";
        n[4] = "Cafeteria Bienestar";
        n[5] = "Edificio A";
        n[6] = "Edificio B";
        n[7] = "Edificio C";
        n[8] = "Edificio D";
        n[9] = "Edificio E";
        n[10] = "Edificio F";
        n[11] = "Edificio G";
        n[12] = "Edificio H";
        n[13] = "Edificio I";
        n[14] = "Auditorio Manuelita";
        n[15] = "Auditorio Banco Occidente";
        n[16] = "Auditorio Argos";
        n[17] = "Auditorio Varela";
        n[18] = "Auditorio Delima";
        n[19] = "Auditorio Alfonso Borrero";

        clsCaminocorto g = new clsCaminocorto(n);

        g.agregarRuta("Edificio A", "Cafeteria Central", 4);
        g.agregarRuta("Edificio A", "Auditorio Alfonso Borrero", 1);
        g.agregarRuta("Edificio A", "Edificio B", 2);

        g.agregarRuta("Edificio B", "Cafeteria Snack", 5);
        g.agregarRuta("Edificio B", "Auditorio Varela", 3);
        g.agregarRuta("Edificio B", "Edificio I", 10);

        g.agregarRuta("Edificio C", "Cafeteria Bienestar", 10);
        g.agregarRuta("Edificio C", "Auditorio Banco Occidente", 6);
        g.agregarRuta("Edificio C", "Edificio B", 9);

        g.agregarRuta("Edificio D", "Auditorio Manuelita", 1);
        g.agregarRuta("Edificio D", "Cafeteria del L", 3);
        g.agregarRuta("Edificio D", "Edificio E", 6);

        g.agregarRuta("Edificio E", "Cafeteria Snack", 7);
        g.agregarRuta("Edificio E", "Auditorio Argos", 2);
        g.agregarRuta("Edificio E", n[13], 12);

        g.agregarRuta("Edificio F", "Cafeteria Tostao", 4);
        g.agregarRuta("Edificio F", "Auditorio Alfonso Borrero", 8);
        g.agregarRuta("Edificio F", "Auditorio Delima", 9);

        g.agregarRuta("Edificio G", "Cafeteria Bienestar", 11);
        g.agregarRuta("Edificio G", "Auditorio Delima", 16);
        g.agregarRuta("Edificio G", "Edificio E", 12);

        g.agregarRuta("Edificio H", "Cafeteria Tostao", 10);
        g.agregarRuta("Edificio H", "Auditorio Banco Occidente", 3);
        g.agregarRuta("Edificio H", "Edificio A", 8);

        g.agregarRuta("Edificio I", "Cafeteria Central", 19);
        g.agregarRuta("Edificio I", "Auditorio Varela", 2);
        g.agregarRuta("Edificio I", "Edificio H", 2);

        // IMPRIMIR LA MATRIZ DEL GRAFO
        g.imprimirGrafoMatriz();

        // IMPRIMIR LA LISTA DE LUGARES POSIBLES
        System.out.println("Esta es la lista de lugares disponibles : \n");
        for (int i = 0; i < n.length; i++) {
            System.out.println(i + " " + n[i]);
            // Se imprime uno por uno jaja
            // JOptionPane.showMessageDialog(jFrame, i + " " + n[i]);
        }

        String origen = JOptionPane.showInputDialog(jFrame, "Escriba el origen:");
        String fin = JOptionPane.showInputDialog(jFrame, "Escriba el destino:");

        String respuesta = g.encontrarRutaMinimaDijkstra(origen, fin);
        JOptionPane.showMessageDialog(jFrame, respuesta);
    }

}

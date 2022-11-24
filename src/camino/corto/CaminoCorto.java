package camino.corto;

import java.util.Scanner;
import javax.swing.*;

//QUEDO MUY CORTO XD NO SE QUE LE QUIERAN AÑADIR 
//AGREGENLE UNA EXCEPTION POR SI EL DESTINO NO EXISTE

public class CaminoCorto {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        Scanner lector = new Scanner(System.in);
        String[] n = new String[51];

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
        n[14] = "Edificio O";
        n[15] = "Edificio H";
        n[16] = "Edificio J";
        n[17] = "Edificio K";
        n[18] = "Auditorio Manuelita";
        n[19] = "Auditorio Banco Occidente";
        n[20] = "Auditorio Argos";
        n[21] = "Auditorio Varela";
        n[22] = "Auditorio Delima";
        n[23] = "Auditorio Alfonso Borrero";
        n[24] = "Taller diseño";
        n[25] = "Cancha Futbol 11";
        n[26] = "Cancha Futbol 6";
        n[27] = "Gym";
        n[28] = "Piscina";
        n[29] = "Plaza mayor";
        n[30] = "Porteria Principal";
        n[31] = "Porteria lateral";
        n[32] = "Salon Piano";
        n[33] = "Salon canto";
        n[34] = "Salon vocal";
        n[35] = "Salon guitarra";
        n[36] = "Parqueaderos";
        n[37] = "Teatrino";
        n[38] = "Plazoleta Bienestar";
        n[39] = "Plazuela de estudiantes";
        n[40] = "111G";
        n[41] = "112G";
        n[42] = "113G";
        n[43] = "114G";
        n[44] = "114G";
        n[45] = "115G";
        n[46] = "116G";
        n[47] = "117G";
        n[48] = "118G";
        n[49] = "119G";
        n[50] = "120G";

        clsCaminocorto g = new clsCaminocorto(n);

        g.agregarRuta("Edificio A", "Cafeteria Central", 4);
        g.agregarRuta("Edificio A", "Auditorio Alfonso Borrero", 1);
        g.agregarRuta("Edificio A", "Edificio B", 2);
        g.agregarRuta("Edificio A", "112G", 5);

        g.agregarRuta("Edificio B", "Cafeteria Snack", 5);
        g.agregarRuta("Edificio B", "Auditorio Varela", 3);
        g.agregarRuta("Edificio B", "Edificio I", 10);
        g.agregarRuta("Edificio B", "Teatrino", 4);

        g.agregarRuta("Edificio C", "Cafeteria Bienestar", 10);
        g.agregarRuta("Edificio C", "Auditorio Banco Occidente", 6);
        g.agregarRuta("Edificio C", "Edificio B", 9);
        g.agregarRuta("Edificio C", "Teatrino", 2);

        g.agregarRuta("Edificio D", "Auditorio Manuelita", 1);
        g.agregarRuta("Edificio D", "Cafeteria del L", 3);
        g.agregarRuta("Edificio D", "Edificio E", 6);
        g.agregarRuta("Edificio D", "Teatrino", 10);

        g.agregarRuta("Edificio E", "Cafeteria Snack", 7);
        g.agregarRuta("Edificio E", "Auditorio Argos", 2);
        g.agregarRuta("Edificio E", "Edificio F", 12);
        g.agregarRuta("Edificio E", "Teatrino", 12);

        g.agregarRuta("Edificio F", "Cafeteria Tostao", 4);
        g.agregarRuta("Edificio F", "Auditorio Alfonso Borrero", 8);
        g.agregarRuta("Edificio F", "Auditorio Delima", 9);
        g.agregarRuta("Edificio F", "Gym", 2);

        g.agregarRuta("Edificio G", "Cafeteria Bienestar", 11);
        g.agregarRuta("Edificio G", "Auditorio Delima", 16);
        g.agregarRuta("Edificio G", "Edificio E", 12);
        g.agregarRuta("Edificio G", "Gym", 2);

        g.agregarRuta("Edificio H", "Cafeteria Tostao", 10);
        g.agregarRuta("Edificio H", "Auditorio Banco Occidente", 3);
        g.agregarRuta("Edificio H", "Edificio A", 8);
        g.agregarRuta("Edificio H", "Piscina", 2);

        g.agregarRuta("Edificio I", "Cafeteria Central", 19);
        g.agregarRuta("Edificio I", "Auditorio Varela", 2);
        g.agregarRuta("Edificio I", "Edificio H", 2);

        g.agregarRuta("Edificio O", "Piscina", 8);
        g.agregarRuta("Edificio O", "Salon vocal", 5);
        g.agregarRuta("Edificio O", "Teatrino", 4);

        g.agregarRuta("Edificio H", "111G", 7);
        g.agregarRuta("Edificio H", "Plazuela de estudiantes", 10);
        g.agregarRuta("Edificio H", "Piscina", 2);

        g.agregarRuta("Edificio J", "114G", 7);
        g.agregarRuta("Edificio J", "Taller diseño", 10);
        g.agregarRuta("Edificio J", "Cancha Futbol 11", 2);

        g.agregarRuta("Edificio K", "112G", 7);
        g.agregarRuta("Edificio K", "Cancha Futbol 6", 10);
        g.agregarRuta("Edificio K", "Cafeteria del L", 2);

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

        // String origen = "Edificio B";
        // String fin = "Cafeteria Central";

        String respuesta = g.encontrarRutaMinimaDijkstra(origen, fin);
        JOptionPane.showMessageDialog(jFrame, respuesta);
    }

}

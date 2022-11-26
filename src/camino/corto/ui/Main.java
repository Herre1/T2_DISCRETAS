package ui;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

import Busqueda.diksjtra;
import Busqueda.kruskal;
import GrafosImplementacion.GenerarGrafos.GrafoNDP;
import GrafosImplementacion.MetodosBusqueda.Kruskal;

//QUEDO MUY CORTO XD NO SE QUE LE QUIERAN AÑADIR 
//AGREGENLE UNA EXCEPTION POR SI EL DESTINO NO EXISTE

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        Scanner lector = new Scanner(System.in);
        String[] n = new String[51];

        

/*
 		//IMPLEMENTACION DE KRUSKAL CON UN GRAFO GENERADO
		try {
        GrafoNDP grafoK = new GrafoNDP("grafo.in");
        grafoK.coloreoSecuencial(10);
		grafoK.coloreoWelshPowell(10);
		grafoK.coloreoMatula(10);
        Kruskal kruskal = new Kruskal(grafoK);
        kruskal.ejecutar();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }		
 */



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

        diksjtra g = new diksjtra(n);
        kruskal k = new kruskal(0, n);

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
        String metodo = JOptionPane.showInputDialog(jFrame,
                "¿Que metodo de busqueda desea usar? \n1.Diksjtra  \n2.Kruskal");

        if (metodo.equals("1")) {

            boolean salir = false;

            while (salir == false) {
                String menu = JOptionPane.showInputDialog(jFrame,
                        "Bienvenido A Nombre: \n 1. Insertar un punto y su arista  \n2. Buscar ruta minima \n3. Buscar ruta maxima \n4. Mostrar posibles caminos \n5.Salir");

                switch (menu) {
                    case "1":
                        
                        System.out.println("Escriba el nombre del lugar");
                        String agregado = lector.nextLine();

                        if (n.length<51){
                        System.out.println("Error el mapa no puede tomar mas puntos");
                        } else {
                        int i = n.length;
                        n[i] = agregado;    
                        }
                        
                        String destinoAgregado = JOptionPane.showInputDialog("Escriba la conexion que tendra el lugar:");
                        int pesoArista = Integer.parseInt(JOptionPane.showInputDialog("Escriba la distancia de la conexion:"));
                        g.agregarRuta(agregado, destinoAgregado, pesoArista);
                        break;

                    case "2":
                        String origen = JOptionPane.showInputDialog("Escriba el origen:");
                        String fin = JOptionPane.showInputDialog("Escriba el destino:");
                        

                        System.out.println(origen);
                        System.out.println(fin);
                        String respuesta = g.encontrarRutaMinimaDijkstra(origen, fin);
                        JOptionPane.showMessageDialog(jFrame, respuesta);
                        break;

                    case "3":
                        origen = JOptionPane.showInputDialog("Escriba el origen:");
                        
                        fin = JOptionPane.showInputDialog("Escriba el destino:");
                        

                        respuesta = g.encontrarRutaMaximaDijkstra(origen, fin);
                        JOptionPane.showMessageDialog(jFrame, respuesta);
                        break;

                    case "4":

                        break;

                    case "5":
                        JOptionPane.showMessageDialog(jFrame, g, menu, 0);
                        salir = true;
                        break;
                    default:
                        break;
                }
            }
//PARA KRUSKAL SE USAN LOS NUMEROS , NO LOS NOMBRES
        } else if (metodo.equals("2")) {

            boolean salir = false;

            while (salir == false) {
                String menu = JOptionPane.showInputDialog(jFrame,
                        "Bienvenido A Nombre: \n 1. Insertar un punto y su arista  \n2. Buscar ruta minima \n3. Verificar si todos los caminos estan conectados \n4. Mostrar si es posible alcanzar la ruta \n5.Salir");

                switch (menu) {
                    case "1":
                        String agregado = JOptionPane.showInputDialog(jFrame, "Escriba el nombre del lugar");
                        int i = n.length;
                        n[i] = agregado;
                        String destinoAgregado = JOptionPane.showInputDialog(jFrame,
                                "Escriba la conexion que tendra el lugar:");
                        int pesoArista = Integer
                                .parseInt(JOptionPane.showInputDialog(jFrame, "Escriba la distancia de la conexion:"));

                        k.AgregarRutaKruskal(agregado, destinoAgregado, pesoArista);
                        break;

                    case "2":
                        // String origen = JOptionPane.showInputDialog(jFrame, "Escriba el origen:");
                        // String fin = JOptionPane.showInputDialog(jFrame, "Escriba el destino:");
                        k.Kruskals();
                        break;

                    case "3":
                        pesoArista = Integer.parseInt(JOptionPane.showInputDialog(jFrame, "Escriba la conexion a evaluar:"));
                        Boolean respuesta = k.allconnect(pesoArista);
                        JOptionPane.showMessageDialog(jFrame, respuesta);
                        break;

                    case "4":
                        // Falta añadir por nombre no posicion
                        int origen = Integer.parseInt(JOptionPane.showInputDialog(jFrame, "Escriba el origen de la conexion:"));
                        int fin = Integer.parseInt(JOptionPane.showInputDialog(jFrame, "Escriba el destino de la conexion:"));
                        pesoArista = Integer.parseInt(JOptionPane.showInputDialog(jFrame, "Escriba el peso de la conexion a evaluar:"));

                        k.can_reach(origen, fin, pesoArista);
                        break;

                    case "5":
                        JOptionPane.showMessageDialog(jFrame, g, menu, 0);
                        salir = true;
                        break;
                    default:
                        break;
                }
            }

        } else {

        }

        // String origen = "Edificio B";
        // String fin = "Cafeteria Central";

    }

    

}

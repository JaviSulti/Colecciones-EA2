package coo.ea1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class COOEA2 {

    public static void main(String[] args) {

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Bienvenido/a al listador de Razas. Ud. debera ingresar razas de perros hasta que decida lo contrario.");
        System.out.println("----------------------------------------------------------------------------------------------------");
        int i = 1;
        String razza;
        ArrayList<String> listaDeRazas = new ArrayList();

        do {
            razza = ingresarUnaRaza(i);
            listaDeRazas.add(razza);
            i++;
        } while (consultarSiContinua() == true);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("La lista de razas ingresadas es: ");
        mostrarArrayList(listaDeRazas);
        System.out.println("----------------------------------------------------------------------------------------------------");

        ArrayList<String> listaEliminada = eliminarPerro(listaDeRazas);
        mostrarArrayList(listaEliminada);
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public static String ingresarUnaRaza(int i) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Por favor, ingrese la raza del perro numero " + i + " > ");
        String raza = teclado.next();
        return raza;
    }

    public static Boolean consultarSiContinua() {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        System.out.print(" - Si desea agregar otra raza, por favor indique si. De lo contrario indique no > ");
        String respuesta = teclado.next();

        while (!respuesta.equals("si") && !respuesta.equals("no")) {
            System.out.println("");
            System.out.print("ATENCION Ingreso una respuesta equivocada, por favor, vuelva a indicar si o no > ");
            System.out.println("");
            respuesta = teclado.next();
        }
        return respuesta.equals("si");
    }

    public static void mostrarArrayList(ArrayList listaDeRazas) {
        listaDeRazas.forEach((aux) -> {
            System.out.println("- " + aux);
        });
    }
    
    public static ArrayList eliminarPerro (ArrayList listaDeRazas){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Por favor, ingrese la raza de perro que desea eliminar > ");
        String eliminarRaza = teclado.next();
        Iterator <String> it = listaDeRazas.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().equals(eliminarRaza)) {
                it.remove();
                i++;
            }            
        }
        
        if (i > 0) {
            System.out.println("La raza " + eliminarRaza + " ha sido encontrada " + i + " veces. Por lo que sera eliminada de la lista, quedando: ");
        } else {
            System.out.println("Como la raza " + eliminarRaza + " no ha sido encontrada, no habra cambios en la lista, siendo esta: ");
        }
        
        return listaDeRazas;
    }

}

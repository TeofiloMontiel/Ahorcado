/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pc
 */
public class Ahorcado {

    private static ArrayList ingresadas;

    public static void main(String[] args) {
        Scanner intro = new Scanner(System.in);
        int iteracion;
        do {
            iteracion = 0;
            ingresadas = new ArrayList();
            Juego.setPalabra();
            Juego.InicializarJuego();
            System.out.println("Para la revision del programa, la palabra que le toco es "+ Juego.getPalabra());
            System.out.println("Vida inicial = "+Juego.getVida());
            do {
                System.out.println("\nIngrese una letra");
                String letra = ValidadorEntrada();
                Juego.Comprobar(letra);
                Juego.MostrarJuego();
            } while (Juego.getVida() > 0);
            System.out.println("\nFelicidades, usted adivino la palabra");
            do {
                try {
                    System.out.println("¿Desea jugar de nuevo?\n"
                            + "1.- Si |"
                            + " 2.- No");
                    iteracion = intro.nextInt();
                    if (iteracion == 2){
                        System.out.println("Bien, usted saldra del programa");
                    }
                    if (iteracion < 1 || iteracion > 2) {
                        System.out.println("Ingrese una alternativa valida");
                    }
                } catch (Exception e) {
                    System.out.println("Ha ingresado incorrectamente, intentelo de nuevo");
                }
            } while (iteracion < 1 || iteracion > 2);
        } while (iteracion == 1);
    }

    private static String ValidadorEntrada() {
        String letra = null;
        int iteracion = 0;
        Scanner intro = new Scanner(System.in);
        do {
            iteracion = 0;
            do {
                letra = intro.nextLine().toLowerCase();
                if (letra.length() < 1) {
                    System.out.println("No ha ingresado nada, por favor ingrese una letra");
                }
            } while (letra.length() < 1);
            if (!Character.isLetter(letra.charAt(0)) || letra.length() > 1) {
                System.out.println("No ha ingresado correctamente, por favor ingrese UNA letra");
            }
            if (Character.isLetter(letra.charAt(0)) || letra.length() == 1) {
                for (int i = 0; i < ingresadas.size(); i++) {
                    String aux = (String) ingresadas.get(i);
                    if (aux.charAt(0) == letra.charAt(0)) {
                        iteracion = 1;
                    }
                }
                if (iteracion == 1 && Character.isLetter(letra.charAt(0)) && letra.length() == 1) {
                    System.out.println("Usted ya ingreso esta letra, porfavor ingrese otra");
                }
            }
        } while (!Character.isLetter(letra.charAt(0)) || letra.length() > 1 || iteracion == 1);
        ingresadas.add(letra);
        return letra;
    }
}

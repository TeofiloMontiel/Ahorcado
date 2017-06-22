/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.util.ArrayList;

/**
 *
 * @author Pc
 */
public class Juego {

    public static final String[] Palabras = {"Cabello", "Caballo", "Zapallo", "Paradero", "Establo", "Gigante", "Platano", "Patente", "Camarero", "Carreta"};
    public static int Vida;
    private static String Palabra;
    private static ArrayList palabra = new ArrayList();
    private static int TotalAciertos;

    public static int getVida() {
        return Vida;
    }

    public static void setPalabra() {
        Palabra = Palabras[(int) (Math.random() * 9)];
    }

    public static String getPalabra() {
        return Palabra;
    }

    public static void InicializarJuego() {
        palabra.clear();
        for (int i = 0; i < Palabra.length(); i++) {
            palabra.add(i, "_");
        }
        Vida = 50;
        TotalAciertos=0;
    }

    public static void Comprobar(String letra) {
        int acierto = 0;
        for (int i = 1; i < Palabra.length(); i++) {
            if (Palabra.charAt(i) == letra.charAt(0)) {
                palabra.remove(i);
                palabra.add(i, letra);
                acierto++;
                TotalAciertos++;
            }
        }
        String LetraToUpperCase = letra.toUpperCase();
        if (Palabra.charAt(0) == LetraToUpperCase.charAt(0)) {
            palabra.remove(0);
            palabra.add(0, LetraToUpperCase);
            acierto++;
            TotalAciertos++;
        }
        if (acierto == 0) {
            Vida = Vida - 10;
            System.out.println("No ha acertado, usted perdera 10 puntos de vida");
        }else{
            System.out.println("Bien! acertaste");
        }
        if (TotalAciertos==palabra.size()){
        Vida = Vida-Vida;
        }else{
            System.out.println("Su vida actual es "+getVida());
        }
    }

    public static void MostrarJuego() {
        System.out.println("\nLa palabra hasta el momento es: ");
        for (int i = 0; i < palabra.size(); i++) {
            System.out.print(palabra.get(i) + " ");
        }
        System.out.println();
    }
}

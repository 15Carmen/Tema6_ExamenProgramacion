package examen;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Funciones {

    /**
     * Declaramos el scanner como un atributo estático
     */
    static Scanner sc = new Scanner(System.in);

    //Declaramos los atributos estáticos
    /**
     * Atributo donde guardaremos en un array las palabras que el usuario tendrá que adivinar
     */
    static String[] palabras = {"humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna",
            "cabeza", "brazo", "familia"};
    /**
     * Atributo donde guardaremos el número de intentos que tendrá el usuario para adivinar la palabra
     */
    final static int NUMINTENTOS = 7;
    /**
     * Atributo donde guardaremos la palabra secreta que el usuario tendrá que adivinar
     */
    static String palabraSecreta = "";
    /**
     * Atributo donde guardaremos la palabra con las letras que el usuario ha acertado
     */
    static String palabraPista = "";
    /**
     * Atributo donde guardaremos las letras que el usuario no ha acertado
     */
    static String noAcertadas = "";

    //Empezamos a crear los métodos de la clase

    /**
     * Método que almacena en la variable palabraSecreta una palabra aleatoria de las almacenadas en el array palabras
     */
    public static void generaPalabra() {
        //Declaramos las variables
        int posicion;   //Variable donde vamos a guardar una posición aleatoria del array palabras

        //Generamos una posicion aleatoria del array
        posicion = (int) (Math.random() * palabras.length);

        //Indicamos que palabra secreta es igual a una palabra aleatoria del array palabras
        palabraSecreta = palabras[posicion];

        //Rellenamos la variable palabraPista con tantos guiones bajos como letras tenga la palabra secreta
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraPista += "_";
        }
    }

    /**
     * Método que pintará por consola el menu de opciones del usuario y devolverá la opción elegida por el mismo.
     * @return la opción elegida por el usuario.
     */
    public static int menu() {
        //Declaramos las variables
        int opc;    //Variable donde guardaremos la opcion elegida por el usuario

        //Pintamos el menu y guardamos la opcion elegida por el usuario
        System.out.println("""
                Seleccione una de las siguientes opciones:
                [1] Introducir letra
                [2] Introducir palabra
                """);
        opc = sc.nextInt();

        //Devolvemos la opción elegida
        return opc;
    }

    /**
     * Método que recibe la una letra por parámetro y comprobará si esta se encuentra en la palabra secreta
     * @param letra : letra introducida por el usuario por consola.
     */
    public static void compruebaLetra(String letra) {
        //Pasamos la letra introducida por parámetros a minúsculas para no tener problemas al comparar letras
        letra = letra.toLowerCase();

        //Si la letra introducida por el usuario se encuentra en la palabra secreta
        if (palabraSecreta.contains(letra)) {
            //Recorremos la palabra secreta
            for (int i = 0; i < palabraSecreta.length(); i++) {
                //Si la letra de la palabra secreta es igual a la letra introducida por el usuario
                if (palabraSecreta.charAt(i) == letra.charAt(0)) {
                    //La almacenamos en la variable palabraPista
                    palabraPista = palabraPista.substring(0, i) + letra + palabraPista.substring(i + 1);
                }
            }
        } else {    //Si la letra introducida por el usuario no se encuentra en la palabra secreta
            //La almacenamos en la variable noAcertadas
            noAcertadas += letra;
        }
    }


    /**
     * Método que comprueba si la palabra introducida por parámetros es igual que la palabra secreta
     * @param palabra : palabra introducida por el usuario por consola.
     */
    public static void compruebaPalabra(String palabra) {
        //Pasamos la palabra introducida por parámetros a minúsculas para no tener problemas al comparar palabras
        palabra = palabra.toLowerCase();

        //Si la palabra introducida ees igual que la palabra secreta
        if (palabra.equals(palabraSecreta)) {
            //La almacenamos en la palabraPista
            palabraPista = palabra;
        }
    }

    /**
     * Método que pinta por consola las letras usadas pero no acertadas y la palabraPista
     */
    public static void pintarPista() {
        System.out.println("Las letras que no se encuentran en la palabra son: " + noAcertadas);
        System.out.println("Esto es lo que llevas adivinado por ahora: " + palabraPista);
    }


}

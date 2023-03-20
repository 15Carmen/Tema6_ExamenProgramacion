package examen;

import java.util.Scanner;

public class Main {

    //Declaramos el scanner
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Delcaramos las varaibles
        String adivinaPalabra="";                       //Variable que almacenará la palabra que el usuario introduce por consola
        String letra = "";                              //Variable que almacenará la letra que el usuario introduce por consola
        int numeroIntentos = Funciones.NUMINTENTOS;     //Variable que almacenará el número de intentos que tiene el usuario
        String letrasUsadas = "";                       //Variable que almacenará todas las letras que el usuario ha introducido

        //Primero generamos la palabra a adivinar
        Funciones.generaPalabra();

        //Ahora imprimimos la pista
        Funciones.pintarPista();

        //Mientras el jugador no haya adivinado la palabra secreta y el número de intentos sea mayor que 0
        do {
            //Imprimimos el menu y leemos la opción que elige el usuario
            switch (Funciones.menu()){
                //Si elige la opción 1, comprueba si la letra introducida está en la palabra secreta
                case 1:{
                    System.out.println("Introduzca una letra: ");
                    letra = sc.nextLine();

                    Funciones.compruebaLetra(letra);
                    break;
                }
                //Si elige la opción 2, comprueba si la palabra introducida es igual a la palabra secreta
                case 2:{
                    System.out.println("Introduzca una palabra: ");
                    adivinaPalabra = sc.nextLine();

                    Funciones.compruebaPalabra(adivinaPalabra);
                    break;
                }
            }//Fin del switch

            //Imprimimos de nuevo la pista
            Funciones.pintarPista();

            //Le restamos 1 a la variable NUMINTENTOS, siempre y cuando no haya introducido ya esa letra
            if (!letrasUsadas.contains(letra)){
                numeroIntentos--;
                //Añadimos la letra a la variable letrasUsadas
                letrasUsadas += letra;
            }//Fin del if

            //imprimimos cuantos intentos le quedan
            System.out.println("Te quedan: " + numeroIntentos + " intentos");

        }while (!adivinaPalabra.equals(Funciones.palabraSecreta) && numeroIntentos>0);
        //Fin del do-while

        System.out.println();   //Salto de línea estético

        //Si la palabra introducida por el usuario es igual que la palabra secreta mostramos un mensaje de error
        if (adivinaPalabra.equals(Funciones.palabraSecreta)){
            System.out.println("¡¡ENHORABUENA!! HAS ACERTADO");
        } else {     //Si el número de errores es igual a 0, acabamos el juego
            System.out.println("GAME OVER");
        }//Fin del if

        //Cerramos el scanner
        sc.close();

    }//Fin del main





}//Fin de la clase Main
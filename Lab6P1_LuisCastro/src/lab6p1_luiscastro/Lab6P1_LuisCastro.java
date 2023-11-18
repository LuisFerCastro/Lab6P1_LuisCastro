/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_luiscastro;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author lfern
 */
public class Lab6P1_LuisCastro {
static Scanner leer = new Scanner(System.in);
static Random random = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        System.out.println("*****Menu*****");
        System.out.println("1. Conjuntos.");
        System.out.println("2. ¿Cuantos primos tienes? ");
        System.out.println("Cualquier otro numero sale del programa.");
        System.out.println("Ingrese su opcion: ");
        opcion = leer.nextInt();
        
        while(opcion <=2 && opcion >=1){
            switch(opcion){
                case 1:
                    System.out.println("Size SET1: ");
                    int size1 = leer.nextInt();
                    char []SET1 = new char[size1];
                    System.out.println("");
                    System.out.println("Size SET2: ");
                    int size2 = leer.nextInt();
                    char []SET2 = new char[size2];
                    
                    System.out.println("Cadenas generadas: ");
                    SET1 = genRandCharArray(size1);
                    SET2 = genRandCharArray(size2);
                    
                    System.out.print("SET1: ");
                    imprimir(SET1);
                    System.out.println("");
                    System.out.print("SET2: ");
                    imprimir(SET2);
                    System.out.println("");
                    
                    System.out.println("Operaciones.");
                    System.out.println("1. Interseccion.");
                    System.out.println("2. Diferencia.");
                    System.out.println("Ingrese una opcion:");
                    int opcion2 = leer.nextInt();
                    
                    while (opcion2 > 2||opcion2 <1){
                        System.out.println("Opcion invalida. Ingrese de nuevo.");
                        opcion2 = leer.nextInt();
                    }//fin while interno
                    switch(opcion2){
                        case 1:
                            intersection(SET1,SET2);
                            quitar_espacios((intersection(SET1,SET2)));
                        case 2:
                            difference(SET1, SET2);
                            quitar_espacios((difference(SET1,SET2)));
                            System.out.println("");
                            break;
                    }//fin switch interno
                    
                    break;
                case 2:
                    System.out.println("Ingrese el tamaño del arreglo: ");
                    int size = leer.nextInt();
                    while (size < 1){
                        System.out.println("Tiene que ser mayor que 1. Ingrese de nuevo:");
                        size = leer.nextInt();
                    }
                    System.out.println("Ingrese el limite inferior: ");
                    int lim_inf = leer.nextInt();
                    System.out.println("Ingrese el limite superior: ");
                    int lim_sup = leer.nextInt();
                    
                    while(lim_inf >= lim_sup){
                        System.out.println("El limite inferior no puede ser mayor que el superior.");
                        System.out.println("Ingrese de nuevo: ");
                        System.out.println("Limite inferior: ");
                        lim_inf = leer.nextInt();
                        System.out.println("Limite superior: ");
                        lim_sup = leer.nextInt();
                    }
                    int []arreglo = new int[size];
                    System.out.println("Arreglo generado: ");
                    arreglo = genRandArray(size, lim_inf, lim_sup);
                    imprimir_int(arreglo);
                    System.out.println("");
                    
                    System.out.print("No. divisores primos: ");
                    int [] num_divs = new int [size];
                    num_divs = getTotalPrimeCount(arreglo);
                    imprimir_int(num_divs);
                    System.out.println("");
                    
                    break;
            }//fin switch externo
            System.out.println("*****Menu*****");
            System.out.println("1. Conjuntos.");
            System.out.println("2. ¿Cuantos primos tienes? ");
            System.out.println("Cualquier otro numero sale del programa.");
            System.out.println("Ingrese su opcion: ");
        opcion = leer.nextInt();
        }//fin while externo
    }//fin main
    public static void imprimir(char []arreglo){
        for(int i = 0; i < arreglo.length;i++){
            System.out.print("[ "+arreglo[i]+" ]");
        }
    }//fin metodo imprimir
    
    public static void imprimir_int(int []arreglo){
        for(int i = 0; i < arreglo.length;i++){
            System.out.print("[ "+arreglo[i]+" ]");
        }
    }//fin metodo imprimir int
    
    public static void quitar_espacios(char []arreglo){
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i] == '/'){
                continue;
            }else{
                System.out.println("[ "+ arreglo[i]+ " ]");
            }
        }
    }//fin metodo quitar espacios
    
    
    public static char []genRandCharArray(int size){
        char [] temporal = new char [size];
        for(int i = 0; i < size; i++){
            temporal [i] = (char) (random.nextInt((73-65)+1)+65);
        }
        return temporal;
    }//fin metodo genRandCharArray
    
    public static char []intersection(char []arreglo1, char []arreglo2){
        int contador =0;
        char[] temporal = new char[arreglo1.length];
        for (int i = 0; i < temporal.length; i++) {
            temporal[i] = '/';
        }
        for (int i = 0; i < arreglo1.length; i++) {
            for (int j = 0; j < arreglo2.length; j++) {
                if (arreglo2[j] == arreglo1[i]) {
                    contador++;
                }
            }
            if(contador>0){
                temporal[i] = arreglo1[i];
            }
            contador = 0;
        }
        return temporal;
    }//fin metodo intersection
    
    public static char [] difference(char[] arreglo1, char []arreglo2){
       char [] diferencia = new char [arreglo1.length + arreglo2.length];
        return diferencia;
    }//fin metodo difference
    
    public static int []genRandArray(int size, int lim_inf, int lim_sup){
        int [] temporal = new int [size];
        for(int i = 0; i < size; i++){
            temporal[i] = random.nextInt((lim_sup - lim_inf)+1)+ lim_inf;
        }
        return temporal;
    }// fin metodo genRandArray
    
    public static boolean isPrime(int num){
        int accum = 0;
        boolean isPrime;
        for (int i = 1; i <= num; i++){
            if((num%i)==0){
                accum++;
            }
        }
        if(accum == 2){
            isPrime = true;
        }else {
            isPrime = false;
        }
        return isPrime;
    }//fin metodo isPrime
    
    public static int countPrimeFactors(int num){
        int cont_prime_factors = 0;
        boolean primo;
        for(int i = 1; i <= num; i++){
            primo = isPrime(i);
            if(primo == true && (num%i == 0)){
                cont_prime_factors++;
            }
            
        }
        return cont_prime_factors;
    }//fin metodo countPrimeFactros
    
    public static int []getTotalPrimeCount(int[]arreglo){
        int [] temporal = new int [arreglo.length];
        for(int i = 0; i< arreglo.length;i++){
            temporal [i] = countPrimeFactors(arreglo[i]);
        }
        return temporal;
    }// fin metodo getTotalPrimeCount
}//fin de la clase

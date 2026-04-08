package com.nicolas.Pacman.model;
import java.util.Random;
    // Creamos nuestro tipo de variable Direccion 

    public enum Direccion {
    ARRIBA,
    ABAJO,
    IZQUIERDA,
    DERECHA;

    public static final Random i = new Random();

    // vamos a crear un metodo que nos devuelva una direccion al azar

    public static Direccion randomDireccion(){

        // declaramos un numero random y luego asignamos a nuestra variable numero un numero random de 1-4 se le suma uno 
        
        int numero = i.nextInt(4)+1;

        switch (numero) {
            case 1: return ARRIBA;
            case 2: return ABAJO;    
            case 3: return IZQUIERDA;
            case 4: return DERECHA;    
        }
        return null;
    }
}


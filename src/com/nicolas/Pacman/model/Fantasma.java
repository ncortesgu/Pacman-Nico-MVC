package com.nicolas.Pacman.model;
import java.util.ArrayList;
public class Fantasma extends Personaje{
    
// Atributos declarados
private Coordenadas posInicial;
private boolean asustado;   // estado , si estan asustados o normales
private ArrayList<Fantasma> ghost_array;

// Molde para fantasmas / constructor 

public Fantasma(Coordenadas posicion, boolean asustado,Coordenadas posInicial) {

    this.posicion= posicion;
    this.asustado = asustado;
    this.posInicial = posInicial;
}

// constructor para crear a nuestros 4 fantasmas e inicializarlos 

public Fantasma() { // creamos los 4 en la cajita de la mitad 

    this.asustado = false; // parametrizamos y asi podemos cambiar el estado de los 4 con cambiar este boolean (asustado)

    ghost_array = new ArrayList<>(); // generamos el espacio en memoria 

    // en cada indice añadimos un fantasma 
    // Creamos una pocisionActual que puede variar y una pocision inicial fija para cuando los fantasmas mueran y tengan que regresar a base 

    ghost_array.add(new Fantasma(new Coordenadas(10, 7), asustado, new Coordenadas(10, 7)));
    ghost_array.add(new Fantasma(new Coordenadas(10, 8), asustado, new Coordenadas(10, 8)));
    ghost_array.add(new Fantasma(new Coordenadas(11, 7), asustado, new Coordenadas(11, 7)));
    ghost_array.add(new Fantasma(new Coordenadas(11, 8), asustado, new Coordenadas(11, 8)));


}


@Override
public void mover(Direccion direccion) {

    switch(direccion){
 
        case DERECHA : posicion = new Coordenadas(posicion.getY(), posicion.getX()+1); 
            this.direccion_actual = Direccion.DERECHA;

        case IZQUIERDA : posicion = new Coordenadas(posicion.getY(), posicion.getX()-1); 
            this.direccion_actual = Direccion.IZQUIERDA;
        
        case ARRIBA : posicion = new Coordenadas(posicion.getY()+1, posicion.getX()); 
            this.direccion_actual = Direccion.ARRIBA;
        
        case ABAJO : posicion = new Coordenadas(posicion.getY()-1, posicion.getX());
            this.direccion_actual = Direccion.ABAJO;

        }
    
}

public Coordenadas nuevoFantasma(Direccion direccion){

    switch(direccion){
 
        case DERECHA : return new Coordenadas(posicion.getY(), posicion.getX()+1); 
        
            
        case IZQUIERDA : return  new Coordenadas(posicion.getY(), posicion.getX()-1); 
        
        
        case ARRIBA : return  new Coordenadas(posicion.getY()+1, posicion.getX()); 
        
        
        case ABAJO : return  new Coordenadas(posicion.getY()-1, posicion.getX());
        
        }

        return null; // default 
        }

        public void seASustan(){
            this.asustado = true;
        }

        public boolean estadoFantasma(){
            return this.asustado;
        }

        public void fantasmaMuere(int i){ // le pasamos como parametro un indice para saber cual fue el fantasma que murio 
             ghost_array.get(i).posicion = ghost_array.get(i).posInicial;
        }
        
        public int cantidadFantasmas(){
            return ghost_array.size();
        }

        public Coordenadas accederFantasma(int i ){ // nos retorna las coordenadas de algun fantasma en el arreglo 
            return ghost_array.get(i).posicion;
        }

        public Direccion dirActualGhost(){
            return this.direccion_actual;
        }
}




package com.nicolas.Pacman.model;
public class Fantasma extends Personaje{
    
// Atributos declarados

private boolean asustado; 

public Fantasma(Direccion direccion_actual, Coordenadas posicion, Coordenadas spawn) {
        super(direccion_actual, posicion, spawn);
        this.asustado = false;
    }


public void mover(Direccion direccion) {

    int x = this.posicion.getX();
    int y = this.posicion.getY();
    
    switch(direccion){
 
        case DERECHA : this.posicion = new Coordenadas(x+1, y); 
            this.direccion_actual = Direccion.DERECHA;
            break;

        case IZQUIERDA : this.posicion = new Coordenadas(x-1, y); 
            this.direccion_actual = Direccion.IZQUIERDA;
            break;
        
        case ARRIBA : this.posicion = new Coordenadas(x, y-1); 
            this.direccion_actual = Direccion.ARRIBA;
            break;
        
        case ABAJO : this.posicion = new Coordenadas(x, y+1);
            this.direccion_actual = Direccion.ABAJO;
            break;
        }
}

public Coordenadas nuevoFantasma(Direccion direccion){

    int x = this.posicion.getX();
    int y = this.posicion.getY();

    switch(direccion){
 
        case DERECHA : return new Coordenadas(x+1, y); 
        case IZQUIERDA : return  new Coordenadas(x-1, y); 
        case ARRIBA : return  new Coordenadas(x, y-1); 
        case ABAJO : return  new Coordenadas(x, y+1);
}
        return null; 
 }

        public void seASustan(){
            this.asustado = true;
        }

        public boolean Asustados(){
            return this.asustado;
        }

        public void fantasmaMuere( ){ 
              this.posicion = this.spawn;
        }
        
        public Direccion dirActualFantasma(){
            return this.direccion_actual;
        }

        public Coordenadas ubicacion(){
            return this.posicion;
        }
       


}




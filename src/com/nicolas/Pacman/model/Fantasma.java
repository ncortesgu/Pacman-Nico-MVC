package com.nicolas.Pacman.model;
public class Fantasma extends Personaje{
    
// Atributos declarados

private boolean asustado; 
private boolean muerto;
private int tiempoReaparecer ;
private int temporizadorPoder;

public Fantasma(Direccion direccion_actual, Coordenadas posicion, Coordenadas spawn) {
        super(direccion_actual, posicion, spawn);
        this.asustado = false;
        this.muerto  = false;
        this.tiempoReaparecer=0;
        this.temporizadorPoder=0;
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
            this.temporizadorPoder=130;
            this.asustado = true;
        }
        public void temporizadorPoder(){
            if(this.temporizadorPoder > 0) this.temporizadorPoder--;
            if(this.temporizadorPoder == 0) this.asustado = false;
        }

        public boolean Asustados(){
            return this.asustado;
        }
        public boolean muertos(){
            return this.muerto;
        }

        public void fantasmaMuere( ){
                this.tiempoReaparecer = 70;
               this.muerto = true;  
              this.posicion = this.spawn;
               this.asustado= false;

        }
        public void temporizadorSpawn(){
            if(this.tiempoReaparecer > 0) this.tiempoReaparecer--;
            if(this.tiempoReaparecer == 0) this.muerto = false;
        }
        
        public Direccion dirActualFantasma(){
            return this.direccion_actual;
        }

        public Coordenadas ubicacion(){
            return this.posicion;
        }
       


}




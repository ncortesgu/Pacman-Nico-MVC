package com.nicolas.Pacman.model;

public class Pacman extends Personaje {
     
    // Constructor para inicializar las variables
    

    public Pacman(Direccion direccion_actual, Coordenadas posicion, Coordenadas spawn) {
        super(direccion_actual, posicion, spawn);
        
        
    }
    

    public void mover(Direccion direccion) { 

        int x = this.posicion.getX();
        int y = this.posicion.getY();
        
        switch(direccion){
 
        case DERECHA : posicion = new Coordenadas(x+1, y); 
        this.direccion_actual = Direccion.DERECHA; break;
            
        case IZQUIERDA : posicion = new Coordenadas(x-1, y); 
        this.direccion_actual = Direccion.IZQUIERDA; break;

        case ARRIBA : posicion = new Coordenadas(x, y-1); 
        this.direccion_actual = Direccion.ARRIBA; break;

        case ABAJO : posicion = new Coordenadas(x, y+1);
        this.direccion_actual = Direccion.ABAJO; break;
        }
    }

    
        public Coordenadas pacmanFuturo(Direccion direccion){

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

        
        public Coordenadas spawnCoordenadas(){
            return this.spawn;
        }
        public void setPosicion(Coordenadas c) {
            this.posicion = c;
        }
        public Direccion dirActual(){
            return this.direccion_actual;
        }
        public Coordenadas pacmanActual(){
            return this.posicion;
        }

        

        }



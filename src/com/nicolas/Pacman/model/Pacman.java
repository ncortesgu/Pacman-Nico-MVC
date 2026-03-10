package com.nicolas.Pacman.model;

public class Pacman extends Personaje {

    // Atributos vienen por la herencia de la clase personaje  

    // atributo posicionInicial para cuando pacman muera spawnearlo ahi 

    private Coordenadas posInicial;
     
    // Constructor para inicializar las variables 

    public Pacman() { 

        this.posicion = new Coordenadas(1, 1);  
        this.posInicial = new Coordenadas(1, 1); // este atributo va a ser fijo  
    }

    @Override
    public void mover(Direccion direccion) { // cambiamos las coordenadas y actualizamos la direccion actual/ ya que luego la usaremos en caso de que se quiera mover a un muro
        
        switch(direccion){
 
        case DERECHA : posicion = new Coordenadas(posicion.getX()+1, posicion.getY()); 
        this.direccion_actual = Direccion.DERECHA;
        break;
            
        case IZQUIERDA : posicion = new Coordenadas(posicion.getX()-1, posicion.getY()); 
        this.direccion_actual = Direccion.IZQUIERDA;
        break;

        case ARRIBA : posicion = new Coordenadas(posicion.getX(), posicion.getY()-1); 
        this.direccion_actual = Direccion.ARRIBA;
        break;

        case ABAJO : posicion = new Coordenadas(posicion.getX(), posicion.getY()+1);
        this.direccion_actual = Direccion.ABAJO;
        break;
        }
        
    
    }

        // Metodo que nos retorna el futuro pacman  
    
        public Coordenadas pacmanFuturo(Direccion direccion){
            
            switch(direccion){
 
        case DERECHA : return new Coordenadas(posicion.getX()+1, posicion.getY()); 
        
            
        case IZQUIERDA : return  new Coordenadas(posicion.getX()-1, posicion.getY()); 
        
        
        case ARRIBA : return  new Coordenadas(posicion.getX(), posicion.getY()-1); 
        
        
        case ABAJO : return  new Coordenadas(posicion.getX(), posicion.getY()+1);
        
        }

        return null; // default 
        }

        // metodo para retornar la posicion inicial y respawnear a pacman cuando muera

        public Coordenadas spawnCoordenadas(){
            return this.posInicial;
        }

        // necesitamos dejar que juego acceda a la pocision de pacman para que lo haga cruzar los portales
        
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



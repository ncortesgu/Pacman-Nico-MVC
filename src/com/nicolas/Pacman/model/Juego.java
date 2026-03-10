package com.nicolas.Pacman.model;

public class Juego { // Esta va a ser la clase que diriga todo , va a asignar las velocidades a cada personaje ya que conoce tablero fantastma y pacman 

private Pacman pacman;  // conocimiento de pacman 
private Tablero mapa;   // conocimiento de tablero
private Fantasma ghost; // conocimiento de fantasma 
private Direccion direcciones; // le damos conocimiento a juego de la clase direccion para poder hacer el movimiento random de los fantasmas

// otros atributos necesarios para nuestros metodos



public Juego(){ // le damos vida a nuestros atributos  (inicializamos) 

this.pacman = new Pacman();
this.mapa = new Tablero();
this.ghost = new Fantasma();

}

// METODO PARA QUE PANEL PUEDA ACCEDER A METODOS DE TABLERO
public Tablero getMapa() {
    return mapa;
}
public Pacman getPacman() {
    return pacman;
}
public Fantasma getGhost() {
    return ghost;
}
private void win(){ // metodo para verificar victoria en cada frame

    if(mapa.gana()){
        System.out.println("VICTORIA VICTORIAAA");
    }
}

private void pacmanComePoder(){
    if(mapa.hayPoder(pacman.pacmanActual())){ // si hay un poder donde esta el pacman actual los fantasmas se asustan 
        ghost.seASustan();
    }
}
// vamos a hacer el metodo que nos permita cruzar los portales
private void cruzarPortales(Coordenadas c){

        Coordenadas cruzoDerecha  = new Coordenadas(1,c.getY()); // se calculan las coordenadas dependiendo de que portal sea
        Coordenadas cruzoIzquierda  = new Coordenadas(20,c.getY());

    if(mapa.hayPortalDerecha(c) && !mapa.noValido(cruzoDerecha)){ // se verifica si fue portal derecha y si la posicion calculada es valida dentro del mapa
        
        pacman.setPosicion(cruzoDerecha);

    }
    
    if(mapa.hayPortalIzquierda(c) && !mapa.noValido(cruzoIzquierda)){ // se verifica si fue portal de izquierda y si la posicion calculada es valida 
        
        pacman.setPosicion(cruzoIzquierda);

    }

}

// GAMEOVER / COMPRUEBA SI HAY GAMEOVER O SI PACMAN SE COME UN FANTASMA DEPENDIENDO DEL ESTADO 

private boolean gameOver(Coordenadas c,boolean asustados){ 

    if(!asustados){
        for(int i=0;i<ghost.cantidadFantasmas();i++){
            Coordenadas fantasma = ghost.accederFantasma(i);

            if(c.getY()==fantasma.getY() && c.getX()==fantasma.getX()){

                
                return true;
            }
    }
}
    else if(asustados){

        for(int i=0;i<ghost.cantidadFantasmas();i++){
            Coordenadas fantasma = ghost.accederFantasma(i);

            if(c.getY()==fantasma.getY() && c.getX()==fantasma.getX()){

                ghost.fantasmaMuere(i);

                return false;
            }         
        }
}
    
    return false;
}

private void pacmanMover(Direccion direccionFutura){
    if (direccionFutura == null) return;

    Direccion actual = pacman.dirActual();
    Coordenadas futuro = pacman.pacmanFuturo(direccionFutura);
    if (actual == null) actual = direccionFutura;
    Coordenadas futuroConDireccionActual = pacman.pacmanFuturo(actual);

    

     if (!mapa.hayMuro(futuro)){

        pacman.mover(direccionFutura); // si no hay muro se hace caso al parametro y se va en esa direccion 
    }

     else if(!mapa.hayMuro(futuroConDireccionActual)){
        
        pacman.mover(actual); // si hay muro se sigue moviendo en la direccion en que iba
    }
    }

    private void fantasmasMover(){

        Direccion direccionFutura = direcciones.randomDireccion();
        Direccion actual = ghost.dirActualGhost();
        Coordenadas futuro = ghost.nuevoFantasma(direccionFutura);
        Coordenadas futuroConDireccionActual = ghost.nuevoFantasma(actual);

        if (!mapa.hayMuro(futuro)){

        ghost.mover(direccionFutura); // si no hay muro se hace caso al parametro y se va en esa direccion 
    }

     else if(!mapa.hayMuro(futuroConDireccionActual)){
        
        ghost.mover(actual); // si hay muro se sigue moviendo en la direccion en que iba 
    }
    }
    private void pacmanPoderCome(Coordenadas c){
        if(mapa.hayPoder(c)){
            mapa.pacmanComioPoder(c);
            
        }
        
    }

    private void pacmanComePuntos(Coordenadas c){
        if(mapa.hayPepita(c)){
            mapa.pacmanPaso(c);
        }
    }

// FRAME DEL JUEGO 

    public void Actualizar(Direccion direccionTeclado){

        boolean estado = ghost.estadoFantasma();
        Direccion direccionFutura = direccionTeclado;
        Coordenadas pacmanActual = pacman.pacmanActual();
        System.out.println(mapa.puntosJuego());
        pacmanMover(direccionFutura); // movemos a pacman
        cruzarPortales(pacmanActual);   // verificamos si estamos cruzando un portal 
        //fantasmasMover(); // movemos a los fantasmas
        pacmanComePuntos(pacmanActual); 
        pacmanPoderCome(pacmanActual);
        
        pacmanComePoder();              // verificamos si hay cambio de estado                                    
        gameOver(pacmanActual, estado); // verificamos gameover
        win();                          // verificamos victoria 




    }
        
    }

    






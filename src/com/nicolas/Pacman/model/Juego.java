package com.nicolas.Pacman.model;

import java.util.ArrayList;

public class Juego { 

private Pacman pacman;  
private Tablero mapa;   
private Direccion direcciones; 
private Fantasma fantasma;
private ArrayList <Fantasma> fantasmas ;

// -----------INICIALIZAR------------------

public Juego(){ 

this.pacman = new Pacman(direcciones.randomDireccion(), new Coordenadas(1, 1), new Coordenadas(1, 1));
this.mapa = new Tablero();

this.fantasmas = new ArrayList<>();
fantasmas.add(new Fantasma(direcciones.randomDireccion(), new Coordenadas(10, 8), new Coordenadas(10, 8)));
fantasmas.add(new Fantasma(direcciones.randomDireccion(), new Coordenadas(11, 8), new Coordenadas(11, 8)));
fantasmas.add(new Fantasma(direcciones.randomDireccion(), new Coordenadas(10, 7), new Coordenadas(10, 7)));
fantasmas.add(new Fantasma(direcciones.randomDireccion(), new Coordenadas(11, 7), new Coordenadas(11, 7)));

}

// GETTERS PARA EL PANEL  

public Tablero getMapa() {
    return mapa;
}
public Pacman getPacman() {
    return pacman;
}
public ArrayList<Fantasma> getFantasmas() {
    return fantasmas;
}

// METODOS DEL JUEGO 

private void win(){ 

    if(mapa.gana()){
        System.out.println("VICTORIA VICTORIAAA");
    }
}

// -------------- GAME OVER ---------------

private Boolean gameOver(){

Boolean muerte = false ;
Coordenadas actual = pacman.pacmanActual();

for(int i=0;i < fantasmas.size() ; i++ ){
Coordenadas fantasmaUbi = fantasmas.get(i).ubicacion();
Fantasma f = fantasmas.get(i);

if(fantasmaUbi.getX() == actual.getX() && fantasmaUbi.getY() == actual.getY()){

if(!f.Asustados()){
    muerte = true ;
    break;
}

else f.fantasmaMuere();

}
}
return muerte;
}
    
// --------------CRUZAR PORTAL------------------

public void cruzarPortal(Direccion futura){

    Coordenadas actual = pacman.pacmanActual();

        if(actual.getX() == 0 && futura == Direccion.IZQUIERDA){

                pacman.setPosicion(new Coordenadas(20, actual.getY()));
        }
        else if(actual.getX() == 21 && futura == Direccion.DERECHA){

                pacman.setPosicion(new Coordenadas(1, actual.getY()));
        }
}   

// -------------- MOVIMIENTO PACMAN ---------------------

private void pacmanMover(Direccion direccionFutura){
 
    if (direccionFutura == null) return;
    Direccion actual = pacman.dirActual();
    Coordenadas futuro = pacman.pacmanFuturo(direccionFutura);
    if (actual == null) actual = direccionFutura;
    Coordenadas futuroConDireccionActual = pacman.pacmanFuturo(actual);
    
    cruzarPortal(direccionFutura);

    if (!mapa.hayMuro(futuro)&& !mapa.noValido(futuro)){

        pacman.mover(direccionFutura); 
    }

     else if(!mapa.hayMuro(futuroConDireccionActual)&&!mapa.noValido(futuroConDireccionActual)){
        
        pacman.mover(actual); 
    }
    }

//--------------MOVIMIENTO FANTASMAS------------

private void fantasmasMover(){

for(int i=0; i<fantasmas.size(); i++){

Direccion DirActual = fantasmas.get(i).dirActualFantasma();
Fantasma fActual = fantasmas.get(i);
Coordenadas futuro = fActual.nuevoFantasma(DirActual);

if(!mapa.hayMuro(futuro) && !mapa.noValido(futuro)){
    fActual.mover(DirActual);
}
else if(mapa.hayMuro(futuro) && !mapa.noValido(futuro)){
    fActual.setDireccion_actual(direcciones.randomDireccion());
}
}
}
 
// ------------- CONSUME OBJETOS MAPA-----------

   private void pacmanComePoder(){

    Coordenadas actual = pacman.pacmanActual();
    if(mapa.hayPoder(actual)){ 
        for(int i=0;i < fantasmas.size(); i++){
        fantasmas.get(i).seASustan();
    }
        mapa.pacmanComioPoder(actual);
    }
}

    private void pacmanComePuntos(){

        Coordenadas actual = pacman.pacmanActual();
        if(mapa.hayPepita(actual)){
            mapa.pacmanPaso(actual);
        }
    }

// FRAME DEL JUEGO 

    public void Actualizar(Direccion direccionTeclado){

        Direccion direccionFutura = direccionTeclado;      
        pacmanMover(direccionFutura); 
        fantasmasMover();
        pacmanComePoder();
        pacmanComePuntos();
        gameOver();
        win();                          
    }
        
    }

    






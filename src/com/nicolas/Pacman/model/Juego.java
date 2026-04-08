package com.nicolas.Pacman.model;

import java.util.ArrayList;

public class Juego { 

private Pacman pacman;  
private Tablero mapa;   
private ArrayList <Fantasma> fantasmas ;
private int contador = 0;

// -----------INICIALIZAR------------------

public Juego(){ 

this.pacman = new Pacman(Direccion.randomDireccion(), new Coordenadas(1, 1), new Coordenadas(1, 1));
this.mapa = new Tablero();

this.fantasmas = new ArrayList<>();
fantasmas.add(new Fantasma(Direccion.randomDireccion(), new Coordenadas(10, 7), new Coordenadas(10, 7)));
fantasmas.add(new Fantasma(Direccion.randomDireccion(), new Coordenadas(10, 8), new Coordenadas(11, 8)));
fantasmas.add(new Fantasma(Direccion.randomDireccion(), new Coordenadas(11, 7), new Coordenadas(10, 7)));
fantasmas.add(new Fantasma(Direccion.randomDireccion(), new Coordenadas(11, 8), new Coordenadas(11, 7)));

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

else  f.fantasmaMuere();
    

}
}
return muerte;
}
    

// -------------- MOVIMIENTO PACMAN ---------------------

private void pacmanMover(Direccion direccionFutura){
 
    Coordenadas cordPacman = pacman.pacmanActual();
    if (direccionFutura == null) return;
    Direccion actual = pacman.dirActual();
    Coordenadas futuro = pacman.pacmanFuturo(direccionFutura);
    if (actual == null) actual = direccionFutura;
    Coordenadas futuroConDireccionActual = pacman.pacmanFuturo(actual);
    
    // ------------------CRUZAR PORTALES----------------------- 

    if(cordPacman.getX() == 0 && actual == Direccion.IZQUIERDA){
        pacman.setPosicion(new Coordenadas(20, cordPacman.getY()));
    }

    else if(cordPacman.getX() == 21 && actual == Direccion.DERECHA){
        pacman.setPosicion(new Coordenadas(1, cordPacman.getY()));
    }

    //-----------------VALIDACION DE MUROS----------------------

    else if(!mapa.hayMuro(futuro)&& !mapa.noValido(futuro)){

        pacman.mover(direccionFutura); 
    }

     else if(!mapa.hayMuro(futuroConDireccionActual)&&!mapa.noValido(futuroConDireccionActual)){
        
        pacman.mover(actual); 
    }
    }



//--------------MOVIMIENTO FANTASMAS------------

private void moverFantasmas(){
   
for(int i=0 ; i < fantasmas.size() ; i++){

Fantasma f = fantasmas.get(i);
Direccion decidida = f.dirActualFantasma();
Coordenadas Cordfantasma = f.ubicacion();

if(!f.muertos()){
if(mapa.hayMuro(f.nuevoFantasma(decidida)) || mapa.hayInterseccion(Cordfantasma)){

do {
    decidida = Direccion.randomDireccion();
} while (mapa.hayMuro(f.nuevoFantasma(decidida)));

f.setDireccion_actual(decidida);
}
f.mover(decidida);
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
        if(mapa.hayPepita(actual) || mapa.hayInterseccion(actual)){
            mapa.pacmanPaso(actual);
            
        }
    }

//--------------------TEMPORIZADORES-----------------------

private void fantasmaSpawn(){
    for(int i=0;i<fantasmas.size() ; i++){
        Fantasma f = fantasmas.get(i);
        f.temporizadorSpawn();
    }
}

private void temporizadorPoder(){
    for(int i=0; i<fantasmas.size() ;i++){
        fantasmas.get(i).temporizadorPoder();
    }
}

private void aumentar(){
    contador++;
}

// ------------------FRAME DEL JUEGO---------------------- 

    public void Actualizar(Direccion direccionTeclado){

        aumentar();
        Direccion direccionFutura = direccionTeclado;      
        if(contador%2==0)pacmanMover(direccionFutura); 
        if(contador %3 == 0)moverFantasmas();
        pacmanComePoder();
        pacmanComePuntos();
        fantasmaSpawn();
        temporizadorPoder();
        gameOver();
        win();                          
    }
        
    }

    






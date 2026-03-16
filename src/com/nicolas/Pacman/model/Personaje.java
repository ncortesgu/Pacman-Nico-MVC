package com.nicolas.Pacman.model;

public abstract class Personaje { // creamos una clase madre personaje para poder añadir en un futuro mas personajes con diferente movimiento

    public  Direccion direccion_actual; // para guardar la direccion en que se esta moviendo cada personaje 
    public Coordenadas posicion ; // pocision de personaje 
    public Coordenadas spawn ;


    public void setPosicion(Coordenadas posicion) {
        this.posicion = posicion;
    }

    public void setDireccion_actual(Direccion direccion_actual) {
        this.direccion_actual = direccion_actual;
    }

    public Personaje(Direccion direccion_actual, Coordenadas posicion, Coordenadas spawn) {
        this.direccion_actual = direccion_actual;
        this.posicion = posicion;
        this.spawn = spawn;
    }

    public Personaje() {
    } 

    

}

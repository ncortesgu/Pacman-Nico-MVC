package com.nicolas.Pacman.model;

public abstract class Personaje { // creamos una clase madre personaje para poder añadir en un futuro mas personajes con diferente movimiento

    public  int velocidad; // se guarda la cantidad de frames a pasar para que se ejecute el movimiento 
    public  Direccion direccion_actual; // para guardar la direccion en que se esta moviendo cada personaje 
    public Coordenadas posicion ; // pocision de personaje 

    public  abstract void mover(Direccion direccion); // metodo abstracto que cada hijo heredara pero hara a su manera

    public int getVelocidad() { // para acceder a la velocidad 
        return velocidad;
    }

    public void setVelocidad(int velocidad) { // para que juego asigne la velocidad dependiendo de lo que vea en el mapa
        this.velocidad = velocidad;
    }


}

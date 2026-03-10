package com.nicolas.Pacman.model;

public class Coordenadas {
    
// Atributos 

int x; // columnas
int y; // filas 

// Constructor para poder generar coordenadas 

public Coordenadas(int x, int y) {
    this.x = x;
    this.y = y;
}

// Getters para poder acceder a filas y columnas 

public int getX() {
    return x;
}

public int getY() {
    return y;
}



}

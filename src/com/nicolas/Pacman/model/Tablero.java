package com.nicolas.Pacman.model;

public class Tablero {

    private char [][] mapa_juego;
    private int puntos = 187;

    public Tablero() {

        this.mapa_juego = new char[][] {
        //    0   1   2   3   4   5   6   7   8   9  10   11  12  13  14  15  16  17  18  19  20  21
            {'7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7' }, // 0
            {'7','.','.','.','.','.','.','7','.','.','.','.','.','.','7','.','.','.','.','.','.','7' }, // 1
            {'7','.','7','7','7','.','.','7','.','7','7','7','7','.','7','.','.','7','7','7','.','7' }, // 2
            {'7','.','7','.','.','8','.','7','.','.','.','.','.','.','7','.','.','.','.','7','.','7' }, // 3
            {'7','.','7','.','.','.','.','.','.','.','.','.','.','.','.','.','.','8','.','7','.','7' }, // 4
            {'7','.','.','.','7','.','.','.','.','.','.','.','.','.','.','.','.','7','.','.','.','7' }, // 5
            {'7','.','.','.','7','.','.','7','.','.','.','.','.','.','7','.','.','7','.','.','.','7' }, // 6
            {'1','.','.','.','.','.','.','7','.','.','.','.','.','.','7','.','.','.','.','.','.','0' }, // 7
            {'1','.','.','.','.','.','.','7','.','.','.','.','.','.','7','.','.','.','.','.','.','0' }, // 8
            {'7','.','.','.','7','.','.','.','.','.','.','.','.','.','.','.','.','7','.','.','.','7' }, // 9
            {'7','.','7','.','7','.','.','.','.','.','.','.','.','.','.','.','.','7','.','7','.','7' }, // 10
            {'7','.','7','8','.','.','.','7','.','.','.','.','.','.','7','.','.','.','.','7','.','7' }, // 11
            {'7','.','7','7','7','.','.','7','.','7','7','7','7','.','7','.','.','7','7','7','.','7' }, // 12
            {'7','.','.','.','.','.','.','7','.','.','.','.','.','8','7','.','.','.','.','.','.','7' }, // 13
            {'7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7','7' }, // 14
            
        };

    }
    
    // METODOS PARA SABER QUE HAY EN EL MAPA

    public boolean hayPoder(Coordenadas c){
        return this.mapa_juego[c.getY()][c.getX()] == '8';
    }

    public boolean hayMuro(Coordenadas c){
        return this.mapa_juego[c.getY()][c.getX()] == '7';
    }

    public boolean hayPepita(Coordenadas c){
        return this.mapa_juego[c.getY()][c.getX()]== '.';
    }

    public boolean estaVacio(Coordenadas c){
        return this.mapa_juego[c.getY()][c.getX()]== '2';
    }

    public boolean hayPortalDerecha(Coordenadas c){
        return this.mapa_juego[c.getY()][c.getX()]== '0';
    } 

    public boolean hayPortalIzquierda(Coordenadas c){
        return this.mapa_juego[c.getY()][c.getX()]== '1';
    }


// METODOS PARA PUNTOS DEL JUEGO 

public void pacmanPaso(Coordenadas c){

    int y = c.getY();
    int x = c.getX();

    this.mapa_juego[y][x]='2';

    puntos--;
}
public void pacmanComioPoder(Coordenadas c){
    int y = c.getY();
    int x = c.getX();

    this.mapa_juego[y][x] = '2';

}

public int puntosJuego(){
    return puntos;
}


public boolean gana(){
    return puntos==0;
}


// METODO PARA VERIFICAR VALIDEZ DE UNA COORDENADA 
    
public boolean noValido(Coordenadas c){ // si algunas de estas condiciones son verdaderas retornara verdadero y sabremos que no es valida la coordenada
    return c.getY()< 0 || c.getY()>=this.mapa_juego.length || c.getX()<0 || c.getX()>=this.mapa_juego[0].length;
} 

// METODO RETORNAR LARGO MAPA PARA CRUZAR PORTALES / PARA PASARLE INFORMACION AL PANEL

public int largoMapa(){
    return this.mapa_juego[0].length;
}
public int anchoMapa(){
    return this.mapa_juego.length;
}

public char[][] getMapaCopia() {
    char[][] copia = new char[this.mapa_juego.length][this.mapa_juego[0].length];
    for (int i = 0; i < this.mapa_juego.length; i++) {
        System.arraycopy(this.mapa_juego[i], 0, copia[i], 0, this.mapa_juego[i].length);
    }
    return copia;
}

}

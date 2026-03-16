package com.nicolas.Pacman.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.nicolas.Pacman.model.Fantasma;
import com.nicolas.Pacman.model.Juego;

public class Panel extends JPanel{

private Juego modelo;
int tamañoPixel = 18;

public Panel(Juego modelo){

this.modelo = modelo ;
this.setBackground(Color.BLACK);
this.setPreferredSize(new Dimension(400, 400));


this.setVisible(true);


}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g); 
    dibujarMapa(g);
    dibujarEntidades(g);
 
}

private void dibujarMapa(Graphics g ){

char mapa[][] = modelo.getMapa().getMapaCopia();
int filas = modelo.getMapa().anchoMapa();
int columnas = modelo.getMapa().largoMapa();


for(int i=0;i<filas;i++){

    for(int j=0;j<columnas;j++){

        char celda = mapa[i][j];
        int x = j*tamañoPixel;
        int y = i*tamañoPixel;

        if (celda == '7') {
            g.setColor(Color.MAGENTA);
            g.fillRect(x, y, tamañoPixel, tamañoPixel);
        }
        else if(celda=='.'){
            g.setColor(Color.yellow);
            g.fillOval(x+5, y+5, 5, 5);
           
        }
        else if(celda == '2'){
            g.setColor(Color.black);
            g.fillRect(x, y, tamañoPixel, tamañoPixel);
        }
        else if(celda == '8'){
            g.setColor(Color.GREEN);
            g.fillOval(x+4,y+4, 10, 10);
        }
        else if(celda == '0' || celda =='1'){
            g.setColor(Color.WHITE);
            g.fillRect(x, y, tamañoPixel, tamañoPixel);
        }
    }
}
}

private void dibujarEntidades(Graphics g){

int pacmanY = modelo.getPacman().pacmanActual().getY();
int pacmanX = modelo.getPacman().pacmanActual().getX();
ArrayList<Fantasma> fantasmas = modelo.getFantasmas();

g.setColor(Color.yellow);
g.fillOval(pacmanX*tamañoPixel+2, pacmanY*tamañoPixel+2, 14, 14);

g.setColor(Color.CYAN);
int cantidadFantasmas = fantasmas.size();

for(int i=0; i<cantidadFantasmas; i++){

    int x = fantasmas.get(i).posicion.getX();
    int y = fantasmas.get(i).posicion.getY(); 

    g.fillOval(x*tamañoPixel+2, x*tamañoPixel+2, 14, 14);
    
}

}

}
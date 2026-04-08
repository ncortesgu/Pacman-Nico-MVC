package com.nicolas.Pacman.view;

import javax.swing.JFrame;

import com.nicolas.Pacman.controller.TecladoControlador;
import com.nicolas.Pacman.model.Juego;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame{
    public Juego modelo = new Juego();

    public Panel miPanel = new Panel(modelo);

    public Frame(){

        this.setSize(400, 400);
        this.add(miPanel);
        this.setTitle("PacmanGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        

        TecladoControlador teclado = new TecladoControlador();
        this.addKeyListener(teclado);
        this.setFocusable(true);
        this.requestFocusInWindow();
        

Timer timer = new Timer(50, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
       
        modelo.Actualizar(teclado.getDireccionFutura()); 
        
        
        miPanel.repaint(); 
        
    }
});
timer.start(); 
this.setVisible(true);  
        
        
        
    }

    
}

package com.nicolas.Pacman.controller;
import com.nicolas.Pacman.model.Direccion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//import javax.lang.model.element.ModuleElement.DirectiveKind;

public class TecladoControlador extends KeyAdapter {

    private Direccion direccionFutura = Direccion.DERECHA;

    @Override
    public void keyPressed(KeyEvent e) {
        
        int tecla = e.getKeyCode(); 

        switch(tecla){

           case KeyEvent.VK_UP -> direccionFutura = Direccion.ARRIBA;
            case KeyEvent.VK_DOWN -> direccionFutura = Direccion.ABAJO;
            case KeyEvent.VK_LEFT -> direccionFutura = Direccion.IZQUIERDA;
            case KeyEvent.VK_RIGHT -> direccionFutura = Direccion.DERECHA;
} 
}

public Direccion getDireccionFutura() {
        return direccionFutura;
    }    

}

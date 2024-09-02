/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Usuarios;
import Vistas.frmInicio;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ctrlInicioSesion implements MouseListener {
      Usuarios Modelos; 
      frmInicio Vistas; 
      
     
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == Vistas.btnIngresar) {
            Modelos.setCorreo(Vistas.txtCorreo.getText());
            Modelos.setContraseña(Modelos.convertirSHA256(Vistas.txtContraseña.getText()));

            //Creo una variable llamada "comprobar" 
            //que guardará el resultado de ejecutar el metodo iniciarSesion()            
            boolean comprobar = Modelos.iniciarSesion();

            //Si la variable es "true" significa que si existe el usuario ingresado    
            if (comprobar == true) {
                JOptionPane.showMessageDialog(Vistas,"¡Bienvenido a DLPH!");
            } else {
                JOptionPane.showMessageDialog(Vistas, "Usuario no encontrado, intente denuevo");

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}

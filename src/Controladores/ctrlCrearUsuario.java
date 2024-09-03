
package Controladores;

import Modelos.mdlCrearUsu;
import Vistas.frmCrearU;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class ctrlCrearUsuario implements MouseListener, KeyListener  {
    
    private mdlCrearUsu modelo; 
    private frmCrearU vista; 

    public ctrlCrearUsuario(mdlCrearUsu modelo, frmCrearU vista) {
        this.modelo = modelo;
        this.vista = vista;

     
        vista.btnAgregarCu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });
        
        vista.jtbUsuariosEcu.addMouseListener(this);

       
        modelo.Mostrar(vista.jtbUsuariosEcu);
    }
    
    private void agregarUsuario() {
        if (vista.txtNombreCu.getText().isEmpty() || 
            vista.txtContrasenaCu.getText().isEmpty() || 
            vista.txtCorreoCu.getText().isEmpty() || 
            vista.jSpinner1.getValue() == null) {

            JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                modelo.setNombre(vista.txtNombreCu.getText());
                modelo.setContrasenaUsuario(vista.txtContrasenaCu.getText());
                modelo.setCorreoUsuario(vista.txtCorreoCu.getText());
                modelo.setRolUsuario(vista.jSpinner1.getValue().toString());

          
                modelo.Guardar();

        
                modelo.Mostrar(vista.jtbUsuariosEcu);

              
                modelo.limpiarCampos(vista);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.jtbUsuariosEcu) {
            int filaSeleccionada = vista.jtbUsuariosEcu.getSelectedRow();
            if (filaSeleccionada != -1) {
                String Nombre = vista.jtbUsuariosEcu.getValueAt(filaSeleccionada, 1).toString();
                String ContrasenaUsuario = vista.jtbUsuariosEcu.getValueAt(filaSeleccionada, 2).toString();
                String CorreoUsuario = vista.jtbUsuariosEcu.getValueAt(filaSeleccionada, 3).toString();
                String RolUsuario = vista.jtbUsuariosEcu.getValueAt(filaSeleccionada, 4).toString();

                // Establecer los valores en los campos de texto
                vista.txtNombreCu.setText(Nombre);
                vista.txtContrasenaCu.setText(ContrasenaUsuario);
                vista.txtCorreoCu.setText(CorreoUsuario);
                vista.jSpinner1.setValue(RolUsuario);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }
    
    @Override
    public void mouseReleased(MouseEvent e) { }
    
    @Override
    public void mouseEntered(MouseEvent e) { }
    
    @Override
    public void mouseExited(MouseEvent e) { }
   
    @Override
    public void keyTyped(KeyEvent e) { }
    
    @Override
    public void keyPressed(KeyEvent e) { }
   
    @Override
    public void keyReleased(KeyEvent e) { }
    
    }

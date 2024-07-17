import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu_opciones extends JFrame{
    private JButton ingresarButton;
    private JButton buscarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JPanel panelmenu;

    public Menu_opciones() {
        super("Menu de opciones");
        setContentPane(panelmenu);
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registro_producto resgistrar = new Registro_producto();
                resgistrar.ingresar();
                dispose();



            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Busqueda_producto busqueda = new Busqueda_producto();
                busqueda.ingresar();
                dispose();
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actualizar_producto ventana_actualizar = new Actualizar_producto();
                ventana_actualizar.ingresar();
                dispose();

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar_producto ventana_eliminar = new Eliminar_producto();
                ventana_eliminar.ingresar();
                dispose();
            }
        });
    }



    public void ingresar(){
        setVisible(true);

        setSize(500,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

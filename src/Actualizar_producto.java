import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actualizar_producto extends JFrame {
    private JPanel panelactualizar;
    private JTextField actualizar;
    private JButton actualizarButton;
    private JButton volverButton;

    public Actualizar_producto() {
        super("Panel de Busqueda");
        setContentPane(panelactualizar);
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_opciones ventana_menu = new Menu_opciones();
                ventana_menu.ingresar();
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

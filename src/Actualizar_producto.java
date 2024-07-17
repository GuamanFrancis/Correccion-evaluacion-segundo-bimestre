import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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

                try{
                    Actualizar();

                }catch (SQLException ex){
                    System.out.println(ex.getMessage());

                }

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

    public Connection conexion()throws SQLException {
        String url = "jdbc:mysql://localhost:3306/productos_cp";
        String user = "root";
        String pass = "12345";

        return DriverManager.getConnection(url,user,pass);

    }


public void Actualizar()throws SQLException{
    Connection conectar = conexion();
    String producto = actualizar.getText();
    String sql = "SELECT * FROM producto WHERE codigo_producto = ? ";

    PreparedStatement stmt = conectar.prepareStatement(sql);
    stmt.setString(1,producto);

    ResultSet RS = stmt.executeQuery();

    if (RS.next()) {
        JOptionPane.showMessageDialog(null,"Producto encontrado");
        Registro_producto actualizacionproducto = new Registro_producto();
        actualizacionproducto.ingresar();
        dispose();



    }else{

        JOptionPane.showMessageDialog(null,"No se encontro el producto");

    }





}


}

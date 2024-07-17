import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Eliminar_producto extends JFrame{
    private JPanel paneleliminar;
    private JTextField elimi;
    private JButton eliminarButton;
    private JButton volverButton;

    public Eliminar_producto() {
        super("Panel de Busqueda");
        setContentPane(paneleliminar);
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    eliminarproducto();

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

    public void eliminarproducto()throws SQLException{

        Connection conectar = conexion();
        String producto = elimi.getText();
        String sql = "SELECT * FROM producto WHERE codigo_producto = ? ";

        PreparedStatement stmt = conectar.prepareStatement(sql);
        stmt.setString(1,producto);

        ResultSet RS = stmt.executeQuery();

        if (RS.next()) {

                eliminar();

        }else{

            JOptionPane.showMessageDialog(null,"No se encontro el producto");

        }




    }

    public void eliminar()throws SQLException{
        Connection conectar = conexion();
        String producto = elimi.getText();
        String sql = "DELETE  FROM producto WHERE codigo_producto = ? ";
        PreparedStatement stmt = conectar.prepareStatement(sql);
        stmt.setString(1,producto);
        int columnas = stmt.executeUpdate();

        if (columnas>0){
            JOptionPane.showMessageDialog(null,"Datos eliminados exitosamente");

        }else{
            JOptionPane.showMessageDialog(null,"Error");

        }






    }
}

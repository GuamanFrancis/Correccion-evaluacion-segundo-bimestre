import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Busqueda_producto extends JFrame{
    private JTextField prod_buscar;
    private JButton volverButton;
    private JButton buscarButton;
    private JPanel panel_busqueda;

    public Busqueda_producto() {
        super("Panel de Busqueda");
        setContentPane(panel_busqueda);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    buscarproducto();
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

    public void buscarproducto()throws SQLException{
        Connection conectar = conexion();
        String producto = prod_buscar.getText();
        String sql = "SELECT * FROM producto WHERE codigo_producto = ? ";

        PreparedStatement stmt = conectar.prepareStatement(sql);
        stmt.setString(1,producto);

        ResultSet RS = stmt.executeQuery();
        StringBuilder datos = new StringBuilder("");
        if (RS.next()) {
            datos.append("Codigo: ").append(RS.getString("codigo_producto")).append("\n ");
            datos.append("nombre: ").append(RS.getString("nombre")).append(" \n");
            datos.append("descipcion: ").append(RS.getString("descripcion")).append("\n ");
            datos.append("precio: ").append(RS.getString("precio")).append("\n ");
            datos.append("cantidad: ").append(RS.getString("cantidad")).append(" \n");
            datos.append("categoria: ").append(RS.getString("categoria")).append(" \n");

            JOptionPane.showMessageDialog(null,datos);

        }else{

            JOptionPane.showMessageDialog(null,"No se encontro el producto");

        }
    }
}

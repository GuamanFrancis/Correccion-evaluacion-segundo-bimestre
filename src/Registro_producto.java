import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Registro_producto extends JFrame{
    private JPanel panelregistro;
    private JTextField codigo;
    private JTextField nom;
    private JTextField desc;
    private JTextField pre;
    private JTextField cant;
    private JTextField cat;
    private JButton ingresarButton;
    private JButton volverButton;

    public Registro_producto() {
        super("Ventana Registro");
        setContentPane(panelregistro);

        ingresarButton.addActionListener(new ActionListener() {
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
        setLocationRelativeTo(null);
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public Connection conexion()throws SQLException{
        String url = "jdbc:mysql://localhost:3306/productos_cp";
        String user = "root";
        String pass = "12345";

        return DriverManager.getConnection(url,user,pass);

    }

    public void Registrarproductos()throws SQLException{
        Connection conectar=conexion();
        String cod = codigo.getText();
        String nombre = nom.getText();
        String descripcion = desc.getText();
        Double precio = Double.parseDouble(pre.getText());
        String cantidad = cant.getText();
        String cateogira = cat.getText();
        String sql = "INSERT  INTO producto(codigo_producto,nombre,description,precio,cantidad,cateogira)values(?,?,?,?,?,?,)";
        PreparedStatement stmt = conectar.prepareStatement(sql);
        stmt.setString(1,cod);
        stmt.setString(2,nombre);
        stmt.setString(3,descripcion);
        stmt.setDouble(4,precio);
        stmt.setInt(5,Integer.parseInt(cantidad));
        stmt.setString(6,cateogira);

        int columnas = stmt.executeUpdate();

        if (columnas>0){
            JOptionPane.showMessageDialog(null,"Datos ingresados exitosamente");

        }else{
            JOptionPane.showMessageDialog(null,"Datos no ingresados");

        }


    }
}

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Vent extends JFrame {

    public Vent() {
        this.setTitle("Tarea lol");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 650);
        this.setLocationRelativeTo(null);

        JTabbedPane menuNavegacion = new JTabbedPane();

        menuNavegacion.addTab("Login", crearPanelLogin());
        menuNavegacion.addTab("Registro", crearPanelRegistro());
        menuNavegacion.addTab("Tabla de Usuarios", crearPanelTabla());

        this.add(menuNavegacion);
        this.setVisible(true);
    }

    private JPanel crearPanelLogin() {
        JPanel pnl = new JPanel(null);
        pnl.setBackground(Color.BLACK);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(50, 50, 100, 30);
        lblUser.setForeground(Color.WHITE);
        pnl.add(lblUser);

        JTextField txtUser = new JTextField();
        txtUser.setBounds(50, 80, 200, 35);
        pnl.add(txtUser);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(50, 140, 100, 30);
        lblPass.setForeground(Color.WHITE);
        pnl.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(50, 170, 200, 35);
        pnl.add(txtPass);

        JButton btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(50, 230, 100, 40);
        pnl.add(btnLogin);

        return pnl;
    }

    private JPanel crearPanelRegistro() {
        JPanel pnl = new JPanel(null);
        pnl.setBackground(Color.DARK_GRAY);

        JLabel lblName = new JLabel("Nombre Completo:");
        lblName.setBounds(50, 30, 150, 30);
        lblName.setForeground(Color.WHITE);
        pnl.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(50, 60, 250, 30);
        pnl.add(txtName);

        JLabel lblBio = new JLabel("Bio:");
        lblBio.setBounds(50, 100, 100, 30);
        lblBio.setForeground(Color.WHITE);
        pnl.add(lblBio);

        JTextArea txtBio = new JTextArea();
        txtBio.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtBio.setBounds(50, 130, 250, 80);
        pnl.add(txtBio);

        JRadioButton rbSi = new JRadioButton("Acepto términos");
        JRadioButton rbNo = new JRadioButton("No acepto");
        rbSi.setBounds(50, 220, 130, 30);
        rbNo.setBounds(180, 220, 100, 30);
        rbSi.setOpaque(false);
        rbNo.setOpaque(false);
        rbSi.setForeground(Color.WHITE);
        rbNo.setForeground(Color.WHITE);
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbSi); 
        grupo.add(rbNo);
        pnl.add(rbSi); 
        pnl.add(rbNo);

        String[] opciones = {"Estudiante", "Profesor", "Admin"};
        JComboBox<String> combo = new JComboBox<>(opciones);
        combo.setBounds(50, 260, 150, 30);
        pnl.add(combo);

        JButton btnReg = new JButton("Registrar");
        btnReg.setBounds(50, 310, 150, 40);
        btnReg.setBackground(Color.CYAN);
        pnl.add(btnReg);

        return pnl;
    }

    private JPanel crearPanelTabla() {
        JPanel pnl = new JPanel(new BorderLayout());

        String[] columnas = {"ID", "Nombre", "Correo", "Edad", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        modelo.addRow(new Object[]{"1", "Francisco", "fran@mail.com", "20", "Activo"});
        modelo.addRow(new Object[]{"2", "Brianda", "bri@mail.com", "19", "Activo"});

        JTable tabla = new JTable(modelo);
        
        JScrollPane scroll = new JScrollPane(tabla);
        pnl.add(scroll, BorderLayout.CENTER);

        return pnl;
    }

    public static void main(String[] args) {
        new Vent();
    }
}
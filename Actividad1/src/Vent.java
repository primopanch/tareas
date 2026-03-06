import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Vent extends JFrame {

    // Paleta de colores consistente
    private final Color BG_DARK = new Color(30, 30, 30);
    private final Color BG_CARD = new Color(45, 45, 45);
    private final Color ACCENT_BLUE = new Color(0, 122, 255);
    private final Color TEXT_WHITE = Color.WHITE;

    public Vent() {
        configurarAparienciaGlobal();
        
        this.setTitle("Gestor de Usuarios");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 700);
        this.setLocationRelativeTo(null);

        // Contenedor Principal
        JTabbedPane menuNavegacion = new JTabbedPane();
        menuNavegacion.setFont(new Font("SansSerif", Font.BOLD, 13));
        
        // Agregamos los paneles
        menuNavegacion.addTab("Login", crearPanelLogin());
        menuNavegacion.addTab("Registro", crearPanelRegistro());
        menuNavegacion.addTab("Tabla de Usuarios", crearPanelTabla());

        this.add(menuNavegacion);
        this.setVisible(true);
    }

    private void configurarAparienciaGlobal() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Forzamos que los textos de los Tabs sean visibles si el sistema los pone oscuros
        UIManager.put("TabbedPane.foreground", Color.BLACK); 
        UIManager.put("TabbedPane.selectedForeground", ACCENT_BLUE);
    }

    private JPanel crearPanelLogin() {
        JPanel pnl = new JPanel(new GridBagLayout());
        pnl.setBackground(BG_DARK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("INICIAR SESIÓN", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 26));
        lblTitle.setForeground(ACCENT_BLUE);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 30, 10);
        pnl.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        
        gbc.gridy = 1; pnl.add(crearLabel("Usuario:"), gbc);
        JTextField txtUser = new JTextField(15);
        txtUser.setPreferredSize(new Dimension(250, 35));
        gbc.gridy = 2; pnl.add(txtUser, gbc);

        gbc.gridy = 3; pnl.add(crearLabel("Contraseña:"), gbc);
        JPasswordField txtPass = new JPasswordField(15);
        txtPass.setPreferredSize(new Dimension(250, 35));
        gbc.gridy = 4; pnl.add(txtPass, gbc);

        JButton btnLogin = new JButton("ENTRAR");
        btnLogin.setBackground(ACCENT_BLUE);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setPreferredSize(new Dimension(100, 40));
        gbc.gridy = 5; gbc.insets = new Insets(30, 10, 10, 10);
        pnl.add(btnLogin, gbc);

        return pnl;
    }

    private JPanel crearPanelRegistro() {
        JPanel pnlMain = new JPanel(new BorderLayout());
        pnlMain.setBackground(BG_DARK);
        
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setOpaque(false);
        form.setBorder(new EmptyBorder(50, 150, 50, 150));

        form.add(crearLabel("Nombre Completo:"));
        form.add(new JTextField());
        form.add(Box.createVerticalStrut(15));

        form.add(crearLabel("Biografía:"));
        JTextArea txtBio = new JTextArea(4, 20);
        txtBio.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        form.add(new JScrollPane(txtBio));
        form.add(Box.createVerticalStrut(15));

        JPanel pnlRadio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlRadio.setOpaque(false);
        JRadioButton rbSi = new JRadioButton("Acepto términos");
        rbSi.setForeground(TEXT_WHITE); rbSi.setOpaque(false);
        pnlRadio.add(rbSi);
        form.add(pnlRadio);
        
        form.add(Box.createVerticalStrut(15));
        String[] opciones = {"Estudiante", "Profesor", "Admin"};
        JComboBox<String> combo = new JComboBox<>(opciones);
        form.add(combo);

        form.add(Box.createVerticalStrut(30));
        JButton btnReg = new JButton("CREAR CUENTA");
        btnReg.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReg.setBackground(new Color(40, 167, 69)); // Color verde éxito
        btnReg.setForeground(Color.WHITE);
        form.add(btnReg);

        pnlMain.add(form, BorderLayout.CENTER);
        return pnlMain;
    }

    private JPanel crearPanelTabla() {
        JPanel pnl = new JPanel(new BorderLayout());
        pnl.setBackground(BG_DARK);
        pnl.setBorder(new EmptyBorder(30, 30, 30, 30));

        JLabel titulo = new JLabel("Usuarios Registrados");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        titulo.setForeground(TEXT_WHITE);
        titulo.setBorder(new EmptyBorder(0, 0, 20, 0));
        pnl.add(titulo, BorderLayout.NORTH);

        String[] columnas = {"ID", "Nombre", "Correo", "Edad", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        modelo.addRow(new Object[]{"1", "Francisco", "fran@mail.com", "20", "Activo"});
        modelo.addRow(new Object[]{"2", "Brianda", "bri@mail.com", "19", "Activo"});

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(35);
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        // Estilo del encabezado
        JTableHeader header = tabla.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.setBackground(BG_CARD);
        header.setForeground(ACCENT_BLUE);
        
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.getViewport().setBackground(BG_DARK);
        pnl.add(scroll, BorderLayout.CENTER);

        return pnl;
    }

    private JLabel crearLabel(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setForeground(TEXT_WHITE);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lbl.setBorder(new EmptyBorder(5, 0, 5, 0));
        return lbl;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Vent::new);
    }
}
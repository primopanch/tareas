import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class RegistroUsuarios extends JFrame {

    // Paleta de colores Dark Theme
    private final Color COLOR_FONDO_PRINCIPAL = new Color(30, 30, 46);
    private final Color COLOR_PANEL_SECUNDARIO = new Color(45, 45, 65);
    private final Color COLOR_TEXTO = new Color(205, 214, 244);
    private final Color COLOR_ACENTO = new Color(137, 180, 250); // Azul claro para títulos

    public RegistroUsuarios() {
        setTitle("Registro de Usuarios - Modern Dark");
        setSize(750, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Contenedor raíz con fondo oscuro
        getContentPane().setBackground(COLOR_FONDO_PRINCIPAL);
        setLayout(new BorderLayout(15, 15));

        
        JLabel lblTitulo = new JLabel("Registro de Usuarios", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setForeground(COLOR_ACENTO);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(lblTitulo, BorderLayout.NORTH);

        
        JPanel pnlCentro = new JPanel(new GridLayout(2, 2, 15, 15));
        pnlCentro.setOpaque(false); // Deja ver el fondo del JFrame
        pnlCentro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel pnlDatosGenerales = crearPanelPersonalizado("Datos Generales");
        pnlDatosGenerales.setLayout(new GridLayout(6, 2, 8, 12));
        agregarCamposGenerales(pnlDatosGenerales);

        
        JPanel pnlPerfil = crearPanelPersonalizado("Perfil del Usuario");
        pnlPerfil.setLayout(new BoxLayout(pnlPerfil, BoxLayout.Y_AXIS));
        configurarPanelPerfil(pnlPerfil);

        JPanel pnlOpcionales = crearPanelPersonalizado("Datos Opcionales");
        pnlOpcionales.setLayout(new BorderLayout(10, 10));
        configurarPanelOpcionales(pnlOpcionales);

        JPanel pnlBotones = crearPanelPersonalizado("Acciones");
        pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
        configurarBotones(pnlBotones);

        pnlCentro.add(pnlDatosGenerales);
        pnlCentro.add(pnlPerfil);
        pnlCentro.add(pnlOpcionales);
        pnlCentro.add(pnlBotones);

        add(pnlCentro, BorderLayout.CENTER);
    }


    private JPanel crearPanelPersonalizado(String titulo) {
        JPanel panel = new JPanel();
        panel.setBackground(COLOR_PANEL_SECUNDARIO);
        
        // Borde estilizado: Línea de color acento con título en texto claro
        LineBorder linea = new LineBorder(new Color(60, 60, 85), 2, true);
        TitledBorder border = BorderFactory.createTitledBorder(linea, titulo);
        border.setTitleColor(COLOR_ACENTO);
        border.setTitleFont(new Font("Segoe UI", Font.BOLD, 14));
        
        panel.setBorder(border);
        return panel;
    }

    private void agregarCamposGenerales(JPanel p) {
        String[] labels = {"Nombres:", "Ap. Paterno:", "Ap. Materno:", "Nacimiento:", "Sexo:", "País:"};
        for (String l : labels) {
            JLabel label = new JLabel(l);
            label.setForeground(COLOR_TEXTO);
            p.add(label);
            
            if (l.equals("Sexo:")) {
                JPanel rbPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                rbPanel.setOpaque(false);
                JRadioButton m = new JRadioButton("M", true);
                JRadioButton f = new JRadioButton("F");
                m.setForeground(COLOR_TEXTO); f.setForeground(COLOR_TEXTO);
                m.setOpaque(false); f.setOpaque(false);
                ButtonGroup bg = new ButtonGroup(); bg.add(m); bg.add(f);
                rbPanel.add(m); rbPanel.add(f);
                p.add(rbPanel);
            } else if (l.equals("País:")) {
                p.add(new JComboBox<>(new String[]{"Perú", "Otros"}));
            } else {
                JTextField txt = new JTextField();
                txt.setBackground(COLOR_FONDO_PRINCIPAL);
                txt.setForeground(Color.WHITE);
                txt.setCaretColor(Color.WHITE);
                txt.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 100)));
                p.add(txt);
            }
        }
    }

    private void configurarPanelPerfil(JPanel p) {
        JLabel lblFoto = new JLabel("FOTO", SwingConstants.CENTER);
        lblFoto.setPreferredSize(new Dimension(120, 120));
        lblFoto.setMaximumSize(new Dimension(120, 120));
        lblFoto.setBorder(LineBorder.createBlackLineBorder());
        lblFoto.setForeground(COLOR_TEXTO);
        lblFoto.setAlignmentX(Component.CENTER_ALIGNMENT);

        JCheckBox c1 = new JCheckBox("Mostrar Foto", true);
        JCheckBox c2 = new JCheckBox("Mostrar Fecha", true);
        c1.setForeground(COLOR_TEXTO); c2.setForeground(COLOR_TEXTO);
        c1.setOpaque(false); c2.setOpaque(false);
        c1.setAlignmentX(Component.CENTER_ALIGNMENT);
        c2.setAlignmentX(Component.CENTER_ALIGNMENT);

        p.add(Box.createVerticalGlue());
        p.add(lblFoto);
        p.add(Box.createVerticalStrut(15));
        p.add(c1);
        p.add(c2);
        p.add(Box.createVerticalGlue());
    }

    private void configurarPanelOpcionales(JPanel p) {
        JTextArea area = new JTextArea("Bio...");
        area.setBackground(COLOR_FONDO_PRINCIPAL);
        area.setForeground(COLOR_TEXTO);
        p.add(new JScrollPane(area), BorderLayout.CENTER);
    }

    private void configurarBotones(JPanel p) {
        String[] nombres = {"Nuevo", "Guardar", "Salir"};
        for (String n : nombres) {
            JButton btn = new JButton(n);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(60, 60, 85));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
            btn.setPreferredSize(new Dimension(100, 35));
            p.add(btn);
            if(n.equals("Salir")) btn.addActionListener(e -> System.exit(0));
        }
    }

    public static void main(String[] args) {
        // Intentar usar el estilo del sistema para componentes internos
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } catch (Exception e) {}
        SwingUtilities.invokeLater(() -> new RegistroUsuarios().setVisible(true));
    }
}
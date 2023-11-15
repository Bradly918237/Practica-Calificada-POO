//PREGUNTA 2
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Pregunta1PROGRAMACION {
    private String modelo;
    private String color;
    private String placa;
    private String modalidadSeguro;
    private int año;
    private String tipo;
    private String tipoPintura;

    public Pregunta1PROGRAMACION(String modelo, String color, String placa, String modalidadSeguro, int año, String tipo, String tipoPintura) {
        this.modelo = modelo;
        this.color = color;
        this.placa = placa;
        this.modalidadSeguro = modalidadSeguro;
        this.año = año;
        this.tipo = tipo;
        this.tipoPintura = tipoPintura;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModalidadSeguro() {
        return modalidadSeguro;
    }

    public void setModalidadSeguro(String modalidadSeguro) {
        this.modalidadSeguro = modalidadSeguro;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoPintura() {
        return tipoPintura;
    }

    public void setTipoPintura(String tipoPintura) {
        this.tipoPintura = tipoPintura;
    }

    public static void main(String[] args) {
        ArrayList<Pregunta1PROGRAMACION> carrosRegistrados = new ArrayList<>();

        // Crear menú
        JDesktopPane desktopPane = new JDesktopPane();
        JFrame frame = new JFrame("Gestor de Carros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menuCarros = new JMenu("Carros");
        menuBar.add(menuCarros);

        JMenuItem registrarItem = new JMenuItem("Registrar Carro");
        registrarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir formulario de registro
                InterfazRegistrarCarro interfazRegistrar = new InterfazRegistrarCarro(carrosRegistrados);
                desktopPane.add(interfazRegistrar);
                interfazRegistrar.setVisible(true);
            }
        });
        menuCarros.add(registrarItem);

        JMenuItem listarItem = new JMenuItem("Listar Carros");
        listarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir formulario de lista de carros
                InterfazListarCarros interfazListar = new InterfazListarCarros(carrosRegistrados);
                desktopPane.add(interfazListar);
                interfazListar.setVisible(true);
            }
        });
        menuCarros.add(listarItem);

        frame.setVisible(true);
    }
}

class InterfazRegistrarCarro extends JInternalFrame {
    private ArrayList<Pregunta1PROGRAMACION> carrosRegistrados;

    private JTextField modeloField;
    private JTextField colorField;
    private JTextField placaField;
    private JRadioButton aTodoRiesgoRadioButton;
    private JRadioButton aTercerosRadioButton;
    private JTextField añoField;
    private JComboBox<String> tipoCarroComboBox;
    private JComboBox<String> tipoPinturaComboBox;

    public InterfazRegistrarCarro(ArrayList<Pregunta1PROGRAMACION> carrosRegistrados) {
        this.carrosRegistrados = carrosRegistrados;

        setTitle("Registrar Carro");
        setClosable(true);
        setResizable(true);
        setMaximizable(true);
        setIconifiable(true);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        modeloField = new JTextField();
        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);

        colorField = new JTextField();
        panel.add(new JLabel("Color:"));
        panel.add(colorField);

        placaField = new JTextField();
        panel.add(new JLabel("Placa:"));
        panel.add(placaField);

        ButtonGroup modalidadSeguroGroup = new ButtonGroup();
        aTodoRiesgoRadioButton = new JRadioButton("A todo Riesgo");
        aTercerosRadioButton = new JRadioButton("A terceros");
        modalidadSeguroGroup.add(aTodoRiesgoRadioButton);
        modalidadSeguroGroup.add(aTercerosRadioButton);
        panel.add(aTodoRiesgoRadioButton);
        panel.add(aTercerosRadioButton);

        añoField = new JTextField();
        panel.add(new JLabel("Año de Fabricación:"));
        panel.add(añoField);

        String[] tiposCarro = {"MINI", "UTILITARIO", "FAMILIAR", "DEPORTIVO"};
        tipoCarroComboBox = new JComboBox<>(tiposCarro);
        panel.add(new JLabel("Tipo de carro:"));
        panel.add(tipoCarroComboBox);

        String[] tiposPintura = {"Metalizada", "No Metalizada"};
        tipoPinturaComboBox = new JComboBox<>(tiposPintura);
        panel.add(new JLabel("Tipo de pintura:"));
        panel.add(tipoPinturaComboBox);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guardar los datos del carro
                String modelo = modeloField.getText();
                String color = colorField.getText();
                String placa = placaField.getText();
                String modalidadSeguro = aTodoRiesgoRadioButton.isSelected() ? "A todo riesgo" : "A terceros";
                int año = Integer.parseInt(añoField.getText());
                String tipo = (String) tipoCarroComboBox.getSelectedItem();
                String tipoPintura = (String) tipoPinturaComboBox.getSelectedItem();

                Pregunta1PROGRAMACION carro = new Pregunta1PROGRAMACION(modelo, color, placa, modalidadSeguro, año, tipo, tipoPintura);
                carrosRegistrados.add(carro);

                JOptionPane.showMessageDialog(null, "Carro registrado correctamente");

                // Limpiar campos
                modeloField.setText("");
                colorField.setText("");
                placaField.setText("");
                modalidadSeguroGroup.clearSelection();
                añoField.setText("");
                tipoCarroComboBox.setSelectedIndex(0);
                tipoPinturaComboBox.setSelectedIndex(0);
            }
        });
        panel.add(guardarButton);

        setContentPane(panel);
    }
}

class InterfazListarCarros extends JInternalFrame {
    private ArrayList<Pregunta1PROGRAMACION> carrosRegistrados;

    private JTable tablaCarros;
    private JTextField placaBuscarField;

    public InterfazListarCarros(ArrayList<Pregunta1PROGRAMACION> carrosRegistrados) {
        this.carrosRegistrados = carrosRegistrados;

        setTitle("Listar Carros");
        setClosable(true);
        setResizable(true);
        setMaximizable(true);
        setIconifiable(true);
        setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        tablaCarros = new JTable();
        tablaCarros.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {"Id", "Modelo", "Color", "Placa", "Modalidad seguro", "Año", "Tipo de Fabricación", "Tipo de Pintura"}
        ));
        panel.add(new JScrollPane(tablaCarros), BorderLayout.CENTER);

        placaBuscarField = new JTextField();
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Buscar carro por placa
                String placaBuscar = placaBuscarField.getText();

                DefaultTableModel model = (DefaultTableModel) tablaCarros.getModel();
                model.setRowCount(0);

                for (Pregunta1PROGRAMACION carro : carrosRegistrados) {
                    if (carro.getPlaca().equals(placaBuscar)) {
                        model.addRow(new Object[] {carro.getPlaca(), carro.getModelo(), carro.getColor(), carro.getPlaca(), carro.getModalidadSeguro(), carro.getAño(), carro.getTipo(), carro.getTipoPintura()});
                    }
                }
            }
        });

        panel.add(placaBuscarField, BorderLayout.NORTH);
        panel.add(buscarButton, BorderLayout.SOUTH);

        setContentPane(panel);
    }
}

import javax.swing.*;

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
        Pregunta1PROGRAMACION carro = new Pregunta1PROGRAMACION("Modelo", "Color", "Placa", "A todo riesgo", 2023, "MINI", "Metalizada");
        InterfazCarro interfaz = new InterfazCarro(carro);
    }
}

class InterfazCarro {
    private Pregunta1PROGRAMACION carro;

    private JTextField modeloField;
    private JTextField colorField;
    private JTextField placaField;
    private JRadioButton aTodoRiesgoRadioButton;
    private JRadioButton aTercerosRadioButton;
    private JTextField añoField;
    private JComboBox<String> tipoCarroComboBox;
    private JComboBox<String> tipoPinturaComboBox;

    public InterfazCarro(Pregunta1PROGRAMACION carro) {
        this.carro = carro;

        JFrame frame = new JFrame("Datos del Carro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        modeloField = new JTextField(carro.getModelo());
        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);

        colorField = new JTextField(carro.getColor());
        panel.add(new JLabel("Color:"));
        panel.add(colorField);

        placaField = new JTextField(carro.getPlaca());
        panel.add(new JLabel("Placa:"));
        panel.add(placaField);

        ButtonGroup modalidadSeguroGroup = new ButtonGroup();
        aTodoRiesgoRadioButton = new JRadioButton("A todo Riesgo");
        aTercerosRadioButton = new JRadioButton("A terceros");
        modalidadSeguroGroup.add(aTodoRiesgoRadioButton);
        modalidadSeguroGroup.add(aTercerosRadioButton);
        panel.add(aTodoRiesgoRadioButton);
        panel.add(aTercerosRadioButton);

        añoField = new JTextField(String.valueOf(carro.getAño()));
        panel.add(new JLabel("Año de Fabricación:"));
        panel.add(añoField);

        String[] tiposCarro = {"MINI", "UTILITARIO", "FAMILIAR", "DEPORTIVO"};
        tipoCarroComboBox = new JComboBox<>(tiposCarro);
        tipoCarroComboBox.setSelectedItem(carro.getTipo());
        panel.add(new JLabel("Tipo de carro:"));
        panel.add(tipoCarroComboBox);

        String[] tiposPintura = {"Metalizada", "No Metalizada"};
        tipoPinturaComboBox = new JComboBox<>(tiposPintura);
        tipoPinturaComboBox.setSelectedItem(carro.getTipoPintura());
        panel.add(new JLabel("Tipo de pintura:"));
        panel.add(tipoPinturaComboBox);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(e -> guardarCambios());
        panel.add(guardarButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void guardarCambios() {
        carro.setModelo(modeloField.getText());
        carro.setColor(colorField.getText());
        carro.setPlaca(placaField.getText());
        carro.setModalidadSeguro(aTodoRiesgoRadioButton.isSelected() ? "A todo riesgo" : "A terceros");
        carro.setAño(Integer.parseInt(añoField.getText()));
        carro.setTipo((String) tipoCarroComboBox.getSelectedItem());
        carro.setTipoPintura((String) tipoPinturaComboBox.getSelectedItem());
    }
}

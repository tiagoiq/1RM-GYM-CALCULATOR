import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RMCalculator {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Calculadora de RM por Tiago Ilacqua");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        // Crear los componentes
        JLabel labelRepeticiones = new JLabel("Repeticiones:");
        JTextField fieldRepeticiones = new JTextField();
        JLabel labelPeso = new JLabel("Peso:");
        JTextField fieldPeso = new JTextField();
        JLabel labelResultado = new JLabel("RM:");
        JLabel resultado = new JLabel("0.0");

        // Agregar un KeyListener para calcular el RM en tiempo real
        KeyAdapter calcularRM = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    double repeticiones = Double.parseDouble(fieldRepeticiones.getText());
                    double peso = Double.parseDouble(fieldPeso.getText());
                    double rm = repeticiones * peso * 0.0333 + peso;
                    resultado.setText(String.format("%.2f", rm));
                } catch (NumberFormatException ex) {
                    resultado.setText("0.0"); // Valor predeterminado si hay error
                }
            }
        };

        // Asociar el KeyListener a los campos de texto
        fieldRepeticiones.addKeyListener(calcularRM);
        fieldPeso.addKeyListener(calcularRM);

        // Agregar los componentes a la ventana
        frame.add(labelRepeticiones);
        frame.add(fieldRepeticiones);
        frame.add(labelPeso);
        frame.add(fieldPeso);
        frame.add(labelResultado);
        frame.add(resultado);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
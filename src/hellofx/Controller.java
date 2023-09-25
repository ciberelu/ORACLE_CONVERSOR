package hellofx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.util.converter.BigDecimalStringConverter;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class Controller implements Initializable {
    // Crear un formato con dos decimales
    DecimalFormat df = new DecimalFormat("#.##");

    @FXML
    private Label label;    

    @FXML
    private TextField textFieldNumerico;

    @FXML
    private TextField textResultado;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ComboBox<String> comboBox2;

    @FXML
    private Label lblError;

    

    private List<String> monedas = new ArrayList<String>(Arrays.asList("Dólar", "Quetzal","Euro", "Yen", "Libra esterlina", "Won sul-coreano"));

    
    
    

    @FXML
    void BtnClicked(ActionEvent event) {
        String monedaOriginalElegida = comboBox.getValue();
        String monedaAConvertir = comboBox2.getValue();

        if (monedaOriginalElegida == null || monedaAConvertir == null){
            lblError.setText("Por favor, escoja sus monedas");
            return;
        }
        lblError.setText("");
        Double montoOriginal = Double.valueOf(textFieldNumerico.getText());
        Double unidadConversionToDolar = Converter.getTipoCambioToDolar(monedaOriginalElegida);
        Double unidadConversion = Converter.getTipoCambioFromDolar(monedaAConvertir);

        Double resultadoConversion = Converter.convertir(montoOriginal, unidadConversion, unidadConversionToDolar);
        String numeroFormateado = df.format(resultadoConversion);
        textResultado.setText(String.valueOf(numeroFormateado));


    }

    @FXML
    void BtnReiniciarClicked(ActionEvent event) {
        
        textFieldNumerico.setText("0");
        textResultado.setText("0");

        
        comboBox.getSelectionModel().clearSelection(); // Limpiar la selección en el ComboBox
        comboBox2.getSelectionModel().clearSelection();

    }

    @FXML
    void BtnSalirClicked(ActionEvent event) {
        Platform.exit();

    }

    

    


















    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //agregar los elementos para seleccionar las monedas
        comboBox.getItems().addAll(monedas);
        comboBox2.getItems().addAll(monedas);

        // Crear un UnaryOperator que filtra la entrada para números y números decimales positivos
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("^[0-9]*\\.?[0-9]*$") || newText.isEmpty()) {
                return change;
            }
            return null;
        };

        // Crear un TextFormatter con el filtro
        TextFormatter<BigDecimal> textFormatter = new TextFormatter<>(new BigDecimalStringConverter(), BigDecimal.ZERO, filter);

        // Configurar el TextFormatter en el TextField
        textFieldNumerico.setTextFormatter(textFormatter);

        
        
        
    }
}
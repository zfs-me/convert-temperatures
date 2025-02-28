import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConvertTemps extends Application {
    private String baseTemp = "";
    public void start(Stage stage) {
        Label title = new Label("This converts between a base temperature to another unit");
        Label prompt = new Label("Enter temperature:");
        TextField input = new TextField();
        input.setMaxWidth(100);

        String[] units = {"Fahrenheit", "Celsius", "Kelvin"};
        ComboBox<String> cb = new ComboBox<>(FXCollections.observableArrayList(units));
        cb.setOnAction(e -> {
            baseTemp = cb.getValue();
            //System.out.println("set to " + baseTemp);
        });
	
	Label resultLabel = new Label("");

        Label prompt2 = new Label("Choose what to convert to");
        Button btnCelsius = new Button("Celsius");
        Button btnFahrenheit = new Button("Fahrenheit");
        Button btnKelvin = new Button("Kelvin");
        btnCelsius.setMaxWidth(100);
        btnFahrenheit.setMaxWidth(100);
        btnKelvin.setMaxWidth(100);

        Convert conv = new Convert();
        btnCelsius.setOnAction(e -> {
            double temp = Double.parseDouble(input.getText());
            double result = conv.convert(baseTemp, temp, "Celsius");
	    resultLabel.setText(result + " °C");
        });
        btnFahrenheit.setOnAction(e -> {
            double temp = Double.parseDouble(input.getText());
            double result = conv.convert(baseTemp, temp, "Fahrenheit");
	    resultLabel.setText(result + " °F");
        });
        btnKelvin.setOnAction(e -> {
            double temp = Double.parseDouble(input.getText());
            double result = conv.convert(baseTemp, temp, "Kelvin");
	    resultLabel.setText(result + " °K");
        });

        VBox top = new VBox(5, title);
        top.setPadding(new Insets(30, 0, 50, 0));
        top.setAlignment(Pos.CENTER);

        GridPane gp = new GridPane();
        gp.addRow(0, prompt, input, cb);
        gp.setAlignment(Pos.TOP_CENTER);
        gp.setHgap(10);

        VBox centerButtons = new VBox(10, prompt2, btnCelsius, btnFahrenheit, btnKelvin, resultLabel);
        centerButtons.setAlignment(Pos.TOP_CENTER);

        VBox center = new VBox(5, gp, centerButtons);

        BorderPane bp = new BorderPane();
        bp.setTop(top);
        bp.setCenter(center);

        Scene scene = new Scene(bp, 800, 400);
        stage.setScene(scene);
        stage.setTitle("Temperature Converter");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}


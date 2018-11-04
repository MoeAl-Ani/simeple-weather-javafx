package com.moe.weather;

import com.moe.weather.model.WeatherResult;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeatherMainApp extends Application {


    @Override
    public void start(Stage stage) {
        Button button = new Button("search");
        Label cityNameLab = new Label("city:");
        Label cityNameVal = new Label("");
        Label cityTempLab = new Label("temp:");
        Label cityTempVal = new Label("");
        HBox h1 = new HBox();
        h1.getChildren().addAll(cityNameLab,cityNameVal);
        HBox h2 = new HBox();
        h2.getChildren().addAll(cityTempLab,cityTempVal);

        TextField city = new TextField();
        city.setPromptText("enter city");

        button.setOnAction(e -> {
            WeatherResult ouluWeather = new OpenWeatherService().getWetherByCity(city.getText());
            cityTempLab.setText(String.valueOf(ouluWeather.getMain().getTemp()));
            cityNameVal.setText(city.getText());
        });

        VBox v = new VBox();
        v.getChildren().addAll(h1,h2,city,button);
        Scene scene = new Scene(v, 300, 200);
        stage.setScene(scene);

        stage.setTitle("FxSample");
        stage.show();
    }

    public static void main(String[]  args) {
        launch(args);
    }
}

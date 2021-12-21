package com.jpro.hellojpro;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJPro extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        HBox hbx = new HBox(10);

        ComboBox cbo = new ComboBox();
        cbo.getItems().addAll("Pakistan", "Turkey", "Indonashia");

        DatePicker dpk = new DatePicker();

        ColorPicker cpk = new ColorPicker();

        hbx.getChildren().addAll(cbo, dpk, cpk);

        ScrollPane spnMain = new ScrollPane();
        spnMain.setPannable(true);
        spnMain.setFitToWidth(true);
        spnMain.setFitToHeight(true);
        VBox.setVgrow(spnMain, Priority.ALWAYS);

        Pagination pagination = new Pagination();
        pagination.setMinHeight(Region.USE_PREF_SIZE);

        pagination.setPageFactory((pageIndex) -> {
            FlowPane flowpaneCards = new FlowPane();
            flowpaneCards.setHgap(10);
            flowpaneCards.setVgap(10);
            flowpaneCards.prefWrapLengthProperty().bind(stage.widthProperty());

            StackPane stkCard;

            for (int i = 0; i < 100; i++) {
                stkCard = new StackPane();
                stkCard.setPrefSize(300, 240);
                stkCard.setStyle("-fx-background-color: pink;");

                Label lblText = new Label("Card " + i);

                stkCard.getChildren().add(lblText);

                flowpaneCards.getChildren().add(stkCard);
            }

            return flowpaneCards;
        });

        spnMain.setContent(pagination);

        root.getChildren().addAll(hbx, spnMain);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}

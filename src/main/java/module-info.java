module com.example.gomes {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires javafx.media;

    opens com.example.gomes to javafx.fxml;
    exports com.example.gomes;
    exports com.example;
    opens com.example to javafx.fxml;
}
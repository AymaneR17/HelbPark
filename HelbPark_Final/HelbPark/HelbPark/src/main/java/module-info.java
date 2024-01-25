module com.example.helbpark {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.helbpark to javafx.fxml;
    exports com.example.helbpark;
}
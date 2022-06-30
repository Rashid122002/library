module kg.kstu.library_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons.dbcp;

    opens kg.kstu.library_fx.model to javafx.fxml;
    opens kg.kstu.library_fx.controller to javafx.fxml;

    exports kg.kstu.library_fx.model;
    exports kg.kstu.library_fx.controller;
    exports kg.kstu.library_fx;
}
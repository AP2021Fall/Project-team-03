module com.example.project03withfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project03withfx to javafx.fxml;
    exports com.example.project03withfx;
    exports com.example.project03withfx.fxView;
    opens com.example.project03withfx.fxView to javafx.fxml;
}
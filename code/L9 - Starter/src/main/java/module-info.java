module edu.westga.cs1302.password_generator {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
	requires javafx.base;

    opens edu.westga.cs1302.password_generator.view to javafx.fxml;
    exports edu.westga.cs1302.password_generator;
}

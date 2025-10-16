module edu.westga.cs1302.task_tracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens edu.westga.cs1302.task_tracker.views to javafx.fxml;
    exports edu.westga.cs1302.task_tracker;
}

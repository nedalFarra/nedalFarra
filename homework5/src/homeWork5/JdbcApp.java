
package homeWork5;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class JdbcApp extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane paneTableView = FXMLLoader.load(getClass().getResource("TableViewPane.fxml"));
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("tableView", paneTableView);
        Scene scene = new Scene(mapPanes.get("tableView"));
        primaryStage.setTitle("Streams and Database App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

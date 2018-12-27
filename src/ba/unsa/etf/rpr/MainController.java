package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class MainController implements Initializable {
    public BorderPane pane;
    public ListView lista;
    private GeografijaDAO baza ;

    public MainController() {
        baza = GeografijaDAO.getInstance();
//        GradoviReport report = new GradoviReport();
//        try {
//            report.showReport(GeografijaDAO.getConnection());
//        } catch (JRException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void selectLanguage(Locale locale) {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        Locale.setDefault(locale);
        ResourceBundle bundle = ResourceBundle.getBundle("Translation");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("prozor.fxml"), bundle);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(480);
    }

    private void refreshList(){

    }

    public void setBa(ActionEvent actionEvent) {
        selectLanguage(new Locale("bs","BA"));
    }

    public void setEn(ActionEvent actionEvent) {
        selectLanguage(new Locale("en","US"));
    }

    public void setDe(ActionEvent actionEvent) {
        selectLanguage(new Locale("de","DE"));
    }

    public void setFr(ActionEvent actionEvent) {
        selectLanguage(new Locale("fr","FR"));
    }

    public void deleteCountry(ActionEvent actionEvent) {

    }

    public void addCountry(ActionEvent actionEvent) {

    }

    public void editCity(ActionEvent actionEvent) {

    }

    public void addCity(ActionEvent actionEvent) {

    }

    public void load(ActionEvent actionEvent) {

    }
}

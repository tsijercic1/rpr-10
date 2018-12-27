package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Main extends Application{


    private static GeografijaDAO baza;
    public static void main(String[] args) {
        launch(args);
    }

    private static void glavniGrad() {
        GeografijaDAO baza = GeografijaDAO.getInstance();
        String drzava;
        System.out.print("Unesite ime drzave: ");
        Scanner tok = new Scanner(System.in);
        drzava = tok.nextLine();
        Grad grad = baza.glavniGrad(drzava);
        System.out.println(grad.getNaziv());


    }

    public static String ispisiGradove() {
        baza = GeografijaDAO.getInstance();
        ArrayList<Grad> gradovi = baza.gradovi();
        StringBuilder res= new StringBuilder();
        for(Grad x : gradovi){
            res.append(x.getNaziv()).append(" (").append(x.getDrzava().getNaziv()).append(") - ").append(x.getBrojStanovnika()).append("\n");
        }
        return res.toString();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(new Locale("bs","BA"));
        ResourceBundle bundle = ResourceBundle.getBundle("Translation");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("prozor.fxml"), bundle);
        Parent root = loader.load();
        primaryStage.setTitle("Države i gradovi");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();

    }
}

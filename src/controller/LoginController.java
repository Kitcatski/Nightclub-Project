package controller;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;
import view.*;

/**
 * Created by Eric on 11/5/2016.
 */
public class LoginController {

    public LoginController(PeopleBag peopleBag, Pane4CreateAccount pane4CreateAccount,Pane4Customer pane4Customer, Pane4Login pane4Login, Pane4Owner pane4Owner, Pane4Manager pane4Manager, Stage stage) {

        pane4Login.getCreateAccount().setOnAction(e ->{
            stage.setScene(pane4CreateAccount.getScene());

        });
        pane4Login.getLoginButton().setOnAction(e ->{

            Person p1 = peopleBag.findByUsername(pane4Login.getUsername().getText());
            if(p1 == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect Username/Password");
                alert.showAndWait();
            }
            else if(!pane4Login.getUsername().getText().equals(p1.getUsername())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect Username/Password");
                alert.showAndWait();
            }

            else if(p1.getPassword().equals(pane4Login.getPassword().getText()) && p1 instanceof Owner) {
                stage.setScene(pane4Owner.getScene());
                stage.centerOnScreen();
                pane4Login.getUsername().clear();
                pane4Login.getPassword().clear();

            }
            else if(p1.getPassword().equals(pane4Login.getPassword().getText()) && p1 instanceof Manager){
                stage.close();
                stage.setScene(pane4Manager.getScene());
                stage.centerOnScreen();
                stage.show();
                pane4Manager.getLoggedInAs().setText(p1.getFirstName());
                pane4Login.getUsername().clear();
                pane4Login.getPassword().clear();
                }
            else if(p1.getPassword().equals(pane4Login.getPassword().getText()) && p1 instanceof Customer){

                stage.setScene(pane4Customer.getScene());
                stage.centerOnScreen();
                pane4Customer.getCustomerName().setText(p1.getFirstName() + " | " +  p1.getUsername());
                pane4Login.getUsername().clear();
                pane4Login.getPassword().clear();
            }

            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Password incorrect.");
                alert.showAndWait();
            }


        });






    }

}

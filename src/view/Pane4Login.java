package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;



import static javafx.scene.paint.Color.RED;


/**
 * Created by Kitcatski on 11/2/2016.
 */
public class Pane4Login {
    private Scene scene;
    private GridPane loginPane;
    private HBox usernameBox;
    private HBox passwordBox;
    private VBox pane;
    private HBox textBox;
    private VBox buttonBox;
    private HBox accountBox;
    private HBox titleBox;
    private Text title;
    private Label username;
    private Text login;
    private Label password;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private TextFlow createAccount;
    private Hyperlink createAccountClick;


    public Pane4Login(){
        //Panes
        loginPane = new GridPane();
        loginPane.setPadding(new Insets(20,20,20,20));
        usernameBox = new HBox();
        usernameBox.setPadding(new Insets(20,20,20,20));
        usernameBox.setSpacing(15);
        passwordBox = new HBox();
        passwordBox.setPadding(new Insets(20,20,20,20));
        passwordBox.setSpacing(20);
        textBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER);
        accountBox = new HBox();
        accountBox.setAlignment(Pos.CENTER);
        titleBox = new HBox();
        titleBox.setPadding(new Insets(0,0,50,0));
        titleBox.setAlignment(Pos.CENTER);
        pane = new VBox();
        //Labels and Text
        login = new Text("Log In");
        login.setFont(Font.font("Century Gothic",30));
        login.setFill(Color.WHITE);
        username = new Label("Username: ");
        password = new Label("Password: ");
        title = new Text("FirePaw");
        title.setFont(Font.font("arial",50));
        title.setFill(RED);
        title.setEffect(new GaussianBlur());
        createAccountClick = new Hyperlink("Click here!");
        createAccount = new TextFlow(new Text("Don't have an account?"), createAccountClick);
        //Fields and Buttons
        usernameField = new TextField();
        usernameField.setStyle("-fx-background: #AFCEC4");
        passwordField = new PasswordField();
        loginButton = new Button("Submit");
        loginButton.defaultButtonProperty().bind(loginButton.focusedProperty());
        //Adding nodes to box's
        textBox.getChildren().add(login);
        buttonBox.getChildren().add(loginButton);
        accountBox.getChildren().add(createAccount);
        usernameBox.getChildren().addAll(username,usernameField);
        passwordBox.getChildren().addAll(password,passwordField);
        titleBox.getChildren().add(title);
        //Add box's to pane
        pane.getChildren().addAll(titleBox,textBox,usernameBox,passwordBox,buttonBox,accountBox);
        //Add pane to the gridPane
        loginPane.getChildren().add(pane);
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setStyle("-fx-background: #AFCEC4;");
        //Add pane to scene
        scene = new Scene(loginPane,600,600);




    }
    public Scene getScene(){
        return scene;
    }
    public GridPane getLoginPane() {
        return loginPane;
    }

    public void setLoginPane(GridPane loginPane) {
        this.loginPane = loginPane;
    }

    public TextField getUsername() {
        return usernameField;
    }

    public TextField getPassword() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Hyperlink getCreateAccount(){
        return createAccountClick;
    }
}

package mss.modern_school_system.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import mss.modern_school_system.MSSApplication;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Welcome implements Initializable {

    @FXML
    private ImageView showPassword;
    @FXML
    private ImageView hidePassword;

    //InputBox Error Message
    @FXML
    private Label errorMsgEmailLogin;
    @FXML
    private Label errorMsgPwLogin;
    @FXML
    private Label errorMsgUsername;
    @FXML
    private Label errorMsgPwSignup;
    @FXML
    private Label errorMsgEmailSignup;

    //InputBox
    @FXML
    private TextField emailFieldLogin;
    @FXML
    private TextField emailFieldSignup;
    @FXML
    private PasswordField pwFieldLogin;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField pwFieldSignup;

    //Button
    @FXML
    private Button createBtn;
    @FXML
    private Button loginBtn;

    //Link to display Form (Create Acc & Login Acc).
    @FXML
    public Label signupLink;
    public Label loginLink;

    //Login and Signup Section
    @FXML
    private Group createAccForm;
    @FXML
    private Group loginAccForm;

    //CheckBox (Policy/terms)
    @FXML
    private Rectangle checkBox;
    @FXML
    private ImageView checkBoxMark;

    //The count variable is use to keep track of the input field
    private int count = 0;
    private Stage stage;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emailFieldLogin.setText("samie@gmail.com");
        pwFieldLogin.setText("1234");
        setVisibility();
        checkInputField();
        changeSection();
        buttonAction();

        checkBoxToggle();
        //setPasswordToggle();
    }

    public void checkBoxToggle(){
        checkBox.setOnMouseClicked(e->{
            checkBox.setVisible(false);
            checkBoxMark.setVisible(true);
        });
        checkBoxMark.setOnMouseClicked(e->{
            checkBoxMark.setVisible(false);
            checkBox.setVisible(true);
        });
    }
    public void setPasswordToggle(){
        hidePassword.setVisible(false);
        showPassword.setOnMouseClicked(e-> {
            showPassword.setVisible(false);
            hidePassword.setVisible(true);
            //pwField.setVisible(false);
            //showPwField.setText(pwField.getText());
            //showPwField.setVisible(true);
        });
        hidePassword.setOnMouseClicked(e->{
            hidePassword.setVisible(false);
            showPassword.setVisible(true);
            //pwField.setText(showPwField.getText());
            //showPwField.setVisible(false);
            //pwField.setVisible(true);
        });

    }

    public void checkInputField(){
        loginSection();
        signupSection();
    }
    private void setVisibility(){
        errorMsgEmailLogin.setVisible(false);
        errorMsgPwLogin.setVisible(false);
        errorMsgEmailSignup.setVisible(false);
        errorMsgUsername.setVisible(false);
        errorMsgPwSignup.setVisible(false);

    }

    private void changeSection(){
        signupLink.setOnMouseClicked(e->{
            loginAccForm.setVisible(false);
            createAccForm.setVisible(true);

            pwFieldSignup.setStyle("-fx-border-color: #C8C8C8;");
            usernameField.setStyle("-fx-border-color: #C8C8C8;");
            emailFieldSignup.setStyle("-fx-border-color: #C8C8C8;");
            setVisibility();
            count = 0;
        });

        loginLink.setOnMouseClicked(e->{
            createAccForm.setVisible(false);
            loginAccForm.setVisible(true);

            pwFieldLogin.setStyle("-fx-border-color: #C8C8C8;");
            emailFieldLogin.setStyle("-fx-border-color: #C8C8C8;");
            setVisibility();
            count = 0;
        });
    }

    private void loginSection(){

        emailFieldLogin.setOnMouseClicked(e->{
            count++;
            if (count > 1 && isEmpty(pwFieldLogin, errorMsgPwLogin));

            if (!isEmpty(pwFieldLogin) )
                fieldChangeMode(pwFieldLogin, "-fx-border-color: #C8C8C8;", errorMsgPwLogin);

            if (!isEmpty(emailFieldLogin)) {
                fieldChangeMode(emailFieldLogin, "-fx-border-color: #46949a;", errorMsgEmailLogin);
            }
        });
        pwFieldLogin.setOnMouseClicked(e->{
            if (isEmpty(emailFieldLogin, errorMsgEmailLogin));

            if (!isEmpty(emailFieldLogin))
                fieldChangeMode(emailFieldLogin, "-fx-border-color: #C8C8C8;", errorMsgEmailLogin);

            if (!isEmpty(pwFieldLogin)) {
                fieldChangeMode(pwFieldLogin, "-fx-border-color: #46949a;", errorMsgPwLogin);
            }
        });
    }
    private void signupSection(){
        emailFieldSignup.setOnMouseClicked(e->{
            if (count>=1 && isEmpty(pwFieldSignup, errorMsgPwSignup));
            if (count>=1 && isEmpty(usernameField, errorMsgUsername));

            if (!isEmpty(pwFieldSignup))
                fieldChangeMode(pwFieldSignup, "-fx-border-color: #C8C8C8;", errorMsgPwSignup);

            if (!isEmpty(usernameField))
                fieldChangeMode(usernameField, "-fx-border-color: #C8C8C8;", errorMsgUsername);

            if (isEmpty(emailFieldSignup)) {
                fieldChangeMode(emailFieldSignup, "-fx-border-color: #46949a;", errorMsgEmailSignup);
            }
        });
        usernameField.setOnMouseClicked(e->{
            count++;
            if (isEmpty(emailFieldSignup, errorMsgEmailSignup));
            if (count>2 && isEmpty(pwFieldSignup, errorMsgPwSignup));

            if (!isEmpty(pwFieldSignup))
                fieldChangeMode(pwFieldSignup, "-fx-border-color: #C8C8C8;", errorMsgPwSignup);

            if (!isEmpty(emailFieldSignup))
                fieldChangeMode(emailFieldSignup, "-fx-border-color: #C8C8C8;", errorMsgEmailSignup);


            if (isEmpty(usernameField)) {
                fieldChangeMode(usernameField, "-fx-border-color: #46949a;", errorMsgUsername);
            }
        });
        pwFieldSignup.setOnMouseClicked(e->{
            if (isEmpty(emailFieldSignup, errorMsgEmailSignup));
            if (isEmpty(usernameField, errorMsgUsername));

            if (!isEmpty(emailFieldSignup))
                fieldChangeMode(emailFieldSignup, "-fx-border-color: #C8C8C8;", errorMsgEmailSignup);

            if (!isEmpty(usernameField))
                fieldChangeMode(usernameField, "-fx-border-color: #C8C8C8;", errorMsgUsername);

            if (isEmpty(pwFieldSignup)) {
                fieldChangeMode(pwFieldSignup, "-fx-border-color: #46949a;", errorMsgPwSignup);
            }
        });

    }
    private void buttonAction(){
         loginBtn.setOnAction(e->{
            if(validateLoginBtn()) {
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(MSSApplication.class.getResource("fxml/dashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.getIcons().add(new Image(MSSApplication.class.getResourceAsStream("images/bobfilogo.png")));
                    MSSApplication.primaryStage.hide();
                    stage.setMaximized(true);
                    stage.show();

                    scene.getWindow().centerOnScreen();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        createBtn.setOnAction(e->{
            if (!isEmpty(emailFieldSignup, errorMsgEmailSignup)){
                if (!emailValidation(emailFieldSignup.getText())){
                    emailFieldSignup.setStyle(
                            "-fx-border-color: RED;"
                    );
                    errorMsgEmailSignup.setText("Please enter a valid email");
                    errorMsgEmailSignup.setVisible(true);
                }
                else {
                    fieldChangeMode(emailFieldSignup, "-fx-border-color: #C8C8C8;", errorMsgEmailSignup);
                }
            }
            if(!isEmpty(pwFieldSignup,errorMsgPwSignup)){
                fieldChangeMode(pwFieldSignup, "-fx-border-color: #C8C8C8;", errorMsgPwSignup);
            }
            if (!isEmpty(usernameField,errorMsgUsername)){
                fieldChangeMode(usernameField, "-fx-border-color: #C8C8C8;", errorMsgUsername);
            }
            if (checkBox.isVisible()){
                checkBox.setStyle("-fx-stroke: RED");
            }
            else{
                checkBox.setStyle("-fx-stroke: #C8C8C8;");
            }
        });
    }

    private boolean emailValidation(String emailAddress){
        return EmailValidator.getInstance()
                .isValid(emailAddress);
    }

    private boolean isEmpty(TextField field, Label error){
        if (field.getText().isEmpty()){
            field.setStyle("-fx-border-color: RED;");
            error.setVisible(true);
            return true;
        }
        return false;
    }
    private boolean isEmpty(TextField field){
        if (field.getText().isEmpty()){
            return true;
        }
        return false;
    }

    private void fieldChangeMode(TextField field, String style, Label error ){
        field.setStyle(style);
        error.setVisible(false);
    }

    private boolean validateLoginBtn(){
        if(!isEmpty(pwFieldLogin,errorMsgPwLogin)){
            fieldChangeMode(pwFieldLogin, "-fx-border-color: #C8C8C8;", errorMsgPwLogin);
        }

        if (!isEmpty(emailFieldLogin, errorMsgEmailLogin)){
            if (!emailValidation(emailFieldLogin.getText())){
                emailFieldLogin.setStyle(
                        "-fx-border-color: RED;"
                );
                errorMsgEmailLogin.setText("Please enter a valid email");
                errorMsgEmailLogin.setVisible(true);
            }
            else {
                fieldChangeMode(emailFieldLogin, "-fx-border-color: #C8C8C8;", errorMsgEmailLogin);
            }
        }
        return !isEmpty(pwFieldLogin,errorMsgPwLogin) && !isEmpty(emailFieldLogin, errorMsgEmailLogin) && emailValidation(emailFieldLogin.getText());
    }
}

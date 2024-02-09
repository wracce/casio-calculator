package com.example.ooplqb8;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Lab8Controller {
    Calculater calculater = new Calculater();

    @FXML
    public Label screen;

    @FXML
    public void onClickButton(ActionEvent actionEvent) {
        char code = ((Node)actionEvent.getSource()).getUserData().toString().charAt(0);
        switch (code) {
            case ('!'):
                Stage stage = (Stage) screen.getScene().getWindow();
                stage.close();
                break;
            case ('0'):
                calculater.addDigit(0);
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            case ('1'):
                calculater.addDigit(1);
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            case ('2'):
                calculater.addDigit(2);
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            case ('3'):
                calculater.addDigit(3);
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            case ('4'):
                calculater.addDigit(4);
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            case ('5'):
                calculater.addDigit(5);
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            case ('6'):
                calculater.addDigit(6);
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            case ('7'):
                calculater.addDigit(7);
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            case ('8'):
                calculater.addDigit(8);
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            case ('9'):
                calculater.addDigit(9);
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            case ('.'):
                calculater.addDot();
                screen.setText(String.valueOf(calculater.getDigit()));
                break;
            default:
                doAction(code);
                break;

        }
    }

    private void doAction(char code) {
        switch (calculater.calculate()) {
            case 1:
                screen.setText("Div by zero\n");
                break;
            case 2:
                screen.setText("Negative root\n");
                break;
            default:
                screen.setText(String.valueOf(calculater.printNum()));
                calculater.setOperator(code);
                if (code == 'C' || code ==  '√') {
                    switch (calculater.calculate()) {
                        case 1:
                            screen.setText("Div by zero\n");
                            break;
                        case 2:
                            screen.setText("Negative root\n");
                            break;
                        default:
                            screen.setText(String.valueOf(calculater.printNum()));
                            break;
                    }
                }
                break;
        }
    }

    @FXML
    public void onKeyPresed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case ESCAPE -> {
                Stage stage = (Stage) screen.getScene().getWindow();
                stage.close();
            }
            case NUMPAD0, DIGIT0 -> {
                calculater.addDigit(0);
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case NUMPAD1, DIGIT1 -> {
                calculater.addDigit(1);
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case NUMPAD2, DIGIT2 -> {
                calculater.addDigit(2);
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case NUMPAD3, DIGIT3 -> {
                calculater.addDigit(3);
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case NUMPAD4, DIGIT4 -> {
                calculater.addDigit(4);
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case NUMPAD5, DIGIT5 -> {
                calculater.addDigit(5);
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case NUMPAD6, DIGIT6 -> {
                calculater.addDigit(6);
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case NUMPAD7, DIGIT7 -> {
                calculater.addDigit(7);
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case NUMPAD8, DIGIT8 -> {
                calculater.addDigit(8);
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case NUMPAD9, DIGIT9 -> {
                calculater.addDigit(9);
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case DECIMAL, SEPARATOR -> {
                calculater.addDot();
                screen.setText(String.valueOf(calculater.getDigit()));
            }
            case MINUS, SUBTRACT -> doAction('-');
            case PLUS, ADD -> doAction('+');
            case MULTIPLY -> doAction('x');
            case DIVIDE -> doAction('/');
            case DELETE,BACK_SPACE -> doAction('C');
            case S -> doAction('√');
            case EQUALS, ENTER -> doAction('=');
        }
    }
}
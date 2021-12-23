package com.example.hellofx;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;


public class HelloController {
    @FXML
    private ImageView img;

    @FXML
    private ImageView p1;

    @FXML
    private ImageView p2;

    @FXML
    private AnchorPane ap;

    @FXML
    private ImageView imagePlay;

    @FXML
    private ImageView imageQuit;

    @FXML
    private ImageView arrow;


    private static int j = 0;
    private int step = 1;
    private static int i = 0;

    private static int count = 1;

    private int player1Count = 0;
    private int player2Count = 0;

    Player player1 = new Player(player2Name, p1);
    Player player2 = new Player(player1Name, p2);

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField p1pl;

    @FXML
    private TextField p2pl;


    @FXML
    private ImageView diceImage;

    @FXML
    private Button rollButton;

    private static int num = 0;

    private static File file;

    @FXML
    void roll(ActionEvent event) throws  IOException {

        Random random = new Random();
        Thread thread = new Thread(){

            public void run(){
                try {
//                    rollButton.setDisable(false);
                    arrow.setVisible(false);
                    for (int i = 0; i < 12; i++) {
                        num=random.nextInt(6)+1;
                        file = new File("src/main/resources/com/example/hellofx/dice" + (num)+".png");
                        diceImage.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);
                    }
                    arrow.setVisible(true);
//                    rollButton.setDisable(false);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        move(num);

    }

    Game game = new Game();
    Board board = new Board();

    @FXML
    private Button exit;

    @FXML
    public void ExitButton(ActionEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }


    public void move(int num) throws IOException {
        if(count%2!=0 && player2Count==0 && num==1){

            p1.setTranslateY(p1.getTranslateY()-57);
            moveInPositiveDirection(player2, num-1, p1);
            player2Count = player2Count + (num);

            if(board.getSnakes().containsKey(player2Count)){
                Thread thread = new Thread(){
                    public void run(){
                        try{
                            System.out.println("Snake");
                            Thread.sleep(1000);
                            moveInNegativeDirection(player2, board.getSnakes().get(player2Count), p1);
                            player2Count = player2Count - board.getSnakes().get(player2Count);
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();

            }

            if(board.getLadders().containsKey(player2Count)){
                Thread thread = new Thread(){
                    public void run(){
                        try{
                            System.out.println("Ladder");
                            Thread.sleep(1000);
                            moveInPositiveDirection(player2, board.getLadders().get(player2Count), p1);
//                            translate(board.getLaddersCoordinate(), player2Count , p1);

                            player2Count = player2Count + board.getLadders().get(player2Count);
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        }

        else if( count%2==0 && player1Count == 0 && num==1){
            p2.setTranslateY(p2.getTranslateY()-27);
            moveInPositiveDirection(player1, num-1, p2);
            player1Count = player1Count + (num );

            if(board.getSnakes().containsKey(player1Count)){
                Thread thread = new Thread(){
                    public void run(){
                        try{
                            Thread.sleep(1000);
                            System.out.println("Snake");
                            moveInNegativeDirection(player1, board.getSnakes().get(player1Count), p2);
                            player1Count = player1Count - board.getSnakes().get(player1Count);
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }

            if(board.getLadders().containsKey(player1Count)){
                Thread thread = new Thread(){
                    public void run(){
                        try{
                            System.out.println("Ladder");
                            Thread.sleep(1000);
                            moveInPositiveDirection(player1, board.getLadders().get(player1Count), p2);
//                            translate(board.getLaddersCoordinate(), player1Count, p2);

                            player1Count = player1Count + board.getLadders().get(player1Count);
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }

        }

        else {
            if(player1Count>0 && count%2==0){

                if(game.isValidMove(player1, num, player1Count)){
                    System.out.println("Player1 pos: "+player1Count);

                    if(!game.isComplete(player1Count + num)) {

                        moveInPositiveDirection(player1, num, p2);
                        player1Count = player1Count + num;

                        if(board.getSnakes().containsKey(player1Count)){

                            Thread thread = new Thread(){
                                public void  run(){
                                    try{
                                        System.out.println("Snake");
                                        Thread.sleep(1000);
                                        moveInNegativeDirection(player1, board.getSnakes().get(player1Count), p2);
                                        player1Count = player1Count - board.getSnakes().get(player1Count);
                                    }
                                    catch (InterruptedException e){
                                        e.printStackTrace();
                                    }
                                }
                            };
                            thread.start();
                        }

                        if(board.getLadders().containsKey(player1Count)){
                            Thread thread = new Thread(){
                                public void  run(){
                                    try {
                                        Thread.sleep(1000);
                                        System.out.println("Ladder");
                                        moveInPositiveDirection(player1, board.getLadders().get(player1Count), p2);
//                                        translate(board.getLaddersCoordinate(), player1Count , p2);
                                        player1Count = player1Count + board.getLadders().get(player1Count);

                                    }
                                    catch (InterruptedException e){
                                        e.printStackTrace();
                                    }
                                }
                            };
                            thread.start();
                        }
                    }
                    else {
                        end(player1);
                    }

                }
            } else if(player2Count>0 && count%2!=0) {
                if(game.isValidMove(player2, num, player2Count)){
                    System.out.println("Player pos2: "+player2Count);
                    if(!game.isComplete(player2Count+num)){
                        moveInPositiveDirection(player2, num, p1);
                        player2Count = player2Count + num;
                        if(board.getSnakes().containsKey(player2Count)){
                            Thread thread = new Thread(){
                                public void run(){
                                    try {
                                        Thread.sleep(1000);
                                        System.out.println("Snake");
                                        moveInNegativeDirection(player2, board.getSnakes().get(player2Count), p1);
                                        player2Count = player2Count - board.getSnakes().get(player2Count);
                                    }
                                    catch (InterruptedException e){
                                        e.printStackTrace();
                                    }
                                }
                            };
                            thread.start();
                        }
                        if(board.getLadders().containsKey(player2Count)){
                            Thread thread = new Thread(){
                                public void run(){
                                    try{
                                        System.out.println("Ladder");
                                        Thread.sleep(1000);
                                        moveInPositiveDirection(player2, board.getLadders().get(player2Count), p1);
//                                        translate(board.getLaddersCoordinate(), player2Count , p1);
                                        player2Count = player2Count + board.getLadders().get(player2Count);
                                    }
                                    catch (InterruptedException e){
                                        e.printStackTrace();
                                    }
                                }
                            };
                            thread.start();
                        }
                    }
                    else{
                        end(player2);
                    }
                }
            }
        }
        count++;
    }

    public void translate(HashMap<Integer, int []> hashMap, int number, Circle p){
        System.out.println("translate Called: "+number);

        TranslateTransition tt = new TranslateTransition(Duration.millis(200), p);
        int arr [] = hashMap.get(number);
        int i = arr[0];
        int j = arr[1];
        tt.setByX((i)*40);
        tt.setByY((j)*57);
        tt.play();
    }

    public void SwitchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("first.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void SwitchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("select.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void SwitchToSceneAtWhichPlayerShowUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("select.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void SwitchToScene3Hint(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hint.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public static String player1Name ;
    public static String player2Name ;

    public static String WinnerName;

    public void end(Player p) throws IOException {
        WinnerName =  p.getName();
        Stage st = (Stage) ap.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("ending.fxml"));
        Parent root = fxmlLoader.load();

        Label n1 = (Label) root.lookup("#Winner");
        n1.setText(WinnerName);

        Scene sc = new Scene(root);
        st.setScene(sc);
        st.show();

//        Parent root = FXMLLoader.load(getClass().getResource("end.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();


    }

    public void SwitchToScene4Game(ActionEvent event) throws IOException {
        player1Name = p1pl.getText();
        player2Name =  p2pl.getText();

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Label n1 = (Label) root.lookup("#Name1");
        Label n2 = (Label) root.lookup("#Name2");

        n1.setText(player1Name);
        n2.setText(player2Name);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

//        System.out.println(player1Name);
//        System.out.println(player2Name);
//
////        Name1.setText(player1Name);
////        Name2.setText(player2Name);
//
//        System.out.println(player1Name);
//        System.out.println(player2Name);
    }

    public void SwitchToScene3Exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("first.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void moveInNegativeDirection(Player p, int num, ImageView p1){
        j = p.getJth();
        step = 0;
        i = p.getIth();

        Thread thread = new Thread(){
            public void run(){
                try {
                    while(step < num){
                        if(i%2!=0){
                            if(j==0){
                                p1.setTranslateY(p1.getTranslateY() + 57);
                                Thread.sleep(100);
                                j = 9;
                                i++;
                                step++;
                            }
                            else{
                                p1.setTranslateX(40+ p1.getTranslateX());
                                Thread.sleep(100);
                                j--;
                                step++;

                            }
                        }
                        else{
                            if(j==0){
                                p1.setTranslateY(p1.getTranslateY() + 57);
                                Thread.sleep(100);
                                j = 9;
                                i++;
                                step++;
                            }
                            else{
                                p1.setTranslateX(p1.getTranslateX()-40);
                                Thread.sleep(100);
                                j--;
                                step++;

                            }
                        }
                    }
                    p.setJth(j);
                    p.setIth(i);
                    p.setPosition( p.getPosition() - num);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void moveInPositiveDirection(Player p, int num, ImageView p1){
        j = p.getJth();
        step = 0;
        i = p.getIth();

        Thread thread = new Thread(){
            public void run(){
                try {
                    while(step < num){
                        if(i%2==0){
                            if(j==9){
                                p1.setTranslateY(p1.getTranslateY() - 57);

                                Thread.sleep(100);
                                j = 0;
                                i++;
                                step++;
                            }
                            else{
                                p1.setTranslateX(40+ p1.getTranslateX());
                                Thread.sleep(100);
                                j++;
                                step++;

                            }
                        }
                        else{
                            if(j==9){
                                p1.setTranslateY(p1.getTranslateY() - 57);

                                Thread.sleep(100);
                                j = 0;
                                i++;
                                step++;
                            }
                            else{
                                p1.setTranslateX(p1.getTranslateX()-40);
                                Thread.sleep(100);
                                j++;
                                step++;
                            }
                        }
                    }
                    p.setJth(j);
                    p.setIth(i);
                    p.setPosition(num + p.getPosition());
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
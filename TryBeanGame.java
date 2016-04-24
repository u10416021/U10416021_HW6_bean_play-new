//u10416021 張馨容
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.util.*;
import java.security.SecureRandom;

public class TryBeanGame extends Application {
  @Override 
  public void start(Stage primaryStage) { 
  	//create a pane 
  	Pane pane = new Pane();  
    //Create a polyline and set its color
    Polyline polyline = new Polyline();polyline.setFill(Color.WHITE);polyline.setStroke(Color.BLACK);
    //Add points to polyline
    polyline.getPoints().addAll(new Double[]{185.0, 40.0 ,185.0, 70.0 ,80.0 , 300.0,80.0 , 360.0,320.0, 360.0,320.0, 300.0,215.0, 70.0 ,215.0, 40.0 });
    //Create circle 
    Circle circle1 = new Circle(200,80,5,Color.BLACK);
    Circle circle2 = new Circle(185,115,5,Color.BLACK);
    Circle circle3 = new Circle(215,115,5,Color.BLACK);
    Circle circle4 = new Circle(170,150,5,Color.BLACK);
    Circle circle5 = new Circle(200,150,5,Color.BLACK);
    Circle circle6 = new Circle(230,150,5,Color.BLACK);
    Circle circle7 = new Circle(155,185,5,Color.BLACK);
    Circle circle8 = new Circle(185,185,5,Color.BLACK);
    Circle circle9 = new Circle(215,185,5,Color.BLACK);
    Circle circle10 = new Circle(245,185,5,Color.BLACK);
    Circle circle11 = new Circle(140,220,5,Color.BLACK);
    Circle circle12 = new Circle(170,220,5,Color.BLACK);
    Circle circle13 = new Circle(200,220,5,Color.BLACK);
    Circle circle14 = new Circle(230,220,5,Color.BLACK);
    Circle circle15 = new Circle(260,220,5,Color.BLACK);
    Circle circle16 = new Circle(125,255,5,Color.BLACK);
    Circle circle17 = new Circle(155,255,5,Color.BLACK);
    Circle circle18 = new Circle(185,255,5,Color.BLACK);
    Circle circle19 = new Circle(215,255,5,Color.BLACK);
    Circle circle20 = new Circle(245,255,5,Color.BLACK);
    Circle circle21 = new Circle(275,255,5,Color.BLACK);
    Circle circle22 = new Circle(110,290,5,Color.BLACK);
    Circle circle23 = new Circle(140,290,5,Color.BLACK);
    Circle circle24 = new Circle(170,290,5,Color.BLACK);
    Circle circle25 = new Circle(200,290,5,Color.BLACK);
    Circle circle26 = new Circle(230,290,5,Color.BLACK);
    Circle circle27 = new Circle(260,290,5,Color.BLACK);
    Circle circle28 = new Circle(290,290,5,Color.BLACK);
	//line:To form the slot
	Line line1 = new Line(110,290,110,360);
	Line line2 = new Line(140,290,140,360);
	Line line3 = new Line(170,290,170,360);
	Line line4 = new Line(200,290,200,360);
	Line line5 = new Line(230,290,230,360);
	Line line6 = new Line(260,290,260,360);
	Line line7 = new Line(290,290,290,360);
    pane.getChildren().clear();pane.getChildren().add(polyline); 
	pane.getChildren().addAll(circle1,circle2,circle3,circle4,circle5,circle6,circle7,circle8,circle9,circle10,circle11,circle12,circle13,circle14,circle15,circle16,circle17,circle18,circle19,circle20,circle21,circle22,circle23,circle24,circle25,circle26,circle27,circle28,line1,line2,line3,line4,line5,line6,line7);
	//create a scene
	Scene scene = new Scene(pane, 400, 400);
	//EventHandler
	scene.setOnKeyPressed(e -> {
		//create a circle
    	Circle ball = new Circle(200,50,3,Color.RED);
    	pane.getChildren().add(ball);
		run(ball);
    }); 
    primaryStage.setTitle("BeanMachine"); 
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void run(Circle ball){
  	SecureRandom random = new SecureRandom();
  	//create a path about the ball
  	Path path = new Path();
  	//get the location of the ball
  	double X = ball.getCenterX(), Y = ball.getCenterY();
	path.getElements().add(new MoveTo(ball.getCenterX(), ball.getCenterY()));
	//use for loop to get the random routine
	for (int i = 0; i < 7; i++) {
		if (random.nextInt(2) == 1) {
			X += 15; Y += 30;
		} 
		else {
			X -= 15; Y += 30;
		}
		path.getElements().add(new LineTo(X, Y));
	}
	path.getElements().add(new LineTo(X,Y+90));
	PathTransition pathtran = new PathTransition();
	pathtran.setDuration(Duration.millis(1000));
	pathtran.setPath(path);pathtran.setNode(ball);
	pathtran.play();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application{
	
	@Override
	public void start(Stage Stage) {
		
		try {
			
			gc = canvas.getGraphicsContext2D();
			//도화지에 그릴 연필이 객체화 됨
			gc.setStroke(Color.BLACK);
			//선의 색깔을 정해줌			
			gc.setLineWidth(1);
			
			pane.getChildren().addAll(canvas,grid);
			cp.setValue(Color.BLACK);//처음 색깔을 검은색으로
			cp.setOnAction(e->{
				
				gc.setStroke(cp.getValue());
				
			});//선택된 색깔이 나오게됨
		
			slider.setMin(1);
			slider.setMax(50);
			slider.setShowTickLabels(true);
			slider.setShowTickLabels(true);
			slider.valueProperty().addListener(e->{
				
				double value = slider.getValue();
				gc.setLineWidth(value);
		
			});
			
			pane.setStyle("-fx-background-color: white");
			
			grid.addRow(0,cp,slider);
			grid.setHgap(20);
			grid.setAlignment(Pos.TOP_CENTER);
			grid.setPadding(new Insets(20,0,0,0));
			
			scene.setOnMousePressed(e->{
				
				gc.beginPath();//선을 그리기 시작하겠다고 선언
				gc.lineTo(e.getSceneX(), e.getSceneY());
				gc.stroke();
				
			});
			
			scene.setOnMouseDragged(e->{
				
				gc.lineTo(e.getSceneX(), e.getSceneY());
				gc.stroke();
				
			});//이동한 지점마다 계속 점을 찍어준다.
			
		
			
			Stage.setScene(scene);
			Stage.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	Canvas canvas = new Canvas(800,500);
	//도화지 크기 설정
	
	GridPane grid = new GridPane();
	

	GraphicsContext gc;
	
	ColorPicker cp = new ColorPicker();
	Slider slider = new Slider();
	
	StackPane pane = new StackPane();
	Scene scene = new Scene(pane,800,500);
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

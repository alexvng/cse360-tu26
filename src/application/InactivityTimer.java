package application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;

//Tracks inactivity and will close program is user is gone for too long
public class InactivityTimer {
	
	private long lastActivityTime = System.currentTimeMillis();
	private Timer timer = new Timer(true);
	
	//Tracks time user has been away from their application
	public void tracker(Stage stage) {
		
		//Mouse event handler to track activity
		stage.addEventFilter(MouseEvent.ANY, event->{
			lastActivityTime = System.currentTimeMillis();
		});
	
		//Keyboard event handler to track activity
		stage.addEventFilter(KeyEvent.ANY, event->{
			lastActivityTime = System.currentTimeMillis();
		});
		
		timer.scheduleAtFixedRate(new TimerTask() {
		
		public void run() {
		
		//Takes current time and subtracts from it the last activity time to get the total inactive time
		long currentTime = System.currentTimeMillis();
		long inactiveTime = currentTime - lastActivityTime;
				
		//If user has been gone for more then 30 seconds they will be kicked out of the program and the timer will turn off
		if(inactiveTime>30000) {
			showError(stage);
			timer.cancel();
				}
			}
		},0,1000); //Checks every 1 second
	}
	
	
	//Method to show error message when user has been inactive for too long
	public void showError(Stage stage) {
		
		Platform.runLater(()->{
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("You have been inactive for too long");
			error.setContentText("Please close the program and log back in");			
			error.show();
			stage.close();
		});
		
		
		
	}

}

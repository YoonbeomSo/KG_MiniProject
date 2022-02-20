package Main.main;

import Main.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main/main/KG_COM_FX_Main.fxml"));
		Parent mainForm = loader.load();
		Controller controller = new Controller();
		
		controller.setLoginController(loader.getController());
//		controller.getLoginController().setmainForm(mainForm);
//		System.out.println("mainForm"+mainForm);
		LoginController loginController = controller.getLoginController();
		loginController.setmainForm(mainForm);
		//sdgdsdg
		Scene scene = new Scene(mainForm);
		
		primaryStage.setTitle("MainPage");
		primaryStage.setScene(scene);
		controller.setStage(primaryStage);
		primaryStage.show();
	}
	
	
}

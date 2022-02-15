package admin.exProgramMgt;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;



public class ExProgramMgtController implements Initializable{
	private Parent exProgramMgtForm;
	private ExProgramMgtService exProgramSvc;
	
	@FXML public ListView<String> programListView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		exProgramSvc = new ExProgramMgtService();
		exProgramSvc.listUp(this.programListView);
		
	}
	
	public void setExProgramMgtForm(Parent exProgramMgtForm) {
		this.exProgramMgtForm = exProgramMgtForm;
	}
	
	
	// 등록 버튼 클릭 시
	public void exProgramInsertProc() {
		System.out.println("프로그램 등록");
		exProgramSvc.exProgramInsertProc(exProgramMgtForm);
	}
	
	// 수정 버튼 클릭 시
	public void exProgramModifyProc() {
		System.out.println("프로그램 수정");
		exProgramSvc.exProgramModifyProc(exProgramMgtForm);
	}
	
	// 삭제 버튼 클릭 시
	public void exProgramDeleteProc() {
		System.out.println("프로그램 삭제");
		exProgramSvc.exProgramDeleteProc(exProgramMgtForm);
	}
	
	// 이전 버튼 클릭 시
	public void exProgramCancleProc() {
		System.out.println("이전 버튼");
		
	}

}

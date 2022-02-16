package trn.Welcome;

import java.io.IOException;

import common.CmnTrainerDAO;
import common.CmnTrainerDTO;
import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import trn.DBDAO.TrnTrainerDAO;
import trn.DBDTO.TrnTrainerDTO;

public class TrnWelcomeService {
	
	private TrnWelcomeController trnWelcomeController;

	private ObservableList<TrnTbVDTO> list = FXCollections.observableArrayList(
			new TrnTbVDTO("hellocode", "hellocode","hellocode"),
			new TrnTbVDTO("hellocode2", "helloname2","hellomems2")
			);
		
	public void setTrnWelcomeController(TrnWelcomeController trnWelcomeController) {
		this.trnWelcomeController = trnWelcomeController;
	}
	public void programclickProc(Parent welcomeForm) {
	
		TableView<TrnTbVDTO> CurrentProgramTableList = (TableView<TrnTbVDTO>)welcomeForm.lookup("#CurrentProgramTableList");
//		TableColumn<TrnTableView, String> PCodeColumn;
//		TableColumn<TrnTableView, String> PNameColumn;
//		TableColumn<TrnTableView, String> MembersColumn;
		CurrentProgramTableList.setItems(list);
		

	}

	//강사정보페이지
	public void TrnMgtOpen(String trnCode) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/trn/TrnMgt/KG_TRN_FX_Mgt.fxml"));
		Parent trnMgtForm;
		try {
			trnMgtForm = loader.load();
			trnWelcomeController.setTrnMgtController(loader.getController());
			trnWelcomeController.getTrnMgtController().setTrnMgtForm(trnMgtForm);
			trnWelcomeController.getTrnMgtController().setTrnCode(trnCode);
		
			//강사 정보 get
			
			//tilte sector set
			Label titleUserName = (Label)trnMgtForm.lookup("#TitleUserNameLabel");
			CmnTrainerDTO tmpTrnDto = new CmnTrainerDTO(new CmnTrainerDAO().SltTrnOne(trnCode));
			titleUserName.setText(tmpTrnDto.getTRAINER_Name()+" 강사님");
			//초기 표시 설정
			TextField IDField = (TextField)trnMgtForm.lookup("#TrnIDField");//기존 이름 표시
			TextField NameField = (TextField)trnMgtForm.lookup("#TrnNameField");//기존 이름 표시
			PasswordField PWField = (PasswordField)trnMgtForm.lookup("#TrnPWField");//기존 이름 표시
			PasswordField PWCField = (PasswordField)trnMgtForm.lookup("#TrnPWCField");//기존 이름 표시
			TextField BirthField = (TextField)trnMgtForm.lookup("#TrnBirthField");//기존 생일 표시
			TextField MobileField = (TextField)trnMgtForm.lookup("#TrnMobileField");//기존 전번 표시
			RadioButton maleBtn = (RadioButton)trnMgtForm.lookup("#MaleRbtn");//기존 남성버튼
			RadioButton FeMaleBtn = (RadioButton)trnMgtForm.lookup("#FeMaleRbtn");//기존 여자버튼
			TextField Addr1Field = (TextField)trnMgtForm.lookup("#TrnAddr1");//기존 주소 표시
			TextField Addr2Field = (TextField)trnMgtForm.lookup("#TrnAddr2");//기존 주소 표시
			TextField CareerField = (TextField)trnMgtForm.lookup("#TrnCareer");//기존 커리어 표시
		
			//ID Sector
			IDField.setText(tmpTrnDto.getTRAINER_ID());
			IDField.setEditable(false);//false:입력 불가
			//Name Sector			
			NameField.setText(tmpTrnDto.getTRAINER_Name());
			//PW Sector :초기 미표시
			//Birth Sector
			BirthField.setText(Integer.toString(tmpTrnDto.getTRAINER_Birth()));
			//Gender Sector
			ToggleGroup group = new ToggleGroup();
			maleBtn.setToggleGroup(group);
			FeMaleBtn.setToggleGroup(group);
			if(tmpTrnDto.getTRAINER_Gender().equals("남성")) maleBtn.setSelected(true);
			else if(tmpTrnDto.getTRAINER_Gender().equals("여성")) FeMaleBtn.setSelected(true);
			else maleBtn.setSelected(true);
			//Addr Sector
			Addr1Field.setText(tmpTrnDto.getTRAINER_Addr());
			Addr2Field.setText(tmpTrnDto.getTRAINER_Addr());
			//Career Sector
			CareerField.setText(Integer.toString(tmpTrnDto.getTRAINER_Career()));
			
			
			
			Stage stage = new Stage();
			stage.setScene(new Scene(trnMgtForm));
			stage.setTitle("강사 정보수정 페이지");
			stage.show();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//프로그램 개설 페이지
	public void ExPEnrollOpen(String trnCode) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/trn/ExprogramEnroll/KG_TRN_FX_EXProgramEnroll.fxml"));
		Parent trnExPEnrollFrom;
		try {
			trnExPEnrollFrom= loader.load();
			trnWelcomeController.setTrnExpEnrollController(loader.getController());
			trnWelcomeController.getTrnExpEnrollController().setTrnExpEnrollForm(trnExPEnrollFrom);
			trnWelcomeController.getTrnExpEnrollController().setTrnCode(trnCode);			
			Stage stage = new Stage();
			stage.setScene(new Scene(trnExPEnrollFrom));
			stage.setTitle("trnExPEnroll");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	//프로그램 관리 페이지
	public void ExPMgtOpen(String trnCode) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/trn/EXProgramMgt/KG_TRN_FX_EXProgramMgt.fxml"));
		Parent trnExPMgtFrom;
		try {
			trnExPMgtFrom = loader.load();
			trnWelcomeController.setTrnExpMgtController(loader.getController());
			trnWelcomeController.getTrnExpMgtController().setTrnExProgramMgtForm(trnExPMgtFrom);
			trnWelcomeController.getTrnExpMgtController().setTrnCode(trnCode);
			Stage stage = new Stage();
			stage.setScene(new Scene(trnExPMgtFrom));
			stage.setTitle("trnExPEnroll");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public void backClose(Parent back) {
		CommonService.WindowClose(back);
	}
	

	


}

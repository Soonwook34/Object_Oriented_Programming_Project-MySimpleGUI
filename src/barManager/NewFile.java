package barManager;

import componentManager.ComponentController;
import layout.Frame;

//새로 만들기를 처리하는 클래스
public class NewFile extends FileCheck {
	
	public static void execute() {
		//파일이 저장되어있는지 확인
		if(isSaved) {
			//새로 만들기
			ComponentController.clearComponent();
		}
		else {
			//저장할 것인지 확인
			switch(FileCheck.warning()) {
				case 0:
					//저장하고 새로 만들기
					SaveFile.save();
				case 1:
					//새로 만들기
					ComponentController.clearComponent();
					break;
				case 2:
					//취소
					return;
			}
		}
		//FileCheck 값 초기화
		isOpened = false;
		isSaved = true;
		fileName = "";
		Frame.frame.setTitle("이름_없음 - MySimpleGUI");
	}
}

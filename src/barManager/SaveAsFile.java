package barManager;

import javax.swing.JOptionPane;

import layout.Frame;

//다른 이름으로 저장을 처리하는 클래스
public class SaveAsFile extends FileCheck {

	public static void execute() {
		//파일이 존재하는지 확인
		switch(FileCheck.fileExists(1)) {
			//취소
			case 0:
			//빈 파일 이름을 입력했을 때
			case 1:
				return;
			//파일이 존재하면 덮어쓰기
			case 2:
				if(overWrite()) {
					fileName = tempFileName;
					SaveFile.save();
				}
				return;
			//저장
			case 3:
				fileName = tempFileName;
				SaveFile.save();
		}
	}
	
	//덮어쓸 것인지 확인하는 클래스
	private static boolean overWrite() {
		String[] option = {"확인", "취소"};
        int yesNo = JOptionPane.showOptionDialog(Frame.frame, tempFileName + ".json 파일이 이미 있습니다.\n기존 파일을 바꾸시겠습니까?", "다른 이름으로 저장", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, option, option[0]);
        //덮어쓰기
        if(yesNo == 0) {
        	return true;
        }
        //취소
        else {
        	return false;
        }
	}
}

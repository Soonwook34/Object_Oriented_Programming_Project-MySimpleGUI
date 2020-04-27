package barManager;

import java.io.File;

import javax.swing.JOptionPane;

import layout.Frame;

//barManager의 상위 클래스
public class FileCheck {
	//파일이 열려있는지 확인
	static boolean isOpened = false;
	//파일에 저장되어있는지 확인
	public static boolean isSaved = true;
	//임시 저장 파일의 이름
	static String tempFileName = new String();
	//저장 파일의 이름
	static String fileName = new String();
	
	//json 파일에 저장할 것인지 묻는 함수
	public static int warning() {
		String file;
		if(fileName.isEmpty()) {
			file = "제목_없음";
		}
		else {
			file = fileName;
		}
		String[] option = {"저장", "저장 안함", "취소"};
		int select = JOptionPane.showOptionDialog(Frame.frame, file + ".json의 변경 내용을 저장하시겠습니까?", "MySimpleGUI", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		
		switch(select) {
			//저장
			case 0:
				fileName = file;
				return 0;
			//저장 안함
			case 1:
				return 1;
			//취소
			case 2:
				return 2;
			default:
				return 2;
		}
	}
	
	//지정한 json 파일이 존재하는지 확인
	public static int fileExists(int index) {
		if(index == 0) {
			tempFileName = JOptionPane.showInputDialog(Frame.frame, "파일 이름을 입력하세요(.json 제외)", "열기", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			tempFileName = JOptionPane.showInputDialog(Frame.frame, "파일 이름을 입력하세요(.json 제외)", "다른 이름으로 저장", JOptionPane.INFORMATION_MESSAGE);
		}
		//취소를 누르면
		if(tempFileName == null) {
			return 0;
		}
		//빈 값으로 확인을 누르면
		else if(tempFileName.isEmpty()) {
			JOptionPane.showMessageDialog(Frame.frame, "입력된 값이 없습니다!", "오류", JOptionPane.WARNING_MESSAGE);
			return 1;
		}
		//제대로 파일 이름을 입력하면
		else {
			File dirPath = new File("./save");
			if(!dirPath.exists() || dirPath.isFile()) {
				dirPath.mkdirs();
			}
			File[] saveList = dirPath.listFiles();
			for(File temp : saveList) {
				if(temp.isFile()) {
					String tempName = temp.getName();
					//이미 있는 파일이면
					if(tempName.equals(tempFileName + ".json")) {
						return 2;
					}
				}
			}
			//없는 파일이면
			return 3;
		}
	}
}

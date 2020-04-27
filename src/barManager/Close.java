package barManager;

//닫기를 처리하는 클래스
public class Close extends FileCheck {
	
	public static void execute() {
		//저장이 되어있다면
		if(isSaved) {
			//프로그램 종료
			System.exit(0);
		}
		//저장이 되어있지 않다면
		else {
			//진행 중인 상황을 저장할 것인지 확인
			switch(FileCheck.warning()) {
				case 0:
					//저장하고 종료
					SaveFile.save();
				case 1:
					//종료
					System.exit(0);
					break;
				case 2:
					//취소
					return;
			}
		}
	}
}

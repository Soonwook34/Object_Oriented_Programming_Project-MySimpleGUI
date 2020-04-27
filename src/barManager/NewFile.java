package barManager;

import componentManager.ComponentController;
import layout.Frame;

//���� ����⸦ ó���ϴ� Ŭ����
public class NewFile extends FileCheck {
	
	public static void execute() {
		//������ ����Ǿ��ִ��� Ȯ��
		if(isSaved) {
			//���� �����
			ComponentController.clearComponent();
		}
		else {
			//������ ������ Ȯ��
			switch(FileCheck.warning()) {
				case 0:
					//�����ϰ� ���� �����
					SaveFile.save();
				case 1:
					//���� �����
					ComponentController.clearComponent();
					break;
				case 2:
					//���
					return;
			}
		}
		//FileCheck �� �ʱ�ȭ
		isOpened = false;
		isSaved = true;
		fileName = "";
		Frame.frame.setTitle("�̸�_���� - MySimpleGUI");
	}
}

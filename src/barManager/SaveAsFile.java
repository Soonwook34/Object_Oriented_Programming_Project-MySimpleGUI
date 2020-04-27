package barManager;

import javax.swing.JOptionPane;

import layout.Frame;

//�ٸ� �̸����� ������ ó���ϴ� Ŭ����
public class SaveAsFile extends FileCheck {

	public static void execute() {
		//������ �����ϴ��� Ȯ��
		switch(FileCheck.fileExists(1)) {
			//���
			case 0:
			//�� ���� �̸��� �Է����� ��
			case 1:
				return;
			//������ �����ϸ� �����
			case 2:
				if(overWrite()) {
					fileName = tempFileName;
					SaveFile.save();
				}
				return;
			//����
			case 3:
				fileName = tempFileName;
				SaveFile.save();
		}
	}
	
	//��� ������ Ȯ���ϴ� Ŭ����
	private static boolean overWrite() {
		String[] option = {"Ȯ��", "���"};
        int yesNo = JOptionPane.showOptionDialog(Frame.frame, tempFileName + ".json ������ �̹� �ֽ��ϴ�.\n���� ������ �ٲٽðڽ��ϱ�?", "�ٸ� �̸����� ����", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, option, option[0]);
        //�����
        if(yesNo == 0) {
        	return true;
        }
        //���
        else {
        	return false;
        }
	}
}

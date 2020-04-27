package barManager;

import java.io.File;

import javax.swing.JOptionPane;

import layout.Frame;

//barManager�� ���� Ŭ����
public class FileCheck {
	//������ �����ִ��� Ȯ��
	static boolean isOpened = false;
	//���Ͽ� ����Ǿ��ִ��� Ȯ��
	public static boolean isSaved = true;
	//�ӽ� ���� ������ �̸�
	static String tempFileName = new String();
	//���� ������ �̸�
	static String fileName = new String();
	
	//json ���Ͽ� ������ ������ ���� �Լ�
	public static int warning() {
		String file;
		if(fileName.isEmpty()) {
			file = "����_����";
		}
		else {
			file = fileName;
		}
		String[] option = {"����", "���� ����", "���"};
		int select = JOptionPane.showOptionDialog(Frame.frame, file + ".json�� ���� ������ �����Ͻðڽ��ϱ�?", "MySimpleGUI", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		
		switch(select) {
			//����
			case 0:
				fileName = file;
				return 0;
			//���� ����
			case 1:
				return 1;
			//���
			case 2:
				return 2;
			default:
				return 2;
		}
	}
	
	//������ json ������ �����ϴ��� Ȯ��
	public static int fileExists(int index) {
		if(index == 0) {
			tempFileName = JOptionPane.showInputDialog(Frame.frame, "���� �̸��� �Է��ϼ���(.json ����)", "����", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			tempFileName = JOptionPane.showInputDialog(Frame.frame, "���� �̸��� �Է��ϼ���(.json ����)", "�ٸ� �̸����� ����", JOptionPane.INFORMATION_MESSAGE);
		}
		//��Ҹ� ������
		if(tempFileName == null) {
			return 0;
		}
		//�� ������ Ȯ���� ������
		else if(tempFileName.isEmpty()) {
			JOptionPane.showMessageDialog(Frame.frame, "�Էµ� ���� �����ϴ�!", "����", JOptionPane.WARNING_MESSAGE);
			return 1;
		}
		//����� ���� �̸��� �Է��ϸ�
		else {
			File dirPath = new File("./save");
			if(!dirPath.exists() || dirPath.isFile()) {
				dirPath.mkdirs();
			}
			File[] saveList = dirPath.listFiles();
			for(File temp : saveList) {
				if(temp.isFile()) {
					String tempName = temp.getName();
					//�̹� �ִ� �����̸�
					if(tempName.equals(tempFileName + ".json")) {
						return 2;
					}
				}
			}
			//���� �����̸�
			return 3;
		}
	}
}

package barManager;

//�ݱ⸦ ó���ϴ� Ŭ����
public class Close extends FileCheck {
	
	public static void execute() {
		//������ �Ǿ��ִٸ�
		if(isSaved) {
			//���α׷� ����
			System.exit(0);
		}
		//������ �Ǿ����� �ʴٸ�
		else {
			//���� ���� ��Ȳ�� ������ ������ Ȯ��
			switch(FileCheck.warning()) {
				case 0:
					//�����ϰ� ����
					SaveFile.save();
				case 1:
					//����
					System.exit(0);
					break;
				case 2:
					//���
					return;
			}
		}
	}
}

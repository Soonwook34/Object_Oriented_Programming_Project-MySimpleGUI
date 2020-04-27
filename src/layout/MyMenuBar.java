package layout;
import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import barManager.Close;
import barManager.CreateJava;
import barManager.NewFile;
import barManager.OpenFile;
import barManager.SaveAsFile;
import barManager.SaveFile;

//�޴� �� Ŭ����
public class MyMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	//���� �����
	private static JMenu newFile = new JMenu("���� �����");
	//����
	private static JMenu openFile = new JMenu("����");
	//����
	private static JMenu saveFile = new JMenu("����");
	//�ٸ� �̸����� ����
	private static JMenu saveAsFile = new JMenu("�ٸ� �̸����� ����");
	//java ���� ����
	private static JMenu createJava = new JMenu(".java ���� ����");
	//������Ʈ �߰�
	private static JMenu addComponent = new JMenu("������Ʈ �߰�");
	//������Ʈ ����
	private static JMenu deleteComponent = new JMenu("������Ʈ ����");
	//�ݱ�
	private static JMenu close = new JMenu("�ݱ�");
	
	public MyMenuBar() {
		this.setBackground(new Color(190, 70, 50));
		
		Color textColor = new Color(245, 245, 245);
		
		newFile.setForeground(textColor);
		newFile.addMenuListener(new NewFileMenuListener());
		this.add(newFile);
		
		openFile.setForeground(textColor);
		openFile.addMenuListener(new OpenFileMenuListener());
		this.add(openFile);
		
		saveFile.setForeground(textColor);
		saveFile.addMenuListener(new SaveFileMenuListener());
		this.add(saveFile);
		
		saveAsFile.setForeground(textColor);
		saveAsFile.addMenuListener(new SaveAsFileMenuListener());
		this.add(saveAsFile);
		
		createJava.setForeground(textColor);
		createJava.addMenuListener(new CreateJavaMenuListener());
		this.add(createJava);
		
		addComponent.setForeground(textColor);
		addComponent.addMenuListener(new AddComponentMenuListener());
		this.add(addComponent);
		
		deleteComponent.setForeground(textColor);
		deleteComponent.addMenuListener(new DeleteComponentMenuListener());
		this.add(deleteComponent);
		
		close.setForeground(textColor);
		close.addMenuListener(new CloseMenuListener());
		this.add(close);
	}
	
	//���� ����� ActionListener �߰�
	private class NewFileMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			NewFile.execute();
		}
	}
	
	//���� ActionListener �߰�
	private class OpenFileMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			OpenFile.execute();
		}
	}
	
	//���� ActionListener �߰�
	private class SaveFileMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			SaveFile.execute();
		}
	}
	
	//�ٸ� �̸����� ���� ActionListener �߰�
	private class SaveAsFileMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			SaveAsFile.execute();
		}
	}
	
	//java ���� ���� ActionListener �߰�
	private class CreateJavaMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			CreateJava.execute();
		}
	}
	
	//������Ʈ �߰� ActionListener �߰�
	private class AddComponentMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			EditorPane.isGeneratingComponent = true;
		}
	}
	
	//������Ʈ ���� ActionListener �߰�
	private class DeleteComponentMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			EditorPane.isDeletingComponent = true;
		}
	}
	
	//�ݱ� ActionListener �߰�
	private class CloseMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			Close.execute();
		}
	}
}

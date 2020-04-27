package layout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import barManager.Close;
import barManager.CreateJava;
import barManager.NewFile;
import barManager.OpenFile;
import barManager.SaveAsFile;
import barManager.SaveFile;

//���� Ŭ����
public class MyToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	//���� �����
	private static JButton newFile = new JButton(new ImageIcon("resources/icon/new.png"));
	//����
	private static JButton openFile = new JButton(new ImageIcon("resources/icon/open.png"));
	//����
	private static JButton saveFile = new JButton(new ImageIcon("resources/icon/save.png"));
	//�ٸ� �̸����� ����
	private static JButton saveAsFile = new JButton(new ImageIcon("resources/icon/save_as.png"));
	//java ���� ����
	private static JButton createJava = new JButton(new ImageIcon("resources/icon/create.png"));
	//������Ʈ �߰�
	private static JButton addComponent = new JButton(new ImageIcon("resources/icon/add.png"));
	//������Ʈ ����
	private static JButton deleteComponent = new JButton(new ImageIcon("resources/icon/delete.png"));
	//�ݱ�
	private static JButton close = new JButton(new ImageIcon("resources/icon/close.png"));
	
	public MyToolBar() {
		this.setBackground(new Color(245, 245, 245));
		
		newFile.addActionListener(new NewFileActionListener());
		this.add(newFile);
		
		openFile.addActionListener(new OpenFileActionListener());
		this.add(openFile);
		
		saveFile.addActionListener(new SaveFileActionListener());
		this.add(saveFile);
		
		saveAsFile.addActionListener(new SaveAsFileActionListener());
		this.add(saveAsFile);
		
		createJava.addActionListener(new CreateJavaActionListener());
		this.add(createJava);
		
		addComponent.addActionListener(new AddComponentActionListener());
		this.add(addComponent);
		
		deleteComponent.addActionListener(new DeleteComponentActionListener());
		this.add(deleteComponent);
		
		close.addActionListener(new CloseActionListener());
		this.add(close);
	}
	
	//���� ����� ActionListener �߰�
	private class NewFileActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			NewFile.execute();
		}
	}
	
	//���� ActionListener �߰�
	private class OpenFileActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			OpenFile.execute();
		}
	}
	
	//���� ActionListener �߰�
	private class SaveFileActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			SaveFile.execute();
		}
	}
	
	//�ٸ� �̸����� ���� ActionListener �߰�
	private class SaveAsFileActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			SaveAsFile.execute();
		}
	}
	
	//java ���� ���� ActionListener �߰�
	private class CreateJavaActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			CreateJava.execute();
		}
	}
	
	//������Ʈ �߰� ActionListener �߰�
	private class AddComponentActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			EditorPane.isGeneratingComponent = true;
		}
	}
	
	//������Ʈ ���� ActionListener �߰�
	private class DeleteComponentActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			EditorPane.isDeletingComponent = true;
		}
	}
	
	//�ݱ� ActionListener �߰�
	private class CloseActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Close.execute();
		}
	}
}

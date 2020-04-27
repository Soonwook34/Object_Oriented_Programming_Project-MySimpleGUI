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

//툴바 클래스
public class MyToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	//새로 만들기
	private static JButton newFile = new JButton(new ImageIcon("resources/icon/new.png"));
	//열기
	private static JButton openFile = new JButton(new ImageIcon("resources/icon/open.png"));
	//저장
	private static JButton saveFile = new JButton(new ImageIcon("resources/icon/save.png"));
	//다른 이름으로 저장
	private static JButton saveAsFile = new JButton(new ImageIcon("resources/icon/save_as.png"));
	//java 파일 생성
	private static JButton createJava = new JButton(new ImageIcon("resources/icon/create.png"));
	//컴포넌트 추가
	private static JButton addComponent = new JButton(new ImageIcon("resources/icon/add.png"));
	//컴포넌트 삭제
	private static JButton deleteComponent = new JButton(new ImageIcon("resources/icon/delete.png"));
	//닫기
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
	
	//새로 만들기 ActionListener 추가
	private class NewFileActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			NewFile.execute();
		}
	}
	
	//열기 ActionListener 추가
	private class OpenFileActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			OpenFile.execute();
		}
	}
	
	//저장 ActionListener 추가
	private class SaveFileActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			SaveFile.execute();
		}
	}
	
	//다른 이름으로 저장 ActionListener 추가
	private class SaveAsFileActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			SaveAsFile.execute();
		}
	}
	
	//java 파일 생성 ActionListener 추가
	private class CreateJavaActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			CreateJava.execute();
		}
	}
	
	//컴포넌트 추가 ActionListener 추가
	private class AddComponentActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			EditorPane.isGeneratingComponent = true;
		}
	}
	
	//컴포넌트 삭제 ActionListener 추가
	private class DeleteComponentActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			EditorPane.isDeletingComponent = true;
		}
	}
	
	//닫기 ActionListener 추가
	private class CloseActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Close.execute();
		}
	}
}

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

//메뉴 바 클래스
public class MyMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	//새로 만들기
	private static JMenu newFile = new JMenu("새로 만들기");
	//열기
	private static JMenu openFile = new JMenu("열기");
	//저장
	private static JMenu saveFile = new JMenu("저장");
	//다른 이름으로 저장
	private static JMenu saveAsFile = new JMenu("다른 이름으로 저장");
	//java 파일 생성
	private static JMenu createJava = new JMenu(".java 파일 생성");
	//컴포넌트 추가
	private static JMenu addComponent = new JMenu("컴포넌트 추가");
	//컴포넌트 삭제
	private static JMenu deleteComponent = new JMenu("컴포넌트 삭제");
	//닫기
	private static JMenu close = new JMenu("닫기");
	
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
	
	//새로 만들기 ActionListener 추가
	private class NewFileMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			NewFile.execute();
		}
	}
	
	//열기 ActionListener 추가
	private class OpenFileMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			OpenFile.execute();
		}
	}
	
	//저장 ActionListener 추가
	private class SaveFileMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			SaveFile.execute();
		}
	}
	
	//다른 이름으로 저장 ActionListener 추가
	private class SaveAsFileMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			SaveAsFile.execute();
		}
	}
	
	//java 파일 생성 ActionListener 추가
	private class CreateJavaMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			CreateJava.execute();
		}
	}
	
	//컴포넌트 추가 ActionListener 추가
	private class AddComponentMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			EditorPane.isGeneratingComponent = true;
		}
	}
	
	//컴포넌트 삭제 ActionListener 추가
	private class DeleteComponentMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			EditorPane.isDeletingComponent = true;
		}
	}
	
	//닫기 ActionListener 추가
	private class CloseMenuListener implements MenuListener {

		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}

		public void menuSelected(MenuEvent e) {
			Close.execute();
		}
	}
}

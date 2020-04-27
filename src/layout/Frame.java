package layout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

//메인 프레임 클래스
public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static Frame frame;
	public static MyMenuBar menuBar = new MyMenuBar();
	public static MyToolBar toolBar = new MyToolBar();
	public static AttributePane attributePane = new AttributePane();
	public static EditorPane editorPane = new EditorPane();
	
	private static JPanel panel = new JPanel();
	
	public Frame() {
		//초기 값 지정
		this.setTitle("제목_없음 - MySimpleGUI");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//메뉴바 추가
		this.setLayout(new BorderLayout());
		this.add(menuBar, "North");
		
		panel.setLayout(new BorderLayout(5, 0));
		//툴바 추가
		panel.add(toolBar, "North");
		//속성 페인 추가
		panel.add(attributePane, "West");
		//에디터 페인 추가
		panel.add(editorPane, "Center");
		this.add(panel);
		
		this.setVisible(true);
	}
	
	//시작
	public static void start() {
		frame = new Frame();
		System.out.println(frame);
	}
	
	//프로그램 정보 출력
	public String toString() {
		return "/**************\n*My Simple GUI*\n*20160290 박순욱*\n*20160318 임규형*\n**************/";
	}
}

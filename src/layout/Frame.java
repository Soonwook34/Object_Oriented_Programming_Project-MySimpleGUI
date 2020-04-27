package layout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

//���� ������ Ŭ����
public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static Frame frame;
	public static MyMenuBar menuBar = new MyMenuBar();
	public static MyToolBar toolBar = new MyToolBar();
	public static AttributePane attributePane = new AttributePane();
	public static EditorPane editorPane = new EditorPane();
	
	private static JPanel panel = new JPanel();
	
	public Frame() {
		//�ʱ� �� ����
		this.setTitle("����_���� - MySimpleGUI");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�޴��� �߰�
		this.setLayout(new BorderLayout());
		this.add(menuBar, "North");
		
		panel.setLayout(new BorderLayout(5, 0));
		//���� �߰�
		panel.add(toolBar, "North");
		//�Ӽ� ���� �߰�
		panel.add(attributePane, "West");
		//������ ���� �߰�
		panel.add(editorPane, "Center");
		this.add(panel);
		
		this.setVisible(true);
	}
	
	//����
	public static void start() {
		frame = new Frame();
		System.out.println(frame);
	}
	
	//���α׷� ���� ���
	public String toString() {
		return "/**************\n*My Simple GUI*\n*20160290 �ڼ���*\n*20160318 �ӱ���*\n**************/";
	}
}

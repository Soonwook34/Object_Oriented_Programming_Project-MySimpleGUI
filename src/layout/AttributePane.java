package layout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import componentManager.AttributeView;

//속성 페인 클래스
public class AttributePane extends JPanel {

	private static final long serialVersionUID = 1L;

	public static int index = -1;
	
	//타입 정보
	protected static JComboBox<String> typeInfo = new JComboBox<>();
	//변수명 정보
	protected static JTextField varInfo = new JTextField();
	//텍스트 정보
	protected static JTextField textInfo = new JTextField();
	//x좌표 정보
	protected static JTextField xInfo = new JTextField();
	//y좌표 정보
	protected static JTextField yInfo = new JTextField();
	//너비 정보
	protected static JTextField widthInfo = new JTextField();
	//높이 정보
	protected static JTextField heightInfo = new JTextField();

	//생성자
	public AttributePane() {
		this.setLayout(new GridLayout(8, 2, 5, 5));
		this.setBackground(Color.LIGHT_GRAY);
		
		this.add(new JLabel("타입", SwingConstants.CENTER));
		typeInfo.setBackground(new Color(245, 245, 245));
		typeInfo.addItem("JLabel");
		typeInfo.addItem("JButton");
		typeInfo.addItem("JTextField");
		typeInfo.addActionListener(new AttributeTypeActionListener());
		this.add(typeInfo);
		
		AttributeStringActionListener stringActionListener = new AttributeStringActionListener();
		this.add(new JLabel("변수명", SwingConstants.CENTER));
		varInfo.addActionListener(stringActionListener);
		this.add(varInfo);
		
		this.add(new JLabel("텍스트", SwingConstants.CENTER));
		textInfo.addActionListener(stringActionListener);
		this.add(textInfo);
		
		AttributeBoundsActionListener boundsActionListener = new AttributeBoundsActionListener();
		this.add(new JLabel("X 좌표", SwingConstants.CENTER));
		xInfo.addActionListener(boundsActionListener);
		this.add(xInfo);
		
		this.add(new JLabel("Y 좌표", SwingConstants.CENTER));
		yInfo.addActionListener(boundsActionListener);
		this.add(yInfo);
		
		this.add(new JLabel("너비", SwingConstants.CENTER));
		widthInfo.addActionListener(boundsActionListener);
		this.add(widthInfo);
		
		this.add(new JLabel("높이", SwingConstants.CENTER));
		heightInfo.addActionListener(boundsActionListener);
		this.add(heightInfo);
	}
	
	//타입의 ActionListener
	private class AttributeTypeActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(AttributeView.index != -1) {
				String type = (String)typeInfo.getSelectedItem();
				AttributeView.typeUpdate(index, type);
			}
		}
	}
	
	//변수명, 텍스트 정보의 ActionListener
	private class AttributeStringActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(AttributeView.index != -1) {
				String var = varInfo.getText();
				String text = textInfo.getText();
				AttributeView.stringUpdate(index, var, text);
			}
		}
	}
	
	//좌표, 크기 정보의 ActionListener
	private class AttributeBoundsActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(AttributeView.index != -1) {
				int x = Integer.parseInt(xInfo.getText());
				int y = Integer.parseInt(yInfo.getText());
				int width = Integer.parseInt(widthInfo.getText());
				int height = Integer.parseInt(heightInfo.getText());
				AttributeView.boundsUpdate(index, x, y, width, height);
			}
		}
	}
}

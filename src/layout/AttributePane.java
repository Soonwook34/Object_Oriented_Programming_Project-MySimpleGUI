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

//�Ӽ� ���� Ŭ����
public class AttributePane extends JPanel {

	private static final long serialVersionUID = 1L;

	public static int index = -1;
	
	//Ÿ�� ����
	protected static JComboBox<String> typeInfo = new JComboBox<>();
	//������ ����
	protected static JTextField varInfo = new JTextField();
	//�ؽ�Ʈ ����
	protected static JTextField textInfo = new JTextField();
	//x��ǥ ����
	protected static JTextField xInfo = new JTextField();
	//y��ǥ ����
	protected static JTextField yInfo = new JTextField();
	//�ʺ� ����
	protected static JTextField widthInfo = new JTextField();
	//���� ����
	protected static JTextField heightInfo = new JTextField();

	//������
	public AttributePane() {
		this.setLayout(new GridLayout(8, 2, 5, 5));
		this.setBackground(Color.LIGHT_GRAY);
		
		this.add(new JLabel("Ÿ��", SwingConstants.CENTER));
		typeInfo.setBackground(new Color(245, 245, 245));
		typeInfo.addItem("JLabel");
		typeInfo.addItem("JButton");
		typeInfo.addItem("JTextField");
		typeInfo.addActionListener(new AttributeTypeActionListener());
		this.add(typeInfo);
		
		AttributeStringActionListener stringActionListener = new AttributeStringActionListener();
		this.add(new JLabel("������", SwingConstants.CENTER));
		varInfo.addActionListener(stringActionListener);
		this.add(varInfo);
		
		this.add(new JLabel("�ؽ�Ʈ", SwingConstants.CENTER));
		textInfo.addActionListener(stringActionListener);
		this.add(textInfo);
		
		AttributeBoundsActionListener boundsActionListener = new AttributeBoundsActionListener();
		this.add(new JLabel("X ��ǥ", SwingConstants.CENTER));
		xInfo.addActionListener(boundsActionListener);
		this.add(xInfo);
		
		this.add(new JLabel("Y ��ǥ", SwingConstants.CENTER));
		yInfo.addActionListener(boundsActionListener);
		this.add(yInfo);
		
		this.add(new JLabel("�ʺ�", SwingConstants.CENTER));
		widthInfo.addActionListener(boundsActionListener);
		this.add(widthInfo);
		
		this.add(new JLabel("����", SwingConstants.CENTER));
		heightInfo.addActionListener(boundsActionListener);
		this.add(heightInfo);
	}
	
	//Ÿ���� ActionListener
	private class AttributeTypeActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(AttributeView.index != -1) {
				String type = (String)typeInfo.getSelectedItem();
				AttributeView.typeUpdate(index, type);
			}
		}
	}
	
	//������, �ؽ�Ʈ ������ ActionListener
	private class AttributeStringActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(AttributeView.index != -1) {
				String var = varInfo.getText();
				String text = textInfo.getText();
				AttributeView.stringUpdate(index, var, text);
			}
		}
	}
	
	//��ǥ, ũ�� ������ ActionListener
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

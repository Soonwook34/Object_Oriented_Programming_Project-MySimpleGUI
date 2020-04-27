package componentManager;
import java.awt.Point;

import layout.AttributePane;

//�Ӽ� ������ View Ŭ����
public class AttributeView extends AttributePane {

	private static final long serialVersionUID = 1L;
	
	//Controller�� ������Ʈ ���� ��û
	public static void getInfo(int index) {
		ComponentController.getInfo(index);
	}
	
	//Controller�κ��� �޾ƿ� ���� ���
	public static void showInfo(int index, String type, String var, String text, int x, int y, int width, int height) {
		AttributePane.index = index;
		AttributePane.typeInfo.setSelectedItem(type);
		AttributePane.varInfo.setText(var);
		AttributePane.textInfo.setText(text);
		AttributePane.xInfo.setText(String.valueOf(x));
		AttributePane.yInfo.setText(String.valueOf(y));
		AttributePane.widthInfo.setText(String.valueOf(width));
		AttributePane.heightInfo.setText(String.valueOf(height));
	}
	
	//�Ӽ� ���� ����
	public static void initInfo() {
		AttributePane.index = -1;
		AttributePane.typeInfo.setSelectedItem("JLabel");
		AttributePane.varInfo.setText("");
		AttributePane.textInfo.setText("");
		AttributePane.xInfo.setText("");
		AttributePane.yInfo.setText("");
		AttributePane.widthInfo.setText("");
		AttributePane.heightInfo.setText("");
	}
	
	//Controller�� Ÿ�� ���� ��û
	public static void typeUpdate(int index, String type) {
		ComponentController.typeUpdate(index, type);
	}
	
	//Controller�κ��� �޾ƿ� Ÿ������ ����
	public static void typeChanged(int index, String type) {
		if(AttributePane.index == index) {
			AttributePane.typeInfo.setSelectedItem(type);
		}
	}
	
	//Controller�� ������, �ؽ�Ʈ ���� ��û
	public static void stringUpdate(int index, String var, String text) {
		ComponentController.stringUpdate(index, var, text);
	}
	
	//Controller�κ��� �޾ƿ� ������, �ؽ�Ʈ�� ����
	public static void stringChanged(int index, String var, String text) {
		if(AttributePane.index == index) {
			AttributePane.varInfo.setText(var);
			AttributePane.textInfo.setText(text);
		}
	}
	
	//Controller�κ��� �޾ƿ� ��ǥ�� ����
	public static void pointChanged(int index, Point p) {
		if(AttributePane.index == index) {
			AttributePane.xInfo.setText(String.valueOf(p.x));
			AttributePane.yInfo.setText(String.valueOf(p.y));
		}
	}
	
	//Controller�� ��ǥ, ũ�� ���� ��û
	public static void boundsUpdate(int index, int x, int y, int width, int height) {
		ComponentController.boundsUpdate(index, x, y, width, height);
	}
	
	//Controller�κ��� �޾ƿ� ��ǥ, ũ��� ����
	public static void boundsChanged(int index, int x, int y, int width, int height) {
		if(AttributePane.index == index) {
			AttributePane.xInfo.setText(String.valueOf(x));
			AttributePane.yInfo.setText(String.valueOf(y));
			AttributePane.widthInfo.setText(String.valueOf(width));
			AttributePane.heightInfo.setText(String.valueOf(height));
		}
	}
}

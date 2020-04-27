package componentManager;
import java.awt.Point;

import layout.AttributePane;

//속성 페인의 View 클래스
public class AttributeView extends AttributePane {

	private static final long serialVersionUID = 1L;
	
	//Controller에 컴포넌트 정보 요청
	public static void getInfo(int index) {
		ComponentController.getInfo(index);
	}
	
	//Controller로부터 받아온 정보 출력
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
	
	//속성 페인 비우기
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
	
	//Controller에 타입 변경 요청
	public static void typeUpdate(int index, String type) {
		ComponentController.typeUpdate(index, type);
	}
	
	//Controller로부터 받아온 타입으로 변경
	public static void typeChanged(int index, String type) {
		if(AttributePane.index == index) {
			AttributePane.typeInfo.setSelectedItem(type);
		}
	}
	
	//Controller에 변수명, 텍스트 변경 요청
	public static void stringUpdate(int index, String var, String text) {
		ComponentController.stringUpdate(index, var, text);
	}
	
	//Controller로부터 받아온 변수명, 텍스트로 변경
	public static void stringChanged(int index, String var, String text) {
		if(AttributePane.index == index) {
			AttributePane.varInfo.setText(var);
			AttributePane.textInfo.setText(text);
		}
	}
	
	//Controller로부터 받아온 좌표로 변경
	public static void pointChanged(int index, Point p) {
		if(AttributePane.index == index) {
			AttributePane.xInfo.setText(String.valueOf(p.x));
			AttributePane.yInfo.setText(String.valueOf(p.y));
		}
	}
	
	//Controller에 좌표, 크기 변경 요청
	public static void boundsUpdate(int index, int x, int y, int width, int height) {
		ComponentController.boundsUpdate(index, x, y, width, height);
	}
	
	//Controller로부터 받아온 좌표, 크기로 변경
	public static void boundsChanged(int index, int x, int y, int width, int height) {
		if(AttributePane.index == index) {
			AttributePane.xInfo.setText(String.valueOf(x));
			AttributePane.yInfo.setText(String.valueOf(y));
			AttributePane.widthInfo.setText(String.valueOf(width));
			AttributePane.heightInfo.setText(String.valueOf(height));
		}
	}
}

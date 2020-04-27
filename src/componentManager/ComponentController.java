package componentManager;
import java.awt.Point;

import barManager.FileCheck;

//Controller 클래스
public class ComponentController extends ComponentModel {
	
	public ComponentController() {}
	
	//Model에게 컴포넌트 생성 요청
	public static void newComponent(int x, int y, int width, int height) {
		ComponentModel.newComponent(x, y, width, height);
		FileCheck.isSaved = false;
	}
	
	//Model에게 컴포넌트 생성 요청
	public static void newComponent(String type, String var, String text, int x, int y, int width, int height) {
		ComponentModel.newComponent(type,  var,  text, x, y, width, height);
	}
	
	//View에게 컴포넌트 생성 요청
	public static void addComponent(int index, String type, String var, String text, int x, int y, int width, int height) {
		AttributeView.showInfo(index, type, var, text, x, y, width, height);
		EditorView.addComponent(x, y, width, height);
		EditorView.setTool(x, y, width, height);
	}
	
	//Model에게 컴포넌트 삭제 요청
	public static void removeComponent(int index) {
		ComponentModel.removeComponent(index);
		FileCheck.isSaved = false;
	}
	
	//View에게 컴포넌트 삭제 요청
	public static void deleteComponent(int index) {
		AttributeView.initInfo();
		EditorView.deleteComponent(index);
		EditorView.initTool();
	}
	
	//새로 만들기 요청이 들어왔을 때 Model과 View에게 초기화 요청
	public static void clearComponent() {
		ComponentModel.clearComponent();
		AttributeView.initInfo();
		EditorView.clearComponent();
	}
	
	//Model에게 컴포넌트 정보 요청
	public static void getInfo(int index) {
		ComponentModel.getInfo(index);
		FileCheck.isSaved = false;
	}
	
	//View에게 컴포넌트 정보 출력 요청
	public static void showInfo(int index, String type, String var, String text, int x, int y, int width, int height) {
		AttributeView.showInfo(index, type, var, text, x, y, width, height);
	}
	
	//Model에 타입 변경 요청
	public static void typeUpdate(int index, String type) {
		ComponentModel.typeUpdate(index, type);
		FileCheck.isSaved = false;
	}
	
	//View에게 타입 변경 요청
	public static void typeChanged(int index, String type) {
		AttributeView.typeChanged(index, type);
	}
	
	//Model에게 변수명, 텍스트 정보 변경 요청
	public static void stringUpdate(int index, String var, String text) {
		ComponentModel.stringUpdate(index, var, text);
		FileCheck.isSaved = false;
	}
	
	//View에게 변수명, 텍스트 정보 변경 요청
	public static void stringChanged(int index, String var, String text) {
		AttributeView.stringChanged(index, var, text);
	}
	
	//Model에게 좌표 변경 요청
	public static void pointUpdate(int index, Point p) {
		ComponentModel.pointUpdate(index, p);
		FileCheck.isSaved = false;
	}
	
	//View에게 좌표 변경 요청
	public static void pointChanged(int index, Point p) {
		AttributeView.pointChanged(index, p);
		EditorView.pointChanged(index, p);
		EditorView v = EditorView.viewE.get(index);
		EditorView.setTool(p.x, p.y, v.getWidth(), v.getHeight());
	}
	
	//Model에게 좌표, 크기 변경 요청
	public static void boundsUpdate(int index, int x, int y, int width, int height) {
		ComponentModel.boundsUpdate(index, x, y, width, height);
		FileCheck.isSaved = false;
	}
	
	//View에게 좌표, 크기 변경 요청
	public static void boundsChanged(int index, int x, int y, int width, int height) {
		AttributeView.boundsChanged(index, x, y, width, height);
		EditorView.boundsChanged(index, x, y, width, height);
		EditorView.setTool(x, y, width, height);
	}
}

package componentManager;
import java.awt.Point;

import barManager.FileCheck;

//Controller Ŭ����
public class ComponentController extends ComponentModel {
	
	public ComponentController() {}
	
	//Model���� ������Ʈ ���� ��û
	public static void newComponent(int x, int y, int width, int height) {
		ComponentModel.newComponent(x, y, width, height);
		FileCheck.isSaved = false;
	}
	
	//Model���� ������Ʈ ���� ��û
	public static void newComponent(String type, String var, String text, int x, int y, int width, int height) {
		ComponentModel.newComponent(type,  var,  text, x, y, width, height);
	}
	
	//View���� ������Ʈ ���� ��û
	public static void addComponent(int index, String type, String var, String text, int x, int y, int width, int height) {
		AttributeView.showInfo(index, type, var, text, x, y, width, height);
		EditorView.addComponent(x, y, width, height);
		EditorView.setTool(x, y, width, height);
	}
	
	//Model���� ������Ʈ ���� ��û
	public static void removeComponent(int index) {
		ComponentModel.removeComponent(index);
		FileCheck.isSaved = false;
	}
	
	//View���� ������Ʈ ���� ��û
	public static void deleteComponent(int index) {
		AttributeView.initInfo();
		EditorView.deleteComponent(index);
		EditorView.initTool();
	}
	
	//���� ����� ��û�� ������ �� Model�� View���� �ʱ�ȭ ��û
	public static void clearComponent() {
		ComponentModel.clearComponent();
		AttributeView.initInfo();
		EditorView.clearComponent();
	}
	
	//Model���� ������Ʈ ���� ��û
	public static void getInfo(int index) {
		ComponentModel.getInfo(index);
		FileCheck.isSaved = false;
	}
	
	//View���� ������Ʈ ���� ��� ��û
	public static void showInfo(int index, String type, String var, String text, int x, int y, int width, int height) {
		AttributeView.showInfo(index, type, var, text, x, y, width, height);
	}
	
	//Model�� Ÿ�� ���� ��û
	public static void typeUpdate(int index, String type) {
		ComponentModel.typeUpdate(index, type);
		FileCheck.isSaved = false;
	}
	
	//View���� Ÿ�� ���� ��û
	public static void typeChanged(int index, String type) {
		AttributeView.typeChanged(index, type);
	}
	
	//Model���� ������, �ؽ�Ʈ ���� ���� ��û
	public static void stringUpdate(int index, String var, String text) {
		ComponentModel.stringUpdate(index, var, text);
		FileCheck.isSaved = false;
	}
	
	//View���� ������, �ؽ�Ʈ ���� ���� ��û
	public static void stringChanged(int index, String var, String text) {
		AttributeView.stringChanged(index, var, text);
	}
	
	//Model���� ��ǥ ���� ��û
	public static void pointUpdate(int index, Point p) {
		ComponentModel.pointUpdate(index, p);
		FileCheck.isSaved = false;
	}
	
	//View���� ��ǥ ���� ��û
	public static void pointChanged(int index, Point p) {
		AttributeView.pointChanged(index, p);
		EditorView.pointChanged(index, p);
		EditorView v = EditorView.viewE.get(index);
		EditorView.setTool(p.x, p.y, v.getWidth(), v.getHeight());
	}
	
	//Model���� ��ǥ, ũ�� ���� ��û
	public static void boundsUpdate(int index, int x, int y, int width, int height) {
		ComponentModel.boundsUpdate(index, x, y, width, height);
		FileCheck.isSaved = false;
	}
	
	//View���� ��ǥ, ũ�� ���� ��û
	public static void boundsChanged(int index, int x, int y, int width, int height) {
		AttributeView.boundsChanged(index, x, y, width, height);
		EditorView.boundsChanged(index, x, y, width, height);
		EditorView.setTool(x, y, width, height);
	}
}

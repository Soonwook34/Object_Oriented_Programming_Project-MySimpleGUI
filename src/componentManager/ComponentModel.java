package componentManager;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

//Model 클래스
public class ComponentModel {
	
	//컴포넌트 정보를 ArrayList에 저장
	private static ArrayList<ComponentModel> model = new ArrayList<>();
	private static int cnt = -1;
	private static ComponentModel cm = null;
	//컴포넌트 정보
	private String type;
	private String var;
	private String text;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public ComponentModel() {}
	
	//생성자
	private ComponentModel(String type, String var, String text, int x, int y, int width, int height) {
		this.type = type;
		this.var = var;
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		model.add(this);
	}
	
	//Model의 배열 Iterator를 리턴
	public static Iterator<ComponentModel> getIterator() {
		return model.iterator();
	}
	
	//컴포넌트 추가
	protected static void newComponent(int x, int y, int width, int height) {
		cnt++;
		cm = new ComponentModel("JLabel", "var" + cnt, "text" + cnt, x, y, width, height);
		ComponentController.addComponent(cnt, cm.type, cm.var, cm.text, cm.x, cm.y, cm.width, cm.height);
	}
	
	//컴포넌트 추가
	protected static void newComponent(String type, String var, String text, int x, int y, int width, int height) {
		cnt++;
		cm = new ComponentModel(type, var, text, x, y, width, height);
		ComponentController.addComponent(cnt, cm.type, cm.var, cm.text, cm.x, cm.y, cm.width, cm.height);
	}
	
	//컴포넌트 삭제
	protected static void removeComponent(int index) {
		model.remove(index);
		cnt--;
		ComponentController.deleteComponent(index);
	}
	
	//컴포넌트 초기화
	protected static void clearComponent() {
		model.clear();
		cnt = -1;
	}
	
	//컴포넌트 정보 전달
	protected static void getInfo(int index) {
		cm = model.get(index);
		ComponentController.showInfo(index, cm.type, cm.var, cm.text, cm.x, cm.y, cm.width, cm.height);
	}
	
	//컴포넌트 타입 정보 변경
	protected static void typeUpdate(int index, String type) {
		cm = model.get(index);
		cm.type = type;
		ComponentController.typeChanged(index, cm.type);
	}
	
	//컴포넌트 변수명, 텍스트 정보 변경
	protected static void stringUpdate(int index, String var, String text) {
		cm = model.get(index);
		cm.var = var;
		cm.text = text;
		ComponentController.stringChanged(index, var, text);
	}
	
	//컴포넌트 좌표 정보 변경
	protected static void pointUpdate(int index, Point p) {
		cm = model.get(index);
		cm.x = p.x;
		cm.y = p.y;
		ComponentController.pointChanged(index, p);
	}
	
	//컴포넌트 좌표, 크기 정보 변경
	protected static void boundsUpdate(int index, int x, int y, int width, int height) {
		cm = model.get(index);
		cm.x = x;
		cm.y = y;
		cm.width = width;
		cm.height = height;
		ComponentController.boundsChanged(index, x, y, width, height);
	}
	
	//타입 리턴
	public String getType() {
		return this.type;
	}
	
	//변수명 리턴
	public String getVar() {
		return this.var;
	}
	
	//텍스트 리턴
	public String getText() {
		return this.text;
	}
	
	//x좌표 리턴
	public int getX() {
		return this.x;
	}
	
	//y좌표 리턴
	public int getY() {
		return this.y;
	}
	
	//너비 리턴
	public int getWidth() {
		return this.width;
	}
	
	//높이 리턴
	public int getHeight() {
		return this.height;
	}
}

package componentManager;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

//Model Ŭ����
public class ComponentModel {
	
	//������Ʈ ������ ArrayList�� ����
	private static ArrayList<ComponentModel> model = new ArrayList<>();
	private static int cnt = -1;
	private static ComponentModel cm = null;
	//������Ʈ ����
	private String type;
	private String var;
	private String text;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public ComponentModel() {}
	
	//������
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
	
	//Model�� �迭 Iterator�� ����
	public static Iterator<ComponentModel> getIterator() {
		return model.iterator();
	}
	
	//������Ʈ �߰�
	protected static void newComponent(int x, int y, int width, int height) {
		cnt++;
		cm = new ComponentModel("JLabel", "var" + cnt, "text" + cnt, x, y, width, height);
		ComponentController.addComponent(cnt, cm.type, cm.var, cm.text, cm.x, cm.y, cm.width, cm.height);
	}
	
	//������Ʈ �߰�
	protected static void newComponent(String type, String var, String text, int x, int y, int width, int height) {
		cnt++;
		cm = new ComponentModel(type, var, text, x, y, width, height);
		ComponentController.addComponent(cnt, cm.type, cm.var, cm.text, cm.x, cm.y, cm.width, cm.height);
	}
	
	//������Ʈ ����
	protected static void removeComponent(int index) {
		model.remove(index);
		cnt--;
		ComponentController.deleteComponent(index);
	}
	
	//������Ʈ �ʱ�ȭ
	protected static void clearComponent() {
		model.clear();
		cnt = -1;
	}
	
	//������Ʈ ���� ����
	protected static void getInfo(int index) {
		cm = model.get(index);
		ComponentController.showInfo(index, cm.type, cm.var, cm.text, cm.x, cm.y, cm.width, cm.height);
	}
	
	//������Ʈ Ÿ�� ���� ����
	protected static void typeUpdate(int index, String type) {
		cm = model.get(index);
		cm.type = type;
		ComponentController.typeChanged(index, cm.type);
	}
	
	//������Ʈ ������, �ؽ�Ʈ ���� ����
	protected static void stringUpdate(int index, String var, String text) {
		cm = model.get(index);
		cm.var = var;
		cm.text = text;
		ComponentController.stringChanged(index, var, text);
	}
	
	//������Ʈ ��ǥ ���� ����
	protected static void pointUpdate(int index, Point p) {
		cm = model.get(index);
		cm.x = p.x;
		cm.y = p.y;
		ComponentController.pointChanged(index, p);
	}
	
	//������Ʈ ��ǥ, ũ�� ���� ����
	protected static void boundsUpdate(int index, int x, int y, int width, int height) {
		cm = model.get(index);
		cm.x = x;
		cm.y = y;
		cm.width = width;
		cm.height = height;
		ComponentController.boundsChanged(index, x, y, width, height);
	}
	
	//Ÿ�� ����
	public String getType() {
		return this.type;
	}
	
	//������ ����
	public String getVar() {
		return this.var;
	}
	
	//�ؽ�Ʈ ����
	public String getText() {
		return this.text;
	}
	
	//x��ǥ ����
	public int getX() {
		return this.x;
	}
	
	//y��ǥ ����
	public int getY() {
		return this.y;
	}
	
	//�ʺ� ����
	public int getWidth() {
		return this.width;
	}
	
	//���� ����
	public int getHeight() {
		return this.height;
	}
}

package componentManager;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import layout.Frame;

//에디터 페인의 View 클래스
public class EditorView extends JLabel {

	private static final long serialVersionUID = 1L;
	
	//에디터 페인의 JLabel 정보를 갖고있는 ArrayList
	public static ArrayList<EditorView> viewE = new ArrayList<>();
	private static EditorView v = null;
	//선택됐을 때 도구 값
	private static JLabel[] stretchTool = new JLabel[8];
	private static boolean toolSet = false;
	private static boolean toolIsOpaque = false;
	
	private static EtchedBorder componentBorder = new EtchedBorder(EtchedBorder.LOWERED);
	private static LineBorder toolBorder = new LineBorder(Color.LIGHT_GRAY, 2);
	private static Color background = new Color(165, 165, 165);
	
	//컴포넌트의 선택 여부
	public boolean isSelected;
	//컴포넌트가 움직이고있는지 여부
	public boolean isMoved;
	//컴포넌트가 크기조절 중인지 여부
	public int isStretched;
	//마우스 좌표 저장
	public Point mouse;
	
	//생성자
	private EditorView(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		this.setOpaque(true);
		this.setBackground(background);
		this.setBorder(componentBorder);
		
		this.isSelected = false;
		this.isMoved = false;
		this.isStretched = 0;
		this.mouse = new Point();
		
		viewE.add(this);
		Frame.editorPane.add(this);
	}
	
	//Controller에 컴포넌트 생성 요청
	public static void newComponent(int x, int y, int width, int height) {
		ComponentController.newComponent(x, y, width, height);
	}
	
	//Controller로부터 컴포넌트 생성 요청 처리
	public static void addComponent(int x, int y, int width, int height) {
		v = new EditorView(x, y, width, height);
	}
	
	//Controller에게 컴포넌트 삭제 요청
	public static void removeComponent(int index) {
		ComponentController.removeComponent(index);
	}
	
	//Controller로부터 컴포넌트 삭제 요청 처리
	public static void deleteComponent(int index) {
		v = viewE.get(index);
		Frame.editorPane.remove(v);
		viewE.remove(index);
	}
	
	//에디터 페인의 View 초기화
	public static void clearComponent() {
		Frame.editorPane.removeAll();
		Frame.editorPane.repaint();
		viewE.clear();
		toolSet = false;
		toolIsOpaque = false;
	}
	
	////Controller에게 좌표 정보 변경 요청
	public static void pointUpdate(int index, Point p) {
		ComponentController.pointUpdate(index, p);
	}
	
	//Controller로부터 좌표 정보 변경 요청 처리
	public static void pointChanged(int index, Point p) {
		v = viewE.get(index);
		v.setLocation(p);
	}
	
	//Controller에 좌표, 크기 변경 요청
	public static void boundsUpdate(int index, int x, int y, int width, int height) {
		ComponentController.boundsUpdate(index, x, y, width, height);
	}
	
	//Controller로부터 좌표, 크기 변경 요청 처리
	public static void boundsChanged(int index, int x, int y, int width, int height) {
		v = viewE.get(index);
		v.setBounds(x, y, width, height);
	}
	
	//컴포넌트가 마우스 좌표를 포함하는지 확인
	public boolean contains(Point p) {
		Rectangle r = this.getBounds();
		return (r.x - 4 <= p.x) && (p.x <= r.x + r.width + 4) && (r.y - 4 < p.y) && (p.y <= r.y + r.height + 4);
	}
	
	//컴포넌트의 도구에 마우스 좌표가 포함되는지 확인
	public int isReadyToBeStretched(Point p) {
		Rectangle r = this.getBounds();
		if((r.x-4 <= p.x) && (p.x <= r.x+4) && (r.y-4 <= p.y) && (p.y <= r.y+4)) {
			return 1;
		}
		else if((r.x+(r.width/2)-4 <= p.x) && (p.x <= r.x+(r.width/2)+4) && (r.y-4 <= p.y) && (p.y <= r.y+4)) {
			return 2;
		}
		else if((r.x+r.width-4 <= p.x) && (p.x <= r.x+r.width+4) && (r.y-4 <= p.y) && (p.y <= r.y+4)) {
			return 3;
		}
		else if((r.x-4 <= p.x) && (p.x <= r.x+4) && (r.y+(r.height/2)-4 <= p.y) && (p.y <= r.y+(r.height/2)+4)) {
			return 4;
		}
		else if((r.x+r.width-4 <= p.x) && (p.x <= r.x+r.width+4) && (r.y+(r.height/2)-4 <= p.y) && (p.y <= r.y+(r.height/2)+4)) {
			return 5;
		}
		else if((r.x-4 <= p.x) && (p.x <= r.x+4) && (r.y+r.height-4 <= p.y) && (p.y <= r.y+r.height+4)) {
			return 6;
		}
		else if((r.x+(r.width/2)-4 <= p.x) && (p.x <= r.x+(r.width/2)+4) && (r.y+r.height-4 <= p.y) && (p.y <= r.y+r.height+4)) {
			return 7;
		}
		else if((r.x+r.width-4 <= p.x) && (p.x <= r.x+r.width+4) && (r.y+r.height-4 <= p.y) && (p.y <= r.y+r.height+4)) {
			return 8;
		}
		else {
			return 0;
		}
	}

	//컴포넌트가 선택되었을 때 에디터 페인 처리
	public static void setSelected(boolean isSelected, int index) {
		Iterator<EditorView> it = viewE.iterator();
		EditorView v = null;
		int cnt = 0;
		Color selected = new Color(68, 114, 196);
		Color notSelected = new Color(165, 165, 165);
		
		if(isSelected) {
			while(it.hasNext()) {
				v = it.next();
				if(cnt == index) {
					v.setBackground(selected);
				}
				else {
					v.isSelected = false;
					v.setBackground(notSelected);
				}
				cnt++;
			}
		}
		else {
			while(it.hasNext()) {
				v = it.next();
				v.isSelected = false;
				v.isMoved = false;
				v.isStretched = 0;
				v.setBackground(notSelected);
			}
		}
	}
	
	//컴포넌트가 선택되었을 때 도구 설정
	public static void setTool(int x, int y, int width, int height) {
		if(!EditorView.toolSet) {
			for(int i=0; i<8; i++) {
				stretchTool[i] = new JLabel();
				stretchTool[i].setBounds(0, 0, 9, 9);
				stretchTool[i].setBackground(Color.WHITE);
				stretchTool[i].setOpaque(true);
				stretchTool[i].setEnabled(false);
				Frame.editorPane.add(stretchTool[i]);
			}
			EditorView.toolSet = true;
		}
		stretchTool[0].setLocation(x-4, y-4);
		stretchTool[1].setLocation(x+(width/2)-4, y-4);
		stretchTool[2].setLocation(x+width-4, y-4);
		stretchTool[3].setLocation(x-4, y+(height/2)-4);
		stretchTool[4].setLocation(x+width-4, y+(height/2)-4);
		stretchTool[5].setLocation(x-4, y+height-4);
		stretchTool[6].setLocation(x+(width/2)-4, y+height-4);
		stretchTool[7].setLocation(x+width-4, y+height-4);
		if(!toolIsOpaque) {
			toolIsOpaque = true;
			for(int i=0; i<8; i++) {
				stretchTool[i].setOpaque(true);
				stretchTool[i].setBorder(toolBorder);
			}
		}
	}
	
	//컴포넌트 선택이 해제되었을 때 도구 초기화
	public static void initTool() {
		if(!EditorView.toolSet) {
			for(int i=0; i<8; i++) {
				stretchTool[i] = new JLabel();
				stretchTool[i].setBounds(0, 0, 9, 9);
				stretchTool[i].setBackground(Color.WHITE);
				stretchTool[i].setOpaque(true);
				stretchTool[i].setEnabled(false);
				Frame.editorPane.add(stretchTool[i]);
			}
			EditorView.toolSet = true;
		}
		toolIsOpaque = false;
		for(int i=0; i<8; i++) {
			stretchTool[i].setOpaque(false);
			stretchTool[i].setBorder(null);
		}
	}
	
	//컴포넌트들의 zOrder(페인에 그려지는 우선순위) 정리 함수
	public static void setZOrder(int index) {
		Iterator<EditorView> it = EditorView.viewE.iterator();
		int size = EditorView.viewE.size() + 7, cnt = 0;
		EditorView v = null, temp = null;
		
		while(it.hasNext()) {
			temp = it.next();
			if(cnt == index) {
				v = temp;
			}
			else {
				Frame.editorPane.setComponentZOrder(temp, size);
				size--;
			}
			cnt++;
		}
		if(v != null) {
			Frame.editorPane.setComponentZOrder(v, size);
			size--;
		}
		
		for(cnt=0; cnt<8; cnt++) {
			Frame.editorPane.setComponentZOrder(stretchTool[cnt], size);
			size--;
		}
		Frame.editorPane.repaint();
	}
}

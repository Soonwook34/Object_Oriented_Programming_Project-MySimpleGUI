package layout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

import javax.swing.JPanel;

import componentManager.AttributeView;
import componentManager.EditorView;

//������ ���� Ŭ����
public class EditorPane extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static boolean isGeneratingComponent = false;
	public static boolean isDeletingComponent = false;
	static Point startPoint;

	//������
	public EditorPane() {
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.addMouseListener(new EditorPaneMouseListener());
		this.addMouseMotionListener(new EditorPaneMouseMotionListener());
	}
	
	//������ ������ MouseListener
	private class EditorPaneMouseListener extends MouseAdapter {
		
		private Point p;
		private Iterator<EditorView> it;
		private int cnt, index;
		private EditorView v, temp;
		
		public void mouseClicked(MouseEvent e) {
			//������Ʈ ���� ���� ��
			if(EditorPane.isDeletingComponent) {
				p = e.getPoint();
				it = EditorView.viewE.iterator();
				cnt = 0;
				index = 0;
				v = null;
				temp = null;
				
				while(it.hasNext()) {
					temp = it.next();
					if(temp.contains(p)) {
						if(temp.isSelected) {
							index = cnt;
							EditorView.removeComponent(index);
							EditorPane.isDeletingComponent = false;
							return;
						}
						v = temp;
						index = cnt;
					}
					cnt++;
				}
				
				if(v != null) {
					EditorView.removeComponent(index);
				}
				EditorPane.isDeletingComponent = false;
			}
		}
		
		public void mousePressed(MouseEvent e) {
			p = e.getPoint();
			it = EditorView.viewE.iterator();
			cnt = 0;
			index = 0;
			v = null;
			temp = null;
			
			//������Ʈ ���� ���� ��
			if(EditorPane.isGeneratingComponent) {
				EditorView.setSelected(false, -1);
				startPoint = p;
				EditorView.newComponent(p.x, p.y, 0, 0);
				index = EditorView.viewE.size() - 1;
				v = EditorView.viewE.get(index);
				v.isSelected = true;
				v.setBackground(new Color(142, 170, 219));
				EditorView.setZOrder(index);
				return;
			}
			
			while(it.hasNext()) {
				temp = it.next();
				
				//���콺�� ������Ʈ�� ������ �� ����
				if(temp.contains(p)) {
					v = temp;
					if(temp.isSelected) {
						v.isStretched = v.isReadyToBeStretched(p);
						if(v.isStretched != 0) {
							v.mouse.setLocation(v.getX(), v.getY());
						}
						else {
							v.mouse.setLocation(p.x - v.getX(), p.y - v.getY());
							v.isMoved = true;
						}
						return;
					}
					else {
						index = cnt;
					}
				}
				else {
					temp.isSelected = false;
				}
				cnt++;
			}
			//���õǾ��� �� ����
			if(v != null) {
				v.mouse.setLocation(p.x - v.getX(), p.y - v.getY());
				v.isSelected = true;
				v.isMoved = true;
				AttributeView.getInfo(index);
				EditorView.setSelected(true, index);
				EditorView.setTool(v.getX(), v.getY(), v.getWidth(), v.getHeight());
				EditorView.setZOrder(index);
			}
			//������ �ȵǾ����� �� ����
			else {
				AttributeView.initInfo();
				EditorView.setSelected(false, -1);
				EditorView.initTool();
				EditorView.setZOrder(-1);
			}
		}
		
		public void mouseReleased(MouseEvent e) {
			int index;
			//������Ʈ ���� ���� ��
			if(EditorPane.isGeneratingComponent) {
				index = EditorView.viewE.size() - 1;
				v = EditorView.viewE.get(index);
				EditorView.setSelected(true, index);
				EditorPane.isGeneratingComponent = false;
				EditorView.setZOrder(index);
				return;
			}
			
			it = EditorView.viewE.iterator();
			index = 0;
			//���õǾ��ִ� ������Ʈ�� ���ؼ� isMoved, isStretched ����
			while(it.hasNext()) {
				v = it.next();
				if(v.isSelected) {
					v.isMoved = false;
					v.isStretched = 0;
					v.setBackground(new Color(68, 114, 196));
					EditorView.setZOrder(index);
					return;
				}
				index++;
			}
		}
	}
	
	//������ ������ MouseMotionListener
	private class EditorPaneMouseMotionListener implements MouseMotionListener {
		
		private Point p;
		private Iterator<EditorView> it;
		private int index;
		private EditorView r;
		
		public void mouseDragged(MouseEvent e) {
			p = e.getPoint();
			it = EditorView.viewE.iterator();
			index = 0;
			r = null;
			int x, y, width, height;
			
			EditorPane.isDeletingComponent = false;
			
			//������Ʈ ���� ���� ��
			if(EditorPane.isGeneratingComponent) {
				index = EditorView.viewE.size() - 1;
				r = EditorView.viewE.get(index);
				x = r.getX();
				y = r.getY();
				width = p.x - x;
				height = p.y - y;
				EditorView.boundsUpdate(index, x, y, width, height);
				return;
			}
			
			//������Ʈ�� �����̰ų� ũ�Ⱑ ����� ��
			while(it.hasNext()) {
				r = it.next();
				if(r.isMoved) {
					p.x = p.x - r.mouse.x;
					p.y = p.y - r.mouse.y;
					EditorView.pointUpdate(index, p);
					return;
				}
				
				if(r.isStretched != 0) {
					r.setBackground(new Color(142, 170, 219));
					switch(r.isStretched) {
						case 1:
							x = p.x;
							y = p.y;
							width = r.getWidth() + (r.mouse.x - p.x);
							height = r.getHeight() + (r.mouse.y - p.y);
							EditorView.boundsUpdate(index, x, y, width, height);
							r.mouse.x = p.x;
							r.mouse.y = p.y;
							break;
						case 2:
							x = r.getX();
							y = p.y;
							width = r.getWidth();
							height = r.getHeight() + (r.mouse.y - p.y);
							EditorView.boundsUpdate(index, x, y, width, height);
							r.mouse.y = p.y;
							break;
						case 3:
							x = r.getX();
							y = p.y;
							width = p.x - x;
							height = r.getY() + r.getHeight() - p.y;
							EditorView.boundsUpdate(index, x, y, width, height);
							break;
						case 4:
							x = p.x;
							y = r.getY();
							width = r.getWidth() + (r.mouse.x - p.x);
							height = r.getHeight();
							EditorView.boundsUpdate(index, x, y, width, height);
							r.mouse.x = p.x;
							break;
						case 5:
							x = r.getX();
							y = r.getY();
							width = p.x - x;
							height = r.getHeight();
							EditorView.boundsUpdate(index, x, y, width, height);
							break;
						case 6:
							x = p.x;
							y = r.getY();
							width = r.getX() + r.getWidth() - p.x;
							height = p.y - y;
							EditorView.boundsUpdate(index, x, y, width, height);
							break;
						case 7:
							x = r.getX();
							y = r.getY();
							width = r.getWidth();
							height = p.y - r.mouse.y;
							EditorView.boundsUpdate(index, x, y, width, height);
							break;
						case 8:
							x = r.getX();
							y = r.getY();
							width = p.x - x;
							height = p.y - y;
							EditorView.boundsUpdate(index, x, y, width, height);
							break;
					}
					return;
				}
				index++;
			}
		}
		
		public void mouseMoved(MouseEvent e) {}
	}
}

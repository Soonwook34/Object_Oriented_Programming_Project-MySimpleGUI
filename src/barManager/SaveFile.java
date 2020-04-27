package barManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import componentManager.ComponentModel;
import layout.Frame;

//������ ó���ϴ� Ŭ����
public class SaveFile extends FileCheck {

	public static void execute() {
		//�����ְ�
		if(isOpened) {
			//����Ǿ�������
			if(isSaved) {
				return;
			}
			//����Ǿ����� ������
			else {
				//����
				save();
			}
		}
		//�������� �ʴٸ�
		else {
			//�ٸ� �̸����� ����
			SaveAsFile.execute();
		}
	}
	
	//������ �����ϴ� Ŭ����
	public static void save() {
		JSONArray componentArray = new JSONArray();
		JSONObject componentList;
		Iterator<ComponentModel> it = ComponentModel.getIterator();
		ComponentModel cm = null;
		
		componentList = new JSONObject();
		
		while(it.hasNext()) {
			JSONObject componentInfo = new JSONObject();
			cm = it.next();
			//������Ʈ�� �ϳ��� jsonArray�� ����
			componentInfo.put("type", cm.getType());
			componentInfo.put("var", cm.getVar());
			componentInfo.put("text", cm.getText());
			componentInfo.put("x", cm.getX());
			componentInfo.put("y", cm.getY());
			componentInfo.put("width", cm.getWidth());
			componentInfo.put("height", cm.getHeight());
			
			componentArray.add(componentInfo);
		}
		//���� �߰�
		componentList.put("Component", componentArray);
		
		try {
			String newName = "save/" + fileName + ".json";
			FileWriter file = new FileWriter(newName);
			
			//json ���Ͽ� ����
			file.write(componentList.toJSONString());
			file.flush();
			file.close();
			//�� ����
			isOpened = true;
			isSaved = true;
			Frame.frame.setTitle(fileName + " - MySimpleGUI");
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(Frame.frame, "IOException�� �߻��Ͽ����ϴ�", "�˸�", JOptionPane.WARNING_MESSAGE);
		}
	}
}

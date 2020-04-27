package barManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import componentManager.AttributeView;
import componentManager.ComponentController;
import componentManager.EditorView;
import layout.Frame;

//���� ���⸦ ó���ϴ� Ŭ����
public class OpenFile extends FileCheck {

	public static void execute() {
		//������ �����ϴ��� Ȯ��
		switch(FileCheck.fileExists(0)) {
			//���
			case 0:
			//�� ���� �̸��� �Է����� ��
			case 1:
				return;
			//������ ã���� ��
			case 2:
				//���� ����� ��
				NewFile.execute();
				fileName = tempFileName;
				//����
				open();
				break;
			//������ ���� ��
			case 3:
				JOptionPane.showMessageDialog(Frame.frame, fileName + "������ �����ϴ�.\n���� �̸��� Ȯ���ϰ� �ٽ� �õ��Ͻʽÿ�.", "����", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//���⸦ �����ϴ� Ŭ����
	private static void open() {
		JSONParser componentParser = new JSONParser();
		JSONArray componentArray;
		JSONObject componentInfo, componentList;
		String type, var, text;
		int x, y, width, height;
		
		try {
			String newFile = "save/" + fileName + ".json";
			
			componentList = (JSONObject)componentParser.parse(new FileReader(newFile));
			componentArray = (JSONArray)componentList.get("Component");
			
			//json ���� �о����
			Iterator<JSONObject> it = componentArray.iterator();
			while(it.hasNext()) {
				componentInfo = (JSONObject)it.next();
				//������Ʈ ���� �ϳ��� �޾ƿ���
				type = (String)componentInfo.get("type");
				var = (String)componentInfo.get("var");
				text = (String)componentInfo.get("text");
				x = ((Long)componentInfo.get("x")).intValue();
				y = ((Long)componentInfo.get("y")).intValue();
				width = ((Long)componentInfo.get("width")).intValue();
				height = ((Long)componentInfo.get("height")).intValue();
				
				//������Ʈ �߰�
				ComponentController.newComponent(type, var, text, x, y, width, height);
			}
			//�� ����
			isOpened = true;
			isSaved = true;
			AttributeView.initInfo();
			EditorView.setSelected(false, -1);
			EditorView.initTool();
			EditorView.setZOrder(-1);
			Frame.frame.setTitle(fileName + " - MySimpleGUI");
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(Frame.frame, "IOException�� �߻��Ͽ����ϴ�", "�˸�", JOptionPane.WARNING_MESSAGE);
		}
		catch (ParseException e) {
			JOptionPane.showMessageDialog(Frame.frame, "ParseException�� �߻��Ͽ����ϴ�", "�˸�", JOptionPane.WARNING_MESSAGE);
		}
	}
}

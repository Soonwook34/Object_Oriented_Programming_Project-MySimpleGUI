package barManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import componentManager.ComponentModel;
import layout.Frame;

//저장을 처리하는 클래스
public class SaveFile extends FileCheck {

	public static void execute() {
		//열려있고
		if(isOpened) {
			//저장되어있으면
			if(isSaved) {
				return;
			}
			//저장되어있지 않으면
			else {
				//저장
				save();
			}
		}
		//열려있지 않다면
		else {
			//다른 이름으로 저장
			SaveAsFile.execute();
		}
	}
	
	//저장을 실행하는 클래스
	public static void save() {
		JSONArray componentArray = new JSONArray();
		JSONObject componentList;
		Iterator<ComponentModel> it = ComponentModel.getIterator();
		ComponentModel cm = null;
		
		componentList = new JSONObject();
		
		while(it.hasNext()) {
			JSONObject componentInfo = new JSONObject();
			cm = it.next();
			//컴포넌트를 하나씩 jsonArray에 저장
			componentInfo.put("type", cm.getType());
			componentInfo.put("var", cm.getVar());
			componentInfo.put("text", cm.getText());
			componentInfo.put("x", cm.getX());
			componentInfo.put("y", cm.getY());
			componentInfo.put("width", cm.getWidth());
			componentInfo.put("height", cm.getHeight());
			
			componentArray.add(componentInfo);
		}
		//최종 추가
		componentList.put("Component", componentArray);
		
		try {
			String newName = "save/" + fileName + ".json";
			FileWriter file = new FileWriter(newName);
			
			//json 파일에 쓰기
			file.write(componentList.toJSONString());
			file.flush();
			file.close();
			//값 설정
			isOpened = true;
			isSaved = true;
			Frame.frame.setTitle(fileName + " - MySimpleGUI");
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(Frame.frame, "IOException이 발생하였습니다", "알림", JOptionPane.WARNING_MESSAGE);
		}
	}
}

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

//파일 열기를 처리하는 클래스
public class OpenFile extends FileCheck {

	public static void execute() {
		//파일이 존재하는지 확인
		switch(FileCheck.fileExists(0)) {
			//취소
			case 0:
			//빈 파일 이름을 입력했을 때
			case 1:
				return;
			//파일을 찾았을 때
			case 2:
				//새로 만들기 후
				NewFile.execute();
				fileName = tempFileName;
				//열기
				open();
				break;
			//파일이 없을 때
			case 3:
				JOptionPane.showMessageDialog(Frame.frame, fileName + "파일이 없습니다.\n파일 이름을 확인하고 다시 시도하십시오.", "열기", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//열기를 실행하는 클래스
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
			
			//json 파일 읽어오기
			Iterator<JSONObject> it = componentArray.iterator();
			while(it.hasNext()) {
				componentInfo = (JSONObject)it.next();
				//컴포넌트 정보 하나씩 받아오기
				type = (String)componentInfo.get("type");
				var = (String)componentInfo.get("var");
				text = (String)componentInfo.get("text");
				x = ((Long)componentInfo.get("x")).intValue();
				y = ((Long)componentInfo.get("y")).intValue();
				width = ((Long)componentInfo.get("width")).intValue();
				height = ((Long)componentInfo.get("height")).intValue();
				
				//컴포넌트 추가
				ComponentController.newComponent(type, var, text, x, y, width, height);
			}
			//값 지정
			isOpened = true;
			isSaved = true;
			AttributeView.initInfo();
			EditorView.setSelected(false, -1);
			EditorView.initTool();
			EditorView.setZOrder(-1);
			Frame.frame.setTitle(fileName + " - MySimpleGUI");
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(Frame.frame, "IOException이 발생하였습니다", "알림", JOptionPane.WARNING_MESSAGE);
		}
		catch (ParseException e) {
			JOptionPane.showMessageDialog(Frame.frame, "ParseException이 발생하였습니다", "알림", JOptionPane.WARNING_MESSAGE);
		}
	}
}

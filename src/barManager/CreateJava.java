package barManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import componentManager.ComponentModel;
import layout.Frame;

//java파일을 생성하는 클래스
public class CreateJava extends FileCheck {
	
	public static void execute() {
		File dirPath = new File("./save");
		//save 디렉터리가 있는지 확인
		if(!dirPath.exists() || dirPath.isFile()) {
			dirPath.mkdirs();
		}
		
		String file;
		//파일 생성
		if(fileName.isEmpty()) {
			file = "save/제목_없음.java";
		}
		else {
			file = "save/" + fileName + ".java";
		}
		
		try {
			//java파일 내용 입력하기
			BufferedWriter java = new BufferedWriter(new FileWriter(file));
			
			java.write("import java.awt.Color;");
			java.newLine();
			java.write("import javax.swing.*;");
			java.newLine();
			java.newLine();
			java.write("public class " + fileName + " extends JFrame {");
			java.newLine();
			java.newLine();
			//생성자
			java.write("	public " + fileName + "() {");
			java.newLine();
			java.write("		this.setTitle(\"" + fileName + "\");");
			java.newLine();
			java.write("		this.setSize(1100, 635);");
			java.newLine();
			java.write("		this.setLayout(null);");
			java.newLine();
			java.write("	}");
			java.newLine();
			java.newLine();
			//메인함수
			java.write("	public static void main(String[] args) {");
			java.newLine();
			java.write("		" + fileName + " frame = new " + fileName + "();");
			java.newLine();
			//컴포넌트 생성 및 추가
			Iterator<ComponentModel> it = ComponentModel.getIterator();
			ComponentModel cm = null;
			String type, var;
			while(it.hasNext()) {
				cm = it.next();
				type = cm.getType();
				var = cm.getVar().replace(' ', '_');
				switch(type) {
					case "JLabel":
						java.write("		" + type + " " + var + " = new " + type + "(\"" + cm.getText() + "\", 0);");
						break;
					case "JButton":
						java.write("		" + type + " " + var + " = new " + type + "(\"" + cm.getText() + "\");");
						break;
						case "JTextField":
						java.write("		" + type + " " + var + " = new " + type + "(\"" + cm.getText() + "\", 0);");
						break;
				}
				java.newLine();
				java.write("		" + var + ".setBounds(" + cm.getX() + ", " + cm.getY() + ", " + cm.getWidth() + ", " + cm.getHeight() + ");");
				java.newLine();
				java.write("		" + var + ".setOpaque(true);");
				java.newLine();
				switch(type) {
					case "JLabel":
						java.write("		" + var + ".setBackground(new Color(68, 114, 196));");
						java.newLine();
						java.write("		" + var + ".setForeground(new Color(245, 245, 245));");
						break;
					case "JButton":
						java.write("		" + var + ".setBackground(new Color(112, 173, 71));");
						java.newLine();
						java.write("		" + var + ".setForeground(new Color(245, 245, 245));");
						break;
					case "JTextField":
						java.write("		" + var + ".setBackground(new Color(245, 245, 245));");
						java.newLine();
						break;
				}

				java.newLine();
				java.write("		frame.add(" + var + ");");
				java.newLine();
			}
			java.write("		frame.setVisible(true);");
			java.newLine();
			java.write("	}");
			java.newLine();
			java.write("}");
			
			java.close();
			//알림 메세지
			JOptionPane.showMessageDialog(Frame.frame, fileName + ".java에 반영되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

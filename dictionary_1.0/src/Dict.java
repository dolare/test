import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;



public class Dict {
	
	final DefaultListModel model = new DefaultListModel(); 
	private Vector<String> words = new Vector<String>();
	private JFrame frame;
	private JList jl;
	private JScrollPane jsc;
	private JTextField jText ;
	
	public Dict(){
		getWords();
		initDict();		
	}
	
	public void initDict() {
	
		frame = new JFrame();
		frame.setTitle("Dictionary");	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setBounds(200, 100, 300, 660);
		frame.setIconImage(new ImageIcon("image//logo.png").getImage());
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		for (int i = 0; i < words.size(); i++) {
			model.addElement(words.get(i));
		}
		jl= new JList(model);
	 	 jsc = new JScrollPane(jl);
	 	jsc.setBounds(20, 90,265,500);
	 	frame.getContentPane().add(jsc);
		jl.setFont(new Font("宋体", Font.PLAIN, 15));
		
		
	    jText = new JTextField(); 
		jText.setBounds(20, 20, 260, 50);
		frame.getContentPane().add(jText);
		jText.setFont(new Font("Times New Roman", Font.BOLD, 25));
		jText.setForeground(new Color(25, 25, 25));
		jText.setBackground(new Color(200, 200, 200));
		
		
		Document dt = jText.getDocument();
        dt.addDocumentListener(new  javax.swing.event.DocumentListener(){
            
             public void changedUpdate(DocumentEvent documentEvent)   {
            	 String result = jText.getText();
            	 checkWord(result);
            }

            public void insertUpdate(DocumentEvent documentEvent)   {
            	String result = jText.getText();
            	model.clear();
           	 	checkWord(result);
            }

            public void removeUpdate(DocumentEvent documentEvent)   {
               String result = jText.getText();
               model.clear();
          	   checkWord(result);
            }
                        
        });    
	}
	
	public void getWords(){
		String fileName = "dictionary.txt";
		
		BufferedReader in = null;
		
		try{
			in = new BufferedReader(new FileReader(fileName));
	
			String textLine = "";
		
			while(( textLine =in.readLine())!=null){
			    words.add(textLine);
			 }
			
		}catch(Exception e){
			
		}	
	}
	
	public void checkWord(String result){
    	int rLength = result.length();
    	
    	if(rLength == 0){
    		for (int i = 0; i < words.size(); i++) {
				model.addElement(words.get(i));
			}
    	}else {
			for (int i = 0; i < words.size(); i++) {
				if(rLength > words.get(i).length())continue;
				for (int j = 0; j < rLength; j++) {
					if(words.get(i).charAt(j) != result.charAt(j))
						break;
					if(j == rLength - 1)
						model.addElement(words.get(i));
				}
			}
		}
    	
    	if (model.size() == 0) {
    		model.addElement("您所查的单词不在词典中");
		}
    }

	public static void main(String[] args) {
		Dict d1 = new Dict();
		d1.frame.setVisible(true);
	}
}

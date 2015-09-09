import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame; 
import javax.swing.JList; 
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document; 

public class test { 

  public static void main(String[] a) { 
    JFrame frame = new JFrame(); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    DefaultListModel listModel = new DefaultListModel();
    Vector months = new Vector(); 
   
    JList list = new JList(listModel); 
    for (int i = 0; i < months.size(); i++) {
		listModel.addElement(months.get(i));
	}
    
    JTextField jText ;
    jText = new JTextField(10);
	
	Document dt = jText.getDocument();
	
    dt.addDocumentListener(new  javax.swing.event.DocumentListener(){
        
         public void changedUpdate(DocumentEvent documentEvent)   {
        	 String result = jText.getText();
        	
        }

        public void insertUpdate(DocumentEvent documentEvent)   {
        	String result = jText.getText();
        	listModel.clear();
        	listModel.addElement(result);
        	System.out.println(result);
        }

        public void removeUpdate(DocumentEvent documentEvent)   {
           String result = jText.getText();
           listModel.clear();
           listModel.addElement(result);
           System.out.println(result);
        }
    });
//用Vector对象创建JList，可以在创建后增加内容，而采用数组创建则不可以 

   listModel.addElement("January"); 
   listModel.addElement("January"); 
   listModel.addElement("January"); 
   listModel.addElement("January"); 
   listModel.addElement("January"); 
   listModel.addElement("January"); 
   listModel.addElement("January"); 
   listModel.addElement("January"); 
   listModel.addElement("January"); 
   listModel.addElement("January"); 
    frame.setSize(300, 200); 
  
    frame.add(new JScrollPane(list)); 
    
    frame.setLayout(new FlowLayout());
	frame.add(jText);
  
    frame.setVisible(true); 
    listModel.addElement("1January"); 
  } 

} 
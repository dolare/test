

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Set extends JFrame {

	public static int count;
	private JTextArea stranslate;
	private JTextArea sarticle;
	public Set() {
		super();
		count=1;
		setTitle("��ƪ����");
		getContentPane().setLayout(null);
		setBounds(100, 100, 499, 375);

		final JSeparator separator = new JSeparator();
		separator.setBounds(10, 290, 472, 20);
		getContentPane().add(separator);
		//�鿴��һƪ
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				Data data = new Data();
				try {
					sarticle.setText(null);
					stranslate.setText(null);
					data.OpenConn();
					String sql= "select * from ArticleList";
					ResultSet re = data.executeQuery(sql);
					for(int i=0;i<count;i++)
						re.next();
					if(re.next()){
						sarticle.append(re.getString("article"));
						stranslate.append(re.getString("translate"));
						count++;
					}else{
						JOptionPane.showMessageDialog(AddWord.Frame, "�������һƪ��ллʹ�ã�");
					}
					
						
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setText("��һƪ");
		button.setBounds(276, 303, 82, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				setVisible(false);
			}
		});
		button_1.setText("�˳�");
		button_1.setBounds(384, 303, 82, 28);
		getContentPane().add(button_1);

		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 492, 284);
		getContentPane().add(tabbedPane);

		sarticle = new JTextArea();
		tabbedPane.addTab("Ӣ��ԭ��", null, sarticle, null);

		stranslate = new JTextArea();
		tabbedPane.addTab("���Ķ���", null, stranslate, null);
		
		showArticle();
		
	}
	private void showArticle(){
		Data data = new Data();
		try {
			sarticle.setText(null);
			stranslate.setText(null);
			data.OpenConn();
			String sql= "select * from ArticleList";
			ResultSet re = data.executeQuery(sql);

			if(re.next()){
				sarticle.append(re.getString("article"));
				stranslate.append(re.getString("translate"));
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

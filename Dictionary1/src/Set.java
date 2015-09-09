

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
		setTitle("名篇翻译");
		getContentPane().setLayout(null);
		setBounds(100, 100, 499, 375);

		final JSeparator separator = new JSeparator();
		separator.setBounds(10, 290, 472, 20);
		getContentPane().add(separator);
		//查看下一篇
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
						JOptionPane.showMessageDialog(AddWord.Frame, "这是最后一篇，谢谢使用！");
					}
					
						
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setText("下一篇");
		button.setBounds(276, 303, 82, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				setVisible(false);
			}
		});
		button_1.setText("退出");
		button_1.setBounds(384, 303, 82, 28);
		getContentPane().add(button_1);

		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 492, 284);
		getContentPane().add(tabbedPane);

		sarticle = new JTextArea();
		tabbedPane.addTab("英文原版", null, sarticle, null);

		stranslate = new JTextArea();
		tabbedPane.addTab("中文对照", null, stranslate, null);
		
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

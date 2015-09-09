

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Dictionary {

	private JTextArea wordusage;
	private JTextField searchword;
	private JList wordlist;
	private JFrame frame;
	private DefaultListModel listModel;

	public static void main(String args[]) {
		//������ķ����Ϊwindows��
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Dictionary window = new Dictionary();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dictionary() {
		initialize();
		showWord();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setTitle("����С�ֵ�");
		frame.setBounds(100, 100, 603, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�����˵�
		final JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		final JMenu menu = new JMenu();
		menu.setText("�ļ�");
		menuBar.add(menu);
		//���ӵ��ʽ���
		final JMenuItem menuItem = new JMenuItem();
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				AddWord frm = new AddWord();
				frm.setVisible(true);
			}
		});
		menuItem.setText("���Ӵʿ�");
		menu.add(menuItem);

		final JMenuItem menuItem_1 = new JMenuItem();
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				DeleteWord frm = new DeleteWord();
				frm.setVisible(true);
			}
		});
		menuItem_1.setText("ɾ���ʿ�");
		menu.add(menuItem_1);

		menu.addSeparator();
		//�������ͽ���
		final JMenuItem menuItem_7 = new JMenuItem();
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				AddSentence frm = new AddSentence();
				frm.setVisible(true);
			}
		});
		menuItem_7.setText("��������");
		menu.add(menuItem_7);

		final JMenuItem menuItem_10 = new JMenuItem();
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				AddArticle frm = new AddArticle();
				frm.setVisible(true);
			}
		});
		menuItem_10.setText("������ƪ");
		menu.add(menuItem_10);

		final JMenu menu_1 = new JMenu();
		menu_1.setText("�鿴");
		menuBar.add(menu_1);

		final JMenuItem menuItem_3 = new JMenuItem();
		//�鿴ȫ������
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				listModel.clear();
				showWord();
			}
		});
		menuItem_3.setText("ȫ���ʻ�");
		menu_1.add(menuItem_3);

		menu_1.addSeparator();

		final JMenuItem menuItem_4 = new JMenuItem();
		//�鿴���õ���
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				listModel.clear();
				searchGroup("���ôʻ�");
			}
		});
		menuItem_4.setText("���ôʻ�");
		menu_1.add(menuItem_4);

		final JMenuItem menuItem_5 = new JMenuItem();
		menuItem_5.setText("�ļ��ʻ�");
		menu_1.add(menuItem_5);

		final JMenuItem menuItem_6 = new JMenuItem();
		menuItem_6.setText("�����ʻ�");
		menu_1.add(menuItem_6);

		menu_1.addSeparator();
		//��������
		final JMenuItem menuItem_8 = new JMenuItem();
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				showSentence();
			}
		});
		menuItem_8.setText("��������");
		menu_1.add(menuItem_8);

		final JMenu menu_2 = new JMenu();
		menu_2.setText("����");
		menuBar.add(menu_2);

		final JMenuItem menuItem_9 = new JMenuItem();
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				Set frm = new Set();
				frm.setVisible(true);
			}
		});
		menuItem_9.setText("��ƪ����");
		menu_2.add(menuItem_9);

		final JMenu menu_3 = new JMenu();
		menu_3.setText("ϵͳ");
		menuBar.add(menu_3);
		//�˳�ϵͳ
		final JMenuItem menuItem_2 = new JMenuItem();
		menu_3.add(menuItem_2);
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuItem_2.setText("�˳�ϵͳ");
		//��������
		listModel = new DefaultListModel();
		wordlist = new JList(listModel);
		//��ʾ���ʵ���Ϣ
		wordlist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent arg0) {
				searchWord(wordlist.getSelectedValue().toString());
			}
		});
		wordlist.setBorder(new LineBorder(Color.black, 1, false));
		wordlist.setBounds(0, 56, 149, 373);
		frame.getContentPane().add(wordlist);

		searchword = new JTextField();
		searchword.setBounds(155, 6, 252, 26);
		frame.getContentPane().add(searchword);
		//��ʼ���
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				searchWord(searchword.getText());
			}
		});
		button.setText("���");
		button.setBounds(431, 7, 99, 23);
		frame.getContentPane().add(button);

		wordusage = new JTextArea();
		wordusage.setFont(new Font("����", Font.PLAIN, 15));
		wordusage.setBorder(new LineBorder(Color.black, 1, false));
		wordusage.setBounds(155, 55, 440, 373);
		frame.getContentPane().add(wordusage);

		final JLabel label = new JLabel();
		label.setText("�����ѯ���ʣ�");
		label.setBounds(10, 11, 99, 15);
		frame.getContentPane().add(label);

		final JSeparator separator = new JSeparator();
		separator.setBounds(9, 40, 576, 9);
		frame.getContentPane().add(separator);
		
		
	}
	//��ʾ���еĵ���
	private void showWord(){
		Data data = new Data();
		try {
			data.OpenConn();
			String sql= "select * from WordList";
			ResultSet re = data.executeQuery(sql);

			while(re.next())
				listModel.addElement(re.getString(1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ʾ����
	private void showSentence(){
		Data data = new Data();
		try {
			wordusage.setText(null);
			data.OpenConn();
			String sql= "select * from SentenceList";
			ResultSet re = data.executeQuery(sql);

			while(re.next()){
				wordusage.append(re.getString("english"));
				wordusage.append("\n");
				wordusage.append(re.getString("chinese"));
				wordusage.append("\n\n");
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����ĳ������
	private void searchWord(String sword){
		Data data = new Data();
		try {
			data.OpenConn();
			String sql= "select * from WordList where word ='"+sword+"'";
			ResultSet re = data.executeQuery(sql);
			//listModel.clear();
			if(re.next()){
				wordusage.setText(null);
				//listModel.addElement(re.getString("word"));
				wordusage.append("���ʣ�"+re.getString("word"));
				wordusage.append("\n\n");
				wordusage.append("���룺"+re.getString("translate"));
				wordusage.append("\n\n");
				wordusage.append("�÷���"+re.getString("usage"));
				wordusage.append("\n\n");
				wordusage.append("���飺"+re.getString("partment"));
			}
			else{
				JOptionPane.showMessageDialog(AddWord.Frame, "��Ǹ��ϵͳû�иõ��ʣ��鷳����֪�����ϵͳ���ӵ��ʣ�");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���ҷ���ĵ���
	private void searchGroup(String part){
		Data data = new Data();
		try {
			data.OpenConn();
			String sql= "select * from WordList where partment = '"+part+"'";
			ResultSet re = data.executeQuery(sql);

			while(re.next())
				listModel.addElement(re.getString(1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

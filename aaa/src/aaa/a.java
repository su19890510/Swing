package aaa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Rectangle;

public class a extends JFrame implements KeyListener {

	private JPanel contentPane;
	private final JTextField textField = new JTextField();
	JTree tree = null;
	DefaultMutableTreeNode root  = null;
	File[] fileList = null;
	JScrollPane scrollPane = new JScrollPane();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a frame = new a();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public a() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		this.setLocationRelativeTo( null ); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.add(scrollPane);
		scrollPane.setColumnHeaderView(textField);
		textField.setColumns(10);
		panel.setPreferredSize(new Dimension(250, 10));
		panel.setBounds(new Rectangle(0, 0, 150, 0));
		
		scrollPane.setViewportView(panel);
		textField.addKeyListener(this);
		
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void fileList()
	{
		String path = textField.getText();
		File file = new File(path);
		if(!file.exists())
		{
			JOptionPane.showConfirmDialog(null,"路径找不到", "提示",  JOptionPane.YES_OPTION);
		}
		fileList = file.listFiles();
		root = new DefaultMutableTreeNode(file.getName());
	
		tree =  new JTree(root);
		tree.setPreferredSize(new Dimension(500, 64));
//		tree.setVisibleRowCount(100);
		tree.setShowsRootHandles(true);
		scrollPane.setViewportView(tree);
		
		if(fileList == null )
		{
			return;
		}
		getChildFile(file, root);
//		for(File folderFile : fileList)
//		{
//			System.out.println(folderFile.getName());
//		}
		    
	}
	public void getChildFile(File file,DefaultMutableTreeNode node)
	{
		File[] fileList = file.listFiles();
		if(fileList == null)
		{
			return;
		}
	
		for(File fileChild:fileList)
		{
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(fileChild.getName());
			node.add(child);
			getChildFile(fileChild, child);
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == textField)
		{
			if(e.getKeyCode() == KeyEvent.VK_ENTER )
			{
				System.out.println("enter button is pressed ok");
				System.out.println(textField.getText());
				this.fileList();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

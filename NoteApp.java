import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class NoteApp extends JFrame implements ActionListener
{
	JTextArea ta;
	JMenuBar mb;
	JMenu file,edit;
	JMenuItem new1,open,cut,copy,paste,save,close;
	JFileChooser jfc;
	
	NoteApp()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		jfc=new JFileChooser();
		ta=new JTextArea();
		//ta.setBounds(0,40,800,780);
		mb=new JMenuBar();
		//mb.setBounds(0,0,800,20);
		file=new JMenu("File");
		edit=new JMenu("Edit");
		new1=new JMenuItem("new1");
		open=new JMenuItem("open");
		save=new JMenuItem("save");
		cut=new JMenuItem("cut");
		copy=new JMenuItem("copy");
		paste=new JMenuItem("paste");
		close=new JMenuItem("close");
		
		
		file.add(new1);
		file.add(open);
		file.add(save);
		file.add(close);
		file.addSeparator();
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		mb.add(file);
		mb.add(edit);
		add(mb, new BorderLayout().NORTH);
		add(ta, new BorderLayout().CENTER);
		
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		
		new1.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		close.addActionListener(this);
		
		file.addActionListener(this);
		edit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==new1)
		{
			ta.setText("");
		}
	}
	
	public static void main(String x[])
	{
		NoteApp np=new NoteApp();
		np.setSize(800,1000);
		np.setVisible(true);
		np.setTitle("ak notes");
	}
}
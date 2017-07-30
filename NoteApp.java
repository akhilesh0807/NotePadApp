import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


class NoteApp extends JFrame implements ActionListener
{
	JTextArea ta;
	JMenuBar mb;
	JMenu file,edit;
	JMenuItem new1,open,cut,copy,paste,save,close;
	JFileChooser jfc;
	DataInputStream take;
	File SelectedFile;
	Scanner s;
	JScrollPane jsp;
	
	NoteApp()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		take=new DataInputStream(System.in);
		//selectedFile=new File();
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
		//file.addSeparator();
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
		if(ae.getSource()==close)
		{
			System.exit(0);
		}
		if(ae.getSource()==open)
		{
			ta.setText("");
			int n=jfc.showOpenDialog(this);
			if(n== JFileChooser.APPROVE_OPTION)
			{
				try
				{
					s=new Scanner(jfc.getSelectedFile());
					while(s.hasNext())
					{
						String str=s.nextLine();
						ta.setText(str+"\n"+ta.getText());
						//jsp=new JScrollPane(ta);
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
				
		}
		if(ae.getSource()==save)
		{
			try
			{
				BufferedWriter br=new BufferedWriter(new FileWriter("TextDocument.text"));
				Scanner sc=new Scanner(ta.getText());
				while(sc.hasNext())
				{
					br.write(sc.nextLine());
					br.newLine();
				}
				br.close();
			}
			catch(IOException ie)
			{
				System.out.println(ie);
			}
			//jfc.showSaveDailog(null);
		}
	}
	
	public static void main(String x[])
	{
		NoteApp np=new NoteApp();
		np.setSize(500,500);
		np.setVisible(true);
		np.setTitle("ak notes");
	}
}
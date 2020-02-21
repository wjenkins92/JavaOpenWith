import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UserInterface
{
	JFrame MainFrame;
	JTextArea TextArea;
	
	public UserInterface ()
	{
		MainFrame = new JFrame("My Application");
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TextArea = new JTextArea();
		TextArea.setLineWrap(true);
		
		JScrollPane ScrollPane = new JScrollPane(TextArea);
		ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		MainFrame.getContentPane().add(ScrollPane);
	}
	
	public void display ()
	{
		MainFrame.setSize(300, 300);
		MainFrame.setVisible(true);
		MainFrame.setLocationRelativeTo(null);
	}
	
	public void pass (Object obj)
	{
		TextArea.append(obj.toString());
		TextArea.setCaretPosition(TextArea.getText().length());
	}
}
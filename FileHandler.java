import java.awt.desktop.OpenFilesEvent;
import java.awt.desktop.OpenFilesHandler;

public class FileHandler implements OpenFilesHandler
{
	UserInterface ui;
	
	public FileHandler (UserInterface arg)
	{
		ui = arg;
	}
	
	public void openFiles (OpenFilesEvent e)
	{
		ui.pass(e.getFiles().get(0).toString());
	}
}
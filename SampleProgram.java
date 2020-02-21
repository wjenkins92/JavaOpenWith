import java.awt.Desktop;

public class SampleProgram
{
	public static void main (String[] args)
	{
		UserInterface ui = new UserInterface();
		ui.display();
		
		FileHandler fh = new FileHandler(ui);
		Desktop.getDesktop().setOpenFileHandler(fh);
	}
}
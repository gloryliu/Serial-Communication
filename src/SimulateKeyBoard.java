import java.awt.*;

public class SimulateKeyBoard
{
	private static Robot robot;
	static
	{
		try
		{
			robot = new Robot();
		} catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void press(int code)
	{
		robot.keyPress(code);
		robot.keyRelease(code);
	}
}

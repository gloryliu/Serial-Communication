package ÓÎÏ·ÊÖ±ú;
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
	}
	public static void release(int code)
	{
		robot.keyRelease(code);
	}
}

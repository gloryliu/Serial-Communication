import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.comm.CommPortIdentifier;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.UnsupportedCommOperationException;

public class Main
{
	/**
	 * @param args
	 * @throws UnsupportedCommOperationException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnsupportedCommOperationException, IOException
	{
		new Main().listPortChoices();
	}
	void listPortChoices() throws UnsupportedCommOperationException, IOException
	{
		try
		{
			CommPortIdentifier portId;
			Enumeration en = CommPortIdentifier.getPortIdentifiers();
			// iterate through the ports.
			while (en.hasMoreElements())
			{
				portId = (CommPortIdentifier) en.nextElement();
				if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
				{
					if (portId.getName().equals("COM4"))
					{
						while (true)
						{
							SerialPort serialPort = (SerialPort) portId.open("Serial_Communication", 1000);
							serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);// 设置串口速率为9600，数据位8位，停止位1们，奇偶校验无
							
							InputStream in = serialPort.getInputStream();// 得到输入流
							
							OutputStream out = serialPort.getOutputStream();// 得到输出流
							// 进行输入输出操作
							BufferedReader br = new BufferedReader(new InputStreamReader(in));
							String str = null;
							while(( str = br.readLine() )!= null)
							{
							System.out.println(str);
							//模拟键盘操作
							simulateOperate(str);
							}
							
							// 操作结束后
							in.close();
							out.close();
							serialPort.close();// 关闭串口
						}
					}
				}
			}
		} catch (PortInUseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void simulateOperate(String str)
	{
		if(str.equals("->"))
		{
			SimulateKeyBoard.press(KeyEvent.VK_RIGHT);
		}else if(str.equals("<-"))
		{
			SimulateKeyBoard.press(KeyEvent.VK_LEFT);
		}else if(str.equals("space"))
		{
			SimulateKeyBoard.press(KeyEvent.VK_SPACE);
		}else if(str.equals("+"))
		{
			SimulateKeyBoard.press(KeyEvent.VK_UP);
		}else if(str.equals("-"))
		{
			SimulateKeyBoard.press(KeyEvent.VK_DOWN);
		}
	}
}

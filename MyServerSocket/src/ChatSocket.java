import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket; 

import org.json.JSONException;
import org.json.JSONObject;

public class ChatSocket extends Thread{
	
	private Socket socket;
	private BufferedWriter bWriter;
	private BufferedReader bReader;
	
	public ChatSocket (Socket socket) {
		this.socket = socket;
		try {
			bWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
			bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public void out(String s) 
	{
		s += "\n";
		try {
			bWriter.write(s);
			bWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void run() 
	{
		try 
		{
			String s;		
			while ((s = bReader.readLine()) != null) 
			{
				try 
				{
					JSONObject root = new JSONObject(s);
					if(root.has("content")) 
					{
						String toID = root.getString("toID");
						if(toID.equalsIgnoreCase("Group"))
						{
							ChatManager.getChatManager().publish(this, s);
						}
						else 
						{
							ChatSocket cs = ChatManager.getChatManager().hashMap.get(toID);
							if(cs != null)
							{
								cs.out(s);
							}
							else 
							{	
								System.out.println("没有该用户" + toID);	
							}
						}
					}
					else if(root.has("user") && root.has("password")) 
					{
						JSONObject a = new JSONObject();
						if(root.getString("user").equalsIgnoreCase(root.getString("password"))) 
						{
							if(!ChatManager.getChatManager().hashMap.containsKey("user"))
							{
								a.put("result", true);
								ChatManager.getChatManager().hashMap.put(root.getString("user"), this);
								System.out.println("用户" + root.getString("user") + "上线了！！");
							}
							else 
							{
								a.put("result", false);
							}
						}
						else 
						{
							a.put("result", false);
						}
						out(a.toString());
					}
				}
				catch (JSONException e)
				{
					e.printStackTrace();
				}			
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

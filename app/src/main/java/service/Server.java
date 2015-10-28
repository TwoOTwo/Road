package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Hua on 2015/10/28.
 */
public class Server implements Runnable
{
    public static final String SERVERIP = "192.168.1.100";
    public  static final int SERVERPORT = 51706;

    public void run()
    {
      try
      {
          ServerSocket serverSocket = new ServerSocket(SERVERPORT);
          while(true)
          {// 等待接受客户端请求
              Socket client = serverSocket.accept();
              try{
                  // 接受客户端信息
                  BufferedReader in = new BufferedReader(
                          new InputStreamReader(client.getInputStream()));

                  // 发送给客户端的消息
                  PrintWriter out = new PrintWriter(new BufferedWriter(
                          new OutputStreamWriter(client.getOutputStream())),true);
                  String str = in.readLine(); // 读取客户端的信息
                  if (str != null ) {
                      // 设置返回信息，把从客户端接收的信息再返回给客户端
                      out.println("You sent to server message is:" + str);
                      out.flush();

                      // 把客户端发送的信息保存到文件中
                      File file = new File("C://android.txt");
                      FileOutputStream fops = new FileOutputStream(file);
                      byte [] b = str.getBytes();
                      for ( int i = 0 ; i < b.length; i++ )
                      {
                          fops.write(b[i]);
                      }
                      System.out.println("S: Received: '" + str + "'");
                  } else {
                      System.out.println("Not receiver anything from client!");
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              } finally {
                  client.close();
                  System.out.println("S: Done.");
              }
          }
      } catch (Exception e) {
          System.out.println("S: Error 2");
          e.printStackTrace();
      }
    }
    public static void main(String [] args ) {
        Thread desktopServerThread = new Thread(new Server());
        desktopServerThread.start();

    }

}





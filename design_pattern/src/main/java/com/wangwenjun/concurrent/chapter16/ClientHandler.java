package com.wangwenjun.concurrent.chapter16;

import java.io.*;
import java.net.Socket;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ClientHandler implements Runnable {

    private final Socket socket;

    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter printWriter = new PrintWriter(outputStream)) {
            while (running) {
                String message = br.readLine();
                if (message == null)
                    break;
                System.out.println("Come from client >" + message);
                printWriter.write("echo " + message + "\n");
                printWriter.flush();
            }
        } catch (IOException e) {
//            e.printStackTrace();
            this.running = false;
        } finally {
            this.stop();
        }
    }

    public void stop() {
        if (!running) {
            return;
        }

        this.running = false;

        try {
            this.socket.close();
        } catch (IOException e) {
            //
        }
    }
}
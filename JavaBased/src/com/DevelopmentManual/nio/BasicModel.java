package com.DevelopmentManual.nio;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作者: xhd
 * 创建时间: 2019/8/27 8:44
 * 版本: V1.0
 */
public class BasicModel implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (Thread.interrupted()) {
                new Thread(new Handler(serverSocket.accept())).start();
            }
        } catch (Exception ex) {

        }
    }

    static class Handler implements Runnable {
        final Socket socket;

        Handler(Socket s) {
            socket = s;
        }

        public void run() {
            try {
                byte[] input = new byte[1024];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException ex) { /* ... */ }
        }

        private byte[] process(byte[] input) {
            byte[] output = null;
            /* ... */
            return output;
        }
    }
}

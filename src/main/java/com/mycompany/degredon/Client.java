/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.degredon;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author FabioAbreu
 */
public class Client {

    Socket socket = null;
    ObjectOutputStream oos = null;

    public Client() {

    }
    
    public static void main(String args[]) {
        Client client = new Client();
        Player player = new Player();
        Stats stats = new Stats();
        stats.randomizeAllStats();
        player.setStats(stats);
        player.setName("Nuckrieg");
        client.sendData(player);
        
        
    }

    public void sendData(Object obj) {

        try {
            
            openSocket("localhost", 12345);
            setOOS(socket);
            sendObject(oos, obj);
            closeObject(oos);

            System.out.println("SENT!");

            socket.close();
        } catch (Exception exc) {
            if (exc instanceof ConnectException) {
                JOptionPane.showMessageDialog(null, "Server is not ready!", "Error!", JOptionPane.ERROR_MESSAGE);
            } else {
            exc.printStackTrace();}
        }

    }

    public void sendObject(ObjectOutputStream oos, Object obj) {
        try {
            oos.writeObject(obj);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public void closeObject(ObjectOutputStream oos) throws IOException {
            oos.close();
    }

    public void openSocket(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }
    
    public void closeSocket(Socket skt) throws IOException {
        skt.close();
    }

    public ObjectOutputStream setOOS(Socket skt) throws IOException {
        OutputStream os = skt.getOutputStream();
        oos = new ObjectOutputStream(os);
        return oos;

    }

}

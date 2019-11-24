package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run(){
        SocketThread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();

        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("При работе клиента возникла ошибка");
        }

        while(clientConnected) {
            String line = ConsoleHelper.readString();
            if (line.equals("exit")) break;
            if (shouldSendTextFromConsole()) sendTextMessage(line);
        }
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            e.printStackTrace();
            clientConnected = false;
        }
    }



    public class SocketThread extends Thread{
        /*
        Чат (17)
        Последний, но самый главный метод класса SocketThread - это метод void run().
        Добавь его. Его реализация с учетом уже созданных методов выглядит очень просто.

        Давай напишем ее:
        1) Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
        2) Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.
        3) Создай объект класса Connection, используя сокет из п.17.2.
        4) Вызови метод, реализующий "рукопожатие" клиента с сервером (clientHandshake()).
        5) Вызови метод, реализующий основной цикл обработки сообщений сервера.
        6) При возникновении исключений IOException или ClassNotFoundException сообщи главному потоку о проблеме,
        используя notifyConnectionStatusChanged() и false в качестве параметра.

        Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.


        Требования:
        1. В методе run() должно быть установлено и сохранено в поле connection соединение с сервером
        (для получения адреса сервера и порта используй методы getServerAddress() и getServerPort()).
        2. В методе run() должен быть вызван метод clientHandshake().
        3. В методе run() должен быть вызван метод clientMainLoop().
        4. При возникновении исключений IOException или ClassNotFoundException в процессе работы метода run(),
        должен быть вызван метод notifyConnectionStatusChanged() с параметром false.
        5. Заголовок метода run() должен соответствовать условию задачи.
         */
        public void run(){
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();

            try {
                Client.this.connection = new Connection(new Socket(serverAddress, serverPort));
                clientHandshake();
                clientMainLoop();
            } catch (Exception e) {
                e.printStackTrace();
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{

            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else {
                    if (message.getType() == MessageType.NAME_ACCEPTED) {
                        notifyConnectionStatusChanged(true);
                        return;
                    } else {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }

        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{

            Message message;
            while (!clientConnected){
                message = connection.receive();
                if(!(MessageType.TEXT == message.getType() || MessageType.USER_REMOVED == message.getType() || MessageType.USER_ADDED == message.getType()))
                    throw new IOException();
                if (message.getData() != null) {
                    switch (message.getType()) {
                        case TEXT:
                            processIncomingMessage(message.getData());
                            break;
                        case USER_ADDED:
                            informAboutAddingNewUser(message.getData());
                            break;
                        case USER_REMOVED:
                            informAboutDeletingNewUser(message.getData());
                            break;
                        default:
                            throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }
        protected void processIncomingMessage(String message){
            /*- должен выводить текст message в консоль.*/
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            /*- должен выводить в консоль информацию о том,
            что участник с именем userName присоединился к чату.*/
            ConsoleHelper.writeMessage(userName + "Присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            /*- должен выводить в консоль, что участник с именем userName покинул чат.*/
            ConsoleHelper.writeMessage(userName + "Покинул чат");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            /*- этот метод должен:
            а) Устанавливать значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром.
            б) Оповещать (пробуждать ожидающий) основной поток класса Client.*/
            synchronized (Client.this){
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера: ");
        return ConsoleHelper.readString();
    }
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт: ");
        return ConsoleHelper.readInt();
    }
    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя: ");
        return ConsoleHelper.readString();
    }

}

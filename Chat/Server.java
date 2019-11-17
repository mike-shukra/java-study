package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
Чат (10)
Этап третий - главный цикл обработки сообщений сервером.

Добавь приватный метод void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException, где значение параметров такое же,
как и у метода notifyUsers().

Он должен:
1. Принимать сообщение клиента
2. Если принятое сообщение - это текст (тип TEXT), то формировать новое текстовое сообщение путем конкатенации: имени клиента, двоеточия, пробела и текста сообщения.
Например, если мы получили сообщение с текстом "привет чат" от пользователя "Боб", то нужно сформировать сообщение "Боб: привет чат".
3. Отправлять сформированное сообщение всем клиентам с помощью метода sendBroadcastMessage().
4. Если принятое сообщение не является текстом, вывести сообщение об ошибке
5. Организовать бесконечный цикл, внутрь которого перенести функционал пунктов 10.1-10.4.


Требования:
1. В классе Handler должен быть создан метод private void serverMainLoop(Connection connection, String userName).
2. Метод serverMainLoop() должен в бесконечном цикле получать сообщения от клиента (используя метод receive() класса Connection).
3. Если сообщение, полученное методом serverMainLoop(), имеет тип MessageType.TEXT, то должно быть отправлено новое сообщение всем участникам чата
используя метод sendBroadcastMessage() (форматирование сообщения описано в условии).
4. Если сообщение, полученное методом serverMainLoop(), имеет тип отличный от MessageType.TEXT, метод sendBroadcastMessage() не должен быть вызван,
и должно быть выведено сообщение об ошибке.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        try {
            for (Connection connection : connectionMap.values())
                connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка отправки");
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        ServerSocket serverSocket = new ServerSocket(consoleHelper.readInt());
        System.out.println("Start server");
        try {
            while (true){
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            serverSocket.close();
        }

    }

    private static class Handler extends Thread{
        private Socket socket;

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            /*
            Он должен:
            1. Принимать сообщение клиента
            2. Если принятое сообщение - это текст (тип TEXT), то формировать новое текстовое сообщение путем конкатенации: имени клиента, двоеточия, пробела и текста сообщения.
            Например, если мы получили сообщение с текстом "привет чат" от пользователя "Боб", то нужно сформировать сообщение "Боб: привет чат".
            3. Отправлять сформированное сообщение всем клиентам с помощью метода sendBroadcastMessage().
            4. Если принятое сообщение не является текстом, вывести сообщение об ошибке
            5. Организовать бесконечный цикл, внутрь которого перенести функционал пунктов 10.1-10.4.


            Требования:
            1. В классе Handler должен быть создан метод private void serverMainLoop(Connection connection, String userName).
            2. Метод serverMainLoop() должен в бесконечном цикле получать сообщения от клиента (используя метод receive() класса Connection).
            3. Если сообщение, полученное методом serverMainLoop(), имеет тип MessageType.TEXT, то должно быть отправлено новое сообщение всем участникам чата
            используя метод sendBroadcastMessage() (форматирование сообщения описано в условии).
            4. Если сообщение, полученное методом serverMainLoop(), имеет тип отличный от MessageType.TEXT, метод sendBroadcastMessage() не должен быть вызван,
            и должно быть выведено сообщение об ошибке.
             */

            while (true) {
                Message message = connection.receive();
                if (message != null && message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }
            }

        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            /*
            Метод должен:
            1) Пройтись по connectionMap.
            2) У каждого элемента из п.1 получить имя клиента, сформировать команду с типом USER_ADDED и полученным именем.
            3) Отправить сформированную команду через connection.
            4) Команду с типом USER_ADDED и именем равным userName отправлять не нужно, пользователь и так имеет информацию о себе.


            Требования:
            1. В классе Handler должен быть создан метод private void notifyUsers(Connection connection, String userName).
            2. Метод notifyUsers() должен отправлять через connection сообщение о том, что был добавлен пользователь с именем name для каждого имени из connectionMap.
            3. Метод notifyUsers() НЕ должен отправлять сообщение о добавлении пользователя, если имя пользователя совпадает со вторым параметром метода (userName).
             */
            for (String clientName : connectionMap.keySet()) {

                if (!userName.equals(clientName))
                    connection.send(new Message(MessageType.USER_ADDED, clientName));
            }
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message reply = connection.receive();
            String name = reply.getData();
            if (reply.getType() == MessageType.USER_NAME) {
                if (connectionMap.get(name) == null && !name.equals("")) {
                    connectionMap.put(name, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return name;
                }
                else return serverHandshake(connection);
            }
            else return serverHandshake(connection);
        }

        public Handler (Socket socket){
            this.socket = socket;
        }
    }


}

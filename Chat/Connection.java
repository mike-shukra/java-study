package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/*
Чат (5)
Клиент и сервер будут общаться через сокетное соединение.
Одна сторона будет записывать данные в сокет, а другая читать.
Их общение представляет собой обмен сообщениями Message.
Класс Connection будет выполнять роль обертки над классом java.net.Socket,
которая должна будет уметь сериализовать и десериализовать объекты типа Message в сокет.
Методы этого класса должны быть готовы к вызову из разных потоков.

Добавь в класс Connection:
1) Final поля:
а) Socket socket
б) ObjectOutputStream out
в) ObjectInputStream in

2) Конструктор, который должен принимать Socket в качестве параметра и инициализировать поля класса.
Для инициализации полей in и out используй соответствующие потоки сокета.
Конструктор может бросать исключение IOException.
Создать объект класса ObjectOutputStream нужно до того, как будет создаваться объект класса ObjectInputStream,
иначе может возникнуть взаимная блокировка потоков, которые хотят установить соединение через класс Connection.
Более подробно об этом ты можешь прочитать в спецификации класса ObjectInputStream.

3) Метод void send(Message message) throws IOException.
Он должен записывать (сериализовать) сообщение message в ObjectOutputStream.
Этот метод будет вызываться из нескольких потоков.
Позаботься, чтобы запись в объект ObjectOutputStream была возможна только одним потоком в определенный момент времени,
остальные желающие ждали завершения записи.
При этом другие методы класса Connection не должны быть заблокированы.

4) Метод Message receive() throws IOException, ClassNotFoundException.
Он должен читать (десериализовать) данные из ObjectInputStream.
Сделай так, чтобы операция чтения не могла быть одновременно вызвана несколькими потоками,
при этом вызов других методы класса Connection не блокировать.

5) Метод SocketAddress getRemoteSocketAddress(), возвращающий удаленный адрес сокетного соединения.

6) Метод void close() throws IOException, который должен закрывать все ресурсы класса.

Класс Connection должен поддерживать интерфейс Closeable.


Требования:
1. Класс Connection должен поддерживать интерфейс Closeable.
2. В классе Connection должно быть создано private final поле socket типа Socket.
3. В классе Connection должно быть создано private final поле out типа ObjectOutputStream.
4. В классе Connection должно быть создано private final поле in типа ObjectInputStream.
5. В классе Connection должен быть создан конструктор с одним параметром типа Socket инициализирующий поля класса в соответствии с условием задачи.
6. В классе Connection должен быть корректно реализован метод send c одним параметром типа Message.
7. В классе Connection должен быть корректно реализован метод receive без параметров.
8. Метод getRemoteSocketAddress класса Connection должен возвращать удаленный адрес сокетного соединения.
9. Метод close класса Connection должен закрывать потоки чтения, записи и сокетное соединение.
 */
public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
//        this.out = (ObjectOutputStream) socket.getOutputStream();
//        this.in = (ObjectInputStream) socket.getInputStream();
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message)throws IOException {
        synchronized (out) {
            out.writeObject(message);
        }
    }
    public Message receive() throws IOException, ClassNotFoundException{
        synchronized (in) {
            return (Message) in.readObject();
        }
    }

    public SocketAddress getRemoteSocketAddress() {
        return this.socket.getRemoteSocketAddress();
    }

    public void close() throws IOException {
        this.socket.close();
        this.out.close();
        this.in.close();
    }

}

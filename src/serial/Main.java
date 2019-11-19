package serial;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Gam o1 = new Gam(2,"Art");
        Gam o2 = new Gam(3,"Art143");
        Gam o3 = new Gam(4,"Ar444t");

        FileOutputStream fos =
                new FileOutputStream("D:\\Java\\SerialEx\\game.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(o1);
        os.writeObject(o2);
        os.writeObject(o3);
        os.close();

        FileInputStream fin =
                new FileInputStream("D:\\Java\\SerialEx\\game.ser");
        ObjectInputStream oi = new ObjectInputStream(fin);

        Gam  o4 = (Gam) oi.readObject();
        Gam  o5 = (Gam) oi.readObject();
        Gam  o6 = (Gam) oi.readObject();
        System.out.println(o4.age + "  " + o4.name);
        System.out.println(o5.age + "  " + o5.name);
        System.out.println(o6.age + "  " + o6.name);
        oi.close();

        FileWriter fw =
                new FileWriter("D:\\Java\\SerialEx\\foo.txt");
        fw.write("Hello my dear  foo txt");
        fw.close();
    }
}

class Gam implements Serializable {
    int age;
    String name;

    Gam(int a, String s) {
        age = a; name  = s;
    }
}

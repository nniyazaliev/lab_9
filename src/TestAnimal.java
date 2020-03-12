import java.io.*;
import java.util.*;

class TestAnimal {

    public static void main(String[] argv) {
        try {
            ArrayList<Animal> objList = new ArrayList<>();

            Animal animal1 = new Animal("Кошка", "кошачих", 20.5, 2);
            Animal animal2 = new Animal("Собака", "псовые", 8.5, 1);
            Animal animal3 = new Animal("Кошка", "кошачих", 10.5, 2);

            objList.add(animal1);
            objList.add(animal2);
            objList.add(animal3);

//            Serializable arList = new ArrayList();
//
//            Class arrayList = new ArrayList<>().getClass();
//            Class arrayList2 = ArrayList.class;
//
//            Class[] interf = arrayList.getInterfaces();
//            for (Class cInterf : interf) System.out.println(cInterf.getName());

            FileOutputStream fileOut = new FileOutputStream("serialize.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(objList);
            out.close();
            fileOut.close();
            System.out.println("Serialized: ");
            System.out.println(objList);
        } catch (Exception ex) {

        }

        try {
            FileInputStream fileIn = new FileInputStream("serialize.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Animal> a = (ArrayList<Animal>) in.readObject();
            //Animal a_ = (Animal) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized object:");
            System.out.println(a);
        } catch (Exception e) {
            System.out.println("Exception in deserialization: " + e);
        }

    }
}
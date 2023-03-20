package HW2.HW_2_1;

import java.util.Arrays;
import java.util.LinkedList;

public class ExLinkedList {
    public static void main(String[] args) {
        String str1 = new String("String1");
        String str2 = new String("String2");
        String str3 = new String("String3");
        String str4 = new String("String4");

        LinkedList<String> example = new LinkedList<String>();
        example.add(str1);
        example.add(str3);
        example.add(1, str2); //вставка по индексу
        example.add(str4);

        System.out.println(example);

        example.remove(1);
        System.out.println(example.size());

        if(!example.contains(str2)) {
            System.out.println(example.indexOf(str3));
            example.set(1,str2);
        }

        //добавление в начало и в конец
        example.addFirst(str2);
        example.addLast(str2);
        System.out.println(example);

        //возврат значения первого и последнего элеманта без удаления
        if (example.peekFirst().equals(example.peekLast())){
            System.out.println("Equals first and last");
        }
        //возврат значения первого и последнего элеманта с удалением
        if (example.pollFirst().equals(example.pollLast())){
            System.out.println(Arrays.toString(example.toArray())); // преобрахование в массив
        }


    }
}

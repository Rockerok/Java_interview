package HW2.HW_2_2;

import java.util.ArrayList;

public class ExArrayList {
    public static void main(String[] args) {
        String str1 = new String("String1");
        String str2 = new String("String2");
        String str3 = new String("String3");
        String str4 = new String("String4");

        ArrayList<String> exampleArL = new ArrayList<>();
        exampleArL.add(str1);
        exampleArL.add(str2);
        exampleArL.add(1,str3);
        exampleArL.add(str4);
        System.out.println(exampleArL);

        ArrayList<String> exampleA = new ArrayList<>();
        if(exampleA.addAll(exampleArL)){
            System.out.println(exampleA);
            exampleA.clear();
            System.out.println(exampleA.isEmpty());
        }

        exampleA = (ArrayList<String>)exampleArL.clone() ;
        if(exampleA.contains(str2)){
            exampleA.ensureCapacity(100);
            System.out.println(exampleA.indexOf(exampleA.get(exampleA.size()-1)));
        }
        exampleA.set(2,str3);
        System.out.println(exampleA);
        exampleA.remove(3);
        System.out.println(exampleA.remove(exampleA.lastIndexOf(str1)));
        System.out.println(exampleA);
        exampleA.set(0,str4);
        System.out.println(exampleA);
        exampleA.sort(String::compareTo);
        System.out.println(exampleA);

    }
}

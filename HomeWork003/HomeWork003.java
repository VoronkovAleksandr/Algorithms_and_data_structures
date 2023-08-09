package HomeWork003;

import java.util.Random;

// Необходимо реализовать метод разворота связного списка
// (двухсвязного или односвязного на выбор).
//Разворот списка реализован в методе revers
public class HomeWork003 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++)
            list.addSorted(new Random().nextInt(20));
        list.print();
        list.revers();
        list.print();

        LinkedList<String> list1 = new LinkedList<String>();
        list1.addSorted("Hello");
        list1.addSorted("World");
        list1.addSorted("Hi");
        list1.addSorted("GB");
        list1.addSorted("5");
        list1.print();
        list1.revers();
        list1.print();
    }
}


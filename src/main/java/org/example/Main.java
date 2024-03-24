package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] nameFirmа = new String[]{"Cartier", "Armani", "Tissot"};

        Object[][] markaWatch = new Object[][] {
                {nameFirmа[0], ":", "TANK FRANÇAISE", ",", "TANK CINTRÉE"},
                {nameFirmа[1], ":", "Emporio Armani AR0389", ",", "Emporio Armani AR1908"},
                {nameFirmа[2], ":", "T116.617.11.047.01", ",", "T120.210.17.116.00"}
        };

        ArrayList<Object[]> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите ли продолжить шопинг: 1.ДА, 2.НЕТ");
        int vibor = scanner.nextInt();
        int i = 0;
        String name = null;
        String email = null;
        String number = null;

        while(vibor == 1){
            System.out.println("Заказ - " +  (i + 1) +" "+ "Введите данные: ");
            int nomer = i + 1;
            if (name == null || email == null || number == null){
                System.out.println("ФИО- ");
                scanner.nextLine();
                name = scanner.nextLine();
                System.out.println("Email- ");
                email = scanner.nextLine();
                System.out.println("Number- ");
                number = scanner.nextLine();
            }
            System.out.println("Список товара в магазине: ");
            for (int f = 0; f < markaWatch.length; f++) {
                for (int j = 0; j < markaWatch[i].length; j++) {
                    System.out.print(markaWatch[f][j] + " ");
                }
                System.out.println();
            }
            scanner.nextLine();
            System.out.println("Выберите фирму часов (Cartier, Armani, Tissot): ");
            String firm = "";
            boolean firmaVibor = false;

            while (!firmaVibor){
                firm = scanner.nextLine();

                for (Object[] row : markaWatch) {
                    if (row[0].equals(firm)) {
                        firmaVibor = true;
                        break;
                    }
                }
                if (!firmaVibor) {
                    System.out.println("Такой фирмы нет в магазине. Пожалуйста, выберите фирму часов из следующих: Cartier, Armani, Tissot");
                }
            }
            System.out.print("Выберите марку часов из следующих: ");

            for (Object[] row : markaWatch) {
                if (row[0].equals(firm)) {
                    for (int j = 2; j < row.length; j++) {
                        System.out.print(row[j] + " ");
                    }
                    System.out.println();
                }
            }

            String mark = "";
            boolean markaVibor = false;

            while (!markaVibor) {
                mark = scanner.nextLine();

                for (Object[] row : markaWatch) {
                    if (row[0].equals(firm)) {
                        for (int j = 2; j < row.length; j++) {
                            if (row[j].equals(mark)) {
                                markaVibor = true;
                                break;
                            }
                        }
                    }
                }

                if (!markaVibor) {
                    System.out.println("Такой марки нет в магазине. Пожалуйста, выберите марку часов из предложенных вами фирмой.");
                }
            }

            System.out.println("Количество товара- ");
            String count = scanner.nextLine();
            Object[] zakaz = {name, email, number, firm, mark, count, nomer};
            data.add(zakaz);

            System.out.println("Хотите ли продолжить шопинг: 1.ДА, 2.НЕТ");
            vibor = scanner.nextInt();
            scanner.nextLine();

            i++;
        }

        System.out.println("Информация о покупателях:");
        for (Object[] zakaz : data) {
            System.out.println("Номер заказа: " + zakaz[6]);
            System.out.println("ФИО: " + zakaz[0]);
            System.out.println("Email: " + zakaz[1]);
            System.out.println("Номер телефона: " + zakaz[2]);
            System.out.println("Фирма часов: " + zakaz[3]);
            System.out.println("Марка часов: " + zakaz[4]);
            System.out.println("Количество: " + zakaz[5]);
            System.out.println();
        }
    }
}
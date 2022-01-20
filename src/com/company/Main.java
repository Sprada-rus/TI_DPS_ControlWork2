package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("Контрольная работа №2 \nВариант №3\n");
        System.out.println("Разработано в системе IntelliJ " +
                "\nПрограмма для решения арифметической задачи.\n" +
                "Вариант №3. Сапронов И.А. СПБ ГТИ(ТУ), 2022 год.\n");

        System.out.println("Нажмите [N] для проверки заданного числа\n" +
                "Нажмите [P] для печати чисел в заданном диапазоне\n" +
                "Нажмите [D] для печати чисел являющихся полным квадратом\n" +
                "Нажмите [Q] для выхода из меню\n");
        while (running) {
            String input = "";
            try {
                System.out.print("Введите комманду: ");
                input = new Scanner(System.in).next().toLowerCase();
            } catch (Exception e){
                System.out.println("Некорректно введено значение\n" +
                        "Просьба ввести повторно");
                continue;
            }
            switch (input) {
                case "n" -> inputNumbers();
                case "p" -> printNumbers();
                case "d" -> printDegreeThree();
                case "q" -> running = false;
                default -> System.out.println("Команда не распознана");
            }
        }
    }
    /*
    * Функция печатает числа которые являются полным квадратом
    * */
    public static void printDegreeThree(){
        Long num = 1L;
        System.out.println("Серия чисел являющихся полными квадратами");

        do {
            if (Solve.isDegreeSquare(Solve.sumDigits(num))) System.out.println(num);
            num++;
        } while (num < 1000 && num > 0);
    }
    /*
    * Функция печатает в заданном диапазоне те числа,
    * сумма цифр которых является полным квадратом и разность между соседними цифрами числа равна k
    * */
    public static void printNumbers(){
        int diff = 0;
        Long lower = 0L , upper = 0L, number = 0L;

        System.out.print("Введите число нижнего предела поиска: ");
        try {
            lower = new Scanner(System.in).nextLong();
        } catch (Exception e){
            System.out.println("Некорректное число нижнего предела!");
        }

        System.out.print("Введите число верхнего предела поиска: ");
        try {
            upper = new Scanner(System.in).nextLong();
        } catch (Exception e){
            System.out.println("Некорректное число верхнего предела!");
        }

        System.out.print("Введите цифры в диапазоне [1...9]: ");
        try {
            diff = new Scanner(System.in).nextInt();
            if (diff < 1 || diff > 9) throw new Exception("");
        } catch (Exception e){
            System.out.println("Некорректное значение цифры!");
        }

        if (lower > upper) {
            number = lower;
            lower = upper;
            upper = number;
        }

        for (number = lower; number <= upper; number++){
            if (Solve.checkNumber(number, diff)) System.out.println(number);
        }
    }

    /*
    * Функция вводит числа до тех пор, пока не будет введено (-1), и проверяет каждое число, чтобы сумма
    * цифр была полным квадратом и разность между соседними цифрами числа равна k, и подсчитывает их.
    * */
    public static void inputNumbers(){
        boolean zero = false;
        int diff, n = 0, m =0, number = 0;

        System.out.print("Введите значение разности k в диапазоне [1...9]: ");
        try{
            diff = new Scanner(System.in).nextInt();
            if (diff < 1 || diff > 9) throw new Exception();
        } catch (Exception e){
            System.out.println("Некорректное значение числа");
            return;
        }

        do {
            System.out.print("Введите число для проверки: ");
            try {
                number = new Scanner(System.in).nextInt();
            } catch (Exception e){
                System.out.print("Некорректное значение числа");
                return;
            }

            if (number == -1){
                zero = true;
            }

            if (Solve.checkNumber(Integer.toUnsignedLong(number), diff)) {
                n++;
                System.out.println("Число (" + number + ") имеет сумму цифр " + Solve.sumDigits(Integer.toUnsignedLong(number))
                        + " и эта сумма является полным квадратом.");
            } else m++;
        } while (zero);

        System.out.println("Чисел, имеющих заданное свойство: " + n + "\n" +
                "Прочих чисел: " + m);
    }
}
package com.company;

public class Solve {
    /*
    * Функция проверяет, обладает ли число заданными свойствами
    * */
    public static boolean checkNumber(Long num, int k){
        return isDifference(num, k) && isDegreeSquare(sumDigits(num));
    }

    /*
    * Функция проверяет, является ли число полным квадратом. Возвращает true – если число полный квадрат или false – если нет
    * */
    public static boolean isDegreeSquare(Long num){
        double checkNumber = Math.sqrt((double) Math.abs(num));
        return checkNumber % 1 == 0;
    }

    /*
    * Функция проверяет разность между цифрами числами Возвращает true – если разность между цифрами равна K
    * или false – если хотя бы для одной пары цифр разность неравна K
    * */
    public static boolean isDifference(Long num, int k){
        int digit, delta;
        num = num > 0 ? Math.abs(num) : num;
        digit = (int)(num % 10);
        num /= 10;

        while (num != 0){
            delta = (int)(num % 10 - digit);
            delta = delta < 0 ? Math.abs(delta) : delta;
            if (delta != k) return false;
            digit = (int)(num % 10);
            num /= 10;
        };

        return true;
    }

    /*
    * Функция вычисляет сумму цифр числа
    * */
    public static long sumDigits(Long num){
        long result = 0L;

        num = num < 0 ? Math.abs(num) : num;
        while (num != 0){
            result += num % 10;
            num /= 10;
        }

        return result;
    }
}

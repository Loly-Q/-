package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int getRandom(int min, int max) {                     //Функция для рандомных чисел в диапазоне от min до max
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {

        int [] mass = new int[100];                                 //Объявление одномерного массива для количества заключённых
        byte [] array = new byte[mass.length + 1];                  //Массив для не повторяющихся чисел
        boolean [] inmate = new boolean[array.length];              //Массив заключённых
        int alt = getRandom(1, mass.length);                        //Переменная для рандомногочисла
        int number;

        float x = 0, y = 0;
        int iterate = 10000;

        for (int inc = 1; inc <= iterate; inc++) {                         //Повторяем всё iterate раз
            for (int i = 0; i < array.length; i++) {                    //Заполнение массива с не повторяющимися числами
                array[i] = 1;
            }


            for (int i = 0; i < mass.length; i++) {                      //Заполнение массива
                while (array[alt] == 0) {                            //Цикл для проверки повторяющихся чисел, если повторяется то повторяем функцию рандома
                    alt = getRandom(1, mass.length);
                }
                mass[i] = alt;                                       //Записываем в массив и отмечаем в массиве что такое число уже есть
                array[alt] = 0;
            }

            inmate[0] = true;                                          //Заполняем первый элемент массива для удобства выполнения
            for (int i = 1; i < inmate.length; i++) {                   //Цикл для нахождения своего номера за половину количества заключённых
                number = i - 1;                                         //Уменьшаем на один для работы массива, из-за того что начинаем с первого, а не нулевого
                for (int j = 0; j < mass.length / 2; j++) {             //Цикл для прохождения по массиву
                    if (i != mass[number]) {                            //Условие, если заключённый нашёл свой номер, то записываем в массив что он нашёл свой номер
                        number = mass[number] - 1;
                    } else {
                        inmate[i] = true;
                    }
                }
            }
            int truInmate = 0;
            for (int i = 1; i < inmate.length; i++) {
                if (inmate[i] == true) truInmate++;
            }
            x = (100 * truInmate) / (inmate.length - 1);
            if(x == 100) y++;

        }
        x = (100 * y) / iterate;
        System.out.println("Процент правильнот ответевших:" + x + "%");


//
//        for (int i = 0; i < mass.length; i++) {                         //Цикл вывода массива
//                System.out.print(mass[i] + "; ");
//            }
//
//        System.out.println();
//        System.out.println(Arrays.toString(inmate));

        if (x < 100) {
            System.out.println("Всех заключённых убили");
        } else {
            System.out.println("Всех заключённых отпустили");
        }



    }
}

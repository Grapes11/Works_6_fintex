
/**
 * Данный класс реализует методы
 * для работы с телефонной книгой.
 *
 * @version 28.10.2019
 *
 * @author Никита виноградов
 */
package com.company;
import java.io.*;
import java.util.Arrays;

final class WorksWithFile  {
    /**
     * Приватный конструктор.
     */
    private WorksWithFile() {
    }

    /**
     * колочество бит в байте,
     * необходимо для метода mark.
     */
    private static final int BIT = 8;
    /**
     * количество строк в файле.
     */
    private static int numberLines;
    /**
     * массив, в который заносятся контакты.
     */
    private static String[] contacts;
    /**
     * позволяет переносить
     * текст на новую строку.
     */
    private static String newLine = System.getProperty("line.separator");


    /**
     * @throws IOException
     * Загружает текстовый файл и
     * помещает его элементы в массив.
     */
    static void loadFile() throws IOException {

        File file = new File("phone_book.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int l = (int) file.length();
        if (l > 0) {
            bufferedReader.mark(l * BIT);
        } else {
            bufferedReader.mark(1);
        }
        numberLines = 0;

        while ((bufferedReader.readLine()) != null) {
            numberLines++;
        }

        bufferedReader.reset();
        contacts = new String[numberLines];

        for (int i = 0; i <= numberLines - 1; i++) {
            contacts[i] = bufferedReader.readLine();
        }

        bufferedReader.close();
    }


    /**
     * @throws IOException
     * Перезагружает текстовый файл.
     */
        static void updateFile() throws IOException {
        FileWriter writer = new FileWriter("phone_book.txt", false);
        for (int i = 0; i <= numberLines - 1; i++) {
            String text = contacts[i];
            writer.write(text);
            writer.append('\n');
        }
        writer.flush();
    }


    /**
     * @throws Exception
     * Позволяет вносить новые
     * контакты в телефонную книгу.
     */
    static void contactRecord() throws Exception {
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Введите ФИО и номер "
                        + "телефона контакта, "
                        + "который хотите добавить "
                        + "в телефонную книгу"
                        + newLine
                        + "Если вы ввели все контакты, "
                        + "которые хотели, введите off");
                String contact = reader.readLine();
                if (contact.equals("off")) {
                    break;
                } else {
                    for (int i = 0; i <= numberLines - 1; i++) {
                        if (contact.equals(contacts[i])) {
                            throw (new MyException());
                        }
                    }
                    numberLines++;
                    contacts = Arrays.copyOf(contacts, numberLines);
                    contacts[numberLines - 1] = contact;
                }
            }

    }

    /**
     * Позволяет просматривать
     * имеющиеся контакты.
     */
    static void viewContact() {
        for (int i = 0; i <= numberLines - 1; i++) {
            System.out.println(contacts[i]);
        }
    }
}

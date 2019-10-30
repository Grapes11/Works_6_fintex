
package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class Main {
    /**
     * Приватный конструктор.
     */
    private Main() { }

    /**
     * @param args
     * Главный метод, в пишется основной код.
     */
    public static void main(final String[] args) {
        String newLine = System.getProperty("line.separator");
        try {
            WorksWithFile.loadFile();
            label:
            while (true) {
                System.out.println("Нажмите v, чтобы"
                        + " просмотреть контакты," + newLine
                        + "Нажмите r, чтобы добавить "
                        + "новый контакт"
                        + newLine
                        + "Чтобы закрыть приложение "
                        + "введите off");
                BufferedReader reader
                        = new BufferedReader(new InputStreamReader(System.in));
                String text = reader.readLine();
                switch (text) {
                    case "v":
                        WorksWithFile.viewContact();
                        break;
                    case "r":
                        WorksWithFile.contactRecord();
                        break;
                    case "off":
                        break label;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
            WorksWithFile.updateFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package crud.view;

import crud.model.Writer;
import crud.repo.IoWriterRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ViewWriter {
    public void run() {
        boolean t = true;
        System.out.println("Добро пожаловать в Writer!");
        int choice;
        String s;
        String k;
        int id;
        Scanner cs = new Scanner(System.in);


        while (t) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Выберете меню:");
            System.out.println("    1. Посмотреть список Writer");
            System.out.println("    2. Создать новый Writer");
            System.out.println("    3. Удалить Writer");
            System.out.println("    4. Изменить Writer");
            System.out.println("    0. Выход");

            choice = cs.nextInt();
            if (choice == 1) {
                try {

                    IoWriterRepo ioWriterRepo = new IoWriterRepo();
                    ioWriterRepo.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {

                try {
                    Writer writer = new Writer();
                    IoWriterRepo ioWriterRepo = new IoWriterRepo();
                    System.out.println("Введите FirstName");
                    s = br.readLine();
                    writer.setFirstName(s);
                    System.out.println("Введите LastName");
                    k = br.readLine();
                    writer.setLastName(k);
                    ioWriterRepo.create(writer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (choice == 3) {
                try {

                    IoWriterRepo ioWriterRepo = new IoWriterRepo();
                    System.out.println("Введите номер Writer который хотите удалить");                    id = cs.nextInt();
                    ioWriterRepo.delete(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (choice == 4) {
                try {

                    IoWriterRepo ioWriterRepo = new IoWriterRepo();
                    ioWriterRepo.update();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (choice == 0) {
                t = false;
            } else {
                System.out.println("!");
                System.out.println("!!");
                System.out.println("!!!");
                System.out.println("введите корректный номер меню!!!");
                System.out.println("!!!");
                System.out.println("!!");
                System.out.println("!");

            }
        }
    }
}
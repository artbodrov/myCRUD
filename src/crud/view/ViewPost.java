package crud.view;

import crud.model.Post;

import crud.repo.IoPostRepo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ViewPost {
    public void run() {
        boolean t = true;
        System.out.println("Добро пожаловать в Post!");
        int choice;
        String s;
        String k;
        String l;
        Scanner cs = new Scanner(System.in);


        while (t) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Выберете меню:");
            System.out.println("    1. Посмотреть список Post");
            System.out.println("    2. Создать новый Post");
            System.out.println("    3. Удалить Post");
            System.out.println("    4. Изменить Post");
            System.out.println("    0. Выход");

            choice = cs.nextInt();
            if (choice == 1) {
                try {

                    IoPostRepo ioPostRepo = new IoPostRepo();
                    ioPostRepo.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {

                try {
                    Post post = new Post();
                    IoPostRepo ioPostRepo = new IoPostRepo();
                    System.out.println("Введите Content");
                    s = br.readLine();
                    post.setContent(s);
                    System.out.println("Введите Created");
                    k = br.readLine();
                    post.setCreated(k);
                    System.out.println("Введите Updated");
                    l = br.readLine();
                    post.setUpdated(l);
                    ioPostRepo.create(post);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (choice == 3) {
                try {

                    IoPostRepo ioPostRepo = new IoPostRepo();
                    ioPostRepo.delete(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (choice == 4) {
                try {

                    IoPostRepo ioPostRepo = new IoPostRepo();
                    ioPostRepo.update();
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

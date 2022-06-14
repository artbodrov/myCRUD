package crud.view;
import crud.model.Label;
import crud.model.Post;
import crud.model.Writer;
import crud.repo.LabelRepo;
import crud.repo.PostRepo;
import crud.repo.WriterRepo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {
        boolean t = true;
        System.out.println("Добро пожаловать в CRUD!");
        int choice;
        Scanner cs = new Scanner(System.in);

        while (t) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Выберете меню:");
            System.out.println("    1. Writer");
            System.out.println("    2. Post");
            System.out.println("    3. Label");
            System.out.println("    0. Выход");

            choice = cs.nextInt();
            if (choice == 1) {
                boolean w = true;
                System.out.println("Добро пожаловать в Writer!");
                int choicewriter;
                String swr;
                String kwr;
                Scanner cswr = new Scanner(System.in);

                while (w) {
                    BufferedReader brwr = new BufferedReader(new InputStreamReader(System.in));

                    System.out.println("Выберете меню:");
                    System.out.println("    1. Посмотреть список Writer");
                    System.out.println("    2. Создать новый Writer");
                    System.out.println("    3. Удалить Writer");
                    System.out.println("    4. Изменить Writer");
                    System.out.println("    0. Выход");

                    choicewriter = cswr.nextInt();
                    if (choicewriter == 1) {
                        try {
                            WriterRepo writerRepo = new WriterRepo();
                            writerRepo.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (choicewriter == 2) {
                        try {
                            Writer writer = new Writer();
                            WriterRepo writerRepo = new WriterRepo();
                            System.out.println("Введите FirstName");
                            swr = brwr.readLine();
                            writer.setFirstName(swr);
                            System.out.println("Введите LastName");
                            kwr = brwr.readLine();
                            writer.setLastName(kwr);
                            writerRepo.create(writer);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (choicewriter == 3) {
                        try {
                            WriterRepo writerRepo = new WriterRepo();
                            writerRepo.delete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (choicewriter == 4) {
                        try {
                            WriterRepo writerRepo = new WriterRepo();
                            writerRepo.change();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (choicewriter == 0) {
                        w = false;
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
            } else if (choice == 2) {

                boolean p = true;
                System.out.println("Добро пожаловать в Post!");
                int choicepost;
                String sp;
                String kp;
                String lp;
                Scanner csp = new Scanner(System.in);

                while (p) {
                    BufferedReader brp = new BufferedReader(new InputStreamReader(System.in));

                    System.out.println("Выберете меню:");
                    System.out.println("    1. Посмотреть список Post");
                    System.out.println("    2. Создать новый Post");
                    System.out.println("    3. Удалить Post");
                    System.out.println("    4. Изменить Post");
                    System.out.println("    0. Выход");

                    choicepost = csp.nextInt();
                    if (choicepost == 1) {
                        try {
                            PostRepo postRepo = new PostRepo();
                            postRepo.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (choicepost == 2) {
                        try {
                            Post post = new Post();
                            PostRepo postRepo = new PostRepo();
                            System.out.println("Введите Content");
                            sp = brp.readLine();
                            post.setContent(sp);
                            System.out.println("Введите Created");
                            kp = brp.readLine();
                            post.setCreated(kp);
                            System.out.println("Введите Updated");
                            lp = brp.readLine();
                            post.setUpdated(lp);
                            postRepo.create(post);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (choicepost == 3) {
                        try {
                            PostRepo postRepo = new PostRepo();
                            postRepo.delete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (choicepost == 4) {
                        try {
                            PostRepo postRepo = new PostRepo();
                            postRepo.change();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (choicepost == 0) {
                        p = false;
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
            } else if (choice == 3) {
                boolean l = true;
                System.out.println("Добро пожаловать в Label!");
                int choicel;
                String sl;
                Scanner csl = new Scanner(System.in);

                while (l) {
                    BufferedReader brl = new BufferedReader(new InputStreamReader(System.in));

                    System.out.println("Выберете меню:");
                    System.out.println("    1. Посмотреть список Label");
                    System.out.println("    2. Создать новый Label");
                    System.out.println("    3. Удалить Label");
                    System.out.println("    4. Изменить Label");
                    System.out.println("    0. Выход");

                    choicel = csl.nextInt();
                    if (choicel == 1) {
                        try {
                            LabelRepo labelRepo = new LabelRepo();
                            labelRepo.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (choicel == 2) {
                        try {
                            Label label = new Label();
                            LabelRepo labelRepo = new LabelRepo();
                            System.out.println("Введите Label");
                            sl = brl.readLine();
                            label.setName(sl);
                            labelRepo.create(label);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (choicel == 3) {
                        try {
                            LabelRepo labelRepo = new LabelRepo();
                            labelRepo.delete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (choicel == 4) {
                        try {
                            LabelRepo labelRepo = new LabelRepo();
                            labelRepo.change();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (choicel == 0) {
                        l = false;
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

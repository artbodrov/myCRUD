package crud.repo;

import crud.model.Post;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PostRepo {
    private Map<Integer, Post> map;

    public PostRepo() {
        this.map = createMap();
    }

    public void read() throws IOException {
        try {

            FileReader tfr = new FileReader("C://Users//ru156010005//Documents//crud//posts.txt");

            char[] buffer = new char[8096];
            int chars = tfr.read(buffer);

            while (chars != -1) {
                System.out.println(String.valueOf(buffer, 0, chars));
                chars = tfr.read(buffer);
            }

            tfr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int calculateid() throws IOException {
        String result = null;

        try (RandomAccessFile raf = new RandomAccessFile("C://Users//ru156010005//Documents//crud//posts.txt", "r")) {
            int startId = (int) raf.length();
            while (startId >= 0 && (result == null || result.length() == 0)) {
                raf.seek(startId);
                if (startId > 0)
                    raf.readLine();
                result = raf.readLine();
                startId--;
            }
        }
        if (result == null) {
            return 1;
        } else {
            return Integer.parseInt(result.substring(0, result.indexOf(';'))) + 1;
        }
    }

    private void write(Post post) {

        try (BufferedWriter wr = new BufferedWriter(new FileWriter("C://Users//ru156010005//Documents//crud//posts.txt", true))) {

            wr.write(post.getId() + ";" + post.getContent()+ ";" + post.getCreated() +";" + post.getUpdated() + "\n");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public Post create(Post post) throws IOException {
        post.setId(calculateid());
        write(post);
        return post;
    }

    private Map<Integer, Post> createMap() {

        try {
            File readToFile = new File("C://Users//ru156010005//Documents//crud//posts.txt");
            FileInputStream fis = new FileInputStream(readToFile);
            Scanner sc = new Scanner(fis);

            Map<Integer, Post> map = new HashMap<>();

            String currentLine;

            while (sc.hasNextLine()) {
                currentLine = sc.nextLine();
                String[] splitcurrentLines = currentLine.split(";");
                Integer id = Integer.valueOf(splitcurrentLines[0]);
                String content = splitcurrentLines[1];
                String created = splitcurrentLines[2];
                String updated = splitcurrentLines[3];

                map.put(id, new Post(id, content, created,updated));

            }
            fis.close();

            for (Map.Entry<Integer, Post> m : map.entrySet()) {
                //  System.out.println("Key: " + m.getKey() + ", Writer: " + m.getValue());
            }
            return map;

        } catch (Exception e) {

        }

        return map;
    }
    public void delete() throws IOException {

        File writeToFile = new File("C://Users//ru156010005//Documents//crud//posts.txt");
        FileOutputStream fos = new FileOutputStream(writeToFile);
        PrintWriter pw = new PrintWriter(fos);
        System.out.println("Введите номер posts который хотите удалить");
        Scanner sc = new Scanner(System.in);
        Integer s = sc.nextInt();
        map.remove(s);


        for (Map.Entry<Integer, Post> m : map.entrySet()) {

            pw.println(m.getValue().getId() + ";" + m.getValue().getContent()+ ";" + m.getValue().getCreated()+ ";" + m.getValue().getUpdated());

        }

        pw.flush();
        pw.close();
        fos.close();

    }

    public void change() throws IOException {

        File writeToFile = new File("C://Users//ru156010005//Documents//crud//posts.txt");
        FileOutputStream fos = new FileOutputStream(writeToFile);
        PrintWriter pw = new PrintWriter(fos);
        System.out.println("Введите номер posts который хотите изменить");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc2 = new Scanner(System.in);
        Integer s = sc2.nextInt();
        System.out.println("Введите новый Post content");
        String k = br2.readLine();
        System.out.println("Введите новый Post created");
        String l = br2.readLine();
        System.out.println("Введите новый Post updated");
        String p = br2.readLine();

        map.put(s, new Post(s, k, l,p));

        for (Map.Entry<Integer, Post> m : map.entrySet()) {
            pw.println(m.getValue().getId() + ";" + m.getValue().getContent()+ ";" + m.getValue().getCreated()+ ";" + m.getValue().getUpdated());


        }

        pw.flush();
        pw.close();
        fos.close();

    }
}
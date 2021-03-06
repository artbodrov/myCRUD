package crud.repo;

import crud.model.Label;
import crud.model.Writer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IoWriterRepo implements WriteRepository {
    private Map<Integer, Writer> map;

    public IoWriterRepo() {
        this.map = createMap();
    }

    @Override
    public void read() throws IOException {
        try {

            FileReader tfr = new FileReader("C://Users//ru156010005//Documents//crud//writers.txt");

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

        try (RandomAccessFile raf = new RandomAccessFile("C://Users//ru156010005//Documents//crud//writers.txt", "r")) {
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

    private void write(Writer writer) {

        try (BufferedWriter wr = new BufferedWriter(new FileWriter("C://Users//ru156010005//Documents//crud//writers.txt", true))) {

            wr.write(writer.getId() + ";" + writer.getFirstName() + ";" + writer.getLastName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Writer create(Writer writer) throws IOException {
        writer.setId(calculateid());
        write(writer);
        return writer;
    }

    private Map<Integer, Writer> createMap() {

        try {
            File readToFile = new File("C://Users//ru156010005//Documents//crud//writers.txt");
            FileInputStream fis = new FileInputStream(readToFile);
            Scanner sc = new Scanner(fis);

            Map<Integer, Writer> map = new HashMap<>();

            String currentLine;

            while (sc.hasNextLine()) {
                currentLine = sc.nextLine();
                String[] splitcurrentLines = currentLine.split(";");
                Integer id = Integer.valueOf(splitcurrentLines[0]);
                String firstName = splitcurrentLines[1];
                String lastName = splitcurrentLines[2];

                map.put(id, new Writer(id, firstName, lastName));

            }
            fis.close();

            for (Map.Entry<Integer, Writer> m : map.entrySet()) {
                //  System.out.println("Key: " + m.getKey() + ", Writer: " + m.getValue());
            }
            return map;

        } catch (Exception e) {

        }

        return map;
    }

    @Override
    public void delete(Integer id) throws IOException {

        File writeToFile = new File("C://Users//ru156010005//Documents//crud//writers.txt");
        FileOutputStream fos = new FileOutputStream(writeToFile);
        PrintWriter pw = new PrintWriter(fos);
        map.remove(id);


        for (Map.Entry<Integer, Writer> m : map.entrySet()) {

            pw.println(m.getValue().getId() + ";" + m.getValue().getFirstName() + ";" + m.getValue().getLastName());

        }

        pw.flush();
        pw.close();
        fos.close();


    }
    @Override
    public Writer getId(Integer id) {

        return map.getOrDefault(id, null);
    }

    @Override
    public void update() throws IOException {

        File writeToFile = new File("C://Users//ru156010005//Documents//crud//writers.txt");
        FileOutputStream fos = new FileOutputStream(writeToFile);
        PrintWriter pw = new PrintWriter(fos);
        System.out.println("?????????????? ?????????? Writer ?????????????? ???????????? ????????????????");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc2 = new Scanner(System.in);
        Integer s = sc2.nextInt();
        System.out.println("?????????????? ?????????? Writer FirstName");
        String k = br2.readLine();
        System.out.println("?????????????? ?????????? Writer LastName");
        String l = br2.readLine();

        map.put(s, new Writer(s, k, l));

        for (Map.Entry<Integer, Writer> m : map.entrySet()) {
            pw.println(m.getValue().getId() + ";" + m.getValue().getFirstName() + ";" + m.getValue().getLastName());


        }

        pw.flush();
        pw.close();
        fos.close();

    }
}

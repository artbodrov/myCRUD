package crud.repo;

import crud.model.Label;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class IoLabelRepo implements LabelRepository {

    private Map<Integer, Label> map;


    public IoLabelRepo() {
        this.map = createMap();
    }

    private void write(Label label) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//ru156010005//Documents//crud//labels.txt", true))) {

            writer.write(label.getId() + ";" + label.getName() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int calculateid() throws IOException {
        String result = null;

        try (RandomAccessFile raf = new RandomAccessFile("C://Users//ru156010005//Documents//crud//labels.txt", "r")) {
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

    @Override
    public Label create(Label label) throws IOException {
        label.setId(calculateid());
        write(label);
        return label;


    }

    @Override
    public void read() throws IOException {
        try {

            FileReader tfr = new FileReader("C://Users//ru156010005//Documents//crud//labels.txt");

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


    private Map<Integer, Label> createMap() {

        try {
            File readToFile = new File("C://Users//ru156010005//Documents//crud//labels.txt");
            FileInputStream fis = new FileInputStream(readToFile);
            Scanner sc = new Scanner(fis);


            Map<Integer, Label> map = new HashMap<>();

            String currentLine;

            while (sc.hasNextLine()) {
                currentLine = sc.nextLine();
                String[] splitcurrentLines = currentLine.split(";");
                Integer id = Integer.valueOf(splitcurrentLines[0]);
                String name = splitcurrentLines[1];

                map.put(id, new Label(id, name));

            }

            fis.close();

            for (Map.Entry<Integer, Label> m : map.entrySet()) {
                // System.out.println("Key: " + m.getKey() + ", Label: " + m.getValue());

            }


            return map;
        } catch (Exception e) {

        }

        return map;

    }

    @Override
    public void delete(Integer id) throws IOException {

        File writeToFile = new File("C://Users//ru156010005//Documents//crud//labels.txt");
        FileOutputStream fos = new FileOutputStream(writeToFile);
        PrintWriter pw = new PrintWriter(fos);
        map.remove(id);


        for (Map.Entry<Integer, Label> m : map.entrySet()) {

            pw.println(m.getValue().getId() + ";" + m.getValue().getName());

        }

        pw.flush();
        pw.close();
        fos.close();


    }
    @Override
    public Label getId(Integer id){

        return map.getOrDefault(id,null);
    }

    @Override
    public void update() throws IOException {

        File writeToFile = new File("C://Users//ru156010005//Documents//crud//labels.txt");
        FileOutputStream fos = new FileOutputStream(writeToFile);
        PrintWriter pw = new PrintWriter(fos);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("?????????????? ?????????? Label");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String k = br2.readLine();
        map.put(s,new Label(s,k));

        for (Map.Entry<Integer, Label> m : map.entrySet()) {

            pw.println(m.getValue().getId() + ";" + m.getValue().getName());

        }

        pw.flush();
        pw.close();
        fos.close();

    }
}



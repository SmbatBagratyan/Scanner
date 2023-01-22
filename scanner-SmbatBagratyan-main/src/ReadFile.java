import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReadFile {

    public ReadFile () {
    }

    File file ;


    public ReadFile(File file1) {
         file = file1;
       // file = new File("C:/Users/smbba/OneDrive/Desktop/Compiler Design/homework-1/scanner-SmbatBagratyan/src/program.txt");
    }


    public String[] ReadSymbol() throws IOException {
        //File file = new File("C:/Users/smbba/OneDrive/Desktop/Compiler Design/homework-1/scanner-SmbatBagratyan/src/program.txt");
        char[] chars = new char[(int) file.length()];

        try (
                FileReader fr = new FileReader(file)) {
            fr.read(chars);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        String[] result = fixData(chars);

        return result;
    }

    private String[] fixData(char[] chars) {
        String str = new String(chars);
        String[] result = new String[(int) chars.length];
        int indexForResult = 0;


        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<' && str.charAt(i + 1) == '=') {
                result[indexForResult] = "<=";
                indexForResult++;
                i++;
                if (i >= str.length()) {
                    break;
                }
            } else if (str.charAt(i) == '>' && str.charAt(i + 1) == '=') {
                result[indexForResult] = ">=";
                indexForResult++;
                i++;
                if (i >= str.length()) {
                    break;
                }

            } else if (str.charAt(i) == ':' && str.charAt(i + 1) == '=') {
                result[indexForResult] = ":=";
                indexForResult++;
                i++;
                if (i >= str.length()) {
                    break;
                }
            } else {
                result[indexForResult] = Character.toString(str.charAt(i));
                indexForResult++;
            }
        }


        List<String> list = new ArrayList();
        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                list.add(result[i]);
            }
        }
        result = list.toArray(new String[0]);


        return result;
    }

//    public void cleanTheFile() throws IOException {
//        FileWriter fwOb = new FileWriter("C:/Users/smbba/OneDrive/Desktop/Compiler Design/homework-1/scanner-SmbatBagratyan/src/result.txt", false);
//        PrintWriter pwOb = new PrintWriter(fwOb, false);
//        pwOb.flush();
//        pwOb.close();
//        fwOb.close();
//    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Scanner {


    int lengthOfLex = 9;

    //File file = new File("C:/Users/smbba/OneDrive/Desktop/Compiler Design/homework-1/scanner-SmbatBagratyan/src/result.txt");
    File fileForOutput;
    //FileWriter fw = new FileWriter(file);
    //PrintWriter pw = new PrintWriter(fw);

    public ArrayList<String> lexems = new ArrayList(Arrays.asList(
            "or", "div", "mod", "char", "integer",
            "boolean", "false", "true", "not", "(", ")", "while", "repeat",
            "until", "do", "loop", "end", "if", "else", "elsif", "procedure",
            "const", "type", "var", "module", "import", "begin", "for"));
    public ArrayList<String> numbers = new ArrayList(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    public ArrayList<String> signs = new ArrayList(Arrays.asList("*", "+", "-", "=", "#", "<", "<=", ">", ">=", ":",
            ":=", ";", ":", ",", ".", "\""));
    public ArrayList<String> letters = new ArrayList(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b",
            "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

    public Scanner() throws IOException {
    }

    public Scanner(File file1) throws IOException {
        fileForOutput = file1;
    }

//    public void WriteInTheFile(String str) {
//        pw.println(str);
//        pw.close();
//    }

    public void getSymbol() throws IOException {

        ReadFile rd = new ReadFile(fileForOutput);
        //rd.cleanTheFile();

        String[] chars = rd.ReadSymbol();
        String result = "";


        boolean error = false;

       // BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));


        for (int i = 0; i <= chars.length - 1; i++) {
            if (!chars[i].isBlank() && !signs.contains(chars[i])) {
                result += chars[i];

                if (i == chars.length - 1) {
                    if (numbers.contains(Character.toString(result.charAt(0)))) {
                        for (int j = 0; j < result.length(); j++) {
                            if (letters.contains(Character.toString(result.charAt(j)))) {
                                error = true;
                            }
                        }
                        if (error) {
                          //  writer.write(result + ":" + " error, invalid lexem \n");
                            System.out.print(result + ":" + " error, invalid lexem \n");
                        } else {
                            //writer.write("number: " + result + '\n');
                            System.out.print("number: " + result + '\n');
                        }
                        error = false;
                        result = "";
                    } else if (letters.contains(Character.toString(result.charAt(0)))) {
                        if (lexems.contains(result)) {
                            //writer.write(result + "\n");
                            System.out.print(result + "\n");
                        } else {
                            //writer.write("identifier: " + result + "\n");
                            System.out.print("identifier: " + result + "\n");
                        }
                        result = "";
                    }
                }

            } else {
                if (signs.contains(chars[i]) && !chars[i].contains("\"")) {
                    if (result.length() == 0) {
                        //writer.write(chars[i] + "\n");
                        System.out.print(chars[i] + "\n");
                        result = "";
                    } else {
                        if (numbers.contains(Character.toString(result.charAt(0)))) {
                            for (int j = 0; j < result.length(); j++) {
                                if (letters.contains(Character.toString(result.charAt(j)))) {
                                    error = true;
                                }
                            }
                            if (error) {
                                //writer.write(result + ":" + " error, invalid lexem \n");
                                System.out.print(result + ":" + " error, invalid lexem \n");
                            } else {
                                //writer.write("number: " + result + '\n');
                                System.out.print("number: " + result + '\n');
                            }
                            //writer.write(chars[i] + "\n");
                            System.out.print(chars[i] + "\n");
                            error =false;
                            result = "";
                        } else if (letters.contains(Character.toString(result.charAt(0)))) {
                            if (lexems.contains(result)) {
                                //writer.write(result + "\n");
                                System.out.print(result + "\n");
                            } else {
                                //writer.write("identifier: " + result + "\n");
                                System.out.print("identifier: " + result + "\n");
                            }
                            //writer.write(chars[i] + "\n");
                            System.out.print(chars[i] + "\n");
                            result = "";
                        }
                    }

                } else if (chars[i].contains("\"")) {
                    int currentIndex = 0;
                    if (result.length() > 1) {
                        if (numbers.contains(Character.toString(result.charAt(0)))) {
                            for (int j = 0; j < result.length(); j++) {
                                if (letters.contains(Character.toString(result.charAt(j)))) {
                                    error = true;
                                }
                            }
                            if (error) {
                                //writer.write(result + ":" + " error, invalid lexem \n");
                                System.out.print(result + ":" + " error, invalid lexem \n");
                            } else {
                                //writer.write("number: " + result + "\n");
                                System.out.print("number: " + result + "\n");
                            }
                            error = false;
                            result = "";
                        } else if (letters.contains(Character.toString(result.charAt(0)))) {
                            if (lexems.contains(result)) {
                                //writer.write(result + "\n");
                                System.out.print(result + "\n");
                            } else {
                                //writer.write("identifier: " + result + "\n");
                                System.out.print("identifier: " + result + "\n");
                            }
                            result = "";
                        }
                        i = i - 1;
                    } else {
                        result += "\"";
                        currentIndex = i;
                        for (int j = i + 1; j < chars.length; j++) {
                            if (!chars[j].contains("\"")) {
                                result += chars[j];
                                currentIndex = j;
                            } else {
                                result += "\"";
                                currentIndex = j;
                                break;
                            }
                        }
                        if (result.endsWith("\"") && (result.length() > 1)) {
                            //writer.write("String: " + result + "\n");
                            System.out.print("String: " + result + "\n");
                        } else {
                            //writer.write("String error: " + result + "\n");
                            System.out.print("String error: " + result + "\n");
                        }
                        result = "";
                        i = currentIndex;
                    }

                } else {
                    if (chars[i].isBlank()) {
                        if (result.length() == 0) {
                            result = "";
                        } else {
                            if (numbers.contains(Character.toString(result.charAt(0)))) {
                                for (int j = 0; j < result.length(); j++) {
                                    if (letters.contains(Character.toString(result.charAt(j)))) {
                                        error = true;
                                    }
                                }
                                if (error) {
                                    //writer.write(result + ":" + " error, invalid lexem \n");
                                    System.out.print(result + ":" + " error, invalid lexem \n");
                                } else {
                                    //writer.write("number: " + result + "\n");
                                    System.out.print("number: " + result + "\n");
                                }
                                error= false;
                                result = "";
                            } else if (letters.contains(Character.toString(result.charAt(0)))) {
                                if (lexems.contains(result)) {
                                    //writer.write(result + "\n");
                                    System.out.print(result + "\n");
                                } else {
                                    //writer.write("identifier: " + result + "\n");
                                    System.out.print("identifier: " + result + "\n");
                                }
                                result = "";
                            }
                        }
                    }
                }
            }
        }
        //writer.close();
        //outputInConsole();
    }

    private void outputInConsole() throws IOException {

        InputStream input = new BufferedInputStream(new FileInputStream("C:/Users/smbba/OneDrive/Desktop/Compiler Design/homework-1/scanner-SmbatBagratyan/src/result.txt"));
        byte[] buffer = new byte[8192];

        try {
            for (int length = 0; (length = input.read(buffer)) != -1; ) {
                System.out.write(buffer, 0, length);
            }
        } finally {
            input.close();
        }
    }
}

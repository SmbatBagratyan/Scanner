import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        //ReadFile rd = new ReadFile();
        // rd.ReadSymbol();

        if(args.length > 0) {
            //ReadFile rd = new ReadFile(new File(args[0]));
            Scanner sc = new Scanner(new File(args[0]));
            sc.getSymbol();
        }


//        Scanner sc = new Scanner();
//        sc.getSymbol();
    }
}

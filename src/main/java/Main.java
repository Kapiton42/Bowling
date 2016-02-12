import java.io.IOException;
import  java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kapiton on 02.02.16.
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data;
        try {
            data = readFromBuffer(br);
        } catch (IOException e) {
            System.out.print("IOException");
            return;
        }
        System.out.print(Counter.calculateScore(data));
    }

    public static String[] readFromBuffer(BufferedReader br) throws IOException{
        String[] data = new String[10];

        for(int i = 0; i < 10; i++) {
                data[i] = br.readLine();
                if(i == 9)
                    if(!checkLastFrame(data[i]))
                        throw new IOException();
                 else
                    if(!checkFrame(data[i]))
                        throw new IOException();
        }
        return data;
    }

    static boolean checkFrame(String frame) {
        Pattern p = Pattern.compile("^\\d\\d$");
        Matcher m = p.matcher(frame);

        if(m.find())
            if(Character.getNumericValue(frame.charAt(0)) + Character.getNumericValue(frame.charAt(1)) < 10)
                return true;

        p = Pattern.compile("^(\\d\\/)|(x)$");
        m = p.matcher(frame);
        if(m.find())
            return true;
        return false;

    }
    static boolean checkLastFrame(String frame) {
        if(frame.length() < 3)
            return checkFrame(frame);

        Pattern p = Pattern.compile("^x\\d\\d$");
        Matcher m = p.matcher(frame);

        if(m.find())
            return checkFrame(frame.substring(1));

        p = Pattern.compile("^(xxx)|(xx\\d)|(x\\d/)|(\\d/\\d)$");
        m = p.matcher(frame);

        return m.find();

    }
}

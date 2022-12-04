
import java.io.*;
import java.util.*;

public class WriterFile {

    private PrintWriter outfile;

    public WriterFile(String file_name) {
        try {
        	// 파일 생성
            outfile = new PrintWriter(new FileWriter(file_name));
        }
        catch (Exception e) {
            System.out.println("PayrollWriter Error: " + file_name);
            throw new RuntimeException(e.toString());
        }
    }

    public void close() {
        outfile.close();
    }

    // 파일에 입력
    public void printCheck(String guest_name, String home_name, String guest_count, String home_count) {
        outfile.println(guest_name + "," + home_name + "," + guest_count + "," + home_count);
    }

    public void printCheck(String s) {
        outfile.println(s);
    }

}
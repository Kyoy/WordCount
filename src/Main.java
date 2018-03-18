import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by jinqi on 2018/3/18.
 */

//-c 字符数 -w 单词数 -l 行数 -o 输出文件 -s 所有文件 -a 复杂信息 -e 停用词表
//wc.exe -s -a –c -w *.c –e stop.txt –o output.txt
public class Main {


//    public static void main(String args[]){
//        WordCount wc = new WordCount("D:/idea-java/WordCount/src/res/ttt.txt");
//        System.out.print(args[0]);
//        if(args[0].equals("-c"))
//            System.out.print(wc.getWordNum());
//        else
//            System.out.print("null");
//    }
    public static void main(String args[]){
        boolean isC = false, isW = false, isL = false, isO = false, isS = false, isA = false, isE = false;
        String resourceFile = "", outputFile = "", stopFile = "";
        for(int i = 0; i < args.length; ++i){
            if(args[i].equals("-c"))
                isC = true;
            else if(args[i].equals("-w"))
                isW = true;
            else if(args[i].equals("-l"))
                isL = true;
            else if(args[i].equals("-o")){
                if(i < args.length - 1){
                    isO = true;
                    outputFile = args[++i];
                }
            }
            else if(args[i].equals("-s"))
                isS = true;
            else if(args[i].equals("-a"))
                isA = true;
            else if(args[i].equals("-e")){
                if(i < args.length - 1){
                    isE = true;
                    stopFile = args[++i];
                }
            }
            else
                resourceFile = args[i];
        }
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

//统计单词个数 奇葩规则：空格和，分开的均属于一个单词

/**
 * Created by jinqi on 2018/3/18.
 */
public class WordCount {
    private String resourceFile;
    private int line;
    private char[] buffer;
    private int wordNum;
    private int charNum;
    private int noteLine;
    private int emptyLine;
    private int codeLine;

    public char[] getBuffer(){
        return buffer;
    }

    public int getLine(){
        return line;
    }

    public String getResourceFile(){
        return resourceFile;
    }

    public int getWordNum(){
        return wordNum;
    }

    public int getCharNum(){
        return charNum;
    }

    public int getNoteLine(){return noteLine;}

    public int getEmptyLine(){return emptyLine;}

    public int getCodeLine(){return codeLine;}

    public WordCount(File file) {
        BufferedReader bf;
        this.resourceFile = resourceFile;
        try {
            bf = new BufferedReader(new FileReader(file));
            String temp1, temp2 = "";
            while((temp1 = bf.readLine()) != null) {
                temp2 += temp1 + String.valueOf('\n');
                line++;
                if(temp1.contains("//") || temp1.contains("/*") || temp1.contains("*/"))
                    noteLine++;
                else if(temp1.trim().length() != 0)
                    codeLine++;
                else
                    emptyLine++;
                for (String val: temp1.split(" |,")){
                    wordNum += val.equals("") ? 0 : 1;
//                    System.out.println(val.equals("") ? "[space]" : val);
                }
            }
            buffer = temp2.toCharArray();
            bf.close();
            charNum = buffer.length;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WordCount(File file, HashSet<String> stopList) {
        BufferedReader bf;
        this.resourceFile = resourceFile;
        try {
            bf = new BufferedReader(new FileReader(file));
            String temp1, temp2 = "";
            while((temp1 = bf.readLine()) != null) {
                temp2 += temp1 + String.valueOf('\n');
                line++;
                if(temp1.contains("//") || temp1.contains("/*") || temp1.contains("*/"))
                    noteLine++;
                else if(temp1.trim().length() != 0)
                    codeLine++;
                else
                    emptyLine++;
                for (String val: temp1.split(" |,")){
                    wordNum += val.equals("") || stopList.contains(val) ? 0 : 1;
//                    System.out.println(val.equals("") ? "[space]" : val);
                }
            }
            buffer = temp2.toCharArray();
            bf.close();
            charNum = buffer.length;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


//    public static void main(String args[]){
//        WordCount wc = new WordCount(new File("D:\\idea-java\\WordCount\\src\\res\\ttt.txt"));
//        System.out.println(wc.getWordNum() + " " + wc.getBuffer().length + " " + wc.getLine() + " " + System.getProperty("user.dir"));
//
//    }

}

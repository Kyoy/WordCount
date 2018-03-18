import java.io.*;

//    统计单词个数 奇葩规则：空格和，分开的均属于一个单词

/**
 * Created by jinqi on 2018/3/18.
 */
public class WordCount {
//    private StringBuilder sb = new StringBuilder();
    private int line;
    private char[] buffer;
    private String resourceFile;
    private int wordNum;

//    public String read(String filename) throws IOException{
//        BufferedReader in = new BufferedReader(new FileReader(filename));
//        String s;
//        while((s = in.readLine()) != null){
//            sb.append(s + "\n");
//        }
//        in.close();
//        return sb.toString();
//    }

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

    public WordCount(String resourceFile) {
        BufferedReader bf;
        File file = new File(resourceFile);
        this.resourceFile = resourceFile;
        try {
            bf = new BufferedReader(new FileReader(file));
            String temp1, temp2 = "";
            while((temp1 = bf.readLine()) != null) {
                temp2 += temp1 + String.valueOf('\n');
                line++;
                for (String val: temp1.split(" |,")){
                    wordNum += val.equals("") ? 0 : 1;
                    System.out.println(val.equals("") ? "[space]" : val);
                }
            }
            buffer = temp2.toCharArray();
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static void main(String args[]){
//        WordCount wc = new WordCount("D:/idea-java/WordCount/src/res/ttt.txt");
//        System.out.print(wc.getWordNum() + " " + wc.getBuffer().length);
//    }

}
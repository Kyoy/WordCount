import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by jinqi on 2018/3/18.
 */

//-c 字符数 -w 单词数 -l 行数 -o 输出文件 -s 所有文件 -a 复杂信息 -e 停用词表
//wc.exe -s -a –c -w *.c –e stop.txt –o output.txt
public class Main {
    public static ArrayList<File> getLegalFile(String Directory,String  pattern) //根据目录信息获得当前目录下所有与pattern相符的文件
    {
        String regex=pattern.replace("?","[0-9a-z]");
        regex=regex.replace("*","[0-9a-z]{0,}"); //正则匹配
        ArrayList<File> fileList=new ArrayList<>();
        File file=new File(Directory);
        if(file.isFile() && file.getName().matches(regex)) {   //是文件且匹配直接返回
            fileList.add(file);
            return fileList;
        }
        File[] files=file.listFiles();
        for(File f : files) {
            if(f.isFile()) {

                if(f.getName().matches(regex)) {    //是文件并且匹配则加入到文件数组中
                    fileList.add(f);
                }
            }
        }
        return  fileList;
    }

    public static HashSet<String> stopList(File stopFile){
        HashSet<String> stopList = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(stopFile));
            String temp;
            String Str = "";
            while((temp = reader.readLine())!=null) {
                Str += temp;
            }
            String[] words = Str.split(" ");
            for(String val:words)
                stopList.add(val);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return stopList;
    }

//    public static void main(String args[]){
//        WordCount wc = new WordCount("D:/idea-java/WordCount/src/res/ttt.txt");
////        System.out.print(args[0]);
////        if(args[0].equals("-c"))
////            System.out.print(wc.getWordNum());
////        else
////            System.out.print("null");
//        Scanner sc = new Scanner(System.in);
//        ArrayList<String> list = new ArrayList<>();
//        String str = sc.nextLine();
//        for(String val : str.split(" "))
//            list.add(val);
//        if(list.get(1).equals("-c"))
//            System.out.print(wc.getWordNum());
//        else
//            System.out.print("null");
//    }

    public static void main(String args[]){
        boolean isC = false, isW = false, isL = false, isO = false, isS = false, isA = false, isE = false;
        String resourceFileName = "", outputFileName, stopFileName;
        File stopFile, outputFile;
        String curPath=System.getProperty("user.dir");
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
                    outputFileName = args[++i];
                    outputFile = new File(outputFileName);
                    if(!outputFile.isFile()){
                        outputFile = new File(curPath + "/" + outputFileName);
                    }

                }
            }
            else if(args[i].equals("-s"))
                isS = true;
            else if(args[i].equals("-a"))
                isA = true;
            else if(args[i].equals("-e")){
                if(i < args.length - 1){
                    isE = true;
                    stopFileName = args[++i];
                    stopFile = new File(stopFileName);
                    if(!stopFile.isFile()){
                        stopFile = new File(curPath + "/" + stopFileName);
                    }
                }
            }
            else
                resourceFileName = args[i];
        }

    }
}

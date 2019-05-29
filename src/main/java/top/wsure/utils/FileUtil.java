package top.wsure.utils;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {

    public static ArrayList<File> getFiles(String path) {
        //目标集合fileList
        ArrayList<File> fileList = new ArrayList<File>();
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fileIndex : files) {
                //如果这个文件是目录，则进行递归搜索
                if (fileIndex.isDirectory()) {
                    getFiles(fileIndex.getPath());
                } else {
                    //如果文件是普通文件，则将文件句柄放入集合中
                    if(fileIndex.getName().matches("\\d+\\.txt"))
                        fileList.add(fileIndex);
                }
            }
        }
        return fileList;
    }

    public static String fileReader(File path)
    {
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String str = null;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
        } catch (Exception ex) {

        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        }
        String result = sb.toString();
        return result;
    }
}

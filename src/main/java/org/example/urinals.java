package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class urinals {

    public static void main(String[] args) throws IOException {
        //author: Sai Sunil Neralla
        System.out.println("Press 1 for Keyboard input and 2 for file input");
        Scanner sc= new Scanner(System.in);
        int x=Integer.parseInt(sc.nextLine());
        switch(x)
        {
            case 1: System.out.println("Enter String");
                     String a = sc.nextLine();
                     int b;
                     if(goodString(a)) {
                         b = countUrinals(a);
                         System.out.println(b);
                     }
                     break;
            case 2: String[] stringsArray = readFile();
                    int[] result = new int[stringsArray.length];
                      for(int j=0;j<stringsArray.length;j++)
                      {
                        if(goodString(stringsArray[j]))
                         result[j] = countUrinals(stringsArray[j]);

                        else result[j] = -1;
                      }
                      writeFile(result);
                      break;
        }

    }

    public static boolean goodString( String str ) {  // checks to see if valid string
        return str.matches("[0-1]+");
    }

    public static int countUrinals(String str) {
        int count=0;
        for(int i=0; i<str.length();i++)
        { char pos=str.charAt(i);
            if(str.contains("11"))
                return -1;
            if(i==0 || i==str.length()-1)
            {
                if(i==0 && pos=='0' && str.charAt(i+1)=='0')
                {
                    count++;
                    i++;
                }
                else if(i==str.length()-1 && pos=='0' && str.charAt(i-1)=='0')
                    count++;
            }
            else
            { char prev=str.charAt(i-1);
                char next=str.charAt(i+1);
                if(pos=='0' && prev=='0' && next=='0')
                {
                    count++;
                    i++;
                }

                else if(pos=='1')
                    i++;
            }
        }
        return count;
    }


    public static String[] readFile() throws IOException {
        String [] stringsArray = null;
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\snerall1\\Documents\\SER_515\\urinal.dat"))) {
            List<String> strings = new ArrayList<>();
            br.lines().forEach(c -> strings.add(c));
            stringsArray = strings.toArray(new String[strings.size()]);
        }
        return  stringsArray;
        }

    public static void writeFile(int[] result) throws IOException{
        String fileName = "rule";

        File file = new File(fileName+ ".txt");
        int count = 0;
        while(!file.createNewFile())
        {
            count++;
            file = new File(fileName+ String.valueOf(count) +".txt");
        }

        String content = "";

        for(int eachResult : result)
        {
            content+= String.valueOf(eachResult) + "\n";
        }

        FileWriter fw = new FileWriter(file);
        fw.write(content);
        fw.close();

    }
}
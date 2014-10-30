package Trangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SumTrangle {
	
	public static int[][] list=new int[1000][1000];
	public static void main(String[] args)  {
		 try {
		        File file = new File(args[0]);
		        BufferedReader in = new BufferedReader(new FileReader(file));
		        String line;
		        int i=0;
		       
		        while ((line = in.readLine()) != null) {
		        	
		     		ArrayInit(line,i);
		     	
		        	i++;
		        }
		        comput(list);
		    } catch (IOException e) {
		        System.out.println("File Read Error: " + e.getMessage());
		    }       

	}
	public static void ArrayInit(String str, int i){
		String[] s=str.split("\\s");
		for(int j=0;j<s.length;j++){
		 list[i][j]=Integer.parseInt(s[j]);	
		}
	
	}
	public static void comput(int[][] values){
		
		int depth = list.length - 2;
		

        while ( depth >= 0) {
            for (int j = 0; j < depth; j++) {
                values[depth][j] += Math.max( values[depth+1][j], values[depth+1][j+1]);
            }
            depth += -1;
        }

        values[0][0] += Math.max(values[1][0], values[1][1]);

            System.out.println("The maximum path sum is: " + values[0][0]);
	}

}

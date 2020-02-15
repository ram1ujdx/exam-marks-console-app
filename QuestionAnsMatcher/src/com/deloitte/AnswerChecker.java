package com.deloitte;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AnswerChecker 
{	
	public static void main(String[] args) throws Exception
	{
		Files.list(Paths.get("C:\\\\Users\\\\raman\\\\OneDrive\\\\Desktop\\\\Test3")).forEach(t -> {
			try {
				checkAnsSheet(t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}


public static void checkAnsSheet(Path path)throws Exception {
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	BufferedReader ans=new BufferedReader(new FileReader("C:\\Users\\raman\\OneDrive\\Desktop\\Test3\\ans.txt"));

	
	BufferedReader soln=new BufferedReader(new FileReader(path.toFile()));

	String line1 = ans.readLine();

	String line2 = soln.readLine();

	int error=0;
	int count=2;

	while(line1!=null || line2!=null) 
	{
		if(line1.equals(line2))
		{
			count=count+1;
		}
		else
		{
			error=error+1;
		}
		line1= ans.readLine();
		line2=soln.readLine();

	}
	String fileName=path.getFileName().toString();
	System.out.printf("Student : %-50s",fileName.substring(0,fileName.length()-4));
	System.out.printf("Obtained : %-5d ",count);
	System.out.printf("Errors : %-5d",error);
	System.out.println();

}
}
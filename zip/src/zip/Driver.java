package zip;

import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*String result=ZipClass.zipfile("Libraries/Documents/a","Libraries/Documents/abc.txt");*/
		String result=ZipClass.zipfile("bin",".project");
		System.out.println(result);
//"C:\Users\admin\Documents\a"
	}

}

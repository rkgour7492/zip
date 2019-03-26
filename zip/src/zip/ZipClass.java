package zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipClass {
public static String zipfile(String... folderspath) throws IOException{
	
		String path="zipped.zip";
		File output=new File(path);
	/*	output.mkdir();
		File file= new File(output,path);*/
		 FileOutputStream fos=new FileOutputStream(output);
	 ZipOutputStream zos=new ZipOutputStream(fos);
	 FileInputStream fis= null;
	 byte[] buffer = new byte[1024];
	List<String> filelist=new ArrayList<String>();
	for(String s:folderspath){
	File f=new File(s);
	if(f.isFile()){
		filelist.add(f.toString());
		ZipEntry ze = new ZipEntry(f.getName());
        zos.putNextEntry(ze);
        fis=new FileInputStream(f);
        int len;
        while ((len = fis .read(buffer)) > 0) {
            zos.write(buffer, 0, len);
	}
	}
        else if(f.isDirectory()){
		String[] subdir=f.list();
		for(String st:subdir){
			zipfile(st);
		}
	}
	}
	zos.close();
		return output.getAbsolutePath();
}
}

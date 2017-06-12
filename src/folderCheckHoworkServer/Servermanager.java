package folderCheckHoworkServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

import javax.imageio.stream.FileCacheImageOutputStream;

public class Servermanager {

	private File f;

	public Servermanager() {
		try {
			f = new File("/Users/07-22/Desktop/32±â _c¹Ý_±è±æ¼·");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String filePwd() {

		String flist = f.getAbsolutePath();

		return flist;
	}
	public File[] fileList() {

		File[] flist = f.listFiles();

		return flist;
	}
	public File fileCd(){
		File cd = new File(f.getParent());
		f= cd;
		return f;
	}
	public File filelist2(String name){
		File f1 = new File(f, name);
		f = f1;
		return f;
	}
	
	public boolean reMoveFile(String file){
		boolean result = false;
		File ff = new File(f, file);
		ff.delete();
		result = true;
		return result;
	}

}


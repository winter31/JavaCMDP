package folderCheckHoworkClient;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CManager {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Socket soc;

	public CManager() {
		try {
			soc = new Socket("127.0.0.1", 8987);

			oos = new ObjectOutputStream(soc.getOutputStream());
			ois = new ObjectInputStream(soc.getInputStream());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public File[] getLs() {
		File[] ff = null;
		Object[] oo = { "ls", null };
		ff = (File[]) Se1(oo);
		return ff;
	}

	public String getPwd() {
		String f = null;
		Object[] oo = { "pwd", null };
		f = (String) Se1(oo);
		return f;
	}

	public File fileCd() {
		File f = null;
		Object[] oo = { "cd", null };
		f = (File) Se1(oo);
		return f;
	}

	public File fileCd2(String name) {
		File f = null;
		Object[] oo = { "cd2", name };
		f = (File) Se1(oo);
		return f;
	}

	public boolean reMoveFile(String name) {
		boolean result = false;
		Object[] oo = { "rm", name };
		result = (boolean) Se1(oo);
		return result;
	}

	public Object Se1(Object[] ww) {
		Object a = null;
		try {
			oos.writeObject(ww);
			a = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;

	}
}

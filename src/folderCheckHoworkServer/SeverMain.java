package folderCheckHoworkServer;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverMain {
	private File[] listt;
	private ServerSocket ssoc;
	private Socket soc;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Servermanager ms;

	public SeverMain() {
		ms = new Servermanager();
		try {
			ssoc = new ServerSocket(8987);
			System.out.println("서버입니다.하하하");
			soc = ssoc.accept();
			System.out.println("써버 저어어어어어어어어어어업솝");
			oos = new ObjectOutputStream(soc.getOutputStream());
			ois = new ObjectInputStream(soc.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			try {

				Object[] oa = (Object[]) ois.readObject();
				String command = (String) oa[0];
				String name = (String) oa[1];
				switch (command) {
				case "ls":
					System.out.println("써버 현재파일 리스트");
					File[] f = ms.fileList();
					oos.writeObject(f);
					break;
				case "pwd":
					System.out.println("써버 현재폴더 위치");
					String f1 = ms.filePwd();
					oos.writeObject(f1);
					break;
				case "cd":
					System.out.println("써버 다른 폴더로 넘어가기");
					File f2 = ms.fileCd();
					oos.writeObject(f2);
					break;
				case "cd2":
					System.out.println("써버 하위 폴더로 넘어가기");
					File f3 = ms.filelist2(name);
					oos.writeObject(f3);
					break;

				case "rm":
					System.out.println("써버 파일 지우기");
					boolean result = ms.reMoveFile(name);
					oos.writeObject(result);
					break;
				}
			} catch (ClassNotFoundException | IOException e) {
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SeverMain();
	}

}

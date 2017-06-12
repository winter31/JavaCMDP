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
			System.out.println("�����Դϴ�.������");
			soc = ssoc.accept();
			System.out.println("��� ����������������");
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
					System.out.println("��� �������� ����Ʈ");
					File[] f = ms.fileList();
					oos.writeObject(f);
					break;
				case "pwd":
					System.out.println("��� �������� ��ġ");
					String f1 = ms.filePwd();
					oos.writeObject(f1);
					break;
				case "cd":
					System.out.println("��� �ٸ� ������ �Ѿ��");
					File f2 = ms.fileCd();
					oos.writeObject(f2);
					break;
				case "cd2":
					System.out.println("��� ���� ������ �Ѿ��");
					File f3 = ms.filelist2(name);
					oos.writeObject(f3);
					break;

				case "rm":
					System.out.println("��� ���� �����");
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

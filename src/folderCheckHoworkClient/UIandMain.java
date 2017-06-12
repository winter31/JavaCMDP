package folderCheckHoworkClient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class UIandMain {
	private Scanner sc = new Scanner(System.in);
	CManager c = new CManager();
	File mf;

	public UIandMain() {
		mf = new File("C:/Users/kita/Downloads");
		while (true) {
			Menu();
			int no = sc.nextInt();
			switch (no) {
			case 1:
				outter_loop: 
					while (true) {
					secondMenu1();
					String no1 = sc.next();
					String no3 = sc.nextLine();
					String no2 = no3.substring(1);

					switch (no1) {
					
					case "crt" :
						if(no2!=null){
							File newFile = new File(mf,no2);
							newFile.mkdirs();
						}else{
							System.out.println("명령어가 잘못됬습니다.");
						}
					break;
					case "ls":
						if (no2.equals("dir")) {
							File[] ff = mf.listFiles();
							System.out.println("..");
							for (File fff : ff) {
								System.out.println(fff.getName());
							}
						} else {
							System.out.println("명령어가 잘못됬습니다.");
						}
						break;
					case "pwd":
						if (no2.equals(".")) {
							System.out.println(mf.getAbsolutePath());
						}
						break;
					case "cd":
						if (no2.equals("..")) {
							if (!(mf.equals(null))) {
								System.out.println(mf.getParent());
								File f = new File(mf.getParent());
								
								mf = f;
								File[] ee = mf.listFiles();
								System.out.println("..");
								for (File e : ee) {
									System.out.println(e.getName());
								}
							} else {
								System.out.println("데이타가 없습니다.");
							}
						} else {
							File ff1 = new File(mf, no2);
							mf = ff1;
							System.out.println(ff1.getPath());
							File[] ff2 = mf.listFiles();
							System.out.println("..");
							for (File oo : ff2) {
								System.out.println(oo.getName());
							}
							if (mf == null) {
								System.out.println("데이타가 없습니다.");
							}
						}
						break;
					case "rm":
						if (no2.equals(no2)) {
							File ff1 = new File(mf, no2);
							boolean result11 = ff1.delete();
							if (result11 == true) {
								System.out.println("데이타 삭제 완료");
							} else {
								System.out.println("삭제 실패");
							}
						}
						break;
					case "return":
						if (no2.equals(no2)) {
							break outter_loop;
						}
					default:
						System.out.println("선택된 번호가 없습니다.");
						break;
					}
				}
				break;
			case 2:
				outter_loop: while (true) {
					secondMenu2();
					String no1 = sc.next();
					String no3 = sc.nextLine();
					String no2 = no3.substring(1);

					switch (no1) {
					case "crt" :
						if(no2!=null){
							File newFile = new File(mf,no2);
							newFile.mkdirs();
						}else{
							System.out.println("명령어가 잘못됬습니다.");
						}
					break;
					case "ls":
						if (no2.equals("dir")) {
							File[] ff = c.getLs();
							System.out.println("..");
							for (File fff : ff) {
								System.out.println(fff.getName());
							}
						} else {
							System.out.println("명령어가 잘못됬습니다.");
						}
						break;
					case "pwd":
						if (no2.equals(".")) {
							System.out.println(c.getPwd());
						}
						break;
					case "cd":
						if (no2.equals("..")) {
							File ff22 = c.fileCd();
							if (!(ff22.equals(null))) {
								System.out.println(ff22);
								File[] ee = ff22.listFiles();
								System.out.println("..");
								for (File e : ee) {
									System.out.println(e.getName());
								}
							} else {
								System.out.println("데이타가 없습니다.");
							}
						} else {
							File f123 = c.fileCd2(no2);
							File ff1 = new File(f123.getPath());
							f123 = ff1;
							System.out.println(f123.getPath());
							File[] ff2 = f123.listFiles();
							System.out.println("..");
							for (File oo : ff2) {
								System.out.println(oo.getName());
							}
							if (mf == null) {
								System.out.println("데이타가 없습니다.");
							}
						}
						break;
					case "rm":
						if (no2.equals(no2)) {
							boolean reulst = c.reMoveFile(no2);
							if (reulst == true) {
								System.out.println("데이타 삭제 완료");
							} else {
								System.out.println("삭제 실패");
							}
						}
						break;
					case "return":
						if (no2.equals(no2)) {
							break outter_loop;
						}
					default:
						System.out.println("선택된 번호가 없습니다.");
						break;
					}
				}
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("선택된 번호가 없습니다.");
				break;
			}
		}
	}

	public void Menu() {
		System.out.println("");
		System.out.println("파일 FTP");
		System.out.println("1. 내컴퓨터");
		System.out.println("2. 서버컴퓨터");
		System.out.println("3. 종료");
		System.out.print("번호를 선택해주십시오.");
		System.out.print("");
	}

	public void secondMenu1() {
		System.out.println("");
		System.out.println("내컴퓨터!!!!!!!");
		System.out.println("명령어 : ls dir-현재파일 리스트 , pwd .- 현재위치 , cd ../ 폴더 -폴더변경 , rm 지울 파일 -제거 , return goback -상위폴터 , 파일 만들기 crt 파일이름");
		System.out.print("명령어 ex) ls 위치정보 및 파일이름 : ");
		System.out.print("");
	}

	public void secondMenu2() {
		System.out.println("");
		System.out.println("써버컴퓨터!!!!!!!");
		System.out.println("명령어 : ls dir-현재파일 리스트 , pwd .- 현재위치 , cd ../ 폴더 -폴더변경 , rm 지울 파일 -제거 , return goback -상위폴터, 파일 만들기 crt 파일이름");
		System.out.print("명령어 ex) ls 위치정보 및 파일이름 : ");
		System.out.print("");

	}

	public static void main(String[] args) {
		new UIandMain();
	}
}

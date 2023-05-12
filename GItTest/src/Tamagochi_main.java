import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tamagochi_main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;
		Tamagochi_controll tc = new Tamagochi_controll();
		TamagochiDAO tdao = new TamagochiDAO();
		int hungry = tc.status().getHungry();
		int hp = tc.status().getHp();
		int love = tc.status().getLove();
		int exp = 0;
		int score = 0;
		int level = tc.status().getLevel();
		UserDTO login = null;
		TamagochiDTO record = null;
		String id = null;
		
		System.out.println("\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣀⢲⣦⣤⣀⣀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠿⡿⢿⣟⣿⣷⣦⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⢲⣿⣿⣿⠏⣤⡬⣥⣥⣾⣿⣿⣿⣿⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣇⡼⣿⡇⡃⠀⣽⣿⣿⣿⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⡀⠀⠀⠘⠉⠙⢷⢃⣡⠴⠀⠈⣨⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠇⠒⠠⠁⠀⠄⠀⠀⠀⡀⠀⠙⢈⡠⢊⣥⡀⠀⠀⠀⠀⠀⠀⣠⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠈⠀⠐⠠⡽⣸⣿⡶⠚⠚⢿⣿⣷⣦⠀⠀⣼⣿⣿⣿⣿⣿⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠅⠀⠀⠈⠛⢟⠍⠓⣾⣿⣿⡿⢿⣿⣿⣿⣿⣇⡀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠺⣷⣤⡄⢀⣾⣷⠙⢻⠟⡉⠀⢰⠉⢻⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⡀⠰⠀⡀⠀⠀⠀⠀⠀⡠⠤⠀⠤⡀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣋⣭⣭⣥⣭⣛⠀⠀⠀⠃⠀⠘⠀⠐⢿⠛⠁⠀⠀⠀⠀⠀⡄⠀⠀\r\n"
				+ "⠀⠀⡃⣀⠆⢉⡆⠀⠀⢠⠮⠄⠠⠄⡀⠀⣧⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣀⠀⠀⢪⢩⣄⠀⠀⠂⠀⠀⠀⠀⠀⢀⣼⣶⣶⣶\r\n"
				+ "⠀⠀⠀⠀⠀⠘⠃⠀⣠⡢⣶⣦⡀⡂⠀⢀⣿⡇⠀⠀⠀⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣇⡴⠛⣹⡐⠾⠀⠀⠀⠀⠀⠀⠀⠀⣾⢟⣝⡮⣶\r\n"
				+ "⠀⠀⠀⠀⠀⠒⠈⢩⠟⢠⡍⠀⠁⠀⠘⢠⣹⡇⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠐⢸⠑⢐⠇⠀⠀⠀⠀⠀⠀⠀⢀⢱⣿⠟⢳⡿\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠛⢀⢸⠄⠺⠃⠀⡴⠸⡛⠁⠀⠀⠀⠈⠘⣿⣿⣿⣿⠛⢻⣿⣿⣧⠈⣶⠃⢸⠚⠀⠀⠀⠀⢀⡠⠠⠀⠑⣽⣦⣾⣃\r\n"
				+ "⠀⠀⡤⠻⠀⠀⠀⠀⠉⠸⡈⠁⠇⠀⠰⢸⠐⠀⠀⠀⠀⠆⢸⠈⠉⠋⠀⠂⠈⢿⡍⠁⢐⣿⠀⠨⣔⠒⠀⠀⣰⣿⣿⣇⡂⢠⣿⣿⣿⣿\r\n"
				+ "⣈⣢⡀⠀⠀⣀⠀⠄⠂⠊⡐⣠⠎⠄⠀⠸⠀⠀⠄⢀⠀⠈⠉⠀⠄⠀⣀⣀⠄⡀⠓⣄⣾⣿⣠⡞⠰⢒⠀⠀⡉⠉⠳⠬⢧⣿⠝⢿⣿⣿\r\n"
				+ "⠛⣟⡰⠄⠂⠁⢀⠀⠚⠀⠉⠉⠐⠐⠀⠀⠆⣀⣤⡄⠘⠀⠀⠀⠀⠀⠀⠀⣎⣱⡄⠹⢿⣿⣿⣷⡀⠘⠽⡦⠃⠀⠀⠀⠀⠰⣾⣿⡿⠿\r\n"
				+ "⠀⠀⠀⠀⡀⠀⠁⠀⠀⠈⠀⠠⠄⠸⢴⣶⡇⢹⣟⣡⣁⠙⠾⣶⣶⣶⣤⣀⡙⠚⠀⠑⣸⣿⠿⢿⡇⠀⠠⠀⠀⠀⠀⠀⠀⠀⡿⠋⢵⣿\r\n"
				+ "⠀⠀⠀⠈⠐⡀⠀⠀⠀⠀⠀⢀⣠⣴⣾⠟⠛⠞⠟⠞⠏⡟⠂⠐⠊⠉⠉⠁⠀⠀⡀⠀⠛⠉⠦⠀⢄⠐⡈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠾⠋\r\n"
				+ "⢀⡄⠁⠀⠀⠈⠀⠀⠈⠁⣰⣿⣿⣿⣤⣄⡀⠀⢀⣀⠀⠓⡦⢄⣀⡀⠀⠀⢄⡠⢃⡀⠀⢈⣦⣶⣤⣗⣫⠤⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀\r\n"
				+ "⠒⡱⡤⠔⢀⠰⡢⠲⠇⣀⣿⣿⣛⡛⣿⣿⡆⠰⣧⠹⠀⠀⢁⠞⠟⠧⡄⢀⣶⠄⠘⠻⣿⣿⣿⣿⠿⠋⠀⣀⠀⢀⠀⠠⡀⠀⠀⠈⠙⣟\r\n"
				+ "⠈⠀⠋⠀⠂⢉⣤⣾⣿⣿⣿⡛⠛⠒⠿⠷⢦⣤⣯⣥⣄⣀⣠⣂⣪⣠⣀⣁⣠⣬⣥⣤⠿⠿⠽⠓⠖⠛⣿⡿⠁⠉⠈⠀⢹⢁⠀⢴⣾⣿\r\n"
				+ "⠀⠀⠀⠀⠀⢻⠏⠀⠘⠅⢿⣧⠀⠀⢤⣄⣀⣶⣐⠀⢇⣈⡉⠉⠉⣉⣁⠁⢰⠀⠀⠤⠤⠤⠶⠖⣀⣾⠟⠀⠀⠀⠀⠀⢸⠙⠿⡏⣿⠋\r\n"
				+ "⠀⠀⣎⠀⢀⠰⠀⠀⡘⠀⠸⠻⣧⠀⠘⣿⣿⣿⣿⡀⠸⣿⡇⠀⠈⣿⣿⠀⢠⡤⠤⠄⠀⠀⠀⢚⣿⣿⢄⢀⢤⡀⠀⠀⢈⠆⠀⠀⠀⢸\r\n"
				+ "⠀⢀⢇⠀⠀⠀⠀⢠⢥⣀⣒⣀⣻⣧⣀⠉⠉⠙⠛⢣⠀⠏⠀⣰⡀⠈⡇⠀⡔⠂⣶⠾⠿⠿⢻⣿⣿⣱⣷⣯⣾⣿⡄⠀⠸⠀⠀⠀⠀⣘\r\n"
				+ "⠀⠀⠀⢂⡠⠑⠛⢻⣿⠃⠉⠹⢿⣿⡿⠷⡶⠦⠤⣼⣤⣶⣾⣿⣿⣦⣧⣴⣷⣤⣤⢤⣶⣶⠿⢻⣿⢿⠋⠀⣼⣿⣷⠀⣰⣶⣾⣴⡡⡝\r\n"
				+ "⠀⠔⠀⢘⠇⢀⣴⢼⣿⡃⢠⣶⡌⢻⣧⠀⢷⠀⢠⣤⣤⣄⣉⣈⠀⣛⣛⠃⠸⠀⠃⣘⣉⡁⢀⣠⣮⡅⠀⣼⡿⢱⡛⣷⣿⣿⣿⣿⣿⣯\r\n"
				+ "⡀⠔⠕⠸⢆⡈⢿⣿⣻⣧⠀⢿⣿⡌⢧⣄⠘⡄⠘⠿⠿⠿⠿⢿⣆⣉⣉⣠⣿⣸⣦⣿⡿⠁⢸⣿⡁⠀⣼⣿⠃⠀⣡⢿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⠀⠸⠛⠀⠀⠀⠀⠉⢘⣿⣧⡘⢿⡇⢸⣿⣀⣿⠓⠒⠒⠒⠒⢺⣇⠛⠛⠛⠛⠛⢻⢏⣤⣿⠀⡿⠁⣼⣿⠷⡾⠛⢿⡜⣿⣿⣿⣿⣿⣦\r\n"
				+ "⠀⠀⠄⠀⠀⠀⠀⠀⠉⣻⣻⣷⣶⣤⣿⣿⣷⡿⠶⠿⠿⠿⠿⠟⠛⠛⠿⠿⠿⠶⢾⣿⣿⣿⣾⣧⣾⣿⣟⠁⠀⠀⣠⡅⣿⣿⣿⣿⣿⣏\r\n"
				+ "⢶⡆⠀⠀⠀⠀⠀⠀⠀⠈⠹⢋⡿⢿⣿⠋⠌⢑⡂⠰⠀⠀⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠛⠻⠿⣿⡧⢨⣀⢠⣺⡟⣽⣿⣿⣟⣿⣟⣿\r\n"
				+ "⠀⠀⠀⠘⠈⠀⠀⠀⠀⠀⠀⢀⡈⢀⣉⠀⠀⠀⠅⠀⠀⠀⢀⣀⠐⠙⠈⠉⠉⢀⠒⠀⠀⢠⢼⣳⣟⣵⣟⣿⣿⣿⣿⣿⡁⢀⣯⣿⣿⣿\r\n"
				+ "⡀⠀⠀⡀⠀⠀⠁⠂⠒⠀⠀⠒⠒⢨⢡⡤⢶⣤⣼⠀⡄⢀⠄⠀⠀⠀⠀⠔⠈⠁⠀⠀⠀⠈⢛⠉⠟⣿⣿⣿⣿⣿⡿⣿⣿⡿⣿⠟⣫⣽\r\n"
				+ "⡀⠈⣠⠈⠀⠀⢀⠀⠀⠀⠀⠀⠀⢀⣤⣄⡀⠉⢻⣠⠔⠏⠂⠀⠀⠀⠃⠀⠀⠀⠀⠀⠀⠀⠀⢀⠂⡿⠛⠭⢋⡩⠿⠿⣧⡳⣏⡠⢟⣿");
		
		while (login == null) {
			System.out.println("[1] 회 원 가 입 / [2] 로 그 인");
			int select = sc.nextInt();

			if (select == 1) {
				int row = 0;
				int row2 = 0;
				System.out.println("===================회원가입======================");
				System.out.print("ID 입력 : ");
				id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();
				System.out.print("NICKNAME 입력 : ");
				String nickname = sc.next();

				UserDTO udto = new UserDTO(id, pw, nickname);
				row = tdao.join(udto);
				if (row > 0) {
					System.out.println("회원가입 성공");
					record = new TamagochiDTO(id, exp, level, hungry, love, hp, score);
					row2 = tdao.startRecord(record);
					
				} else {
					System.out.println("회원가입 실패");

				}

			} else if (select == 2) {
				System.out.println("===================로그인======================");

				System.out.print("ID 입력 : ");
				String l_id = sc.next();
				System.out.print("PW 입력 : ");
				String l_pw = sc.next();
				login = tdao.login(l_id, l_pw);

				if (login != null) {
					record = tdao.selectOne(l_id);
					tc.status().setExp(record.getExp());
					tc.status().setHp(record.getHp());
					tc.status().setHungry(record.getHungry());
					tc.status().setLevel(record.getLevel());
					tc.status().setLove(record.getLove());
					tc.status().setScore(record.getScore());
					
					
					
					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 실패");
				}
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		//record = tdao.recallData(login.getId());
		//tc = 
		while (tc.status().getLevel() < 13)

		{
			boolean a = false;
			String name = tc.revolution(tc.status().getLevel());

			if (name.equals("아구몬")) {
				System.out.println("===================아구몬 등장!!!!!==========================");
				System.out.println("===================아구몬 등장!!!!!==========================");
				System.out.println("===================아구몬 등장!!!!!==========================");
				System.out.println("===================아구몬 등장!!!!!==========================");
				System.out.println("\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣠⣄⠐⢈⠁⠐⠒⠤⠤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠄⠐⠈⠉⠀⠂⠶⣦⡃⠀⠀⠀⠀⠀⠈⠉⠙⡛⠒⠀⠀⠀⠐⠒⠈⠑⠢⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠎⠀⠀⠀⠀⠀⠀⠘⠀⠀⠛⣧⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡈⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⡟⠀⠀⣠⣶⣦⣤⣍⠄⠀⠀⠀⠀⠚⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⢹⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⡔⠉⠀⠀⠀⡀⢿⠟⠀⠀⢻⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠣⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣷⡀⠀⠀⠀⢰⣿⡀⠀⠀⣼⣿⡇⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠈⠦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣸⣿⠀⠀⠀⠸⣿⣷⣤⣴⣿⣿⣿⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠜⠲⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⢀⣿⡟⠀⠀⠀⠰⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠇⠙⠖⢄⡀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⢸⣿⠃⠀⠀⠀⠀⠻⣿⣿⠉⢹⣿⠿⠄⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠉⢳⣄⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⢠⣽⣿⡿⠟⠋⠘⠀⡃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠒⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠀⠀⠀⠀⢸⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⡁⢂⣀⡀⠀⠄⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⠋⠁⠀⠀⠀⠀⠀⠀⠀⠂⠀⠀⠀⠀⣴⣿⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠈⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⢐⣠⣴⠶⠇⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⢰⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⢸⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⢹⣿⡄⠀⠀⠀⠀⠀⠈⠾⠋⠁⠈⡷⣌⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢀⡸⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠈⢿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⡏⢱⡄⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢥⠇⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣴⡄⠀⠀⠀⠀⠀⠀⠀⠀⠻⠋⠙⢧⣄⡄⠄⠶⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⢌⠊⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⢻⢁⡶⣤⣄⡤⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠄⢀⣀⣀⡤⠴⠊⠁⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠿⣿⣄⢀⣀⢀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠄⠉⠀⠸⠻⣿⣷⣤⣄⡀⠀⠀⣀⡠⢽⣤⣾⣿⣿⡟⣿⠢⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⠀⢬⢻⣧⣤⣀⣚⡉⠀⠀⠀⠀⠠⠀⠀⠀⠀⠀⠀⠀⠀⠜⢿⣿⣿⣿⣿⣿⣿⣄⣼⣿⣿⣿⣿⣥⠆⡐⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡇⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣶⣶⣦⣤⣀⠀⠀⠀⠀⠀⠀⠀⠈⠈⠙⠻⣿⢏⣨⣿⣿⠿⠿⠛⠉⠀⡖⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⢀⠜⠑⠀⠀⠀⠀⢈⣜⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠁⠉⠀⢀⠠⠁⢈⠔⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⣠⠄⢀⡀⢀⠆⠀⠀⠀⠀⠀⠀⠈⠀⠉⠛⠛⠿⠿⠿⢿⣿⣿⣿⣿⣿⠿⠿⠛⠻⠷⢶⣬⣤⣅⣀⣙⣀⡠⠤⠓⠀⠁⠀⠀⠀⠀⠁⠀⠀⠀⠄⠰⠀⠀⠀\r\n"
						+ "⠀⠀⣿⡆⠀⢨⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠀⠀⠀⠀⠠⠆⠀⠈⠰⠆⠀⠀⠀⣷⠨⠈⠆⠀⠀⠀⠀⠀⠀⠀⠂⠄⡀⠀⢰⠀⠀⠀⠀⠖⡄⠀⠀\r\n"
						+ "⠀⢰⣿⣷⠀⣼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠝⢄⠀⠀⠀⡆⠀⠀⠄⠀⠀⣠⣿⡄⠀⠀⢀⡄⢸⠀⠀\r\n"
						+ "⠀⢸⣿⣿⣇⡟⠀⠀⠀⠀⠀⠀⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣤⣤⢿⣿⣧⠀⠀⠈⢣⣀⡀⡇⠀⠀⠀⠐⢎⣾⣿⣿⢒⠒⠉⢬⢸⠀⠀\r\n"
						+ "⠀⣸⣿⣿⡿⠁⠀⠀⠀⠀⠀⣀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⠊⠑⠀⠀⠀⢿⣿⣧⡰⠄⠐⠁⠉⣧⠀⠀⠀⠀⠀⡏⢿⣿⡆⠘⠂⠀⡟⠀⠀\r\n"
						+ "⠀⢿⣿⣿⠃⠀⠀⠀⠀⠀⠀⣸⣿⣷⣦⣄⣀⣀⣠⣴⣶⣿⢟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⢻⣿⣿⣄⠀⠀⠀⣿⡆⠀⠀⣠⠜⠔⠈⣿⣧⠀⠀⠀⡇⠀⠀\r\n"
						+ "⠀⢸⣿⠃⠀⠀⠀⠀⠀⠀⢱⣿⣿⣿⣿⣿⣿⣿⡿⠟⢉⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡟⣿⣿⣶⣤⣶⣿⣿⡏⠭⠈⠀⠹⠀⠀⠉⢀⠀⡸⠁⠀⠀\r\n" + "");

			} else if (name.equals("그레이몬")) {
				System.out.println("===================그레이몬 등장!!!!!==========================");
				System.out.println("===================그레이몬 등장!!!!!==========================");
				System.out.println("===================그레이몬 등장!!!!!==========================");
				System.out.println("===================그레이몬 등장!!!!!==========================");
				System.out.println("\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠹⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⢳⣕⢄⠀⠀⠀⠀⠀⠀⠠⠐⠒⠢⢤⣐⣊⣉⣉⠉⠑⢠⡤⠤⠤⡀⠀⠀⠀⠀⠀⣼⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⢿⣶⣯⣥⡲⣤⠄⢴⣥⣴⣦⣤⡀⠙⢿⣿⣿⣷⣶⣤⡻⣶⣦⡈⢆⢀⡀⠤⣶⣽⢿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⠿⣿⣷⣾⣿⣿⡟⡽⠙⢦⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣾⣽⣿⣿⠿⡻⣾⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⢿⣿⣿⣿⠰⢠⡀⠈⣷⣾⣿⣿⣿⣿⡿⠟⠋⠉⠻⣿⠋⠁⢠⢱⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⢆⢼⣿⣿⣿⣆⣸⣿⢡⠛⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠈⢢⡴⣡⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡸⣡⣾⣿⣿⣿⣿⣦⣾⣥⣾⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⡴⢊⣼⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣄⣠⣶⣾⣶⣶⣶⣷⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⣤⣀⠀⠀⠀⠀⠀⢰⠀⡞⢀⣼⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠹⣆⠉⠢⡀⠀⠀⠈⣦⣑⡛⠛⠋⡆⠐⠚⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⢻⡇⠀⠙⡀⠀⠀⢨⠉⠉⠢⡀⠘⠢⡉⠀⢘⠁⠀⣹⠿⠿⠛⠻⣿⣿⣿⡿⠿⠛⠳⢲⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣿⣤⣤⣼⡀⠀⠀⠐⠂⠠⢤⣑⠤⢈⠑⢻⣶⠤⣿⡀⠀⣶⡀⠠⠤⠤⠬⠤⠤⠄⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣿⠉⠁⠀⢱⠀⠀⠀⠀⠀⠀⢸⢷⣌⢂⠈⠻⣷⣽⣿⣦⣿⣷⠦⠖⠒⠒⠒⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⢀⣿⡀⠀⠀⢸⠀⠀⠀⠀⡔⠉⠁⡀⠉⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⢀⣄⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⢀⣾⡇⠀⠀⠀⢸⠀⠀⠀⡘⠀⠀⠀⣼⣶⣶⣤⣤⣄⠀⠀⠀⠀⣴⠾⠛⠛⢆⠈⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⣾⣿⠶⠿⠿⠿⡇⠀⠀⡐⠁⠀⠀⣴⣿⣄⠀⠀⠀⠀⣀⣤⣤⣈⠀⠀⢀⣀⣼⠀⠰⡀⠀⠀⠀⠀⠀⠀⠀⣠⣶⡌⠑⡄⠀\r\n"
						+ "⠀⠀⠀⠀⢠⣿⠃⠀⠀⠀⠀⣣⠀⡀⡴⠊⠉⠛⢯⠈⠻⢶⣶⣶⠾⠋⠀⠙⠿⠷⠾⠯⠟⣻⣄⠀⠣⠀⠒⠒⠒⠒⢲⢢⠛⡿⣿⣀⡇⠀\r\n"
						+ "⠀⠀⠀⠀⣾⣿⡶⠀⢀⣴⣾⠏⠑⡞⠀⣀⡎⠉⢻⠧⣀⡀⠀⠀⣀⠀⠀⠀⠀⠀⢀⣀⠈⠀⠹⣷⣤⣀⠀⠀⠀⣔⢴⠇⢀⣹⣯⣠⠇⠠\r\n"
						+ "⠀⠀⠀⠀⢸⣿⡇⣠⣿⠟⠁⡠⠔⠃⠈⡙⠓⢄⣸⣀⠀⣻⣷⠿⠃⠀⠀⠀⠀⠀⠀⠙⠻⣶⣾⢿⡛⠿⠟⠿⠿⢾⠓⠁⠀⢿⢿⣷⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⣿⣿⣿⠃⠀⢀⡆⠀⡠⠒⢜⣄⣠⣈⡿⣄⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⢆⡀⢀⡼⠍⠘⢊⠟\r\n"
						+ "⠀⠀⠀⠀⠀⠘⣿⣿⣄⣠⡏⠙⡦⣧⡀⠀⠻⠿⠿⢧⣀⠎⢡⠀⠀⠀⠀⠀⠀⠀⠀⢤⣤⣀⠀⠀⡁⠀⠀⠀⠀⠀⠀⠀⠉⠒⠚⠈⠁⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠈⠛⢿⣿⣷⣄⡑⣤⣭⠿⠿⠿⠿⢤⣡⣴⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⢉⣿⣿⣿⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⠿⠿⡏⢀⣠⣴⣶⣶⣾⣿⣻⣿⣶⣶⣶⣶⣶⣶⣶⣶⣾⣿⣿⣿⡿⣰⣷⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⡛⠋⠉⠉⠀⠈⢹⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣿⣾⠿⠛⠁⠘⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢡⣎⡀⠀⠀⣤⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣿⣿⣶⣶⣶⣿⣿⣶⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⠀⠀⠈⠉⠙⠛⠛⠉⠁⠀⢰⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⠏⣉⡒⠒⠒⡄⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣻⣷⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡿⠿⠿⠿⠋⣁⣀⣈⡉⠉⡮⢀⠀⠈⢀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡅⠉⠉⠛⠛⠛⠛⠛⠋⠉⠀⢣⠀⠀⠀⠀⠀⠀⢿⣿⣿⣤⣀⣀⣀⡀⠀⠉⠉⡟⠉⠀⠀⠀⢀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡅⠀⠀⠀⡇⠀⠀⠘⡄⢀⠠⠤⠵⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠛⠛⠿⢿⣶⣊⣀⡀⠀⣀⡨⠀⠀⠀⠀\r\n" + "");

			} else if (name.equals("메탈그레이몬")) {
				System.out.println("===================메탈그레이몬 등장!!!!!==========================");
				System.out.println("===================메탈그레이몬 등장!!!!!==========================");
				System.out.println("===================메탈그레이몬 등장!!!!!==========================");
				System.out.println("===================메탈그레이몬 등장!!!!!==========================");
				System.out.println("===================메탈그레이몬 등장!!!!!==========================");

				System.out.println("\r\n" + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⣠⣾⣿⣿⣿⣿⣿\r\n"
						+ "⣿⡿⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠁⠀⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣿⣿⡏⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠋⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⡇⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠂⠹⠟⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⢀⠄⠀⢀⣀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⡇⠀⠀⡿⠻⠉⠉⠉⠉⢉⣍⣉⠉⠉⠙⠛⠄⢈⣠⡔⢫⣾⡿⠟⣻⣿⣿⣿⣿⠋⣠⠞⠁⠀⠠⠛⣃⣼⣿⣿⣿⡿⠿⠟⠛⢛⣹⣿⣿\r\n"
						+ "⣿⡿⠈⠁⠀⠀⠈⠄⠀⠀⢟⠩⢘⡗⠀⣈⣸⣴⠿⣯⡪⠫⣡⡾⠼⣻⣿⡿⠟⣥⡾⣡⡆⠀⢀⣤⠾⢛⣋⠉⢉⠀⠀⢀⣀⣴⣿⣿⣿⣿\r\n"
						+ "⣿⡇⠀⠀⠀⠀⠀⠀⣀⡀⠀⠠⡀⠀⢸⠛⠻⣷⠄⣼⡵⣯⡦⠈⣠⣽⣟⣀⣾⡟⠹⣛⣤⡶⠿⠛⢋⡉⠀⠐⠛⠀⢚⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⡀⢀⣰⡩⡮⡾⣧⣿⣼⣷⣿⡦⢟⠠⠴⣿⠁⠈⠓⣄⠀⠈⠃⠀⠀⠀⠉⠻⣿⣿⠭⠐⣠⣾⣿⠃⢀⣠⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣷⣶⣷⣿⣿⣿⣯⢿⡟⠏⡅⢀⠀⠀⠈⣆⠀⠐⢌⡆⠀⠀⠀⠀⠇⠀⠀⠘⣿⣿⣗⠊⢉⠶⠮⠛⠛⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⠿⣟⠿⠙⠁⠢⠘⠁⠀⣢⠦⠞⠈⠔⢄⡀⠙⠀⠀⠀⠀⠈⠤⠴⢉⣿⣿⣿⣿⣷⣀⡙⠻⠟⡂⠀⠀⢀⣙⡛⠿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣅⡀⠀⠀⠀⣐⣲⣬⣯⣮⣀⠀⡀⠀⢈⠀⠀⠀⢀⠀⠀⢀⣀⠄⠹⣿⣜⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⡄⠀⠛⠁⢀⠀⠀⠈⠈⠾⣭⢶⡔⠔⠙⠛⠂⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣀⢤⠀⢐⠀⠀⠐⠀⠀⠀⢀⡀⠉⠁⠀⠀⠈⠻⡽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠎⢳⠣⡀⣼⣧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠻⢿⣿⡿⠯⠐⠒⠉⠪⠐⠐⠀⠀⠈⡙⡆⠀⠀⢈⣽⣤⡽⠟⠉⠝⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣁⣥⠔⠂⠁⠀⠀⠀⠀⠀⠀⠐⠄⠀⠑⠀⢰⢀⣤⣴⢟⠿⢙⣄⠀⢸⡇⢀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠂⠀⣀⠄⠀⢠⠀⠀⠀⠀⠀⣦⠀⠑⢿⡟⣛⡥⠔⠁⠀⠀⠙⠧⠁⣇⡌⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⡿⠋⠄⠀⠀⠀⠁⠀⠀⡸⠄⠀⣤⠾⣟⣻⡤⢴⡚⠋⠹⠀⠀⠀⠂⠄⠶⠄⢠⠣⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⡿⠋⠀⠁⠀⡀⠁⠀⣠⠔⠈⠀⠀⠀⠈⠉⠐⢶⣶⣾⣿⣶⡆⠀⠀⠀⠀⠀⠀⢀⢎⡀⠀⢀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⡟⢁⠀⣀⣴⡞⢀⣴⣾⣷⣀⣁⠀⠀⠀⠀⠀⠀⠀⠉⠛⢛⡛⢳⠀⠀⠀⠀⠀⠀⠉⠀⠙⠖⠀⠀⠀⢢⠈⢸⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣶⣿⣾⣿⣿⣷⣿⣿⣿⣿⣿⣿⣶⣀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠠⣀⠀⠀⠈⢒⠀⠀⠀⠀⢈⢄⠀⠐⢓⣆⢾⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣶⣶⣶⣄⢀⡠⠀⠀⠛⣶⣶⣶⣾⡆⠀⠀⠀⠀⠈⠊⠅⢳⡽⢞⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢧⠀⠀⠀⠀⣿⣿⣿⣿⣿⣶⣦⡀⡀⢆⡄⠈⣿⢇⣸⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠉⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠠⠀⠀⠀⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⡆⠀⢿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⢀⠀⠀⡆⠀⠀⠹⣿⣿⣿⣿⡟⠀⡆⠀⠘⠀⠀⢰⡀⢸⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⡀⠀⠀⢱⡄⠂⠐⢻⣿⣿⣿⠃⢀⠀⠀⢸⠀⠀⠘⣧⢸⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣖⠛⠂⠀⠊⣿⣦⡀⢸⣿⣿⡏⠀⠸⠀⠀⢸⡄⠀⠀⢸⡝⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⣆⠀⣿⣿⣿⣿⣿⣿⣷⠀⠀⡆⠀⢈⡿⠀⠀⠛⠁⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⢰⣅⠀⠀⣦⠀⠀⡇⢹⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣼⣿⣶⣄⣿⣧⠀⠀⠸⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⢿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⢸⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿\r\n" + "");
			} else if (name.equals("워그레이몬")) {
				System.out.println("===================워그레이몬 등장!!!!!==========================");
				System.out.println("===================워그레이몬 등장!!!!!==========================");
				System.out.println("===================워그레이몬 등장!!!!!==========================");
				System.out.println("===================워그레이몬 등장!!!!!==========================");
				System.out.println("\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡆⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢻⠀⠀⠀⠀⢰⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢳⢸⡇⠀⣿⠀⠀⠀⠀⠀⠀⢸⠞⡆⠀⠀⠀⡞⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣿⣧⣄⢪⠸⣾⣷⣤⡿⡤⠪⠁⠲⠴⣎⢿⣠⠗⠀⠀⢠⠃⣇⡴⠻⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⡾⢻⡙⠻⡇⠃⠀⠐⣀⠀⣿⣿⣴⠇⠀⢀⣷⣄⡟⢀⡀⠈⠙⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣠⣼⣿⣿⣿⣿⣿⣿⣿⡇⠀⠹⣦⣧⠀⢠⡞⡟⢀⣿⣿⣿⣿⣤⠏⠙⣿⣿⣿⣿⣷⣦⣀⠉⠳⢤⡀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠚⢻⠂⠈⢑⣴⡇⣿⠿⠽⠿⡏⠀⢠⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠉⠓⠤⢤⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⢰⣿⣿⠷⢾⡿⠏⠘⣯⣶⠄⠀⡁⠤⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⢸⡄⠀⠀\r\n"
						+ "⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⡟⠋⠹⣿⢟⣒⣻⠿⠟⢺⣦⡾⠀⣾⣿⣿⠇⠀⠀⠉⠉⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠸⡀⠀⠀\r\n"
						+ "⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⡯⠕⠒⠛⠋⣿⢟⢿⣿⣖⣂⣯⣭⣉⢠⢙⣿⣿⣤⣤⣀⡤⠄⣿⡁⠀⠙⢻⣿⣿⣿⣿⣿⣿⣿⠀⠀⡇⠀⠀\r\n"
						+ "⠀⠀⠀⣾⣿⣿⡿⢛⡵⠋⠀⠀⠀⣀⣰⡗⣤⠼⣿⣧⣁⣿⣿⡀⢁⣭⣿⣿⣿⣌⢻⢶⡿⠃⠉⠳⣄⠀⠈⠻⣿⣿⣿⣿⣿⡆⠀⢇⠀⠀\r\n"
						+ "⠀⠀⣼⣿⡟⠋⡠⠊⠂⠀⠀⢶⣍⣵⣿⣿⡇⠀⢸⣿⣏⠿⠏⠉⣾⣿⣿⡿⠛⠉⠓⣿⠇⠀⠀⠀⠈⠙⢄⠀⠀⠛⣿⣿⣿⣿⠀⢸⠀⠀\r\n"
						+ "⠀⠐⠛⠋⣠⠊⠀⠀⢠⡾⢶⣿⣿⡟⠛⠛⠁⢀⣿⣿⣿⣤⣴⣼⣿⠿⠟⢇⣤⡀⠀⣏⠀⠀⡤⡀⠀⡀⠘⡄⠀⠀⠀⠙⢿⣿⡀⠘⡄⠀\r\n"
						+ "⠀⠀⠀⡴⠁⢀⣀⣰⡿⠗⡟⣿⡇⠀⠀⣠⣴⣾⣿⣯⡹⠍⠹⢋⣿⡃⠀⠂⠀⠹⣄⠘⡆⠀⠃⠈⠂⡆⢰⢺⠀⠀⠀⠀⠀⠹⡇⠀⢳⠀\r\n"
						+ "⠀⠀⠀⢹⠋⢀⣼⣿⣿⣾⣾⠛⠁⢀⣼⣿⣿⡿⠿⣿⣏⣀⣈⣼⠛⠻⣦⡀⠀⠀⢿⣆⢸⡄⢠⠀⠀⠁⠀⠀⠳⡀⠀⠀⠀⠀⠘⠲⣼⠀\r\n"
						+ "⠀⠀⠀⣇⣴⣿⣿⣿⣿⡟⠋⠀⢠⣾⣿⣿⠇⠀⠀⢿⡿⠿⢿⡟⠀⣠⢬⣿⣦⡄⠘⢿⣯⣿⣜⠀⠀⠘⡂⢐⣅⡱⡄⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⢸⣿⣿⣿⣿⣿⡟⠀⠀⣠⣿⡿⢿⣿⣶⣀⣀⣼⡇⠀⢸⠙⣿⠃⠀⠀⠉⠹⠦⣜⢿⣧⡘⣦⠀⠈⠀⠀⠀⣿⠁⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⣿⣿⢿⣿⣿⣿⠁⠀⠀⠛⠛⡇⠀⠉⠙⠻⢿⡃⢇⠀⠸⠀⢸⠀⠀⠀⠀⠀⢀⣦⠓⠛⠀⢸⣷⣠⣆⢠⡆⣤⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⣿⡇⣿⡟⣿⡏⠀⠀⠀⠀⠘⡇⠀⠀⢀⠄⣰⣿⣜⠒⠃⠀⠈⢳⢀⠀⠂⠀⣼⡏⡇⠀⠀⠈⢿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠛⠀⣿⠃⠻⠀⠀⠀⠀⠀⠀⢻⠄⢀⣡⣶⠋⢡⣿⠀⠀⠀⠀⠀⢹⡾⣦⣴⣿⡇⡇⠀⠀⠀⢸⣿⢼⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠞⢻⣿⣿⠀⢸⣿⠀⠀⠀⠀⠀⠀⠘⣼⣿⣿⣇⡇⠀⠀⠀⠀⠛⢸⣿⠻⠃⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⠒⢾⠟⠋⢀⡜⡟⠀⠀⠀⠀⠀⠀⢠⢻⡟⠉⠛⠏⡇⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⣶⣿⠿⢷⣀⢀⡾⠋⠉⠀⣷⠀⠀⠀⠀⠀⠀⢘⢆⣠⣤⡤⣤⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠺⣿⡿⡇⣠⣠⣯⡵⠒⠒⠒⠚⠋⠀⠀⠀⠀⠀⠀⣸⠛⠙⢟⠋⠉⢻⠀⠌⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠋⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⡀⠂⣸⣀⡀⣰⣤⡈⡜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠁⠀⠛⠃⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + "");
			}

			switch (tc.situation()) {
			case 1:
				System.out.println("적이 나타났다");
				a = !a;
				break;
			case 2:
				System.out.println("놀아줘");
				break;
			case 3:
				System.out.println("배고파");
				break;
			}

			System.out.printf("===============[%s]================\n", name);
			System.out.printf("레벨 : %d\n", tc.status().getLevel());
			System.out.printf("포만도 : %d / %d\n", tc.status().getHungry(), hungry);
			System.out.printf("애정도 : %d \n", tc.status().getLove());
			System.out.printf("경험치 : %d / %d\n", tc.status().getExp(), 100);
			System.out.printf("체력 : %d / %d\n", tc.status().getHp(), hp);
			score = tc.getScore();
			System.out.println("[1] 놀아주기 [2] 밥주기 [3] 전투 [4] 휴식 [5] 종료");
			num = sc.nextInt();

			if (num == 1) {
				if (a) {
					tc.battle(a);
					System.out.println("전투에서 도망쳤습니다.");
					System.out.println("체력이 10 내려갑니다.");
					System.out.println("애정도가 10 내려갑니다.");
					System.out.println();
				} else {

					System.out.printf("포만감이 %d 줄었습니다\n", 5);
					System.out.printf("애정도가 %d 상승했습니다\n", 20);
					System.out.printf("경험치가 %d 상승했습니다\n", 20);

					System.out.println();
				}
				tc.play();
				if (tc.die()) {

					System.out.println("디지몬이 죽었습니다.");
					System.out.println("GAME OVER");
					break;
				}

			} else if (num == 2) {
				if (a) {
					tc.battle(a);
					System.out.println("전투에서 도망쳤습니다.");
					System.out.println("체력이 10 내려갑니다.");
					System.out.println("애정도가 10 내려갑니다.");
					System.out.println();
				} else {

					if (tc.feed() > 0) {
						System.out.println("배가 불러서 더 이상 먹을 수 없습니다");
						System.out.println("애정도가 5 내려갑니다");
						System.out.println();
					} else {
						System.out.println("애정도가 3 올라갑니다");
						System.out.println("포만감이 10 올라갑니다");
						System.out.println();
					}

					boolean result = tc.die();
					if (result) {
						System.out.println("디지몬이 죽었습니다.");
						System.out.println("GAME OVER");
						break;
					}
				}
				boolean result = tc.die();
				if (result) {
					System.out.println("디지몬이 죽었습니다.");
					System.out.println("GAME OVER");
					break;
				}
			} else if (num == 3) {
				// 전투
				if (tc.battle(a) > 0) {
					System.out.println("승리했습니다.");
					System.out.println("경험치가 50 올라갑니다.");
					System.out.println("애정도가 30 올라갑니다.");
					tc.levelUp();
					tc.revolution(tc.status().getLevel());
					System.out.println();

				} else {
					System.out.println("졌습니다.");
					System.out.println("체력이 20 내려갑니다.");
					System.out.println("애정도가 10 내려갑니다.");
					System.out.println();
				}
				boolean result = tc.die();
				if (result) {
					System.out.println("디지몬이 죽었습니다.");
					System.out.println("GAME OVER");
					break;
				}

			} else if (num == 4) {
				// 휴식
				if (a) {
					tc.battle(a);
					System.out.println("전투에서 도망쳤습니다.");
					System.out.println("체력이 10 내려갑니다.");
					System.out.println("애정도가 10 내려갑니다.");
					System.out.println();
				} else {
					tc.rest();
					System.out.println("Z Z Z Z...");
					System.out.println("디지몬의 체력이 15 회복되었습니다.");
					System.out.println();
				}
			} else if (num == 5) {
				int temp = tdao.updateData(tc.status().getExp(), tc.status().getLevel(), tc.status().getHungry(),
						tc.status().getLove(), tc.status().getHp(), score, login.getId());
				if (temp > 0) {
					System.out.println("데이터 저장 성공");
					System.out.println("게임을 종료합니다.");
					break;
				} 
			} else {
				System.out.println("지정된 번호만 입력하세요!");
				System.out.println();
			}

			tc.levelUp();
			tc.revolution(tc.status().getLevel());

			boolean result = tc.die();
			if (result) {
				System.out.println("디지몬이 죽었습니다.");
				System.out.println("GAME OVER");
				break;
			}

		}
		int temp = tdao.updateData(tc.status().getExp(), tc.status().getLevel(), tc.status().getHungry(),
				tc.status().getLove(), tc.status().getHp(), score, login.getId());
		if (temp > 0) {
			System.out.println("데이터 저장 성공");
			System.out.println("게임을 종료합니다.");
		}
		
		System.out.println("===============RANKING=================");
		System.out.println("USER\tSCORE\n");
		ArrayList<TamagochiDTO> tarr = tdao.finalScore();
		for(int i = 0;i<tarr.size();i++) {
		System.out.printf("%s\t%d\n",tarr.get(i).getId(), tarr.get(i).getScore());
		}
	}

}

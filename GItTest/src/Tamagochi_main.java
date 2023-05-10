import java.util.Scanner;

public class Tamagochi_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		Tamagochi_controll tc = new Tamagochi_controll();
		int hungry = tc.status().getHungry();
		int hp = tc.status().getHp();
		int love = tc.status().getLove();
		int exp = tc.status().getExp();

		while (true) {
			System.out.println("===============[코로몬]================");
			System.out.printf("포만도 : %d / %d\n", tc.status().getHungry(),hungry);
			System.out.printf("애정도 : %d / %d\n", tc.status().getLove(),love);
			System.out.printf("경험치 : %d / %d\n", tc.status().getExp(), exp);
			System.out.println("[1] 놀아주기 [2] 밥주기 [3] 전투 [4] 휴식 [5] 종료");
			num = sc.nextInt();
			if (num == 1) {
				tc.play();
				if(tc.status().getHungry()==0||tc.status().getLove()==0) {
					System.out.println("디지몬이 죽었습니다.");
					System.out.println("GAME OVER");
					break;
				}
				System.out.printf("포만감이 %d 줄었습니다\n",5);
				System.out.printf("애정도가 %d 상승했습니다\n",5);

			} else if (num == 2) {
				
				
				if(tc.feed()>0) {
					System.out.println("배가 불러서 더 이상 먹을 수 없습니다");
					System.out.println("애정도가 5 내려갑니다");
				}else {
					System.out.println("디지몬이 기뻐합니다");
					System.out.println("애정도가 3 올라갑니다");
					System.out.println("포만감이 10 올라갑니다");
				}
				
				boolean result = tc.die();
				if(result) {
					System.out.println("디지몬이 죽었습니다.");
					System.out.println("GAME OVER");
					break;
				}

			} else if (num == 3) {

			} else if (num == 4) {

			} else if (num == 5) {
				System.out.println("게임을 종료합니다.");
				break;
			}

		}

	}

}

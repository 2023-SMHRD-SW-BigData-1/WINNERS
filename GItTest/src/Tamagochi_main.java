import java.util.Random;
import java.util.Scanner;

public class Tamagochi_main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num;
		Tamagochi_controll tc = new Tamagochi_controll();
		int hungry = tc.status().getHungry();
		int hp = tc.status().getHp();
		int love = tc.status().getLove();
		int exp = 100;
		
		while (true) {
			boolean a = false;
			tc.levelUp();
			String name = tc.revolution(tc.status().getLevel());
			switch(tc.situation()) {
			case 1:
				System.out.println("적이나타났다!!");
				a=!a;
				break;
			case 2:
				System.out.println("심심해 놀아줘!");
				break;
			case 3:
				System.out.println("배고파 밥줘!");
				break;
			}
			
			System.out.printf("===============[%s]================\n",name);
			System.out.printf("레벨 : %d\n",tc.status().getLevel());
			System.out.printf("포만도 : %d / %d\n", tc.status().getHungry(),hungry);
			System.out.printf("애정도 : %d \n", tc.status().getLove());
			System.out.printf("경험치 : %d / %d\n", tc.status().getExp(), exp);
			System.out.printf("체력 : %d / %d\n", tc.status().getHp(), hp);
			System.out.println("[1] 놀아주기 [2] 밥주기 [3] 전투 [4] 휴식 [5] 종료");
			num = sc.nextInt();
			if (num == 1) {
				if(a) {
					tc.battle(a);
					System.out.println("전투에서 도망쳤습니다.");
					System.out.println("체력이 10 내려갑니다.");
					System.out.println("애정도가 10 내려갑니다.");
					System.out.println();
				}else {
					
				tc.play();
				if(tc.status().getHungry()==0||tc.status().getLove()==0) {
					System.out.println("디지몬이 죽었습니다.");
					System.out.println("GAME OVER");
					break;
				}
				System.out.printf("포만감이 %d 줄었습니다\n",5);
				System.out.printf("애정도가 %d 상승했습니다\n",5);
				System.out.printf("경험치가 %d 상승했습니다\n",5);
				tc.levelUp();
				tc.revolution(tc.status().getLevel());
				System.out.println();
				}

			} else if (num == 2) {
				if(a) {
					tc.battle(a);
					System.out.println("전투에서 도망쳤습니다.");
					System.out.println("체력이 10 내려갑니다.");
					System.out.println("애정도가 10 내려갑니다.");
					System.out.println();
				}else {
				
				if(tc.feed()>0) {
					System.out.println("배가 불러서 더 이상 먹을 수 없습니다");
					System.out.println("애정도가 5 내려갑니다");
					System.out.println();
				}else {
					System.out.println("애정도가 3 올라갑니다");
					System.out.println("포만감이 10 올라갑니다");
					System.out.println();
				}
				
				boolean result = tc.die();
				if(result) {
					System.out.println("디지몬이 죽었습니다.");
					System.out.println("GAME OVER");
					break;
				}
				}
			} else if (num == 3) {
				//전투
				if(tc.battle(a)>0) {
					System.out.println("승리했습니다.");
					System.out.println("경험치가 10 올라갑니다.");
					System.out.println("애정도가 10 올라갑니다.");
					tc.levelUp();
					tc.revolution(tc.status().getExp());
					System.out.println();
					
				}else {
					System.out.println("졌습니다.");
					System.out.println("체력이 10 내려갑니다.");
					System.out.println("애정도가 10 내려갑니다.");
					System.out.println();
				}
				
			} else if (num == 4) {
				//휴식
				if(a) {
					tc.battle(a);
					System.out.println("전투에서 도망쳤습니다.");
					System.out.println("체력이 10 내려갑니다.");
					System.out.println("애정도가 10 내려갑니다.");
					System.out.println();
				}else {
				tc.rest();
				System.out.println("Z Z Z Z...");
				System.out.println("디지몬의 체력이 10 회복되었습니다.");
				System.out.println();
				}
			} else if (num == 5) {
				System.out.println("게임을 종료합니다.");
				break;
			}else {
				System.out.println("지정된 번호만 입력하세요!");
				System.out.println();
			}

		}

	}

}

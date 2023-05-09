

import java.util.Scanner;

public class one {

	public static void main(String[] args) {

		int hunger = 50;
		int happiness = 50;
		int energy = 50;

		Scanner scanner = new Scanner(System.in);
		boolean play = true;
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("=======================Welcome to Tamagotchi Game!=============================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");

		while (play) {
			System.out.println("현재상태: ");
			System.out.println("배고픔: " + hunger);
			System.out.println("행복도: " + happiness);
			System.out.println("에너지: " + energy);
			System.out.println("뭘 하고싶나요?");
			
			System.out.println("1. 윤지 먹이주깅");
			System.out.println("2. 윤지 놀아주깅");
			System.out.println("3. 윤지 재우기");
			System.out.println("4. 나가기");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				feed();
				break;
			case 2:
				play();
				break;
			case 3:
				sleep();
				break;
			case 4:
				play = false;
				break;
			default:
				System.out.println("Invalid choice!");
			}

			if (hunger <= 0 || happiness <= 0 || energy <= 0) {
				System.out.println("Your Tamagotchi has died. Game over.");
				play = false;
			}
		}

		System.out.println("Thanks for playing Tamagotchi Game!");
	}

	private static void feed() {
		System.out.println("Feeding Tamagotchi...");
		int hunger = 10;
		int happiness = 5;
		int energy = 5;
	}

	private static void play() {
		System.out.println("Playing with Tamagotchi...");
		int hunger = 5;
		int happiness = 10;
		int energy = 10;
	}

	private static void sleep() {
		System.out.println("Making Tamagotchi sleep...");
		int hunger = 5;
		int happiness = 5;
		int energy = 10;
	}

}
import java.util.ArrayList;
import java.util.Random;

public class Tamagochi_controll {
	Random ran = new Random();
	TamagochiDTO tama = new TamagochiDTO(100, 100, 100, 0, 0, 1, "", "");

	public int situation() {
		int percent = ran.nextInt(10) + 1;
		int situ = 0;
		if (percent > 5) {
			situ = 1;
		} else if (percent > 3) {
			situ = 2;
		} else if (percent > 0) {
			if(tama.getHungry()>=80)
			tama.setHungry(tama.getHungry()-20);
			situ = 3;
		}
		return situ;
	}

	public TamagochiDTO status() {

		return tama;
	}

	public void play() {
		tama.setHungry(tama.getHungry() - 5);
		tama.setLove(tama.getLove() + 5);
		tama.setExp(tama.getExp()+5);
	}

	public int feed() {
		int count = 0;
		if (tama.getHungry() <= 90) {
			tama.setHungry(tama.getHungry() + 10);
			tama.setLove(tama.getLove() + 3);
		} else {
			tama.setHungry(100);
			tama.setLove(tama.getLove() - 5);
			count = 1;
		}
		return count;
	}

	public int battle(boolean a) {
		int count = 0;
		if (ran.nextInt(100) + 1 < 10) {
			tama.setHp(tama.getHp() - 10);
			tama.setLove(tama.getLove() - 10);
		} else if (ran.nextInt(100) + 1 >= 10) {
			count++;
			tama.setExp(tama.getExp() + 100);
			tama.setLove(tama.getLove() + 10);
		} else if (a) {
			tama.setHp(tama.getHp() - 10);
			tama.setLove(tama.getLove() - 10);
		}
		return count;
	}

	public void rest() {
		tama.setHp(tama.getHp()+5);

	}

	public boolean die() {
		boolean result = false;
		if (tama.getHungry() == 0 || tama.getLove() == 0)
			result = true;

		return result;
	}
	
	public void levelUp() {
		if(tama.getExp()==100) {
			tama.setLevel(tama.getLevel()+1);
			tama.setExp(0);
		}
		
	}
	
	public String revolution(int level) {
		level = tama.getLevel();
		String name = "아구몬";
		switch(level) {
		case 4:
			name ="그레이몬";
			break;
		case 7:
			name ="메탈그레이몬";
			break;
		case 10:
			name ="워그레이몬";
			break;
		
		}
		return name;
	}
}

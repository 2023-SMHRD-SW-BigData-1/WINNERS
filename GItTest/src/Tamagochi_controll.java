import java.util.ArrayList;
import java.util.Random;

public class Tamagochi_controll {
	Random ran = new Random();
	TamagochiDTO tama = new TamagochiDTO("", 0, 1, 100, 50, 100, 0);
	MusicController mc = new MusicController();
	
	public int situation() {
		int percent = ran.nextInt(10) + 1;
		int situ = 0;
		if (percent > 6) {
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
		tama.setLove(tama.getLove() + 20);
		tama.setExp(tama.getExp()+20);
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
		int num = ran.nextInt(100) + 1 +tama.getLevel()+tama.getLove()/100;
		int count = 0;
		if (num < 30) {
			tama.setHp(tama.getHp() - 20);
			tama.setLove(tama.getLove() - 10);
		} else if (num >= 30) {
			count++;
			tama.setExp(tama.getExp() + 50);
			tama.setLove(tama.getLove() + 30);
		} else if (a) {
			tama.setHp(tama.getHp() - 10);
			tama.setLove(tama.getLove() - 10);
		}
		return count;
	}

	public void rest() {
		tama.setHp(tama.getHp()+15);

	}

	public boolean die() {
		boolean result = false;
		if (tama.getHungry() <= 0 || tama.getLove() <= 0 ||tama.getHp()<=0) {
			
			result = true;
		}

		return result;
	}
	
	public void levelUp() {
		if(tama.getExp()>=100) {
			tama.setLevel(tama.getLevel()+1);
			tama.setExp(tama.getExp()-100);
		}
		
	}
	
	public String revolution(int level) {
		level = tama.getLevel();
		String name = "아구몬";
		switch(level) {
		case 4:
		case 5:
		case 6:
			name ="그레이몬";
			break;
		case 7:
		case 8:
		case 9:
			name ="메탈그레이몬";
			break;
		case 10:
		case 11:
		case 12:
		case 13:
			name ="워그레이몬";
			break;
		
		}
		return name;
	}
	
	public int getScore() {
		
		int score = 0;
		
		score = tama.getLevel()+tama.getLove();
		
		return score;
		
		
		
	}
	
	public void revolutionMusic(int level) {
		if(level ==4||level ==7||level ==10) {
			mc.stop();
			mc.play(1);
		}
	}
	
	public void openingMusic() {
		
			mc.stop();
			mc.play(0);
		
	}
}

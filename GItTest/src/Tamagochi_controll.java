import java.util.ArrayList;

public class Tamagochi_controll {
	TamagochiDTO tama = new TamagochiDTO(100, 50, 100, 0, 0,"","");
	
	public TamagochiDTO status() {
		
		return tama;
	}
	
	public void play () {
		tama.setHungry(tama.getHungry()-5);
		tama.setLove(tama.getLove()+5);
	}
	
	public int feed () {
		int count = 0;
		if(tama.getHungry()<=90) {
		tama.setHungry(tama.getHungry()+10);
		tama.setLove(tama.getLove()+3);
		}else {
			tama.setHungry(100);
			tama.setLove(tama.getLove()-5);
			count =1;
		}
		return count;
	}
	
	public boolean die() {
		boolean result =false;
		if(tama.getHungry()==0||tama.getLove()==0)
			result = true;
		
		return result;
	}
}

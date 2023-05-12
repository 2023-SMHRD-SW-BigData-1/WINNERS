
public class TamagochiDTO {

	private String id;
	private int exp;
	private int level;
	private int hungry;
	private int love;
	private int hp;
	private int score;

	

	public TamagochiDTO(String id, int exp, int level, int hungry, int love, int hp, int score) {
		super();
		this.id = id;
		this.exp = exp;
		this.level = level;
		this.hungry = hungry;
		this.love = love;
		this.hp = hp;
		this.score = score;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getExp() {
		return exp;
	}



	public void setExp(int exp) {
		this.exp = exp;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public int getHungry() {
		return hungry;
	}



	public void setHungry(int hungry) {
		this.hungry = hungry;
	}



	public int getLove() {
		return love;
	}



	public void setLove(int love) {
		this.love = love;
	}



	public int getHp() {
		return hp;
	}



	public void setHp(int hp) {
		this.hp = hp;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}

	

}

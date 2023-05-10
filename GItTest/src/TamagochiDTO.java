
public class TamagochiDTO {

	private int hungry;
	private int hp;
	private int love;
	private int exp;
	private int score;
	private String id;
	private String pw;
	
	
	public TamagochiDTO(int hungry, int hp, int love, int exp, int score, String id, String pw) {
		super();
		this.hungry = hungry;
		this.hp = hp;
		this.love = love;
		this.exp = exp;
		this.score = score;
		this.id = id;
		this.pw = pw;
	}


	public int getHungry() {
		return hungry;
	}


	public void setHungry(int hungry) {
		this.hungry = hungry;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getLove() {
		return love;
	}


	public void setLove(int love) {
		this.love = love;
	}


	
	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	

	
	
	
}

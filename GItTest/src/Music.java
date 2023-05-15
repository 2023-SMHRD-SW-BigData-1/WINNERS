

public class Music {
	//Model --> 데이터 관리
	
	//뮤직플레이어 안에서 사용할 우리만의 음악 자료형
	
	//1. 노래데이터 경로(위치값)
	private String path;
	
	//2. 가수 이름
	private String singer;
	
	//3. 노래 제목
	private String title;
	
	//--메소드--
	//모든 필드값을 채울 수 있는 생성자 메소드
	
	public Music(String path, String singer, String title) {
		super();
		this.path=path;
		this.singer=singer;
		this.title=title;
		
	}

	public String getPath() {
		return path;
	}

	public String getSinger() {
		return singer;
	}

	public String getTitle() {
		return title;
	}
	
	
	
}

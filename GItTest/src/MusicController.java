

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class MusicController {
	// Controller -->기능들을 가지고 있는 도구
	// 노래 재생기능!

	// 1. 필드 값 지정
	private MP3Player mp3 = new MP3Player();
	private ArrayList<Music> m = new ArrayList<>();
	private int start = 0;// 몇번째 곡인지 의미하는 변수
	// 2.노래 데이터 추가 기본 생성자(매개변수 없음)를 통해

	public MusicController() {
		// 기본생성자의 로직
		// 뮤직 플레이 리스트를 추가하는 작업
		String path = "C:\\Users\\smhrd\\Desktop\\workspace\\GitTest2\\player\\";

		m.add(new Music(path + "longbutterfly.mp3", "???", "butterfly"));
		m.add(new Music(path + "braveheart.mp3", "???", "butterfly"));
		

		
	}
	// 3.재생하는 메소드

	public Music play(int num) {

		if (mp3.isPlaying() == true) {
			mp3.stop();
		}
		mp3.play(m.get(num).getPath());
		return m.get(num);
	}
	
	// 4.정지하는 메소드
	public boolean stop() {
		boolean result = false;
		if (mp3.isPlaying()) {
			mp3.stop();
			result = true;
		}
		return result;
		
	}
	
	// 5.이전곡
	public Music back() {
		
		start--;
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		if (start < 0) {
			start = m.size() -1;
			mp3.play(m.get(start).getPath());
			return m.get(start);
		}else {
			mp3.play(m.get(start).getPath());
			return m.get(start);
		}
	}
	
	
	// 6.다음곡
	public Music next() {
		
		start++;
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		// 3. 다음곡을 재생
		if (start >= m.size()) {
			start = 0;
//		}
//		if(start <m.size()) {
			
		mp3.play(m.get(start).getPath());
		
//		}else {
//			
//			start = m.size()-1;
//			return null;
//			
		}
		return m.get(start);
		
		
	}

}

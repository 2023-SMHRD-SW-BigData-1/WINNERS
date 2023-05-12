import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TamagochiDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	int row = 0;
	ResultSet rs = null;

	// DB연결 메소드
	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String db_id = "DIZIMON";
			String db_pw = "123123";

			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//------------------------------------------getConn메소드 끝-----------------------------
	// DB연결 종료 메소드
	public void getClose() {

		try {// --->예외 처리
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

//--------------------------------------------------------------------------------------	
	// 회원가입 메소드
	// 이 메소드를 만들기 위해서 어떤 데이터가 필요한지 매개변수로 받아줌
	public int join(UserDTO udto) {
		int row = 0;

		try {
			getConn();
			String sql = "insert into user_info values(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, udto.getId());
			psmt.setString(2, udto.getPw());
			psmt.setString(3, udto.getNickname());

			row = psmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			getClose();
		}

		return row;
	}

//--------------------------------회원가입 메소드 끝
	// 로그인 메소드
	public UserDTO login(String id, String pw) {

		getConn();
		String sql = "SELECT* FROM user_info WHERE ID = ? AND PW = ?";
		UserDTO udto = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			if (rs.next()) {// 중복이 없다는 가정하에 if문도 사용 가능!
				String s_id = rs.getString(1);
				String s_pw = rs.getString(2);
				String s_name = rs.getString(3);

				udto = new UserDTO(s_id, s_pw, s_name);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return udto;
	}

	//초기데이터 저장
	public int startRecord(TamagochiDTO tdto) {
		int row = 0;
		try {
			getConn();
			String sql = "insert into digimon_status values(?, ?, ?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, tdto.getId());
			psmt.setInt(2, tdto.getExp());
			psmt.setInt(3, tdto.getLevel());
			psmt.setInt(4, tdto.getHungry());
			psmt.setInt(5, tdto.getLove());
			psmt.setInt(6, tdto.getHp());
			psmt.setInt(7, tdto.getScore());

			row = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();

		}
		return row;

	}

	//데이터 불러오기....
	public TamagochiDTO recallData(String id) {
		TamagochiDTO tdto = null;
		try {
			getConn();
			String sql = "select*from digimon_status where id = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();// result set ==>값을 반환하는 역할
			rs.next();
			tdto = new TamagochiDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return tdto;

	}
	
	//진행 데이터 저장
	public int updateData(int exp, int level, int hungry, int love, int hp, int score, String id) {
		int row = 0;
		getConn();
		String sql = "update digimon_status set 경험치 = ?, 레벨 = ?, 포만도 = ?, 애정도 = ?, 체력 = ?, 점수 = ? where id = ?";
		try {
			// sql문이 통과 할 수 잇는 통로 열었습니다
			psmt = conn.prepareStatement(sql);
			// ?채워주기
			psmt.setInt(1, exp);
			psmt.setInt(2, level);
			psmt.setInt(3, hungry);
			psmt.setInt(4, love);
			psmt.setInt(5, hp);
			psmt.setInt(6, score);
			psmt.setString(7, id);
			// sql문 통과시키기
			row = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}

	//점수 불러오기
	
	public ArrayList<TamagochiDTO> finalScore() {
		getConn();
		ArrayList<TamagochiDTO> tarr = new ArrayList<>();
		String sql = "select ID, 점수 from digimon_status order by 점수 desc";
		TamagochiDTO tdto = null;
		try {
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
			String id = rs.getString(1);	
			int score = rs.getInt(2);
			tdto = new TamagochiDTO(id, score, score, score, score, score, score);
			tarr.add(tdto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return tarr;
		
	}
	
	
	
	
	
	public TamagochiDTO selectOne(String id) {
		getConn();
		String sql = "select*from digimon_status where id = ?";
		TamagochiDTO tdto = null;
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();// result set ==>값을 반환하는 역할
			rs.next();
			tdto = new TamagochiDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return tdto;

	}

}
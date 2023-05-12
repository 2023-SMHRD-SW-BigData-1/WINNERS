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
			if(rs.next()) {//중복이 없다는 가정하에 if문도 사용 가능!
				String s_id = rs.getString(1);
				String s_pw = rs.getString(2);
				String s_name = rs.getString(3);
				
				
				udto = new UserDTO(s_id, s_pw, s_name);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return udto;
	}

	
	public TamagochiDTO startRecord(TamagochiDTO tdto) {
		getConn();
		String sql = "insert into digimon_status values(?, ?, ?, ?, ?, ?, ?)";
		try {
			psmt =  conn.prepareStatement(sql);
			psmt.setString(1, tdto.getId());
			psmt.setInt(2, tdto.getExp());
			psmt.setInt(3, tdto.getLevel());
			psmt.setInt(4, tdto.getHungry());
			psmt.setInt(5, tdto.getLove());
			psmt.setInt(6, tdto.getHp());
			psmt.setInt(7, tdto.getScore());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
			String s_id = rs.getString(1);
			int s_exp = rs.getInt(2);
			int s_level = rs.getInt(3);
			int s_hungry = rs.getInt(4);
			int s_love = rs.getInt(5);
			int s_hp = rs.getInt(6);
			int s_score = rs.getInt(7);
			
			tdto = new TamagochiDTO(s_id, s_exp, s_level, s_hungry, s_love, s_hp, s_score);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
			
		}
		return tdto;
		
		
	}
	
	public void record() {
		
	}
	
	
	
	
	
	public UserDTO selectOne(String id) {
		getConn();
		String sql = "select*from digimon_status where id = ?";
		UserDTO mdto = null;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();//result set ==>값을 반환하는 역할
			rs.next();
			mdto = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return mdto;
		
	}

}
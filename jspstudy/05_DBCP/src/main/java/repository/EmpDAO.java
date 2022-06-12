package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Emp;


public class EmpDAO {
	
	// singleton
	private static EmpDAO empDAO = new EmpDAO();	// 미리 하나 만들어 놓는다.
	private EmpDAO() { }	// 생성자를 private로 해두면 나만 만들 수 있다. 외부에서 new empDAO를 호출할 수 없다.
	public static EmpDAO getInstance() {
		return empDAO;	// 사용자들은 getInstance만 보임. EmpDAO.getinstance() 클래스로 호출한 메소드를 통해서만 접근 가능
	}
	
	// context.xml 내용을 읽어서 DataSource 인스턴스 생성
	// JNDI : java naming and Directory(폴더) Interface API
	// 특정 리소스에 이름(name)을 부여하고 해당 이름(name)을 찾는(lookup) 방식
	// context.xml은 회사측 정보임. 개발자가 만드는게 아님. 이름만 알고 코드만 짜면 됨.
	private static DataSource dataSource;
	static {	// 스태틱처리? 해야함 스태틱 동시에 한다는 뜻
		try {
			Context context = new InitialContext();		// 인터페이스타입은 뉴 못함 이상한거 들어옴
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");	// 뒤 두개는 name resource, 이름을 읽으면 datasource가 반환
			// WAS가 톰캣인 경우     java:comp/env/
			// <Resource name>		 jdbc/oracle11g
		} catch(NamingException e) {
			System.out.println("Resource name을 찾을 수 없습니다.");
		}
	}
	
	
	// field
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	
	// method
	
	// 1. 접속 해제하기
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {	// resultset은 select에서만 씀
		try {
			if(con != null) con.close();  // Connection의 반납
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	// 2. 사원 추가하기
	// 1) 매개변수 : Emp emp	(사원 1명의 정보)
	// 2) 반환 	   : int		데이터가 처리된 개수 (성공하면 1, 실패하면 0)
	public int insertEmp(Emp emp) {
		int res = 0;
		try {
			con = dataSource.getConnection();		// 컨넥션이 필요할 때 datasource로부터 컨넥션 대여해옴. 메소드별로 받았다 반납했다 함
			sql = "INSERT INTO EMP(EMPNO, NAME, DEPT, HIRED) VALUES (EMP_SEQ.NEXTVAL, ?, ?, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getName());	// 1물음표
			ps.setString(2, emp.getDept());	// 2물음표
			res = ps.executeUpdate();	// 실행문. DML(INSERT, UPDATE, DELETE)은 executeUpdate() 메소드 사용
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
	return res;	// 얘는 dao가 처리하는게 아니고 service로 넘겨줌.
	
	}
	
	// 3. 전체사원목록 가져오기
	// 1) 매개변수 : 없음
	// 2) 반환	   : List<Emp> (여러 사원의 정보)
	public List<Emp> selectEmpList() {
		List<Emp> list = new ArrayList<Emp>();
		try {
			con = dataSource.getConnection();	// 데이터소스로부터 빌려욤
			sql = "SELECT EMPNO, NAME, DEPT, HIRED FROM EMP ORDER BY EMPNO DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	 // SELECT문은 executeQuery() 메소드 실행
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setEmpNo(rs.getLong("EMPNO"));   // allargsconstructor
				emp.setName(rs.getString("NAME"));
				emp.setDept(rs.getString("DEPT"));
				emp.setHired(rs.getDate("HIRED"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		
	return list;
	}
	
	// 4. 사원상세정보 가져오기
	// 1) 매개변수 : 사원번호
	// 2) 반환	   : Emp (사원 1명의 정보)
	public Emp selectEmpByEmpNo(Long empNo) {
		Emp emp = null;
		try {
			con = dataSource.getConnection();
			sql = "SELECT EMPNO, NAME, DEPT, HIRED FROM EMP WHERE EMPNO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, empNo);
			rs = ps.executeQuery();
			if(rs.next()) {		// 한명씩 확인할 때 사용하는 코드 있으면true
				emp = new Emp();
				emp.setEmpNo(rs.getLong("EMPNO"));
				emp.setName(rs.getString("NAME"));
				emp.setDept(rs.getString("DEPT"));
				emp.setHired(rs.getDate("HIRED"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return emp;
	}
	
	// 5. 사원정보 수정하기
	// 1) 매개변수 : Emp emp	(사원 1명의 정보)
	// 2) 반환 	   : int		데이터가 처리된 개수 (성공하면 1, 실패하면 0)
	public int updateEmp(Emp emp) {
		int res = 0;
		try {
			con = dataSource.getConnection();
			sql = "UPDATE EMP SET NAME = ?, DEPT = ? WHERE EMPNO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getDept());
			ps.setLong(3,  emp.getEmpNo());
			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return res;
	}
	
	// 6. 사원정보 삭제하기
	// 1) 매개변수 : Long empNo (삭제할 사원번호)
	// 2) 반환 	   : int		(성공하면 1, 실패하면 0)
	public int deleteEmp(Long empNo) {
		int res = 0;
		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM EMP WHERE EMPNO = ?";	// ps를 써서 값을 넣는건 보안문제
			ps = con.prepareStatement(sql);
			ps.setLong(1, empNo);
			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return res;
	}
	
}

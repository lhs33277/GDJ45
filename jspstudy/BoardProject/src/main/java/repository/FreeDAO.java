package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Free;

public class FreeDAO {
	
	private SqlSessionFactory factory;
	
	private static FreeDAO instance = new FreeDAO();
	private FreeDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static FreeDAO getInstance() {
		return instance;
	}
	
	
	// 전체조회
	public List<Free> selectFreeList() {
		SqlSession ss = factory.openSession();
		List<Free> list = ss.selectList("mybatis.mapper.free.selectFreeList");
		ss.close();
		return list;
	}
	
	
	
	
	
}

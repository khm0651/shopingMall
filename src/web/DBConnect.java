package web;

 import java.sql.DriverManager;



 import javax.servlet.ServletException;

 import javax.servlet.http.HttpServlet;



 import org.apache.commons.dbcp2.ConnectionFactory;

 import org.apache.commons.dbcp2.DriverManagerConnectionFactory;

 import org.apache.commons.dbcp2.PoolableConnection;

 import org.apache.commons.dbcp2.PoolableConnectionFactory;

 import org.apache.commons.dbcp2.PoolingDriver;

 import org.apache.commons.pool2.impl.GenericObjectPool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;



public class DBConnect extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    public DBConnect() {

        super();

    }

    

    @Override

    public void init() throws ServletException {

    	loadJDBCDriver();

    	initConnectionPool();

    }



    private void loadJDBCDriver() {

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (Exception e) {

			e.printStackTrace();

		}



		System.out.println("after connection.....");

    }



	private void initConnectionPool() {

		try {

			String jdbcUrl = 

					"jdbc:mysql://localhost:3306/biggates?" + 

					"useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

			String username = "root";

			String password = "rhkrgkals2@";

			

			//ConnectionFactory ����

			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, username, password);

			

			//PoolableConnection�� �����ϴ� Factory ����

			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);

			poolableConnFactory.setValidationQuery("select 1");

			

			//Ŀ�ؼ� Ǯ�� ���� ����

			GenericObjectPoolConfig<PoolableConnection> poolConfig = new GenericObjectPoolConfig<PoolableConnection>();

			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);

			poolConfig.setTestWhileIdle(true);

			poolConfig.setMinIdle(4);

			poolConfig.setMaxTotal(50);

			

			//Ŀ�ؼ� Ǯ ���� �� ����

			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory, poolConfig);

			poolableConnFactory.setPool(connectionPool);

			

			//Ŀ�ؼ� Ǯ�� �����ϴ� JDBC ����̹��� ���

			Class.forName("org.apache.commons.dbcp2.PoolingDriver");

			

			//Ŀ�ؼ� Ǯ ����̹��� ������ Ŀ�ؼ� Ǯ�� ���

			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");

			driver.registerPool("wdbpool", connectionPool);

					

		} catch(Exception e) {

			System.out.println(e.getMessage());

		}

	}

}




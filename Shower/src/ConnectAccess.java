    import java.sql.*;  
    public class ConnectAccess {
    	public static int correct=0;
    	int doll=0;
    	String name=null;
    	String password=null;
    	String sql = null;
    	Connection conn = null;
    	Statement stmt = null;
        public static void main(String args[]) throws Exception {  
            //ConnectAccess ca=new ConnectAccess();  
            //ca.ConnectAccessFile(null, a);
        }  
        public void ConnectAccessFile(String input1,String pass) throws Exception   
        {  
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
            String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=d://Shower.mdb";  
            try{conn = DriverManager.getConnection(dbur1, "username", "password");  
            } catch (Exception e) {
    			System.out.println("���ݿ�����ʧ�ܣ�����");
    		}

            Statement stmt = conn.createStatement();  
            try {
            	correct=0;
    			stmt = conn.createStatement();
    			// Ϊsql������ֵ
    			// �������
    			sql = "select * from Table1";
    			ResultSet r = stmt.executeQuery("select * from Table1");
    			while (r.next()&&correct==0) {
    				name = r.getString(2);
    				password = r.getString(3);
    				if(input1.equals(name)&&pass.equals(password)){
    					correct=1;
    				}
    			}
    		} catch (Exception e) {
    			System.out.println("�������ݿ�ʧ�ܣ�����");
    		}

            try {
    			// �رղ���
    			stmt.close();
    			// �ر�����
    			conn.close();
    		} catch (Exception e) {
    			System.out.println("���ݿ�ر�ʧ�ܣ�����");
    		}  
        }
        public int seal()throws Exception
        {

        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
            String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=d://Shower.mdb";  
            try{conn = DriverManager.getConnection(dbur1, "username", "password");  
            } catch (Exception e) {
    			System.out.println("���ݿ�����ʧ�ܣ�����");
    		}

            Statement stmt = conn.createStatement();  
            try {
    			sql = "select * from Sum";
    			ResultSet r = stmt.executeQuery("select * from Sum");
    			r.next();
    			doll=r.getInt(2);
    		} catch (Exception e) {
    			System.out.println("�������ݿ�ʧ�ܣ�����");
    		}

            try {
    			// �رղ���
    			stmt.close();
    			// �ر�����
    			conn.close();
    		} catch (Exception e) {
    			System.out.println("���ݿ�ر�ʧ�ܣ�����");
    		}
            return doll;
        }
        public void add(int price)throws Exception
        {

        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
            String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=d://Shower.mdb";  
            try{conn = DriverManager.getConnection(dbur1, "username", "password");  
            } catch (Exception e) {
    			System.out.println("���ݿ�����ʧ�ܣ�����");
    		}

            Statement stmt = conn.createStatement();  
            try {
    			sql = "select * from Sum";
    			ResultSet r = stmt.executeQuery("select * from Sum");
    			r.next();
    			doll=r.getInt(2);
    			doll+=price;
    			sql = "UPDATE Sum set sum="+doll+" where ID=1";
    			stmt.executeUpdate("UPDATE Sum set sum="+doll+" where ID=1");
    		} catch (Exception e) {
    			System.out.println("�������ݿ�ʧ�ܣ�����");
    		}
            try {
    			// �رղ���
    			stmt.close();
    			// �ر�����
    			conn.close();
    		} catch (Exception e) {
    			System.out.println("���ݿ�ر�ʧ�ܣ�����");
    		}
        }
}
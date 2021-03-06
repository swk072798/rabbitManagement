package com.nwafu.accountloginmanagement.jdbcActions;

import lombok.Data;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: rabbitmanagement
 * @description: 封装一些使用mybatis没法完成的操作
 * @author: liu qinchang
 * @create: 2019-12-16 11:36
 **/

@Data
public class JdbcActions {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    String preUrl = "jdbc:mysql://116.62.150.116:3306/";
    private final String username = "root";
    private final String password = "123456";
    private static Connection conn;
    private final String postfix = "?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=true&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true";
    public JdbcActions(String dbName) throws SQLException, ClassNotFoundException{
        Class.forName(driver);
        conn = DriverManager.getConnection(preUrl + dbName + postfix, username, password);
    }

    public void runSqlScript() throws IOException {
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.setStopOnError(true);
        Resource resource = new ClassPathResource("sql_files/rabbit_manage_system.sql");
        FileReader reader = new FileReader(resource.getFile());
        scriptRunner.runScript(reader);
    }

    public static void main(String[] args) {
        try {
            JdbcActions jdbcActions = new JdbcActions("lqc");
            jdbcActions.runSqlScript();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("创建成功！！");
    }

}

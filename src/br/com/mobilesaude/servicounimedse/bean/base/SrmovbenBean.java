package br.com.mobilesaude.servicounimedse.bean.base;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class SrmovbenBean{

    @Resource(lookup = "java:/jdbc/srmovben")
    private DataSource datasource;

    public Connection getConnection() throws SQLException {
        return datasource.getConnection();		
    }

    
    
}
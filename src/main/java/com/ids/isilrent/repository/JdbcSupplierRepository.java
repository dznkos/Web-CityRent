package com.ids.isilrent.repository;


import com.ids.isilrent.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcSupplierRepository
        implements SupplierRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Supplier supplier) {
        final String sql = "insert into supplier(ruc, sname, contactEmail, contactMobilePhone, productsku) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, supplier.getRuc(), supplier.getName(),supplier.getContactEmail(),supplier.getContactMobilePhone(),supplier.getProductsku());
    }

    @Override
    public void update(Supplier supplier) {
        final String sql = "update supplier set  sname = ?, contactEmail = ?, contactMobilePhone = ?, productsku = ? where ruc= ?";
        jdbcTemplate.update(sql, supplier.getName(),supplier.getContactEmail(),supplier.getContactMobilePhone(),supplier.getProductsku(), supplier.getRuc());
    }

    @Override
    public void delete(String id) {
        final String sql = "delete supplier where ruc = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Supplier > findAll() {
        final String sql = "select * from supplier ";
        return jdbcTemplate.query(sql,
                JdbcSupplierRepository::SupplierRowMapper);
    }

    @Override
    public Supplier  findById(String id) {
        final String sql = "select * from supplier where ruc = ? ";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                JdbcSupplierRepository::SupplierRowMapper);
    }

    private static Supplier SupplierRowMapper(ResultSet resultSet, int i) throws SQLException {
        String ruc = resultSet.getString("ruc");
        String sname = resultSet.getString("sname");
        String contactEmail = resultSet.getString("contactEmail");
        String contactMobilePhone = resultSet.getString("contactMobilePhone");
        String productsku = resultSet.getString("productsku");
        return new Supplier(ruc, sname, contactEmail, contactMobilePhone, productsku);
    }

}

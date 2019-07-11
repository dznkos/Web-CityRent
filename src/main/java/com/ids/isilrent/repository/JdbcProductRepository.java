package com.ids.isilrent.repository;

import com.ids.isilrent.model.Product;
import com.ids.isilrent.model.ProductsSupplier;
import com.ids.isilrent.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcProductRepository
        implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Product product) {
        final String sql = "insert into product(sku, pname, stock, price) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getSku(), product.getName(),product.getStock(),product.getPrice());
    }

    @Override
    public void update(Product product) {
        final String sql = "update product set pname = ?, stock = ?, price = ?  where sku = ?";
        jdbcTemplate.update(sql, product.getName(),product.getStock(),product.getPrice(), product.getSku());
    }

    @Override
    public void delete(String id) {
        final String sql = "delete product where sku = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Product> findAll() {
        final String sql = "select * from product ";
        return jdbcTemplate.query(sql,
                JdbcProductRepository::ProductRowMapper);
    }

    @Override
    public Product findById(String id) {
        return null;
    }

    public List<Product> findProductBySupplier(String id) {
        //FUNCIONANDO
        List<Product> productList = jdbcTemplate
                .query("select p.sku,p.pname,p.stock,p.price from product p " +
                                " inner join supplier s on p.sku = s.productsku where s.ruc=?",new Object[] { id },
                (rs, rowNum) -> new Product(rs.getString("sku"),
                                            rs.getString("pname"),
                                            rs.getInt("stock"),
                                            rs.getDouble("price")));
        return productList;
    }

    private static Product ProductRowMapper(ResultSet resultSet, int i) throws SQLException {
        String id = resultSet.getString("sku");
        String pname = resultSet.getString("pname");
        int stock = resultSet.getInt("stock");
        double price = resultSet.getDouble("price");
        return new Product(id, pname, stock, price);
    }
}

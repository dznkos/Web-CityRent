package com.ids.isilrent.repository;

import com.ids.isilrent.model.Product;
import com.ids.isilrent.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcReservaRepository implements  ReservaRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Reserva reserva) {
        final String sql = "insert into reserva(idreserva,cliente, auto, price) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, reserva.getIdreserva(), reserva.getCliente(),reserva.getAuto(),reserva.getPrice());
    }

    @Override
    public void update(Reserva reserva) {
        final String sql = "update reserva set  cliente = ?, auto = ?, price = ? where idreserva= ?";
        jdbcTemplate.update(sql, reserva.getCliente(),reserva.getAuto(),reserva.getPrice(), reserva.getIdreserva() );
    }

    @Override
    public void delete(String id) {
        final String sql = "delete reserva where idreserva = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Reserva> findAll() {
        final String sql = "select * from reserva ";
        return jdbcTemplate.query(sql,
                JdbcReservaRepository::ReservaRowMapper);
    }

    @Override
    public Reserva findById(String id)
    {
        final String sql = "select * from reserva where idreserva = ? ";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                JdbcReservaRepository::ReservaRowMapper);
    }
    private static Reserva ReservaRowMapper(ResultSet resultSet, int i) throws SQLException {
        String idreserva = resultSet.getString("idreserva");
        String cliente = resultSet.getString("cliente");
        String auto = resultSet.getString("auto");
        double price = resultSet.getDouble("price");
        return new Reserva(idreserva, cliente, auto, price);
    }
}

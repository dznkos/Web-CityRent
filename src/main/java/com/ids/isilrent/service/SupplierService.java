package com.ids.isilrent.service;

import com.ids.isilrent.model.Supplier;
import com.ids.isilrent.repository.JdbcSupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    JdbcSupplierRepository jdbcSupplierRepository = new JdbcSupplierRepository();

    //AtomicInteger id = new AtomicInteger();

    /*
    List<Vehiculo> vehiculos = new ArrayList<>(
            Arrays.asList(
                    new Vehiculo(id.getAndIncrement(), "nissan","panc"),
                    new Vehiculo(id.getAndIncrement(), "toyota","corolla"),
                    new Vehiculo(id.getAndIncrement(), "kia","fast"),
                    new Vehiculo(id.getAndIncrement(), "ford","summit"),
                    new Vehiculo(id.getAndIncrement(), "mazda","familia")
            )
    );*/

    public List<Supplier> getAll() {
        return jdbcSupplierRepository.findAll();
    }

    /*
    public void saveProduct(Vehiculo pago) {

        pago.setNumeroPago(numeroPago.incrementAndGet());

        products.add(pago);
    }*/
}

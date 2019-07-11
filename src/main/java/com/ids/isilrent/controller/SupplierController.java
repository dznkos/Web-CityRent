package com.ids.isilrent.controller;


import com.ids.isilrent.model.Reserva;
import com.ids.isilrent.model.Supplier;
import com.ids.isilrent.repository.JdbcProductRepository;
import com.ids.isilrent.repository.JdbcReservaRepository;
import com.ids.isilrent.repository.JdbcSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SupplierController {

    @Autowired
    JdbcSupplierRepository jdbcSupplierRepository;

    @Autowired
    JdbcProductRepository jdbcProductRepository;

    @Autowired
    JdbcReservaRepository jdbcReservaRepository;


    @GetMapping( {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/supplier")
    public String getSupplierlist(Model model){
        model.addAttribute("suppliers", jdbcSupplierRepository.findAll());
        return "list-supplier";
    }
    @GetMapping("/reserva")
    public String getReservalist(Model model){
        model.addAttribute("reservas", jdbcReservaRepository.findAll());
        return "list-reserva";
    }

    @GetMapping("/supplier/add")
    public String addSupplier(Model model){
        model.addAttribute("supplier", new Supplier());
        return "supplier-add";
    }
    @GetMapping("/reserva/add")
    public String addReserva(Model model){
        model.addAttribute("reserva", new Reserva());
        return "reserva-add";
    }
    @PostMapping("/reserva/save")
    public String saveReserva(Reserva reserva,Model model){
        jdbcReservaRepository.create(reserva);
        model.addAttribute("reservas", jdbcReservaRepository.findAll());
        return "list-reserva";
    }
    // guardar
    @PostMapping("/reserva/edit/save")
    public String saveUpdateReserva(Reserva reserva,Model model){
        jdbcReservaRepository.update(reserva);
        model.addAttribute("reservas", jdbcReservaRepository.findAll());
        return "list-reserva";
    }
    // ACTUALIZAR
    @GetMapping("/reserva/update/{id}")
    public String updateReserva(@PathVariable String id, Model model){
        Reserva reserva = jdbcReservaRepository.findById(id);
        model.addAttribute("reserva", reserva);
        model.addAttribute("idreserva", id);
        return "reserva-edit";
    }

    @GetMapping("/reserva/delete/{id}")
    public String deleteReserva(@PathVariable String id, Model model){
        jdbcReservaRepository.delete(id);
        model.addAttribute("reservas", jdbcReservaRepository.findAll());
        return "list-reserva";
    }

    @PostMapping("/supplier/save")
    public String saveSupplier(Supplier supplier, Model model){
        jdbcSupplierRepository.create(supplier);
        model.addAttribute("suppliers", jdbcSupplierRepository.findAll());
        return "list-supplier";
    }
    @PostMapping("/supplier/edit/save")
    public String saveEditSupplier(Supplier supplier, Model model){
        jdbcSupplierRepository.update(supplier);
        model.addAttribute("suppliers", jdbcSupplierRepository.findAll());
        return "list-supplier";
    }
    //actualiza
    @GetMapping("/supplier/edit/{id}")
    public String getSupplierForEdit(@PathVariable String id,
                                    Model model){
        Supplier supplierid = jdbcSupplierRepository.findById(id);
        model.addAttribute("supplier", supplierid);
        return "supplier-edit";
    }
    //actualiza supplier
    @PostMapping("/supplier/update/")
    public String updateProdSupplier(Supplier supplier, Model model){
        jdbcSupplierRepository.update(supplier);
        model.addAttribute("suppliers", jdbcSupplierRepository.findAll());
        return "supplier-supplier";
    }
    /// MODIFICA
    @GetMapping("/supplier/update/{id}")
    public String updateSupplier(@PathVariable String id, Model model){
        Supplier sup = jdbcSupplierRepository.findById(id);
        model.addAttribute("supplier", sup);
        model.addAttribute("ruc", id);
        return "supplier-edit";
    }
    @GetMapping("/supplier/delete/{id}")
    public String deleteSupplier(@PathVariable String id, Model model){
        jdbcSupplierRepository.delete(id);
        model.addAttribute("suppliers", jdbcSupplierRepository.findAll());
        return "list-supplier";
    }

    @GetMapping("/supplier/listprod/{id}")
    public String listProduct(@PathVariable String id,Model model){
        try {
            model.addAttribute("productssup", jdbcProductRepository.findProductBySupplier(id));
        }
        catch (EmptyResultDataAccessException e) {
            System.out.println("Error listCourse - suppliers no tiene products");
            model.addAttribute("suppliers", jdbcSupplierRepository.findAll());
            return "list-supplier";
        }
        return "list-productsupplier";
    }

    @GetMapping("/supplier/addprod/{id}")
    public String addProdSupplier(@PathVariable String id, Model model){
        model.addAttribute("supplier", new Supplier());
        Supplier sup = jdbcSupplierRepository.findById(id);
        model.addAttribute("ruc", sup.getRuc());
        model.addAttribute("sname", sup.getName());
        model.addAttribute("contactEmail", sup.getContactEmail());
        model.addAttribute("contactMobilePhone", sup.getContactMobilePhone());
        return "supplier-add-prod";
    }

    @GetMapping("/services")
    public String obtenerServicios(Model model)
    {
        return "services";
    }

}

package com.ids.isilrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reserva {
    private String idreserva;
    private String cliente;
    private String auto;
    private double price;
}

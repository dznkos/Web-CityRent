
DROP TABLE IF EXISTS suplier;
DROP TABLE IF EXISTS product;


CREATE TABLE supplier (
  ruc VARCHAR(10) NOT NULL,
  sname VARCHAR(100) 
NOT NULL,
  contactEmail VARCHAR(100) NOT NULL,
  contactMobilePhone VARCHAR(100) 
NOT NULL,
  productsku VARCHAR(10) NULL
);
create table product (
   
 sku VARCHAR(10) NOT NULL,
    pname VARCHAR(100) NOT NULL,
   
 stock INT NOT NULL,
    price DOUBLE NOT NULL
);

create table reserva (
     idreserva VARCHAR(10) NOT NULL,
     cliente VARCHAR(100) NOT NULL,
     auto VARCHAR(100) NOT NULL,
     price DOUBLE NOT NULL
);

ALTER TABLE supplier 
ADD FOREIGN KEY (productsku) REFERENCES product(sku);

INSERT INTO product 
( sku, pname, stock, price)
           
  VALUES ('123','Toyota','121','450.00'),
           
         ('234','Nissan','14','420.00'),
         
           ('567','Audi','263','500.00'),
          
          ('789','Lamborgini','57','1050.00');



INSERT INTO supplier ( ruc, sname, contactEmail, contactMobilePhone)
              VALUES ('48541125','Bruno','bruno@gmail.com','992358614'),
                     ('78151132','dIEGO','die@gmail.com','9785115151'),
                     ('84511236','Victor','bruno@gmail.com','992358614'),
                     ('84621248','Pedro','podr@gmail.com','99162487'),
                     ('84361578','Renzo','ren@gmail.com','99162487'),
                     ('86781321','Berne','ber@gmail.com','991551623');

INSERT INTO reserva ( idreserva, cliente, auto, price)
              VALUES ('11112222','Bruno','88888888',500.50),
                     ('33332222','Luis','999999999',900.80);



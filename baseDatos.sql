
INSERT INTO paises (pais) VALUES ('Colombia');

INSERT INTO paises (pais) VALUES ('EEUU');

INSERT INTO paises (pais) VALUES ('Ecuador');

INSERT INTO paises (pais) VALUES ('Peru');

INSERT INTO paises (pais) VALUES ('Panama');

select * from paises;
INSERT INTO ciudades (ciudad , departamento_id) VALUES ('Medellin' , 6 );
INSERT INTO departamentos (departamanto , pais_id) VALUES ('Antioquia' , 1 );
INSERT INTO ciudades (ciudad , departamento_id) VALUES (' leticia' , 7 );
INSERT INTO departamentos (departamanto , pais_id) VALUES ('Amazonas' , 1 );
INSERT INTO ciudades (ciudad , departamento_id) VALUES ('Los Ángeles ' , 8 );
INSERT INTO departamentos (departamanto , pais_id) VALUES ('California' , 2 );
INSERT INTO ciudades (ciudad , departamento_id) VALUES ('Houston ' , 9 );
INSERT INTO departamentos (departamanto , pais_id) VALUES ('Texas' , 2 );
INSERT INTO ciudades (ciudad , departamento_id) VALUES ('Guayaquil' , 10 );
INSERT INTO departamentos (departamanto , pais_id) VALUES ('Guayas' , 3 );
INSERT INTO ciudades (ciudad , departamento_id) VALUES ('Quito ' , 11 );
INSERT INTO departamentos (departamanto , pais_id) VALUES ('Pichincha' , 3 );

INSERT INTO ciudades (ciudad , departamento_id) VALUES ('Lima' , 12 );
INSERT INTO departamentos (departamanto , pais_id) VALUES ('Lima' , 4 );
INSERT INTO ciudades (ciudad , departamento_id) VALUES ('Cusco ' , 13 );
INSERT INTO departamentos (departamanto , pais_id) VALUES ('Cusco' , 4 );

INSERT INTO ciudades (ciudad , departamento_id) VALUES ('Ciudad de Panamá' , 14 );
INSERT INTO departamentos (departamanto , pais_id) VALUES ('Provincia de Panamá' , 5 );
INSERT INTO ciudades (ciudad , departamento_id) VALUES ('Colón ' , 15 );
INSERT INTO departamentos (departamanto , pais_id) VALUES ('Provincia de Colón' , 5 );
select * from departamentos;
select * from ciudades; 
select * from paises; 

select * from clientes;

INSERT INTO tipo_identificacion (nombres) Values ('CC');
INSERT INTO tipo_identificacion (nombres) Values ('TI');
INSERT INTO tipo_identificacion (nombres) Values ('PA');
INSERT INTO tipo_identificacion (nombres) Values ('CE');

select * from tipo_identificacion;

INSERT INTO marcas (marca) Values ('Americanino');
INSERT INTO marcas (marca) Values ('American Eagle');
INSERT INTO marcas (marca) Values ('Chevignon');
INSERT INTO marcas (marca) Values ('Esprit');
INSERT INTO marcas (marca) Values ('Naf Naf');
INSERT INTO marcas (marca) Values ('Rifle');

select * from marcas;

select * from clientes;





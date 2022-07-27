CREATE TABLE tbl_regions(
id IDENTITY not null PRIMARY key, 
name varchar(60));

INSERT INTO tbl_regions (id, name) VALUES (1, 'Sudamérica');
INSERT INTO tbl_regions (id, name) VALUES (2, 'Centroamérica');
INSERT INTO tbl_regions (id, name) VALUES (3, 'Norteamérica');
INSERT INTO tbl_regions (id, name) VALUES (4, 'Europa');
INSERT INTO tbl_regions (id, name) VALUES (5, 'Asia');
INSERT INTO tbl_regions (id, name) VALUES (6, 'Africa');
INSERT INTO tbl_regions (id, name) VALUES (7, 'Oceanía');
INSERT INTO tbl_regions (id, name) VALUES (8, 'Antártida');

create table tbl_customers(
id IDENTITY not null PRIMARY key, 
number_id varchar(8),
first_name varchar,
last_name varchar,
email varchar,
photo_url varchar,
state varchar,
region_id int,
foreign key (region_id) references tbl_regions(id)
);


INSERT INTO tbl_customers (id,number_id,first_name,last_name , email, photo_url, region_id, state) VALUES(1,'32404580', 'Andrés', 'Guzmán', 'profesor@bolsadeideas.com','',1,'CREATED');
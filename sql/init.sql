CREATE SEQUENCE product_id_seq;

CREATE TABLE product
(
    id integer NOT NULL DEFAULT nextval('product_id_seq'),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    description character varying(500) COLLATE pg_catalog."default",
    unit_price double precision NOT NULL,
    quantity_per_unit integer NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id)
);


CREATE OR REPLACE FUNCTION get_products(
	)
    RETURNS TABLE(id integer, name character varying, description character varying, unit_price double precision, quantity_per_unit integer) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$

BEGIN
   RETURN QUERY
   SELECT prod.id, prod.name, prod.description, prod.unit_price, prod.quantity_per_unit from product prod;
END

$BODY$;

CREATE OR REPLACE FUNCTION insert_product(
	p_name character varying,
	p_description character varying,
	p_unit_price double precision,
	p_quantity integer)
    RETURNS TABLE(id integer, name character varying, description character varying, unit_price double precision, quantity_per_unit integer) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$

	DECLARE
    product_id product.id%type;
    BEGIN
    Insert into product values (default, p_name,  p_description, p_unit_price ,p_quantity);

	RETURN QUERY
   	SELECT prod.id, prod.name, prod.description, prod.unit_price, prod.quantity_per_unit from product prod where prod.name =p_name;
    END
	

$BODY$;

INSERT INTO public.product(
	id, name, description, unit_price, quantity_per_unit)
	VALUES (default, 'Keyboard', 'Razer Keyboard', 50, 2);
	INSERT INTO public.product(
	id, name, description, unit_price, quantity_per_unit)
	VALUES (default, 'Mouse', 'Microsoft Mouse', 20, 6);
	INSERT INTO public.product(
	id, name, description, unit_price, quantity_per_unit)
	VALUES (default, 'Micro', 'Microsoft micfrophone', 3, 4);

CREATE TABLE "products" (
  "id" bigserial NOT NULL,
  "nome" varchar(255),
  "price" decimal(65,2) NOT NULL,
  "quantity" integer NOT NULL,
  "uuid" varchar(255) NOT NULL,
  primary key  (id)
);

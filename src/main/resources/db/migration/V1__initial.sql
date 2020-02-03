CREATE TABLE "user"
(
  id INT NOT NULL IDENTITY PRIMARY KEY,
  name varchar(255)
);

CREATE TABLE user_property
(
  id  INT  NOT NULL  IDENTITY PRIMARY KEY,
  name varchar(255),
  type ENUM('BUILDING', 'APARTMENT'),
  parent_id BIGINT DEFAULT '0',
  user_id INT;
);

CREATE TABLE rental_contract
(
  id  INT  NOT NULL  IDENTITY PRIMARY KEY,
  tenant_id INT COMMENT 'id of user' , 
);

CREATE TABLE rental_property
(
  id  INT  NOT NULL  IDENTITY PRIMARY KEY,
  rental_contract_id INT COMMENT 'id of user' ,
  user_property_id INT
);


CREATE TABLE persistent_audit
(
 created_by 		VARCHAR(255),
 created_date 		TIMESTAMP without TIME ZONE NOT NULL DEFAULT now(),
 last_modified_by 	VARCHAR (255),
 last_modified_date TIMESTAMP without TIME ZONE NOT NULL DEFAULT now()
);

CREATE TABLE "user"
(
  id 			SERIAL NOT NULL,
  name 			VARCHAR(255),
  CONSTRAINT user_pkey PRIMARY KEY (id)
)INHERITS (zenhomes.persistent_audit);

CREATE TABLE user_property
(
  id  				SERIAL NOT NULL,
  name 				VARCHAR(255),
  type 				VARCHAR(255),
  parent_id 		BIGINT DEFAULT '0',
  user_id 			BIGINT,
  CONSTRAINT user_property_pKey PRIMARY KEY (id),
  CONSTRAINT user_property_user_fkey FOREIGN KEY (user_id)
  	REFERENCES zenhomes.user (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
)INHERITS (zenhomes.persistent_audit);

CREATE TABLE rental_contract
(
  id  			SERIAL NOT NULL,
  tenant_id 	BIGINT, -- 'id of user'
  CONSTRAINT rental_contract_pkey PRIMARY KEY (id)
)INHERITS (zenhomes.persistent_audit);

CREATE TABLE rental_property
(
  id  					SERIAL NOT NULL,
  rental_contract_id 	BIGINT,
  user_property_id 		BIGINT,
  CONSTRAINT rental_property_pkey PRIMARY KEY (id),
  CONSTRAINT rental_property_rental_contract_fkey FOREIGN KEY (rental_contract_id)
  	REFERENCES zenhomes.rental_contract (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT rental_property_user_property_fkey FOREIGN KEY (user_property_id)
  	REFERENCES zenhomes.user_property (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
)INHERITS (zenhomes.persistent_audit);

# Domain
This repository is created to solve **Business logic between Landlord and Tenant**
# Entity Relationship Diagram
![landlord-service](https://serving.photos.photobox.com/85933885ea1dd84c94183f5c5a733afc8cd93171dd6f2229ceea02e170b46569e21d6f62.jpg)
# Tables
**Persistent_audit**  
|Column_name | Data-type | Description |
|------------ | ------------- | ------------- |
|created_by | varchar(255) | created by {user_name}|
|created_date | timestamp | create at|
|last_modified_by | varchar(255) | update by {user_name}|
|last_modified_date | timestamp | last modify at|

**user**  
|Column_name | Data-type | Description |
|------------ | ------------- | ------------- |
|id | bigint | primarykey, auto inscrease|
|name | varchar(255) | property name|

**user_property**  
|Column_name | Data-type | Description |
|------------ | ------------- | ------------- |
|id | bigint | primarykey, auto inscrease|
|name | varchar(255) | user name|
|type | varchar(255) | ENUM('BUILDING', 'APARTMENT', 'BLOCK', 'FLOOR'...)|
|parent_id | bigint | link to id as know as relationship. Ex: Floor have multiple appartments|
|user_id | bigint | FK to user(id). Property's owner|

**rental_contract**  
|Column_name | Data-type | Description |
|------------ | ------------- | ------------- |
|id | bigint | primarykey, auto inscrease|
|tenant_id | bigint | Fk to user(id). User who rent property from landlord|

**rental_property**  
|Column_name | Data-type | Description |
|------------ | ------------- | -------------|
|id | bigint | primarykey, auto inscrease|
|rental_contract_id | bigint | Fk to rental_contract(id)|
|user_property_id | bigint | Fk to user_property(id)|

User, User_property, Rental_contract, Rental property all have a unique ID (id) that is used as their primary key (labelled as PK in the diagram above), and user_property contains the foreign key (FK) user_id that links it to the user table in a one-to-many relationship. The join table rental_property  has two columns, rental_contract_id and user_property_id, which are both foreign keys that make up a composite primary key (CPK) and the Rental_contract constains the FK tenant_id linkted to user table in a one-to-many relationship.

Here are the tables, structured as illustrated above, with some data in them. Note that the order of the columns is not the same as in the diagrams:
**user**
```
+---------+--------------+
| id       | name        | 
+---------+--------------+
| 1       | John         |
| 2       | Steve        |
| 3       | Max          |
+---------+--------------+
```
**user_property**
```
+---------+-------------------+--------------+--------------+----------+
| id      | name              | type         | parent_id    | user_id  |
+---------+-------------------+--------------+--------------+----------+
|       1 | Diamon BUILDING   | BUILDING     | 0            | 1        |
|       2 | FLOOR 1           | FLOOR        | 1            | 1        |
|       3 | Apartment-01      | APARTMENT    | 2            | 1        |
|       4 | Apartment-02      | APARTMENT    | 2            | 1        |
|       5 | Blue BUILDING     | BUILDING     | 0            | 3        |
|       6 | FLOOR A           | FLOOR        | 5            | 3        |
|       7 | FLOOR B           | FLOOR        | 5            | 3        |
|       8 | Apartment-110     | APARTMENT    | 6            | 3        |
|       9 | Apartment-210     | APARTMENT    | 7            | 3        |
+---------+-------------------+--------------+--------------+----------+
```
**rental_contract**
```
+---------+--------------+
| id      | tenant_id    | 
+---------+--------------+
| 1       | 2(Steve)     |
| 2       | 2(Steve)     |
| 3       | 1(John)      |
+---------+--------------+
```
**rental_property**
```
+---------+--------------------+------------------+
| id      | rental_contract_id | user_property_id | 
+---------+--------------------+------------------+
| 1       | 1                  | 3                +
| 2       | 1                  | 4                +
| 3       | 2                  | 7                +
| 4       | 3                  | 6                +
+---------+--------------------+------------------+
```
Now that we have database structure. have been some sample data and we can move on to explain the relationship as real-life.
**User table**: we have 3 records as know as John, Steve, Max
**User_property table**: is dataset user's properties linked to user table by user_id. With data above said: 
- John have a build naming is "Diamon Building". Inside the building it have one floor (Floor-1) and Floor-1 have two apartments(Apartment-01, Apartment-02). Those records has been linked by parent_id. Diamond Building have id = 1 and Floor-1 has id = 2 and parent_id = 1 mean Floor 1 is a part of Diamon Building, it considered as tree-node.
**Noted**: parent_id = 0 (zero) is root-node  
**Rental_contract table**: Is a dataset of the Rental Agreements between Landlord and Tenant.
Relationship between rental_contract and user is one-to-many and each record in user table will be consider as tenant or landlord was mapped by tenant_id and user(id)  
**Rental_property table**: is dataset of properties that tenant wants to rent from landlord.
With data above said that Steve(tenant) have two contracts with John and Max. Furthermore, John is landlord and tenant as well, because He have a contract with Max

**Querying contract**
```sql
SELECT 
  rc.id AS "Contract No",
  u.name AS "Tenant Name",
  up.name AS "Property name",
  upu.name AS "Landlord name"
FROM "zenhomes".rental_contract AS rc
INNER JOIN "zenhomes".rental_property as rp
  ON rp.rental_contract_id = rc.id
INNER JOIN "zenhomes".user_property AS up
INNER JOIN "zenhomes".user AS upu
  ON upu.id = up.user_id
  ON rp.user_property_id = up.id
INNER JOIN "zenhomes".user AS u
  ON u.id = rc.tenant_id
```

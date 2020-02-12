# Domain
This repository is created to solve **Business logic between Landlord and Tenant**
# Entity Relationship Diagram
![landlord-service](https://serving.photos.photobox.com/85933885ea1dd84c94183f5c5a733afc8cd93171dd6f2229ceea02e170b46569e21d6f62.jpg)
# Tables
## persistent_audit
Column_name | Data-type | Description 
------------ | ------------- | ------------- 
created_by | varchar(255) | created by {user_name}
created_date | timestamp | create at
last_modified_by | varchar(255) | update by {user_name}
last_modified_date | timestamp | last modify at
## user
Column_name | Data-type | Description 
------------ | ------------- | ------------- 
created_by | varchar(255) | created by {user_name}
created_date | timestamp | create at
last_modified_by | varchar(255) | update by {user_name}
last_modified_date | timestamp | last modify at
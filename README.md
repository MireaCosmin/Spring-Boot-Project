# Spring-Boot-Project
Order Management Project

Details:
- CRUD operations
- Error handling
- Unit tests

Entities: 
- account
- product
- storage
- shop
- order
- return order

Entities relationships:
- account - order -> one to many 
- product - order -> many to many 
- shop - order -> one to many 
- shop - storage -> one to one 
- storage - product -> many to many 
- return order - order -> many to one

Business requirements:
- create accounts ( constraint: the age to be at least 14 years old )
- place orders ( for pick-up in store; decrease the account balance and the storage )
- return orders completely ( refund the money to the customer and update the storage with the returned quantites )
- delete products from storage ( constrains: the product quantity to be zero )
- add new products in storage 
- apply discount ( constraint: the total amount of the order to be greater than 200 )

Future business requirements:
- create orders for delivery
- return orders partially 

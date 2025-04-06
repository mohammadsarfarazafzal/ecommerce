# Hibernate eCommerce Application

A Java application demonstrating Hibernate ORM capabilities.

## Project Overview

### Project Structure

```
src/main/java/
├── hb/ecommerce/
│   ├── App.java                        # Main application entry point
│   ├── crud/                           # CRUD operation classes 
│   │   ├── CreateOrdersAndOrderDetails.java
│   │   ├── CreateProductAndCategory.java 
│   │   ├── CreateUsers.java
│   │   └── ReadOrdersUsersProducts.java
│   └── entity/                         # Entity classes
│       ├── Category.java
│       ├── OrderDetails.java
│       ├── Orders.java
│       ├── Product.java
│       └── Users.java
└── hibernate.cfg.xml                   # Hibernate configuration
```

## Tech Stack

- Java 17
- Hibernate 6.6.1
- MySQL 8.0.33
- Maven

## Database Schema

![image](https://github.com/user-attachments/assets/87ef3907-3a1a-4ae4-9a36-0c510189efc8)


This application creates the following tables:
- `category` - Stores product categories
- `product` - Stores product information with category references
- `users` - Stores user information 
- `orders` - Stores order information with user references
- `orderdetails` - Stores order line items with order and product references

## Prerequisites

- JDK 17 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/ecommerce.git
```

### 2. Database Setup

1. Create a new MySQL database named `ecommerce`:

```sql
CREATE DATABASE ecommerce;
```

### 2. Import as an Existing Maven Project in Eclipse IDE.

Update the database configuration in `src/main/java/hibernate.cfg.xml` if needed:

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3307/ecommerce</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">YOUR_PASSWORD</property>
```

Note: The current configuration uses port 3307. If your MySQL instance runs on the default port 3306, update accordingly.

### Execution Guide

1. Uncomment the desired operations in `App.java` based on what you want to do:

```java
// To create product and categories
// new CreateProductAndCategory(factory);

// To create users
// new CreateUsers(factory);

// To create orders with details
// new CreateOrdersAndOrderDetails(factory);

// To read and display order details
new ReadOrdersUsersProducts(factory);
```

2. Run the `App.java` file as a Java application:

## CRUD Operations:

1. **Setup Database Schema**: Hibernate automatically creates tables based on entity mappings
2. **Create Categories and Products**: Uses `CreateProductAndCategory` class
3. **Create Users**: Uses `CreateUsers` class
4. **Create Orders**: Uses `CreateOrdersAndOrderDetails` class to create orders with references to users and products
5. **Read Data**: Uses `ReadOrdersUsersProducts` class to retrieve and display order information

## Output:

### Category Table

```
mysql> SELECT * FROM category;
```
![image](https://github.com/user-attachments/assets/4da96bae-0522-4900-b35e-4c708e48948f)

### Product Table

```
mysql> SELECT * FROM product;
```
![image](https://github.com/user-attachments/assets/60cb4f53-8229-49f6-9da1-0ac67ebf6ae2)


### Users Table

```
mysql> SELECT * FROM users;
```
![image](https://github.com/user-attachments/assets/bf0b52f8-b1f7-46f1-b0e6-d5ecb6fd72ef)

### Orders Table

```
mysql> SELECT * FROM orders;
```
![image](https://github.com/user-attachments/assets/d0862e0f-b56e-4287-b13e-96797c9ee3c2)


### Order Details Table

```
mysql> SELECT * FROM orderdetails;
```
![image](https://github.com/user-attachments/assets/0a843643-127c-41b5-b09c-d6708f392284)

### Read Operation

```
Hibernate: select od1_0.detailsId,od1_0.orderId,od1_0.productId,od1_0.quantity,od1_0.unitPrice from orderdetails od1_0
Hibernate: select o1_0.orderId,o1_0.orderDate,o1_0.totalAmount,u1_0.userId,u1_0.email,u1_0.password,u1_0.role,u1_0.username from orders o1_0 left join users u1_0 on u1_0.userId=o1_0.userId where o1_0.orderId=?
Hibernate: select p1_0.productId,c1_0.categoryId,c1_0.categoryDescription,c1_0.categoryName,p1_0.productName,p1_0.price,p1_0.stockQuantity from product p1_0 left join category c1_0 on c1_0.categoryId=p1_0.categoryId where p1_0.productId=?
Hibernate: select p1_0.productId,c1_0.categoryId,c1_0.categoryDescription,c1_0.categoryName,p1_0.productName,p1_0.price,p1_0.stockQuantity from product p1_0 left join category c1_0 on c1_0.categoryId=p1_0.categoryId where p1_0.productId=?
Hibernate: select o1_0.orderId,o1_0.orderDate,o1_0.totalAmount,u1_0.userId,u1_0.email,u1_0.password,u1_0.role,u1_0.username from orders o1_0 left join users u1_0 on u1_0.userId=o1_0.userId where o1_0.orderId=?
Hibernate: select p1_0.productId,c1_0.categoryId,c1_0.categoryDescription,c1_0.categoryName,p1_0.productName,p1_0.price,p1_0.stockQuantity from product p1_0 left join category c1_0 on c1_0.categoryId=p1_0.categoryId where p1_0.productId=?
Hibernate: select p1_0.productId,c1_0.categoryId,c1_0.categoryDescription,c1_0.categoryName,p1_0.productName,p1_0.price,p1_0.stockQuantity from product p1_0 left join category c1_0 on c1_0.categoryId=p1_0.categoryId where p1_0.productId=?
OrderDetails [order = Orders [id=1, orderDate=2025-04-06T22:41:16.561572, totalAmount=0.0, user=User [id=1, username=nahid, password=xzist123, email=nahid@google.com, role=CUSTOMER], orderDetails=], user = User [id=1, username=nahid, password=xzist123, email=nahid@google.com, role=CUSTOMER], product = Product [id=1, name=Paracetamol, price=10.99, stockQuantity=150, category=Category [id=1, name=Medicine, description=]]]
OrderDetails [order = Orders [id=1, orderDate=2025-04-06T22:41:16.561572, totalAmount=0.0, user=User [id=1, username=nahid, password=xzist123, email=nahid@google.com, role=CUSTOMER], orderDetails=], user = User [id=1, username=nahid, password=xzist123, email=nahid@google.com, role=CUSTOMER], product = Product [id=2, name=Calpol, price=11.99, stockQuantity=150, category=Category [id=1, name=Medicine, description=]]]
OrderDetails [order = Orders [id=2, orderDate=2025-04-06T23:00:25.949788, totalAmount=19981.97, user=User [id=5, username=nishant, password=nbhadani123, email=nishant@google.com, role=CUSTOMER], orderDetails=], user = User [id=5, username=nishant, password=nbhadani123, email=nishant@google.com, role=CUSTOMER], product = Product [id=6, name=Black Hoody, price=3990.99, stockQuantity=15, category=Category [id=4, name=Fashion, description=Trending Fashion]]]
OrderDetails [order = Orders [id=2, orderDate=2025-04-06T23:00:25.949788, totalAmount=19981.97, user=User [id=5, username=nishant, password=nbhadani123, email=nishant@google.com, role=CUSTOMER], orderDetails=], user = User [id=5, username=nishant, password=nbhadani123, email=nishant@google.com, role=CUSTOMER], product = Product [id=7, name=White Blazer, price=11999.99, stockQuantity=19, category=Category [id=4, name=Fashion, description=Trending Fashion]]]
```

## License

[MIT License](LICENSE)

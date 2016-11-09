# onlineshop

Mock online shop for the ACA Java class. Core functionality works.

Master currently in working form. Dev branch will have improvements but may not be completely functional

Missing features/future improvements:

Input validation/confirmation

No logging

Some null throws

Assumes DB already exists

Delivery service works, but requires valid lat&long points with no validation(there is a second api for this)

Delivery service should have delivery windows (am, pm/morning, afternoon, evening)

Remove orderlist package and add join functionality to orderdao

Order{id=10, userId=1, amount=4.00, purchaseDate=2016-11-09 11:52:29.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=11, userId=3, amount=4.00, purchaseDate=2016-11-09 11:52:29.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=12, userId=4, amount=4.00, purchaseDate=2016-11-09 11:52:47.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=13, userId=5, amount=4.00, purchaseDate=2016-11-09 11:52:47.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=14, userId=6, amount=4.00, purchaseDate=2016-11-09 11:52:47.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=15, userId=7, amount=4.00, purchaseDate=2016-11-09 11:53:23.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=16, userId=8, amount=4.00, purchaseDate=2016-11-09 11:53:23.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=17, userId=9, amount=4.00, purchaseDate=2016-11-09 11:53:23.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=18, userId=10, amount=4.00, purchaseDate=2016-11-09 11:53:23.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=19, userId=11, amount=4.00, purchaseDate=2016-11-09 11:53:23.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=20, userId=12, amount=4.00, purchaseDate=2016-11-09 11:53:23.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=21, userId=13, amount=4.00, purchaseDate=2016-11-09 11:54:08.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=22, userId=14, amount=4.00, purchaseDate=2016-11-09 11:54:08.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=23, userId=15, amount=4.00, purchaseDate=2016-11-09 11:54:08.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=24, userId=16, amount=4.00, purchaseDate=2016-11-09 11:54:08.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=25, userId=17, amount=4.00, purchaseDate=2016-11-09 11:54:08.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=26, userId=18, amount=4.00, purchaseDate=2016-11-09 11:54:08.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=27, userId=19, amount=4.00, purchaseDate=2016-11-09 11:54:08.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=28, userId=20, amount=4.00, purchaseDate=2016-11-09 11:54:08.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=29, userId=21, amount=4.00, purchaseDate=2016-11-09 11:54:08.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=30, userId=22, amount=4.00, purchaseDate=2016-11-09 11:54:42.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=32, userId=23, amount=4.00, purchaseDate=2016-11-09 11:54:42.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=33, userId=24, amount=4.00, purchaseDate=2016-11-09 11:54:42.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=34, userId=25, amount=4.00, purchaseDate=2016-11-09 11:54:42.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=35, userId=26, amount=4.00, purchaseDate=2016-11-09 11:54:42.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}, 
Order{id=36, userId=27, amount=4.00, purchaseDate=2016-11-09 11:54:42.0, orderStatus=ORDERED, deliveryDate=2016-11-10 18:00:00.0, products=[Product{id=2, name='product', price=4.00, quantity=1}]}]
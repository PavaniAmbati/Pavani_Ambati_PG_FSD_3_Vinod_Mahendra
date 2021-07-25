insert into shoe_brand(brand) values ('Nike');
insert into shoe_brand(brand) values ('Adidas');
insert into shoe_brand(brand) values ('Reebok');

insert into shoe_category(category) values ('Running Shoes');
insert into shoe_category(category) values ('Walking Shoes');
insert into shoe_category(category) values ('Cross Trainers');

insert into shoe_colour(colour) values ('white');
insert into shoe_colour(colour) values ('pink');
insert into shoe_colour(colour) values ('green');

insert into gender(gender) values ('male');
insert into gender(gender) values ('female');

insert into shoe_size(size) values ('5');
insert into shoe_size(size) values ('6');
insert into shoe_size(size) values ('5.5');

insert into adminusers(username,password,enabled,role) values ('admin','password','1','ADMIN');

insert into shoe_inventory(brand,category,colour,gender,price,
shoedescription,shoename,size) values ('Nike','Running Shoes','white','female',
100.00,'Made lighter with a simplified upper, the ride feels as fast as ever','Nike Running Shoes','5');

insert into shoe_inventory(brand,category,colour,gender,price,
shoedescription,shoename,size) values ('Adidas','Walking Shoes','pink','female',
100.00,' our original sneaker is soft, moisture wicking, and ready for anything.','Adidas Walking Shoes','5.5');

insert into shoe_inventory(brand,category,colour,gender,price,
shoedescription,shoename,size) values ('Reebok','Cross Trainers','green','male',
150.00,'Featuring a breathable upper that promotes airflow to help keep you cool','Reebok Cross Trainers','6');



insert into paymenttypes(paymenttype) values ('Visa');
insert into paymenttypes(paymenttype) values ('Master Card');
insert into paymenttypes(paymenttype) values ('American Express');

insert into countrystatelist(city,country,state) values ('Toronto', 'Canada', 'Ontario');
insert into countrystatelist(city,country,state) values ('Edmonton', 'Canada', 'Alberta');
insert into countrystatelist(city,country,state) values ('Winnipeg', 'Canada', 'Manitoba');
insert into countrystatelist(city,country,state) values ('Vancouver', 'Canada', 'BritishColumbia');
insert into countrystatelist(city,country,state) values ('Halifax', 'Canada', 'Novascotia');
insert into countrystatelist(city,country,state) values ('NewYork', 'US', 'NewYork');
insert into countrystatelist(city,country,state) values ('Columbus', 'US', 'Ohio');
insert into countrystatelist(city,country,state) values ('Pittsburg', 'US', 'Pennsylvania');
insert into countrystatelist(city,country,state) values ('Merland', 'US', 'Washington');
insert into countrystatelist(city,country,state) values ('Orlando', 'US', 'Florida');

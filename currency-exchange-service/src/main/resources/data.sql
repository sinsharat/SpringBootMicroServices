drop table if exists exchange_value;
create table exchange_value (
id int not null primary key, 
currency_from varchar(255) not null, 
currency_to varchar(255) not null,
conversion_value numeric(10,4)
);
insert into exchange_value(id, currency_from, currency_to, conversion_value)
values (1000, 'USD', 'INR', 65);
insert into exchange_value(id, currency_from, currency_to, conversion_value)
values (1001, 'EUR', 'INR', 75);
insert into exchange_value(id, currency_from, currency_to, conversion_value)
values (1002,'AUD', 'INR', 25);
insert into exchange_value(id, currency_from, currency_to, conversion_value)
values (1003, 'SID', 'INR', 35);
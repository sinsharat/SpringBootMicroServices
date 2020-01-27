drop table exchange_value;
create table exchange_value(id bigint primary key auto_increment, currency_from varchar(255), currency_to varchar(255), conversion_value decimal(10,4), unique key (currency_from, currency_to));
insert into exchange_value(currency_from, currency_to, conversion_value)
values ('USD', 'INR', 65);
insert into exchange_value(currency_from, currency_to, conversion_value)
values ('EUR', 'INR', 75);
insert into exchange_value(currency_from, currency_to, conversion_value)
values ('AUD', 'INR', 25);
insert into exchange_value(currency_from, currency_to, conversion_value)
values ('SID', 'INR', 35);

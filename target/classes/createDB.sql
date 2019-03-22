create table categories(
  id BIGSERIAL primary key,
  name varchar(20) not null
--   parentCategory int null references categories(id)
);


create table books(
  id bigserial primary key,
  name varchar(30) not null,
  link varchar(150) not null,
  categories_id int references categories(id) not null
);


delete table categor
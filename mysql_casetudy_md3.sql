use casestudy_md3_qltv;

create table books(
idBook int primary key,
nameBook nvarchar(200),
descriptionBook nvarchar(200),
image nvarchar(200),
publishingBook  nvarchar(200),
statusBook int,
CategoryBook int,
locationBook int,
foreign key (statusBook) references statuss(idStatus),
foreign key (CategoryBook) references Category(idCategory),
foreign key (locationBook) references location(idLocation)
);

create table statuss(
idStatus int primary key,
nameStatus nvarchar(10)
);

create table Category(
idCategory int primary key,
nameCategory nvarchar(50)
);

create table location(
idLocation int primary key,
nameLocation nvarchar(50)
);

CREATE TABLE accounts (
  idAccount int(10) NOT NULL AUTO_INCREMENT,
  email varchar(50) DEFAULT NULL,
  pass varchar(50) DEFAULT NULL,
  PRIMARY KEY (idAccount)
);


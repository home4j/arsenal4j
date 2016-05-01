create table product (
	id bigint AUTO_INCREMENT primary key,
    name varchar(80) not null UNIQUE,
    descn varchar(255) null,
    version bigint
);
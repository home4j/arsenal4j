create table product (
	id bigint AUTO_INCREMENT primary key,
    name varchar(80) not null UNIQUE,
    descn varchar(255),
    front varchar(255),
    back varchar(255),
    type int,
    version bigint
);
create table product_ext (
	id bigint AUTO_INCREMENT primary key,
    name varchar(80) not null UNIQUE,
    descn varchar(255),
    front varchar(255),
    back varchar(255),
    type int,
    ext varchar(255),
    version bigint
);
create table trade_order (
	id bigint not null UNIQUE,
    user_id varchar(80) not null UNIQUE,
    descn varchar(255) null,
    version bigint,
    PRIMARY KEY (id, user_id)
);
create table product (
	id bigint AUTO_INCREMENT primary key,
    name varchar(80) not null UNIQUE,
    descn varchar(255) null,
    version bigint
);
create table trade_order (
	id bigint not null UNIQUE,
    user_id varchar(80) not null UNIQUE,
    descn varchar(255) null,
    version bigint,
    PRIMARY KEY (id, user_id)
);
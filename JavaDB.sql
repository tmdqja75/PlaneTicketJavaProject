create table if not exists flight (
	flight_id VARCHAR(20),
    operator VARCHAR(30),
    start_time datetime,
    arrival_time datetime,
    starting_point VARCHAR(40),
    destination VARCHAR(40),
    remnantCount int,
    flight_price int,
    CONSTRAINT PRIMARY KEY(flight_id)
);

create table if not exists product (
	product_number VARCHAR(20),
    flight_id VARCHAR(20),
    agency VARCHAR(30),
    destination VARCHAR(40),
    period date,
    manual VARCHAR(100),
    isHotel boolean, -- 1은 호텔 있음, 0은 없음
    flight_type boolean, -- 1은 해외, 0은 국내
    product_price int,
    CONSTRAINT PRIMARY KEY(product_number),
    CONSTRAINT FOREIGN KEY(flight_id) REFERENCES flight(flight_id)
);

create table if not exists passport (
	num int primary key auto_increment,
	passport_id int,
    user_name VARCHAR(30) NOT NULL,
    birth DATE,
    purchase_num int
);


create table if not exists purchaseInfo (
	num INT NOT NULL auto_increment,
	customer_id VARCHAR(20),
    customer_pwd VARCHAR(20),
    product_number VARCHAR(20),
    ticket_count INT NOT NULL,
    passport_id int,
    isPay boolean,
    CONSTRAINT PRIMARY KEY(num),
    CONSTRAINT FOREIGN KEY(product_number) references product(product_number),
    CONSTRAINT FOREIGN KEY(passport_id) references passport(num)
);


ALTER TABLE passport
ADD constraint foreign key(num) references purchaseInfo(num);
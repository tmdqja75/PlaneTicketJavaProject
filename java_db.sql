-- airline_ticket table

create table if not exists flight (
	flight_id VARCHAR(20) NOT NULL DEFAULT '0',
    airline VARCHAR(30),
    start_time datetime,
    arrival_time datetime,
    starting_point VARCHAR(40),
    destination VARCHAR(40),
    remnantCount int,
    flight_price int,
    CONSTRAINT PRIMARY KEY(flight_id)
);
-- id(정수 + 문자열)의 정수부분 카운터
create table temp_flight( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY );

DROP TRIGGER flight_id_change;
-- id를 정수와 문자열 조합으로 만들어주는 트리거(생성 직전에)
DELIMITER $$
CREATE TRIGGER flight_id_change
BEFORE INSERT ON flight
FOR EACH ROW
BEGIN
	INSERT INTO temp_flight VALUES(NULL);
    SET NEW.flight_id = CONCAT(upper(left(NEW.airline,3)), LPAD(LAST_INSERT_ID(), 4, '0'));
END$$
DELIMITER ;



DROP TRIGGER flight_id_change;
SHOW TRIGGERS;


create table if not exists product (
	product_number int auto_increment, -- autoincrement로 변경
    -- 바뀐 부분
    departflight_id VARCHAR(20), 
    arriveflight_id VARCHAR(20),
    --
    agency VARCHAR(30),
    destination VARCHAR(40),
    period int, -- date 에서 int로 변환
    manual VARCHAR(100),
    isHotel boolean, -- 1은 호텔 있음, 0은 없음
    flight_type boolean, -- 1은 해외, 0은 국내
    product_price int,
    CONSTRAINT PRIMARY KEY(product_number)
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
    product_number int, -- 바뀐 부분 int 로
	ticket_count INT NOT NULL,
    passport_id int,
    isPay boolean,
    CONSTRAINT PRIMARY KEY(num),
    CONSTRAINT FOREIGN KEY(product_number) references product(product_number),
    CONSTRAINT FOREIGN KEY(passport_id) references passport(num)
);


ALTER TABLE passport
ADD constraint foreign key(num) references purchaseInfo(num);
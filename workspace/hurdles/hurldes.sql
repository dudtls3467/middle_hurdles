DROP TABLE member;
DROP TABLE grade;
DROP TABLE follow;
DROP TABLE reservation;
DROP TABLE restaurant;
DROP TABLE menu;
DROP TABLE pick;
DROP TABLE pay;
DROP TABLE waybill;
DROP TABLE product;
DROP TABLE board;
DROP TABLE restaurant_code;
DROP TABLE attribute;
DROP TABLE orders;
DROP TABLE cart;
DROP TABLE board_code;
DROP TABLE review;
DROP TABLE review_attribute;
DROP TABLE reserve_product;
DROP TABLE orders_product;
DROP TABLE coupon;
DROP TABLE member_coupon;
DROP TABLE files;
DROP TABLE local;
DROP TABLE restaurant_file;
DROP TABLE restaurant_qna_file;
DROP TABLE review_file;
DROP TABLE board_file;
DROP TABLE member_profile;
DROP TABLE mileage;
DROP TABLE question;

CREATE TABLE member (
	member_no	number		NOT NULL,
	member_id	varchar2(20)		NULL,
	member_pw	varchar2(50)		NULL,
	create_date	date		DEFAULT SYSDATE NULL,
	remove_date	date		NULL,
	member_role	varchar2(1)		NULL,
	delyn	varchar2(1)		 DEFAULT 'N' NOT NULL
);

COMMENT ON COLUMN member.member_role IS '0 => 관리자
1 => 사장님 & 일반 사용자
2 => 일반 사용자';



CREATE TABLE grade (
	grade_no	number		NOT NULL,
	grade_name	varchar2(10)		NULL,
	grade_level	number		NULL,
	grade_payback	number		NULL
);



CREATE TABLE follow (
	follow_no	number		NOT NULL,
	member_follow_no	number		NOT NULL,
	member_no	number		NOT NULL
);



CREATE TABLE reservation (
	reservation_no	number		NOT NULL,
	reserve_product_no	number		NOT NULL,
	member_no	number		NOT NULL,
	create_date date DEFAULT SYSDATE NULL
);



CREATE TABLE restaurant (
	restaurant_no	number		NOT NULL,
	restaurant_code_no	number		NOT NULL,
	local_no	number		NOT NULL,
	member_no	number		NOT NULL,
	file_no	number		NOT NULL,
	restaurant_name	varchar2(50)		NULL,
	restaurant_des	clob		NULL,
	restaurant_add1	varchar2(100)		NULL,
	restaurant_add2	varchar2(100)		NULL,
	RESTAURANT_X	number	NULL,
	RESTAURANT_Y	number	NULL,
	restaurant_tel	VARCHAR(255)		NULL,
	delyn	varchar2(1)		 DEFAULT 'N' NOT NULL
);

COMMENT ON COLUMN restaurant.member_no IS '사장님 정보 넣기 
(급해서 열로 넣음)';



CREATE TABLE menu (
	menu_no	number		NOT NULL,
	restaurant_no	number		NOT NULL,
	file_no	number		NOT NULL,
	menu_name	varchar2(100)		NULL,
	menu_price	number		NULL,
	menu_des	varchar2(1000)		NULL,
	delyn	varchar2(1)		NULL
);



CREATE TABLE pick (
	member_no	number		NOT NULL,
	restaurant_no	number		NOT NULL
);



CREATE TABLE pay (
	pay_no	number		NOT NULL,
	orders_no	number		NOT NULL,
	create_date	date		DEFAULT SYSDATE NULL,
	remove_date	date		NULL,
	pay_plus	number		NULL,
	pay_minus	number		NULL,
	pay_coupon	number		NULL,
	pay_total_price	number		NULL,
	pay_price	number		NULL
);



CREATE TABLE waybill (
	waybill_no	number		NOT NULL,
	orders_no	number		NOT NULL,
	waybill_status	varchar2(1)		NULL,
	create_date	date		DEFAULT SYSDATE NULL
);

COMMENT ON COLUMN waybill.waybill_status IS '0 => 배달 준비중
1 => 배달 시작
2 => 배달 완료';



CREATE TABLE product (
	product_no	number		NOT NULL,
	restaurant_no	number		NOT NULL,
	file_no	number		NOT NULL,
	product_name	varchar2(100)		NULL,
	product_des	varchar2(1000)		NULL,
	product_price	number		NULL,
	product_yn	varchar2(1)		NULL,
	delyn	varchar2(1)		 DEFAULT 'N' NOT NULL
);

COMMENT ON COLUMN product.product_yn IS '0 => 매진
1 => 사용 가능';



CREATE TABLE board (
	board_no	number		NOT NULL,
	board_title	varchar2(100)		NULL,
	board_content	clob		NULL,
	create_date	date		DEFAULT SYSDATE NULL,
	update_date	date		NULL,
	board_code_no	number		NOT NULL,
	member_no	number		NOT NULL,
	delyn	varchar2(1)		 DEFAULT 'N' NOT NULL
);



CREATE TABLE restaurant_code (
	restaurant_code_no	number		NOT NULL,
	resturant_code_name	varchar2(100)		NULL,
	restaurant_code_no2	number		NOT NULL
);



CREATE TABLE attribute (
	attribute_no	number		NOT NULL,
	attribute_name	varchar2(100)		NULL
);



CREATE TABLE orders (
	orders_no	number		NOT NULL,
	member_no	number		NOT NULL,
	orders_add1	varchar2(100)		NULL,
	orders_add2	varchar2(100)		NULL,
	create_date	date		DEFAULT SYSDATE NULL,
	remove_date	date		NULL
);



CREATE TABLE cart (
	cart_no	number		NOT NULL,
	member_no	number		NOT NULL,
	product_no	number		NOT NULL
);



CREATE TABLE board_code (
	board_code_no	number		NOT NULL,
	board_code_name	varchar2(50)		NULL
);



CREATE TABLE review (
	review_no	number		NOT NULL,
	restaurant_no	number		NOT NULL,
	member_no	number		NOT NULL,
	review_content	clob		NULL,
	review_score	number		NULL,
	create_date	date		DEFAULT SYSDATE NULL,
	delyn	varchar2(1)		 DEFAULT 'N' NOT NULL
);



CREATE TABLE review_attribute (
	attribute_no	number		NOT NULL,
	review_no	number		NOT NULL
);



CREATE TABLE reserve_product (
	reserve_product_no	number		NOT NULL,
	restaurant_no	number		NOT NULL,
	file_no	number		NOT NULL,
	reserve_product_name	varchar2(100)		NULL,
	reserve_product_des	varchar2(1000)		NULL,
	reserve_product_count	number		NULL,
	delyn	varchar2(1)		 DEFAULT 'N' NOT NULL
);



CREATE TABLE orders_product (
	orders_product_no	number		NOT NULL,
	orders_no	number		NOT NULL,
	product_no2	number		NOT NULL,
	orders_product_qty	number		NULL
);



CREATE TABLE coupon (
	coupon_no	number		NOT NULL,
	restaurant_no	number		NOT NULL,
	coupon_name	varchar2(100)		NULL,
	coupon_des	varchar2(500)		NULL,
	coupon_price	number		NULL,
	start_date	date		NULL,
	end_date	date		NULL,
	create_date	date		DEFAULT SYSDATE NULL,
	delyn	varchar2(1)		 DEFAULT 'N' NOT NULL
);



CREATE TABLE member_coupon (
	member_no	number		NOT NULL,
	coupon_no	number		NOT NULL,
	pay_no	number		NOT NULL,
	use_date	date		NULL
);



CREATE TABLE files (
	file_no	number		NOT NULL,
	file_sn	number		NULL,
	file_path	varchar2(200)		NULL,
	file_org_name	varchar2(200)		NULL,
	file_save_name	varchar2(200)		NULL,
	file_ext	varchar2(20)		NULL,
	file_size	number		NULL,
	create_date	date		DEFAULT SYSDATE NULL,
	delyn	varchar2(1)		 DEFAULT 'N' NOT NULL
);



CREATE TABLE local (
	local_no	number		NOT NULL,
	local_name	varchar2(100)		NULL,
	local_no2	number		NOT NULL,
	local_level	number		NULL
);



CREATE TABLE restaurant_file (
	file_no	number		NOT NULL,
	restaurant_no	number		NOT NULL
);



CREATE TABLE restaurant_qna_file (
	file_no	number		NOT NULL,
	question_no	number		NOT NULL
);



CREATE TABLE review_file (
	file_no	number		NOT NULL,
	review_no	number		NOT NULL
);



CREATE TABLE board_file (
	file_no	number		NOT NULL,
	board_no	number		NOT NULL
);



CREATE TABLE member_profile (
	member_no	number		NOT NULL,
	member_name	varchar2(20)		NULL,
	member_bir	date		NULL,
	member_gender	varchar2(1)		NULL,
	member_add1	varchar2(100)		NULL,
	member_add2	varchar2(100)		NULL,
	member_tel	varchar2(13)		NULL,
	member_email	varchar2(100)		NULL,
	member_mileage	number  DEFAULT 0 NULL,
	file_no	number		NOT NULL,
	grade_no	number		NOT NULL
);



CREATE TABLE mileage (
	mileage_no	number		NOT NULL,
	member_no	number		NOT NULL,
	mileage_used	varchar2(1)		NULL,
	create_date	date		DEFAULT SYSDATE NULL,
	mileage_point	number		NULL
);

COMMENT ON COLUMN mileage.mileage_used IS '0 => 사용
1 => 적립';

COMMENT ON COLUMN mileage.create_date IS '곳 적립일이다 생성일이다!';



CREATE TABLE question (
	question_no	number		NOT NULL,
	question_title	varchar2(100)		NULL,
	question_content	clob		NULL,
	create_date	date		DEFAULT SYSDATE NULL,
	update_date	date		NULL,
	question_answer	clob		NULL,
	member_no	number		NOT NULL,
	restaurant_no	number		NOT NULL,
	file_no	number		NOT NULL
);

ALTER TABLE member ADD CONSTRAINT PK_member PRIMARY KEY (
	member_no
);

ALTER TABLE grade ADD CONSTRAINT PK_GRADE PRIMARY KEY (
	grade_no
);

ALTER TABLE follow ADD CONSTRAINT PK_FOLLOW PRIMARY KEY (
	follow_no
);

ALTER TABLE reservation ADD CONSTRAINT PK_RESERVATION PRIMARY KEY (
	reservation_no
);

ALTER TABLE restaurant ADD CONSTRAINT PK_RESTAURANT PRIMARY KEY (
	restaurant_no
);

ALTER TABLE menu ADD CONSTRAINT PK_MENU PRIMARY KEY (
	menu_no
);

ALTER TABLE pick ADD CONSTRAINT PK_PICK PRIMARY KEY (
	member_no,
	restaurant_no
);

ALTER TABLE pay ADD CONSTRAINT PK_PAY PRIMARY KEY (
	pay_no
);

ALTER TABLE waybill ADD CONSTRAINT PK_WAYBILL PRIMARY KEY (
	waybill_no
);

ALTER TABLE product ADD CONSTRAINT PK_PRODUCT PRIMARY KEY (
	product_no
);

ALTER TABLE board ADD CONSTRAINT PK_BOARD PRIMARY KEY (
	board_no
);

ALTER TABLE restaurant_code ADD CONSTRAINT PK_RESTAURANT_CODE PRIMARY KEY (
	restaurant_code_no
);

ALTER TABLE attribute ADD CONSTRAINT PK_ATTRIBUTE PRIMARY KEY (
	attribute_no
);

ALTER TABLE orders ADD CONSTRAINT PK_orders PRIMARY KEY (
	orders_no
);

ALTER TABLE cart ADD CONSTRAINT PK_CART PRIMARY KEY (
	cart_no
);

ALTER TABLE board_code ADD CONSTRAINT PK_BOARD_CODE PRIMARY KEY (
	board_code_no
);

ALTER TABLE review ADD CONSTRAINT PK_REVIEW PRIMARY KEY (
	review_no
);

ALTER TABLE review_attribute ADD CONSTRAINT PK_REVIEW_ATTRIBUTE PRIMARY KEY (
	attribute_no,
	review_no
);

ALTER TABLE reserve_product ADD CONSTRAINT PK_RESERVE_PRODUCT PRIMARY KEY (
	reserve_product_no
);

ALTER TABLE orders_product ADD CONSTRAINT PK_orders_PRODUCT PRIMARY KEY (
	orders_product_no
);

ALTER TABLE coupon ADD CONSTRAINT PK_COUPON PRIMARY KEY (
	coupon_no
);

ALTER TABLE member_coupon ADD CONSTRAINT PK_member_COUPON PRIMARY KEY (
	member_no,
	coupon_no
);

ALTER TABLE files ADD CONSTRAINT PK_FILES PRIMARY KEY (
	file_no
);

ALTER TABLE local ADD CONSTRAINT PK_LOCAL PRIMARY KEY (
	local_no
);

ALTER TABLE restaurant_file ADD CONSTRAINT PK_RESTAURANT_FILE PRIMARY KEY (
	file_no,
	restaurant_no
);

ALTER TABLE restaurant_qna_file ADD CONSTRAINT PK_RESTAURANT_QNA_FILE PRIMARY KEY (
	file_no,
	question_no
);

ALTER TABLE review_file ADD CONSTRAINT PK_REVIEW_FILE PRIMARY KEY (
	file_no,
	review_no
);

ALTER TABLE board_file ADD CONSTRAINT PK_BOARD_FILE PRIMARY KEY (
	file_no,
	board_no
);

ALTER TABLE member_profile ADD CONSTRAINT PK_member_PROFILE PRIMARY KEY (
	member_no
);

ALTER TABLE mileage ADD CONSTRAINT PK_MILEAGE PRIMARY KEY (
	mileage_no
);

ALTER TABLE question ADD CONSTRAINT PK_QUESTION PRIMARY KEY (
	question_no
);

ALTER TABLE pick ADD CONSTRAINT FK_member_TO_pick_1 FOREIGN KEY (
	member_no
)
REFERENCES member (
	member_no
);

ALTER TABLE pick ADD CONSTRAINT FK_restaurant_TO_pick_1 FOREIGN KEY (
	restaurant_no
)
REFERENCES restaurant (
	restaurant_no
);

ALTER TABLE review_attribute ADD CONSTRAINT FK_attribute_TO_review_attribute_1 FOREIGN KEY (
	attribute_no
)
REFERENCES attribute (
	attribute_no
);

ALTER TABLE review_attribute ADD CONSTRAINT FK_review_TO_review_attribute_1 FOREIGN KEY (
	review_no
)
REFERENCES review (
	review_no
);

ALTER TABLE member_coupon ADD CONSTRAINT FK_member_TO_member_coupon FOREIGN KEY (
	member_no
)
REFERENCES member (
	member_no
);

ALTER TABLE member_coupon ADD CONSTRAINT FK_coupon_TO_member_coupon FOREIGN KEY (
	coupon_no
)
REFERENCES coupon (
	coupon_no
);

ALTER TABLE restaurant_file ADD CONSTRAINT FK_files_TO_restaurant_file_1 FOREIGN KEY (
	file_no
)
REFERENCES files (
	file_no
);

ALTER TABLE restaurant_file ADD CONSTRAINT FK_restaurant_TO_restaurant_file_1 FOREIGN KEY (
	restaurant_no
)
REFERENCES restaurant (
	restaurant_no
);

ALTER TABLE restaurant_qna_file ADD CONSTRAINT FK_files_TO_restaurant_qna_file_1 FOREIGN KEY (
	file_no
)
REFERENCES files (
	file_no
);

ALTER TABLE restaurant_qna_file ADD CONSTRAINT FK_question_TO_restaurant_qna_file_1 FOREIGN KEY (
	question_no
)
REFERENCES question (
	question_no
);

ALTER TABLE review_file ADD CONSTRAINT FK_files_TO_review_file_1 FOREIGN KEY (
	file_no
)
REFERENCES files (
	file_no
);

ALTER TABLE review_file ADD CONSTRAINT FK_review_TO_review_file_1 FOREIGN KEY (
	review_no
)
REFERENCES review (
	review_no
);

ALTER TABLE board_file ADD CONSTRAINT FK_files_TO_board_file_1 FOREIGN KEY (
	file_no
)
REFERENCES files (
	file_no
);

ALTER TABLE board_file ADD CONSTRAINT FK_board_TO_board_file_1 FOREIGN KEY (
	board_no
)
REFERENCES board (
	board_no
);

ALTER TABLE member_profile ADD CONSTRAINT FK_member_TO_member_profile_1 FOREIGN KEY (
	member_no
)
REFERENCES member (
	member_no
);




CREATE SEQUENCE member_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE GRADE_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE FOLLOW_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE RESERVATION_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE RESTAURANT_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE MENU_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE PAY_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE WAYBILL_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE PRODUCT_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE BOARD_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE RESTAURANT_CODE_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE ATTRIBUTE_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE ORDERS_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE CART_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE BOARD_CODE_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE REVIEW_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE RESERVE_PRODUCT_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE ORDERS_PRODUCT_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE COUPON_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE FILES_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE LOCAL_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE member_PROFILE_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE MILEAGE_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;
CREATE SEQUENCE QUESTION_SEQ 
    INCREMENT BY 1
    START WITH 1
    NOCACHE;

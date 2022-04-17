
DROP SEQUENCE orderSeq;
DROP TABLE myOrder;
	
CREATE SEQUENCE orderSeq;

CREATE TABLE myOrder(
	orderSeq NUMBER PRIMARY KEY,
	productPrice NUMBER(30) NOT NULL,
	delivery NUMBER(10) NOT NULL,
	amount NUMBER(30) NOT NULL,
	receiveAddress VARCHAR2(200) NOT NULL,
	receiveName VARCHAR2(100) NOT NULL,
	quantity NUMBER(10) NOT NULL,
	productName VARCHAR2(100) NOT NULL,
	orderDate DATE NOT NULL,
	productSeq NUMBER NOT NULL,
	userId VARCHAR2(30) NOT NULL
);

--ALTER TABLE myOrder
--ADD CONSTRAINT BOARD_PRODUCT_FK
--FOREIGN KEY(productSeq)
--REFERENCES PRODUCT (productSeq);

--FORENIGN KEY 에 ON DELETE CASCADE; 쓸까말까 하다 지웠슴미다~
--필요하면 추가하겠슴미다.,.

INSERT INTO myOrder
VALUES(orderSeq.NEXTVAL,3000,3000,6000,'서울시 구로구','앨리스',3,'최고급 호미',SYSDATE,1,'id111');
INSERT INTO myOrder
VALUES(orderSeq.NEXTVAL,2000,3000,5000,'서울시 강남구','홍길동',1,'씨앗 키트',SYSDATE,2,'id222');
INSERT INTO myOrder
VALUES(orderSeq.NEXTVAL,5000,3000,8000,'제주도 서귀포','이순신',5,'최고급 호미',SYSDATE,3,'id333');

SELECT orderSeq,productPrice,delivery,amount,receiveAddress,receiveName,quantity,productName,orderDate,productSeq,userId
FROM myOrder
ORDER BY orderSeq DESC;


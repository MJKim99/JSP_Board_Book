DROP TABLE IF EXISTS book CASCADE;

CREATE TABLE book(
	bk_uid int PRIMARY KEY auto_increment , 
	bk_title varchar(20) NOT NULL , 
	bk_summary text , 
	bk_price int DEFAULT 0 CHECK (bk_price >= 0) , 
	bk_viewcnt int DEFAULT 0 CHECK (bk_viewcnt >= 0) , 
	bk_regdate datetime DEFAULT now() 
);

SELECT bk_uid uid, bk_title title, bk_summary summary, bk_price price, 
bk_viewcnt viewcnt, bk_regdate regdate FROM book ORDER BY bk_uid DESC
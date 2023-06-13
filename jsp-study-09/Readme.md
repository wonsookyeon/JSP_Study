CREATE table employees(
    id varchar2(10) not null,
    pass varchar2(10) not null,
    name varchar2(24),
    lev char(1) default 'A',
    enter date default sysdate,
    gender char(1) default '1',
    phone varchar2(30),
    PRIMARY KEY (id)
    );
    
SELECT * FROM EMPLOYEES;

INSERT into EMPLOYEES(id, pass, name, lev, gender, phone)
values('pinksung', '1234', '성윤정', 'A', '2', '010-2222-2222');

INSERT into EMPLOYEES(id, pass, name, lev, gender, phone)
values('subin', '1234', '전원지', 'B', '1', '010-9999-9999');

INSERT into EMPLOYEES(id, pass, name, lev, gender, phone)
values('admin', '1234', '정운영', 'A', '1', '010-1111-1111');

delete from EMPLOYEES
where name='홍길동';
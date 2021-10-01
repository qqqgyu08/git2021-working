-- MySQL Schema = Database ������ ����
-- ���� Database�� �ϳ��� ���Ϸ� ������

-- ��Ű�� ����
create schema myworkspace;

-- ���� ����â���� ����� ��Ű�� ����
use myworkspace;

create table photo (
	id bigint not null auto_increment, 
	created_time bigint not null, 
	description varchar(255), 
	file_name varchar(255), 
	file_type varchar(255), 
	photo_url BLOB, 
	title varchar(255), 
primary key (id)) engine=InnoDB;

-- �����͸� 1�� �߰�
-- insert into ���̺�(�÷�1, �÷�2...) values(��1, ��2)..
insert into photo(created_time, photo_url, title)
values(1, '...', 'test');



-- ���̺� �����͸� ��ü ��ȸ
-- select �÷���� from ���̺��;
select * from photo; -- ��ü �÷� ����
select id, title from photo; -- Ư�� �÷� ����



-- Ư�� ������ ��ȸ
-- select �÷���� from ���̺�� where ���ǽ�
-- equal ���ǽ�: �÷��� = ��
select * from photo where id = 1; -- map.get(1)
select * from photo where id >= 1;

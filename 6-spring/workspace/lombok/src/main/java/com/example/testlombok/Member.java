package com.example.testlombok;

import lombok.Data;

// �Һ� �÷������� java�ڵ带 ������ �� ��(������ ��)
// �Һ� ������̼ǵ�(@Data)�� �ִ¤� Ŭ����/�������̽�, �ʵ�, �޼������ Ž��
// getter, setter, equals/hashcode, toString �޼��带
// �����ϵǴ� class���Ͽ� �߰�����
@Data
public class Member {
	private int id;
	private String name;

}
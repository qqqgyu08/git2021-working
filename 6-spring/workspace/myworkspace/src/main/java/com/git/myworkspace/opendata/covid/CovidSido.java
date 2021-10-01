package com.git.myworkspace.opendata.covid;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(indexes = @Index(name = "idx_covid_sido_1", columnList = "gubun"))
@IdClass(CovidSidoId.class)
public class CovidSido {

	@Id
	private String stdDay; // �����Ͻ�
	@Id
	private String gubun; // �õ���

	private String defCnt; // Ȯ���� ��
	private String isolIngCnt; // �ݸ���ȯ�ڼ�
	private String overFlowCnt; // �ؿ����� ��
	private String localOccCnt; // �����߻� ��

}

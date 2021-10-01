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
	private String stdDay; // 기준일시
	@Id
	private String gubun; // 시도명

	private String defCnt; // 확진자 수
	private String isolIngCnt; // 격리중환자수
	private String overFlowCnt; // 해외유입 수
	private String localOccCnt; // 지역발생 수

}

package com.git.myworkspace.opendata.covid;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CovidSidoId implements Serializable {
	private static final long serialVersionUID = 1L;

	private String stdDay; // �����Ͻ�
	private String gubun; // �õ���

}

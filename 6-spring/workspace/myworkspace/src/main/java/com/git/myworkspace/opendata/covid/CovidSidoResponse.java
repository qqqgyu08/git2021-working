package com.git.myworkspace.opendata.covid;

import java.util.List;

import lombok.Data;

@Data
public class CovidSidoResponse {
	private Response response;

	@Data
	public class Response {
		private Header header;
		private Body body;
	}

	@Data
	public class Header {
		private String resultCode;
		private String resultMsg;
	}

	@Data
	public class Body {
		private Items items;
	}

	@Data
	public class Items {
		private List<Item> item;
	}

	@Data
	public class Item {
		private String stdDay; // �����Ͻ�
		private String gubun; // �õ���

		private String defCnt; // Ȯ���� ��
		private String isolIngCnt; // �ݸ���ȯ�ڼ�
		private String overFlowCnt; // �ؿ����� ��
		private String localOccCnt; // �����߻� ��
	}

}

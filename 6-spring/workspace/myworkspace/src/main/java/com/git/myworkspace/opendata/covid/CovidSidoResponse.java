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
		private String stdDay; // 기준일시
		private String gubun; // 시도명

		private String defCnt; // 확진자 수
		private String isolIngCnt; // 격리중환자수
		private String overFlowCnt; // 해외유입 수
		private String localOccCnt; // 지역발생 수
	}

}

package com.git.myworkspace.opendata.covid;

import java.util.List;

import lombok.Data;

@Data
public class CovidSidoDailyResponse {
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

		private Integer defCnt; // 확진자 수
		private Integer isolIngCnt; // 격리중환자수
		private Integer overFlowCnt; // 해외유입 수
		private Integer localOccCnt; // 지역발생 수
	}

}

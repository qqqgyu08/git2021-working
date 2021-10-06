package com.git.myworkspace.opendata.air;

import java.util.List;

import lombok.Data;

@Data
public class AirSigunguHourResponse {
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
		// OLAP Cuve 형식으로 데이터
		// 지역, 카테고리, 시간, 값
		private String dataTime;
		private String sidoName;
		private String cityName;

		private Integer pm10Value;
		private Integer pm25Value;

		private String o3Value;
		private String coValue;
		private String no2Value;
		private String so2Value;
	}
}

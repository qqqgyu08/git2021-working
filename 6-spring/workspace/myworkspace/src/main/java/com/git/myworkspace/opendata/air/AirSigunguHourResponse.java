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
		// OLAP Cuve �������� ������
		// ����, ī�װ�, �ð�, ��
		private String dataTime;
		private String sidoName;
		private String cityName;

		private String pm10Value;
		private String pm25Value;

		private String o3Value;
		private String coValue;
		private String no2Value;
		private String so2Value;
	}
}

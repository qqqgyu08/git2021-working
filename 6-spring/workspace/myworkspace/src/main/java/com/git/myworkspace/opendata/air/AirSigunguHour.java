package com.git.myworkspace.opendata.air;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(indexes = @Index(name = "idx_air_sigungu_hour_1", columnList = "sidoName, cityName"))
@IdClass(AirSigunguHourId.class)
public class AirSigunguHour {

	@Id
	private String dataTime;
	@Id
	private String sidoName;
	@Id
	private String cityName;

	// 값
	private Integer pm10Value;
	private Integer pm25Value;
//	private String coValue;
//	private String so2Value;
//	private String o3Value;
//	private String no2Value;
}

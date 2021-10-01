package com.git.myworkspace.opendata.covid;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class CovidService {

	private final String SERVICE_KEY = "x5Y4aL8rNyrtteqOaBLbVESKOE1MX1C8z6bnGSaWuN0%2Fsk8%2B2iy0x6rguYk0ATDXdc6%2Fs17CkAWPPyl4Ylbzng%3D%3D";

	private CovidSidoRepository repo;

	@Autowired
	public CovidService(CovidSidoRepository repo) {
		this.repo = repo;
	}

	@SuppressWarnings("deprecation")
	@Scheduled(fixedRate = 1000 * 60 * 60)
	public void requestCovidSido() throws IOException {
		System.out.println(new Date().toLocaleString());

		StringBuilder builder = new StringBuilder();
		builder.append("http://openapi.data.go.kr");
		builder.append("/openapi");
		builder.append("/service");
		builder.append("/rest");
		builder.append("/Covid19");
		builder.append("/getCovid19SidoInfStateJson");
		builder.append("?serviceKey=" + SERVICE_KEY);

		System.out.println(builder.toString());

		URL url = new URL(builder.toString());

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		byte[] result = con.getInputStream().readAllBytes();

		String data = new String(result, "UTF-8");
		System.out.println(data);

		String json = XML.toJSONObject(data).toString(2);
//		System.out.println(json);

		CovidSidoResponse response = new Gson().fromJson(json, CovidSidoResponse.class);
//		System.out.println(response);

		List<CovidSido> list = new ArrayList<CovidSido>();
		for (CovidSidoResponse.Item item : response.getResponse().getBody().getItems().getItem()) {
			CovidSido record = CovidSido.builder().stdDay(item.getStdDay()).gubun(item.getGubun())
					.defCnt(item.getDefCnt()).isolIngCnt(item.getIsolIngCnt()).overFlowCnt(item.getOverFlowCnt())
					.localOccCnt(item.getLocalOccCnt()).build();
			list.add(record);
		}

		repo.saveAll(list);
	}
}

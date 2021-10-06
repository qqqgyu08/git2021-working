package com.git.myworkspace.opendata.covid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component("covidController")
@RestController
@RequestMapping(value = "/opendata/covid")
public class CovidController {
	private CovidSidoDailyRepository repo;
	private final String cachName = "covid-current";

	@Autowired
	public CovidController(CovidSidoDailyRepository repo) {
		this.repo = repo;
	}

	@Cacheable(value = cachName, key = "'all'")
	@GetMapping(value = "/sido/current")
	public List<CovidSidoDaily> getAirCurrent() {

		return repo.findAll(PageRequest.of(0, 19, Sort.by("gubun").descending())).toList();
	}

	@Cacheable(value = cachName, key = "#gubun")
	@GetMapping(value = "/sido/current/{gubun}")
	public List<CovidSidoDaily> getCovidSidoCurrent(@PathVariable String gubun) {
		Pageable page = PageRequest.of(0, 14, Sort.by("gubun").descending());
		return repo.findByGubun(page, gubun);
	}
}

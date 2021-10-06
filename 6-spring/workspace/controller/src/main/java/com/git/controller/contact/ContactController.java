package com.git.controller.contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	private SortedMap<Long, Contact> contacts = Collections
			.synchronizedSortedMap(new TreeMap<Long, Contact>(Collections.reverseOrder()));

	private AtomicLong maxId = new AtomicLong();

	// 목록조회
	// GET /contacts
	@GetMapping(value = "/contacts")
	public List<Contact> getContacts() {
		return new ArrayList<Contact>(contacts.values());
	}

	// contact 1건 추가
	@PostMapping(value = "/contacts")
	public Contact addContact(@RequestBody Contact contact, HttpServletResponse res) {
		if (contact.getName() == null || contact.getPhone() == null || contact.getName().isEmpty()
				|| contact.getPhone().isEmpty()) {

			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		Long currentId = maxId.incrementAndGet();
		Contact contactItem = Contact.builder().id(currentId).name(contact.getName()).phone(contact.getPhone())
				.email(contact.getEmail()).memo(contact.getMemo()).createdTime(new Date().getTime()).build();

		contacts.put(currentId, contactItem);
		res.setStatus(HttpServletResponse.SC_CREATED);
		return contactItem;
	}

	// 삭제
	@DeleteMapping(value = "/contacts/{id}")
	public boolean removeContact(@PathVariable long id, HttpServletResponse res) {

		// 해당 id의 데이터 1건을 가져옴
		Contact contact = contacts.get(Long.valueOf(id));
		// 해당 id의 데이터가 없으면
		if (contact == null) {
			// res.setStatus(404);
			// NOT FOUND: 해당 경로에 리소스가 없음
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}

		// 삭제 수행
		contacts.remove(Long.valueOf(id));

		return true;
	}

	// 수정
	@PutMapping(value = "/contacts/{id}")
	public Contact modifyContact(@PathVariable long id, @RequestBody Contact contact, HttpServletResponse res) {

		Contact findItem = contacts.get(Long.valueOf(id));

		if (findItem == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		getPlainText(contact.getName());
		getPlainText(contact.getPhone());
		getPlainText(contact.getEmail());
		if ((contact.getName() == null || contact.getName().isEmpty())
				|| (contact.getPhone() == null || contact.getPhone().isEmpty())) {

			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		findItem.setName(contact.getName());
		findItem.setPhone(contact.getPhone());
		findItem.setPhone(contact.getEmail());

		return findItem;
	}

	private String getPlainText(String text) {
		return text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}

}

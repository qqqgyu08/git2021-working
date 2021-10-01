package com.git.myworkspace.contact;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	private ContactRepository repo;

	// 의존성 주입
	@Autowired
	public ContactController(ContactRepository repo) {
		this.repo = repo;
	}

	// 목록조회
	// GET /contacts
	@GetMapping(value = "/contacts")
	public List<Contact> getContacts() throws InterruptedException {
		return repo.findAll();
	}

	@GetMapping("/contacts/paging")
	public Page<Contact> getContactsPaging(int page, int size) {
		return repo.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
	}

	// contact 1건 추가
	@PostMapping(value = "/contacts")
	public Contact addContact(@RequestBody Contact contact, HttpServletResponse res) {
		if (contact.getName() == null || contact.getPhone() == null || contact.getName().isEmpty()
				|| contact.getPhone().isEmpty()) {

			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		Contact contactItem = Contact.builder().name(contact.getName()).phone(contact.getPhone())
				.email(contact.getEmail()).memo(contact.getMemo()).createdTime(new Date().getTime()).build();

		repo.save(contactItem);
		res.setStatus(HttpServletResponse.SC_CREATED);
		return contactItem;
	}

	// 삭제
	@DeleteMapping(value = "/contacts/{id}")
	public boolean removeContact(@PathVariable long id, HttpServletResponse res) {

		// 해당 id의 데이터 1건을 가져옴
		Optional<Contact> contact = repo.findById(id);
		// 해당 id의 데이터가 없으면
		if (contact.isEmpty()) {
			// res.setStatus(404);
			// NOT FOUND: 해당 경로에 리소스가 없음
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}

		// 삭제 수행
		repo.deleteById(id);

		return true;
	}

	// 수정
	@PutMapping(value = "/contacts/{id}")
	public Contact modifyContact(@PathVariable long id, @RequestBody Contact contact, HttpServletResponse res) {

		Optional<Contact> contactItem = repo.findById(id);

		if (contactItem.isEmpty()) {
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

		Contact contactToSave = contactItem.get();

		contactToSave.setName(contact.getName());
		contactToSave.setPhone(contact.getPhone());
		contactToSave.setPhone(contact.getEmail());

		Contact contactSaved = repo.save(contactToSave);

		return contactSaved;
	}

	private String getPlainText(String text) {
		return text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}

}

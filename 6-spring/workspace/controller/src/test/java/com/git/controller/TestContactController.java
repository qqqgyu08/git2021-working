package com.git.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.git.controller.contact.Contact;
import com.git.controller.contact.ContactController;

@SpringBootTest
public class TestContactController {
	@Test
	void addContact() {
		ContactController controller = new ContactController();
		Contact expected = Contact.builder().name("test").phone("010-0000-0000").build();

		controller.addContact(expected, new MockHttpServletResponse());

		List<Contact> contacts = controller.getContacts();
		Contact actual = contacts.get(0);

		assertEquals(1, actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getPhone(), actual.getPhone());
	}

	@Test
	void removeContact() {
		ContactController controller = new ContactController();

		Contact testItem = Contact.builder().name("test").phone("010-0000-0000").build();

		controller.addContact(testItem, new MockHttpServletResponse());

		List<Contact> beforeContacts = controller.getContacts();
		assertEquals(1, beforeContacts.size());

		controller.removeContact(1, new MockHttpServletResponse());

		List<Contact> afterContacts = controller.getContacts();
		assertEquals(0, afterContacts.size());
	}

	@Test
	void modifyContact() {
		ContactController controller = new ContactController();

		Contact testItem = Contact.builder().name("testName").phone("testPhone").build();
		controller.addContact(testItem, new MockHttpServletResponse());

		String expectedResultName = "modify test name";
		String expectedResultPhone = "modify test Phone";
		Contact modifyData = Contact.builder().name(expectedResultName).phone(expectedResultPhone).build();

		HttpServletResponse res = new MockHttpServletResponse();

		controller.modifyContact(1, modifyData, res);

		List<Contact> contacts = controller.getContacts();
		assertEquals(expectedResultName, contacts.get(0).getName());
		assertEquals(expectedResultPhone, contacts.get(0).getPhone());

		Contact resultContactItem = controller.modifyContact(2, modifyData, res);
		assertNull(resultContactItem);
		assertEquals(HttpServletResponse.SC_NOT_FOUND, res.getStatus());

		Contact resultContactItemNull = controller.modifyContact(1, new Contact(), res);
		assertNull(resultContactItemNull);
		assertEquals(HttpServletResponse.SC_BAD_REQUEST, res.getStatus());

		Contact resultContactItemEmpty = controller.modifyContact(1, Contact.builder().name("").phone("").build(), res);
		assertNull(resultContactItemEmpty);
		assertEquals(HttpServletResponse.SC_BAD_REQUEST, res.getStatus());
	}
}

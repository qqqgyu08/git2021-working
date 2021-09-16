import axios from "axios";

interface ContactItemResponse {
  id: number;
  name: string;
  phone: string;
  email: string;
}

interface ContactItemRequest {
  name: string | undefined;
  phone: string | undefined;
}

const contactApi = {
  fetch: () =>
    axios.get<ContactItemResponse[]>(`${process.env.REACT_APP_API_BASE}/contacts`),

  add: (contactItem: ContactItemRequest) =>
    axios.post<ContactItemResponse>(
      `${process.env.REACT_APP_API_BASE}/contacts`,
      contactItem
    ),
  // axios.delete<응답타입>(요청URL);
  // DELETE 요청URL HTTP/1.1
  remove: (id: number) =>
    axios.delete<boolean>(`${process.env.REACT_APP_API_BASE}/contacts/${id}`),

  // axios.PUT<응답타입>(요청URL, 요청객체(JSON바디));
  // PUT 요청URL HTTP/1.1  {...}
  modify: (id: number, contactItem: ContactItemRequest) =>
    axios.put<ContactItemResponse>(
      `${process.env.REACT_APP_API_BASE}/contacts/${id}`,
      contactItem
    ),
};

export default contactApi;

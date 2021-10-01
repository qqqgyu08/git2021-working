import { useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router-dom";
import { AppDispatch, RootState } from "../../store";
import { addContact, ContactItem } from "./ContactSlice";

// interface ContactState {
//   id: number;
//   name?: string;
//   phone?: string;
//   email?: string;
//   memo?: string;
//   createdTime: number;
//   isEdit?: boolean;
// }

const ContactCreate = () => {
  // const [nconttactList, setContactList] = useState<ContactState[]>([]);

  const nameInputRef = useRef<HTMLInputElement>(null);
  const phoneInputRef = useRef<HTMLInputElement>(null);
  const emailInputRef = useRef<HTMLInputElement>(null);
  const memoTxta = useRef<HTMLTextAreaElement>(null);
  const tbRef = useRef<HTMLTableSectionElement>(null);

  const ContactData = useSelector((state: RootState) => state.contact.data);

  const dispatch = useDispatch<AppDispatch>();

  const history = useHistory();

  const handleAddClick = () => {
    const item: ContactItem = {
      id: ContactData.length ? ContactData[0].id + 1 : 1,
      name: nameInputRef.current ? nameInputRef.current.value : "",
      phone: phoneInputRef.current ? phoneInputRef.current.value : "",
      email: emailInputRef.current ? emailInputRef.current.value : "",
      createdTime: new Date().getTime(),
    };

    dispatch(addContact(item));

    history.push("/contacts");
  };

  return (
    <div style={{ width: "40vw" }} className="mx-auto">
      <h2 className="text-center">Contact Create</h2>
      <form>
        <table>
          {/* {nconttactList.map((item) => ( */}
          <tbody ref={tbRef}>
            <tr>
              <th>이름</th>
              <td>
                <input
                  className="form-control"
                  style={{ width: "30vw" }}
                  type="text"
                  // defaultValue={item.name}
                  ref={nameInputRef}
                />
              </td>
            </tr>
            <tr>
              <th>전화번호</th>
              <td>
                <input
                  className="form-control"
                  type="text"
                  // defaultValue={item.phone}
                  ref={phoneInputRef}
                />
              </td>
            </tr>
            <tr>
              <th>이메일</th>
              <td>
                <input
                  className="form-control"
                  type="text"
                  // defaultValue={item.email}
                  ref={emailInputRef}
                />
              </td>
            </tr>
            <tr>
              <th>세부사항</th>
              <td>
                <textarea
                  className="form-control"
                  style={{ height: "30vh" }}
                  // defaultValue={item.memo}
                  ref={memoTxta}
                ></textarea>
              </td>
            </tr>
          </tbody>
          {/* ))} */}
        </table>
      </form>
      <div>
        <button
          className="btn btn-secondary float-start"
          onClick={() => {
            history.push("/contacts");
          }}
        >
          <i className="bi bi-grid-3x3-gap me-1" />
          목록
        </button>
        <button
          className="btn btn-primary float-end"
          onClick={() => {
            handleAddClick();
          }}
        >
          <i className="bi bi-check" />
          저장
        </button>
      </div>
    </div>
  );
};

export default ContactCreate;

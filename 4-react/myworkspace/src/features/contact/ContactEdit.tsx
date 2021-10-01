import { useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useHistory, useParams } from "react-router-dom";
import { AppDispatch, RootState } from "../../store";
import { modifyContact } from "./ContactSlice";

const ContactModify = () => {
  const { id } = useParams<{ id: string }>();

  const ContactItem = useSelector((state: RootState) =>
    state.contact.data.find((item) => item.id === +id)
  );

  const dispatch = useDispatch<AppDispatch>();

  const history = useHistory();

  const nameInputRef = useRef<HTMLInputElement>(null);
  const phoneInputRef = useRef<HTMLInputElement>(null);
  const emailInputRef = useRef<HTMLInputElement>(null);
  const memoTxta = useRef<HTMLTextAreaElement>(null);

  const handleSaveClick = () => {
    // 기존 데이터 카피
    if (ContactItem) {
      const item = { ...ContactItem };
      // 변경할 속성만 대입
      // item.id = ContactItem.id;
      item.name = nameInputRef.current ? nameInputRef.current.value : "";
      item.phone = phoneInputRef.current ? phoneInputRef.current.value : "";
      item.email = emailInputRef.current ? emailInputRef.current.value : "";
      item.memo = memoTxta.current?.value;
      // reducer로 state 수정 및 목록으로 이동
      dispatch(modifyContact(item));
      history.push("/contacts");
    }
  };

  return (
    <div style={{ width: "40vw" }} className="mx-auto">
      <h2 className="text-center">Contact Modify</h2>
      <form>
        <table className="table">
          <tbody>
            <tr>
              <th>이름</th>
              <td>
                <input
                  className="form-control"
                  type="text"
                  defaultValue={ContactItem?.name}
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
                  defaultValue={ContactItem?.phone}
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
                  defaultValue={ContactItem?.email}
                  ref={emailInputRef}
                />
              </td>
            </tr>
            <tr>
              <th>세부사항</th>
              <td>
                <textarea
                  className="form-control"
                  style={{ height: "40vh" }}
                  defaultValue={ContactItem?.memo}
                  ref={memoTxta}
                ></textarea>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
      <div>
        <button
          className="btn btn-secondary me-1 float-start"
          onClick={() => {
            history.push("/contacts");
          }}
        >
          <i className="bi bi-grid-3x3-gap me-1"></i>
          목록
        </button>
        <button
          className="btn btn-primary float-end"
          onClick={() => {
            handleSaveClick();
          }}
        >
          <i className="bi bi-check" />
          저장
        </button>
      </div>
    </div>
  );
};

export default ContactModify;

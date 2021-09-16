import produce from "immer";
import { useEffect, useRef, useState } from "react";
import Alert from "../../components/Alert";

import api from "./contactApi";

interface ContactItemState {
  id: number;
  name: string | undefined;
  phone: string | undefined;
  email: string | undefined;
}

const Contact = () => {
  const [contactList, setContactList] = useState<ContactItemState[]>([]);

  const [isLoading, setLoading] = useState<boolean>(true);

  const [isError, setIsError] = useState(false);
  const [errMessage, setErrMessage] = useState("");

  const nameInputRef = useRef<HTMLInputElement>(null);
  const phoneInputRef = useRef<HTMLInputElement>(null);
  const emailInputRef = useRef<HTMLInputElement>(null);
  const formRef = useRef<HTMLFormElement>(null);
  const tbRef = useRef<HTMLTableElement>(null);

  const fetchData = async () => {
    const res = await api.fetch();

    const contacts = res.data.map((item) => ({
      id: item.id,
      name: item.name,
      phone: item.phone,
      email: item.email,
    })) as ContactItemState[];

    setLoading(false);
    setContactList(contacts);

    console.log("--2. await axios.get completed--");
  };
  useEffect(() => {
    console.log("--1. mounted--");
    // 백엔드에서 데이터를 받아올 것임
    // ES8 style로 async-await 기법을 이용해서 데이터를 조회해옴
    fetchData();
  }, []);

  const add = async (e: React.KeyboardEvent<HTMLInputElement> | null) => {
    // 이벤트 객체가 있을 때는 입력박스에서 엔터 입력
    if (e) {
      if (e.code !== "Enter") return;
    }

    // 입력값이 없으면 에러 메시지 표시
    if (!nameInputRef.current?.value && !phoneInputRef.current?.value) {
      setErrMessage("이름과 연락처를 입력해주세요.");
      setIsError(true);
      return;
    }

    // -------------- 백엔드 연동 부분 ----------------------
    try {
      const result = await api.add({
        name: nameInputRef.current?.value,
        phone: phoneInputRef.current?.value,
      });
      console.log(result);
      // -------------- state 변경부분 ------------------------
      // 서버에서 처리한 데이터로 설정
      const contact: ContactItemState = {
        id: result.data.id,
        name: result.data.name,
        phone: result.data.phone,
        email: result.data.email,
      };

      setContactList(
        produce((state) => {
          state.unshift(contact);
        })
      );
      formRef.current?.reset();
      // 에러 메시지 제거
      setIsError(false);
    } catch (e: any) {
      console.log(e.response);
      // 에러메시지를 표시
      const message = (e as Error).message;
      setIsError(true);
      setErrMessage(message);
    }
  };

  const del = async (id: number, index: number) => {
    console.log(id);

    const result = await api.remove(id);
    console.log(result.status);

    setContactList(
      produce((state) => {
        state.splice(index, 1);
      })
    );
  };

  return (
    <>
      <h2 className="text-center my-4">연락처 관리</h2>
      <form
        className="d-flex"
        ref={formRef}
        onSubmit={(e) => e.preventDefault()}
      >
        <input
          type="text"
          className="form-control me-1"
          placeholder="이름"
          ref={nameInputRef}
        />
        <input
          type="text"
          className="form-control me-1"
          placeholder="전화번호"
          ref={phoneInputRef}
        />
        <input
          type="text"
          className="form-control me-2"
          placeholder="이메일"
          ref={emailInputRef}
        />
        <button
          type="button"
          className="btn btn-outline-primary text-nowrap"
          onClick={() => {
            add(null);
          }}
        >
          추가
        </button>
      </form>
      {isError && (
        <Alert
          message={errMessage}
          variant={"danger"}
          // 닫기 버튼을 클릭할 때 처리하는 함수를 넘김
          onClose={() => {
            setIsError(false);
          }}
        />
      )}

      <table className="table table-striped mt-5" ref={tbRef}>
        <thead>
          <tr>
            <th>#</th>
            <th style={{ width: "20%" }}>이름</th>
            <th style={{ width: "30%" }}>전화번호</th>
            <th style={{ width: "30%" }}>이메일</th>
            <th style={{ width: "10%" }}>작업</th>
          </tr>
        </thead>
        <tbody>
          <tr id="ul-list" className="list-group list-group-flush mt-3">
            {/* 로딩중 처리 표시 */}
            {isLoading && (
              <td className="list-group-item text-center">
                <div className="spinner-border text-primary" role="status">
                  <span className="visually-hidden">Loading...</span>
                </div>
              </td>
            )}
            {/* 빈 데이터 표시 */}
            {!isLoading && contactList.length === 0 && (
              <td className="list-group-item">데이터가 없습니다.</td>
            )}
          </tr>
          {contactList.map((item, index) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.phone}</td>
              <td>{item.email}</td>
              <td>
                <button
                  className="btn btn-outline-secondary btn-sm remove"
                  onClick={() => {
                    del(item.id, index);
                  }}
                >
                  삭제
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
};

export default Contact;

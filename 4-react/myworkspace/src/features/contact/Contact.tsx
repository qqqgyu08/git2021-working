import { useSelector } from "react-redux";
import { useHistory } from "react-router-dom";
import { RootState } from "../../store";

const getTimeString = (unixtime: number) => {
  // Locale: timezone, currency 등
  // js에서는 브라우저의 정보를 이용함
  const day = 24 * 60 * 60 * 1000;
  const dateTime = new Date(unixtime);
  return unixtime - new Date().getTime() >= day
    ? dateTime.toLocaleDateString()
    : dateTime.toLocaleTimeString();
};

const Contact = () => {
  const contact = useSelector((state: RootState) => state.contact);
  const history = useHistory();
  return (
    <div style={{ width: "40vw" }} className="mx-auto">
      <h2 className="text-center">Contact</h2>
      <div className="d-grid gap-2 d-md-flex justify-content-md-end">
        <button
          type="button"
          className="btn btn-outline-primary text-nowrap"
          onClick={() => {
            history.push("/contacts/create");
          }}
        >
          <i className="bi bi-plus" />
          추가
        </button>
      </div>
      {/* 목록화면에는 없어야 되고 추가, 상세보기, 수정화면에만 메모가 보이게 합니다. */}

      <table className="table table-striped mt-5 table-hover">
        <thead>
          <tr>
            <th style={{ width: "5%" }}>#</th>
            <th style={{ width: "15%" }}>이름</th>
            <th style={{ width: "25%" }}>전화번호</th>
            <th style={{ width: "25%" }}>이메일</th>
            <th style={{ width: "20%" }}>작성일시</th>
          </tr>
        </thead>
        <tbody>
          {contact.data.map((item, index) => (
            <tr
              key={item.id}
              onClick={() => {
                history.push(`/contacts/detail/${item.id}`);
              }}
            >
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.phone}</td>
              <td>{item.email}</td>
              <td>
                <span style={{ fontSize: "0.75rem" }}>
                  {getTimeString(item.createdTime)}
                </span>
              </td>
            </tr>
          ))}
        </tbody>
        {!contact.data.length && (
          <tfoot>
            <tr>
              <td colSpan={5}>데이터가 없습니다.</td>
            </tr>
          </tfoot>
        )}
      </table>
    </div>
  );
};

export default Contact;

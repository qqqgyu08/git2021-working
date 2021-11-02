import Layout from "../../components/layout";

const Registration = () => {
  return (
    <Layout>
      <section>
        <h2 className="text-center">가게 등록</h2>
        <form>
          <div className="mb-3">
            <label className="form-label">가게명</label>
            <input type="text" className="form-control" id="placeName" />
          </div>

          <div className="mb-3">
            <label className="form-label">이름</label>
            <input type="text" className="form-control" id="registratant" />
          </div>

          <div className="mb-3">
            <label className="form-label">번호</label>
            <input type="text" className="form-control" id="tel" />
          </div>

          <div className="mb-3">
            <label className="form-label">주소</label>
            <input
              type="text"
              className="form-control"
              id="address"
              aria-describedby="addressHelp"
            />
            <div id="addressHelp" className="form-text">
              주소를 명확히 입력해주세요.
            </div>
          </div>

          <div className="input-group mb-3">
            <label className="form-label">대표 이미지</label>
            <input type="file" className="form-control" id="placeImage" />
          </div>

          <div className="mb-3">
            <label className="form-label">매장 소개글</label>
            <input type="text" className="form-control" id="info" />
          </div>

          <div className="mb-3">
            <label className="form-label">메뉴</label>
            <input
              type="text"
              className="form-control"
              id="menuName"
              aria-describedby="menuName"
            />
            <div id="menuName" className="form-text">
              음식명
            </div>
            <input
              type="text"
              className="form-control"
              id="menuPrice"
              aria-describedby="menuPrice"
            />
            <div id="menuPrice" className="form-text">
              가격
            </div>
            <input
              type="text"
              className="form-control"
              id="menuInfo"
              aria-describedby="menuInfo"
            />
            <div id="menuInfo" className="form-text">
              설명
            </div>
          </div>

          <div className="mb-3">
            <label className="form-label">좌석</label>
            <div className="input-group mb-3">
              <label className="input-group-text">좌석선택</label>
              <select className="form-select">
                <option value="default" disabled style={{ color: "#ccc" }}>
                  좌석을 선택해주세요.
                </option>
                <option value="1">테이블석</option>
                <option value="2">1인석</option>
                <option value="3">단체석</option>
                <option value="4">창가석</option>
              </select>
            </div>
          </div>
        </form>
      </section>
    </Layout>
  );
};

export default Registration;

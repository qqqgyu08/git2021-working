// 프론트엔드 state: UI 처리 바뀌게 하는 변수
// ㄴ> 모달팝업상태(보이고 안보이고), 연락처목록상태(10개보이고, 5개보이고, 수정모드이고) 이런 것들
// 백엔드엔드 state: 비즈니스 로직 처리가 바뀌게 하는 데이터
// ㄴ> 주문상태(주문요청, 결제, 결제확인, 배송중, 배송완료) 이런거
// ㄴ> 승인상태(제출, 검토중, 반려, 승인)

import { configureStore } from "@reduxjs/toolkit";
// import { enableMapSet } from "immer";

import profileReducer from "../features/profile/profileSlice"
import photoReducer from "../features/photo/photoSlice"
import contactReducer from "../features/contact/ContactSlice"
import progressReducer from "../components/progress/progressSlice";
import alertReducer from "../components/alert/alertSlice";

// 최상위 사가
import rootSaga from "../saga";
import createSagaMiddleware from "@redux-saga/core";

// saga middleware 생성
// middleware: 중간에 먼가를 처리하는 소프트웨어
// redux saga는 redux 상태처리 전/후에 먼가를 해주는 라이브러리
const sagaMiddleware = createSagaMiddleware();

// global state(전역 상태) 저장소 만듦
// global state: profile, todo, contact .... 여러개 state가 있음
// ** 이러한 state들은 다른 컴포넌트와 state가 공유 됨
export const store = configureStore({
  // 각 state별로 처리할 reducer 목록
  reducer: {
    // state이름: reducer이름
    // profile state 처리하는 reducer를 등록
    profile: profileReducer,
    // photo state를 처리하는 reducer를 등록
    photo :photoReducer,
    contact: contactReducer,
    progress: progressReducer,
    alert: alertReducer,
  },
  // redux store(dispatcher)에 미들웨어 적용
  // middleware는 여러개 사용할 수 있음, [defaultMiddlware, sagaMiddleware, thunkMiddlware]
  middleware: [sagaMiddleware],
  devTools: true, // 개발툴 사용여부
});

// Redux
/*
 comp -> dispatch(reduxAction) 
   -> dispatcher -> reducer -> store/state
*/

// Redux-Saga
/*
 comp -> dispatch(sagaAction) 
   -> dispatcher -> saga -> api(서버연동) -> put(reduxAction) (추가단계)
     -> dispatcher -> reducer -> store/state
*/

// saga middleware 실행
// rootSaga와 하위에 정의한 감지(take)할 Saga Action들에 대해서 감지 시작
sagaMiddleware.run(rootSaga);


// js는 여기서 끝

// ts일때 더 쳐줘야 하는게 있음
// https://redux-toolkit.js.org/tutorials/quick-start
// 최상위 state

// root state 타입 정의
export type RootState = ReturnType<typeof store.getState>;

// dispatch 타입 정의
export type AppDispatch = typeof store.dispatch;
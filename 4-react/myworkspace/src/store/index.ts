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

// immer객체에 map사용하기
// enableMapSet();

// global state(전역 상태) 저장소 만듦
// global state: profile, todo, contact ... 여러개 state가 있음
// ** 이런 state들은 다른 컴포넌트와 state가 공유 됨
export const store = configureStore({
  // 각 state별로 처리할 reducer 목록
  reducer: {
    // state이름: reducer이름
    // profile state 처리하는 reducer을 등록
    profile: profileReducer, 
    // photo state 처리하는 reducer을 등록
    photo: photoReducer,
    
    contact: contactReducer,
  },
  devTools: true, // 개발툴 사용여부
});
// js는 여기서 끝

// ts일때 더 쳐줘야 하는게 있음
// https://redux-toolkit.js.org/tutorials/quick-start
// 최상위 state

// root state 타입 정의
export type RootState = ReturnType<typeof store.getState>

// dispatch 타입 정의
export type AppDispatch = typeof store.dispatch
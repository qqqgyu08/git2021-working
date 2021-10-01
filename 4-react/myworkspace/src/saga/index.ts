import { fork } from "redux-saga/effects";
import phosoSaga from "../features/photo/photoSaga"
import contactSaga from "../features/contact/contactSaga";


// 최상위의 Saga(generator 함수)를 내보내기함
// 그 하위, phosoSaga, contactSaga , ....
// 기능별 각각의 saga action별로 처리할 saga들을 넣어줌
export default function* rootSaga() {
  yield fork(phosoSaga);
  yield fork(contactSaga);
}
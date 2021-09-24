import contactReducer, {
  addContact,
  initialCompleted,
  initialContact,
  modifyContact,
  removeContact,
} from "../contact/ContactSlice";
import { createAction, nanoid, PayloadAction } from "@reduxjs/toolkit";
import { ContactItem } from "../contact/ContactSlice";
import api, { ContactItemRequest, ContactItemResponse } from "./contactApi";
import { call, put, takeEvery } from "@redux-saga/core/effects";
import { endProgress, startProgress } from "../../components/progress/progressSlice";
import { AxiosResponse } from "axios";
import { addAlert } from "../../components/alert/alertSlice";
import { takeLatest } from "redux-saga/effects";

export const requestAddContact = createAction<ContactItem>(
  `${contactReducer.name}/requestAddContact`
);

export const requestFetchContacts = createAction(
  `${contactReducer.name}/requestFetchContacts`
);

export const requestRemoveContact = createAction<number>(
  `${contactReducer.name}/requestRemoveContact`
);

export const requestModifyContact = createAction<ContactItem>(
  `${contactReducer.name}/requestModifyContact`
);

function* addData(action: PayloadAction<ContactItem>) {
  yield console.log("--addData--");
  yield console.log(action);
  try {
    const contactItemPayload = action.payload;

    const ContactItemRequest: ContactItemRequest = {
      name: contactItemPayload.name,
      phone: contactItemPayload.phone,
      email: contactItemPayload.email,
    };

    // 뺑글이
    yield put(startProgress());

    const result: AxiosResponse<ContactItemResponse> = yield call(
      api.add,
      ContactItemRequest
    );

    // 뺑글이 off
    yield put(endProgress());

    const contactItem: ContactItem = {
      id: result.data.id,
      name: result.data.name,
      phone: result.data.phone,
      email: result.data.email,
      createdTime: result.data.createdTime,
    };

    yield put(addContact(contactItem));

    yield put(initialCompleted());

    yield put(
      addAlert({ id: nanoid(), variant: "success", message: "저장되었습니다." })
    );
  } catch (e: any) {
    yield put(endProgress());

    yield put(
      addAlert({ id: nanoid(), variant: "danger", message: e.message })
    );
  }
}

function* fetchData() {
  yield console.log("--fetchData--");

  yield put(startProgress());

  const result: AxiosResponse<ContactItemResponse[]> = yield call(api.fetch);

  yield put(endProgress());

  const contacts = result.data.map(
    (item) => 
    ({
      id: item.id,
      name : item.name,
      phone: item.phone,
      email: item.email,
      createdTime: item.createdTime,
    } as ContactItem)
  );
  yield put(initialContact(contacts));
}

function* removeData(action: PayloadAction<number>) {
  yield console.log("--removeData--");

  const id = action.payload;

  yield put(startProgress());

  const result: AxiosResponse<boolean> = yield call(api.remove, id);

  yield put(endProgress());

  if (result.data) {
    yield put(removeContact(id));
  }
  yield put(initialCompleted());
}

function* modifyData(action: PayloadAction<ContactItem>) {
  yield console.log("--modifyData--");

  const contactItemPayload = action.payload;

  const contactItemRequest: ContactItemRequest = {
    name: contactItemPayload.name,
    phone: contactItemPayload.phone,
    email: contactItemPayload.email,
  };

  yield put(startProgress());

  const result: AxiosResponse<ContactItemResponse> = yield call(
    api.modify,
    contactItemPayload.id,
    contactItemRequest
  );

  yield put(endProgress());

  const contactItem: ContactItem = {
    id: result.data.id,
    name: result.data.name,
    phone: result.data.phone,
    email: result.data.email,
    createdTime: result.data.createdTime,
  }
  yield put(modifyContact(contactItem));

  yield put(initialCompleted());
}

export default function* contactSaga() {
  yield takeEvery(requestAddContact, addData);
  yield takeLatest(requestFetchContacts, fetchData);
  yield takeEvery(requestRemoveContact, removeData);
  yield takeEvery(requestModifyContact, modifyData);
}
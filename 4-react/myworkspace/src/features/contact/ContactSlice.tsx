import { createSlice, PayloadAction } from "@reduxjs/toolkit";

export interface ContactItem {
  id: number;
  name: string;
  phone: string;
  email: string;
  memo?: string | undefined;
  createdTime: number;
}

interface ContactState {
  data: ContactItem[];
  isFetched: boolean;
  isAddCompleted?: boolean; // 데이터 추가가 완료되었는지 여부
  isRemoveCompleted?: boolean; // 데이터 삭제가 완료되었는지 여부
  isModifyCompleted?: boolean; // 데이터 수정이 완료되었는지 여부
}

const initialState: ContactState = {
  data: [],
  isFetched: false,
};

const ContactSlice = createSlice({
  name: "contact",
  initialState,
  reducers: {
    addContact: (state, action: PayloadAction<ContactItem>) => {
      const contact = action.payload;
      console.log("--in reducer function--");
      console.log(contact);
      state.data.unshift(contact);
    },

    initialCompleted: (state) => {
      delete state.isAddCompleted;
    },

    removeContact: (state, action: PayloadAction<number>) => {
      const id = action.payload;
      // id에 해당하는 아이템의 index를 찾고 그 index로 splice를 한다.
      state.data.splice(
        state.data.findIndex((item) => item.id === id),
        1
      );
    },
    modifyContact: (state, action: PayloadAction<ContactItem>) => {
      // 생성해서 넘긴 객체
      const modifyItem = action.payload;
      // state에 있는 객체
      const ContactItem = state.data.find((item) => item.id === modifyItem.id);
      // state에 있는 객체의 속성을 넘김 객체의 속성으로 변경
      if (ContactItem) {
        ContactItem.name = modifyItem.name;
        ContactItem.phone = modifyItem.phone;
        ContactItem.email = modifyItem.email;
        ContactItem.memo = modifyItem.memo;
      }
      state.isModifyCompleted = true;
    },
    initialContact: (state, action: PayloadAction<ContactItem[]>) => {
      const contacts = action.payload;
      state.data = contacts;
      state.isFetched = true;
    },
  },
});

export const {
  addContact,
  removeContact,
  modifyContact,
  initialContact,
  initialCompleted,
} = ContactSlice.actions;

export default ContactSlice.reducer;

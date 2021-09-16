import { createSlice, PayloadAction } from "@reduxjs/toolkit";

export interface ContactItem {
  id: number;
  name: string;
  phone: string;
  email: string;
  memo?: string | undefined;
  createdTime: number;
  editedTime?: number;
}

interface ContactState {
  data: ContactItem[];
  isFetched: boolean;
}

const initialState: ContactState = {
  data: [
    {
      id: 1,
      name: "SunQ",
      phone: "010-1234-5678",
      email: "sunq@gmail.com",
      memo: "sunq",
      createdTime: new Date().getTime(),
      editedTime: new Date().getTime(),
    },
  ],
  isFetched: false,
};

const ContactSlice = createSlice({
  name: "Contact",
  initialState,
  reducers: {
    addContact: (state, action: PayloadAction<ContactItem>) => {
      const contact = action.payload;
      console.log("--in reducer function--");
      console.log(contact);
      state.data.unshift(contact);
    },
    removeContact: (state, action: PayloadAction<number>) => {
      const id = action.payload;
      // id에 해당하는 아이템의 index를 찾고 그 index로 splice를 한다.
      state.data.splice(
        state.data.findIndex((item) => item.id === id),
        1
      );
    },
    editContact: (state, action: PayloadAction<ContactItem>) => {
      // 생성해서 넘긴 객체
      const editItem = action.payload;
      // state에 있는 객체
      const ContactItem = state.data.find((item) => item.id === editItem.id);
      // state에 있는 객체의 속성을 넘김 객체의 속성으로 변경
      if (ContactItem) {
        ContactItem.name = editItem.name;
        ContactItem.phone = editItem.phone;
        ContactItem.email = editItem.email;
        ContactItem.memo = editItem.memo;
      }
    },
  },
});

export const { addContact, removeContact, editContact } = ContactSlice.actions;

export default ContactSlice.reducer;

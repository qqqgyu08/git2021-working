import React from "react";
import { render, screen } from "@testing-library/react";
import App from "./App";

test("renders learn react link", () => {
  // 컴포넌트를 렌더링함
  render(<App />);
  // 화면에서 특정텍스트 엘리먼트찾음
  // a tag를 가져옴
  const linkElement = screen.getByText(/learn react/i);
  // a tag가 렌더링 화면에 있는지 확인
  expect(linkElement).toBeInTheDocument();
});

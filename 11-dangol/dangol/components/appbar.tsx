import Link from "next/link";

import { Navbar, Container, Nav } from "react-bootstrap";

const AppBar = () => {
  return (
    <Navbar bg="primary" expand="lg">
      <Container className="w-100">
        <Navbar.Brand className="ms-3">
          <Link href="/">
            <span className="text-light">DANGOL</span>
          </Link>
        </Navbar.Brand>
        <div className="d-flex justify-content-end me-3">
          {/* <a className="text-light" href="/list">
            ABOUT
          </a> */}
          <Nav className="me-auto">
            {/* <Nav.Link>
              <Link href="/">HOME</Link>
            </Nav.Link> */}
            {/* next/link안에 a태그를 주어서 스타일 먹인다 */}
            {/* 변환된 태그 <a class="text-light" href="/"></a> */}
            <Nav.Link>
              <Link href="/list">
                <span className="text-light">MANAGE</span>
              </Link>
            </Nav.Link>
            {/* <Nav.Link>
              <Link href="/todo">
                <span className="text-light">TODO</span>
              </Link>
            </Nav.Link>
            <Nav.Link>
              <Link href="/photos">
                <span className="text-light">PHOTO</span>
              </Link>
            </Nav.Link> */}
          </Nav>
        </div>
      </Container>
    </Navbar>
  );
};

export default AppBar;

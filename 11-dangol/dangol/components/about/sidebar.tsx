import Link from "next/link";
import styles from "./sidebar.module.css";

export default function Sidebar() {
  return (
    <nav className={styles.nav}>
      {/* <input className={styles.input} placeholder="Search..." /> */}
      <Link href="/list">
        <a>오늘예약</a>
      </Link>
      <Link href="/list/reservated">
        <a>예약현황</a>
      </Link>
      <Link href="/list/review">
        <a>후기</a>
      </Link>
    </nav>
  );
}

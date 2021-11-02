import type { NextPage } from "next";
import Layout from "../components/layout";
import { useRouter } from "next/router";
import Head from "next/head";
import Link from "next/link";

import styles from "../styles/Home.module.css";

const Home: NextPage = () => {
  return (
    <Layout>
      <div className={styles.container}>
        <Head>
          <title>DANGOL</title>
          <meta name="description" content="dangol" />
        </Head>

        <div className="mx-auto">
          <header className="app-bar position-fixed d-flex justify-content-end bg-primary shadow"></header>

          <main className="content-container">
            {/* Suspense 컴포넌트로 로딩중에 보여줄 화면을 처리하는 것 */}
            {/* fallback={로딩중에 보여줄 컴포넌트} */}
            {/* <Suspense fallback={<div>Loading...</div>}>
            </Suspense> */}
          </main>
        </div>
        <div className="d-grid gap-2 col-6 mx-auto">
          <Link href="/registration">
            <button className="btn btn-primary">가게 등록</button>
          </Link>
          <Link href="/list">
            <button className="btn btn-primary">가게 관리</button>
          </Link>
        </div>
      </div>
    </Layout>
  );
};

export default Home;

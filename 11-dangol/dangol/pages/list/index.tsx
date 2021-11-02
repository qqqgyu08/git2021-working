import Layout from "../../components/layout";
import Sidebar from "../../components/about/sidebar";

export default function List() {
  return (
    <Layout>
      <article className="d-flex">
        <Sidebar />
        <section>오늘예약</section>
      </article>
    </Layout>
  );
}

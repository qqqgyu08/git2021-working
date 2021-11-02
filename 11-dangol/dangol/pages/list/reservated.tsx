import Layout from "../../components/layout";
import Sidebar from "../../components/about/sidebar";

export default function Reservated() {
  return (
    <Layout>
      <article className="d-flex">
        <Sidebar />
        <section>
          <p>예약현황</p>
        </section>
      </article>
    </Layout>
  );
}

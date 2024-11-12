import { useEffect, useState } from "react";
import { Page } from "../../components/page";

import { findManyContacts } from "../../models/contact";
import { ContactEntity } from "../../infra/database";

import styles from "./styles.module.css";

export function About() {
  const [contacts, setContacts] = useState<ContactEntity[]>([]);

  useEffect(() => {
    setContacts(findManyContacts());
  }, []);

  return (
    <Page>
      <header className={styles.headerContainer}>
        <h1>Página Sobre</h1>
        <p>
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Iste rerum
          fugiat quidem quam nostrum placeat, dolorem amet asperiores aperiam
          pariatur assumenda sequi veritatis perspiciatis explicabo porro totam
          repellat ducimus minima.
        </p>
      </header>
      <main>
        <section className={styles.section1}>
          <h2>Pessoas que passaram por aqui</h2>
          <table className={styles.contactsTable}>
            <thead>
              <tr>
                <th>#</th>
                <th>Nome</th>
                <th>E-mail</th>
              </tr>
            </thead>
            <tbody>
              {contacts.map((contact, index) => {
                return (
                  <tr>
                    <td>{index + 1}</td>
                    <td>{contact.name}</td>
                    <td>{contact.email}</td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </section>
      </main>
    </Page>
  );
}

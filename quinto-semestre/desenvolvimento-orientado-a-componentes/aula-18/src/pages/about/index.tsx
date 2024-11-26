import { useEffect, useState } from "react";
import { Page } from "../../components/page";

import { findManyContacts } from "../../models/contact";
import { ContactEntity } from "../../infra/database";

import styles from "./styles.module.css";
import { MessageList } from "../../components/message-list";

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
      <main className={styles.mainContainer}>
        <h2>Mensagens deixadas por aqui</h2>
        <MessageList contacts={contacts} />
      </main>
    </Page>
  );
}

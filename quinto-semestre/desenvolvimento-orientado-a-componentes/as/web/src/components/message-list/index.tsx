import { ContactEntity } from "../../infra/database";
import styles from "./styles.module.css";

type MessageListProps = {
  contacts: ContactEntity[];
};

export function MessageList({ contacts }: MessageListProps) {
  return (
    <dl className={styles.dlContainer}>
      {contacts.map((contact) => {
        return (
          <>
            <dt>{contact.name}</dt>
            <dd>{contact.message}</dd>
          </>
        );
      })}
    </dl>
  );
}

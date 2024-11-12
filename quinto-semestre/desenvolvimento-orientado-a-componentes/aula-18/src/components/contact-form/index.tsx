import { ChangeEvent, FormEvent, useState } from "react";
import styles from "./styles.module.css";
import { saveContact } from "../../models/contact";
import { ContactEntity } from "../../infra/database";

export function ContactForm() {
  const [contact, setContact] = useState<ContactEntity>({
    name: "",
    email: "",
    message: "",
  });

  function handleSubmitContact(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();

    if (contact === null) return;

    saveContact(contact);
    setContact({ name: "", email: "", message: "" });
  }

  function handleNewNameValue(event: ChangeEvent<HTMLInputElement>) {
    setContact((currentState) => {
      return { ...currentState, name: event.target.value };
    });
  }

  function handleNewEmailValue(event: ChangeEvent<HTMLInputElement>) {
    setContact((currentState) => {
      return { ...currentState, email: event.target.value };
    });
  }

  function handleNewMessageValue(event: ChangeEvent<HTMLTextAreaElement>) {
    setContact((currentState) => {
      return { ...currentState, message: event.target.value };
    });
  }

  return (
    <form onSubmit={handleSubmitContact} className={styles.formContainer}>
      <div className={styles.formGroup}>
        <label htmlFor="name">Nome:</label>
        <input
          type="text"
          id="name"
          placeholder="Dígite o nome completo"
          value={contact.name}
          onChange={handleNewNameValue}
          required
        />
      </div>
      <div className={styles.formGroup}>
        <label htmlFor="email">E-mail:</label>
        <input
          type="text"
          id="email"
          placeholder="Digíte seu e-mail"
          value={contact.email}
          onChange={handleNewEmailValue}
          required
        />
      </div>
      <div className={styles.formGroup}>
        <label htmlFor="message">Mensagem:</label>
        <textarea
          id="message"
          placeholder="Escreva sua mensagem aqui"
          rows={6}
          value={contact.message}
          onChange={handleNewMessageValue}
          required
        ></textarea>
      </div>
      <div className={styles.submitButton}>
        <button type="submit">Enviar</button>
      </div>
    </form>
  );
}

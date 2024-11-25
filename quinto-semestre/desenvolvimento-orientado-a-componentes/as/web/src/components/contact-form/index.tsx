import { ChangeEvent, FormEvent, useState } from "react";
import styles from "./styles.module.css";

export function ContactForm() {
  function handleSubmitContact(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
  }

  function handleNewNameValue(event: ChangeEvent<HTMLInputElement>) {}

  function handleNewEmailValue(event: ChangeEvent<HTMLInputElement>) {}

  function handleNewMessageValue(event: ChangeEvent<HTMLTextAreaElement>) {}

  return (
    <form onSubmit={handleSubmitContact} className={styles.formContainer}>
      <div className={styles.formGroup}>
        <label htmlFor="name">Nome:</label>
        <input
          type="text"
          id="name"
          placeholder="Dígite o nome completo"
          value=""
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
          value=""
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
          value=""
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

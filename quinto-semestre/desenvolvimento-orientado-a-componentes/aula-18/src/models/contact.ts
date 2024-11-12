import { ContactEntity, database } from "../infra/database";

export function saveContact(contact: ContactEntity) {
  database.contact.push(contact);
}

export function findManyContacts(): ContactEntity[] {
  return database.contact;
}

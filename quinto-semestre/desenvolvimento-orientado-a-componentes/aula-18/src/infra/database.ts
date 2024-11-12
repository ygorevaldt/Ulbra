export type ContactEntity = {
  name: string;
  email: string;
  message: string;
};

type LocalDatabase = {
  contact: ContactEntity[];
};

export const database: LocalDatabase = {
  contact: [],
};

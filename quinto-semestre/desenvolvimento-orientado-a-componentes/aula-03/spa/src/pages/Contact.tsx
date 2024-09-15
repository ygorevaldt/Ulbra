import { z } from "zod";

import { Header } from "../components/Header";
import { Page } from "../components/Page";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { useState } from "react";
import { useStoredContacts } from "../hooks/use-get-stored-contacts";

const newContactSchema = z.object({
    name: z.string()
        .min(3, "Informe seu nome"),
    email: z.coerce.string()
        .email("E-mail inválido"),
    phone: z.string()
        .min(1, "Telefone é obrigatório")
        .max(11, "Telefone deve ter no máximo 11 caracteres")
});

export function Contact() {
    type ContactForm = z.infer<typeof newContactSchema>;

    const [contacts, setContacts] = useState<ContactForm[]>([]);

    useStoredContacts(setContacts);

    const { register, handleSubmit, formState, reset } = useForm<ContactForm>({
        resolver: zodResolver(newContactSchema)
    });

    function handleSubmitContact(data: ContactForm) {
        setContacts((currentState) => {
            return [...currentState, data];
        });
        saveContactsToLocalStorage([...contacts, data]);
        reset();
    }

    function saveContactsToLocalStorage(contacts: ContactForm[]) {
        localStorage.setItem("contacts", JSON.stringify(contacts));
    }

    return (
        <Page>
            <Header>
                <h1>Contato</h1>
            </Header>
            <main className="flex flex-col gap-6">
                <form onSubmit={handleSubmit(handleSubmitContact)} className="flex flex-col gap-4">
                    <div className="flex items-center flex-wrap gap-4">
                        <div className="flex flex-col gap-1">
                            <label htmlFor="name">Nome:</label>
                            <input
                                type="text"
                                id="name"
                                placeholder="Digíte seu nome"
                                className="input w-full"
                                {...register("name")}
                            />
                            {formState.errors.name && (
                                <p className="text-xs text-pink-500">{formState.errors.name.message}</p>
                            )}
                        </div>
                        <div className="flex flex-col gap-1">
                            <label htmlFor="email">E-mail:</label>
                            <input
                                type="email"
                                id="email"
                                placeholder="Digíte seu e-mail"
                                className="input"
                                {...register("email")}

                            />
                            {formState.errors.email && (
                                <p className="text-xs text-pink-500">{formState.errors.email.message}</p>
                            )}
                        </div>
                        <div className="flex flex-col gap-1">
                            <label htmlFor="phone">Telefone:</label>
                            <input
                                type="text"
                                id="phone"
                                placeholder="Digíte seu telefone"
                                className="input"
                                {...register("phone")}
                            />
                            {formState.errors.phone && (
                                <p className="text-xs text-pink-500">{formState.errors.phone.message}</p>
                            )}
                        </div>
                    </div>
                    <div>
                        <button type="submit" className="btn">
                            Enviar
                        </button>
                    </div>
                </form>
                {contacts[0] && (
                    <table className="border-collapse border border-slate-500">
                        <thead className="bg-zinc-700">
                            <tr>
                                <th className="tableRow text-start">Nome</th>
                                <th className="tableRow text-start">E-mail</th>
                                <th className="tableRow text-start">Telefone</th>
                            </tr>
                        </thead>
                        <tbody>
                            {contacts.map(contact => {
                                return (
                                    <tr>
                                        <td className="tableRow">{contact?.name}</td>
                                        <td className="tableRow">{contact?.email}</td>
                                        <td className="tableRow">{contact?.phone}</td>
                                    </tr>
                                );
                            })}
                        </tbody>
                    </table>
                )}
            </main>
        </Page>
    );
}
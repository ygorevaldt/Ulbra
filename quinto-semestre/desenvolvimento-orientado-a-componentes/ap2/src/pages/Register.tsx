import { z } from "zod";

import { Header } from "../components/Header";
import { Page } from "../components/Page";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { useState } from "react";
import { useStoredParticipants } from "../hooks/use-get-stored-contacts";

const newParticipantSchema = z.object({
    name: z.string()
        .min(3, "Informe seu nome"),
    phone: z.string().optional(),
    guest: z.boolean().default(true),
    paid: z.boolean().default(true),
    imgUrl: z.string()
        .min(1, "Informe a URL da imagem de perfil")
});

export function Register() {
    type RegisterForm = z.infer<typeof newParticipantSchema>;

    const [participants, setParticipants] = useState<RegisterForm[]>([]);

    useStoredParticipants(setParticipants);

    const { register, handleSubmit, formState, reset } = useForm<RegisterForm>({
        resolver: zodResolver(newParticipantSchema)
    });

    function handleSubmitParticipant(data: RegisterForm) {
        setParticipants((currentState) => {
            return [...currentState, data];
        });
        saveParticipantsToLocalStorage([...participants, data]);
        reset();
    }

    function saveParticipantsToLocalStorage(participants: RegisterForm[]) {
        localStorage.setItem("participants", JSON.stringify(participants));
    }

    return (
        <Page>
            <Header>
                <h1>Contato</h1>
            </Header>
            <main className="flex flex-col gap-6">
                <form onSubmit={handleSubmit(handleSubmitParticipant)} className="flex flex-col gap-4">
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
                                <p className="text-xs text-purple-500">{formState.errors.name.message}</p>
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
                                <p className="text-xs text-purple-500">{formState.errors.phone.message}</p>
                            )}
                        </div>
                        <div className="flex flex-col gap-1">
                            <label htmlFor="imgUrl">Imagem de perfil:</label>
                            <input
                                type="text"
                                id="imgUrl"
                                placeholder="Url da imagem"
                                className="input"
                                {...register("imgUrl")}
                            />
                            {formState.errors.imgUrl && (
                                <p className="text-xs text-purple-500">{formState.errors.imgUrl.message}</p>
                            )}
                        </div>
                    </div>
                    <div>
                        <button type="submit" className="btn">
                            Enviar
                        </button>
                    </div>
                </form>
            </main>
        </Page>
    );
}
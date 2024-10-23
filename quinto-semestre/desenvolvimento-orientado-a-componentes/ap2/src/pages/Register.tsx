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
    guest: z.coerce.boolean(),
    paid: z.coerce.boolean(),
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
        console.log("data", data);
        setParticipants((currentState) => {
            return [...currentState, data];
        });
        saveParticipantsToLocalStorage([...participants, data]);
        reset();
    }

    function saveParticipantsToLocalStorage(participants: RegisterForm[]) {
        localStorage.setItem("participants", JSON.stringify(participants));
    }

    function forceTypeBoolean(value: string | null | boolean): boolean | null {
        console.log(value);
        return typeof value === "boolean" ? value : value === "true" ? true : value === "false" ? false : null;
    }

    return (
        <Page>
            <Header>
                <h1>Contato</h1>
            </Header>
            <main className="flex flex-col gap-6">
                <form onSubmit={handleSubmit(handleSubmitParticipant)} className="flex flex-col gap-4">
                    <div className="flex flex-col items-start flex-wrap gap-4">
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
                        <div className="flex items-center flex-wrap gap-4">
                            <div className="flex flex-col gap-1">
                                <label>Convidado:</label>
                                <div className="flex gap-2">
                                    <label>
                                        <input
                                            type="radio"
                                            value="true"
                                            {...register("guest", { setValueAs: forceTypeBoolean })}
                                        />
                                        Sim
                                    </label>
                                    <label>
                                        <input
                                            type="radio"
                                            value="false"
                                            {...register("guest", { setValueAs: forceTypeBoolean })}
                                        />
                                        Não
                                    </label>
                                </div>
                            </div>
                            <div className="flex flex-col gap-1">
                                <label>Pago:</label>
                                <div className="flex gap-2">
                                    <label>
                                        <input
                                            type="radio"
                                            value="true"
                                            {...register("paid", { setValueAs: forceTypeBoolean })}
                                        />
                                        Sim
                                    </label>
                                    <label>
                                        <input
                                            type="radio"
                                            value="false"
                                            {...register("paid", { setValueAs: forceTypeBoolean })}
                                        />
                                        Não
                                    </label>
                                </div>
                            </div>
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
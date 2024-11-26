import { z } from "zod";

import { Page } from "../components/Page";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { useState } from "react";
import { useStoredParticipants } from "../hooks/use-get-stored-contacts";

const newParticipantSchema = z.object({
    name: z.string()
        .min(3, "Informe seu nome"),
    phone: z.string().optional(),
    guest: z
        .string({ invalid_type_error: "Escolha obrigatória" })
        .refine(val => val === "true" || val === "false",)
        .transform(val => val === "true"),
    paid: z
        .string({ invalid_type_error: "Escolha obrigatória" })
        .refine(val => val === "true" || val === "false")
        .transform(val => val === "true"),
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

    return (
        <Page title="Contato">
            <main className="flex flex-col gap-6">
                <form onSubmit={handleSubmit(handleSubmitParticipant)} className="flex flex-col gap-4">
                    <div className="flex flex-col items-start flex-wrap gap-4">
                        <div className="flex items-start flex-wrap gap-4">
                            <div className="flex flex-col gap-1">
                                <label htmlFor="name">Nome:</label>
                                <input
                                    type="text"
                                    id="name"
                                    placeholder="Digíte seu nome"
                                    className="input w-full"
                                    {...register("name")}
                                />
                                <span>
                                    {formState.errors.name && (
                                        <p className="text-xs text-purple-500">{formState.errors.name.message}</p>
                                    )}
                                </span>
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
                                <span>
                                    {formState.errors.imgUrl && (
                                        <p className="text-xs text-purple-500">{formState.errors.imgUrl.message}</p>
                                    )}
                                </span>
                            </div>
                        </div>
                        <div className="flex items-start flex-wrap gap-4">
                            <div className="flex flex-col gap-1">
                                <label>Convidado:</label>
                                <div className="flex gap-2">
                                    <label>
                                        <input
                                            type="radio"
                                            value="true"
                                            {...register("guest")}
                                        />
                                        Sim
                                    </label>
                                    <label>
                                        <input
                                            type="radio"
                                            value="false"
                                            {...register("guest")}
                                        />
                                        Não
                                    </label>

                                </div>
                                {formState.errors.guest && (
                                    <p className="text-xs text-purple-500">{formState.errors.guest.message}</p>
                                )}
                            </div>
                            <div className="flex flex-col gap-1">
                                <label>Pago:</label>
                                <div className="flex gap-2">
                                    <label>
                                        <input
                                            type="radio"
                                            value="true"
                                            {...register("paid")}
                                        />
                                        Sim
                                    </label>
                                    <label>
                                        <input
                                            type="radio"
                                            value="false"
                                            {...register("paid")}
                                        />
                                        Não
                                    </label>
                                </div>
                                {formState.errors.paid && (
                                    <p className="text-xs text-purple-500">{formState.errors.paid.message}</p>
                                )}
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
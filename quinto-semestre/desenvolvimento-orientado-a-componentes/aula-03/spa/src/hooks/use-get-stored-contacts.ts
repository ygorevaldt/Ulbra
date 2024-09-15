import { useEffect } from "react";

export function useStoredContacts(callback: (value: React.SetStateAction<{
    name: string;
    email: string;
    phone: string;
}[]>) => void) {
    useEffect(() => {
        const storedContacts = localStorage.getItem("contacts");
        if (!storedContacts) return;

        callback(JSON.parse(storedContacts));
    }, []);
}
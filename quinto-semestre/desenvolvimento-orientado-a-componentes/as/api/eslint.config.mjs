import globals from "globals";
import tseslint from "typescript-eslint";

export default [
  {
    files: ["**/*.{js,mjs,cjs,ts}"],
    languageOptions: { globals: globals.browser },
    rules: {
      semi: ["error", "always"], // Erro quando não terminar com ponto e vírgula
      quotes: ["error", "double"], // Utilizar aspas duplas
      indent: ["error", 2], // Utilizar tabulação para indentação
    },
  },
  ...tseslint.configs.recommended,
];

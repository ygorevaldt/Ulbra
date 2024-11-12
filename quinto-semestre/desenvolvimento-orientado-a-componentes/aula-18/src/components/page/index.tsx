import { ReactNode } from "react";

import styles from "./styles.module.css";

type PageProps = {
  children: ReactNode;
  className?: String;
};

export function Page({ children, className }: PageProps) {
  return (
    <div
      className={`
        ${styles.pageContainer} ${className}  
      `}
    >
      {children}
    </div>
  );
}

import { Outlet } from "react-router-dom";

export function AdminLayout() {
  return (
    <div>
      <header className="bg-white text-black p-4">
        <h1>PAINEL ADMIN</h1>
      </header>
      <div className="p-4">
        <Outlet />
      </div>
    </div>
  );
}

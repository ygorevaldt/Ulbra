import { Route, Routes } from "react-router-dom";
import { Layout } from "./layouts/Layout";
import { Home } from "./pages/Home";
import { Register } from "./pages/Register";
import { AdminLayout } from "./layouts/AdminLayout";

export function Router() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Register />} />
      </Route>
      <Route path="/admin" element={<AdminLayout />}>
        <Route path="/admin" element={<h1>Painel administrativo home</h1>} />
        <Route
          path="/admin/contato"
          element={<h1>Painel administrativo contato</h1>}
        />
      </Route>
    </Routes>
  );
}

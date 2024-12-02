import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Home } from "./pages/home";
import { Products } from "./pages/products";
import { Default } from "./layouts/default";
import { ProductsRegister } from "./pages/products-register";
import { ProductsEdit } from "./pages/products-edit";

export function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Default />}>
          <Route index element={<Home />} />
          <Route path="/products" element={<Products />} />
          <Route path="/products/register" element={<ProductsRegister />} />
          <Route path="/products/edit" element={<ProductsEdit />} />
          <Route path="*" element={<h1>404</h1>}></Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

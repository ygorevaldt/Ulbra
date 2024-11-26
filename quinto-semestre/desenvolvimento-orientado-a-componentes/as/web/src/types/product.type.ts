export type ProductType = {
  id: string;
  name: string;
  price: number;
  description?: string;
  image: string;
  created_at: string;
  deleted_at?: string;
  session_id: string;
};
